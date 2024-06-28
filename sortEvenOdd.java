import java.util.*;

class sortEvenOdd {
    public static void main(String[] args){
        int[] arr1 = {9,3,7,2,5,78,9,4,5};
        //sortEvenOdd sort = new sortEvenOdd();
        //sort.sortEvenOddMethod(arr1);
        for(int i = 0; i < arr1.length; i++){
            System.out.println(sortEvenOddMethod(arr1).toString());
        }
    }


    public static int[] sortEvenOddMethod(int[] nums) {
        // Create two ArrayList to sort the odd indices and even indices item into seperate ArrayList
        ArrayList<Integer> arrOdd = new ArrayList<Integer>();
        ArrayList<Integer> arrEven = new ArrayList<Integer>();

        int arrLength = nums.length;
        //Input the values of odd and even indices into their respective ArrayList
        for(int i = 0; i < nums.length-1; i+=2){
            arrOdd.add(nums[i]);
            arrEven.add(nums[i+1]);
        }

        //If array has odd numbered length, add the last digit to the ArrayList
        if(arrLength%2 == 1){
            arrOdd.add(nums[nums.length-1]);
        }
        

        //Using collection framework to sort the items in non-decreasing order (Ascending)
        Collections.sort(arrOdd);
        
        //Using collection framework to sort the items in non-increasing order (Decsending)
        Collections.sort(arrEven, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2){
                //Compare it Decsendingly
                return o2.compareTo(o1);
            }
        });
        
        int y = 0, i = 0;
        int[] sortedNums = new int[arrLength];
        while(true){
            try{
                sortedNums[i] = arrOdd.get(y);
                sortedNums[i+1] = arrEven.get(y);
                y++;
                i += 2;
            } catch(IndexOutOfBoundsException e){
                break;
            }
        }
        
        //If array has odd numbered length, add the last digit to the Array
        if(arrLength%2 == 1){
            sortedNums[nums.length-1] = arrOdd.get(y);
        }

        return sortedNums;
    }
}