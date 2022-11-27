/*import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class CandidatoComboBoxModel extends AbstractListModel implements ComboBoxModel{

    private List<Candidato> listCandidato;
    private Candidato candidatoSelecionado;

    public CandidatoComboBoxModel() {
        this.listCandidato = new ArrayList<>();
    }

    @Override
    public Object getSelectedItem() {
        
        return this.candidatoSelecionado;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        if(anItem instanceof Candidato) {
            this.candidatoSelecionado = (Candidato) anItem;
            fireContentsChanged(this.listCandidato, 0, this.listCandidato.size());
        }
    }

    @Override
    public Object getElementAt(int index) {
        return this.listCandidato.get(index);
    }

    @Override
    public int getSize() {
        return listCandidato.size();
    }
    
    public void addCandidatos(Candidato candidato) {
        this.listCandidato.add(candidato);
    }

}*/
