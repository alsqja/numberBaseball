package essential;

import java.util.InputMismatchException;
import java.util.regex.Pattern;

public class Confirm {
    private static final String NUMBER_REG = "^[1-3]*$";

    public boolean isGameType(String gameType) throws InputMismatchException {
        if (Pattern.matches(NUMBER_REG, gameType)) {
            return false;
        } else {
            throw new InputMismatchException();
        }
    }
}
