import java.util.ArrayList;

public class Application extends Content {
    private String osType;

    Application(String id, String name, double price, int numberOfDownloads, ArrayList < Comment > reviews, String osType) {
        super(id, name, price, numberOfDownloads, reviews);
        this.osType = osType;
    }

    Application(String id, String name, double price, String osType) {
        super(id, name, price, 0, new ArrayList < Comment > ());
        this.osType = osType;
    }

    Application(String id, String name, String osType) {
        super(id, name, 0.00, 0, new ArrayList < Comment > ());
        this.osType = osType;
    }

    public void addReview(Comment comment) {
        super.addReview(comment);
    }
}