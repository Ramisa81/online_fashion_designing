package Online_Fashion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.Timer;

public class Order extends JFrame {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/invoice";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "database1";

    static public String email;
    private String trackingCode;

    private static final int APP_WIDTH = 1080;
    private static final int APP_HEIGHT = 720;

    private JPanel mainPanel;
    private JProgressBar progressBar;  // Make sure this field is initialized
    private JTextArea orderStatusTextArea;
    private JButton redirectButton;
    
    private Timer timer;
    private int orderCount;
    private int currentOrderIndex;

    

    public Order(String email) {
        this.timer = new Timer(0, null);
        this.orderCount = 0;
        this.currentOrderIndex = 0;
        this.email = email;
        setSize(APP_WIDTH, APP_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initializeUI();

        trackOrders(email);
    }

    private void initializeUI() {
    mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout());

    // Top Panel with Label
    JPanel topPanel = new JPanel();
    topPanel.setBackground(new Color(52, 152, 219)); // Professional color
    JLabel yourOrdersLabel = new JLabel("Your Orders");
    yourOrdersLabel.setForeground(Color.WHITE);
    topPanel.add(yourOrdersLabel);
    mainPanel.add(topPanel, BorderLayout.NORTH);

    // Center Panel for Order Status and Progress Bar
    JPanel centerPanel = new JPanel();
    centerPanel.setLayout(new BorderLayout());

    // Order Status
    JPanel orderStatusPanel = new JPanel();
    orderStatusPanel.setLayout(new BorderLayout());
    orderStatusPanel.setBackground(new Color(201, 196, 15)); // Professional color

    orderStatusTextArea = new JTextArea();
    orderStatusTextArea.setEditable(false);
    orderStatusTextArea.setFont(new Font("Arial", Font.PLAIN, 14));
    JScrollPane scrollPane = new JScrollPane(orderStatusTextArea);
    orderStatusPanel.add(scrollPane, BorderLayout.CENTER);

    centerPanel.add(orderStatusPanel, BorderLayout.CENTER);

    // Progress Bar
    progressBar = new JProgressBar(0, 60 * 60); // Initialize the progressBar here
    progressBar.setStringPainted(true);
    centerPanel.add(progressBar, BorderLayout.SOUTH);

    mainPanel.add(centerPanel, BorderLayout.CENTER);

    // Footer Panel with Redirect Button and Invoice Button
    JPanel footerPanel = new JPanel();
    footerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));
    footerPanel.setBackground(new Color(44, 62, 80)); // Professional color

    redirectButton = new JButton("Continue Shopping");
    redirectButton.setForeground(Color.WHITE);
    redirectButton.setBackground(new Color(41, 128, 185)); // Professional color
    redirectButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            whom s = new whom(email);
            s.show();
            dispose();
        }
    });
    footerPanel.add(redirectButton);

    JButton invoiceButton = new JButton("Invoice");
    invoiceButton.setForeground(Color.WHITE);
    invoiceButton.setBackground(new Color(41, 128, 185)); // Professional color
    invoiceButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            displayFullInvoice();
        }
    });
    footerPanel.add(invoiceButton);

    mainPanel.add(footerPanel, BorderLayout.SOUTH);

    add(mainPanel);
}
    
    private void displayFullInvoice() {
    // Replace this with the logic to display the full invoice
    // You may want to create a new JFrame or dialog to show the invoice details
    Invoice invoice = new Invoice(email);
    invoice.setVisible(true);
}

        private void trackOrders(String email) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String selectSql = "SELECT * FROM delivery WHERE email=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
                preparedStatement.setString(1, email);

                ResultSet resultSet = preparedStatement.executeQuery();
                orderCount = 0;

                while (resultSet.next()) {
                    String trackingCode = resultSet.getString("code");
                    String invoice = setTrackingCode(trackingCode);

                    orderCount++;
                    orderStatusTextArea.append("Order " + orderCount + ": Tracking Code - " + trackingCode + "\n");
                    orderStatusTextArea.append("Invoice:\n" + invoice + "\n\n");

                    // Update the right panel with tracking numbers

                    // Set up timer for each order
                    setupOrderTimer();

                    currentOrderIndex++;
                }

                if (orderCount == 0) {
                    orderStatusTextArea.append("No orders found for the provided email.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void setupOrderTimer() {
        int maxMinutes = 10;
        int updateInterval = 1000; // Update every 1 second
        int maxProgress = maxMinutes * 60 * 1000 / updateInterval;

        timer = new Timer(updateInterval, e -> {
            int value = progressBar.getValue();
            int percentage = (int) (((double) value / maxProgress) * 100);

            if (value < maxProgress) {
                progressBar.setValue(value + 1);

                // Set background color dynamically based on progress percentage
                Color backgroundColor = calculateBackgroundColor(percentage);
                progressBar.setBackground(backgroundColor);

                progressBar.setString(percentage + "%");
            } else {
                ((Timer) e.getSource()).stop();
                // Reset progress bar for the next order
                progressBar.setValue(0);
                progressBar.setBackground(Color.WHITE);
            }
        });
        timer.setInitialDelay(0); // Start immediately
        timer.setDelay(updateInterval);
        timer.start();
    }

    public String setTrackingCode(String trackingCode) {
        this.trackingCode = trackingCode;
        return trackingCode;
    }

    private void updateProgressBar() {
    int maxSeconds = 60;
    int updateInterval = 1000; // Update every 1 second
    int maxProgress = maxSeconds * 1000 / updateInterval;

    Timer timer = new Timer(updateInterval, e -> {
        int value = progressBar.getValue();
        int percentage = (int) (((double) value / maxProgress) * 100);

        if (value < maxProgress) {
            progressBar.setValue(value + 1);

            // Set background color dynamically based on progress percentage
            Color backgroundColor = calculateBackgroundColor(percentage);
            progressBar.setBackground(backgroundColor);

            progressBar.setString(percentage + "%");
        } else {
            ((Timer) e.getSource()).stop();
        }
    });
    timer.start();
}

private Color calculateBackgroundColor(int percentage) {
    // Example: Change color to black when progress is at or above 10%
    if (percentage >= 1) {
        return Color.BLACK;
    } else {
        return Color.WHITE;
    }
}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Order(email).setVisible(true);
        });
    }
}
