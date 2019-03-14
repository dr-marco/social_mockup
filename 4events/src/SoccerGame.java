import java.lang.reflect.*;
import java.lang.Class.*;


public class SoccerGame extends Event {
    public Character gender;
    public Integer ageMin;
    public Integer ageMax;

    public SoccerGame(){
        super();
    }

    public String printArguments(){

        Field[] superFields = this.getClass().getSuperclass().getFields();
        Field[] currentFields = this.getClass().getDeclaredFields();//both public and private

        StringBuffer arguments= new StringBuffer();
        for (Field field:superFields) {
            arguments.append(field);//TODO cercare nomi nel json
            arguments.append("\n");
        }
        for (Field field:currentFields) {
            arguments.append(field);//TODO cercare nomi nel json
            arguments.append("\n");
        }
        return arguments.toString();

        //TODO sistemare ordine in cui stampa i fields della classe

    }

}
