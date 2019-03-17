import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Menu {

    public Menu() {/* TODO stub constructor, remove this */};

    // TODO remove this testing method
    public void testMenu() {
        Event game = new SoccerGame();
        jsonTranslator eventJson = new jsonTranslator("4events/res/IT_EventDescr.json");

        for (String field : game.getFields()) {
            System.out.println(eventJson.getName(field));
        }
    } // TODO testing method end

    /**
     * Nested class that's used to store the JSONObject representation of a json file on disk.
     */
    class jsonTranslator {
        JSONObject jsonContent;

        /**
         *
         * @param jsonPath Path to the json file to be loaded
         */
        public jsonTranslator (String jsonPath) {
            try (InputStream inputStream = new FileInputStream(jsonPath) ) {
                JSONTokener tokener = new JSONTokener(inputStream);
                jsonContent = new JSONObject(tokener);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        /**
         * Translates a field to a human readable text
         * @param field The field to search for in json file
         * @return <String> The name corresponding to field
         */
        public String getName (String field) {
            try {
                String name = jsonContent.getJSONObject(field).getString("name");
                return name;
            } catch (JSONException e) {
                return ("ALERT: Missing element in json file: " + field);
            }
        }

        /**
         * Translates a field to a human readable description
         * @param field The field to search for in json file
         * @return <String> The description corresponding to field
         */
        public String getDescr (String field) {
            try {
                String name = jsonContent.getJSONObject(field).getString("descr");
                return name;
            } catch (JSONException e) {
                return ("ALERT: Missing element in json file: " + field);
            }
        }
    }
}
