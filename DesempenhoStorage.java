import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DesempenhoStorage {

    public static List<Desempenho> listar() {
        List<Desempenho> desempenhos = new ArrayList<>();

        String query = "SELECT c.NomeCandidato, c.SiglaPartido, p.intencaoVotos, p.fontePesquisa, p.mesPesquisa, p.anoPesquisa FROM projetoaplicado.candidato c INNER JOIN projetoaplicado.pesquisa p on c.idCandidato = p.idCandidato ORDER BY mesPesquisa, anoPesquisa";

        Connection conexao = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            conexao = ConexaoFactory.getConexao();

            statement = conexao.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Desempenho desempenho = new Desempenho();
                desempenho.setNomeCandidato(resultSet.getString("NomeCandidato"));
                desempenho.setSiglaPartido(resultSet.getString("SiglaPartido"));
                desempenho.setIntencaoVotos(resultSet.getInt("intencaoVotos"));
                desempenho.setFontePesquisa(resultSet.getString("fontePesquisa"));
                desempenho.setMesPesquisa(resultSet.getInt("mesPesquisa"));
                desempenho.setAnoPesquisa(resultSet.getInt("anoPesquisa"));

                desempenhos.add(desempenho);
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

        return desempenhos;
    }

    public static List<Desempenho> listar(String nome) {
        List<Desempenho> desempenhos = new ArrayList<>();

        String query = "SELECT c.NomeCandidato, c.SiglaPartido, p.intencaoVotos, p.fontePesquisa, p.mesPesquisa, p.anoPesquisa FROM projetoaplicado.candidato c INNER JOIN projetoaplicado.pesquisa p on c.idCandidato = p.idCandidato WHERE NomeCandidato like '" + nome + "%' ORDER BY mesPesquisa, anoPesquisa";

        Connection conexao = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            conexao = ConexaoFactory.getConexao();

            statement = conexao.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Desempenho desempenho = new Desempenho();
                desempenho.setNomeCandidato(resultSet.getString("NomeCandidato"));
                desempenho.setSiglaPartido(resultSet.getString("SiglaPartido"));
                desempenho.setIntencaoVotos(resultSet.getInt("intencaoVotos"));
                desempenho.setFontePesquisa(resultSet.getString("fontePesquisa"));
                desempenho.setMesPesquisa(resultSet.getInt("mesPesquisa"));
                desempenho.setAnoPesquisa(resultSet.getInt("anoPesquisa"));

                desempenhos.add(desempenho);
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

        return desempenhos;
    }

} // fim da classe PesquisaStorage