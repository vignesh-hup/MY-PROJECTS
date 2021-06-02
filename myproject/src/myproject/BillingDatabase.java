package myproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BillingDatabase {
	private String URL = "jdbc:mysql://localhost:3306/billing_App";
	private String USERNAME = "root";
	private String PASSWORD = "vignesh164@";
	Connection con;
	Statement st;
	String query;
	Scanner sc;

	BillingDatabase() throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
	}

	public void login(BillingData userData, String x) throws SQLException, ClassNotFoundException {
		System.out.println("\n\t\t\t........." + x + "\tLOGIN...........");
		sc = new Scanner(System.in);
		System.out.println("\nENTER THE " + x + " NAME =");
		String userName = sc.next();
		System.out.println("\nENTER THE " + x + " PASSWORD =");
		String password = sc.next();
		/*
		 * System.out.println("\nENTER THE " + x + " ROLE ="); String role = sc.next();
		 */
		con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		st = con.createStatement();
		ResultSet rs = st.executeQuery(
				"SELECT*from USER_DATA WHERE USER_NAME='" + userName + "' and USER_PASSWORD='" + password + "';");
		int count = 0;
		while (rs.next()) {
			count++;
		}
		if (count > 0) {
			System.out.println("\n\t\tUSER ACCOUNT SUCUESSFULLY LOGIN");
		} else {
			System.out.println("\n\t\tUSER NAME AND PASSWORD INCORRCTED");
			this.login(userData, x);
		}

	}

	public void createUser(BillingData userData) throws SQLException {
		String query = "insert into user_data values('" + userData.getUsername() + "','" + userData.getPassword() + "','"
				+ userData.getRole() + "');";
		con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		st = con.createStatement();
		st.execute(query);
		System.out.println("\n" + query + "\n\t\tUSER DATA SUCESSFULLY ADDED");
	}

	public void remove(BillingData userData) throws SQLException {
		System.out.println("\nENTER THE CONDITION COLUNM NAME");
		String c_name = sc.next();
		System.out.println("\nENTER THE " + c_name + " VALUE");
		String Condition = sc.next();
		query = "Delete from user_data where " + c_name + "='" + Condition + "';";
		System.out.println("\n" + query);
		con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		st = con.createStatement();
		st.execute(query);
		System.out.println("\n\t\tGIVEN RECORD WILL BE SUCESSFULLY DELETED\n");
	}

	public void createEnetryData(EnteryData userData) throws SQLException {
		String query = "insert into entery_data values ('" + userData.getStore_name() + "','" + userData.getBill_no()
				+ "','" + userData.getP_code() + "','" + userData.getP_name() + "','" + userData.getP_quantity() + "','"
				+ userData.getP_date() + "','" + userData.getP_time() + "','" + userData.getB_name() + "','"
				+ userData.getB_mobno() + "','" + userData.getB_place() + "','" + userData.getTotal_price() + "');";
		con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		st = con.createStatement();
		st.execute(query);
		System.out.println("\n" + query + "\n\n\t\tBILL SUCESSFULLY ENTERYED");

	}

	public void generateBill(EnteryData ed) throws SQLException {
		sc = new Scanner(System.in);
		System.out.println("\nENTER THE BILL NUMBER :");
		int b = sc.nextInt();
		System.out.println("\nENTER THE BAYER NAME :");
		String name = sc.next();
		query = "select*from entery_data WHERE BILL_NO='" + b + "' and BAYER_NAME ='" + name + "';";
		con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		st = con.createStatement();
		System.out.println("\n" + query);
		execteQuery();
	}

	public void execteQuery() throws SQLException {
		ResultSet rs = st.executeQuery(query);
		System.out.println("\n\n\t\tQUERY WAS SUCESSFULLY EXECUTED");
		while (rs.next()) {
			System.out.println("\nSTORE NAME =" + rs.getString(1) + "\nBILL NO =" + rs.getString(2) + "\nPRODUCT CODE ="
					+ rs.getString(3) + "\nPRAODUCT NAME =" + rs.getString(4) + "\nPRODUCT QUANTITY =" + rs.getString(5)
					+ "\nPRODECT DATE =" + rs.getString(6) + "\nPRODECT TIME =" + rs.getString(7) + "\nBAYER NAME="
					+ rs.getString(8) + "\nBAYER MOBILE NUMBER =" + rs.getString(9) + "\nBAYER PALCE ="
					+ rs.getString(10) + "\nTOTAL PRICE =" + rs.getString(11));
		}
	}

	public void addproduct(ProductData userdata) throws SQLException {
		String query = "insert into product_info values ('" + userdata.getP_code() + "','" + userdata.getP_name()
				+ "','" + userdata.getManifacturing_date() + "','" + userdata.getP_expiry_date() + "','"
				+ userdata.getStock_info() + "','" + userdata.getOriganal_price() + "');";
		con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		st = con.createStatement();
		st.execute(query);
		System.out.println("\n" + query + "\n\n\t\tPRODUCT DATA SUCESSFULLY ADDED");
	}

	public void showProduct(ProductData userdata) throws SQLException {
		sc = new Scanner(System.in);
		System.out.println("\nENTER THE PRODUCT CODE ");
		int c = sc.nextInt();
		String query = "select*from product_info where PRODUCT_CODE='" + c + "';";
		System.out.println(query);
		con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		System.out.println("\n" + query + "\n\n\t\tQUERY WAS SUCESSFULLY EXECUTED");
		while (rs.next()) {
			System.out.println("\nPRODUCT CODE =" + rs.getString(1) + "\nPRODUCT NAME =" + rs.getString(2)
					+ "\nMANIFACTURING DATE =" + rs.getString(3) + "\nPRODUCT EXPIRY DATE  =" + rs.getString(4)
					+ "\nSTOCK INFO =" + rs.getString(5) + "\nORIGINAL PRICE =" + rs.getString(6));
		}
	}

	public void removeProduct(ProductData userdata) throws SQLException {
		sc = new Scanner(System.in);
		System.out.println("\nENTER THE REMOVED PRODUCT CODE");
		int code = sc.nextInt();
		query = "delete from product_info WHERE PRODUCT_CODE ='" + code + "';";
		System.out.println("\n" + query);
		con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		st = con.createStatement();
		st.execute(query);
		System.out.println("\n"+query+"\n\n\t\tGIVEN PRODUCT WILL BE SUCESSFULLY DELETED\n");
	}
}
