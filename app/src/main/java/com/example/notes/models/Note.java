package com.example.notes.models;

public class Note {
    private int id;
    private String title;
    private String text;

    public Note(){}

    public Note(int id,String title,String body){
        this.id = id;
        this.title = title;
        this.text = body;
    }

    public Note(String title,String body){
        this.title = title;
        this.text = body;
    }

    public int id() {
        return id;
    }

    public String title() {
        return title;
    }

    public String body() {
        return text;
    }


    public void id(int id) {
        this.id = id;
    }

    public void title(String title) {
        this.title = title;
    }

    public void body(String body) {
        this.text = body;
    }
}
