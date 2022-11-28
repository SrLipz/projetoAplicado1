public class Pesquisa {
    
    private int idPesquisa;
    private int idCandidato;
    private int intencaoVotos;
    private String fontePesquisa;
    private int mesPesquisa;
    private int anoPesquisa;

    public int getIdPesquisa() {
        return idPesquisa;
    }

    public void setIdPesquisa(int idPesquisa) {
        this.idPesquisa = idPesquisa;
    }

    public int getIdCandidato() {
        return idCandidato;
    }

    public void setIdCandidato(int idCandidato) {
        this.idCandidato = idCandidato;
    }

    public int getIntencaoVotos() {
        return intencaoVotos;
    }

    public void setIntencaoVotos(int intencaoVotos) {
        this.intencaoVotos = intencaoVotos;
    }

    public String getFontePesquisa() {
        return fontePesquisa;
    }

    public void setFontePesquisa(String fontePesquisa) {
        this.fontePesquisa = fontePesquisa;
    }

    public int getMesPesquisa() {
        return mesPesquisa;
    }

    public void setMesPesquisa(int mesPesquisa) {
        this.mesPesquisa = mesPesquisa;
    }

    public int getAnoPesquisa() {
        return anoPesquisa;
    }

    public void setAnoPesquisa(int anoPesquisa) {
        this.anoPesquisa = anoPesquisa;
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

        Pesquisa outraPesquisa = (Pesquisa) obj;
        return idPesquisa == outraPesquisa.getIdPesquisa() ;
    }
    
} // fim da classe Pesquisa