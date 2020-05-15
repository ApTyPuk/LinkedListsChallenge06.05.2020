package com.Artur;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

import static com.Artur.Album.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Album.addAlbum("VESNA");
        Album.addAlbum("OSEN");
        findAlbum("VESNA").createSongAddToAlbum("Nebesa", "2:35");
        findAlbum("VESNA").createSongAddToAlbum("Chudo", "1:24");
        findAlbum("VESNA").createSongAddToAlbum("Nevesta", "9:58");
        findAlbum("VESNA").createSongAddToAlbum("Sobibor", "6:25");
        findAlbum("OSEN").createSongAddToAlbum("Kolibelnaya", "4:06");

        Song song_stest = new Song("Zhopa_Noviy_Gog", "0:55");
        findAlbum("OSEN").addSong(song_stest);

//        findAlbum("VESNA").printAlbumSongs();
//        findAlbum("OSEN").printAlbumSongs();

        PlayList playlist = new PlayList();
        playlist.addSongToPlayList("Nebesa");
        playlist.addSongToPlayList("Chudo");
        playlist.addSongToPlayList("Nevesta");
        playlist.addSongToPlayList("Sobibor");
        playlist.addSongToPlayList("Kolibelnaya");
        playlist.addSongToPlayList("Zhopa_Noviy_Gog");
//        playlist.printPlayList();

        playPlayList();

    }
    public static void playPlayList(){
        ListIterator<Song> iterator =  PlayList.getPlayList().listIterator();

        if (iterator.hasNext()){
            System.out.println("\nStart playing song: " + iterator.next().getTitle());
        }else{
            System.out.println("You reach end of playlist.");
        }

        menu();
        boolean quit = false;
        boolean goingForward = true;
        printAction();

        while(!quit){
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action){
                case 1:
                    System.out.println("Quitting...");
                    quit = true;
                    break;
                case 2:
                    if(!goingForward){
                        iterator.next();
                        goingForward = true;
                    }
                    if(iterator.hasNext()){
                        songNext();
                        System.out.println(iterator.next().getTitle());
                    }else{
                        System.out.println("Your reached end of playlist.");
                        goingForward = false;
                    }
                    printAction();
                    break;
                case 3:
                    if(goingForward){
                        iterator.previous();
                        goingForward = false;
                    }
                    if(iterator.hasPrevious()){
                        songPrevious();
                        System.out.println(iterator.previous().getTitle());
                    }else{
                        System.out.println("Your reached the beginning of playlist.");
                        goingForward = true;
                    }
                    printAction();
                    break;
                case 4:
                    songReplay();
                    if(goingForward){
                        iterator.previous();
                        System.out.println(iterator.next().getTitle());
                        goingForward = true;
                    }
                    if(!goingForward) {
                        System.out.println(iterator.next().getTitle());
                        iterator.previous();
                        goingForward = false;
                    }
                    printAction();
                    break;
                case 5:
                    printPlayList();
                    printAction();
                    break;
                case 6:
                    songRemove();
                    if(PlayList.getPlayList().size()>0){
                        System.out.println("current song.");
                        iterator.remove();
                        if(iterator.hasNext()){
                            System.out.println("\nStart playing song: " + iterator.next().getTitle());
                        }else if(iterator.hasPrevious()){
                            System.out.println("\nStart playing song: " + iterator.previous().getTitle());
                        }
                    }else{
                        System.out.println("No songs to delete.");
                    }
                    printAction();
                    break;
            }
        }
    }
    public static void printAction(){
        System.out.print("\nYour action: ");
    }
    public static void songNext(){  //2
        System.out.print("Switching to next song: ");
    }
    public static void songPrevious(){  //3
        System.out.print("Switching to previous song: ");
    }
    public static void songReplay(){    //4
        System.out.print("Replaying song: ");
    }
    public static void printPlayList(){ //5
        System.out.println("\nPlaylist song list:");
        LinkedList<Song> playlist = PlayList.getPlayList();
        for(int i=0; i<playlist.size(); i++){
            Song song = playlist.get(i);
            System.out.println("    "+(i+1)+". -> "+song.getTitle());
        }
    }
    public static void songRemove(){    //4
        System.out.print("Removing song: ");
    }



    public static void menu(){
        System.out.println("\nPlayer controls: \n"+
                "   1 - Quit \n"+
                "   2 - Next song. \n"+
                "   3 - Previous song. \n"+
                "   4 - Replay song. \n"+
                "   5 - Playlist songs. \n"+
                "   6 - Remove current song from playlist. ");
    }

}
