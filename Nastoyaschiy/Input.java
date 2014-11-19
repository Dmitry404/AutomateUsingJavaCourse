import java.util.Scanner;

public class Input {

    public static int integer() {
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextInt()) {
            System.out.println("Please input integer");
            sc.nextLine();
        }
        return sc.nextInt();
    }

    public static int integer(int max) {
        Scanner sc = new Scanner(System.in);
        int i;
        while (true) {
            if (sc.hasNextInt()) {
                i = sc.nextInt();
                if (i >= 0 && i <= max) break;
            }
            System.out.println("Please input integer in the range 0-" + max);
            sc.nextLine();
        }
        return i;
    }

    public static String string() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}