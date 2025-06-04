public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {1,9,9};

        PlusOne plusOne = new PlusOne();
        int[] result = plusOne.plusOne(digits);
        for (int digit : result) {
            System.out.print(digit + " ");
        }
    }

    public int[] plusOne(int[] digits) {
        int[] tempDigits = new int[digits.length + 1];
        digits[digits.length-1] += 1;
        for(int i = 0; i < digits.length; i++){
            tempDigits[i+1] = digits[i];
        }
        for(int i = tempDigits.length - 1; i > 0; i--){
            if (tempDigits[i] == 10){
                tempDigits[i] = 0;
                tempDigits[i-1] += 1;
            }
        }

        int[] newDigits = new int[digits.length];
        if (tempDigits[0] == 0){
            for(int i = 0; i < digits.length; i++){
                newDigits[i] = tempDigits[i + 1];
            }
        }else if(tempDigits[0] != 0){
            newDigits = new int[digits.length + 1];
            for(int i = 0; i < digits.length; i++){
                newDigits[i] = tempDigits[i];
            }
        }
        return newDigits;
    }
}
