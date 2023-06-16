import java.util.Scanner;

public class magicNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number");
        int  num = scanner.nextInt();

        int total = 0;
        while (num > 0 || total > 9)
        {
            if (num == 0)
            {
                num = total;
                total = 0;
            }
            total += num % 10;
            num /= 10;
        }

        if(total == 1) {
            System.out.println("It is a magic number");
        }else {
            System.out.println("It is not a magic number");
        }
    }
}


// the time complexity of this program is O(n) because it is a linear search.

