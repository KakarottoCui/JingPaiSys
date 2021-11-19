package cn.itbaizhan.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.impl.SimpleDataSource;

import cn.itbaizhan.bean.User;

public class HelloWorld {


	public static void main(String[] args) throws ClassNotFoundException {
//		SimpleDataSource ds = new SimpleDataSource();
//		ds.setDriverClassName("com.mysql.jdbc.Driver"); //默认加载了大部分数据库的驱动!!
//		ds.setJdbcUrl("jdbc:mysql://localhost:3306/desktop?useUnicode=true&characterEncoding=UTF-8");
//		ds.setUsername("root");
//		ds.setPassword("root");
//		Dao dao = new NutDao(ds);
//		User user = new User();
//		user.setUsername("admin");
//		user.setPassword("admin");
//		user.setSex(1);
//		user.setEmail("gzq123@qw.com");
//		dao.insert(user);
		//System.out.println(Calendar.getInstance().getTimeInMillis());
		Calendar c =Calendar.getInstance();
		  
		try{
		    c.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2014-04-28 18:58:00"));
		}catch (ParseException e) {
		    e.printStackTrace();
		}
		System.out.println(c.getTimeInMillis());
		System.out.println(">"+Calendar.getInstance().getTimeInMillis());
		System.out.println(">"+System.currentTimeMillis());
		System.out.println(">"+(System.currentTimeMillis()-c.getTimeInMillis()));
		//System.out.println("今天距离1970年的毫秒数："+System.currentTimeMillis());
		//System.out.println("距离1970年的毫秒数："+c.getTimeInMillis());
		         
		long day=(System.currentTimeMillis()-c.getTimeInMillis())/1000/60/60/24;
		System.out.println("4月5号距离今天的天数："+day);

	}

}
 
