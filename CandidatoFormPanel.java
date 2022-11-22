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

public class CandidatoFormPanel extends JPanel {
    private AppFrame frame;

    private Candidato candidato;

    private GridBagLayout layout;
    private GridBagConstraints constraints;

    private JTextField txtId;
    private JTextField txtNome;
    private JFormattedTextField txtNumero;
    private JTextField txtPartido;
    private JButton btnSalvar;
    private JButton btnCancelar;

    public CandidatoFormPanel(AppFrame frame) {
        this.frame = frame;

        layout = new GridBagLayout();
        constraints = new GridBagConstraints();

        setLayout(layout);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                if (candidato == null) {
                    txtId.setText("");
                    txtNome.setText("");
                    txtNumero.setText("");
                    txtPartido.setText("");
                } else {
                    txtId.setText(Integer.toString(candidato.getIdCandidato()));
                    txtNome.setText(candidato.getNomeCandidato());
                    txtNumero.setText(Integer.toString(candidato.getNumeroCandidato()));
                    txtPartido.setText(candidato.getPartidoCandidato());
                }
            }
        });

        criarForm();
        formatCampo();
    }

    public void setNomeCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    private void criarForm() {
        JLabel label;

        label = new JLabel("ID");
        adicionarComponente(label, 0, 0);
        txtId = new JTextField(5);
        txtId.setEditable(false);
        adicionarComponente(txtId, 1, 0);

        label = new JLabel("Candidato");
        adicionarComponente(label, 2, 0);
        txtNome = new JTextField(30);
        adicionarComponente(txtNome, 3, 0);

        label = new JLabel("Numero");
        adicionarComponente(label, 4, 0);
        txtNumero = new JFormattedTextField();
        adicionarComponente(txtNumero, 5, 0);
        
        label = new JLabel("Partido");
        adicionarComponente(label, 6, 0);
        txtPartido = new JTextField(30);
        adicionarComponente(txtPartido, 7, 0);

        criarBotoes();
    }

    private void criarBotoes() {
        JPanel btnPanel = new JPanel();
        FlowLayout flowLayout = (FlowLayout) btnPanel.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);

        criarBtnSalvar(btnPanel);
        criarBtnCancelar(btnPanel);

        adicionarComponente(btnPanel, 8, 0, 2, 1);

        
    }

    private void criarBtnSalvar(JPanel btnPanel) {
        btnSalvar = new JButton("Salvar");      
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (CandidatoFormPanel.this.candidato == null) {
                    Candidato novoCandidato = new Candidato();
                    novoCandidato.setNomeCandidato(txtNome.getText());
                    novoCandidato.setNumeroCandidato(Integer.parseInt(txtNumero.getText()));
                    novoCandidato.setPartidoCandidato(txtPartido.getText());

                    CandidatoStorage.inserir(novoCandidato);
                    JOptionPane.showMessageDialog(CandidatoFormPanel.this, 
                                                  "Candidato incluido com sucesso", 
                                                  "Todo App", 
                                                  JOptionPane.INFORMATION_MESSAGE);
                } else {
                    candidato.setNomeCandidato(txtNome.getText());
                    candidato.setNumeroCandidato(Integer.parseInt(txtNumero.getText()));
                    candidato.setPartidoCandidato(txtPartido.getText());
                    CandidatoStorage.atualizar(CandidatoFormPanel.this.candidato);
                    JOptionPane.showMessageDialog(CandidatoFormPanel.this, 
                                                  "Candidato atualizado com sucesso", 
                                                  "Todo App", 
                                                  JOptionPane.INFORMATION_MESSAGE);
                }

                    
                frame.mostrarCandidatoListPanel();
            }
        });
        btnPanel.add(btnSalvar);
    }

    private void criarBtnCancelar(JPanel btnPanel) {
        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.mostrarCandidatoListPanel();
            }
        });
        btnPanel.add(btnCancelar);
    }

    private void habilitarBtns() {
        btnSalvar.setEnabled(true);
    }

    private void desabilitarBtns() {
        btnSalvar.setEnabled(false);
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

    private void formatCampo () {
        try {
            MaskFormatter mask = new MaskFormatter("##");
            mask.install(txtNumero);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

} // fim da classe TarefaFormPanel
