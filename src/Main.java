import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {

        Album album1 = new Album("doorie","Atif Aslam");
        Album album2 = new Album("Rang", "Arijit Singh");

        album1.addSong("kuch is trah",4.9);
        album1.addSong("Aadat",3.5);

        LinkedList<Song> playList = new LinkedList<>();

//        album1.addInPlaylistFromAlbum(4,playList);

        album1.addInPlaylistFromAlbum("kuch is trah",playList);
        album1.addInPlaylistFromAlbum("Aadat",playList);


        album2.addSong("Gerua", 4.2);
        album2.addSong("Rang Laga", 3.9);
        album2.addInPlaylistFromAlbum("Gerua",playList);
        album2.addInPlaylistFromAlbum("Rang Laga",playList);

//        if(album2.findSong("Gerua")){
//            System.out.println("Song is present");
//        }
//        else{
//            System.out.println("song not found");
//        }

//        LinkedList<Song> playList1 = new LinkedList<>();
        play(playList);

    }
    public static void play(LinkedList<Song> playList){
        ListIterator<Song> itr = (ListIterator<Song>) playList.iterator();

        if(!itr.hasNext()){
            System.out.println("Playlist is empty");
            return;
        }
        System.out.println("Playing now");
        System.out.println(itr.next());

        printMenu();
        Scanner  sc = new Scanner(System.in);

        boolean wasNext = true;
        while(true){

            System.out.println("Please enter the option");
            int option = sc.nextInt();

            switch (option){
                case 1:
                    if(wasNext == false){
                        itr.next();
                        wasNext = true;
                    }

                    if(itr.hasNext()){
                        System.out.println("Now Playing");
                        System.out.println(itr.next());
                        wasNext = true;
                    }
                    else
                       System.out.println("you have reached at the end of the playList");
                    break;
                case 2:
                    if(wasNext == true){
                        itr.previous();
                        wasNext = false;
                    }

                    if(itr.hasPrevious()){
                        System.out.println("Now playing");
                        System.out.println(itr.previous());
                        wasNext = false;

                    }
                    else System.out.println("You have reached at the start of the playlist");
                    break;
                case 3:
                    if(wasNext==true){
                        if(itr.hasPrevious()){
                            System.out.println("Now playing: ");
                            System.out.println(itr.previous());
                            wasNext = false;
                        }
                    }
                    else{
                        if(itr.hasNext()){
                            System.out.println("Now playing: ");
                            System.out.println(itr.next());
                            wasNext = true;
                        }
                    }
                    break;
                case 4:
                   printPlaylist(playList);
                   break;
                case 5:

                    break;
                case 6:
                    printMenu();
                    break;
                case 7:
                    exit(0);

            }

        }

    }

    public static void printPlaylist(LinkedList<Song>playList){
        for(Song s : playList){
            System.out.println(s);
        }
        return ;


    }



    public static void printMenu(){

        System.out.println("1: play the next song");
        System.out.println("2: play the previous song");
        System.out.println("3: Repeat the current song");
        System.out.println("4: show all the song");
        System.out.println("5: delete the current song");
        System.out.println("6: Show the menu again");
        System.out.println("7: exit");


    }
}
