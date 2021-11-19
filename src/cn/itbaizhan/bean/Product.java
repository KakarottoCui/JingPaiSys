package cn.itbaizhan.bean;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

@Table("product")
public class Product {
	@Id
	private int id;
	@Column("name")
	private String name;
	@Column("img")
	private String img;
	@Column("content")
	private String content;
	@Column("price")
	private String price;
	@Column("sfcx")
	private int sfcx;
	@Column("newprice")
	private String newprice;
	@Column("sfms")
	private int sfms;
	@Column("msprice")
	private String msprice;
	@Column("msdate")
	private String msdate;
	@Column("mscount")
	private int mscount;
	@Column("sfjp")
	private int sfjp;
	@Column("qpprice")
	private String qpprice;
	@Column("jpprice")
	private String jpprice;
	@Column("jpperson")
	private String jpperson;
	@Column("jpdate")
	private String jpdate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getSfcx() {
		return sfcx;
	}
	public void setSfcx(int sfcx) {
		this.sfcx = sfcx;
	}
	public String getNewprice() {
		return newprice;
	}
	public void setNewprice(String newprice) {
		this.newprice = newprice;
	}
	public int getSfms() {
		return sfms;
	}
	public void setSfms(int sfms) {
		this.sfms = sfms;
	}
	public String getMsprice() {
		return msprice;
	}
	public void setMsprice(String msprice) {
		this.msprice = msprice;
	}
	public String getMsdate() {
		return msdate;
	}
	public void setMsdate(String msdate) {
		this.msdate = msdate;
	}
	public int getMscount() {
		return mscount;
	}
	public void setMscount(int mscount) {
		this.mscount = mscount;
	}
	public int getSfjp() {
		return sfjp;
	}
	public void setSfjp(int sfjp) {
		this.sfjp = sfjp;
	}
	public String getQpprice() {
		return qpprice;
	}
	public void setQpprice(String qpprice) {
		this.qpprice = qpprice;
	}
	public String getJpprice() {
		return jpprice;
	}
	public void setJpprice(String jpprice) {
		this.jpprice = jpprice;
	}
	public String getJpperson() {
		return jpperson;
	}
	public void setJpperson(String jpperson) {
		this.jpperson = jpperson;
	}
	public String getJpdate() {
		return jpdate;
	}
	public void setJpdate(String jpdate) {
		this.jpdate = jpdate;
	}
	
	
	
	
}
