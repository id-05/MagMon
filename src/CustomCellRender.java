
import javax.swing.*;
        import javax.swing.table.*;
        import java.awt.*;

class CustomCellRender extends DefaultTableCellRenderer {

    public CustomCellRender() {
        setOpaque(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        String number = (String)value;
        int val = Integer.parseInt(number);

        if(MainForm.MagMonList.get(row).getStatus().equals("ok")){
            setBackground(Color.green);
            System.out.println( "ok");
        }
        setEnabled(table == null || table.isEnabled()); // see question above

        if ((row % 2) == 0)
            setBackground(Color.green);
        else
            setBackground(Color.lightGray);

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        //setText(value !=null ? value.toString() : "");
        return this;
    }
}