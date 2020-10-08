import javax.swing.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimerTask;

public class MainTask extends TimerTask {

    JTextArea LogOut;

    public MainTask(JTextArea LogOut){
        this.LogOut = LogOut;
    }

    @Override
    public void run() {
        Object[][] array = new String[MainForm.MagMonList.size()][9];
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("HH:mm");
        Date currentDate = new Date();
        for(int i=0; i<=MainForm.MagMonList.size()-1;i++) {
            try {
                boolean autoriseOk = WebHeandlessMagMon.autorise(i, LogOut);
                System.out.println(" Autorise " + autoriseOk);
                if(autoriseOk){
                    WebHeandlessMagMon.getData(i, LogOut);
                    array[i][0] = MainForm.MagMonList.get(i).getName();
                    array[i] [1] = MainForm.MagMonList.get(i).getHePress();
                    array[i][2] = MainForm.MagMonList.get(i).getHeLevel();
                    array[i][3] = MainForm.MagMonList.get(i).getWaterTemp1();
                    array[i][4] = MainForm.MagMonList.get(i).getWaterFlow1();
                    array[i][5] = MainForm.MagMonList.get(i).getWaterTemp2();
                    array[i][6] = MainForm.MagMonList.get(i).getWaterFlow2();
                    array[i][7] = MainForm.MagMonList.get(i).getStatus();
                    array[i][8] =formatForDateNow.format(currentDate);
                    LogOut.append(formatForDateNow.format(currentDate)+
                        ":   Name: "+MainForm.MagMonList.get(i).getName()+ "; HePress: "+MainForm.MagMonList.get(i).getHePress()+
                        "; HeLevel: "+MainForm.MagMonList.get(i).getHeLevel()+ "; WaterTemp1: "+MainForm.MagMonList.get(i).getWaterTemp1()+
                        "; WaterFlow1: "+MainForm.MagMonList.get(i).getWaterFlow1()+
                                    "; WaterTemp2: "+MainForm.MagMonList.get(i).getWaterTemp2()+ "; WaterFlow2:"+MainForm.MagMonList.get(i).getWaterFlow2()+
                                "; Status: "+MainForm.MagMonList.get(i).getStatus()+ "\n");
                }else{
                    array[i][0] = MainForm.MagMonList.get(i).getName();
                    array[i][7] = "No Connect";
                    array[i][8] = formatForDateNow.format(currentDate);
                    ArrayList<String> bufList = new ArrayList<>();
                    bufList.add("No Connect");
                    MainForm.MagMonList.get(i).setErrors(bufList);
                    MainForm.MagMonList.get(i).setLastTime(formatForDateNow.format(currentDate));
                    LogOut.append(formatForDateNow.format(currentDate)+ ":   Name: "+MainForm.MagMonList.get(i).getName()+ "; Status: No Connect"+ "\n");
                    System.out.println("error connect");
                }
            } catch (IOException e) {
                System.out.println(e.getMessage().toString());
            }
        }
        MainForm.tableModel.setRowCount(0);
             for (Object[] objects : array) MainForm.tableModel.addRow(objects);
    }
}
