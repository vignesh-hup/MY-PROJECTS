package myproject;

import java.sql.SQLException;
import java.util.Scanner;

public class BillingApp {
	BillingDatabase bds;
	BillingData bd;
	EnteryData ed;
	ProductData pd;
	Scanner sc;
	String A = "ADMIN", B = "BILLER", S = "STOCK KEEPER";

	public void firstOption() throws ClassNotFoundException, SQLException {
		System.out.println(
				"\n1.ADMIN LOGIN \n2.BILLER LOGIN\n3.STOCK KEEPER LOGIN\n4.EXIT\n\t\t...........SELECT YOUR OPTION..........");
		getUserOption();
	}

	private void getUserOption() throws ClassNotFoundException, SQLException {
		bd = new BillingData();
		sc = new Scanner(System.in);
		int option = sc.nextInt();
		switch (option) {
		case 1: {
			bds = new BillingDatabase();
			bds.login(bd, A);
			adminRole();
			firstOption();
			break;
		}
		case 2: {
			bds = new BillingDatabase();
			bds.login(bd, B);
			billerRole();
			firstOption();
			break;
		}
		case 3: {
			bds = new BillingDatabase();
			bds.login(bd, S);
			stock_Keeper_Role();
			firstOption();
			break;
		}
		case 4: {
			System.exit(0);
		}

		}
		sc.close();
	}

	private void stock_Keeper_Role() throws ClassNotFoundException, SQLException {
		System.out.println(
				"\n1.ADD PRODUCT INFOMARTION\n2.SHOW A PRODUCT INFO\n3.UPDATE PRODUCT INFO\n4.REMOVE PRODUCT INFO\n5.GOTO LOGIN \t\t............SELECT YOUR OPTION............");
		int option = sc.nextInt();
		switch (option) {
		case 1: {
			pd = new ProductData();
			System.out.println("\nENTER THE BELOW DETAILS");
			System.out.println("\nENTER THE PRODUCT ROLE :");
			pd.setP_code(sc.nextInt());
			System.out.println("\nENTER THE PRODUCT NAME :");
			pd.setP_name(sc.next());
			System.out.println("\nENTER THE PRODUCT MANIFACTURING DATE :");
			pd.setManifacturing_date(sc.next());
			System.out.println("\nENTER THE PRODUCT EXPIRY DATE  :");
			pd.setP_expiry_date(sc.next());
			System.out.println("\nENTER THE PRODUCT STOCK INFO :");
			pd.setStock_info(sc.nextInt());
			System.out.println("\nENTER THE PRODUCT	ORIGANAL PRICE :");
			pd.setOriganal_price(sc.next());
			bds = new BillingDatabase();
			bds.addproduct(pd);
			stock_Keeper_Role();
			break;
		}
		case 2: {
			bds = new BillingDatabase();
			bds.showProduct(pd);
			stock_Keeper_Role();
			break;
		}
		case 3: {
			bds = new BillingDatabase();
			bds.removeProduct(pd);
			stock_Keeper_Role();
			break;
		}
		}

	}

	private void billerRole() throws ClassNotFoundException, SQLException {
		System.out.println(
				"\n1.ENTERY THE BILL\n2.GENERATE THE BILL\n3.GOTO LOGIN \t\t...............SELECT YOUR OPTION.............");
		int option = sc.nextInt();
		switch (option) {
		case 1: {
			ed = new EnteryData();
			System.out.println("\nENTER THE BELOW DETAILS");
			System.out.println("\nENTER THE STORE NAME :");
			ed.setStore_name(sc.next());
			System.out.println("\nENTER THE BILL NO :");
			ed.setBill_no(sc.nextInt());
			System.out.println("\nENTER THE PRODUCT CODE :");
			ed.setP_code(sc.nextInt());
			System.out.println("\nENTER THE PRODUCT NAME :");
			ed.setP_name(sc.next());
			System.out.println("\nENTER THE PRODUCT QUANTITY :");
			ed.setP_quantity(sc.next());
			System.out.println("\nENTER THE PRODUCT DATE :");
			ed.setP_date(sc.next());
			System.out.println("\nENTER THE PRODUCT TIME :");
			ed.setP_time(sc.next());
			System.out.println("\nENTER THE BAYER NAME :");
			ed.setB_name(sc.next());
			System.out.println("\nENTER THE BAYER MOBILE NUMBER :");
			ed.setB_mobno(sc.next());
			System.out.println("\nENTER THE BAYER PLACE :");
			ed.setB_place(sc.next());
			System.out.println("\nENTER THE TOTAL PRICE :");
			ed.setTotal_price(sc.next());
			bds = new BillingDatabase();
			bds.createEnetryData(ed);
			billerRole();
			break;
		}
		case 2: {
			bds = new BillingDatabase();
			bds.generateBill(ed);
			billerRole();
			break;
		}
		case 3: {
			getUserOption();
		}
		}
	}

	private void adminRole() throws ClassNotFoundException, SQLException {
		System.out.println(
				"\n1.ADD ADMIN OR BILLER OR STOCK_KEEPER\n2.REMOVE ADMIN OR BILLER OR STOCK KEEPER\n3.GOTO LOGIN OPTION");
		int option = sc.nextInt();
		switch (option) {
		case 1: {
			bd = new BillingData();
			System.out.println("\nENTER THE USER NAME =");
			bd.setUsername(sc.next());
			System.out.println("\nENTER THE USER PASSWORD =");
			bd.setPassword(sc.next());
			System.out.println("\nENTER THE USER ROLE =");
			bd.setRole(sc.next());
			bds = new BillingDatabase();
			bds.createUser(bd);
			adminRole();
			break;
		}
		case 2: {
			bds = new BillingDatabase();
			bds.remove(bd);
			adminRole();
			break;
		}
		case 3: {
			firstOption();
		}
		}
		sc.close();

	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		BillingApp ba = new BillingApp();
		ba.firstOption();

	}

}