package advanced;

public class CreateNum {
    private String number = "";

    public CreateNum(int level) {
        //  길이를 기준으로 중복되지 않은 값만 추가
        while (this.number.length() < level) {
            String num = (int) (Math.random() * 9 + 1) + "";

            if (!this.number.contains(num)) {
                this.number += num;
            }

            // TODO: 작동 시 정답 보기 위함 -> 추후 삭제
            System.out.println(number);
        }
    }

    //  number Getter
    public String getNumber() {
        return this.number;
    }
}
