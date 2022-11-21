/* 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class IntencaoStorage {
    //private static List<Tarefa> tarefas = new ArrayList<>();
    //private static int incremento = 1;

    public static boolean inserir(Pesquisa pesquisa) {
        //tarefa.setId(incremento++);
        //tarefas.add(tarefa);

        String query = "INSERT INTO intencao (fonte, intencao) VALUES (?, ?)";

        Connection conexao = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            conexao = ConexaoFactory.getConexao();

            statement = conexao.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, pesquisa.getFontePesquisa());
            statement.setString(2, pesquisa.getIntencaoPesquisa());
            statement.execute();

            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                pesquisa.setIdPesquisa(resultSet.getInt(1));
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

    public static boolean atualizar(Pesquisa pesquisa) {
        //int idx = tarefas.indexOf(tarefa);
        //if (idx >= 0) {
        //    tarefas.set(idx, tarefa);
        //}

        String query = "UPDATE pesquisa SET fonte = ?, intencao = ? WHERE id = ?";

        Connection conexao = null;
        PreparedStatement statement = null;

        try {
            conexao = ConexaoFactory.getConexao();

            statement = conexao.prepareStatement(query);
            statement.setString(1, pesquisa.getFontePesquisa());
            statement.setString(2, pesquisa.getIntencaoPesquisa());
            statement.setInt(3, pesquisa.getIdPesquisa());
            statement.execute();
        } catch (SQLException e) {
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

    public static boolean remover(Pesquisa pesquisa) {
        //tarefas.remove(tarefa);

        String query = "DELETE FROM pesquisa WHERE id = ?";

        Connection conexao = null;
        PreparedStatement statement = null;

        try {
            conexao = ConexaoFactory.getConexao();

            statement = conexao.prepareStatement(query);
            statement.setInt(1, pesquisa.getIdPesquisa());
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

    public static List<Pesquisa> listar() {
        //return tarefas;

        List<Pesquisa> pesquisas = new ArrayList<>();

        String query = "SELECT * FROM pesquisa ORDER BY id";

        Connection conexao = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            conexao = ConexaoFactory.getConexao();

            statement = conexao.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Pesquisa pesquisa = new Pesquisa();
                pesquisa.setIdPesquisa(resultSet.getInt("id"));
                pesquisa.setFontePesquisa(resultSet.getString("fonte"));
                pesquisa.setIntencaoPesquisa(resultSet.getString("intencao"));

                pesquisas.add(pesquisa);
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

        return pesquisas;
    }
} // fim da classe TarefaStorage
*/