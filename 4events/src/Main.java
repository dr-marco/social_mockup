public class Main {
    public static void main(String args[]) {
        String dbURL = "jdbc:postgresql://localhost:5432/four_events_db"; // TODO move to config file
        String username = "REDACTED"; // TODO same
        String password = "REDACTED"; // TODO same
        Connector myConnector = new Connector(dbURL, username, password);
        myConnector.testConnection();
        myConnector.closeDb();
    }
}
