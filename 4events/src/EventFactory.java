/**
 * A factory class to generate Event subclasses
 */
public class EventFactory {

    /**
     *
     * @param className A String referring to the first column in categories table of the DB
     * @return  SoccerGame  if provided soccer_game
     *          void        if provided any other string
     * @throws IllegalArgumentException if given className isn't a known type
     */
    public Event createEvent (String className) {
        Event returnEvent = null;

        switch (className) { // Iterates over different classes present in the DB
            case "soccer_game":
                returnEvent = new SoccerGame();
                break;
            default:
                throw new IllegalArgumentException("ALERT: unknown event type: " + className);
        }
        return returnEvent;
    }
}
