package com.example.demo.views;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Territory {
    private int m, n;
    private ArrayList<ArrayList<Integer>> regions;
    private int currentArea;
    private int[][] owner;
    public Territory(int m, int n) {
        this.m = m;

        this.n = n;
        regions = new ArrayList<ArrayList<Integer>>(m);
        for (int i = 0; i < m; i++) {
            ArrayList<Integer> row = new ArrayList<Integer>(n);
            for (int j = 0; j < n; j++) {
                row.add(0);
            }
            regions.add(row);
        }
        this.currentArea = 0;
    }

    public void loadFromFile(String filename) throws FileNotFoundException {
        File file = new File(filename);

        Scanner scanner = new Scanner(file);

        // Read the first line containing m and n
        m = scanner.nextInt();
        n = scanner.nextInt();

        // Initialize the ArrayList with 0s
        regions = new ArrayList<ArrayList<Integer>>(m);
        for (int i = 0; i < m; i++) {
            ArrayList<Integer> row = new ArrayList<Integer>(n);
            for (int j = 0; j < n; j++) {
                row.add(0);
            }
            regions.add(row);
        }
    }


    public int getOwner(int row, int col) {
        return owner[row][col];
    }

    public void setOwner(int row, int col, int playerId) {
        owner[row][col] = playerId;
    }


}

