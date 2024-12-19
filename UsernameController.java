import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Controller
public class UsernameController {

    @RequestMapping(value = "/checkUsername", method = RequestMethod.POST)
    public String checkIfUsernameExists(
            @RequestParam(value = "user", required = true) String username,
            Model model) {
        Connection connect = null;
        PreparedStatement preparedStatement = null;

        try {
            // Load database driver and establish a connection
            Class.forName("com.mysql.jdbc.Driver"); // Use correct JDBC driver for your database
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "your_username", "your_password");

            // SELECT query using prepared statements
            String sqlQuery = "SELECT 1 FROM users WHERE username = ?";
            preparedStatement = connect.prepareStatement(sqlQuery);
            preparedStatement.setString(1, username);
            ResultSet result = preparedStatement.executeQuery();

            // Check if a result is returned (username exists)
            if (result.next()) {
                model.addAttribute("message", "Username exists: " + username);
            } else {
                model.addAttribute("message", "Username does not exist.");
            }
        } catch (Exception e) {
            model.addAttribute("error", "An error occurred: " + e.getMessage());
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connect != null) connect.close();
            } catch (Exception e) {
                model.addAttribute("error", "An error occurred during cleanup: " + e.getMessage());
            }
        }

        return "result";
    }
}
