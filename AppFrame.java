import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AppFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;

    private CandidatoListPanel candidatoPanel;
    private CandidatoFormPanel candidatoFormPanel;
    private InicialPanel inicialPanel;
    private PesquisaListPanel pesquisaPanel;
    private PesquisaFormPanel pesquisaForm;
    private DesempenhoFormPanel desempenhoFormPanel;
    private DesempenhoListPanel desempenhoListPanel;

    public AppFrame() {
        super("Todo App");

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

        pesquisaPanel = new PesquisaListPanel(this);
        cardPanel.add(pesquisaPanel, PesquisaListPanel.class.getName());

        pesquisaForm = new PesquisaFormPanel(this);
        cardPanel.add(pesquisaForm, PesquisaFormPanel.class.getName()); 

        candidatoPanel = new CandidatoListPanel(this);
        cardPanel.add(candidatoPanel, CandidatoListPanel.class.getName());

        candidatoFormPanel = new CandidatoFormPanel(this);
        cardPanel.add(candidatoFormPanel, CandidatoFormPanel.class.getName());

        desempenhoFormPanel = new DesempenhoFormPanel(this);
        cardPanel.add(desempenhoFormPanel, DesempenhoFormPanel.class.getName());

        desempenhoListPanel = new DesempenhoListPanel(this);
        cardPanel.add(desempenhoListPanel, DesempenhoListPanel.class.getName());

    }

    public void mostrarCandidatoFormPanel(Candidato candidato) {
        candidatoFormPanel.setCandidato(candidato);
        cardLayout.show(cardPanel, CandidatoFormPanel.class.getName());
    }

    public void mostrarCandidatoListPanel() {
        candidatoPanel.recarregar();
        cardLayout.show(cardPanel, CandidatoListPanel.class.getName());
    }

    public void mostrarInicialPanel() {
        cardLayout.show(cardPanel, InicialPanel.class.getName());
    }

    public void mostrarPesquisaListPanel() {
        pesquisaPanel.recarregar();
        cardLayout.show(cardPanel, PesquisaListPanel.class.getName());
    }

    public void mostrarPesquisaForm(Pesquisa pesquisa) {
        pesquisaForm.setPesquisa(pesquisa);
        cardLayout.show(cardPanel, PesquisaFormPanel.class.getName());
    }

    public void mostrarDesempenhoListPanel() {
        //desempenhoListPanel.recarregar();
        cardLayout.show(cardPanel, DesempenhoListPanel.class.getName());
    }

    public void mostrarDesemepenhoFormPanel (Pesquisa pesquisa) {
        pesquisaForm.setPesquisa(pesquisa);
        cardLayout.show(cardPanel, DesempenhoFormPanel.class.getName());
    }

} // fim da classe AppFrame