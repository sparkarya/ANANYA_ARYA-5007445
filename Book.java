import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Book {
    int bookId;
    String title;
    String author;

    // Constructor to initialize book attributes
    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    // Getter for title
    public String getTitle() {
        return title;
    }

    // toString method to display book information
    @Override
    public String toString() {
        return "Book ID: " + bookId + ", Title: " + title + ", Author: " + author;
    }
}

class LibrarySearch {

    // Linear search for books by title
    public static Book linearSearch(List<Book> books, String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book; // Book found
            }
        }
        return null; // Book not found
    }

    // Binary search for books by title (sorted list required)
    public static Book binarySearch(List<Book> books, String title) {
        int low = 0;
        int high = books.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            Book midBook = books.get(mid);

            int comparison = midBook.getTitle().compareToIgnoreCase(title);

            if (comparison == 0) {
                return midBook; // Book found
            } else if (comparison < 0) {
                low = mid + 1; // Search in the right half
            } else {
                high = mid - 1; // Search in the left half
            }
        }

        return null; // Book not found
    }

    public static void main(String[] args) {
        // Sample list of books
        List<Book> books = new ArrayList<>(Arrays.asList(
                new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"),
                new Book(2, "To Kill a Mockingbird", "Harper Lee"),
                new Book(3, "1984", "George Orwell")
        ));

        // Linear Search
        String linearSearchTitle = "1984";
        Book foundBookLinear = linearSearch(books, linearSearchTitle);
        System.out.println("Linear Search Result:");
        if (foundBookLinear != null) {
            System.out.println("Found book: " + foundBookLinear);
        } else {
            System.out.println("Book not found.");
        }

        // Prepare for Binary Search (requires sorted list)
        books.sort(Comparator.comparing(Book::getTitle));

        // Binary Search
        String binarySearchTitle = "The Great Gatsby";
        Book foundBookBinary = binarySearch(books, binarySearchTitle);
        System.out.println("\nBinary Search Result:");
        if (foundBookBinary != null) {
            System.out.println("Found book: " + foundBookBinary);
        } else {
            System.out.println("Book not found.");
        }
    }
}
