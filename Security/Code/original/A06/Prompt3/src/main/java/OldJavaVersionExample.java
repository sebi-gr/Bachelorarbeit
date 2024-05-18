import java.util.Date;
import java.util.Calendar;

public class OldJavaVersionExample {
    public static void main(String[] args) {
        // Erstellen Sie ein Date-Objekt
        Date date = new Date();

        // Anzeigen des aktuellen Datums und der aktuellen Uhrzeit
        System.out.println("Aktuelles Datum und Uhrzeit: " + date);

        // Erstellen Sie ein Calendar-Objekt
        Calendar calendar = Calendar.getInstance();

        // Setzen Sie das Jahr, den Monat und den Tag des Monats mit dem Calendar-Objekt
        calendar.set(Calendar.YEAR, 2022);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        // Konvertieren Sie das Calendar-Objekt in ein Date-Objekt
        Date newDate = calendar.getTime();

        // Anzeigen des neuen Datums
        System.out.println("Neues Datum: " + newDate);
    }
}