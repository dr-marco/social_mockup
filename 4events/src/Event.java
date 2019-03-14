import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.UUID;

abstract class Event {
    private UUID eventID;//id dell'evento sul database
    private UUID creatorID;//id unico del creatore dell'evento
    private Category eventType;
    public String title;
    public Integer participantsNum;
    public Calendar deadline;
    public String location;
    public Calendar startDate;
    public Calendar duration;//è un oggetto calendar successivo a start_date che sarà usato per calcolare un intervallo di tempo
    public Double cost;
    public String inQuota;
    public Calendar endDate;
    public String notes;


    public Event() {
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
