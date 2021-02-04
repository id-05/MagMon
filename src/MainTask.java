import javax.swing.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimerTask;

public class MainTask extends TimerTask {

    JTextArea LogOut;

    public MainTask(/*JTextArea LogOut*/){
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
                    array[i][1] = MainForm.MagMonList.get(i).getHePress();
                    array[i][2] = MainForm.MagMonList.get(i).getHeLevel();
                    array[i][3] = MainForm.MagMonList.get(i).getWaterTemp1();
                    array[i][4] = MainForm.MagMonList.get(i).getWaterFlow1();
                    array[i][5] = MainForm.MagMonList.get(i).getWaterTemp2();
                    array[i][6] = MainForm.MagMonList.get(i).getWaterFlow2();
                    array[i][7] = MainForm.MagMonList.get(i).getStatus();
                    array[i][8] =formatForDateNow.format(currentDate);
                    /*
                    LogOut.append(formatForDateNow.format(currentDate)+
                        ":   Name: "+MainForm.MagMonList.get(i).getName()+ "; HePress: "+MainForm.MagMonList.get(i).getHePress()+
                        "; HeLevel: "+MainForm.MagMonList.get(i).getHeLevel()+ "; WaterTemp1: "+MainForm.MagMonList.get(i).getWaterTemp1()+
                        "; WaterFlow1: "+MainForm.MagMonList.get(i).getWaterFlow1()+
                                    "; WaterTemp2: "+MainForm.MagMonList.get(i).getWaterTemp2()+ "; WaterFlow2:"+MainForm.MagMonList.get(i).getWaterFlow2()+
                                "; Status: "+MainForm.MagMonList.get(i).getStatus()+ "\n");
                    */
                    if(MainForm.BotMode){
                        MainForm.bot.sendMsg(MainForm.ChatId,
                                MainForm.MagMonList.get(i).getName()+ "\n HePress: "+MainForm.MagMonList.get(i).getHePress()+
                                "\n HeLevel: "+MainForm.MagMonList.get(i).getHeLevel()+
                                        "\n WaterTemp1: "+MainForm.MagMonList.get(i).getWaterTemp1()+
                                "\n WaterFlow1: "+MainForm.MagMonList.get(i).getWaterFlow1()+
                                "\n WaterTemp2: "+MainForm.MagMonList.get(i).getWaterTemp2()+ "\n WaterFlow2:"+MainForm.MagMonList.get(i).getWaterFlow2()+
                                "\n Status: "+MainForm.MagMonList.get(i).getStatus());
                    }else{
                        if(MainForm.MagMonList.get(i).getStatusChange()){
                            //сюда добавить все ошибки
                            String errors = "";
                            if(MainForm.MagMonList.get(i).getErrors().size()>0){
                                ArrayList<String> bufList = MainForm.MagMonList.get(i).getErrors();
                                for (int j = 0; j <= bufList.size() - 1; j++) {
                                    errors = errors + bufList.get(j) + "\n";
                                }
                            }
                            MainForm.bot.sendMsg(MainForm.ChatId,MainForm.MagMonList.get(i).getName()+ "\n Status: "+MainForm.MagMonList.get(i).getStatus()+"\n"+errors);
                        }
                    }
                }else{
                    array[i][0] = MainForm.MagMonList.get(i).getName();
                    array[i][7] = "No Connect";
                    array[i][8] = formatForDateNow.format(currentDate);

                    if(MainForm.MagMonList.get(i).getStatusChange()==null){
                        MainForm.MagMonList.get(i).setStatusChange(true);
                    }

                    ArrayList<String> bufList = new ArrayList<>();
                    bufList.add("No Connect");
                    MainForm.MagMonList.get(i).setErrors(bufList);
                    System.out.println(MainForm.MagMonList.get(i).getStatusChange());

                    if(MainForm.MagMonList.get(i).getStatusChange()){
                        MainForm.bot.sendMsg(MainForm.ChatId,MainForm.MagMonList.get(i).getName()+ "\n Status: No Connect");
                        MainForm.MagMonList.get(i).setStatusChange(false);
                    }

                    MainForm.MagMonList.get(i).setLastTime(formatForDateNow.format(currentDate));
                    //LogOut.append(formatForDateNow.format(currentDate)+ ":   Name: "+MainForm.MagMonList.get(i).getName()+ "; Status: No Connect"+ "\n");
                }
            } catch (IOException e) {
                System.out.println(e.getMessage().toString());
            }
        }
        MainForm.tableModel.setRowCount(0);
             for (Object[] objects : array) MainForm.tableModel.addRow(objects);
    }
}
