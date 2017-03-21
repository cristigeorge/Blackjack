package com;


public class Main {

    public static void main(String args[]) {
        Game g = new Game();
        boolean firstStage = g.init(); //false: nobody wins
        if (firstStage) {
            //if someone wins, end game
            return;
        }
        boolean playerWins = g.playerStage();  //false : you lose; true : continue game
        if (!playerWins) {
            return;
        }
        boolean dealerWins = g.dealerStage(); //false : dealer loses; true : continue game
        if (!dealerWins) {
            return;
        }
        g.result();
    }

}
