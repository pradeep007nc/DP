package prac;

public class AddBinary {

    public static void main(String[] args) {
        System.out.println(addBinary("1010", "1011"));
    }

    public static String addBinary(String str1, String str2) {
        StringBuilder ans = new StringBuilder();
        int i = str1.length() - 1;
        int j = str2.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry>0) {
            if (i >= 0)
                carry += str1.charAt(i--) - '0';
            if (j >= 0)
                carry += str2.charAt(j--) - '0';
            ans.append(carry % 2);
            carry = carry/2;
        }
        return ans.reverse().toString();
    }

}



