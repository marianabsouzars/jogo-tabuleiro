package br.edu.uniritter.canoas.poo.jogo.view;

import java.util.Random;

import br.edu.uniritter.canoas.poo.jogo.model.Tabuleiro;

public class TabuleiroView {
    public static void showSituacaoAtual(Tabuleiro tab, int jogadorAtual){
        //for (int i = 0; i < tab.getQtdCasas(); i++) {
            //if (tab.getCasaOcupada(i) != null) {
            //    System.out.println("casa "+i+": "+tab.getCasaOcupada(i)+" ->"+tab.getJogadoresCasa(i));
            //}
            //CasaView.desenhaCasa(tab.getCasa(i), tab.getJogadoresCasa(i));
        //}
        
        Random random = new Random();
        int indice = random.nextInt(tab.getQtdCasas());          
        
        CasaView.desenhaCasa(tab.getCasa(indice), tab.getJogadoresCasa(indice));
        
        if(tab.getJogador(jogadorAtual) != null) {
        	tab.getJogador(jogadorAtual).setQtdCasas(tab.getJogador(jogadorAtual).getQtdCasas() + tab.getCasa(indice).getIncremento());
        }                            
        
        System.out.println("============");
        JogoView.continuar();
    }
}
