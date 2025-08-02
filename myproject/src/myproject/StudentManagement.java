package myproject;

import java.sql.SQLException;
/*
import java.util.HashMap;*/
import java.util.Scanner;
//import java.util.Set;

public class StudentManagement {
	Scanner sc;
	private int option;
	DataBase db;
	StudentData sd;
	// HashMap<Integer, StudentData> studentRecord=new HashMap<Integer,
	// StudentData>();
	int foundKey;

	void showOption() throws ClassNotFoundException, SQLException {
		System.out.println(
				"\n1. ADD A STUDENT\n2. EDIT A STUDENT RECORD\n3. SHOW ALL STUDENT RECORD\n4. SHOW A STUDENT RECORD\n5. DELETE A STUDENT RECORD\n6. EXIT\n\t\t............CHOOSE YOUR OPTION ............\n");
		getUserOption();
	}

	void getUserOption() throws ClassNotFoundException, SQLException {
		sc = new Scanner(System.in);
		option = sc.nextInt();
		callOption();
	}

	void callOption() throws ClassNotFoundException, SQLException {
		switch (option) {
		case 1: {
			addStudent();
			break;
		}
		case 2: {
			editStudent();
			break;
		}
		case 3: {
			showAllStudent();
			break;
		}
		case 4: {
			showStudent();
			break;
		}
		case 5: {
			deleteStudent();
			break;
		}
		case 6: {
			exit();
			break;
		}
		}
	}

	void addStudent() throws SQLException {
		try {
			sd = new StudentData();
			System.out.println("ENETER THE BELOW DETAILS........\n\n");
			sc = new Scanner(System.in);
			System.out.println("ENTER STUDENT ROLL NUMBER");
			sd.setRollno(sc.nextInt());
			System.out.println("ENTER STUDENT NAME");
			sd.setName(sc.next());
			System.out.println("ENTER STUDENT PLACE");
			sd.setPlace(sc.next());
			System.out.println("ENTER STUDENT AGE");
			sd.setAge(sc.nextInt());
			System.out.println("ENTER STUDENT MOBILE NUMBER");
			sd.setMobno(sc.next());
			db = new DataBase();
			db.insertValue(sd);
			// studentRecord.put(sd.getRollno(), sd);
			System.out.println("\n\t\t\t\tRECORD CREATED SUCESSFULLY");
			showOption();
		} catch (Exception ex) {
			System.out.println("PROBLEMS OCCCURED DURING ADDING STUDENT RECORD\n");
			System.out.println(ex.getMessage());
		}

	}

	void editStudent() throws ClassNotFoundException, SQLException {
		System.out.println("\n1.ALTER THE TABLE\n2.UPDATE THE TABLE\n3.DROP THE TABLE\n4.GOTO MAIN OPTION\n\t\t............ENTER THE OPTION............");
		int option=sc.nextInt();
		switch(option) {
		case 1: {
			db = new DataBase();
			db.alterTable(sd);
			editStudent();
		}
		case 2: {
			db = new DataBase();
			db.updateTable(sd);
			editStudent();
		}
		case 3:{
			db=new DataBase();
			db.dropTable(sd);
			editStudent();
		}
		case 4: {
			showOption();
		}
		}
		/*
		 * System.out.println("ENTER STUDENT ROLL NUMBER TO SHOW...."); sc = new
		 * Scanner(System.in); int key = sc.nextInt(); Set<Integer> rno =
		 * studentRecord.keySet(); for (int a : rno) { if (a == key) { foundKey = a;
		 * updateRecord(); break; } } showOption();
		 */

	}

	void updateRecord() {
		/*
		 * sc=new Scanner(System.in); StudentData temp = studentRecord.get(foundKey);
		 * System.out.
		 * println("\n\nSELECT DATA TO UPDATE\n1.UPDATE NAME\n2.UPDATE AGE\n3.UPDATE PLACE\n4.UPDATE MOBILE NUMBER\n"
		 * ); int option=sc.nextInt(); switch(option) { case 1:{
		 * System.out.println("ENTER THE NEME TO UPDATE"); temp.setName(sc.next());
		 * break; } case 2:{ System.out.println("ENTER THE AGE TO UPDATE");
		 * temp.setAge(sc.nextInt()); break; } case 3:{
		 * System.out.println("ENTER THE PLACE TO UPDATE"); temp.setPlace(sc.next());
		 * break; } case 4:{ System.out.println("ENETE THE MOBILE NUMBER TO UPDATE");
		 * temp.setMobno(sc.next()); break; } } // studentRecord.replace(foundKey,
		 * temp); System.out.println("\nRECORD SUCESSFULLY UPDATAED.....!!");
		 */
	}

	void showAllStudent() throws ClassNotFoundException, SQLException {
		db = new DataBase();
		db.showAll(sd);
		showOption();
		/*
		 * //Set<Integer> rno=studentRecord.keySet(); for(int a:rno) { foundKey=a;
		 * printData(); } showOption();
		 */
	}

	void showStudent() throws ClassNotFoundException, SQLException {
		System.out.println(
				"\n1.ALL DETAILS(all colunm)\n2.SPECIFIC DETAILS(Specific Colunm)\n3.GOTO MAIN OPTION\n\t\t..........SELECT YOUR OPTION..........");
		int option = sc.nextInt();
		switch (option) {
		case 1: {
			db = new DataBase();
			db.show(sd);
			showStudent();
		}
		case 2: {
			db = new DataBase();
			db.show_A_Detail(sd);
			showStudent();
		}
		case 3: {
			showOption();
		}
		}
		/*
		 * System.out.println("ENTER STUDENT ROLL NUMBER TO SHOW...."); sc = new
		 * Scanner(System.in); int key = sc.nextInt(); //Set<Integer> rno =
		 * studentRecord.keySet(); for (int a : rno) { if (a == key) { foundKey = a; } }
		 * printData(); showOption();
		 */
	}

	void printData() {
		/*
		 * System.out.println("STUDENT DATA\n"); StudentData data =
		 * studentRecord.get(foundKey); System.out.println("ROLL NUMBER = " +
		 * data.getRollno()); System.out.println("NAME = " + data.getName());
		 * System.out.println("AGE = " + data.getAge()); System.out.println("PLACE = " +
		 * data.getPlace()); System.out.println("MOBILE NUMBER = " + data.getMobno());
		 */
	}

	void deleteStudent() throws ClassNotFoundException, SQLException {
		System.out.println("\n1.PARTICULAR RECORD DELETED\n2.DELETE ALL RECORD\n3.GOTO MAIN OPTION\n\t\t............ENTER THE OPTION............");
		int option=sc.nextInt();
		switch(option) {
		case 1: {
			db = new DataBase();
			db.remove(sd);
			showStudent();
		}
		case 2: {
			db = new DataBase();
			db.removeAll(sd);
			showStudent();
		}
		case 3: {
			showOption();
		}
		}
		/*
		 * sc=new Scanner(System.in);
		 * System.out.println("ENTER ROLL NUMBER TO DELETE THE STUDENT RECORD"); int
		 * key=sc.nextInt(); studentRecord.remove(key);
		 * System.out.println("GIVEN RECORD SUCESSFULLY DELETED........!!");
		 * showOption();
		 */
	}

	void exit() {
		System.exit(0);
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		StudentManagement sm = new StudentManagement();
		sm.showOption();
	}

}
