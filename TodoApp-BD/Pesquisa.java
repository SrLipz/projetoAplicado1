public class Pesquisa {
    
    private int idPesquisa;
    private String fontePesquisa;

    public int getIdPesquisa() {
        return idPesquisa;
    }

    public void setIdPesquisa(int idPesquisa) {
        this.idPesquisa = idPesquisa;
    }


    public String getFontePesquisa() {
        return fontePesquisa;
    }

    public void setFontePesquisa(String fontePesquisa) {
        this.fontePesquisa = fontePesquisa;
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
    
} // fim da classe Tarefa