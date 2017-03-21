package com;

import java.util.Scanner;

public class Game {
    private Player dealer;
    private Player player;

    private Deck deck;

    Game() {
        dealer = new Player();
        player = new Player();
    }

    public boolean init() {
        deck = new Deck();
        deck.shuffle();

        dealer.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());
        player.addCard(deck.dealCard());
        player.addCard(deck.dealCard());

        System.out.println("dealer has: [" + dealer.getCard(0) + ", HiddenCard]");
        System.out.println("you have: " + player.getScore() + " " + player.getCards());

        if (player.getScore() == 21) {
            return true;
        }

        if (dealer.getScore() == 21) {
            System.out.println("dealer wins with " + dealer.getCards());
            return true;
        }
        return false;
    }

    boolean playerStage() {
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("Hit or stop? h/s : ");
            char c = Character.toLowerCase(input.next().charAt(0)); // getting a char value
            if (c == 's') {
                break;
            } else if (c == 'h') {
                Card card = deck.dealCard();
                player.addCard(card);
                System.out.println("new card: " + card);
                System.out.println("you have " + player.getScore() + player.getCards());
            }

            if (player.getScore() > 21) {
                System.out.println("busted!");
                return false;
            }

        }
        return true;
    }

    boolean dealerStage() {
        System.out.println("dealer's turn");
        System.out.println("dealer has " + dealer.getScore() + dealer.getCards());

        while (dealer.getScore() < 17) {
            Card card = deck.dealCard();
            dealer.addCard(card);
            System.out.println("dealer draws card " + card + " having a total of: " + dealer.getScore());
            if (dealer.getScore() > 21) {
                System.out.println("you win, dealer has " + dealer.getScore());
                return false;
            }
        }
        return true;
    }

    void result() {
        int diff = player.getScore() - dealer.getScore();
        if (diff > 0) {
            System.out.println("you win with " + player.getScore());
        } else if (diff < 0) {
            System.out.println("dealer wins with " + dealer.getScore());

        } else {
            System.out.println("draw");
        }
    }


}
