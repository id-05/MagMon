import javax.swing.*;
import java.awt.*;

public class MagMonStatus extends JFrame {
    MagMonRec MagMon;
    private JPanel MainPanel;

    public MagMonStatus(MagMonRec MagMon){
        this.MagMon = MagMon;
        setContentPane(MainPanel);
        setBounds(250, 250, 350, 300);
        setLocationRelativeTo(null);
        MainPanel.setBackground(Color.orange);
        MainPanel.setForeground(Color.white);
        Font font = new Font("Verdana", Font.CENTER_BASELINE, 18);
        MainPanel.setFont(font);
        setTitle("Magnet Monitor "+MagMon.getName()+" Status");
        setVisible(true);
    }
}
