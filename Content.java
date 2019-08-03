import java.util.ArrayList;

public abstract class Content {
    private String id;
    private String name;
    private int numberOfDownloads;
    private double price;
    private ArrayList < Comment > reviews;

    Content(String id, String name, double price, int numberOfDownloads, ArrayList < Comment > reviews) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.numberOfDownloads = numberOfDownloads;
        this.reviews = reviews;
    }
    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
    public double getPrice() {
        return this.price;
    }

    public void addReview(Comment review) {
        this.reviews.add(review);
    }

    public void showReviews() {
        for (int i = 0; i < this.reviews.size(); i++) {
            System.out.println(this.reviews.get(i).getText());
        }

    }



}