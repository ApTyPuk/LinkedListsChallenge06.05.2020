package com.Artur;

import static com.Artur.Album.*;

public class Main {

    public static void main(String[] args) {
        Album.addAlbum("VESNA");
        Album.addAlbum("OSEN");
        findAlbum("VESNA").createSongAddToAlbum("Nebesa", "2:35");
        findAlbum("VESNA").createSongAddToAlbum("Chudo", "1:24");
        findAlbum("VESNA").createSongAddToAlbum("Nevesta", "9:58");
        findAlbum("VESNA").createSongAddToAlbum("Sobibor", "6:25");
        findAlbum("OSEN").createSongAddToAlbum("Kolibelnaya", "4:06");

        Song song_stest = new Song("Zhopa_Noviy_Gog", "0:55");
        findAlbum("OSEN").addSongToAlbum(song_stest);

//        findAlbum("VESNA").printAlbumSongs();
//        findAlbum("OSEN").printAlbumSongs();

        PlayList playlist = new PlayList();
        playlist.addSongToPlayList("Nebesa");
        playlist.addSongToPlayList("Chudo");
        playlist.addSongToPlayList("Nevesta");
        playlist.addSongToPlayList("Sobibor");
        playlist.addSongToPlayList("Kolibelnaya");
        playlist.addSongToPlayList(song_stest.getTitle());
//        playlist.printPlayList();

    }

    public static void menu(){
        System.out.println("\nPlayer controls: \n"+
                "   1 - Quit \n"+
                "   2 - Next song. \n"+
                "   3 - Previous song. \n"+
                "   4 - Reply song. \n"+
                "   5 - Playlist songs. \n"+
                "   6 - Remove current song from playlist. ");
    }

}
