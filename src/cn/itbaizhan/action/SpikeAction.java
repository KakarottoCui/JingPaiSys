package cn.itbaizhan.action;

import javax.servlet.http.HttpServletRequest;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.View;
import org.nutz.mvc.annotation.At;

import cn.itbaizhan.service.ProductService;

@IocBean
@At("/spike")
public class SpikeAction {
	
	@Inject("refer:productService")
	private ProductService productService;
	
	/**
	 * 列表
	 * @param request
	 * @return
	 */
	@At("/list")
	public View tologin(HttpServletRequest request){
		
		return null;
	}

}
