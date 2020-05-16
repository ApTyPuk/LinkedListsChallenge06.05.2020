package com.Artur;

import java.util.ArrayList;
import java.util.List;

public class Album {
    public static ArrayList<Album> albums = new ArrayList<Album>();

    private String nameAlbum;
    private Album.SongList songList;

    public Album(String name) {
        this.nameAlbum = name;
        this.songList = new Album.SongList();

    }

    public String getAlbumName() {
        return nameAlbum;
    }

    public SongList getSongList() {
        return songList;
    }

    public static Album addAlbum(String nameAlbum){
        Album album = new Album(nameAlbum);
        albums.add(album);
        return album;
    }

    public void addSongToAlbum(Song nameSong){     //addSongToAlbum
        this.songList.addSong(nameSong);
//        System.out.println(nameSong.getTitle() + " Added to Album -> "+ this.nameAlbum );
    }


    public boolean createSongAddToAlbum(String title, String duration){
//        Album album = findAlbum(getAlbumName());
        if(findAlbum(getAlbumName()) != null){
            Song song = new Song(title, duration);
            this.songList.addSong(song);
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
        for (Album album : albums) {
            System.out.println(album.getAlbumName());
        }
    }

    public void printAlbumSongs(){
        System.out.println("\nPrinting song list for album: " + getAlbumName());
        for(int i = 0; i < this.songList.getSongList().size(); i++){
            System.out.println("    "+ (i+1) + ". " + this.songList.getSongList().get(i).getTitle());
        }

    }

    public Album ifSongInAlbum(String nameSong){
        if(findSong(nameSong) != null){
            for(int i = 0; i < albums.size(); i++){
                Album album = albums.get(i);
                System.out.println(album.getAlbumName());

                for(int j = 0; j < this.songList.getSongList().size(); j++){
                    Song song = this.songList.getSongList().get(j);
                    if(song.getTitle().equals(nameSong)){
                        System.out.println("Song "+nameSong+" IS IN ALBUM");
                        return album;
                    }

                }

            }
        }
        return null;
    }

    public static Album findAlbum(String nameAlbum){
        for(Album album: albums){
            if(album.getAlbumName().equals(nameAlbum)){
                return album;
            }
        }
//        for(int i =0; i<albums.size(); i++){
//            Album album = albums.get(i);
//            if(album.getAlbumName() == nameAlbum ){
//                return album;
//            }
//        }
        return null;
    }

    public Song findSong(String nameSong){
        if(this.songList.findSong(nameSong) != null){
            return this.songList.findSong(nameSong);
        }
        return null;
    }





    public class SongList {
        public List<Song> songList = new ArrayList<Song>();

        public List<Song> getSongList() {
            return songList;
        }

        public void addSong(Song nameSong) {
            this.songList.add(nameSong);
        }

        public Song findSong(String nameSong) {
            for(Song checkSong: this.songList){
                if(checkSong.getTitle().equals(nameSong)){
                    return checkSong;
                }
            }
            return null;
        }
    }








}
