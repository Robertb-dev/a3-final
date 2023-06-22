/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Connection.ConnectionFactory;
import Model.PacienteModel;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jotaf
 */
public class PacienteDAO {

    public void save(PacienteModel paciente) {
        String sql = "INSERT INTO paciente (nome, cpf, idade, peso, altura, tmb) VALUES (?, ?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //criar uma conexão com o banco de dados
            conn = ConnectionFactory.createConnectionToMySQL();

            //criar uma  PreparedStatement pára executar uma query
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            //adiciona os valores
            pstm.setString(1, paciente.getNome());
            pstm.setString(2, paciente.getCpf());
            pstm.setInt(3, paciente.getIdade());
            pstm.setDouble(4, paciente.getPeso());
            pstm.setInt(5, paciente.getAltura());
            pstm.setDouble(6, paciente.getTmb());

            pstm.execute();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            
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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<PacienteModel> read(){

    

        String sql = "SELECT * FROM paciente";

        ArrayList<PacienteModel> pacientes = new ArrayList<PacienteModel>();

        Connection conn = null;
        PreparedStatement pstm = null;

// classe que vai recuperar os dados do banco
        ResultSet rset = null;

        try {

            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = (PreparedStatement) conn.prepareStatement(sql);

            rset = pstm.executeQuery();

            while (rset.next()) {

                PacienteModel paciente = new PacienteModel();

                //recuperar os dados
                paciente.setId(rset.getInt("id"));
                paciente.setNome(rset.getString("nome"));
                paciente.setCpf(rset.getString("cpf"));
                paciente.setIdade(rset.getInt("idade"));
                paciente.setPeso(rset.getDouble("peso"));
                paciente.setAltura(rset.getInt("altura"));
                paciente.setTmb(rset.getDouble("tmb"));
                

                pacientes.add(paciente);

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
        return pacientes;
    }
    
    public void update (PacienteModel paciente) {
        
        String sql = "UPDATE paciente SET nome = ?, cpf = ?, idade = ?, peso = ?, altura = ?, tmb = ? WHERE id = ?";
                 
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try {
            
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            
            pstm.setString(1, paciente.getNome());         
            pstm.setString(2, paciente.getCpf());
            pstm.setInt(3, paciente.getIdade());
            pstm.setDouble(4, paciente.getPeso());
            pstm.setInt(5, paciente.getAltura());
            pstm.setDouble(6, paciente.getTmb());
            
            pstm.setInt(7, paciente.getId());
            
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Atualizado com Sucesso!");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
               
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
    }
    //bruce falou que pode reprovar ele!
    public void delete (PacienteModel paciente) {
        
        String sql = "DELETE FROM paciente WHERE id = ?";
                 
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try {
            
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
               
            pstm.setInt(1, paciente.getId());
            
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
               
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
    }
}
