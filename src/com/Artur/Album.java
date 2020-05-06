package com.Artur;

import java.util.ArrayList;


public class Album {
    public static ArrayList<Album> albums = new ArrayList<Album>();

    private String nameAlbum;
    private ArrayList<Song> songArrayList;


    public Album(String name) {
        this.nameAlbum = name;
        this.songArrayList = new ArrayList<Song>();
    }

    public String getAlbumName() {
        return nameAlbum;
    }

    public ArrayList<Song> getSongArrayList() {
        return songArrayList;
    }

    public static Album addAlbum(String nameAlbum){
        Album album = new Album(nameAlbum);
        albums.add(album);
        return album;
    }
//    public void addAlbumToAlbumList(String nameAlbum){
//        Album album = findAlbum(nameAlbum);
//        albums.add(album);
//    }

    public boolean addSongToAlbum(Song nameSong){
//        Song song = findSong(nameSong);
        if(nameSong != null){
            this.songArrayList.add(nameSong);
            return true;
        }
        return false;
    }

//    public boolean addSongToAlbum(String nameAlbum, String nameSong){
//        if((findAlbum(nameAlbum) != null) && (findSong(nameSong) != null)){
//            findAlbum(nameAlbum).getAlbumSongsArray().add(findSong(nameSong));
//            System.out.println("Song added to Album");
//            return true;
//        }
//        return false;
//    }

    public void printAlbumSongs(){
        System.out.println("Printing song list for album: " + getAlbumName());

        for(int i = 0; i<this.songArrayList.size(); i++){
            System.out.println("    "+ (i+1) + ". " + this.songArrayList.get(i).getTitle());
        }

    }

    public Album ifSongInAlbum(String nameSong){
        if(findSong(nameSong) != null){
            for(int i = 0; i < albums.size(); i++){
                Album album = albums.get(i);
                System.out.println(album.getAlbumName());

                for(int j = 0; j < this.songArrayList.size(); j++){
                    Song song = this.songArrayList.get(j);
                    if(song.getTitle() == nameSong){
                        System.out.println("Song "+nameSong+" IS IN ALBUM");
                        return album;
                    }

                }

            }
        }
        return null;
    }

    public Album findAlbum(String nameAlbum){
        for(int i =0; i<albums.size(); i++){
            Album album = albums.get(i);
            if(album.getAlbumName() == nameAlbum ){
                System.out.println("Album '"+nameAlbum+"'found");
                return album;
            }
        }
        return null;
    }

    public Song findSong(String nameSong){
        for(int i = 0; i<this.songArrayList.size(); i++){
            Song song = this.songArrayList.get(i);
            if(song.getTitle() == nameSong){
                return song;
            }
        }
        return null;
    }






}
