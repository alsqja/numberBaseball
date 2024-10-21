package essential;

import java.util.Scanner;

public class Input {
    private final Scanner sc = new Scanner(System.in);

    public String gameTypeInput() {
        String gameType = sc.next().trim();
        sc.nextLine();
        return gameType;
    }

    public String answerInput() {
        String answerInput = sc.next().trim();
        sc.nextLine();
        return answerInput;
    }
}
