package cn.itbaizhan.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.View;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.view.JspView;

import cn.itbaizhan.bean.Message;
import cn.itbaizhan.common.PagerUtil;
import cn.itbaizhan.service.MessageService;
@SuppressWarnings("unchecked")
@IocBean
@At("/message")
public class MessageAction {
	
	@Inject("refer:messageService")
	private MessageService messageService;
	
	/**
	 * 留言列表
	 * @param request
	 * @return
	 */
	@At("/list")
	public View tologin(HttpServletRequest request){
		String pagerNum = request.getParameter("pagerNum");
		if(pagerNum==null){
			pagerNum = "1";
		}
		List<Message> list = messageService.findListMessage();
		list = (List<Message>) PagerUtil.getPager(list, Integer.parseInt(pagerNum));
		request.setAttribute("list", list);
		request.setAttribute("count", list.size());
		request.setAttribute("maxPager", list.size()/10+1);
		request.setAttribute("pagerNum", pagerNum);
		return new JspView("jsp.admin.message");
	}
	/**
	 * add message
	 * @param request
	 * @return
	 */
	@At("/add")
	public View add(HttpServletRequest request){
		Message message = new Message();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String text = request.getParameter("message");
		message.setName(name);
		message.setEmail(email);
		message.setMessage(text);
		message = messageService.addMessage(message);
		if(message != null){
			request.setAttribute("msg", "留言成功");
		}else{
			request.setAttribute("msg", "留言失败");
		}
		return new JspView("jsp.message");
	}
	/**
	 * add message
	 * @param request
	 * @return
	 */
	@At("/delete")
	public View delete(HttpServletRequest request){
		String id = request.getParameter("id");
		int i = messageService.deleteMessage(Integer.parseInt(id));
		if(i==1){
			request.setAttribute("msg", "删除成功");
		}else{
			request.setAttribute("msg", "删除失败");
		}
		String pagerNum = request.getParameter("pagerNum");
		if(pagerNum==null){
			pagerNum = "1";
		}
		List<Message> list = messageService.findListMessage();
		list = (List<Message>) PagerUtil.getPager(list, Integer.parseInt(pagerNum));
		request.setAttribute("list", list);
		request.setAttribute("count", list.size());
		request.setAttribute("maxPager", list.size()/10+1);
		request.setAttribute("pagerNum", pagerNum);
		return new JspView("jsp.admin.message");
	}

}
