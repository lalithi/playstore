import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.*;

public class PlayStore {
    private HashMap < String, Content > contents;
    private ArrayList < User > users;


    PlayStore() {
        this.contents = new HashMap < String, Content > ();
        this.users = new ArrayList < User > ();
    }

    PlayStore(HashMap < String, Content > contents, ArrayList < User > users) {
        this.contents = contents;
        this.users = users;
    }

    public void addContent(Content content) { // add the content into the content list
        this.contents.put(content.getId(), content);
    }

    public void addUser(User user) { // add the user to the list of users
        this.users.add(user);
    }

    public User getUserById(String userId) throws UserNotFoundException { // Method to get a user by providing the user ID
        for (int i = 0; i < this.users.size(); i++) {
            if (this.users.get(i).getId().equals(userId))
                return this.users.get(i);
        }
        throw new UserNotFoundException("Invalid User");
    }

    public Content getContentByContentId(String contentId) throws ContentNotFoundException { //Method to get a content by its ID
        if (this.contents.containsKey(contentId))
            return this.contents.get(contentId);
        throw new ContentNotFoundException("Invalid content ID");
    }

    public void showContent() throws ContentNotFoundException { // Show the list of all contents
        Iterator < String > itr = contents.keySet().iterator();
        System.out.println("ID" + "\t" + "Content Name" + "\t" + "Price");
        while (itr.hasNext()) {
            //System.out.println(itr.next());
            Content item = getContentByContentId(itr.next());
            System.out.println(item.getId() + "\t" + item.getName() + "\t" + item.getPrice());
        }
    }



}