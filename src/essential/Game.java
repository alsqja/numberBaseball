package essential;

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
        while (true) {
            System.out.print("숫자를 입력하세요: ");
            String inputAnswer = input.answerInput();
            this.count++;
            int[] result = {0, 0};
            try {
                result = checkAnswer(inputAnswer, number);
                System.out.println(result[0] + "S " + result[1] + "B");
            } catch (Exception e) {
                System.out.println("정답");
                break;
            }
        }
    }
}
