import java.sql.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;

class Connector {
    Connection dbConnection = null;

    /**
     *
     * @param dbURL Url to target DB - should start with "jdbc:postgresql://"
     * @param username
     * @param password
     */
    Connector(String dbURL, String username, String password) {
        try {
            Class.forName("org.postgresql.Driver"); // Ensures correct driver is loaded
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println("ALERT: Error selecting postgresql driver!");
            e.printStackTrace();
        }
        try {
            dbConnection = DriverManager.getConnection(dbURL, username, password);
        } catch(java.sql.SQLException e) {
            System.out.println("ALERT: Error establishing a database connection!");
            e.printStackTrace();
        }
    }

    /**
     * Closes a connection to the database
     * @throws IllegalStateException If no database is currently open
     */
    void closeDb () throws IllegalStateException {
        if (dbConnection == null) throw new IllegalStateException("ALERT: No connection to the database");
        try {
            dbConnection.close();
        } catch (java.sql.SQLException e) {
            System.out.println("ALERT: Error closing database connection!");
            e.printStackTrace();
        }
        dbConnection = null;
    }

    /**
     * Fetches categories currently present in the database
     * @return  an ArrayList of String in the first column of public.categories table.
     *          If no categories, empty ArrayList.
     * @throws IllegalStateException If called before a database connection is established
     * @throws NoSuchElementException If the database table public.categories is empty
     */
    ArrayList<String> getCategories() throws IllegalStateException, NoSuchElementException {
        if (dbConnection == null) throw new IllegalStateException("ALERT: No connection to the database");

        ArrayList<String> returnAList = new ArrayList<>();
        try {
            Statement categoriesStatement = dbConnection.createStatement();
            ResultSet rs = categoriesStatement.executeQuery("select * from categories");

            if (!rs.next()) { // rs.next() returns false when the query has no results
                throw new NoSuchElementException("ALERT: No categories in the database");
            } else {
                do {
                    returnAList.add(rs.getString(1));
                } while (rs.next());
            }
        } catch(java.sql.SQLException e) {
            System.out.println("ALERT: Failed getting categories from database!");
            e.printStackTrace();
        }
        return returnAList;
    }

    ArrayList<String> getCategoryDescription(String categoryName) throws IllegalStateException, NoSuchElementException {
        if (dbConnection == null) throw new IllegalStateException("ALERT: No connection to the database");

        ArrayList<String> returnAList = new ArrayList<>();
        try {
            Statement categoriyDescrStatement = dbConnection.createStatement();
            ResultSet rs = categoriyDescrStatement.executeQuery("select * from categories where event_type like '" + categoryName + "'");

            if (!rs.next()) { // rs.next() returns false when the query has no results
                throw new NoSuchElementException("ALERT: Category " + categoryName + " does not exist in the database");
            } else {
                do {
                    returnAList.add(rs.getString(2));
                    returnAList.add(rs.getString(3));
                } while (rs.next());
            }
        } catch(java.sql.SQLException e) {
            System.out.println("ALERT: Failed getting category description!");
            e.printStackTrace();
        }
        return returnAList;
    }
}
