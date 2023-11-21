package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CRUDmodification {
	static Statement stmt = null;
	static Connection con = null;

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

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("Press 1 to create table");
			System.out.println("Press 2 to update the exisiting records");
			System.out.println("Press 3 to delete the records");
			System.out.println("Press 4 to inset recorods into the table ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				createTable();
				break;
			case 2: {
				System.out.println("How many Record You Enter");
				int no = sc.nextInt();
				for (int i = 0; i < no; i++) {
					System.out.println("Enter The Updated Marks ");
				}
			}
			}
		}
	}

	public static void createTable() {
		String query = "CREATE TABLE Rock(" + "id number  NOT NULL, " + "Name VARCHAR (20) NOT NULL, "
				+ "Location varchar(20))";
		try {
			stmt = con().createStatement();
			ResultSet rs = stmt.executeQuery(query);
			System.out.println(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
