/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author jotaf
 */
public class PacienteModel extends PessoaModel{
    
    private int idade;
    private double peso;
    private int altura;
    private double tmb;
    private int id;
    private String cpf;


    
    public PacienteModel(String nome, String cpf, int idade, double peso, int altura,  double tmb ) {
        
        this.peso = peso;
        this.altura = altura;
        this.idade = idade;
        this.tmb = tmb;
    }

    public PacienteModel() {
       
    }


    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getTmb() {
        return tmb;
    }

    public void setTmb(double tmb) {
        this.tmb = tmb;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    
    
    
  


    
}
