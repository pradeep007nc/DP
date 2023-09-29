package prac.strings;

public class DetermineTwoStrings {

    public static void main(String[] args) {
        System.out.println(new DetermineTwoStrings().closeStrings("abc", "bca"));
    }

    public boolean closeStrings(String word1, String word2) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for(int i=0;i<word1.length();i++){
            freq1[word1.charAt(i) - 'a']++;
        }

        for(int i=0;i<word2.length();i++){
            freq2[word2.charAt(i) - 'a']++;
        }

        int chars1 = 0;
        int chars2 = 0;
        int freqCheck1 = 0;
        int freqCheck2 = 0;

        for(int i=0;i<26;i++){
            if(freq1[i] != 0){
                chars1++;
                freqCheck1 += freq1[i];
            }
            if(freq2[i] != 0){
                chars2++;
                freqCheck2 += freq2[i];
            }
        }

        return ((chars1 == chars2) && (freqCheck1 == freqCheck2));
    }
}
