import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class DesempenhoListPanel extends JPanel {
    private AppFrame frame;

    private JButton btnPesquisar;
    private JButton btnVoltar;
    private JTable tabela;
    private DesempenhoTableModel tableModel;


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

        criarBtnPesquisar();
        panel.add(btnPesquisar);

        criarBtnVoltar();
        panel.add(btnVoltar);

        add(panel, BorderLayout.NORTH);

    }

    private void criarBtnPesquisar() {
        btnPesquisar = new JButton("Pesquisar");
        btnPesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.mostrarDesemepenhoFormPanel(null);
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

        tableModel = new DesempenhoTableModel(PesquisaStorage.listar());
        tabela = new JTable(tableModel);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        JScrollPane scrollPane = new JScrollPane(tabela);
        panel.add(scrollPane);

        add(panel, BorderLayout.CENTER);
    }

    public void recarregar() {
        tableModel.carregar(PesquisaStorage.listar());
    }
} // fim da classe DesempenhoListPanel