import java.util.ArrayList;

public class Publication extends Content {
    private String publisher;
    private int numberOfPages;

    Publication(String id, String name, double price, int numberOfDownloads, ArrayList < Comment > reviews, String publisher, int numberOfPages) {
        super(id, name, price, numberOfDownloads, reviews);
        this.publisher = publisher;
        this.numberOfPages = numberOfPages;
    }

    Publication(String id, String name, double price, String publisher, int numberOfPages) {
        super(id, name, price, 0, new ArrayList < Comment > ());
        this.publisher = publisher;
        this.numberOfPages = numberOfPages;
    }
}