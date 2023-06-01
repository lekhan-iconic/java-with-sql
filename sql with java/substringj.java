package lekhan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class substringj {
    public static void main(String[] args) {

        int i,empid,empsal,num;
        String empname;
        Scanner sc=new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/lekhan";
        String username = "root";
        String password = "root";


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            System.out.println("Enter how many employee u want to insert ");
            num = sc.nextInt();
            for (i=1; i<=num ;i++){
                System.out.println("Enter id,salary,name");
                empid=sc.nextInt();
                empsal=sc.nextInt();
                sc.nextLine();
                empname= sc.nextLine();
                String sql3 = String.format("insert into employee values (%d,'%s',%d);", empid, empname, empsal);
                statement.executeUpdate(sql3);
            }

            ResultSet resultSet = statement.executeQuery("SELECT * FROM employee WHERE empname LIKE '%smith%'");

            while (resultSet.next()) {
                // Process the data here
                String empname1 = resultSet.getString("empname");
                String empid1 = resultSet.getString("empid");
                String empsal1 = resultSet.getString("empsal");
                System.out.println(empid1 + " " + empname1 + " " + empsal1);
            }

            resultSet.close();
            statement.close();
            connection.close();
        }


        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
