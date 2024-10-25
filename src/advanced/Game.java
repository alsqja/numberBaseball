package advanced;

import java.util.InputMismatchException;

public class Game {
    //  맞출때까지 걸린 횟수 count
    private int count = 0;
    private String number = "";

    public Game(int level) {
        //  길이를 기준으로 중복되지 않은 값만 추가
        while (this.number.length() < level) {
            String num = (int) (Math.random() * 9 + 1) + "";

            if (!this.number.contains(num)) {
                this.number += num;
            }
        }
    }

    //  count Getter
    public int getCount() {
        return count;
    }

    private int[] checkAnswer(String inputAns) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < inputAns.length(); i++) {
            //  같은 자리에 같은 숫자 -> strike++
            if (inputAns.charAt(i) == this.number.charAt(i)) {
                strike++;
            } else if (this.number.contains(Character.toString(inputAns.charAt(i)))) {
                //  다른 자리에 같은 숫자 -> ball++
                ball++;
            }
        }
        return new int[]{strike, ball};
    }

    public void player(int level) {

        while (true) {
            String inputAnswer;
            try {
                inputAnswer = getInputAnswer(level);
            } catch (InputMismatchException e) {
                continue;
            }
            //  입력된 숫자 문제 없을 시 입력횟수 추가
            this.count++;

            int[] result;

            //  strike, ball 을 담을 result에 checkAnswer로 결과값 대입
            if (extracted(level, inputAnswer)) break;

        }
    }

    private boolean extracted(int level, String inputAnswer) {
        int[] result;
        result = checkAnswer(inputAnswer);

        if (result[0] == level) {
            System.out.println("정답");
            return true;
        }

        if (result[0] == 0 && result[1] == 0) {
            System.out.println("아웃");
        } else {
            System.out.println(result[0] + "S " + result[1] + "B");
        }
        return false;
    }

    private static String getInputAnswer(int level) throws InputMismatchException {
        Input input = new Input();
        Validation validation = new Validation();
        System.out.print("숫자를 입력하세요: ");
        String inputAnswer = input.stringInput();
        try {
            //  숫자 유효성 검사
            validation.isValidNumber(inputAnswer, level);
        } catch (InputMismatchException e) {
            System.out.println("올바르지 않은 입력값입니다.");
            throw new InputMismatchException();
        }
        return inputAnswer;
    }
}
