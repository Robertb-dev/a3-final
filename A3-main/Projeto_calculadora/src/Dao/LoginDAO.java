package Dao;

import Connection.ConnectionFactory;
import Model.LoginModel;
import java.sql.*;
import javax.swing.JOptionPane;


/**
 *
 * @author jotaf
 */
public class LoginDAO {

    public void save(LoginModel login) {

        String sql = "INSERT INTO login (username, senha) VALUES (?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //criar uma conexão com o banco de dados
            conn = ConnectionFactory.createConnectionToMySQL();

            //criar uma  PreparedStatement pára executar uma query
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            //adiciona os valores
            pstm.setString(1, login.getUsername());
            pstm.setString(2, login.getSenha());

            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            //fechar as conexões
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public boolean testeLogin(String username, String senha){

    

        String sql = "SELECT * FROM login WHERE username = ? and senha = ?";

        Connection conn = null;
        PreparedStatement pstm = null;
        boolean teste = false;

// classe que vai recuperar os dados do banco
        ResultSet rset = null;

        try {

            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = (PreparedStatement) conn.prepareStatement(sql);
            
            pstm.setString(1, username);
            pstm.setString(2, senha);

            rset = pstm.executeQuery();

            if (rset.next()) {

                teste = true;

            }else{
                 
                JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos!");
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //fechar as conexões
            try {
                if (rset != null) {
                    rset.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return teste;
    }
}
