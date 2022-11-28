import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AppFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;

    private CandidatoListPanel candidatoListPanel;
    private CandidatoFormPanel candidatoFormPanel;
    private InicialPanel inicialPanel;
    private PesquisaListPanel pesquisaListPanel;
    private PesquisaFormPanel pesquisaFormPanel;
    private DesempenhoListPanel desempenhoListPanel;

    public AppFrame() {
        super("ELEICOES BRASIL 2022");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        cardLayout = new CardLayout();
        cardPanel = new JPanel();
        cardPanel.setLayout(cardLayout);
        add(cardPanel);

        criarCards();
    }

    public void mostrar() {
        pack();
		setLocationRelativeTo(null);
		setVisible(true);
    }

    private void criarCards() {

        inicialPanel = new InicialPanel(this);
        cardPanel.add(inicialPanel, InicialPanel.class.getName());

        pesquisaListPanel = new PesquisaListPanel(this);
        cardPanel.add(pesquisaListPanel, PesquisaListPanel.class.getName());

        pesquisaFormPanel = new PesquisaFormPanel(this);
        cardPanel.add(pesquisaFormPanel, PesquisaFormPanel.class.getName()); 

        candidatoListPanel = new CandidatoListPanel(this);
        cardPanel.add(candidatoListPanel, CandidatoListPanel.class.getName());

        candidatoFormPanel = new CandidatoFormPanel(this);
        cardPanel.add(candidatoFormPanel, CandidatoFormPanel.class.getName());

        desempenhoListPanel = new DesempenhoListPanel(this);
        cardPanel.add(desempenhoListPanel, DesempenhoListPanel.class.getName());

    }

    public void mostrarCandidatoFormPanel(Candidato candidato) {
        candidatoFormPanel.setCandidato(candidato);
        cardLayout.show(cardPanel, CandidatoFormPanel.class.getName());
    }

    public void mostrarCandidatoListPanel() {
        candidatoListPanel.recarregar();
        cardLayout.show(cardPanel, CandidatoListPanel.class.getName());
    }

    public void mostrarInicialPanel() {
        cardLayout.show(cardPanel, InicialPanel.class.getName());
    }

    public void mostrarPesquisaListPanel() {
        pesquisaListPanel.recarregar();
        cardLayout.show(cardPanel, PesquisaListPanel.class.getName());
    }

    public void mostrarPesquisaFormPanel(Pesquisa pesquisa) {
        pesquisaFormPanel.setPesquisa(pesquisa);
        cardLayout.show(cardPanel, PesquisaFormPanel.class.getName());
    }

    public void mostrarDesempenhoListPanel() {
        desempenhoListPanel.recarregar();
        cardLayout.show(cardPanel, DesempenhoListPanel.class.getName());
    }

} // fim da classe AppFrame