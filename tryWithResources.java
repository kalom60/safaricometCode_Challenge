import java.io.BufferedReader;
import java.io.FileReader;

public class tryWithResources {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(
                new FileReader("/Users/rollin/Github/safaricometCode_Challenge\n"))) {
            String line = br.readLine();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
