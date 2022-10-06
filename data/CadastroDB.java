package data;

import model.CadastroCNES;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CadastroDB {

    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;

    public CadastroDB() {
        connection = Conexao.getConnection();
    }

    public boolean insert(CadastroCNES cadastro) throws SQLException {
        try {

            PreparedStatement stmt = this.connection
                    .prepareStatement("INSERT INTO tb_cnes (cnes, uf, ibge, nome, logradouro, bairro) values (?, ?, ?, ?, ?, ?)");

            stmt.setString(1, cadastro.getCnes());
            stmt.setString(2, cadastro.getUf());
            stmt.setString(3, cadastro.getIbge());
            stmt.setString(4, cadastro.getNome());
            stmt.setString(5, cadastro.getLogradouro());
            stmt.setString(6, cadastro.getBairro());


            stmt.execute();
            return true;

        } catch (SQLException e) {
            System.err.println(e.toString());
        } finally {

            connection.close();

        }
        return false;
    }
}