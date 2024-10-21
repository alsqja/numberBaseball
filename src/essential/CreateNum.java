package essential;

public class CreateNum {
    private String number = "";

    public CreateNum() {
        while (this.number.length() < 3) {
            String num = (int) (Math.random() * 9 + 1) + "";

            if (!this.number.contains(num)) {
                this.number += num;
            }
        }
    }

    //  number Getter
    public String getNumber() {
        return this.number;
    }
}
