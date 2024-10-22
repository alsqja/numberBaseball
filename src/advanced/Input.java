package advanced;

import java.util.Scanner;

public class Input {
    private final Scanner sc = new Scanner(System.in);

    public String stringInput() {
        String str = sc.next().trim();
        sc.nextLine();
        return str;
    }
}
