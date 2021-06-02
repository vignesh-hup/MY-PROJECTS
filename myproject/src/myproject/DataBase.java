package myproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DataBase {
	private String URL = "jdbc:mysql://localhost:3306/student_management";
	private String USERNAME = "root";
	private String PASSWORD = "vignesh164@";
	Connection con;
	Statement st;
	String query;
	Scanner sc;

	DataBase() throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
	}

	public void insertValue(StudentData userData) throws SQLException {
		String query = "insert into student_data values(" + userData.getRollno() + ",'" + userData.getName() + "','"
				+ userData.getPlace() + "'," + userData.getAge() + ",'" + userData.getMobno() + "');";
		con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		st = con.createStatement();
		st.execute(query);
		System.out.println("\n" + query);
	}

	public void showAll(StudentData userData) throws SQLException, ClassNotFoundException {
		query = "select*from student_data;";
		con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		st = con.createStatement();
		execteQuery();
	}

	public void show(StudentData userData) throws SQLException, ClassNotFoundException {
		sc = new Scanner(System.in);
		System.out.println("\nENTER THE CONDITION COLUNM NAME");
		String c_name = sc.next();
		System.out.println("\nENTER THE " + c_name + " VALUE");
		String Condition = sc.next();
		query = "select*from student_data where " + c_name + "='" + Condition + "';";
		System.out.println("\n" + query);
		con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		st = con.createStatement();
		execteQuery();
		
	}

	public void execteQuery() throws SQLException, ClassNotFoundException {
		ResultSet rs = st.executeQuery(query);
		System.out.println("\n\t\tQUERY WAS SUCESSFULLY EXECUTED");
		while (rs.next()) {
			System.out.println(" Roll No = " + rs.getString(1) + "\n Name = " + rs.getString(2) + "\n Place = "
					+ rs.getString(3) + "\n Age = " + rs.getString(4) + "\n Mobile Number = " + rs.getString(5));
			System.out.println("============================");
		}

	}

	public void show_A_Detail(StudentData userData) throws SQLException, ClassNotFoundException {
		sc = new Scanner(System.in);
		System.out.println("'\nENTER THE RESULT COLUNM NAME ");
		String r_name = sc.next();
		System.out.println("\nENTER THE CONDTION COLUNM NAME");
		String c_name = sc.next();
		System.out.println("\nENTER THE " + c_name + " VALUE");
		String Condition = sc.next();
		query = "select " + r_name + " from student_data where " + c_name + "='" + Condition + "';";
		System.out.println("\n" + query);
		System.out.println("\n\t\tQUERY WAS SUCESSFULLY EXECUTED");
		con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			System.out.println(r_name + "=" + rs.getString(r_name));
		}
	}

	public void remove(StudentData userData) throws SQLException {
		sc = new Scanner(System.in);
		System.out.println("\nENTER THE CONDITION COLUNM NAME");
		String c_name = sc.next();
		System.out.println("\nENTER THE " + c_name + " VALUE");
		String Condition = sc.next();
		query = "Delete from student_data where " + c_name + "='" + Condition + "';";
		System.out.println("\n" + query);
		con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		st = con.createStatement();
		st.execute(query);
		System.out.println("\n\t\tGIVEN RECORD WILL BE SUCESSFULLY DELETED\n");
		
	}

	public void removeAll(StudentData userData) throws SQLException {
		query = "Delete from student_data";
		System.out.println("\n" + query);
		con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		st = con.createStatement();
		st.execute(query);
		System.out.println("\n\t\tALL RECORD WILL BE SUCESSFULLY DELETED");
	}
	public void alterTable(StudentData userData) throws SQLException {
		sc = new Scanner(System.in);
		System.out.println("\nENTER THE NEW COLUNM NAME");
		String c_name = sc.next();
		System.out.println("\nENTER THE NEW COLUNM " + c_name + " DATATYPE AND NULL OR NOT NULL");
		String Datatype = sc.next();
		query = "alter table student_data add " +c_name+" "+Datatype +";";
		System.out.println("\n" + query);
		con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		st = con.createStatement();
		st.execute(query);
		System.out.println("\n\t\tALTER TABLE SUCESSFULLY EXECUTED\n");
		
	}
	public void updateTable(StudentData userData) throws SQLException {
		sc = new Scanner(System.in);
		System.out.println("\nENTER THE NEW COLUNM NAME");
		String N_name = sc.next();
		System.out.println("\nENTER THE NEW COLUNM " +N_name +" VALUE");
		String N_value = sc.next();
		System.out.println("\nENTER THE CONDITION COLUNM NAME");
		String c_name = sc.next();
		System.out.println("\nENTER THE " + c_name + " VALUE");
		String Condition = sc.next();
		query = "update student_data set "+N_name+"='"+ N_value+"' where " +c_name +"='"+Condition+"';";
		System.out.println("\n" + query);
		con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		st = con.createStatement();
		st.execute(query);
		System.out.println("\n\t\t UPDATE TABLE SUCESSFULLY EXECUTED\n");
	}
	public void dropTable(StudentData userData) throws SQLException {
		sc =new Scanner(System.in);
		System.out.println("\n ENTER THE DROPED COLUMN NAME");
		String drop=sc.next();
		query="alter table student_data drop column "+drop+";";
		System.out.println("\n"+query);
		con=DriverManager.getConnection(URL, USERNAME, PASSWORD);
		st =con.createStatement();
		st.execute(query);
		System.out.println("\n\t\tGIVEN TABLE COLUMN SUCESSFULLY DROPED\n");
	}

}
