package com.example.score2;

public class User {
    private String key  ;
    private String name ;
    private String password ;
    private String win ;
    private String lose ;
    private String draw ;
    private String goal ;
    private String goalIn ;
    private String cleansheets ;
    private String image ;
    private String matchs;
    private String points ;
    private String rank ;
    private String request ;


    public User(){}

    public User(String name , String password , String key){
        this.key = key ;
        this.name = name ;
        this.password = password ;
        win = "0"  ;
        lose = "0" ;
        draw = "0" ;
        goal = "0" ;
        goalIn = "0" ;
        cleansheets = "0" ;
        image = "";
        matchs = " ";
        points = "0";
        rank = "0";
        request = " ";
    }

    public String getWin() {
        return win;
    }

    public void setWin(String win) {
        this.win = win;
    }

    public String getLose() {
        return lose;
    }

    public void setLose(String lose) {
        this.lose = lose;
    }

    public String getDraw() {
        return draw;
    }

    public void setDraw(String draw) {
        this.draw = draw;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getGoalIn() {
        return goalIn;
    }

    public void setGoalIn(String goalIn) {
        this.goalIn = goalIn;
    }

    public String getCleansheets() {
        return cleansheets;
    }

    public void setCleansheets(String cleansheets) {
        this.cleansheets = cleansheets;
    }

    public String getMatchs() {
        return matchs;
    }

    public void setMatchs(String matchs) {
        this.matchs = matchs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

}
