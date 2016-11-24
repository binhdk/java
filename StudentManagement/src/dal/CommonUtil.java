package dal;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CommonUtil {

    public static void removeColumn(int index, JTable tbl) {
        int nRow = tbl.getRowCount();//gom ca dong header.
        int nCol = tbl.getColumnCount() - 1;
        Object[][] cells = new Object[nRow][nCol];
        String[] names = new String[nCol];

        for (int j = 0; j < nCol; j++) {
            if (j < index) {
                names[j] = tbl.getColumnName(j);
                for (int i = 0; i < nRow; i++) {
                    cells[i][j] = tbl.getValueAt(i, j);
                }
            } else {
                names[j] = tbl.getColumnName(j + 1);
                for (int i = 0; i < nRow; i++) {
                    cells[i][j] = tbl.getValueAt(i, j + 1);
                }
            }
        }

        DefaultTableModel mod = new DefaultTableModel(cells, names);
        tbl.setModel(mod);
    }
}
