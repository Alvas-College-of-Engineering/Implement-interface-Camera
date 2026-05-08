package mobilmanagement;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MobileServlet")
public class MobileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String brand = request.getParameter("brand");
        String action = request.getParameter("action");

        System.out.println("Brand: " + brand);
        System.out.println("Action: " + action);

        Mobile m = new Mobile(brand);
        String result;

        if (action != null && action.equals("photo")) {
            result = m.clickPhoto();
        } 
        else if (action != null && action.equals("video")) {
            result = m.recordVideo();
        } 
        else {
            result = "No Action Selected";
        }

        System.out.println("Result: " + result);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mobile_db",
                    "root",
                    "YOUR_PASSWORD"   
            );

            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO mobile(brand, action) VALUES (?, ?)"
            );

            ps.setString(1, brand);
            ps.setString(2, result);

            ps.executeUpdate();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("result", result);

        RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
        rd.forward(request, response);
    }
}