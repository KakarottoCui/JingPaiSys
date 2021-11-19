package cn.itbaizhan.bean;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

@Table("order1")
public class Order {
	@Id
	private int id;
	@Column("proid")
	private int proid;
	@One(target = Product.class, field = "proid")
	private Product product;
	@Column("count")
	private String count;
	@Column("singleprice")
	private String singleprice;
	@Column("price")
	private String price;
	@Column("userid")
	private int userid;
	
	@One(target = User.class, field = "userid")
	private User user;
	
	@Column("sffk")
	private int sffk;
	@Column("tel")
	private String tel;
	@Column("address")
	private String address;
	@Column("date")
	private String date;
	@Column("senddept")
	private String senddept;
	@Column("visible")
	private int visible;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getSffk() {
		return sffk;
	}
	public void setSffk(int sffk) {
		this.sffk = sffk;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getSenddept() {
		return senddept;
	}
	public void setSenddept(String senddept) {
		this.senddept = senddept;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getProid() {
		return proid;
	}
	public void setProid(int proid) {
		this.proid = proid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getSingleprice() {
		return singleprice;
	}
	public void setSingleprice(String singleprice) {
		this.singleprice = singleprice;
	}
	public int getVisible() {
		return visible;
	}
	public void setVisible(int visible) {
		this.visible = visible;
	}
	
	
}
