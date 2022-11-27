import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
//import javax.swing.RowFilter;
//import javax.swing.table.TableRowSorter;


public class DesempenhoListPanel extends JPanel {
    private AppFrame frame;

    private JTextField txtPesquisa;
    private JButton btnVoltar;
    private JTable tabela;
    private DesempenhoTableModel tableModel;
    //private TableRowSorter<DesempenhoTableModel> rowSorter;


    public DesempenhoListPanel(AppFrame frame) {
        this.frame = frame;

        setLayout(new BorderLayout());

        criarComandosPanel();
        criarTabelaPanel();
    }

    private void criarComandosPanel() {
        JPanel panel = new JPanel();
        FlowLayout layout = (FlowLayout) panel.getLayout();
        layout.setAlignment(FlowLayout.LEFT);

        criarTxtPesquisa();
        panel.add(txtPesquisa);

        criarBtnVoltar();
        panel.add(btnVoltar);

        add(panel, BorderLayout.NORTH);

    }

    /*private void criarTxtPesquisa() {
        txtPesquisa = new JTextField(34);
        txtPesquisa.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                rowSorter.setRowFilter(RowFilter.regexFilter(txtPesquisa.getText()));
            }
        });

    }*/

    private void criarTxtPesquisa() {
        txtPesquisa = new JTextField(34);
        txtPesquisa.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                //rowSorter.setRowFilter(RowFilter.regexFilter(txtPesquisa.getText()));
                
                if (txtPesquisa.getText() != "") {
                    tableModel.carregar(PesquisaStorage.listar(Integer.parseInt(txtPesquisa.getText())));
                } else { 
                    recarregar();
                
                }

            }
        });
    }

    /*private void criarBtnPesquisar() {
        btnPesquisar = new JButton("Pesquisar");
        btnPesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.mostrarDesemepenhoFormPanel(null);
            }
        });
    }*/


    private void criarBtnVoltar() {
        btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.mostrarInicialPanel();
            }
        });
    }

    private void criarTabelaPanel() {
        JPanel panel = new JPanel();

        tableModel = new DesempenhoTableModel(PesquisaStorage.listar());
        tabela = new JTable(tableModel);
        //rowSorter = new TableRowSorter<>(tableModel);
        //tabela.setRowSorter(rowSorter);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        JScrollPane scrollPane = new JScrollPane(tabela);
        panel.add(scrollPane);

        add(panel, BorderLayout.CENTER);
    }

    public void recarregar() {
        tableModel.carregar(PesquisaStorage.listar(0));
    }
} // fim da classe DesempenhoListPanel