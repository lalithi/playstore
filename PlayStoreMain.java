import java.util.*;
import java.io.*;

public class PlayStoreMain {
    public static void main(String[] args) throws UserNotFoundException, ContentNotFoundException {
        PlayStore store = new PlayStore();
        Scanner sc = new Scanner(System.in);
        boolean programmeEnd = false;
        int option = 0;

        // new publications
        String[] authors1 = {
            "L. Tolstoy"
        };
        Book b1 = new Book("b1", "War and Peace", 12.55, "The Russian Messenger", 1225, authors1);

        String[] authors2 = {
            "F. Scott Fitzgerald"
        };
        Book b2 = new Book("b2", "The great gatsby", 10, "Charles Scribner's Sons", 180, authors2);

        String[] authors3 = {
            "Thomas H. Cormen",
            "Charles E. Leiserson",
            "Ronald L. Rivest",
            "Clifford Stein"
        };
        Book b3 = new Book("b3", "Introduction to algorithms", 100, "MIT Press", 1312, authors3);

        Magazine m1 = new Magazine("m1", "Forbes", 8.99, "Forbes Media", 50, 201904);


        store.addContent(b1);
        store.addContent(b2);
        store.addContent(b3);
        store.addContent(m1);


        Application g1 = new Application("g1", "Pokemon", 5.3, "androidV4");
        Application g2 = new Application("g2", "Pokemon", 5, "iOSV10");
        //a free app
        Application app1 = new Application("app1", "Calendar", "androidV3");


        store.addContent(g1);
        store.addContent(g2);
        store.addContent(app1);


        // Adding new users
        User u1 = new User("u1", "John Doe", "0412000", 200);
        User u2 = new User("u2", "Mary Poppins", "0433191");
        User u3 = new User("u3", "Dave Smith", "0413456", 1000);
        User u4 = new User("u4", "Jackie Chan", "0417654");

        store.addUser(u1);
        store.addUser(u2);
        store.addUser(u3);
        store.addUser(u4);

        Comment comment1 = new Comment(u1, "This is a fantastic game!");
        g1.addReview(comment1);

        Comment comment2 = new Comment(u2, "I never liked this game!");
        g1.addReview(comment2);

        g1.addReview(new Comment(u3, "The game crashes frequently"));

        b1.addReview(new Comment(u2, "I love Tolstoy!"));

        u1.buyContent(b1);
        u1.buyContent(b3);
        u1.buyContent(m1);

        u4.buyContent(g1);
        u4.becomePremium();
        u4.buyContent(m1);


        u2.becomePremium();
        u2.buyContent(b1);
        u2.buyContent(g1);


        store.showContent();

        g1.showReviews();

        while (!programmeEnd) { //The main menu
            boolean done = false;

            do {
                try {
                    System.out.println("Choose from the menu: 1.Add Content  2.Buy Content  3.Become a premium member  4.Add funds  5.Show reviews  6.Show all contents  7.Quit");
                    option = sc.nextInt();
                    done = true;
                } catch (InputMismatchException ex) {
                    System.out.println("Invalid input. Enter again : ");
                    sc.nextLine();
                }
            } while ((!done) && (option < 0 || option > 8));

            switch (option) {

                //Add content
                case 1:
                    System.out.println("Still working on this");
                    break;

                    //Buy content
                case 2:
                    System.out.println("Enter your user ID");
                    sc.nextLine();
                    String userId = sc.nextLine();
                    User user = store.getUserById(userId);
                    System.out.println("Logged in as " + user.getName());
                    System.out.println("Select the ID of the Item to purchase from the following list");
                    store.showContent();
                    String contentId = sc.nextLine();
                    user.buyContent(store.getContentByContentId(contentId));
                    break;

                    //Become a premium member
                case 3:
                    System.out.println("Enter your user ID");
                    sc.nextLine();
                    String userId1 = sc.nextLine();
                    User user1 = store.getUserById(userId1);
                    System.out.println("Logged in as " + user1.getName());
                    user1.becomePremium();
                    break;

                    //Add funds to a user account
                case 4:
                    System.out.println("Enter your user ID");
                    sc.nextLine();
                    String userId2 = sc.nextLine();
                    User user2 = store.getUserById(userId2);
                    System.out.println("Logged in as " + user2.getName() + ". Your current balance is: " + user2.getAvailableFunds());
                    System.out.println("Enter the amount you want to add to your account");
                    //sc.nextLine();
                    double amountAdd = sc.nextDouble();
                    user2.addFunds(amountAdd);
                    break;

                    //Show reviews
                case 5:
                    System.out.println("Select the ID of the Item to view reviews");
                    store.showContent();
                    sc.nextLine();
                    String contentId1 = sc.nextLine();
                    Content content = store.getContentByContentId(contentId1);
                    System.out.println("Reviews for " + content.getId() + " " + content.getName() + " are:");
                    content.showReviews();
                    break;

                    // Show a list of all contents
                case 6:
                    store.showContent();
                    break;

                    //Quit
                case 7:
                    programmeEnd = true;
                    System.out.println("Exit from the Play store.");
                    break;

                default:
                    System.out.println("Wrong option");
            }
        }

    }
}