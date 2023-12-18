package com.example.TuneIn;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class TuneInApplication {

    public static void main(String[] args) {

        /*
		1. Fetch context from ApplicationContext.xml and initiate Scanner.
		2. Fetch User details from Console.
		3. Get the required bean from context.
		4. Get the songs from Console and add them to the playlist
		5. Display the playlist reference Id
		6. Display the list of songs with their reference Id
		 */
    	ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext.xml");
    	Scanner s=new Scanner(System.in);
    	System.out.println("Welcome to the Music Playlsit Application");
    	User user=context.getBean("myUser",MyUser.class);
    	MyPlaylist playlist=context.getBean("myPlaylist",MyPlaylist.class);
    	System.out.println("What is your name?");
    	String name=s.nextLine();
    	System.out.println("What is your age?");
    	int age=s.nextInt();
    	user.setUserDetail(name, age);
    	
    	while(true) {
    	System.out.println("Do you want to add songs to the palylist\n1. Yes\n2. No");
    	int choice=s.nextInt();
    	switch(choice){
    	case 1:{
    		Song song=context.getBean("mySong",Song.class);
    		System.out.println("Enter name of the song?");
    		
    		s.nextLine();
    		String songName=s.nextLine();
    		
    		song.setName(songName);
    		playlist.addSong(song);
    		break;
    	}
    	case 2:{
    		System.out.println("Your playlist with referenceId: "+playlist+" is Ready!");
    		List<Song> songs=playlist.getPlaylistSongs();
    		for(Song sg:songs) {
    			System.out.println("Song name: "+sg.getSongName()+"\t Reference Id: "+sg);
    		}
    		System.exit(choice);
    	}
    	default:{
    		System.out.println("Invalid Choice!!");
    		System.exit(choice);
    	}
    	}
    	}
    	
    }

}
