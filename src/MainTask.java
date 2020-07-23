import javax.swing.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
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
        Date date = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("HH:mm:ss");
        for(int i=0; i<=MainForm.MagMonList.size()-1;i++) {

            try {
                WebHeandlessMagMon.autorise(i, LogOut);
                WebHeandlessMagMon.getData(i, LogOut);
                MainForm.tableModel.setRowCount(0);
                    array[i][0] = MainForm.MagMonList.get(i).getName();
                    array[i][1] = MainForm.MagMonList.get(i).getHePress();
                    array[i][2] = MainForm.MagMonList.get(i).getHeLevel();
                    array[i][3] = MainForm.MagMonList.get(i).getWaterTemp1();
                    array[i][4] = MainForm.MagMonList.get(i).getWaterFlow1();
                    array[i][5] = MainForm.MagMonList.get(i).getWaterTemp2();
                    array[i][6] = MainForm.MagMonList.get(i).getWaterFlow2();
                    array[i][7] = MainForm.MagMonList.get(i).getStatus();
                    array[i][8] = MainForm.MagMonList.get(i).getLastTime();
            } catch (IOException e) {
                MainForm.tableModel.setRowCount(0);
                array[i][0] = MainForm.MagMonList.get(i).getName();
                array[i][7] = "No Connect";
                array[i][8] = formatForDateNow.format(date);
                e.printStackTrace();
            }
        }
            for (Object[] objects : array) MainForm.tableModel.addRow(objects);
    }
}
