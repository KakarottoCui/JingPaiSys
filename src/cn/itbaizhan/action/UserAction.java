package cn.itbaizhan.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.View;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.view.JspView;

import cn.itbaizhan.bean.Product;
import cn.itbaizhan.bean.User;
import cn.itbaizhan.service.ProductService;
import cn.itbaizhan.service.UserService;

@IocBean
@At("/user")
public class UserAction {
	
	@Inject("refer:userService")
	private UserService userService;
	@Inject("refer:productService")
	private ProductService productService;
	
	/**
	 * 到登录/注册页面
	 * @param request
	 * @return
	 */
	@At("/tologin")
	public View tologin(HttpServletRequest request){
		return new JspView("jsp.login");
	}
	/**
	 * 到注册页面
	 * @param request
	 * @return
	 */
	@At("/toregister")
	public View toregister(HttpServletRequest request){
		return new JspView("jsp.register");
	}
	/**
	 * 注册
	 * @param request
	 * @return
	 */
	@At("/register")
	public View register(HttpServletRequest request){
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user = userService.addUser(user);
		if(user!=null){
			request.setAttribute("msg", "success");
		}else{
			request.setAttribute("msg", "error");
		}
		return new JspView("jsp.register");
	}
	
	
	/**
	 * login
	 */
	@At("/login")
	public View login(HttpServletRequest request){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		List<User> list = userService.findUserByNameAndPsd(username, password);
		//新品上市
		List<Product> newlist = productService.findNewProduct();
		request.setAttribute("newlist", newlist);
		//促销
		List<Product> cxlist = productService.findCxProduct();
		request.setAttribute("cxlist", cxlist);
		if(list.size()!=1){
			request.setAttribute("msg", "error");
			
			return new JspView("jsp.login");
		}else{
			request.setAttribute("user", list.get(0));
			request.getSession().setAttribute("user", list.get(0));
			return new JspView("jsp.index");
		}
	}
	/**
	 * Adminlogin
	 */
	@At("/adminlogin")
	public View adminlogin(HttpServletRequest request){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//如果直接请求该方法，就跳转到后台登录页面
		if(username==null&&password==null){
			return new JspView("jsp.admin.login");
		}
		List<User> list = userService.findUserByNameAndPsd(username, password);
		if(list.size()!=1){
			request.setAttribute("msg", "用户名或密码错误");
			return new JspView("jsp.admin.login");
		}else{
			if(list.get(0).getAdmin()==1){
				request.setAttribute("user", list.get(0));
				request.getSession().setAttribute("user", list.get(0));
				return new JspView("jsp.admin.index");
			}else{
				request.setAttribute("msg", "无管理员权限");
				return new JspView("jsp.admin.login");
			}
		}
	}
	/**
	 * adminlogout
	 * @param request
	 * @return
	 */
	@At("/adminlogout")
	public View adminlogout(HttpServletRequest request){
		request.getSession().setAttribute("user", null);
		return new JspView("jsp.admin.login");
	}
	/**
	 * logout
	 * @param request
	 * @return
	 */
	@At("/logout")
	public View logout(HttpServletRequest request){
		request.getSession().setAttribute("user", null);
		//新品上市
		List<Product> newlist = productService.findNewProduct();
		request.setAttribute("newlist", newlist);
		//促销
		List<Product> cxlist = productService.findCxProduct();
		request.setAttribute("cxlist", cxlist);
		return new JspView("jsp.index");
	}
	/**
	 * 跳转到修改密码
	 * @param request
	 * @return
	 */
	@At("/tochangePsd")
	public View tochangePsd(HttpServletRequest request){
		return new JspView("jsp.changePsd");
	}
	/**
	 * 跳转到admin修改密码
	 * @param request
	 * @return
	 */
	@At("/toAdminChangePsd")
	public View toAdminChangePsd(HttpServletRequest request){
		return new JspView("jsp.admin.changePsd");
	}
	/**
	 * 修改密码
	 * @param request
	 * @return
	 */
	@At("/changePsd")
	public View changePsd(HttpServletRequest request){
		User user = (User)request.getSession().getAttribute("user");
		String oldpsd = request.getParameter("oldpsd");
		String newpsd = request.getParameter("newpsd");
		String cpsd = request.getParameter("cpsd");
		if(oldpsd.equals(user.getPassword())){
			if(newpsd.equals(cpsd)){
				user.setPassword(newpsd);
				int i = userService.editUser(user);
				if(i==1){
					request.setAttribute("msg", "密码修改成功");
					return new JspView("jsp.changePsd");
				}else{
					request.setAttribute("msg", "密码修改失败");
					return new JspView("jsp.changePsd");
				}
				
			}else{
				request.setAttribute("msg", "新密码两次输入不一致");
				return new JspView("jsp.changePsd");
			}
			
		}else{
			request.setAttribute("msg", "原密码错误");
			return new JspView("jsp.changePsd");
		}
		
	}
	/**
	 * admin修改密码
	 * @param request
	 * @return
	 */
	@At("/adminChangePsd")
	public View adminChangePsd(HttpServletRequest request){
		User user = (User)request.getSession().getAttribute("user");
		String newpsd = request.getParameter("newpsd");
		user.setPassword(newpsd);
		int i = userService.editUser(user);
		if(i==1){
			request.setAttribute("msg", "密码修改成功");
			return new JspView("jsp.admin.changePsd");
		}else{
			request.setAttribute("msg", "密码修改失败");
			return new JspView("jsp.admin.changePsd");
		}
	}
}
