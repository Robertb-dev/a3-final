/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connection;
import java.sql.Connection;
import java.sql.*;

/**
 *
 * @author jotaf
 */
public class ConnectionFactory {
    //nome do usu�rio do MySql
    private static final String USERNAME = "root";
    // senha do banco
    private static final String PASSWORD = "";     
    //caminho do banco de dados, porta, nome do banco de dados
    private static final String DATABASE_URL = "jdbc:mysql://localhost/projeto";
    
    //CONEX�O COM BANCO DE DADOS
    
    public static Connection createConnectionToMySQL() throws Exception {
        
        //Faz com que a classe seja carregada pela JVM
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        //cria a conex�o com banco de dados
        Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        
        return connection;
    }
    public static void main(String[] args) throws Exception {
        
        //Recuperar uma conex�o com o banco de dados
        Connection con = createConnectionToMySQL();
        
        //testar se a conex��o � null
        if(con != null){
            System.out.println("Conex�o obtida!");
            con.close();
        }
        
    }
}
