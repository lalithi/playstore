public class Comment {
    private User user;
    private String text;


    Comment(User user, String text) {
        this.user = user;
        this.text = text;
    }

    public String getText() {
        return this.text;
    }



}