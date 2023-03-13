package com.example.demo;

import com.example.demo.views.Territory;

import java.util.ArrayList;

public class INExp {
    private Territory territory;
    private ArrayList<Player> players;
    private int currentPlayerIndex;

    public INExp(Territory territory, ArrayList<Player> players) {
        this.territory = territory;
        this.players = players;
        this.currentPlayerIndex = 0;
    }
    public void play(int rowIndex, int colIndex) {

        Player currentPlayer = players.get(currentPlayerIndex);
    }
        /*if (currentPlayer.ownsRegion(region)) {

        } else {
            currentPlayer.buyRegion(region);
            if (currentPlayer.hasWon()) {

            } else {
                currentPlayerIndex = (currentPlayerIndex + 1) % players.size();

            }
    }**/
}
