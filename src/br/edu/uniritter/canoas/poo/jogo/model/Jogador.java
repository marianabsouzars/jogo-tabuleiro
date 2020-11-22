package br.edu.uniritter.canoas.poo.jogo.model;

public class Jogador {
    private String nome;
    private int posicaoAtual;
    private int qtdCasas = 0;

    public Jogador(String nome) {
        this.nome = nome;
        this.posicaoAtual = -1;
    }
    
    public void setQtdCasas(int qtdCasas) {
		this.qtdCasas = qtdCasas;
	}
    
    public int getQtdCasas() {
		return qtdCasas;
	}

    public String getNome() {
        return nome;
    }

    public int getPosicaoAtual() {
        return posicaoAtual;
    }
    public void avanca(int qtd) {
        this.posicaoAtual += qtd;
    }

    @Override
    public String toString() {
        return "Jogador: "+nome;
    }


}
