/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Connection.ConnectionFactory;
import Model.NutricionistaModel;
import Model.NutricionistaModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author jotaf
 */
public class NutricionistaDAO {

    public void save(NutricionistaModel nutricionista) {
        String sql = "INSERT INTO nutricionista (nome, crn, horario) VALUES (?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //criar uma conexão com o banco de dados
            conn = ConnectionFactory.createConnectionToMySQL();

            //criar uma  PreparedStatement pára executar uma query
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            //adiciona os valores
            pstm.setString(1, nutricionista.getNome());
            pstm.setInt(2, nutricionista.getCrn());
            pstm.setString(3, nutricionista.getHorario());

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

    public List<NutricionistaModel> read() {

        String sql = "SELECT * FROM nutricionista";

        ArrayList<NutricionistaModel> nutricionistas = new ArrayList<NutricionistaModel>();

        Connection conn = null;
        PreparedStatement pstm = null;

// classe que vai recuperar os dados do banco
        ResultSet rset = null;

        try {

            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = (PreparedStatement) conn.prepareStatement(sql);

            rset = pstm.executeQuery();

            while (rset.next()) {

                NutricionistaModel nutricionista = new NutricionistaModel();

                //recuperar os dados
                nutricionista.setId(rset.getInt("id"));
                nutricionista.setNome(rset.getString("nome"));
                nutricionista.setCrn(rset.getInt("crn"));
                nutricionista.setHorario("horario");

                nutricionistas.add(nutricionista);

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
        return nutricionistas;
    }

}
