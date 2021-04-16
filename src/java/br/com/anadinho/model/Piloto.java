/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.anadinho.model;

//import java.sql.Date;
import java.util.Date;

/**
 *
 * @author anadinho
 */
public class Piloto {
    
   private int  matricula;
   private String nome;
   private String pais;
   private Date dataNascimento;
   private String equipe;
   private String fabricanteMotor;
   private int pontosTemporadas;

    /**
     * @return the matricula
     */
    public int getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(String pais) {
        this.pais = pais;
    }


    /**
     * @return the equipe
     */
    public String getEquipe() {
        return equipe;
    }

    /**
     * @param equipe the equipe to set
     */
    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }

    /**
     * @return the fabricanteMotor
     */
    public String getFabricanteMotor() {
        return fabricanteMotor;
    }

    /**
     * @param fabricanteMotor the fabricanteMotor to set
     */
    public void setFabricanteMotor(String fabricanteMotor) {
        this.fabricanteMotor = fabricanteMotor;
    }

    /**
     * @return the pontosTemporadas
     */
    public int getPontosTemporadas() {
        return pontosTemporadas;
    }

    /**
     * @param pontosTemporadas the pontosTemporadas to set
     */
    public void setPontosTemporadas(int pontosTemporadas) {
        this.pontosTemporadas = pontosTemporadas;
    }
    
    
   @Override
     public String toString() {
        return "matricula=" + getMatricula() + ", nome=" + getNome()
                + ", pais=" + getPais() + ", dataNascimento=" + getDataNascimento() + ", equipe="
                + getEquipe()+ ", fabricanteMotor="  + getFabricanteMotor() + ", pontosTemporada="  + getPontosTemporadas()+ "]";
    }

    /**
     * @return the dataNascimento
     */
    public Date getDataNascimento() {
        return dataNascimento;
    }

    /**
     * @param dataNascimento the dataNascimento to set
     */
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
}
