package essential;

import java.util.InputMismatchException;

public class App {
    public static void main(String[] args) {
        String gameType = "";
        Input input = new Input();
        Confirm confirm = new Confirm();

        while (true) {
            while (true) {
                System.out.println("환영합니다! 원하시는 번호를 입력해주세요");
                System.out.println("1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기");
                gameType = input.gameTypeInput();
                try {
                    confirm.isGameType(gameType);
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("올바르지 않은 입력값입니다.");
                }
            }

            if (gameType.equals("1")) {
                System.out.println("< 게임을 시작합니다 >");
                CreateNum createNum = new CreateNum();
                String number = createNum.getNumber();
                Game game = new Game();
                System.out.println(number);
                game.player(number);
                System.out.println(game.getCount() + " 번 만에 맞추셨어요!! 혹시... 천재?");
            } else if (gameType.equals("2")) {
                System.out.println("구현되지 않은 기능입니다.");
            } else {
                System.out.println("종료합니다.");
                break;
            }
        }
    }
}
