/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projeto_calculadora;

import Model.LoginModel;
import Model.NutricionistaModel;
import Dao.LoginDAO;
import Dao.PacienteDAO;
import Model.PacienteModel;
import javax.swing.JOptionPane;

/**
 *
 * @author jotaf
 */
public class Projeto_calculadora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      
        PacienteModel paciente = new PacienteModel();
            PacienteDAO pacienteDao = new PacienteDAO();

         paciente.setNome("teste");
         paciente.setCpf("1");
         paciente.setIdade(1);
         paciente.setPeso(2);
         paciente.setAltura(3);
         paciente.setTmb(1);
         paciente.setId(1);
         
         pacienteDao.update(paciente);
        
        }
       
    }
    

