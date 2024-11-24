import model.DVD;
import model.Magazine;
import model.Media;
import model.Book;
import service.Library;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library<Media> library = new Library<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management:");
            System.out.println("1. Add Book");
            System.out.println("2. Add Magazine");
            System.out.println("3. Add DVD");
            System.out.println("4. Remove Media");
            System.out.println("5. Search by Title");
            System.out.println("6. Display All Media");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: // Додати книгу
                    System.out.print("Enter book title: ");
                    String bookTitle = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String bookAuthor = scanner.nextLine();
                    System.out.print("Enter number of pages: ");
                    int pages = scanner.nextInt();
                    library.addMedia(new Book(bookTitle, bookAuthor, pages));
                    break;

                case 2:
                    System.out.print("Enter magazine title: ");
                    String magazineTitle = scanner.nextLine();
                    System.out.print("Enter magazine author: ");
                    String magazineAuthor = scanner.nextLine();
                    System.out.print("Enter issue number: ");
                    int issueNumber = scanner.nextInt();
                    library.addMedia(new Magazine(magazineTitle, magazineAuthor, issueNumber));
                    break;

                case 3:
                    System.out.print("Enter DVD title: ");
                    String dvdTitle = scanner.nextLine();
                    System.out.print("Enter DVD author: ");
                    String dvdAuthor = scanner.nextLine();
                    System.out.print("Enter duration (in minutes): ");
                    int duration = scanner.nextInt();
                    library.addMedia(new DVD(dvdTitle, dvdAuthor, duration));
                    break;

                case 4:
                    System.out.print("Enter the title of the media to remove: ");
                    String removeTitle = scanner.nextLine();
                    library.removeMedia(removeTitle);
                    break;

                case 5:
                    System.out.print("Enter the title to search for: ");
                    String searchTitle = scanner.nextLine();
                    List<Media> results = library.searchByTitle(searchTitle);
                    if (results.isEmpty()) {
                        System.out.println("No media found with title '" + searchTitle + "'.");
                    } else {
                        results.forEach(System.out::println);
                    }
                    break;

                case 6:
                    library.displayAllMedia();
                    break;

                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}