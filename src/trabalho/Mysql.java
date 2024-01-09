package trabalho;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import mysql.DTO.CCliente;
import mysql.DAO.CclienteDAO;


public class Mysql {
    public static void main(String[] args) {
        CCliente c = new CCliente();
        CclienteDAO dao = new CclienteDAO();
        c.setNome("Alisson");
        
        //dao.getCliente("teste");
    }
    
}
