package lekhan;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class avgsalaryj {
    public static void main(String[] args) {
        int empid, empsal,num;
        String empname;
        Scanner input = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/one";
        String username = "root";
        String password = "root";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            System.out.println("Enter no. of rows u want to input");
            num = input.nextInt();
            for(int i=1;i<=num;i++){
                System.out.println("Enter  empid, empname, empsal");
                empid = input.nextInt();
                empsal = input.nextInt();
                input.nextLine();
                empname = input.nextLine();
                statement.executeUpdate(String.format("insert into emp values (%d,'%s',%d);", empid, empname, empsal));
            }

            ResultSet resultSet = statement.executeQuery("SELECT empname FROM emp where empsal>(select avg(empsal) from emp);");

            while (resultSet.next()) {
                // Process the data here
                String name1 = resultSet.getString("empname");


                System.out.println( name1);

            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
