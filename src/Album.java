import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {


    private String name;
    private String artist;
    private List<Song> songs;

    public Album() {
    }

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Song> getSong() {
        return songs;
    }

    public void setSong(List<Song> songs) {
        this.songs = songs;
    }

    // find method to search the song inside the list;
    public boolean findSong(String title){
        for(Song s : this.songs){
            if(s.getTitle().equals(title)) return true;
        }
        return  false;
    }

    // add music inside the list
    public boolean addSong(String title,double duration){
        if(!findSong(title)){
            this.songs.add(new Song(title,duration));
            System.out.println("Song has been added");
            return true;
        }
        System.out.println("Song already Present");
        return false;
    }

    public boolean deleteSong(String title){
        if(findSong(title)){
            for(int i=0; i<this.songs.size(); i++){
                if(this.songs.get(i).getTitle().equals(title)){
                    this.songs.remove(i);
                    System.out.println("Song successfully deleted");
                    return true;

                }
            }
        }
        System.out.println("Song is not found");
        return false;
    }

    // add to playlist from album
    public boolean addInPlaylistFromAlbum(String title, LinkedList<Song> playlist){
        if(findSong(title)){
            for(Song s : this.songs){
                if(s.getTitle().equals(title)){
                    playlist.add(s);
                    System.out.println("Congrats! Song has been added in playlist ");
                    return true;
                }
            }
        }
        System.out.println("Song not found in Album");
        return false;
    }

    public boolean addInPlaylistFromAlbum(int idx, LinkedList<Song> playlist){
        idx = idx-1;
        if(idx>=0 && idx < this.songs.size()){
            playlist.add(this.songs.get(idx));
            System.out.println("Song has been added in the playlist");
            return  true;
        }
        System.out.println("Invalid song number");
        return false;
    }
}
