package com.example.score2;

public class Match {
    private String date ;
    private String player1 ;
    private String player1Goals ;
    private String player1Image ;
    private String player2 ;
    private String player2Goals ;
    private String player2Image ;
    private String requestsOfPlayer2 ;

    public Match(){

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {this.date = date;}

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer1Goals() {
        return player1Goals;
    }

    public void setPlayer1Goals(String player1Goals) {
        this.player1Goals = player1Goals;
    }

    public String getPlayer1Image() {
        return player1Image;
    }

    public void setPlayer1Image(String player1Image) {
        this.player1Image = player1Image;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public String getPlayer2Goals() {
        return player2Goals;
    }

    public void setPlayer2Goals(String player2Goals) {
        this.player2Goals = player2Goals;
    }

    public String getPlayer2Image() {
        return player2Image;
    }

    public void setPlayer2Image(String player2Image) {
        this.player2Image = player2Image;
    }

    public String getRequestsOfPlayer2() {
        return requestsOfPlayer2;
    }

    public void setRequestsOfPlayer2(String requestsOfPlayer2) {
        this.requestsOfPlayer2 = requestsOfPlayer2;
    }
}
