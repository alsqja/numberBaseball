package advanced;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Set;
import java.util.regex.Pattern;

public class Confirm {
    private static final String TYPE_NUMBER_REG = "^[0-3]*$";
    private static final String NUMBER_REG = "^[1-9]*$";
    private static final String LEVEL_NUMBER_REG = "^[3-5]*$";

    public void isGameType(String gameType) throws InputMismatchException {
        if (!Pattern.matches(TYPE_NUMBER_REG, gameType)) {
            throw new InputMismatchException();
        }
    }

    public void isValidNumber(String number, int level) throws InputMismatchException {
        if (number.length() != level) {
            throw new InputMismatchException();
        }
        Set<Character> set = new HashSet<>();
        if (!Pattern.matches(NUMBER_REG, number)) {
            throw new InputMismatchException();
        }
        for (int i = 0; i < number.length(); i++) {
            set.add(number.charAt(i));
        }
        if (set.size() != level) {
            throw new InputMismatchException();
        }
    }

    public void isValidLevel(String input) throws InputMismatchException {
        int level;
        if (!Pattern.matches(LEVEL_NUMBER_REG, input)) {
            throw new InputMismatchException();
        }
        level = Integer.parseInt(input);
        if (level > 5 || level < 3) {
            throw new InputMismatchException();
        }
    }
}
