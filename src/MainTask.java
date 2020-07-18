import sun.rmi.runtime.Log;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.Time;
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
        Date date = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("'время' hh:mm:ss");
        LogOut.append(" Процесс запушен = "+ formatForDateNow.format(date) +"\n");
        try {
            WebHeandlessMagMon.autorise2(0, LogOut) ;
            WebHeandlessMagMon.autorise3(0, LogOut) ;

            MainForm.tableModel.setRowCount(0);
            Object[][] array = new String[MainForm.MagMonList.size()][9];
            for (int i = 0; i <= MainForm.MagMonList.size()-1; i++){
                array[i][0]=MainForm.MagMonList.get(i).getName();
                array[i][1]=MainForm.MagMonList.get(i).getHePress();
                array[i][2]=MainForm.MagMonList.get(i).getHeLevel();
                array[i][3]=MainForm.MagMonList.get(i).getWaterTemp1();
                array[i][4]=MainForm.MagMonList.get(i).getWaterFlow1();
                array[i][5]=MainForm.MagMonList.get(i).getWaterTemp2();
                array[i][6]=MainForm.MagMonList.get(i).getWaterFlow2();
                array[i][7]=MainForm.MagMonList.get(i).getStatus();
                array[i][8]=MainForm.MagMonList.get(i).getLastTime();
            }
            for (Object[] objects : array) MainForm.tableModel.addRow(objects);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
