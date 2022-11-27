import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class DesempenhoTableModel extends AbstractTableModel {
    private List<Pesquisa> pesquisas = new ArrayList<>();
    private String[] colunas = new String[]{"Candidato",
                                            "Intencao",
                                            "Fonte",
                                            "Mes",
                                            "Ano"};

    public DesempenhoTableModel(List<Pesquisa> pesquisas) {
        this.pesquisas = pesquisas;
    }

    @Override
    public int getRowCount() {
        return pesquisas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int colIdx) {
        String colName = null;

        colName = colunas[colIdx];

        return colName;
    }

    @Override
    public Object getValueAt(int rowIdx, int colIdx) {
        String value = null;

        Pesquisa pesquisa = pesquisas.get(rowIdx);

        switch (colIdx) {
        case 0:
            value = Integer.toString(pesquisa.getIdCandidato());
            break;
        case 1:
            value = Integer.toString(pesquisa.getIntencaoVotos());
            break;
        case 2:
            value = pesquisa.getFontePesquisa();
            break;
        case 3:
            value = Integer.toString(pesquisa.getMesPesquisa());
            break;
        case 4:
            value = Integer.toString(pesquisa.getAnoPesquisa());
            break;
        default:
            System.err.printf("[ERRO] Indice de coluna invalido: %d%n", 
                              colIdx);
        }

        return value;
    }

    public void carregar(List<Pesquisa> pesquisas) {
        this.pesquisas = pesquisas;
        fireTableDataChanged();
    }

    public Pesquisa getFontePesquisa(int rowIdx) {
        Pesquisa pesquisa = null;

        pesquisa = pesquisas.get(rowIdx);

        return pesquisa;
    }
} // fim da classe DesempenhoTableModel
