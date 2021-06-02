package myproject;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class StudentLogin {
	Scanner sc;
	private int Option;
	LoginData ld;
	HashMap<String,LoginData> LoginRecord=new HashMap<String,LoginData>();

	void showOption() {
		System.out.println("\nCHOOSE YOUR OPTION\n1.SIGN IN\n2.LOGIN");
		getOption();
	}

	void getOption() {
		sc = new Scanner(System.in);
		Option = sc.nextInt();
		callOption();
	}

	void callOption() {
		switch (Option) {
		case 1: {
			gotoSignin();
			break;
		}
		case 2: {
			gotoLogin();
			break;
		}
		}
	}

	void gotoSignin() {
		try {
			ld =new LoginData();
			System.out.println("ENETER THE BELOW DETAILS........\n\n");
			sc = new Scanner(System.in);
			System.out.println("ENTER THE USER NAME ");
			ld.setUsername(sc.next());
			System.out.println("ENTER THE PASSWORD");
			ld.setPassword(sc.next());
			System.out.println("ENTER THE DEPARTMENT");
			ld.setDepart(sc.next());
			System.out.println("ENTER THE PLACE");
			ld.setPlace(sc.next());
			System.out.println("ENTER THE AGE");
			ld.setAge(sc.nextInt());
			System.out.println("ENTER THE MOBILE NUMBER");
			ld.setMobno(sc.next());
			LoginRecord.put(ld.getUsername(), ld);
			LoginRecord.put(ld.getPassword(),ld);
			System.out.println("SIGNIN SUCESSFULLY");
			showOption();
		} catch (Exception ex) {
			System.out.println("PROBLEM OCCURED IN DURING SIGNIN\n");
			System.out.println(ex.getMessage());
		}

	}

	void gotoLogin() {
		System.out.println("\n\nENTER THE USER NAME");
		sc = new Scanner(System.in);
		String n=sc.next();
		System.out.println("ENTER THE PASSWORD");
		String p = sc.next();
		Set<String> name = LoginRecord.keySet();
		System.out.println(name);
			if(n.equals(name)&&(p.equals(name))) {
					System.out.println("login sucess");
				}
				
						
		
		showOption();

	}

	public static void main(String[] args) {
		StudentLogin sl = new StudentLogin();
		sl.showOption();
	}

}
