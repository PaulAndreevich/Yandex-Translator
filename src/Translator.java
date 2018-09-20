
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.net.URL;
import java.util.*;

public class Translator {
    public static String ApiKey = "trnsl.1.1.20180918T164130Z.f402d57534157be4.de44308988d58a73dfea86624370ccc60b225f08";

    private static String request(String URL) throws IOException{

        System.out.print(URL + "    ");

        URL url = new URL(URL);

        URLConnection urlConnection = url.openConnection();

        urlConnection.addRequestProperty("User-Yandex", "Yandex");

        InputStream inStream = urlConnection.getInputStream();

        String received = new BufferedReader(new InputStreamReader(inStream)).readLine();

        inStream.close();
        return received;
    }


    public static Map<String,String> getLanguages() throws IOException{
        String languages = request("https://translate.yandex.net/api/v1.5/tr.json/getLangs?key=" + ApiKey + "&ui=en");

        languages = languages.substring(languages.indexOf("langs") + 7);

        languages = languages.substring(0, languages.length() - 1);

        String[] splitLangs = languages.split(",");

        Map<String, String> allLanguages = new HashMap<String, String>();

        for (String s : splitLangs) {
            String[] s2 = s.split(":");

            String key = s2[0].substring(1, s2[0].length() - 1);
            String value = s2[1].substring(1, s2[1].length() - 1);

            allLanguages.put(key, value);
        }
        return allLanguages;
    }

    public static String translate(String text, String sourceLang, String targetLang) throws IOException {
        String response = request("https://translate.yandex.net/api/v1.5/tr.json/translate?key=" + ApiKey + "&text=" + text + "&lang=" + sourceLang + "-" + targetLang);
        return response.substring(response.indexOf("text") + 8, response.length()-3);
    }

    public static String detectLanguage(String text) throws IOException {
        String response = request("https://translate.yandex.net/api/v1.5/tr.json/detect?key=" + ApiKey + "&text=" + text);
        return response.substring(response.indexOf("lang") + 7, response.length()-2);
    }

    public static String getKey(Map<String, String> map, String value) {
        for (String key : map.keySet()) {
            if (map.get(key).equalsIgnoreCase(value)) {
                return key;
            }
        }
        return null;
    }

}
