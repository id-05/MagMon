import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.sun.deploy.cache.BaseLocalApplicationProperties;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.prefs.Preferences;

    public class MainForm extends TrayFrame{
    private CustomTable tableMain;
    public static DefaultTableModel tableModel = new DefaultTableModel();
    private JButton AddButton;
    private JTabbedPane TabPane1;
    private JButton deleteButton;
    private JButton checkConnectionButton;
    private JTextPane textPane1;
    private JTextArea textArea1;
    private JButton button1;
    private JPanel loglist;
    public static Preferences userPrefs;
    public static JsonParser parser = new JsonParser();
    JsonObject buffJson;
    public static ArrayList<MagMonRec> MagMonList = new ArrayList<>();

    public  MainForm() throws IOException {
        super();
        userPrefs = Preferences.userRoot().node("prefgemm");
        refrashTable();
        setToPreferredData();
        setContentPane(TabPane1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250,250,800,300);
        setLocationRelativeTo(null);
        TabPane1.setBackground(Color.orange);
        TabPane1.setForeground(Color.white);
        Font font = new Font("Verdana", Font.BOLD, 18);
        TabPane1.setFont(font);
        setTitle("GE Magnet Monitor 3 RemoteViewer");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        InitiaslTable();
        refrashTable();
        setVisible(true);

        AddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddMagMon();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tableMain.getSelectedRow()>=0){
                    String buf = userPrefs.get("JsonMagMonList", "{}");
                    buffJson = MainForm.parser.parse(buf).getAsJsonObject();
                    JsonEdit.DeleteRec(buffJson,tableMain.getSelectedRow());
                    InitiaslTable();
                    refrashTable();
                }
            }
        });

        checkConnectionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TabPane1.setSelectedIndex(1);
                if(tableMain.getSelectedRow()>=0) {
                    TabPane1.setSelectedIndex(1);

                    textArea1.append("Connection to Magnet Monitor: " + MagMonList.get(tableMain.getSelectedRow()).getName() );
                    textArea1.append("\n");
                    try {
                        WebHeandlessMagMon.autorise2(0,textArea1);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TimerTask timerTask = new MainTask(textArea1);
                Timer timer = new Timer(true);
                timer.scheduleAtFixedRate(timerTask, 0, 15*60*1000);
            }
        });
        tableMain.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(tableMain.getSelectedRow()>=0) {
                    new MagMonStatus(MagMonList.get(tableMain.getSelectedRow()));
                }
            }
        });
    }

    public void InitiaslTable(){
        String buf = userPrefs.get("JsonMagMonList", "{}");
        buffJson = MainForm.parser.parse(buf).getAsJsonObject();
        MagMonList = JsonEdit.GetMagMonList(buffJson);
        tableModel.setRowCount(0);
        Object[] columnsHeader = new String[]{"Name", "HePress",
                "He%","Water Temp 1", "Water Flow 1","Water Temp 2", "Water Flow 2", "Status", "Time"};
        tableModel.setColumnIdentifiers(columnsHeader);
        TableColumnModel tcm = tableMain.getColumnModel();
        TableColumn tm = tcm.getColumn(0);
        tm.setCellRenderer(new CustomCellRender());
    };

    public void refrashTable(){
        //настройка вывода и вида таблицы мониторов

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        Object[][] array = new String[MagMonList.size()][9];
        for (int i = 0; i <= MagMonList.size()-1; i++){
            array[i][0]=MagMonList.get(i).getName();
        }
        for (Object[] objects : array) tableModel.addRow(objects);
        tableMain.setFillsViewportHeight(true);
        tableMain.setDefaultRenderer(String.class, centerRenderer);
        tableMain.setModel(tableModel);
        for(int i=0; i <= tableMain.getColumnCount()-1; i++){
            tableMain.getColumn(tableMain.getColumnName(i)).setCellRenderer(centerRenderer);
        }
    }

    public void setToPreferredData()
    {
        String buf = userPrefs.get("JsonMagMonList", "{}");
    }

    public static void main(String[] args) throws IOException {
        new  MainForm();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
