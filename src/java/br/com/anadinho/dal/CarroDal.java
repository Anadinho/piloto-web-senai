/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.anadinho.dal;

import br.com.anadinho.model.Carro;
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
public class CarroDal {
    
     private Connection conexao;

    public CarroDal() {
        conexao = Conexao.getConexao();
    }

      public void addCarro(Carro carro) {
        String sql = "insert into carro (renavam, marca, modelo, cor, placa, data, categoria, combustivel, km) values ( ?, ?, ?, ?, ?, ?, ?, ?, ? )";
        try {
            PreparedStatement preparedStatement = conexao
                    .prepareStatement(sql);
            // Parameters start with 1        
            preparedStatement.setInt(1, carro.getRenavam());
            preparedStatement.setString(2, carro.getMarca());
            preparedStatement.setString(3, carro.getModelo());
            preparedStatement.setString(4, carro.getCor());
            preparedStatement.setString(5, carro.getPlaca());
             preparedStatement.setDate(6, new java.sql.Date(carro.getData().getTime()));
            preparedStatement.setString(7, carro.getCategoria());
            preparedStatement.setInt(8, carro.getCombustivel());
            preparedStatement.setInt(9, carro.getKm());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCarro(String placa) {
        try {
            PreparedStatement preparedStatement = conexao
                    .prepareStatement("delete from carro where placa=?");
            // Parameters start with 1
            preparedStatement.setString(1, placa);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCarro(Carro carro) {
        try {
            PreparedStatement preparedStatement = conexao
                    .prepareStatement("update carro set renavam =?, marca=?, modelo=?, cor=?, placa=?, data=?, categoria=?, combustivel=?, km=?  where placa = ?");
            // Parameters start with 1
              preparedStatement.setInt(1, carro.getRenavam());
            preparedStatement.setString(2, carro.getMarca());
            preparedStatement.setString(3, carro.getModelo());
            preparedStatement.setString(4, carro.getCor());
            preparedStatement.setString(5, carro.getPlaca());
            preparedStatement.setDate(6, new java.sql.Date(carro.getData().getTime()));
            preparedStatement.setString(7, carro.getCategoria());
            preparedStatement.setInt(8, carro.getCombustivel());
            preparedStatement.setInt(9, carro.getKm());
            preparedStatement.setString(10, carro.getPlaca());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Carro> getAllCarro() {
        List<Carro> carros = new ArrayList<Carro>();
        String sql = "select * from carro;";
                            
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
               Carro carro = new Carro();
                carro.setRenavam(rs.getInt("renavam"));
                carro.setMarca(rs.getString("marca"));
                carro.setModelo(rs.getString("modelo"));
                carro.setCor(rs.getString("cor"));
                carro.setPlaca(rs.getString("placa"));
                carro.setData(rs.getDate("data"));
                carro.setCategoria(rs.getString("categoria"));
                 carro.setCombustivel(rs.getInt("combustivel"));
                 carro.setKm(rs.getInt("km"));
                carros.add(carro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return carros;
    }

    public Carro getCarroById(String placa) {
        Carro carro = new Carro();
        try {
            PreparedStatement preparedStatement = conexao.
                    prepareStatement("select * from carro where placa=?");
            preparedStatement.setString(1, placa);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                 carro.setRenavam(rs.getInt("renavam"));
                 carro.setMarca(rs.getString("marca"));
                 carro.setModelo(rs.getString("modelo"));
                 carro.setCor(rs.getString("cor"));
                 carro.setPlaca(rs.getString("placa"));
                 carro.setData(rs.getDate("data"));
                 carro.setCategoria(rs.getString("categoria"));
                 carro.setCombustivel(rs.getInt("combustivel"));
                 carro.setKm(rs.getInt("km"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

       return carro;
    }
    
}
