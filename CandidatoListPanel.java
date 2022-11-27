import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class CandidatoListPanel extends JPanel {
    private AppFrame frame;

    private JButton btnCriar;
    private JButton btnEditar;
    private JButton btnRemover;
    private JButton btnVoltar;
    private JTable tabela;
    private CandidatoTableModel tableModel;

    public CandidatoListPanel(AppFrame frame) {
        this.frame = frame;

        setLayout(new BorderLayout());

        criarComandosPanel();
        criarTabelaPanel();
    }

    private void criarComandosPanel() {
        JPanel panel = new JPanel();
        FlowLayout layout = (FlowLayout) panel.getLayout();
        layout.setAlignment(FlowLayout.LEFT);

        criarBtnCriar();
        panel.add(btnCriar);

        criarBtnEditar();
        panel.add(btnEditar);

        criarBtnRemover();
        panel.add(btnRemover);

        criarBtnVoltar();
        panel.add(btnVoltar);

        add(panel, BorderLayout.NORTH);

        desabilitarBtns();
    }

    private void criarBtnCriar() {
        btnCriar = new JButton("Criar");
        btnCriar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.mostrarCandidatoFormPanel(null);
            }
        });
    }

    private void criarBtnEditar() {
        btnEditar = new JButton("Editar");
        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.mostrarCandidatoFormPanel(tableModel.getNomeCandidato(tabela.getSelectedRow()));
            }
        });
    }

    private void criarBtnRemover() {
        btnRemover = new JButton("Remover");
        btnRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Candidato candidato = tableModel.getNomeCandidato(tabela.getSelectedRow());
                int resposta = JOptionPane.showConfirmDialog(CandidatoListPanel.this, "Deseja realmente remover?", "Todo App", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (resposta == JOptionPane.YES_OPTION) {
                    CandidatoStorage.remover(candidato);
                    recarregar();
                }
            }
        });
    }

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

        tableModel = new CandidatoTableModel(CandidatoStorage.listar());
        tabela = new JTable(tableModel);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabela.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    if (tabela.getSelectedRow() >= 0) {
                        habilitarBtns();
                    } else {
                        desabilitarBtns();
                    }
                }
            }
        });
        JScrollPane scrollPane = new JScrollPane(tabela);
        panel.add(scrollPane);

        add(panel, BorderLayout.CENTER);
    }

    private void habilitarBtns() {
        btnEditar.setEnabled(true);
        btnRemover.setEnabled(true);
    }

    private void desabilitarBtns() {
        btnEditar.setEnabled(false);
        btnRemover.setEnabled(false);
    }

    public void recarregar() {
        tableModel.carregar(CandidatoStorage.listar());
    }
} // fim da classe CandidatoListPanel