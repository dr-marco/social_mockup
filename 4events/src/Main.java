import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String args[]) {
        jsonConfigReader config = new jsonConfigReader("4events/res/config.json");
        Connector myConnector = new Connector(config.getDBURL(), config.getDBUser(), config.getDBPassword());

        Menu menu = new Menu(myConnector);
        menu.printFields();

        myConnector.closeDb();
    }

    /**
     * Nested class that's used to store the JSONObject representation of the configuration on disk.
     */
    static class jsonConfigReader {
        JSONObject jsonContent;

        /**
         * Initializes the config with a given json file
         * @param jsonPath Path to the json file to load
         */
        public jsonConfigReader (String jsonPath) {
            try (InputStream inputStream = new FileInputStream(jsonPath) ) {
                JSONTokener tokener = new JSONTokener(inputStream);
                jsonContent = new JSONObject(tokener);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        public String getDBURL () throws JSONException {
            return jsonContent.getString("db_url");
        }

        public String getDBPassword () throws JSONException {
            return jsonContent.getString("db_password");
        }

        public String getDBUser () throws JSONException {
            return jsonContent.getString("db_username");
        }
    }
}
