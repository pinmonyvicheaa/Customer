import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerDatabase {
    private static final String URL = "jdbc:mysql://localhost:3306/customer";
    private static final String USER = "root";
    private static final String PASSWORD = "W7301@jqir#";

    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish connection to the database
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String query = "SELECT customer_id, customer_last_name, customer_first_name, customer_phone FROM Customer";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("customer_id");
                String lastName = resultSet.getString("customer_last_name");
                String firstName = resultSet.getString("customer_first_name");
                String phone = resultSet.getString("customer_phone");

                customers.add(new Customer(id, lastName, firstName, phone));
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customers;
    }
}
