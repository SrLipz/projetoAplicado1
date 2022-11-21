import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;


public class InicialPanel extends JPanel {
    
    private AppFrame frame;

    private JButton btnCandidato;
    private JButton btnPesquisa;
    private JButton btnDesempenho;

    public InicialPanel(AppFrame frame){
        this.frame = frame;

        setLayout(new BorderLayout());        

        criarComandosPanel();
    }

    private void criarComandosPanel(){
        JPanel panel = new JPanel();

        FlowLayout layout = (FlowLayout) panel.getLayout();
        layout.setAlignment(FlowLayout.CENTER);

        criarBtnCandidato();
        panel.add(btnCandidato);

        criarBtnPesquisa();
        panel.add(btnPesquisa);

        criarBtnDesempenho();
        panel.add(btnDesempenho);

        add(panel, BorderLayout.CENTER);
    }

    private void criarBtnCandidato(){
        btnCandidato = new JButton("Candidato");
        btnCandidato.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.mostrarCandidatoListPanel();
            }
        });
    }

    private void criarBtnPesquisa(){
        btnPesquisa = new JButton("Pesquisa");
        btnPesquisa.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.mostrarPesquisaListPanel();
            }
        });
    }

    private void criarBtnDesempenho(){
        btnDesempenho = new JButton("Desempenho");
        btnDesempenho.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.mostrarDesemepenhoFormPanel();
            }
        });
    }
 
}