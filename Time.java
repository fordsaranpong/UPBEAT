package com.example.demo;

public class Time {
    private String playerName;
    private long startTime;
    private long timeLeft;
    private boolean isPlaying;

    public Time(String playerName, long startTime, long timeLimit) {
        this.playerName = playerName;
        this.startTime = startTime;
        this.timeLeft = timeLimit;
        this.isPlaying = true;
    }   public String getPlayerName() {
        return playerName;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getTimeLeft() {
        return timeLeft;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setTimeLeft(long timeLeft) {
        this.timeLeft = timeLeft;
    }

    public void setIsPlaying(boolean isPlaying) {
        this.isPlaying = isPlaying;
    }

    public boolean isTimeUp() {
        return System.currentTimeMillis() - startTime >= timeLeft;
    }
}