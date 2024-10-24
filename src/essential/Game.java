package essential;

import java.util.InputMismatchException;

public class Game {
    private int count = 0;

    public int getCount() {
        return count;
    }

    public int[] checkAnswer(String inputAns, String answer) throws Exception {
        int[] answerArr = {0, 0};
        if (inputAns.equals(answer)) {
            throw new Exception();
        }
        for (int i = 0; i < inputAns.length(); i++) {
            if (inputAns.charAt(i) == answer.charAt(i)) {
                answerArr[0]++;
            } else if (answer.contains(Character.toString(inputAns.charAt(i)))) {
                answerArr[1]++;
            }
        }
        return answerArr;
    }

    public void player(String number) {
        Input input = new Input();
        Confirm confirm = new Confirm();
        while (true) {
            System.out.print("숫자를 입력하세요: ");
            String inputAnswer = input.answerInput();
            try {
                confirm.isValidNumber(inputAnswer);
            } catch (InputMismatchException e) {
                System.out.println("올바르지 않은 입력값입니다.");
                continue;
            }
            this.count++;

            int[] result = {0, 0};
            
            try {
                result = checkAnswer(inputAnswer, number);
                if (result[0] == 0 && result[1] == 0) {
                    System.out.println("아웃");
                } else {
                    System.out.println(result[0] + "S " + result[1] + "B");
                }
            } catch (Exception e) {
                System.out.println("정답");
                break;
            }
        }
    }
}
