public class Candidato {
    
    private int idCandidato;
    private String nomeCandidato;
    private String numeroCandidato;
    private String partidoCandidato;

    public int getIdCandidato() {
        return idCandidato;
    }

    public void setIdCandidato(int idCandidato) {
        this.idCandidato = idCandidato;
    }

    public String getNomeCandidato() {
        return nomeCandidato;
    }

    public void setNomeCandidato(String nomeCandidato) {
        this.nomeCandidato = nomeCandidato;
    }

    public String getNumeroCandidato() {
        return numeroCandidato;
    }

    public void setNumeroCandidato(String numeroCandidato) {
        this.numeroCandidato = numeroCandidato;
    }

    public String getPartidoCandidato() {
        return partidoCandidato;
    }

    public void setPartidoCandidato(String partidoCandidato) {
        this.partidoCandidato = partidoCandidato;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        Candidato outroCandidato = (Candidato) obj;
        return idCandidato == outroCandidato.getIdCandidato();
    }
    
} // fim da classe Tarefa
