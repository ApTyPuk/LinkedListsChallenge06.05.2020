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

//    public void addAlbumToAlbumList(){
//        Album album = findAlbum(getAlbumName());
//        albums.add(album);
//    }

    public void addSongToAlbum(Song nameSong){
        this.songArrayList.add(nameSong);
//        System.out.println(nameSong.getTitle() + " Added to Album -> "+ this.nameAlbum );
    }


    public boolean createSongAddToAlbum(String title, String duration){
        Album album = findAlbum(getAlbumName());
        if(findAlbum(getAlbumName()) != null){
            Song song = new Song(title, duration);
            album.getSongArrayList().add(song);
//            System.out.println(title + " -> song added to album -> " + album.getAlbumName());
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

    public static void printAlbumList(){
        for(int i = 0; i < albums.size(); i++){
            System.out.println(albums.get(i).getAlbumName());
        }
    }

    public void printAlbumSongs(){
        System.out.println("\nPrinting song list for album: " + getAlbumName());

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

    public static Album findAlbum(String nameAlbum){
        for(int i =0; i<albums.size(); i++){
            Album album = albums.get(i);
            if(album.getAlbumName() == nameAlbum ){
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
