package essential;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Set;
import java.util.regex.Pattern;

public class Confirm {
    private static final String TYPE_NUMBER_REG = "^[1-3]*$";
    private static final String NUMBER_REG = "^[1-9]*$";

    public void isGameType(String gameType) throws InputMismatchException {
        if (!Pattern.matches(TYPE_NUMBER_REG, gameType)) {
            throw new InputMismatchException();
        }
    }

    public void isValidNumber(String number) throws InputMismatchException {
        if (number.length() != 3) {
            throw new InputMismatchException();
        }
        if (!Pattern.matches(NUMBER_REG, number)) {
            throw new InputMismatchException();
        }
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < number.length(); i++) {
            set.add(number.charAt(i));
        }
        if (set.size() != 3) {
            throw new InputMismatchException();
        }
    }
}
