/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.anadinho.model;

import java.util.Date;

/**
 *
 * @author suporte
 */
public class Corrida {
    private String nomeCorrida;
    private Date dataCorrida;
    private String circuito;
//    private int piloto;
//    private String carro;
    
    private Piloto piloto;
    private Carro carro;
    private int id;

    /**
     * @return the nomeCorrida
     */
    public String getNomeCorrida() {
        return nomeCorrida;
    }

    /**
     * @param nomeCorrida the nomeCorrida to set
     */
    public void setNomeCorrida(String nomeCorrida) {
        this.nomeCorrida = nomeCorrida;
    }

    /**
     * @return the dataCorrida
     */
    public Date getDataCorrida() {
        return dataCorrida;
    }

    /**
     * @param dataCorrida the dataCorrida to set
     */
    public void setDataCorrida(Date dataCorrida) {
        this.dataCorrida = dataCorrida;
    }

    /**
     * @return the circuito
     */
    public String getCircuito() {
        return circuito;
    }

    /**
     * @param circuito the circuito to set
     */
    public void setCircuito(String circuito) {
        this.circuito = circuito;
    }

    
    //    /**
//     * @return the piloto
//     */
//    public int getPiloto() {
//        return piloto;
//    }
//
//    /**
//     * @param piloto the piloto to set
//     */
//    public void setPiloto(int piloto) {
//        this.piloto = piloto;
//    }
//
//    /**
//     * @return the carro
//     */
//    public String getCarro() {
//        return carro;
//    }
//
//    /**
//     * @param carro the carro to set
//     */
//    public void setCarro(String carro) {
//        this.carro = carro;
//    }
    
    /**
     * @return the piloto
     */
    public Piloto getPiloto() {
        return piloto;
    }

    /**
     * @param piloto the piloto to set
     */
    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    /**
     * @return the carro
     */
    public Carro getCarro() {
        return carro;
    }

    /**
     * @param carro the carro to set
     */
    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
    
}
