// 2. Создать программу, которая переворачивает вводимые строки (читает справа налево).
package reverseString;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseString {
    public static void main (String[]args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reverse(reader.readLine());
        System.out.println(s);
    }

    public static String reverse (String string) {
        String newString = "";
        for (int i=string.length()-1; i >= 0; i--) {
            newString += string.charAt(i);
        }
        return newString;
    }


}
