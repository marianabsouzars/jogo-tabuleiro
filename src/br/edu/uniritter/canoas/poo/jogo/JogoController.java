package br.edu.uniritter.canoas.poo.jogo;

import br.edu.uniritter.canoas.poo.jogo.model.Jogador;
import br.edu.uniritter.canoas.poo.jogo.model.MuitosJogadoresException;
import br.edu.uniritter.canoas.poo.jogo.model.Tabuleiro;
import br.edu.uniritter.canoas.poo.jogo.view.JogoView;
import br.edu.uniritter.canoas.poo.jogo.view.TabuleiroView;

public class JogoController {
    private static int qtdJogadores;
    private static Tabuleiro tabuleiro;
    private static int jogadorAtual = 0;
    private static boolean finalizado = false;
    private static int qtdCasas = 10;

    public static void iniciarJogo() {
        tabuleiro = new Tabuleiro(qtdCasas,60,20);
        qtdJogadores = JogoView.intQtdJogadores(2, 6);
        registrarJogadores();

       while(! finalizado) {
           iniciarJogada();
           proximoJogador();
           TabuleiroView.showSituacaoAtual(tabuleiro, jogadorAtual);
           
           for(Jogador j :tabuleiro.getJogadores()) {
        	   if(j.getQtdCasas() == qtdCasas) {
        		   finalizado = true;
        		   System.out.println("jogador vencedor!!!! "+ j.getNome());
        	   }
           }
       }

    }
    private static void proximoJogador() {
        jogadorAtual++;
        if(jogadorAtual == qtdJogadores) {
            jogadorAtual = 0;
        }
    }
    public static void registrarJogadores() {
        for (int i = 1; i <= qtdJogadores; i++) {
            String n = JogoView.InformeJogador(i);
            try {
                tabuleiro.addJogador(new Jogador(n));
            } catch (MuitosJogadoresException e) {
                e.printStackTrace();
            }
        }
    }
    private static void iniciarJogada() {
        JogoView.mostraJogadorAtual(tabuleiro.getJogadores().get(jogadorAtual));
    }

    public static void iniciarJogoOld() {
        Tabuleiro tab = new Tabuleiro(50,20,20);
        try {
            tab.addJogador(new Jogador("Jean1"));
            tab.addJogador(new Jogador("Jean2"));
            Jogador a = null;
            try {
                a.getNome();
            } catch (NullPointerException e) {
                System.out.println("ops, tu tentou usar um null como jogador");
            }

            tab.addJogador(new Jogador("Jean3"));
            tab.addJogador(new Jogador("Jean4"));
            tab.addJogador(new Jogador("Jean5"));

            tab.addJogador(new Jogador("Jean6"));
            tab.addJogador(new Jogador("Jean7"));
        } catch (MuitosJogadoresException e) {
            System.out.println(e.getMessage());
        }
         catch (NullPointerException e) {
            System.out.println("ops, tu tentou usar um null como jogador");
        }
        finally {
            System.out.println("depois de tudo");
        }
        for(int i = 0; i < tab.getJogadores().size(); i++) {
            System.out.println(tab.getJogadores().get(i));
        }
    }
}
