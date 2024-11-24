package service;

import model.Media;
import java.util.ArrayList;
import java.util.List;

public class Library<T extends Media> {
    private List<T> collection = new ArrayList<>();

    public void addMedia(T media) {
        collection.add(media);
        System.out.println(media.getTitle() + " added to the library.");
    }

    public void removeMedia(String title) {
        collection.removeIf(media -> media.getTitle().equalsIgnoreCase(title));
        System.out.println("Media with title '" + title + "' removed from the library.");
    }

    public List<T> searchByTitle(String title) {
        List<T> results = new ArrayList<>();
        for (T media : collection) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                results.add(media);
            }
        }
        return results;
    }

    public void displayAllMedia() {
        if (collection.isEmpty()) {
            System.out.println("Library is empty.");
        } else {
            for (T media : collection) {
                System.out.println(media);
            }
        }
    }
}
