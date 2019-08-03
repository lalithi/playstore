import java.util.ArrayList;

public class Book extends Publication {
    private String[] authors;

    Book(String id, String name, double price, String publisher, int numberOfPages, String[] authors, int numberOfDownloads, ArrayList < Comment > reviews) {
        super(id, name, price, numberOfDownloads, reviews, publisher, numberOfPages);
        this.authors = authors;
    }

    Book(String id, String name, double price, String publisher, int numberOfPages, String[] authors) {
        super(id, name, price, 0, new ArrayList < Comment > (), publisher, numberOfPages);
        this.authors = authors;
    }

    public void addReview(Comment comment) {
        super.addReview(comment);
    }
}