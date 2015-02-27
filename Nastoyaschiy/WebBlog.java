import java.io.IOException;

public class WebBlog {

    private static Posts posts = new Posts();

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println();
        System.out.println("Welcome in my True Blog");

        posts.addpost(new Post("ololo", "ololo twice", "picpic", "olo"));
        posts.addpost(new Post("ololo", "ololo twice dfghdrfgh", "picpic", "azazazaz"));

        while (true) {
            System.out.println();
            System.out.println("Please choose number of action:");
            System.out.println("1 - Create new post");
            System.out.println("2 - Search post by ID");
            System.out.println("3 - Search post by contents");
            System.out.println("4 - Modify post by ID");
            System.out.println("5 - Delete post by ID");
            //System.out.println("6 - Export post to txt file");
            //System.out.println("7 - Export post to html file");
            System.out.println("0 - Exit");
            int i = Input.integer(5);
            if (i == 0) break;
            if (i == 1) create();
            if (i == 2) searchID();
            if (i == 3) search();
            if (i == 4) modify();
            if (i == 5) delete();
        }
        System.out.println();
        System.out.println("Thank you for using my True Blog");
    }

    private static void create() {
        System.out.println();
        System.out.println("Please input title:");
        String head = Input.string();
        System.out.println("Please input text:");
        String body = Input.string();
        System.out.println("Please input picture URL:");
        String picture = Input.string();
        System.out.println("Please input tag:");
        String tag = Input.string();
        Post post = new Post(head, body, picture, tag);
        posts.addpost(post);
        System.out.println("Post was added");
    }

    private static int searchID() {
        System.out.println();
        System.out.println("Please input ID:");
        int id = Input.integer();
        output.outpost(posts.get(id));
        if (posts.get(id) == null) id = 0;
        return id;
    }

    private static void search() {
        while (true) {
            System.out.println();
            System.out.println("Please choose number of action:");
            System.out.println("1 - Search by title");
            System.out.println("2 - Search by text");
            System.out.println("3 - Search by tag");
            System.out.println("0 - End searching");
            int i = Input.integer(3);
            if (i == 0 ) break;
            if (i == 1) {
                System.out.println();
                System.out.println("Please input title:");
                String title = Input.string();
                posts.search(title, "title");
            }
            if (i == 2) {
                System.out.println();
                System.out.println("Please input text:");
                String title = Input.string();
                posts.search(title, "text");
            }
            if (i == 3) {
                System.out.println();
                System.out.println("Please input tag:");
                String title = Input.string();
                posts.search(title, "tag");
            }
        }
    }

    private static void modify() {
        int id = searchID();
        while (id != 0) {
            System.out.println();
            System.out.println("Please choose number of action:");
            System.out.println("1 - Change title");
            System.out.println("2 - Change text");
            System.out.println("3 - Change picture URL");
            System.out.println("4 - Change tag");
            System.out.println("0 - End modification");
            int i = Input.integer(4);
            if (i == 0) break;
            if (i == 1) {
                System.out.println("Input new title:");
                String title = Input.string();
                posts.get(id).setHead(title);
            }
            if (i == 2) {
                System.out.println("Input new text:");
                String body = Input.string();
                posts.get(id).setBody(body);
            }
            if (i == 3) {
                System.out.println("Input new URL:");
                String picture = Input.string();
                posts.get(id).setPicture(picture);
            }
            if (i == 4) {
                System.out.println("Input new tag:");
                String tag = Input.string();
                posts.get(id).setTag(tag);
            }
            posts.get(id).setModifyDate();
            System.out.println();
            output.outpost(posts.get(id));
        }
    }

    private static void delete() {
        int id = searchID();
        System.out.println("Are you sure? (y/n)");
        String s = Input.string();
        if (s.equals("y")) posts.delete(id);
    }
}
