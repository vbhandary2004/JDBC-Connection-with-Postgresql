import javax.xml.transform.Result;
import java.sql.*;

public class Main{

    private static final String URL="jdbc:postgresql://localhost:5432/hospital";
    private static final String user_name="postgres";
    private final static  String password="Nimap@123";
    public static String query ="Select * from doctors";

    public static void main(String[] args) {

        try{
            Class.forName("org.postgresql.Driver");
            System.out.println("Postgres Driver is loaded sucessfully");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        try{
            Connection con = DriverManager.getConnection(URL, user_name, password);
            System.out.println("Connection is eastalished with database \n ");
            Statement statement= con.createStatement();
            ResultSet resultSet= statement.executeQuery(query);
            while (resultSet.next()){
                int id = resultSet.getInt("doctor_id");
               String name  = resultSet.getString("doctor_name");
               String specification = resultSet.getString("specification");

                System.out.println("id: "+ id+" " +"doctor_name: "+name+ " "+"Specification: "+ specification);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}