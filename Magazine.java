import java.util.ArrayList;

public class Magazine extends Publication {
    private int volume;

    Magazine(String id, String name, double price, int numberOfDownloads, ArrayList < Comment > reviews, String publisher, int numberOfPages, int volume) {
        super(id, name, price, numberOfDownloads, reviews, publisher, numberOfPages);
        this.volume = volume;
    }

    Magazine(String id, String name, double price, String publisher, int numberOfPages, int volume) {
        super(id, name, price, 0, new ArrayList < Comment > (), publisher, numberOfPages);
        this.volume = volume;
    }
}