package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CrudOperation {
//	Connection con = null;
//	PreparedStatement  stmt = null;
	public static void main(String[] args) {
insert();
	}

	public static void create() {

		Connection con = null;
		Statement stmt = null;

		String url = "jdbc:oracle:thin:@bsit-ch-d005:1521:ORCl";
		String username = "C##FG_DEMO_IR";
		String password = "FG_DEMO_IR";
		String createQuery = " create  table Student(" + "id NUMBER PRIMARY KEY " + "name VARCHAR(50)" + "age NUMBER ";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public static void insert() {
		Connection con = null;
		PreparedStatement stmt = null;
		String url = "dbc:oracle:thin:@bsit-ch-d005:1521:orcl";
		String username = "C##FG_DEMO_IR";
		String password = "FG_DEMO_IR";
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, username, password);
			System.out.println("Enter User Name :");
			String name = sc.next();
			System.out.println("Enter Your Contact No : ");
			int maths= sc.nextInt();

			stmt = con.prepareStatement("insert into student (NAMe , MATHS) values (?, ?");
			stmt.setString(1, name);
			stmt.setInt(2, maths);
			int no = stmt.executeUpdate();
			if (no == 1) {
				System.out.println("Data Inserted Sucessfully");
			} else {
				System.out.println("Invalid Data Please Try Again");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	public static void Delete() {
		Connection con = null;
		PreparedStatement stmt = null;
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", " System ", "Oracle");
			System.out.println("Enter Name : ");
			String name = sc.next();
			stmt = con.prepareStatement(" Delete  from Student where name= ? ");
			stmt.setString(1, name);
			int no = stmt.executeUpdate();
			if (no == 1)

			{
				System.out.println("Data Is Deleted");
			} else {
				System.out.println("Enter Valid UserName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void Select() {
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", " System ", "Oracle");
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from student");
			while (rs.next()) {
				System.out.println(rs.getString(1));
				System.out.println(rs.getLong(2));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void update() {
		Connection con = null;
		PreparedStatement stmt = null;
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("oracle.jdbc.driver.OraceDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", " System ", "Oracle");
			System.out.println("Enter New Name : ");
			String name = sc.next();
			System.out.println("Enter The num of Old Name : ");
			long num = sc.nextLong();
			stmt = con.prepareStatement("update student set name =? where num =?");
			stmt.setString(1, name);
			stmt.setLong(2, num);
			int no = stmt.executeUpdate();
			if (no == 1) {
				System.out.println("Updated Suceesfuly");
			} else {
				System.out.println("Invalid Number");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void con() {
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		String url = "jdbc:oracle:thin:@bsit-ch-d005:1521:orcl";
		String username = "C##FG_DEMO_IR";
		String password = "FG_DEMO_IR";
		String createQuery = " create  table Student(" + "id NUMBER PRIMARY KEY " + "name VARCHAR(50)" + "age NUMBER ";
		try {

			con = DriverManager.getConnection(url, username, password);
			stmt.executeUpdate(createQuery);
			System.out.println("Table is Created Sucesfully");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
