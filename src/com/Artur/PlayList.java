package com.Artur;

import java.util.LinkedList;

import static com.Artur.Album.albums;

public class PlayList {

    private static LinkedList<Song> playList = new LinkedList<Song>();

    public boolean addSongToPlayList(String nameSong){
        if(returnSongsAlbum(nameSong) != null){
            playList.add(song);
            return true;
        }

        return false;
    }

    public Album returnSongsAlbum(String nameSong){
            for(int i = 0; i < albums.size(); i++){
                Album album = albums.get(i);

                for(int j = 0; j < album.getSongArrayList().size(); j++){
                    Song song = album.getSongArrayList().get(j);
                    if(song.getTitle() == nameSong){
                        System.out.println("\nSong "+nameSong+" IS IN ALBUM: " + album.getAlbumName() );
                        return album;
                    }
                }

            }
        System.out.println("\nSong not found.");
        return null;
    }

}
