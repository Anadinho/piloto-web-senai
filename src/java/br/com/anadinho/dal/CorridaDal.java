/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.anadinho.dal;

import br.com.anadinho.model.Corrida;
import br.com.anadinho.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author suporte
 */
public class CorridaDal {
    
    
    private Connection conexao;

    public CorridaDal() {
        conexao = Conexao.getConexao();
    }

      public void addCorrida(Corrida corrida) {
        String sql = "insert into corrida (nomeCorrida, dataCorrida, circuito, corrida_piloto, corrida_carro) values ( ?, ?, ?, ? ,?)";
//                          
        try {
            PreparedStatement preparedStatement = conexao
                    .prepareStatement(sql);
            // Parameters start with 1        
              preparedStatement.setString(1, corrida.getNomeCorrida());
            preparedStatement.setDate(2, new java.sql.Date(corrida.getDataCorrida().getTime()));
            preparedStatement.setString(3, corrida.getCircuito());
            preparedStatement.setInt(4, corrida.getPiloto().getMatricula());
            preparedStatement.setString(5, corrida.getCarro().getPlaca());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCarro(String id) {
        try {
            PreparedStatement preparedStatement = conexao
                    .prepareStatement("delete from corrida where id=?");
            // Parameters start with 1
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCorrida(Corrida corrida) {
        try {
            PreparedStatement preparedStatement = conexao
                    .prepareStatement("update corrida set nomeCorrida =?, dataCorrida=?, circuito=?, corrida_piloto=?, corrida_carro=?  where id = ?");
            // Parameters start with 1
             preparedStatement.setString(1, corrida.getNomeCorrida());
             preparedStatement.setDate(2, new java.sql.Date(corrida.getDataCorrida().getTime()));
             preparedStatement.setString(3, corrida.getCircuito());
             preparedStatement.setInt(4, corrida.getPiloto().getMatricula());
             preparedStatement.setString(5, corrida.getCarro().getPlaca());
             preparedStatement.setInt(6, corrida.getId());
             preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Corrida> getAllCorrida() {
        List<Corrida> corridas = new ArrayList<Corrida>();
        String sql = "select * from corrida";
                      PilotoDal pD =new PilotoDal();
                      CarroDal cD = new CarroDal();
                      
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
               Corrida corrida = new Corrida();
                corrida.setId(rs.getInt("id"));
                corrida.setNomeCorrida(rs.getString("nomeCorrida"));
               corrida.setDataCorrida(rs.getDate("dataCorrida"));
                corrida.setCircuito(rs.getString("circuito"));
                corrida.setPiloto(pD.getPilotoById(rs.getInt("corrida_piloto")));
                 corrida.setCarro(cD.getCarroById(rs.getString("corrida_carro")));
                corridas.add(corrida);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return corridas;
    }

    public Corrida getCorridaById(String id) {
        Corrida corrida = new Corrida();
        PilotoDal pD =new PilotoDal();
          CarroDal cD = new CarroDal();
        try {
            PreparedStatement preparedStatement = conexao.
                    prepareStatement("select * from corrida where id=?");
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                 corrida.setId(rs.getInt("id"));
                corrida.setNomeCorrida(rs.getString("nomeCorrida"));
                corrida.setDataCorrida(rs.getDate("dataCorrida"));
                corrida.setCircuito(rs.getString("circuito"));
                corrida.setPiloto(pD.getPilotoById(rs.getInt("corrida_piloto")));
                corrida.setCarro(cD.getCarroById(rs.getString("corrida_carro")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

       return corrida;
    }
    
    
    
    
}
