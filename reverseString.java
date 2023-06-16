import java.util.Scanner;

public class reverseString {

    public static void main(String[] args) {
        String str = "entoto";

        char[] charArray = str.toCharArray();
        int left = 0;
        int right = charArray.length - 1;

        while (left < right) {

            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;

            left++;
            right--;
        }

        System.out.println(new String(charArray));
    }
}

//    The time complexity of this program is O(n). n is the length of the string
