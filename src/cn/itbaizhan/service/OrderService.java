package cn.itbaizhan.service;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.IocBean;

import cn.itbaizhan.bean.Order;
import cn.itbaizhan.bean.User;

@IocBean(name="orderService",fields={"dao"})
public class OrderService extends BaseService{
	/**
	 * 
	 * @param userid
	 * @param proid
	 * @return
	 */
	public List<Order> findOrderByUseridAndProid(int userid,int proid){
		List<Order> list = dao.query(Order.class, Cnd.wrap("userid = "+userid+" AND proid = "+proid+" and sffk = 0 and visible = 1"), null);
		return list;
	}
	public List<Order> findOrderByProid(int proid){
		List<Order> list = dao.query(Order.class, Cnd.wrap("proid = "+proid+" and sffk = 0 and visible = 1 "), null);
		return list;
	}
	
	public List<Order> findOrderByProid1(int proid){
		List<Order> list = dao.query(Order.class, Cnd.wrap("proid = "+proid+" and sffk = 0 and visible = 0 "), null);
		return list;
	}
	/**
	 * 添加cart
	 * @param id
	 * @return
	 */
	public Order addOrder(Order order){
		return dao.insert(order);
	}
	/**
	 * 购物车列表
	 * @return
	 */
	public List<Order> getCartList(int id){
		return dao.query(Order.class, Cnd.wrap("userid="+id+" and sffk=0  and visible = 1 order by id desc"), null);
	}
	
	/**
	 * 已购物品
	 * @return
	 */
	public List<Order> getOrderList(int id){
		return dao.query(Order.class, Cnd.wrap("userid="+id+" and sffk=1 and visible = 1 order by date desc"), null);
	}
	/**
	 * 
	 * @return
	 */
	public List<Order> getAllOrderList(){
		return dao.query(Order.class, Cnd.wrap("sffk=1"), null);
	}
	/**
	 * 根据ID查询
	 */
	public Order findOrderById(int id){
		Order order = dao.fetch(Order.class, id);
		return order;
	}
	/**
	 * 修改
	 * @param id
	 * @return
	 */
	public int editOrder(Order order){
		return dao.update(order);
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public int deleteOrder(int id){
		return dao.delete(Order.class, id);
	}
}
