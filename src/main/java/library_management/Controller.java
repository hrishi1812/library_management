package library_management;

import java.util.Scanner;

public class Controller {
	public static void main(String[] args) throws Throwable {
		User user = new User();
		Book book=new Book();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to Admin");

		for (;;) {
			System.out.println("1.Sign Up \n2.Log In \n3.Exit");
			int option = scanner.nextInt();

			switch (option) {
			case 1: {
				System.out.println("Enter the id");
				int id = scanner.nextInt();
				System.out.println("Enter the name");
				String name = scanner.next();
				System.out.println("Enter the phone");
				long phone = scanner.nextLong();
				System.out.println("Enter the email");
				String email = scanner.next();
				System.out.println("Enter the password");
				String password = scanner.next();
				user.setId(id);
				user.setName(name);
				user.setPhone(phone);
				user.setEmail(email);
				user.setPassword(password);
				Operation op = new Operation();
				op.signUp(user);

				break;
			}
			case 2: {
				System.out.println("Enter the email");
				String email = scanner.next();
				System.out.println("Enter the password");
				String password = scanner.next();
				Operation op = new Operation();
				op.logIn(email, password);
				innerloop:
				for (;;) {
					System.out
							.println("1.Get All Books \n2. Add Book \n3.Delete Book \n4.Update Book \n5.Get Book on id "
									+ "\n6.Get Book on name \n7.Get Book on author \n8.Get Book on genre \n9.exit");
					int option1 = scanner.nextInt();
					switch (option1) {
					case 1: {
						BookDepo db=new BookDepo();
						db.getAllBook();

						break;
					}
					case 2: {
						
						System.out.println("Enter the id");
						int id = scanner.nextInt();
						System.out.println("Enter the name");
						String name = scanner.next();
						System.out.println("Enter the author");
						String  author = scanner.next();
						System.out.println("Enter the price");
						double price = scanner.nextDouble();
						System.out.println("Enter the genre");
						String genre = scanner.next();
						book.setId(id);
						book.setName(name);
						book.setAuthor(author);
						book.setPrice(price);
						book.setGenre(genre);
						BookDepo db=new BookDepo();
						db.addBook(book);

						break;
					}
					case 3: {
						System.out.println("Enter the id");
						int id = scanner.nextInt();
						
						BookDepo db=new BookDepo();
                          db.deleteBook(id);
						break;
					}
					case 4: {
						System.out.println("Enter the id");
						int id = scanner.nextInt();
						System.out.println("Enter the name");
						String name = scanner.next();
						System.out.println("Enter the author");
						String  author = scanner.next();
						System.out.println("Enter the price");
						double price = scanner.nextDouble();
						System.out.println("Enter the genre");
						String genre = scanner.next();
						BookDepo db=new BookDepo();
                          db.updateBook(id, name, author, price, genre);

						break;
					}
					case 5: {
						System.out.println("Enter the id");
						int id = scanner.nextInt();
						
						BookDepo db=new BookDepo();
                          db.getBookOnId(id);

						break;
					}
					case 6: {
						System.out.println("Enter the name");
						String name = scanner.next();
						
						BookDepo db=new BookDepo();
                          db.getBookOnName(name);


						break;
					}
					case 7: {
						System.out.println("Enter the author");
						String author = scanner.next();
						
						BookDepo db=new BookDepo();
                          db.getBookOnAuthor(author);


						break;
					}
					case 8: {
						System.out.println("Enter the genre");
						String genre = scanner.next();
						
						BookDepo db=new BookDepo();
                          db.getBookOnGenre(genre);


						break;
					}
					case 9: {
						


						break innerloop;
					}
					default:
						System.out.println("Plaease enter the correct option");
						break;
					}
				}
				break;	
				
			}
			case 3: {
				System.exit(0);
				break;
			}

			default:
				System.out.println("Plaease enter the correct option");
				break;
			}

		}
	}

}
