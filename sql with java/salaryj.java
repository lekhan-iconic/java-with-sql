package lekhan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class salaryj {
    public static void main(String[] args) {
        int i,id,salary,num;
        String designation,name;
        Scanner sc=new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/employee";
        String username = "root";
        String password = "root";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            System.out.println("Enter how many employee u want to insert ");
            num = sc.nextInt();

            for (i = 1; i <= num; i++) {
                System.out.println("Enter id,salary,name,designation");
                id = sc.nextInt();
                salary = sc.nextInt();
                sc.nextLine();
                name = sc.nextLine();
                designation = sc.nextLine();
                String sql2 = String.format("insert into employer values (%d,'%s','%s',%d);", id, name, designation, salary);
                statement.executeUpdate(sql2);
            }
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employer ORDER BY salary DESC LIMIT 5");

            while (resultSet.next()) {
                // Process the data here
                String name1 = resultSet.getString("name");
                String designation1 = resultSet.getString("designation");
                String id1 = resultSet.getString("id");
                String salary1 = resultSet.getString("salary");
                System.out.println(id1 + " " + name1 + " " + designation1 + " " + salary1);
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









