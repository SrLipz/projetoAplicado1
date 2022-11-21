import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CandidatoStorage {
    //private static List<Tarefa> tarefas = new ArrayList<>();
    //private static int incremento = 1;

    public static boolean inserir(Candidato candidato) {
        //tarefa.setId(incremento++);
        //tarefas.add(tarefa);

        String query = "INSERT INTO candidato (NomeCandidato, NumeroPartido, SiglaPartido) VALUES (?, ?, ?)";

        Connection conexao = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            conexao = ConexaoFactory.getConexao();

            statement = conexao.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, candidato.getNomeCandidato());
            statement.setString(2, candidato.getNumeroCandidato());
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
        //int idx = tarefas.indexOf(tarefa);
        //if (idx >= 0) {
        //    tarefas.set(idx, tarefa);
        //}

        String query = "UPDATE candidato SET NomeCandidato = ?, NumeroPartido = ?, SiglaPartido = ? WHERE idCandidato = ?";

        Connection conexao = null;
        PreparedStatement statement = null;

        try {
            conexao = ConexaoFactory.getConexao();

            statement = conexao.prepareStatement(query);
            statement.setString(1, candidato.getNomeCandidato());
            statement.setString(2, candidato.getNumeroCandidato());
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

    public static boolean remover(Candidato candidato) {
        //tarefas.remove(tarefa);

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
        //return tarefas;

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
                candidato.setNumeroCandidato(resultSet.getString("NumeroPartido"));
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
} // fim da classe TarefaStorage
