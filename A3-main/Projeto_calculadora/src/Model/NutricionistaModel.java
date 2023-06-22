/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author jotaf
 */
public class NutricionistaModel extends PessoaModel {

    private int id;
    private int crn;
    private String horario;

    public NutricionistaModel() {

    }

    public NutricionistaModel(String nome, int id, int crn, String horario) {
        this.id = id;
        this.crn = 0;
        this.horario = horario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public NutricionistaModel(String nome, String cpf, int crn, String horario) {

        this.crn = crn;

    }

    public int getCrn() {
        return crn;
    }

    public void setCrn(int crn) {
        this.crn = crn;
    }

    

   

}
