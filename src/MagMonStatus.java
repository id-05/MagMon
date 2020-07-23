import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MagMonStatus extends JFrame {
    MagMonRec MagMon;
    private JPanel MainPanel;
    private JTextField textName;
    private JTextField textHePress;
    private JTextField textHeLevel;
    private JTextField textWT1;
    private JTextField textWF1;
    private JTextField textWT2;
    private JTextField textWF2;
    private JTextField textUpdate;
    private JTextArea textArea1;

    public MagMonStatus(MagMonRec MagMon){
        this.MagMon = MagMon;
        setContentPane(MainPanel);
        setBounds(250, 250, 350, 300);
        setLocationRelativeTo(null);
        //MainPanel.setBackground(Color.orange);
        //MainPanel.setForeground(Color.white);
        Font font = new Font("Verdana", Font.CENTER_BASELINE, 18);
        MainPanel.setFont(font);
        setTitle("Magnet Monitor "+MagMon.getName()+" Status");
        setVisible(true);
        textName.setText(MagMon.getName());
        textHePress.setText(MagMon.getHePress());
        textHeLevel.setText(MagMon.getHeLevel());
        textWT1.setText(MagMon.getWaterTemp1());
        textWF1.setText(MagMon.getWaterFlow1());
        textWT2.setText(MagMon.getWaterTemp2());
        textWF2.setText(MagMon.getWaterFlow2());
        textUpdate.setText(MagMon.getLastTime());
        textArea1.append(" Errors:"+"\n");
        ArrayList<String> bufList = MagMon.getErrors();
        for(int i=0; i<=bufList.size()-1;i++){
            textArea1.append(bufList.get(i)+"\n");
        }
    }
}
