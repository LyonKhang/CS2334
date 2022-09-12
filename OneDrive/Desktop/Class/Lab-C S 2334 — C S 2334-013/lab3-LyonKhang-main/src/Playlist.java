import java.util.Arrays;
import java.lang.reflect.Array;

public class Playlist {
	private Song[] songs;
	private int numSongs;
	private final static int MIN_CAPACITY = 3;
	
	public Playlist() {
		numSongs=0;
		songs = new Song[MIN_CAPACITY];

	}
	public Playlist(int capacity) {
		if(capacity <MIN_CAPACITY) {
			songs = new Song[MIN_CAPACITY];
			numSongs=0;
		}
		else {
		songs = new Song[capacity];
		numSongs=0;
		}
	}
	
	//getter
	public int getCapacity() {
		return songs.length;
	}
	public int getNumSongs() {
		return numSongs;
	}
	public Song[] getSongs() {
		return songs.clone();
	}
	public Song getSong(int index) {
		if(index < 0 ||index >= songs.length)
			return null;
		Song[] tem = Arrays.copyOf(songs,songs.length);
		return tem[index];
	}
	//add
	public boolean addSong(Song song) {
		if(song==null)
			return false;
		for(int i = 0; i < songs.length;i++) { 
			if(songs[i]==null) {
				songs[i] = song;
				numSongs++;
				return true;
			}
		}
		
		return false;
	}
	
	public boolean addSong(int index, Song song) {
		if(song == null ||index < 0 ||index > songs.length ||(index >0&&songs[index-1]==null) || numSongs==songs.length) {
			return false;
		}
		else {
			for(int j =numSongs;j>index;j--){
				songs[j] = songs[j-1]; 
			}
				songs[index] = song;
				numSongs++;
				return true;
		}
	}
	
	public int addSongs(Playlist playlist) {
		int count =0;
		//Song[] temArray = playlist.getSongs().clone();
		if(playlist==null) {
			Song[] temArray= Arrays.copyOf(playlist.getSongs(),playlist.getNumSongs());
			playlist.songs = temArray;
			return 0;
		}
		//Song[] temArray = Arrays.copyOf(playlist.getSongs(),playlist.getNumSongs());
		/*
			for(int i=0;i < (playlist.getCapacity() - playlist.getNumSongs())&& count < temArray.length;count++) {
			 addSong(temArray[i]);
			
		}*/
		return count;
		
	}
	//remove
	
	public Song removeSong() {
		for(int i =songs.length-1; i>= 0;i--){
		if(songs[i]!=null) {
			Song tem = songs[i];
			numSongs--;
			songs[i]= null;
		return tem;
		}
		}
		return null;
	}
	
	public Song removeSong(int index) {
		if(index < 0 ||index >= songs.length)
			return null;			
		if(songs[index]!=null) {
			Song tem = songs[index];
			numSongs--;
			Song[] songsTem = new Song[songs.length-1];
			if(index == songs.length-1) {
				for(int i = 0; i < songsTem.length; i++){  
		            songsTem[i]= songs[i];
		        }
		        songs = songsTem;
				return tem;
			}
			for(int j = index; j < songs.length-1;j++){
				songs[j] = songs[j+1]; 
			}
	        for(int i = 0; i < songsTem.length; i++){  
	            songsTem[i]= songs[i];
	        }
	        songs = songsTem;
		return tem;
		}
		
		return null;
	}
	
	/*
	// tester
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double[] test = new double[] {1,2,3};
		Playlist playlist = new Playlist(5);

		//System.out.println( Array.getLength(playlist));
		System.out.println(playlist.getSong(0));
		int[] time = new int[]{1,2};
		Song tem = new Song("a","b",time);
		System.out.println(playlist.addSong(tem));
		System.out.println(tem);	
		System.out.println(playlist.getSong(0));
		System.out.println(tem.equals(playlist.getSong(0)));
		//System.out.println(playlist.getNumSongs());
		//System.out.println(playlist.getSongs());
		System.out.println(playlist.songs[0].getTitle());
		//System.out.println(playlist.getSong(1));
		Playlist playlist = new Playlist(5);
		System.out.println(playlist.getSongs());
		System.out.println(playlist.getSong(0));
		System.out.println(playlist.getSong(0));
		Song[] temArray = Arrays.copyOf(playlist.getSongs(),5);
		System.out.println(temArray);
		System.out.println(temArray.equals(new Song[] {}));
		//System.out.println(playlist.equals(playlistTest));
		*/
		
	}
	
