package advanced;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Input input = new Input();
        Confirm confirm = new Confirm();
        List<Integer> games = new ArrayList<>();

        int level = 3;
        label:
        while (true) {
            String gameType = "";
            while (true) {
                System.out.println("환영합니다! 원하시는 번호를 입력해주세요");
                System.out.println("0. 자리수 설정 1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기");
                gameType = input.stringInput();
                try {
                    confirm.isGameType(gameType);
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("올바르지 않은 입력값입니다.");
                }
            }


            switch (gameType) {
                case "1":
                    System.out.println("< 게임을 시작합니다 >");

                    CreateNum createNum = new CreateNum(level);
                    String number = createNum.getNumber();

                    Game game = new Game();
                    game.player(number, level);

                    games.add(game.getCount());
                    break;
                case "2":
                    for (int i = 0; i < games.size(); i++) {
                        System.out.println((i + 1) + "번째 게임 : 시도 횟수 - " + games.get(i));
                    }
                    break;
                case "0":
                    while (true) {
                        System.out.println("설정하고자 하는 자리수를 입력하세요.");
                        String in = input.stringInput();
                        try {
                            confirm.isValidLevel(in);
                            level = Integer.parseInt(in);
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("올바르지 않은 입력값입니다.");
                        }
                    }
                    break;
                case "3":
                    System.out.println("종료합니다.");
                    break label;
            }
        }
    }
}
