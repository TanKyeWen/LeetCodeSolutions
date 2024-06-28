
public class MinimumNumberofStepstoMakeTwoStringsAnagram {
    public static void main(String[] args){
        minSteps("anagram", "margana");
    }

    public static int minSteps(String s, String t) {
        int[] alpS = new int[26];
        int[] alpT = new int[26];
        int sum = 0;

        for(int i = 0; i < s.length(); i++){
            alpS[s.charAt(i) - 'a'] += 1;
        }

        for(int i = 0; i < t.length(); i++){
            alpT[t.charAt(i) - 'a'] += 1;
        }

        for(int i = 0; i < 26; i++){
            sum += Math.max(0, alpS[i] - alpT[i]);
        }

        return sum;
    }
}
