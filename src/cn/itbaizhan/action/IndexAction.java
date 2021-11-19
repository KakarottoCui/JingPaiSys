package cn.itbaizhan.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import cn.itbaizhan.service.OrderService;
import cn.itbaizhan.service.ProductService;
import cn.itbaizhan.service.UserService;

@IocBean
@At("/index")
public class IndexAction {
	
	@Inject("refer:productService")
	private ProductService productService;
	@Inject("refer:orderService")
	private OrderService orderService;
	@Inject("refer:userService")
	private UserService userService;
	/**
	 * 跳转到首页
	 * @param request
	 * @return
	 */
	@At("/toIndex")
	public View toIndex(HttpServletRequest request){
		//新品上市
		List<Product> newlist = productService.findNewProduct();
		request.setAttribute("newlist", newlist);
		//促销
		List<Product> cxlist = productService.findCxProduct();
		request.setAttribute("cxlist", cxlist);
		return new JspView("jsp.index");
	}
	/**
	 * 跳转到促销
	 * @param request
	 * @return
	 */
	@At("/toPromotions")
	public View toPromotions(HttpServletRequest request){
		//促销
		List<Product> cxlist = productService.findCxProduct();
		request.setAttribute("cxlist", cxlist);
		//新品上市
		List<Product> newlist = productService.findNewProduct();
		request.setAttribute("newlist", newlist);
		return new JspView("jsp.promotions");
	}
	/**
	 * 跳转到秒杀
	 * @param request
	 * @return
	 */
	@At("/toSpike")
	public View toSpike(HttpServletRequest request){
		//促销
		List<Product> cxlist = productService.findCxProduct();
		request.setAttribute("cxlist", cxlist);
		//新品上市
		List<Product> newlist = productService.findNewProduct();
		request.setAttribute("newlist", newlist);
		//秒杀
		List<Product> mslist = productService.findMsList();
		request.setAttribute("mslist", mslist);
		return new JspView("jsp.spike");
	}
	/**
	 * 跳转到竞拍
	 * @param request
	 * @return
	 */
	@At("/toAuction")
	public View toAuction(HttpServletRequest request){
		//促销
		List<Product> cxlist = productService.findCxProduct();
		request.setAttribute("cxlist", cxlist);
		//新品上市
		List<Product> newlist = productService.findNewProduct();
		request.setAttribute("newlist", newlist);
		//竞拍
		List<Product> jplist = productService.findJpList();
		request.setAttribute("jplist", jplist);
		return new JspView("jsp.auction");
	}
	/**
	 * 跳转到留言
	 * @param request
	 * @return
	 */
	@At("/toMessage")
	public View toMessage(HttpServletRequest request){
		return new JspView("jsp.message");
	}
	/**
	 * 跳转到产品详细
	 * @param request
	 * @return
	 */
	@At("/toDetail")
	public View toDetail(HttpServletRequest request){
		String id = request.getParameter("id");
		Product product = productService.findProductById(Integer.parseInt(id));
		//新品上市
		List<Product> newlist = productService.findNewProduct();
		request.setAttribute("newlist", newlist);
		request.setAttribute("product", product);
		return new JspView("jsp.detail");
	}
	/**
	 * 跳转到促销产品详细
	 * @param request
	 * @return
	 */
	@At("/tocxDetail")
	public View tocxDetail(HttpServletRequest request){
		String id = request.getParameter("id");
		Product product = productService.findProductById(Integer.parseInt(id));
		//促销
		List<Product> cxlist = productService.findCxProduct();
		request.setAttribute("cxlist", cxlist);
		request.setAttribute("product", product);
		return new JspView("jsp.cxdetail");
	}
	/**
	 * 跳转到秒杀产品详细
	 * @param request
	 * @return
	 */
	@At("/tomsDetail")
	public View tomsDetail(HttpServletRequest request){
		String id = request.getParameter("id");
		Product product = productService.findProductById(Integer.parseInt(id));
		//促销
		List<Product> cxlist = productService.findCxProduct();
		request.setAttribute("cxlist", cxlist);
		request.setAttribute("product", product);
		
		Calendar c =Calendar.getInstance();
		try{
		    c.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(product.getMsdate()));
		}catch (ParseException e) {
		    e.printStackTrace();
		}
		long current_time=System.currentTimeMillis();
		long end_time=c.getTimeInMillis();
		long time=end_time-current_time;
		request.setAttribute("time", time/1000);
		return new JspView("jsp.msdetail");
	}
	/**
	 * 跳转到竞拍产品详细
	 * @param request
	 * @return
	 */
	@At("/tojpDetail")
	public View tojpDetail(HttpServletRequest request){
		String id = request.getParameter("id");
		Product product = productService.findProductById(Integer.parseInt(id));
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
	/**
	 * 跳转到购物车
	 * @param request
	 * @return
	 */
	@At("/toCart")
	public View toCart(HttpServletRequest request){
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
	 * 跳转到后台登录页
	 * @param request
	 * @return
	 */
	@At("/toAdmin")
	public View toAdmin(HttpServletRequest request){
		return new JspView("jsp.admin.login");
	}
}
