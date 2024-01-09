package mysql.DAO;

import mysql.DTO.ProdutoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import mysql.DTO.CCliente;
import trabalho.ConnectionFactory;

public class ProdutoDAO {
    
    
    public void InserirProduto(ProdutoDTO produto){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        String nome, produto_cod;
        Double valor_unit;
        nome = produto.getNome();
        valor_unit = produto.getValor_unit();
        produto_cod = produto.getProduto_cod();
        
        String sql = "insert into produto(nome, valor_unit, produto_cod) values('"+nome+"',"+valor_unit+",'"+produto_cod+"')";
        
        try{
            
            stmt = con.prepareStatement(sql);
            stmt.executeUpdate();
            
            //inseriu com sucesso
            infoBox("Material cadastrado com sucesso!", "OK");
        }catch(SQLException ex){
            
            //erro na inserção no banco
            infoBox("ERROR", ex.toString());
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<ProdutoDTO> listarProdutos(){
        try{
            
            List<ProdutoDTO> lista = new ArrayList<>();
            Connection con = ConnectionFactory.getConnection();
            String sql = "select * from produto";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                
                ProdutoDTO obj = new ProdutoDTO();
                
                obj.setNome(rs.getString("nome"));
                
                lista.add(obj);
            }
            
            return lista;
        }catch(Exception e){
            return null;
        }
    }
    
    public ProdutoDTO listarProduto(String nome){
        try{
            
            ProdutoDTO obj = new ProdutoDTO();
            
            Connection con = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM produto WHERE nome = '"+nome+"'"; 
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                obj.setProduto_cod(rs.getString("produto_cod"));
                obj.setValor_unit(Double.parseDouble(rs.getString("valor_unit")));
            }
            
            return obj;
        }catch(Exception e){
            return null;
        }
    }
    
    public List<ProdutoDTO> listarProdutosporNome(String nome){
        try{
            
            List<ProdutoDTO> lista = new ArrayList<>();
            Connection con = ConnectionFactory.getConnection();
            String sql = "SELECT nome FROM produto WHERE nome like '%"+nome+"%'"; 
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                
                ProdutoDTO obj = new ProdutoDTO();
                
                obj.setNome(rs.getString("nome"));
                
                lista.add(obj);
            }
            
            return lista;
        }catch(Exception e){
            return null;
        }
    }
    
    public void ExcluirProdutoPorNome(String nome){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        String sql = "delete from produto where nome = '"+nome+"'";
        
        try{
            
            stmt = con.prepareStatement(sql);
            stmt.executeUpdate();
            
            //inseriu com sucesso
            infoBox("Material excluído com sucesso!", "OK");
        }catch(SQLException ex){
            
            //erro na inserção no banco
            System.out.println("Erro ao excluir os dados" + ex.toString());
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void AtualizarProduto(ProdutoDTO produto){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        String nome, produto_cod;
        double valor_unit;
        nome = produto.getNome();
        produto_cod = produto.getProduto_cod();
        valor_unit = produto.getValor_unit();
        String sql = "update produto set produto_cod = '"+produto_cod+"', valor_unit = "+valor_unit+" where nome = '"+nome+"'";
        
        try{
            
            stmt = con.prepareStatement(sql);
            stmt.executeUpdate();
            
            //inseriu com sucesso
            infoBox("Material atualizado com sucesso!", "OK");
        }catch(SQLException ex){
            
            //erro na inserção no banco
            infoBox("ERROR", ex.toString());
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
}
