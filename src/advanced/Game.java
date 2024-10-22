package advanced;

import java.util.InputMismatchException;

public class Game {
    //  맞출때까지 걸린 횟수 count
    private int count = 0;

    //  count Getter
    public int getCount() {
        return count;
    }

    private int[] checkAnswer(String inputAns, String answer) throws Exception {
        int[] answerArr = {0, 0};
        //  정답일 경우 throw -> catch 로 player while 종료
        if (inputAns.equals(answer)) {
            throw new Exception();
        }

        for (int i = 0; i < inputAns.length(); i++) {
            //  같은 자리에 같은 숫자 -> strike(answerArr[0])++
            if (inputAns.charAt(i) == answer.charAt(i)) {
                answerArr[0]++;
            } else if (answer.contains(Character.toString(inputAns.charAt(i)))) {
                //  다른 자리에 같은 숫자 -> ball(answerArr[1])++
                answerArr[1]++;
            }
        }
        return answerArr;
    }

    public void player(String number, int level) {
        Input input = new Input();
        Confirm confirm = new Confirm();

        while (true) {
            System.out.print("숫자를 입력하세요: ");
            String inputAnswer = input.stringInput();
            try {
                //  숫자 유효성 검사
                confirm.isValidNumber(inputAnswer, level);
            } catch (InputMismatchException e) {
                System.out.println("올바르지 않은 입력값입니다.");
                continue;
            }
            //  입력된 숫자 문제 없을 시 입력횟수 추가
            this.count += 1;

            int[] result = {0, 0};

            try {
                //  strike, ball 을 담을 result에 checkAnswer로 결과값 대입
                result = checkAnswer(inputAnswer, number);
                System.out.println(result[0] + "S " + result[1] + "B");
            } catch (Exception e) {
                //  정답인 경우 throw 를 catch
                System.out.println("정답");
                break;
            }
        }
    }
}
