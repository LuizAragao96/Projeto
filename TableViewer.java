
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class TableViewer extends JFrame {
    public TableViewer() {
        setTitle("Visualizar Tabela");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        JTable table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios")) {

            ResultSetMetaData metaData = rs.getMetaData();
            int columns = metaData.getColumnCount();
            String[] colNames = new String[columns];
            for (int i = 0; i < columns; i++) {
                colNames[i] = metaData.getColumnName(i + 1);
            }

            DefaultTableModel model = new DefaultTableModel(colNames, 0);

            while (rs.next()) {
                Object[] row = new Object[columns];
                for (int i = 0; i < columns; i++) {
                    row[i] = rs.getObject(i + 1);
                }
                model.addRow(row);
            }

            table.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao carregar dados.");
        }
    }
}
