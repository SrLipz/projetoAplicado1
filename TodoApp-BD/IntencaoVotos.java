public class IntencaoVotos {

    private int idCandidato;
    private int idPesquisa;
    private int dia;
    private int mes;
    private int intencao;

    public int getIdCandidato() {
        return idCandidato;
    }
    public void setIdCandidato(int idCandidato) {
        this.idCandidato = idCandidato;
    }
    public int getIdPesquisa() {
        return idPesquisa;
    }
    public void setIdPesquisa(int idPesquisa) {
        this.idPesquisa = idPesquisa;
    }
    public int getDia() {
        return dia;
    }
    public void setDia(int dia) {
        this.dia = dia;
    }
    public int getMes() {
        return mes;
    }
    public void setMes(int mes) {
        this.mes = mes;
    }
    public int getIntencao() {
        return intencao;
    }
    public void setIntencao(int intencao) {
        this.intencao = intencao;
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

        IntencaoVotos outraIntencao = (IntencaoVotos) obj;
        return idCandidato == outraIntencao.getIdCandidato() && idPesquisa == outraIntencao.getIdPesquisa();
    }

}
