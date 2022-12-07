import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CandidatoStorage {

    public static boolean inserir(Candidato candidato) {
        String query = "INSERT INTO candidato (NomeCandidato, NumeroPartido, SiglaPartido) VALUES (?, ?, ?)";

        Connection conexao = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            conexao = ConexaoFactory.getConexao();

            statement = conexao.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, candidato.getNomeCandidato());
            statement.setInt(2, candidato.getNumeroCandidato());
            statement.setString(3, candidato.getPartidoCandidato());
            statement.execute();

            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                candidato.setIdCandidato(resultSet.getInt(1));
            }
        } catch (SQLException e ) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }

                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

        return true;
    }

    public static boolean atualizar(Candidato candidato) {
        String query = "UPDATE candidato SET NomeCandidato = ?, NumeroPartido = ?, SiglaPartido = ? WHERE idCandidato = ?";

        Connection conexao = null;
        PreparedStatement statement = null;

        try {
            conexao = ConexaoFactory.getConexao();

            statement = conexao.prepareStatement(query);
            statement.setString(1, candidato.getNomeCandidato());
            statement.setInt(2, candidato.getNumeroCandidato());
            statement.setString(3, candidato.getPartidoCandidato());
            statement.setInt(4, candidato.getIdCandidato());
            statement.execute();
        } catch (SQLException e ) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

        return true;
    }

    public CandidatoFormPanel candidatoFormPanel;

    public static boolean remover(Candidato candidato) {
        String query = "DELETE FROM candidato WHERE idCandidato = ?";

        Connection conexao = null;
        PreparedStatement statement = null;

        try {
            conexao = ConexaoFactory.getConexao();

            statement = conexao.prepareStatement(query);
            statement.setInt(1, candidato.getIdCandidato());
            statement.execute();
        } catch (SQLException e ) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

        return true;
    }

    public static List<Candidato> listar() {
        List<Candidato> candidatos = new ArrayList<>();

        String query = "SELECT * FROM candidato ORDER BY idCandidato";

        Connection conexao = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            conexao = ConexaoFactory.getConexao();

            statement = conexao.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Candidato candidato = new Candidato();
                candidato.setIdCandidato(resultSet.getInt("idCandidato"));
                candidato.setNomeCandidato(resultSet.getString("NomeCandidato"));
                candidato.setNumeroCandidato(resultSet.getInt("NumeroPartido"));
                candidato.setPartidoCandidato(resultSet.getString("SiglaPartido"));

                candidatos.add(candidato);
            }
        } catch (SQLException e ) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }

                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return candidatos;
    }
} // fim da classe CandidatoStorage
