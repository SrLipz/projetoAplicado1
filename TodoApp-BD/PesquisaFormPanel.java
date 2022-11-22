import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class PesquisaFormPanel extends JPanel {
    private AppFrame frame;

    private Pesquisa pesquisa;

    private GridBagLayout layout;
    private GridBagConstraints constraints;

    private JTextField txtIdPesquisa;
    private JTextField txtIdCandidato;
    private JTextField txtIntencao;
    private JTextField txtFonte;
    private JTextField txtMes;
    private JTextField txtAno;
    private JButton btnSalvar;
    private JButton btnCancelar;

    public PesquisaFormPanel(AppFrame frame) {
        this.frame = frame;

        layout = new GridBagLayout();
        constraints = new GridBagConstraints();

        setLayout(layout);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                if (pesquisa == null) {
                    txtIdPesquisa.setText("");
                    txtIdCandidato.setText("");
                    txtIntencao.setText("");
                    txtFonte.setText("");
                    txtMes.setText("");
                    txtAno.setText("");
                    
                } else {
                    txtIdPesquisa.setText(Integer.toString(pesquisa.getIdPesquisa()));
                    txtIdCandidato.setText(Integer.toString(pesquisa.getIdCandidato()));
                    txtIntencao.setText(Integer.toString(pesquisa.getIntencaoVotos()));
                    txtFonte.setText(pesquisa.getFontePesquisa());
                    txtMes.setText(Integer.toString(pesquisa.getMesPesquisa()));
                    txtAno.setText(Integer.toString(pesquisa.getAnoPesquisa()));
                }
            }
        });

        criarForm();
        //formatCampo();
        
    }

    public void setFontePesquisa(Pesquisa pesquisa) {
        this.pesquisa = pesquisa;
    }

    private void criarForm() {
        JLabel label;

        label = new JLabel("ID");
        adicionarComponente(label, 0, 0);
        txtIdPesquisa = new JTextField(5);
        txtIdPesquisa.setEditable(false);
        adicionarComponente(txtIdPesquisa, 1, 0);

        label = new JLabel("Candidato");
        adicionarComponente(label, 3, 0);
        txtIdCandidato = new JTextField(30);
        adicionarComponente(txtIdCandidato, 3, 0);

        label = new JLabel("Intencao");
        adicionarComponente(label, 4, 0);
        txtIntencao = new JFormattedTextField();
        adicionarComponente(txtIntencao, 5, 0);

        label = new JLabel("Fonte");
        adicionarComponente(label, 6, 0);
        txtFonte = new JTextField();
        adicionarComponente(txtFonte, 7, 0);

        label = new JLabel("Dia");
        adicionarComponente(label, 8, 0);
        txtMes = new JFormattedTextField();
        adicionarComponente(txtMes, 9, 0);

        label = new JLabel("Mes");
        adicionarComponente(label, 10, 0);
        txtAno = new JFormattedTextField();
        adicionarComponente(txtAno, 11, 0);


        criarBotoes();
    }

    private void criarBotoes() {
        JPanel btnPanel = new JPanel();
        FlowLayout flowLayout = (FlowLayout) btnPanel.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);

        criarBtnSalvar(btnPanel);
        criarBtnCancelar(btnPanel);

        adicionarComponente(btnPanel, 12, 0, 2, 1);
    }

    private void criarBtnSalvar(JPanel btnPanel) {
        btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (PesquisaFormPanel.this.pesquisa == null) {
                    Pesquisa novaPesquisa = new Pesquisa();
                    novaPesquisa.setIdCandidato(Integer.parseInt(txtFonte.getText()));
                    novaPesquisa.setIntencaoVotos(Integer.parseInt(txtFonte.getText()));
                    novaPesquisa.setFontePesquisa(txtFonte.getText());
                    novaPesquisa.setMesPesquisa(Integer.parseInt(txtFonte.getText()));
                    novaPesquisa.setAnoPesquisa(Integer.parseInt(txtFonte.getText()));

                    PesquisaStorage.inserir(novaPesquisa);
                    JOptionPane.showMessageDialog(PesquisaFormPanel.this, 
                                                  "Pesquisa incluida com sucesso", 
                                                  "Todo App", 
                                                  JOptionPane.INFORMATION_MESSAGE);
                } else {
                    pesquisa.setFontePesquisa(txtFonte.getText());
                    PesquisaStorage.atualizar(PesquisaFormPanel.this.pesquisa);
                    JOptionPane.showMessageDialog(PesquisaFormPanel.this, 
                                                  "Pesquisa atualizada com sucesso",
                                                  "Todo App",
                                                  JOptionPane.INFORMATION_MESSAGE);
                }

                    
                frame.mostrarPesquisaListPanel();
            }
        });
        btnPanel.add(btnSalvar);
    }

    private void criarBtnCancelar(JPanel btnPanel) {
        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.mostrarPesquisaListPanel();
            }
        });
        btnPanel.add(btnCancelar);
    }

    private void adicionarComponente(JComponent componente, 
                                    int linha, int coluna) {
        adicionarComponente(componente, linha, coluna, 1, 1);
    }                                    

    private void adicionarComponente(JComponent componente, 
                                    int linha, int coluna, 
                                    int largura, int altura) {
        constraints.gridx = coluna;
        constraints.gridy = linha;
        constraints.gridwidth = largura;
        constraints.gridheight = altura;

        constraints.fill = GridBagConstraints.HORIZONTAL;

        layout.setConstraints(componente, constraints);
        add(componente);
    }

    /*private void formatCampo () {
        try {
            MaskFormatter mask = new MaskFormatter("##");
            mask.install(txtDia);
            mask.install(txtMes);
            mask.install(txtIntencao);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }*/

} // fim da classe TarefaFormPanel