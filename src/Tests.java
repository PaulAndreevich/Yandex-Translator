import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;


public class Tests {

    public static void main(String[] args) throws IOException {

        String source = new String();
        String target =  new String();
        String output =  new String();

        String input = new String();

        System.out.print("Tests");

        System.out.print("\nTest 1 :  ");

        Map<String, String> languages = Translator.getLanguages();

        input = "Hello, my name is Jeff";
        input = URLEncoder.encode(input, "UTF-8");
        source = Translator.detectLanguage(input);
        target = Translator.getKey(languages, "russian");
        output = Translator.translate(input, source, target);
        //System.out.println("Перевод на русский:" + output + "-");

        if (output.equals("Привет, Меня зовут Джефф")) {System.out.print(" Passed ");}
            else {System.out.print(" FAILED ");}

        System.out.print("\nTest 2 :  ");

        input = "China fires back in trade war with US";
        input = URLEncoder.encode(input, "UTF-8");
        source = Translator.detectLanguage(input);
        target = Translator.getKey(languages, "russian");
        output = Translator.translate(input, source, target);
        //System.out.println("Перевод на русский:" + output + "-");


        if (output.equals("Китай отстреливается в торговую войну с США")) {System.out.print(" Passed ");}
        else {System.out.print(" FAILED ");}


        System.out.print("\nTest 3 :  ");

        input = "I want to be a programmer";
        input = URLEncoder.encode(input, "UTF-8");
        source = Translator.detectLanguage(input);
        target = Translator.getKey(languages, "russian");
        output = Translator.translate(input, source, target);
        //System.out.println("Перевод на русский:" + output + "-");


        if (output.equals("Я хочу быть программистом")) {System.out.print(" Passed ");}
        else {System.out.print(" FAILED ");}

    }
}
