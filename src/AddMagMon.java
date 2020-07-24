import com.google.gson.JsonObject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddMagMon extends JFrame {
    private JButton okButton;
    private JButton cancelButton;
    private JFormattedTextField editPass;
    private JFormattedTextField editIP;
    private JFormattedTextField editPort;
    private JFormattedTextField editLogin;
    private JPanel MainPanel;
    private JFormattedTextField editName;
    public static ArrayList<MagMonRec> MagMonList = new ArrayList<>();

    public AddMagMon()
    {
        setContentPane(MainPanel);
        setBounds(250, 250, 250, 300);
        setLocationRelativeTo(null);
        MainPanel.setBackground(Color.orange);
        MainPanel.setForeground(Color.white);
        Font font = new Font("Verdana", Font.CENTER_BASELINE, 18);
        MainPanel.setFont(font);
        setTitle("Add Magnet Monitor");
        setVisible(true);

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if((!editName.getText().equals(""))
                        &&(!editIP.getText().equals(""))
                            &&(!editPort.getText().equals(""))
                                && (!editLogin.getText().equals(""))
                                    &&(!editPass.getText().equals("")))
                    {
                        String buf = MainForm.userPrefs.get("JsonMagMonList", "{}");
                        JsonObject buffJson = MainForm.parser.parse(buf).getAsJsonObject();

                        MagMonRec node = new MagMonRec();
                        node.setName(editName.getText());
                        node.setIP(editIP.getText());
                        node.setPort(editPort.getText());
                        node.setLogin(editLogin.getText());
                        node.setPass(editPass.getText());

                        JsonObject NewJson = JsonEdit.AddRec(buffJson, node);
                        MainForm.userPrefs.put("JsonMagMonList", NewJson.toString());
                        MagMonList = JsonEdit.GetMagMonList(NewJson);
                        Object[] array = new String[6];
                        array[0]=node.getName();
                        MainForm.tableModel.addRow(array);

                        dispose();
                    }
                else{
                    JOptionPane.showMessageDialog(null,"EMPTY FIELD!");
                }
            }
        });
    }
}
