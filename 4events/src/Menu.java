import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.security.SecureRandom;

class Menu {
    private static final String MENU_JSON_PATH = "./4events/res/IT_MenuDescr.json";

    private Connector myConnector;
    private jsonTranslator menuTranslation;

    /**
     *
     * @param dbConnector a Connector to the local database
     */
    Menu (Connector dbConnector) {
        this.myConnector = dbConnector;
        Path menuJsonPath = Paths.get(MENU_JSON_PATH);
        menuTranslation = new jsonTranslator(menuJsonPath.toString());
    }

    void printWelcome() {
        System.out.println(menuTranslation.getTranslation("welcome"));
    }

    void printEnd() {
        System.out.println(menuTranslation.getTranslation("end"));
    }

    void printExit() {
        System.out.println(menuTranslation.getTranslation("exit"));
    }

    /**
     * Prints name and description of available categories' fields
     */
    void printFields() {
        System.out.println(menuTranslation.getTranslation("categoryList"));

        EventFactory factory = new EventFactory(myConnector);
        jsonTranslator eventJson = new jsonTranslator(Event.getJsonPath());

        for (String eventType: myConnector.getCategories()) {
            Event game = factory.createEvent(eventType);
            System.out.println(game.getCatName() + "\n\t" + game.getCatDescription() + '\n');

            for (String field : game.getFields()) {
                System.out.println(eventJson.getName(field) + ":\n\t" + eventJson.getDescr(field) + '\n');
            }
        }
    }

    /**
     * Nested class that's used to store the JSONObject representation of a translation on disk.
     */
    class jsonTranslator {
        JSONObject jsonContent;

        /**
         * Instantiate a jsonTranslator object with the given json file
         * @param jsonPath Path to the json file to load
         */
        jsonTranslator (String jsonPath) {
            try (InputStream inputStream = new FileInputStream(jsonPath) ) {
                JSONTokener tokener = new JSONTokener(inputStream);
                jsonContent = new JSONObject(tokener);

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        String getTranslation (String key) {
            try {
                return jsonContent.getString(key);
            } catch (JSONException e) {
                return ("ALERT: Missing element in json file: " + key);
            }
        }

        /**
         * Translates a field to a human readable text
         * @param field The field to search for in json file
         * @return <String> The name corresponding to field
         */
        String getName (String field) {
            try {
                return jsonContent.getJSONObject(field).getString("name");
            } catch (JSONException e) {
                return ("ALERT: Missing element in json file: " + field);
            }
        }

        /**
         * Translates a field to a human readable description
         * @param field The field to search for in json file
         * @return <String> The description corresponding to field
         */
        String getDescr (String field) {
            try {
                return jsonContent.getJSONObject(field).getString("descr");
            } catch (JSONException e) {
                return ("ALERT: Missing element in json file: " + field);
            }
        }
    }
}
