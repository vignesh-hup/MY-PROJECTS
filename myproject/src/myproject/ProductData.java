package myproject;

public class ProductData {
	private int p_code,Stock_info;
	private String p_name,manifacturing_date,p_expiry_date,Origanal_price;
	public int getP_code() {
		return p_code;
	}
	public void setP_code(int p_code) {
		this.p_code = p_code;
	}
	public int getStock_info() {
		return Stock_info;
	}
	public void setStock_info(int stock_info) {
		Stock_info = stock_info;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getManifacturing_date() {
		return manifacturing_date;
	}
	public void setManifacturing_date(String manifacturing_date) {
		this.manifacturing_date = manifacturing_date;
	}
	public String getP_expiry_date() {
		return p_expiry_date;
	}
	public void setP_expiry_date(String p_expiry_date) {
		this.p_expiry_date = p_expiry_date;
	}
	public String getOriganal_price() {
		return Origanal_price;
	}
	public void setOriganal_price(String origanal_price) {
		this.Origanal_price = origanal_price;
	}

}
