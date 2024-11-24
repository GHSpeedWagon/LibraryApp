package model;

public class Book extends Media {
    private int pages;

    public Book(String title, String author, int pages) {
        super(title, author);
        this.pages = pages;
    }

    public int getPages() {
        return pages;
    }

    @Override
    public String toString() {
        return "Book - " + super.toString() + ", Pages: " + pages;
    }
}
