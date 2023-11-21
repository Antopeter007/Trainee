package JDBC;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class CreateTable {
	public static void main(String[] args) {
//		select();
//		insert();
		delete();
//		update();
//		createTable();
	}

	public static void select() {
		Statement stmt = null;
		String createQuery = " select * from STUDENT";
		try {
			stmt = con().createStatement();
			ResultSet rs = stmt.executeQuery(createQuery);
			while (rs.next()) {
				System.out.println(rs.getString(2));
				System.out.println(rs.getInt(3));
			}
			System.out.println("Table created Sucessfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void insert() {
//		Connection con = null;
		PreparedStatement stmt = null;
//		String url = ("jdbc:oracle:thin:@bsit-ch-d005:1521:orcl");
//		String username = "C##FG_DEMO_IR";
//		String password = "FG_DEMO_IR";
		Scanner sc = new Scanner(System.in);
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			con = DriverManager.getConnection(url, username, password);
			System.out.println("enter the Id : ");
			int id = sc.nextInt();
			System.out.println("Enter Name : ");
			String name = sc.next();
			System.out.println("Enter Maths Mark : ");
			int maths = sc.nextInt();
			System.out.println("Enter physics Mark");
			int physics = sc.nextInt();
			System.out.println("Enter Physics Mark : ");
			int chemistry = sc.nextInt();
//			System.out.println("Enter The Total Marks : ");
			int total = maths + chemistry + physics;
			stmt = con().prepareStatement("insert into student values (?,?,?,?,?,?)");
			stmt.setInt(1, id);
			stmt.setString(2, name);
			stmt.setInt(3, maths);
			stmt.setInt(4, physics);
			stmt.setInt(5, chemistry);
			stmt.setInt(6, total);
			int no = stmt.executeUpdate();
			if (no == 1) {
				System.out.println("Sucesfully Data Inseted");
			} else {
				System.out.println("Ivalid Input Please try Again !!!");
			}
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void delete() {
		PreparedStatement stmt = null;
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter The id ");
			int id = sc.nextInt();
			stmt = con().prepareStatement("delete from student where id = ?");
			stmt.setInt(1, id);
			int no = stmt.executeUpdate();
			if (no == 1) {
				System.out.println("Data Is succesfully deleted");
			} else {
				System.out.println("Invalid UserName");
			}
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void update() {
		PreparedStatement stmt = null;
		Scanner sc = new Scanner(System.in);
		HashMap<Integer, Integer> hs = new HashMap<>();
//		System.out.println("How Many Coloum You Updated");
//		int n = sc.nextInt();
//		for (int i = 0; i < n; i++) {
		System.out.println("Enter the marks");
		int marks = sc.nextInt();
		System.out.println("Enter The id ");
		int id1 = sc.nextInt();
		hs.put(marks, id1);
//		}
		try {
			String update1 = null;
			for (Entry<Integer, Integer> entry : hs.entrySet()) {
				System.out.println(" Which Are Subject you Updated \n " + " 1 . maths \n" + " 2. physics \n"
						+ " 3. chemistry \n" + " 4. Exit");
				int sub = sc.nextInt();
				switch (sub) {
				case 1:
					update1 = "maths";
					break;
				case 2:
					update1 = "physics";
					break;
				case 3:
					update1 = "chemistry";
					break;
				case 4: {
					System.out.println("Thank You");
					return;
				}
				}
				stmt = con().prepareStatement("UPDATE  student SET " + update1 + "= ? where id =?");

				switch (sub) {
				case 1: {
					update1 = "maths";
					int maths = entry.getKey();
					stmt.setInt(1, maths);
					break;
				}
				case 2: {
					update1 = "physics";
					int physics = entry.getKey();
					stmt.setInt(1, physics);
					break;
				}
				case 3: {
					update1 = "chemistry";
					int chemistry = entry.getKey();
					stmt.setInt(1, chemistry);

				}
				}

//				int physics = entry.getKey();
				int id = entry.getValue();

				stmt.setInt(2, id);
			}

			int no = stmt.executeUpdate();
			if (no == 1) {
				System.out.println("Sucessfully Changed");
			} else {
				System.out.println("Please Enter Valid Input");
			}
//			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void createTable() {
		Statement stmt = null;
		String query = "CREATE TABLE Rock(" + "ProductName VARCHAR (20) NOT NULL, "
				+ "CustomerName VARCHAR (20) NOT NULL, " + "DispatchDate date, " + "DeliveryTime timestamp, "
				+ "Price INT, " + "Location varchar(20))";
		try {
			stmt = con().createStatement();
			int rs = stmt.executeUpdate(query);
			System.out.println(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static Connection con() {
		Connection con = null;
		String url = ("jdbc:oracle:thin:@bsit-ch-d005:1521:orcl");
		String username = "C##FG_DEMO_IR";
		String password = "FG_DEMO_IR";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
