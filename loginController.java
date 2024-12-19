import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@Controller
public class LoginController {

    @RequestMapping(value = "/loginUser", method = RequestMethod.POST)
    public String loginUser(
            @RequestParam(value = "user", required = true) String username,
            @RequestParam(value = "password", required = true) String password,
            Model model) {
        // Connection connect = null;
        // Statement sqlStatement = null;

        // try {
        //     // Load database driver and establish a connection
        //     Class.forName("com.mysql.jdbc.Driver"); // Use correct JDBC driver for your database
        //     connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "your_username", "your_password");

        //     // SQL query to authenticate user
        //     String sqlQuery = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";
        //     sqlStatement = connect.createStatement();
        //     ResultSet result = sqlStatement.executeQuery(sqlQuery);

        //     // Check if the user exists with the given credentials
        //     if (result.next()) {
        //         model.addAttribute("message", "Login successful for user: " + username);
        //     } else {
        //         model.addAttribute("message", "Invalid username or password.");
        //     }
        // } catch (Exception e) {
        //     model.addAttribute("error", "An error occurred: " + e.getMessage());
        // } finally {
        //     try {
        //         if (sqlStatement != null) sqlStatement.close();
        //         if (connect != null) connect.close();
        //     } catch (Exception e) {
        //         model.addAttribute("error", "An error occurred during cleanup: " + e.getMessage());
        //     }
        // }

        // return "result";
    }
}
