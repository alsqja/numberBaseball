package essential;

import java.util.HashSet;
import java.util.Set;

public class CreateNum {
    private String number;

    public CreateNum() {
        //  hashSet 을 이용해 중복 자동 배제 및 숫자 선정
        Set<String> numberSet = new HashSet<>();
        while (numberSet.size() < 3) {
            String num = (int) (Math.random() * 9 + 1) + "";
            numberSet.add(num);
        }

        //  hashSet에 있는 값 String으로 붙이기 (순서 랜덤)
        while (numberSet.iterator().hasNext()) {
            this.number += numberSet.iterator().next();
        }
    }

    //  number Getter
    public String getNumber() {
        return this.number;
    }
}
