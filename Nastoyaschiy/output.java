public class output {

    public static void outpost(Post post) {
        if (post != null) {
            System.out.println("    ID: " + post.getId());
            System.out.println("    Post title: \"" + post.getHead() + "\"");
            System.out.println("    Post text: \"" + post.getBody() + "\"");
            System.out.println("    Picture URL: \"" + post.getPicture() + "\"");
            System.out.println("    #" + post.getTag());
            System.out.println("    Create date: " + post.getCreateDate());
            System.out.println("    Modify date: " + post.getModifyDate());
            System.out.println();
        } else {
            System.out.println();
            System.out.println("    Post not found");
        }

    }
}
