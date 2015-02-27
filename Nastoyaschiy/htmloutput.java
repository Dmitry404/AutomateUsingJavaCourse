import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class htmloutput {

    public static void out(Post post) throws IOException {
        String head = post.getHead();
        String body = post.getBody();
        String picture = post.getPicture();
        String tag = post.getTag();

        File file = new File("D:\\post.html");
        if(!file.exists()){
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file, false);
        fw.write("<html>\r\n" +
                "<head>\r\n" +
                "<meta HTTP-EQUIV=\"Content-type\" CONTENT=\"text/html; charset=UTF-8\">\r\n" +
                "<title>" + head + "</title>\r\n" +
                "<style>\r\n" +
                "p {\r\n" +
                "margin-top: 1em;\r\n" +
                "margin-bottom: 5em;\r\n" +
                "text-indent: 50px;\r\n" +
                "}\r\n" +
                "</style>\r\n" +
                "</head>");
        fw.write("<data>\r\n" +
                "<div align=\"center\">\r\n" +
                "<b> <font size=\"8\"><p>" + head + "</font></b\r\n" +
                "<br /\r\n");

        fw.write("</div>\r\n" +
                "<div align=\"justify\"> <font size=\"8\"><p>" + body + "</font>\r\n" +
                "<br/>\r\n");
        fw.write("<font size=\"6\">#" + tag + "</font>\r\n" +
                "<br/>\r\n");
        fw.write("<img src=\"" + picture + "\">\r\n");
        fw.close();
    }

}
