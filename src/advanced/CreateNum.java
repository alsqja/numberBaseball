package advanced;

public class CreateNum {
    private String number = "";

    public CreateNum(int level) {
        while (this.number.length() < level) {
            String num = (int) (Math.random() * 9 + 1) + "";

            if (!this.number.contains(num)) {
                this.number += num;
            }

            System.out.println(number);
        }
    }

    //  number Getter
    public String getNumber() {
        return this.number;
    }
}
