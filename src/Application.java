import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Scanner;

public class Application {

        public static void main(String[] args) throws IOException {

            Map<String, String> languages = Translator.getLanguages();

            Scanner sc = new Scanner(System.in);
            System.out.print("\nВведите строку на английском для перевода:  ");
            String input = sc.nextLine();

            input = URLEncoder.encode(input, "UTF-8");

            String source = Translator.detectLanguage(input);
            String target = Translator.getKey(languages, "russian");

            String output = Translator.translate(input, source, target);

            System.out.println("Перевод на русский:" + output);
        }

}
