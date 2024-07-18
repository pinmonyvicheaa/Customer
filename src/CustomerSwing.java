import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CustomerSwing extends JFrame {
    private List<Customer> customers;
    private int currentIndex = 0;

    private JLabel lblId = new JLabel("ID:");
    private JLabel lblLastName = new JLabel("Last Name:");
    private JLabel lblFirstName = new JLabel("First Name:");
    private JLabel lblPhone = new JLabel("Phone:");

    private JLabel lblIdValue = new JLabel();
    private JLabel lblLastNameValue = new JLabel();
    private JLabel lblFirstNameValue = new JLabel();
    private JLabel lblPhoneValue = new JLabel();

    private JButton btnPrevious = new JButton("Previous");
    private JButton btnNext = new JButton("Next");

    public CustomerSwing(List<Customer> customers) {
        this.customers = customers;
        setTitle("Customer");
        setLayout(new GridLayout(5, 2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(lblId);
        add(lblIdValue);
        add(lblLastName);
        add(lblLastNameValue);
        add(lblFirstName);
        add(lblFirstNameValue);
        add(lblPhone);
        add(lblPhoneValue);
        add(btnPrevious);
        add(btnNext);

        btnPrevious.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentIndex > 0) {
                    currentIndex--;
                    showCustomer();
                }
            }
        });

        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentIndex < customers.size() - 1) {
                    currentIndex++;
                    showCustomer();
                }
            }
        });

        showCustomer();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void showCustomer() {
        Customer customer = customers.get(currentIndex);
        lblIdValue.setText(String.valueOf(customer.getId()));
        lblLastNameValue.setText(customer.getLastName());
        lblFirstNameValue.setText(customer.getFirstName());
        lblPhoneValue.setText(customer.getPhone());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CustomerDatabase db = new CustomerDatabase();
                List<Customer> customers = db.getCustomers();
                new CustomerSwing(customers);
            }
        });
    }
}
