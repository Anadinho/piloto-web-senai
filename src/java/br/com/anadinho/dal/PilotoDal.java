/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.anadinho.dal;


import br.com.anadinho.model.Piloto;
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
 * @author anadinho
 */
public class PilotoDal {

    private Connection conexao;

    public PilotoDal() {
        conexao = Conexao.getConexao();
    }

      public void addPiloto(Piloto piloto) {
        String sql = "insert into pilotos ( nome, pais, dataNascimento, equipe, fabricanteMotor, pontosTemporada) values ( ?, ?, ?, ?, ?, ? )";
        try {
            PreparedStatement preparedStatement = conexao
                    .prepareStatement(sql);
            // Parameters start with 1
//            preparedStatement.setInt(1, piloto.getMatricula());
            preparedStatement.setString(1, piloto.getNome());
            preparedStatement.setString(2, piloto.getPais());
            preparedStatement.setDate(3, new java.sql.Date(piloto.getDataNascimento().getTime()));
            preparedStatement.setString(4, piloto.getEquipe());
            preparedStatement.setString(5, piloto.getFabricanteMotor());
            preparedStatement.setInt(6, piloto.getPontosTemporadas());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePiloto(int matricula) {
        try {
            PreparedStatement preparedStatement = conexao
                    .prepareStatement("delete from pilotos where matricula=?");
            // Parameters start with 1
            preparedStatement.setInt(1, matricula);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePiloto(Piloto piloto) {
        try {
            PreparedStatement preparedStatement = conexao
                    .prepareStatement("update pilotos set matricula =?, nome=?, pais=?, dataNascimento=?, equipe=?, fabricanteMotor=?, pontosTemporada=?  where matricula = ?");
            // Parameters start with 1
            preparedStatement.setInt(1, piloto.getMatricula());
            preparedStatement.setString(2, piloto.getNome());
            preparedStatement.setString(3, piloto.getPais());
            preparedStatement.setDate(4, new java.sql.Date(piloto.getDataNascimento().getTime()));
            preparedStatement.setString(5, piloto.getEquipe());
            preparedStatement.setString(6, piloto.getFabricanteMotor());
            preparedStatement.setInt(7, piloto.getPontosTemporadas());
            preparedStatement.setInt(8, piloto.getMatricula());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Piloto> getAllPiloto() {
        List<Piloto> pilotos = new ArrayList<Piloto>();
        String sql = "select * from pilotos"
                            + " ORDER BY pontosTemporada desc; ";
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
               Piloto piloto = new Piloto();
                piloto.setMatricula(rs.getInt("matricula"));
                piloto.setNome(rs.getString("nome"));
                piloto.setPais(rs.getString("pais"));
                piloto.setDataNascimento(rs.getDate("dataNascimento"));
                piloto.setEquipe(rs.getString("equipe"));
                piloto.setFabricanteMotor(rs.getString("fabricanteMotor"));
                piloto.setPontosTemporadas(rs.getInt("pontosTemporada"));
                pilotos.add(piloto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pilotos;
    }

    public Piloto getPilotoById(int matricula) {
        Piloto piloto = new Piloto();
        try {
            PreparedStatement preparedStatement = conexao.
                    prepareStatement("select * from pilotos where matricula=?");
            preparedStatement.setInt(1, matricula);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                piloto.setMatricula(rs.getInt("matricula"));
                piloto.setNome(rs.getString("nome"));
                piloto.setPais(rs.getString("pais"));
                piloto.setDataNascimento(rs.getDate("dataNascimento"));
                piloto.setEquipe(rs.getString("equipe"));
                piloto.setFabricanteMotor(rs.getString("fabricanteMotor"));
                piloto.setPontosTemporadas(rs.getInt("pontosTemporada"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return piloto;
    }
}
