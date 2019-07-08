import jdk.nashorn.internal.runtime.ParserException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CovertDate {
    public static void main(String[] args) {
        try{
//            SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy");
//            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//            System.out.println(formatter.format(parser.parse("02/06/1987")));
            String today = "21/12/2020";

            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = formatter.parse(today);
            long dateInLong = date.getTime();

            System.out.println("date = " + date);
            System.out.println("dateInLong = " + dateInLong);
            System.out.println(formatter.format(dateInLong));
        }
        catch (ParseException e){
            e.printStackTrace();
        }
    }
}
