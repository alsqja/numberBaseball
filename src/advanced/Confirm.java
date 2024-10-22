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
        //  0-4 가 아닐 경우
        if (!Pattern.matches(TYPE_NUMBER_REG, gameType)) {
            throw new InputMismatchException();
        }
    }

    public void isValidNumber(String number, int level) throws InputMismatchException {
        //  자리수가 맞지 않을 경우
        if (number.length() != level) {
            throw new InputMismatchException();
        }
        //  중복된 숫자 검증을 위한 Set
        Set<Character> set = new HashSet<>();

        //  숫자로 이루어지지 않은 경우
        if (!Pattern.matches(NUMBER_REG, number)) {
            throw new InputMismatchException();
        }
        //  Set에 각 자리수 추가 (중복 숫자 자동 삭제로 size가 다름)
        for (int i = 0; i < number.length(); i++) {
            set.add(number.charAt(i));
        }
        if (set.size() != level) {
            throw new InputMismatchException();
        }
    }

    public void isValidLevel(String input) throws InputMismatchException {
        //  숫자가 아닌 값이 입력된 경우
        if (!Pattern.matches(LEVEL_NUMBER_REG, input)) {
            throw new InputMismatchException();
        }
        
        int level = Integer.parseInt(input);
        //  난이도의 범위가 맞지 않는 경우
        if (level > 5 || level < 3) {
            throw new InputMismatchException();
        }
    }
}
