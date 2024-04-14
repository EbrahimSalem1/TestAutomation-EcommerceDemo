package utilities;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;

public class DataDrivenClass {



    public static class JsonClass {

        public static String readJson(String filePath, String key){
            JSONObject jsonObject = null;
            try {
                jsonObject = (JSONObject) new JSONParser().parse(new FileReader(filePath));
            } catch (IOException e) {
                throw new RuntimeException("JsonFile Path not found!");
            } catch (ParseException e) {
                throw new RuntimeException("Cannot Parse Key entered!");
            }

            if (jsonObject.get(key) == null) {
                throw new RuntimeException("Invalid Key Entered!");
            }
            return (String) jsonObject.get(key);
        }

    }
}