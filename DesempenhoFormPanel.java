import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


import javax.swing.JButton;
import javax.swing.JComponent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class DesempenhoFormPanel extends JPanel {
    private AppFrame frame;

    private Pesquisa pesquisa;

    private GridBagLayout layout;
    private GridBagConstraints constraints;

    private JTextField txtIdCandidato;
    private JButton btnPesquisar;
    private JButton btnCancelar;

    public DesempenhoFormPanel(AppFrame frame) {
        this.frame = frame;

        layout = new GridBagLayout();
        constraints = new GridBagConstraints();

        setLayout(layout);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                if (pesquisa == null) {
                    txtIdCandidato.setText("");
                    
                } else {
                    txtIdCandidato.setText(Integer.toString(pesquisa.getIdCandidato()));
                }
            }
        });

        criarForm();        
    }

    public void setFontePesquisa(Pesquisa pesquisa) {
        this.pesquisa = pesquisa;
    }

    private void criarForm() {
        JLabel label;

        label = new JLabel("Candidato");
        adicionarComponente(label, 0, 0);
        txtIdCandidato = new JTextField(30);
        adicionarComponente(txtIdCandidato, 1, 0);

        criarBotoes();
    }

    private void criarBotoes() {
        JPanel btnPanel = new JPanel();
        FlowLayout flowLayout = (FlowLayout) btnPanel.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);

        criarBtnPesquisar(btnPanel);
        criarBtnCancelar(btnPanel);

        adicionarComponente(btnPanel, 12, 0, 2, 1);
    }

    private void criarBtnPesquisar(JPanel btnPanel) {
        btnPesquisar = new JButton("Pesquisar");
        btnPesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (DesempenhoFormPanel.this.pesquisa == null) {
                    Pesquisa novaPesquisa = new Pesquisa();
                    novaPesquisa.setIdCandidato(Integer.parseInt(txtIdCandidato.getText()));
                    PesquisaStorage.inserir(novaPesquisa);
                    JOptionPane.showMessageDialog(DesempenhoFormPanel.this, 
                                                  "Pesquisa incluida com sucesso", 
                                                  "Todo App", 
                                                  JOptionPane.INFORMATION_MESSAGE);
                } else {
                    PesquisaStorage.atualizar(DesempenhoFormPanel.this.pesquisa);
                    JOptionPane.showMessageDialog(DesempenhoFormPanel.this, 
                                                  "Pesquisa atualizada com sucesso",
                                                  "Todo App",
                                                  JOptionPane.INFORMATION_MESSAGE);
                }

                    
                frame.mostrarPesquisaListPanel();
            }
        });
        btnPanel.add(btnPesquisar);
    }

    private void criarBtnCancelar(JPanel btnPanel) {
        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.mostrarDesempenhoListPanel();
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