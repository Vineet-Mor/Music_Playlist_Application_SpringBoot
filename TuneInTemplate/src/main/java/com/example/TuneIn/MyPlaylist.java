package com.example.TuneIn;

import java.util.ArrayList;
import java.util.List;

/*
 * 1. Add class attributes.
 * 2. Override all the interface methods.
 * 3. Implement setter injection
 */

public class MyPlaylist implements Playlist {

	Song mySong;
	List<Song> songs;
	int size;
	public MyPlaylist() {
		songs=new ArrayList<Song>();
		size=0;
	}
	@Override
	public void addSong(Song song) {
		// TODO Auto-generated method stub
		songs.add(song);
		size++;
	}

	@Override
	public List<Song> getPlaylistSongs() {
		// TODO Auto-generated method stub
		return songs;
	}

	@Override
	public Integer getCount() {
		// TODO Auto-generated method stub
		return size;
	}
	public void setMySong(Song mySong) {
		this.mySong=mySong; 
	}

}