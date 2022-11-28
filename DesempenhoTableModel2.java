import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class DesempenhoTableModel2 extends AbstractTableModel {
    private List<Desempenho> desempenhos = new ArrayList<>();
    private String[] colunas = new String[]{"Candidato",
                                            "Partido",
                                            "Intencao",
                                            "Fonte",
                                            "Mes",
                                            "Ano"};

    public DesempenhoTableModel2(List<Desempenho> desempenhos) {
        this.desempenhos = desempenhos;
    }

    @Override
    public int getRowCount() {
        return desempenhos.size();
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
        
        Desempenho desempenho = desempenhos.get(rowIdx);

        switch (colIdx) {
        case 0:
            value = desempenho.getNomeCandidato();
            break;
        case 1:
            value = desempenho.getSiglaPartido();
            break;
        case 2:
            value = Integer.toString(desempenho.getIntencaoVotos());
            break;
        case 3:
            value = desempenho.getFontePesquisa();
            break;
        case 4:
            value = Integer.toString(desempenho.getMesPesquisa());
            break;
        case 5:
            value = Integer.toString(desempenho.getAnoPesquisa());
            break;
        default:
            System.err.printf("[ERRO] Indice de coluna invalido: %d%n", 
                              colIdx);
        }

        return value;
    }

    public void carregar(List<Desempenho> desempenhos) {
        this.desempenhos = desempenhos;
        fireTableDataChanged();
    }

    public Desempenho getDesempenho(int rowIdx) {
        Desempenho desempenho = null;

        desempenho = desempenhos.get(rowIdx);

        return desempenho;
    }
} // fim da classe DesempenhoTableModel
