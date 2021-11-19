package cn.itbaizhan.service;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.pager.Pager;
import org.nutz.ioc.loader.annotation.IocBean;

import cn.itbaizhan.bean.Message;
import cn.itbaizhan.bean.User;

@IocBean(name="messageService",fields={"dao"})
public class MessageService extends BaseService{
	
	
	
	/**
	 * 添加msg
	 * @param id
	 * @return
	 */
	public Message addMessage(Message message){
		return dao.insert(message);
	}
	/**
	*查询全部message
	*/
	public List<Message> findListMessage(){
		return dao.query(Message.class,null);
	}
	/**
	 * 删除message
	 * @param id
	 * @return
	 */
	public int deleteMessage(int id){
		return dao.delete(Message.class, id);
	}
}
