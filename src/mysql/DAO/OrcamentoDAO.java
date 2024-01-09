package mysql.DAO;

import com.squareup.okhttp.*;
import java.io.*;
import java.util.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import mysql.DTO.CCliente;
import mysql.DAO.CclienteDAO;
import mysql.DAO.OrcamentoDAO;
import mysql.DTO.ProdutoDTO;


/**
 *
 * @author 202202208353
 */
public class OrcamentoDAO {
    
    public void gerarPdf(List lista_materiais, CCliente cliente, Double total){
                
        StringBuilder markdownString = new StringBuilder();
        
        markdownString.append("""
        markdown=# VP Portões - Orçamento

        Documentação de orçamento para a construção de portões artesanais. 

        ### Orçamento solicitado por

        - Nome: """+" "+cliente.getNome().toString()+"""

        - Telefone: """+" "+cliente.getTelefone().toString()+"""

        - Endereco: """+" "+cliente.getEndereco().toString()+"""      


        ## Lista de Materiais
        | Material | Quantidade | Preço Unitário |
        | ------ | ------ | ------ |
        """);
         
        List<String> materiais_distintos = (List<String>) lista_materiais.stream().distinct().collect(Collectors.toList());

        for(int j = 0; j < materiais_distintos.size(); j++){
            int count = Collections.frequency(lista_materiais, materiais_distintos.get(j));

            ProdutoDAO daoProd = new ProdutoDAO();
            ProdutoDTO p = new ProdutoDTO();
            p = daoProd.listarProduto(materiais_distintos.get(j));
            
            markdownString.append("""
            | %s | %d | R$%.2f |
            """.formatted(materiais_distintos.get(j), count, p.getValor_unit()));
        }
        
        //Double valor_com_mao_de_obra = total + ((20/100)*total);
        
        markdownString.append("""

                ## Tabela de Orçamento
                | Item | Preço |
                | ------ | ------ |
                | Valor dos materiais | R$%.2f |
                | Valor total com mão de obra | R$%.2f |
                
                ##### Informações de contato - VP Portões
                - Rua Doutor Antônio Cândido, 26
                - Ponto de referência: "Arena Shangai"
                - @vp.portoes
                - +19 98889-8520
                """.formatted(total, (total*=2)));
          
        OkHttpClient client = new OkHttpClient();
          MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
          RequestBody body = RequestBody.create(mediaType, markdownString.toString());
          Request request = new Request.Builder()
            .url("https://md-to-pdf.fly.dev")
            .method("POST", body)
            .addHeader("Content-Type", "application/x-www-form-urlencoded")
            .build();
          //Response response = client.newCall(request).execute();
          
        try {
            Response response = client.newCall(request).execute();
            
            byte[] bytes = response.body().bytes();
            DataOutputStream os = new DataOutputStream(new FileOutputStream("C:\\Users\\User\\Desktop\\trab-kesede\\a.pdf"));
            os.write(bytes);
            os.close();
            
            Logger logger;
            logger = Logger.getLogger(OrcamentoDAO.class.getName());
            
            logger.info(response.body().string());
                       
        } catch (IOException ex) {
            Logger.getLogger(OrcamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void infoBox(String infoMessage, String titleBar){
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
    
}