public class Song {

    private String title;
    private double duration;

    // constructor
    //without args

    public Song() {
    }

    // without arguments
    public Song(String name, double duration) {
        this.title = name;
        this.duration = duration;
    }

    // getter and setter

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    // toString functions is used to print the element instead of address
    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}

