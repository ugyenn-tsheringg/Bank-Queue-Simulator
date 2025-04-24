import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BankQueueSimulatorGUI extends JFrame {
    private JTextField counterField;
    private JTextField customerField;
    private JTextField serviceTimeField;
    private JTextField arrivalRateField;
    private JButton simulateButton;
    private JLabel logoLabel;

    public BankQueueSimulatorGUI() {
        setTitle("Bank Queue Simulator");
        setSize(600, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        // Set a background color
        getContentPane().setBackground(new Color(245, 245, 245));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Add logo
        logoLabel = new JLabel();
        setLogo("C:/Users/ACER/Downloads/Telegram Desktop/DSA/logo.jpeg"); // Set initial logo
        logoLabel.setHorizontalAlignment(JLabel.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(logoLabel, gbc);

        // Add header
        JLabel headerLabel = new JLabel("Welcome to Maybank");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerLabel.setForeground(new Color(0, 102, 204));
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        add(headerLabel, gbc);

        // Add input fields
        addLabelAndTextField("Number of Service Counters:", counterField = new JTextField(), 2, gbc);
        addLabelAndTextField("Number of Customers:", customerField = new JTextField(), 3, gbc);
        addLabelAndTextField("Time Each Customer Takes:", serviceTimeField = new JTextField(), 4, gbc);
        addLabelAndTextField("Customers Arriving Per Unit Time:", arrivalRateField = new JTextField(), 5, gbc);

        // Add simulate button
        simulateButton = new JButton("Simulate");
        simulateButton.setFont(new Font("Arial", Font.BOLD, 16));
        simulateButton.setBackground(new Color(255, 204, 204));
        simulateButton.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(simulateButton, gbc);

        // Simulate button action
        simulateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runSimulation();
            }
        });

        // Add Enter key listener to all text fields
        KeyAdapter enterKeyAdapter = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    runSimulation();
                }
            }
        };

        counterField.addKeyListener(enterKeyAdapter);
        customerField.addKeyListener(enterKeyAdapter);
        serviceTimeField.addKeyListener(enterKeyAdapter);
        arrivalRateField.addKeyListener(enterKeyAdapter);
    }

    private void addLabelAndTextField(String labelText, JTextField textField, int yPos, GridBagConstraints gbc) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setOpaque(true);
        label.setBackground(new Color(204, 255, 255));
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        gbc.gridx = 0;
        gbc.gridy = yPos;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(label, gbc);

        textField.setFont(new Font("Arial", Font.PLAIN, 14));
        textField.setBackground(new Color(204, 255, 204));
        textField.setPreferredSize(new Dimension(200, 30)); // Set preferred size for the text fields
        gbc.gridx = 1;
        gbc.gridy = yPos;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(textField, gbc);
    }

    private void setLogo(String imagePath) {
        ImageIcon logoIcon = new ImageIcon(imagePath);
        Image logoImage = logoIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH); // Scaling the image to 150x150
        logoLabel.setIcon(new ImageIcon(logoImage));
    }

    private void runSimulation() {
        try {
            int numberOfCounters = Integer.parseInt(counterField.getText());
            int numberOfCustomers = Integer.parseInt(customerField.getText());
            int customerServiceTime = Integer.parseInt(serviceTimeField.getText());
            int customersPerUnitTime = Integer.parseInt(arrivalRateField.getText());

            BankSimulation simulation = new BankSimulation(numberOfCounters, numberOfCustomers, customerServiceTime, customersPerUnitTime);
            simulation.runSimulation();
            String results = simulation.getResults();

            // Show result in a popup message
            JOptionPane.showMessageDialog(this, results, "Simulation Results", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers in all fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BankQueueSimulatorGUI().setVisible(true);
            }
        });
    }
}
