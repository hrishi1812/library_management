package library_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;



public class Operation {
	public Connection connection() throws Throwable {
		String className = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/librarydb";
		String user = "root";
		String password = "976478@se.com";
		Class.forName(className);
		return DriverManager.getConnection(url, user, password);
	}
	public void signUp(User user) throws Throwable {
		Connection connection1 = connection();
		PreparedStatement preparedstatement = connection1
				.prepareStatement("INSERT INTO USER(id,name,phone,email,password) VALUES(?,?,?,?,?)");
		int id = user.getId();
		String name = user.getName();
		long phone = user.getPhone();
		String email = user.getEmail();
		String password = user.getPassword();
		preparedstatement.setInt(1, id);
		preparedstatement.setString(2, name);
		preparedstatement.setLong(3, phone);
		preparedstatement.setString(4, email);
		preparedstatement.setString(5, password);
		int a = preparedstatement.executeUpdate();
		if (a != 0) {
			System.out.println("Sign up ");
		} else {
			System.out.println(" not Sign up ");
		}

		connection1.close();
	}

	public void logIn(String email, String password) throws Throwable {
		Scanner scanner=new Scanner(System.in);
		String query = "select password from user where email=?";
		Connection connection1 = connection();
		PreparedStatement preparedstatement = connection1.prepareStatement(query);
		preparedstatement.setString(1, email);
		ResultSet resultSet = preparedstatement.executeQuery();
		if (resultSet.next()) {
			if (password.equals(resultSet.getString("password"))) {
				System.out.println("log in successfully");
			} else {
				System.out.println("Invalid password");
				
				System.out.println("1.Forgot password");
				int a=scanner.nextInt();
				if(a==1) {
					PreparedStatement preparedstatement1 = connection1.prepareStatement("update user set password=? where email=?");
					System.out.println("Enter the email");
					String email1=scanner.next();
					preparedstatement1.setString(2, email1);
					System.out.println("Enter the new password");
					String password1=scanner.next();
					preparedstatement1.setString(1, password1);
					int b=preparedstatement1.executeUpdate();
					if (b != 0) {
						System.out.println("Password Updated ");
					} else {
						System.out.println("User Not Register");
						
					}
				}
				
			}
		} else {
			System.out.println("User Not Register");
			
		}
		
		connection1.close();
	}

}
