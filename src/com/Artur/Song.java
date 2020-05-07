package com.Artur;

public class Song {
    private String title;
    private String duration;

    public Song(String title, String duration) {
        this.title = title;
        this.duration = duration;
    }

//    public static Song addSong(String title, String duration){
//        Song song = new Song(title, duration);
//        System.out.println(song.getTitle()+ " -> song created.");
//        return song;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
