package model;

import dto.FilmeDTO;

public class Filme {
    private final String NOME;
    private final int ANO_LANCAMENTO;
    private final int DURACAO;

    public Filme(FilmeDTO filmeDTO) {
        if(filmeDTO.title() == null) {
            throw new NullPointerException("O filme não existe.");
        }
        this.NOME = filmeDTO.title();
        this.ANO_LANCAMENTO = Integer.parseInt(filmeDTO.year().substring(0, 4)) ;
        if(filmeDTO.runtime().equals("N/A")) {
            this.DURACAO = 0;
            return;
        }
        this.DURACAO = Integer.parseInt(filmeDTO.runtime().substring(0, 3));
        toHours();
    }

    // classificação de idade por ano de lançamento
    private String sortByRelease() {
        if(ANO_LANCAMENTO < 2000) {
            return "Filme muito antigo";
        } else if(ANO_LANCAMENTO < 2015) {
            return "Filme antigo";
        } else {
            return "Filme recente";
        }
    }

    private String toHours() {
        if(this.DURACAO == 0) {
            return "Duração: N/A";
        }
        double duracaoHoras = Math.round((double)DURACAO/60);
        return DURACAO +"min | ~" + duracaoHoras + "h";
    }

    @Override
    public String toString() {
        return "Nome: "+NOME+
                "\nAno de lançamento: "+ANO_LANCAMENTO+
                "\n"+toHours()+
                "\nClassificação: "+sortByRelease();
    }


}
