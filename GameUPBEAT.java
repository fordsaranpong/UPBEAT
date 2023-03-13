package com.example.demo;
import com.example.demo.views.Territory;

import java.util.ArrayList;
public class GameUPBEAT {


    private Territory territory;
    private ArrayList<Player> players;
    private int currentPlayerIndex;

    public GameUPBEAT(Territory territory, ArrayList<Player> players) {
        this.territory = territory;
        this.players = players;
        this.currentPlayerIndex = 0;
    }

    public void play(int rowIndex, int colIndex) {
        Player currentPlayer = players.get(currentPlayerIndex);
       /* HexRegion region = territory.getRegion(rowIndex, colIndex);
        if (currentPlayer.ownsRegion(region)) {
            System.out.println("You already own this region!");
        } else {
            currentPlayer.buyRegion(region);*/

        }
    }

