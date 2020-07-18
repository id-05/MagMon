import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CustomTable extends JTable {
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
