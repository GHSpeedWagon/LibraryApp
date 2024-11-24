package model;

public class DVD extends Media {
    private int duration;

    public DVD(String title, String author, int duration) {
        super(title, author);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "DVD - " + super.toString() + ", Duration: " + duration + " min";
    }
}