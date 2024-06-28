import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class RearangeValue {
    public static void main(String[] args){
        RearangeValue c = new RearangeValue();
        long numA = -99900183;
        System.out.println(c.smallestNumber(numA));
    }

    public long smallestNumber(long num) {
        String sNum = Long.toString(num);
        long sortedNum, numLength = sNum.length();
        ArrayList<String> arrNum = new ArrayList<>();

        for(int index = 0; index < numLength; index++){
            arrNum.add(Character.toString(sNum.charAt(index)));
        }
        
        int negCheck = sNum.indexOf("-");
        StringBuilder sortedNumStr = new StringBuilder();
        if(negCheck == 0){
            arrNum.remove(0);
            Collections.sort(arrNum, Collections.reverseOrder());

            sortedNumStr.append("-");

        }else{
            Collections.sort(arrNum);
            if(arrNum.indexOf("0") == 0 && numLength != 1){
                String temp = arrNum.get(arrNum.lastIndexOf("0")+1);
                arrNum.set(arrNum.lastIndexOf("0")+1, "0");
                arrNum.set(0, temp);
            }
        }

        for(String str : arrNum){
            sortedNumStr.append(str);
        }

        sortedNum = Long.parseLong(sortedNumStr.toString());

        return sortedNum;  
    }
}
