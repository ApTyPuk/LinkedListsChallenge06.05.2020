package com.Artur;

import java.util.LinkedList;

import static com.Artur.Album.albums;

public class PlayList {

    private static LinkedList<Song> playList;

    public PlayList() {
        playList = new LinkedList<Song>();
    }

    public static LinkedList<Song> getPlayList() {
        return playList;
    }


    public void addSongToPlayList(String nameSong){
        Song song = returnSong(nameSong);
//        System.out.println(song.getTitle() + " - Trying to add to PlayList!!!!!!!!");
        if(returnSongsAlbum(nameSong) != null){
            playList.add(song);
//            System.out.println(song.getTitle() +" -> added to PlayList.");
        }
    }

    public Song returnSong(String nameSong){
        for(int i = 0; i < albums.size(); i++){
            Album album = albums.get(i);

            for(int j = 0; j < album.getSongList().size(); j++){
                Song song = album.getSongList().get(j);
                if(song.getTitle() == nameSong){
//                    System.out.println("\nSong "+nameSong+" IS IN ALBUM: " + album.getAlbumName() );
                    return song;
                }
            }
        }
//        System.out.println("\nSong not found.");
        return null;
    }

    public Album returnSongsAlbum(String nameSong){
            for(int i = 0; i < albums.size(); i++){
                Album album = albums.get(i);

                for(int j = 0; j < album.getSongList().size(); j++){
                    Song song = album.getSongList().get(j);
                    if(song.getTitle() == nameSong){
//                        System.out.println("\nSong '"+nameSong+"' IS IN ALBUM: " + album.getAlbumName() );
                        return album;
                    }
                }
            }
//        System.out.println("\nSong not found.");
        return null;
    }

    public void printPlayList(){
        System.out.println("\nPlaylist song list:");
        for(int i = 0; i< playList.size(); i++){
            Song song = playList.get(i);
            System.out.println("    "+(i+1)+". '"+song.getTitle()+"' from album: "+ returnSongsAlbum(song.getTitle()).getAlbumName());
        }
    }

}
