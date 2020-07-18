import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ErrParseAnalyze {

    public static ArrayList<String> ErrParse(String sourcetext){
        ArrayList<String> result = null;
        ArrayList<String> ListStr = new ArrayList<String>();
        ArrayList<String> ListBuf = new ArrayList<String>();
        for (String retval : sourcetext.split("\\n")) {
            ListStr.add(retval);
        }
        for(int i=0; i<=ListStr.size()-1;i++){
            if(ListStr.get(i).contains("<")|(ListStr.get(i).length()<2)|(ListStr.get(i).contains("-"))){

            }
            else {
                ListBuf.add(ListStr.get(i).toString());
            }
        }
        return ListBuf;
    }
}
