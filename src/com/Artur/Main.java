package com.Artur;

import static com.Artur.Album.albums;

public class Main {

    public static void main(String[] args) {
        Album vesna = new Album("VESNA");
        Album osen = new Album("OSEN");
//        Album.addAlbum("VESNA");

        Song song1 = new Song("Nebesa", "2:35");
        Song song2 = new Song("Chudo", "1:24");

//        Song.addSong("Nebesa", "2:35");
//        Song.addSong("Chudo", "1:24");
//        Song.addSong("Nevesta", "9:58");
//        Song.addSong("Sobibor", "6:25");

        vesna.addSongToAlbum(song1);
        vesna.addSongToAlbum(song2);


        vesna.findSong("Nebesa");
        vesna.findSong("Chudo");
        vesna.findSong("Nevesta");

        vesna.printAlbumSongs();
        osen.printAlbumSongs();

        vesna.ifSongInAlbum("Nebesa");

        PlayList playlist = new PlayList();
        playlist.returnSongsAlbum("Nebesa");

        albums.add(vesna);

        playlist.returnSongsAlbum("Nebesa");


    }
}
