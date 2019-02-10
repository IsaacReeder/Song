package com.Isaac;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();    // need to initialize an arraylist, so that we can use it without getting any errors
    }

    public boolean addSong(String title, double duration) {    // validating that we are not duplicating songs
        if(findSong(title) == null) {
            this.songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    private Song findSong(String title) {    // only used internally
        for(Song checkedSong: this.songs) {                // this is the foreach command in java. it goes through and creates a variable called checkedSong for every entry in our arraylist
            if(checkedSong.getTitle().equals(title)) {    // forEach acts like a forloop, it is great for lists
                return checkedSong;
            }
        }
        return null;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
        int index = trackNumber -1;                       // the computer likes to read arrays starting at 0
        if((index >=0) && (index <= this.songs.size())) {  // if there is a song in that index position
            playList.add(this.songs.get(index));          // we add this song to the playlist
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        Song checkedSong = findSong(title);
        if(checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }
        System.out.println("The song " + title + " is not in this album");
        return false;
    }
}
