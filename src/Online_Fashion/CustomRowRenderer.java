
package Online_Fashion;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class CustomRowRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

       
        if (row % 2 == 0) {
           
            component.setBackground(new Color(220, 220, 255));
        } else {
           
            component.setBackground(new Color(255, 255, 220));
        }

        return component;
    }
}


