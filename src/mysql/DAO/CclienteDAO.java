package mysql.DAO;

import mysql.DTO.CCliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import trabalho.ConnectionFactory;

public class CclienteDAO {
    
    
    public void InserirCliente(CCliente cliente){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        String nome, email, telefone, cpf, cep, endereco;
        nome = cliente.getNome();
        telefone = cliente.getTelefone();
        email = cliente.getEmail();
        cpf = cliente.getCPF();
        cep = cliente.getCep();
        endereco = cliente.getEndereco();
        String sql = "insert into clientes(nome, email, telefone, cpf, cep, endereco) values('"+nome+"', '"+email+"', '"+telefone+"', '"+cpf+"', '"+cep+"','"+endereco+"')";
        
        try{
            
            stmt = con.prepareStatement(sql);
            stmt.executeUpdate();
            
            //inseriu com sucesso
            infoBox("Cliente adicionado com sucesso!", "OK");
        }catch(SQLException ex){
            
            //erro na inserção no banco
            infoBox("ERROR", ex.toString());
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void AtualizarCliente(CCliente cliente){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        String nome, email, telefone, cpf, cep,endereco;
        nome = cliente.getNome();
        telefone = cliente.getTelefone();
        email = cliente.getEmail();
        cpf = cliente.getCPF();
        cep = cliente.getCep();
        endereco = cliente.getEndereco();
        String sql = "update clientes set telefone = '"+telefone+"', email = '"+email+"', cpf = '"+cpf+"', cep = '"+cep+"', endereco = '"+endereco+"' where nome = '"+nome+"'";
        
        try{
            
            stmt = con.prepareStatement(sql);
            stmt.executeUpdate();
            
            //inseriu com sucesso
            infoBox("Cliente atualizado com sucesso!", "OK");
        }catch(SQLException ex){
            
            //erro na inserção no banco
            infoBox("ERROR", ex.toString());
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void ExcluirClientePorNomeEEmail(CCliente cliente){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        String nome, email;
        nome = cliente.getNome();
        email = cliente.getEmail();
        String sql = "delete from clientes where nome = '"+nome+"' and email = '"+email+"'";
        
        try{
            
            stmt = con.prepareStatement(sql);
            stmt.executeUpdate();
            
            //inseriu com sucesso
            infoBox("Cliente excluído com sucesso!", "OK");
        }catch(SQLException ex){
            
            //erro na inserção no banco
            System.out.println("Erro ao excluir os dados" + ex.toString());
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void ExcluirClientePorNome(String nome){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        String sql = "delete from clientes where nome = '"+nome+"'";
        
        try{
            
            stmt = con.prepareStatement(sql);
            stmt.executeUpdate();
            
            //inseriu com sucesso
            infoBox("Cliente excluído com sucesso!", "OK");
        }catch(SQLException ex){
            
            //erro na inserção no banco
            System.out.println("Erro ao excluir os dados" + ex.toString());
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<CCliente> listarClientes(){
        try{
            
            List<CCliente> lista = new ArrayList<>();
            Connection con = ConnectionFactory.getConnection();
            String sql = "select * from clientes";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                
                CCliente obj = new CCliente();
                
                obj.setNome(rs.getString("nome"));
                obj.setEmail(rs.getString("email"));
                obj.setCPF(rs.getString("cpf"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setTelefone(rs.getString("telefone"));
                
                
                lista.add(obj);
            }
            
            return lista;
        }catch(Exception e){
            return null;
        }
    }
    
    public CCliente listarCliente(String nome){
        try{
            
            CCliente obj = new CCliente();
            
            Connection con = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM clientes WHERE nome = '"+nome+"'"; 
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                obj.setEmail(rs.getString("email"));
                obj.setCPF(rs.getString("cpf"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setTelefone(rs.getString("telefone"));
            }
            
            return obj;
        }catch(Exception e){
            return null;
        }
    }
    
    public List<CCliente> listarClientesporNome(String nome){
        try{
            
            List<CCliente> lista = new ArrayList<>();
            Connection con = ConnectionFactory.getConnection();
            String sql = "SELECT nome FROM clientes WHERE nome like '%"+nome+"%'"; 
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                
                CCliente obj = new CCliente();
                
                obj.setNome(rs.getString("nome"));
                
                lista.add(obj);
            }
            
            return lista;
        }catch(Exception e){
            return null;
        }
    }
    
    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
}
