package advanced;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Input input = new Input();
        Validation validation = new Validation();

        //  매 게임 별 count 저장 List
        List<Integer> games = new ArrayList<>();

        //  자리수 입력 여부 저장 변수
        boolean isInputLevel = false;

        //  난이도
        int level = 3;

        label:
        while (true) {
            String gameType = "";
            //  gameType 입력 (자리수 설정이 됐을 경우 패스)
            if (!isInputLevel) {
                System.out.println("환영합니다! 원하시는 번호를 입력해주세요");
                System.out.println("0. 자리수 설정 1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기");
                gameType = input.stringInput();
                try {
                    validation.isGameType(gameType);
                } catch (InputMismatchException e) {
                    System.out.println("올바르지 않은 입력값입니다.");
                    continue;
                }
            }

            //  자리수 입력 시 바로 시작
            if (isInputLevel) {
                gameType = "1";
            }

            switch (gameType) {
                case "1":
                    System.out.println("< 게임을 시작합니다 >");
                    //  게임 진행
                    Game game = new Game(level);
                    game.player(level);

                    games.add(game.getCount());

                    //  난이도 설정 초기화
                    isInputLevel = false;
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
                            //  input값 유효성 확인
                            validation.isValidLevel(in);

                            level = Integer.parseInt(in);

                            //  난이도 설정 여부
                            isInputLevel = true;
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
