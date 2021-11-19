package cn.itbaizhan.action;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.View;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.view.JspView;

import cn.itbaizhan.bean.Order;
import cn.itbaizhan.bean.Product;
import cn.itbaizhan.bean.User;
import cn.itbaizhan.common.PagerUtil;
import cn.itbaizhan.service.OrderService;
import cn.itbaizhan.service.ProductService;
import cn.itbaizhan.service.UserService;

@IocBean
@At("/order")
public class OrderAction {
	
	@Inject("refer:orderService")
	private OrderService orderService;
	@Inject("refer:productService")
	private ProductService productService;
	@Inject("refer:userService")
	private UserService userService;
	
	/**
	 * add order
	 * @param request
	 * @return
	 */
	@At("/add")
	public View list(HttpServletRequest request){
		String id = request.getParameter("id");
		String price = request.getParameter("price");
		User user = (User)request.getSession().getAttribute("user");
		Order order = new Order();
		order.setProid(Integer.parseInt(id));
		List<Order> listOrd = orderService.findOrderByUseridAndProid(user.getId(), Integer.parseInt(id));
		if(listOrd.size()>0){
			Order existorder = listOrd.get(0);
			int count = Integer.parseInt(existorder.getCount())+1;
			int newprice = count* Integer.parseInt(existorder.getSingleprice());
			existorder.setCount(String.valueOf(count));
			existorder.setVisible(1);
			existorder.setPrice(String.valueOf(newprice));
			orderService.editOrder(existorder);
		}else{
			order.setSingleprice(price);
			order.setPrice(price);
			order.setCount("1");
			order.setVisible(1);
			order.setUserid(user.getId());
			order = orderService.addOrder(order);
			if(order!=null){
				request.setAttribute("msg", "添加成功");
			}else{
				request.setAttribute("msg", "添加失败");
			}
		}
		List<Order> list = orderService.getCartList(user.getId());
		request.setAttribute("list", list);
		int sumprice = 0;
		for(int i=0;i<list.size();i++){
			list.get(i).setUser(userService.findUserById(list.get(i).getUserid()));
			list.get(i).setProduct(productService.findProductById(list.get(i).getProid()));
			if(sumprice==0){
				sumprice = Integer.parseInt(list.get(i).getPrice());
			}else{
				sumprice += Integer.parseInt(list.get(i).getPrice());
			}
		}
		request.setAttribute("sumprice", sumprice);
		request.setAttribute("count", list.size());
		return new JspView("jsp.cart");
	}
	/**
	 * 
	 * @param request
	 * @return
	 */
	@At("/changeCount")
	public View changeCount(HttpServletRequest request){
		String id = request.getParameter("id");
		String count = request.getParameter("count");
		Order order = orderService.findOrderById(Integer.parseInt(id));
		order.setCount(count);
		int price = Integer.parseInt(count)*Integer.parseInt(order.getSingleprice());
		order.setPrice(String.valueOf(price));
		orderService.editOrder(order);
		//**
		User user = (User)request.getSession().getAttribute("user");
		List<Order> list = orderService.getCartList(user.getId());
		request.setAttribute("list", list);
		int sumprice = 0;
		for(int i=0;i<list.size();i++){
			list.get(i).setUser(userService.findUserById(list.get(i).getUserid()));
			list.get(i).setProduct(productService.findProductById(list.get(i).getProid()));
			if(sumprice==0){
				sumprice = Integer.parseInt(list.get(i).getPrice());
			}else{
				sumprice += Integer.parseInt(list.get(i).getPrice());
			}
		}
		request.setAttribute("sumprice", sumprice);
		request.setAttribute("count", list.size());
		return new JspView("jsp.cart");
	}
	/**
	 * 
	 * @param request
	 * @return
	 */
	@At("/deleteorder")
	public View deleteorder(HttpServletRequest request){
		String id = request.getParameter("id");
		orderService.deleteOrder(Integer.parseInt(id));
		//**
		User user = (User)request.getSession().getAttribute("user");
		List<Order> list = orderService.getCartList(user.getId());
		request.setAttribute("list", list);
		int sumprice = 0;
		for(int i=0;i<list.size();i++){
			list.get(i).setUser(userService.findUserById(list.get(i).getUserid()));
			list.get(i).setProduct(productService.findProductById(list.get(i).getProid()));
			if(sumprice==0){
				sumprice = Integer.parseInt(list.get(i).getPrice());
			}else{
				sumprice += Integer.parseInt(list.get(i).getPrice());
			}
		}
		request.setAttribute("sumprice", sumprice);
		request.setAttribute("count", list.size());
		return new JspView("jsp.cart");
	}
	/**
	 * 到结算页面
	 */
	@At("/tocheckout")
	public View tocheckout(HttpServletRequest request){
		String price = request.getParameter("price");
		request.setAttribute("price", price);
		return new JspView("jsp.checkout");
	}
	/**
	 * 到付款界面
	 */
	@At("/topay")
	public View topay(HttpServletRequest request){
		String price = request.getParameter("price");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		String senddept = request.getParameter("senddept");
		User user = (User)request.getSession().getAttribute("user");
		List<Order> list = orderService.getCartList(user.getId());
		Order order = new Order();
		for(int i=0;i<list.size();i++){
			order = list.get(i);
			order.setAddress(address);
			order.setDate(df.format(new Date()));
			order.setSenddept(senddept);
			order.setTel(tel);
			orderService.editOrder(order);
		}
		request.setAttribute("price", price);
		return new JspView("jsp.pay");
	}
	/**
	 * 支付
	 * @param request
	 * @return
	 */
	@At("/pay")
	public View pay(HttpServletRequest request){
		User user = (User)request.getSession().getAttribute("user");
		List<Order> list = orderService.getCartList(user.getId());
		Order order = new Order();
		Product product = new Product();
		for(int i=0;i<list.size();i++){
			order = list.get(i);
			order.setSffk(1);
			order.setVisible(1);
			orderService.editOrder(order);
			product = productService.findProductById(order.getProid());
			if(product.getSfms()==1){//如果是秒杀，秒杀数量-1
				product.setMscount(product.getMscount()-1);
				productService.editProduct(product);
			}
			
		}
		request.setAttribute("msg", "付款成功");
		//新品上市
		List<Product> newlist = productService.findNewProduct();
		request.setAttribute("newlist", newlist);
		//促销
		List<Product> cxlist = productService.findCxProduct();
		request.setAttribute("cxlist", cxlist);
		return new JspView("jsp.index");
	}
	/**
	 * 
	 * @param request
	 * @return
	 */
	@At("/toOrderList")
	public View toOrderList(HttpServletRequest request){
		User user = (User)request.getSession().getAttribute("user");
		List<Order> list = orderService.getOrderList(user.getId());
		for(int i=0;i<list.size();i++){
			list.get(i).setUser(userService.findUserById(list.get(i).getUserid()));
			list.get(i).setProduct(productService.findProductById(list.get(i).getProid()));
		}
		request.setAttribute("list", list);
		return new JspView("jsp.orderlist");
	}
	
	@At("/addprice")
	public View addprice(HttpServletRequest request){
		User user = (User)request.getSession().getAttribute("user");
		String addprice = request.getParameter("addprice");
		//***
		String id = request.getParameter("id");
		
		Product product = productService.findProductById(Integer.parseInt(id));
		int jpprice = Integer.parseInt(product.getJpprice())+Integer.parseInt(addprice);
		product.setJpprice(String.valueOf(jpprice));
		productService.editProduct(product);
		Order order = new Order();
		List<Order> listorder = orderService.findOrderByProid(product.getId());
		if(listorder.size()>0){
			orderService.deleteOrder(listorder.get(0).getId());
		}
		order.setUserid(user.getId());
		order.setProid(product.getId());
		order.setCount("1");
		order.setVisible(0);
		order.setPrice(String.valueOf(jpprice));
		orderService.addOrder(order);
		//促销
		List<Product> cxlist = productService.findCxProduct();
		request.setAttribute("cxlist", cxlist);
		request.setAttribute("product", product);
		
		Calendar c =Calendar.getInstance();
		try{
		    c.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(product.getJpdate()));
		}catch (ParseException e) {
		    e.printStackTrace();
		}
		long current_time=System.currentTimeMillis();
		long end_time=c.getTimeInMillis();
		long time=end_time-current_time;
		request.setAttribute("time", time/1000);
		return new JspView("jsp.jpdetail");
	}
	@At("/setVisible")
	public View setVisible(HttpServletRequest request){
		String id = request.getParameter("id");
		User user = (User)request.getSession().getAttribute("user");
		List<Order> list = orderService.findOrderByProid1(Integer.parseInt(id));
		if(list.size()>0){
			Order order = list.get(0);
			order.setVisible(1);
			orderService.editOrder(order);
		}
		
		//新品上市
		List<Product> newlist = productService.findNewProduct();
		request.setAttribute("newlist", newlist);
		//促销
		List<Product> cxlist = productService.findCxProduct();
		request.setAttribute("cxlist", cxlist);
		return new JspView("jsp.index");
	}
	//houtai****************************************************
	@At("/htlist")
	public View htlist(HttpServletRequest request){
		User user = (User)request.getSession().getAttribute("user");
		String pagerNum = request.getParameter("pagerNum");
		if(pagerNum==null){
			pagerNum = "1";
		}
	
		List<Order> list = orderService.getAllOrderList();
		request.setAttribute("count", list.size());
		request.setAttribute("maxPager", PagerUtil.getMaxPager(list.size()));
		list = (List<Order>) PagerUtil.getPager(list, Integer.parseInt(pagerNum));
		for(int i=0;i<list.size();i++){
			list.get(i).setUser(userService.findUserById(list.get(i).getUserid()));
			list.get(i).setProduct(productService.findProductById(list.get(i).getProid()));
		}
		request.setAttribute("list", list);
		request.setAttribute("pagerNum", pagerNum);
		return new JspView("jsp.admin.order");
	}
	
}
