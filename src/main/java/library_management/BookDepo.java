package library_management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookDepo {
	private static final String genre = null;
	Operation op = new Operation();
	public void getAllBook() throws Throwable {
		Connection connection1 = op.connection();
		PreparedStatement preparedstatement = connection1
				.prepareStatement("Select * from book");
		ResultSet resultSet=preparedstatement.executeQuery();
		while (resultSet.next()) {
			System.out.println(resultSet.getInt("id")+" ");
			System.out.println(resultSet.getString("name")+" ");
			System.out.println(resultSet.getString("author")+" ");
			System.out.println(resultSet.getDouble("price")+" ");
			System.out.println(resultSet.getString("genre")+" ");
			
		}
		}
	public void addBook(Book book) throws Throwable {
		Connection connection1 = op.connection();
		PreparedStatement preparedstatement = connection1
				.prepareStatement("INSERT INTO BOOK(id,name,author,price,genre) VALUES(?,?,?,?,?)");
		int id = book.getId();
		String name = book.getName();
		String author = book.getAuthor();
		double price = book.getPrice();
		String genre = book.getGenre();
		preparedstatement.setInt(1, id);
		preparedstatement.setString(2, name);
		preparedstatement.setString(3, author);
		preparedstatement.setDouble(4, price);
		preparedstatement.setString(5, genre);
		int a = preparedstatement.executeUpdate();
		if (a != 0) {
			System.out.println("Book Added");
		} else {
			System.out.println(" Book Not Added  ");
		}

		connection1.close();
	}
	public void deleteBook(int id) throws Throwable {
		Connection connection1 = op.connection();
		PreparedStatement preparedstatement = connection1
				.prepareStatement("DELETE FROM BOOK WHERE ID=?");
		preparedstatement.setInt(1,id);
		int a = preparedstatement.executeUpdate();
		if (a != 0) {
			System.out.println("Book is deleted ");
		} else {
			System.out.println("Enter correct id");
		}

		connection1.close();

	}
	public void updateBook(int id, String name, String author, double price,String genre) throws Throwable {
		Connection connection1 = op.connection();
		PreparedStatement preparedstatement = connection1
				.prepareStatement("UPDATE BOOK SET NAME=?,AUTHOR=?,PRICE=?,GENRE=? WHERE ID=?");
		preparedstatement.setInt(5,id);
		preparedstatement.setString(1, name);
		preparedstatement.setString(2, author);
		preparedstatement.setDouble(3, price);
		preparedstatement.setString(4, genre);
		int a = preparedstatement.executeUpdate();
		if (a != 0) {
			System.out.println("Book is Updated ");
		} else {
			System.out.println("Enter correct id");
		}

		connection1.close();
	}

	 public void getBookOnId(int id) throws Throwable {
		 Connection connection1 = op.connection();
			PreparedStatement preparedstatement = connection1
					.prepareStatement("select * FROM BOOK WHERE ID=?");
			preparedstatement.setInt(1,id);
			ResultSet resultSet=preparedstatement.executeQuery();
			while (resultSet.next()) {
				System.out.println(resultSet.getInt("id")+" ");
				System.out.println(resultSet.getString("name")+" ");
				System.out.println(resultSet.getString("author")+" ");
				System.out.println(resultSet.getDouble("price")+" ");
				System.out.println(resultSet.getString("genre")+" ");
				
			}
			connection1.close();
	 }
	 public void getBookOnName(String name) throws Throwable {
		 Connection connection1 = op.connection();
			PreparedStatement preparedstatement = connection1
					.prepareStatement("select * FROM BOOK WHERE name=?");
			preparedstatement.setString(1,name);
			ResultSet resultSet=preparedstatement.executeQuery();
			while (resultSet.next()) {
				System.out.println(resultSet.getInt("id")+" ");
				System.out.println(resultSet.getString("name")+" ");
				System.out.println(resultSet.getString("author")+" ");
				System.out.println(resultSet.getDouble("price")+" ");
				System.out.println(resultSet.getString("genre")+" ");
				
			}
			connection1.close();
	 }
	 public void getBookOnAuthor(String author) throws Throwable {
		 Connection connection1 = op.connection();
			PreparedStatement preparedstatement = connection1
					.prepareStatement("select * FROM BOOK WHERE author=?");
			preparedstatement.setString(1,author);
			ResultSet resultSet=preparedstatement.executeQuery();
			while (resultSet.next()) {
				System.out.println(resultSet.getInt("id")+" ");
				System.out.println(resultSet.getString("name")+" ");
				System.out.println(resultSet.getString("author")+" ");
				System.out.println(resultSet.getDouble("price")+" ");
				System.out.println(resultSet.getString("genre")+" ");
				
			}
			connection1.close();
	 }
	 public void getBookOnGenre(String genre) throws Throwable {
		 Connection connection1 = op.connection();
			PreparedStatement preparedstatement = connection1
					.prepareStatement("select * FROM BOOK WHERE genre=?");
			preparedstatement.setString(1,genre);
			ResultSet resultSet=preparedstatement.executeQuery();
			while (resultSet.next()) {
				System.out.println(resultSet.getInt("id")+" ");
				System.out.println(resultSet.getString("name")+" ");
				System.out.println(resultSet.getString("author")+" ");
				System.out.println(resultSet.getDouble("price")+" ");
				System.out.println(resultSet.getString("genre")+" ");
				
			}
			connection1.close();
	 }
	 
}
