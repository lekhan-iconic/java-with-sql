package lekhan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class namingj {
    public static void main(String[] args) {

        int i,id,salary,efficiency,num;
        String name;
        Scanner sc=new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/alphabet";
        String username = "root";
        String password = "root";


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            System.out.println("Enter how many employee u want to insert ");
            num = sc.nextInt();
            for (i=1; i<=num ;i++){
                System.out.println("Enter id,salary,efficiency,name");
                id=sc.nextInt();
                salary=sc.nextInt();
                efficiency=sc.nextInt();
                sc.nextLine();
                name= sc.nextLine();
                String sql3 = String.format("insert into jobholder values (%d,'%s',%d,%d);", id, name, salary, efficiency);
                statement.executeUpdate(sql3);
            }

            ResultSet resultSet = statement.executeQuery("SELECT * FROM jobholder WHERE name LIKE 'a%'");

            while (resultSet.next()) {
                // Process the data here
                String name1 = resultSet.getString("name");
                String efficiency1 = resultSet.getString("efficiency");
                String id1 = resultSet.getString("id");
                String salary1 = resultSet.getString("salary");
                System.out.println(id1 + " " + name1 + " " + salary1 + " " +efficiency1);
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
