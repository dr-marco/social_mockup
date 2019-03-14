import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String args[]) {
        SoccerGame game = new SoccerGame();

        // TODO should following code be moved to a helper json class or in the Event class?
        try ( InputStream inputStream = new FileInputStream("4events/res/IT_EventDescr.json") ) {
            JSONTokener tokener = new JSONTokener(inputStream);
            JSONObject object = new JSONObject(tokener);

            for (String field : game.getFields())
                try {
                    String name = object.getJSONObject(field).getString("name");
                    System.out.println(name);
                } catch (JSONException e) {
                    System.out.println("Missing element in json file: " + field);
                }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
