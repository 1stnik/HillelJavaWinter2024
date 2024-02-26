package validate;

import java.util.Locale;

public class GroupNumberValidator {

    public static boolean validateNumber(String groupNumber){
       // format GR-XX
       if (groupNumber.length() > 5){
           return false;
       }

       if (!groupNumber.toUpperCase(Locale.ROOT).startsWith("GR-")){
           return false;
       }

       return true;
    }

}
