package cn.itbaizhan.service;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.pager.Pager;
import org.nutz.ioc.loader.annotation.IocBean;

import cn.itbaizhan.bean.User;

@IocBean(name="userService",fields={"dao"})
public class UserService extends BaseService{

	public List<User> findUserByNameAndPsd(String username,String password){
		List<User> list = dao.query(User.class, Cnd.wrap("username = '"+username+"' AND password = '"+password+"'"), null);
		return list;
	}
	/**
	*查询人员
	*/
	public List<User> findUsers(Pager pager,String sortnameParmName,String sortorderParmName){
		return dao.query(User.class,Cnd.wrap("ORDER BY "+sortnameParmName+" "+sortorderParmName),pager);
	}
	/**
	*查询全部人员
	*/
	public List<User> findListUsers(){
		return dao.query(User.class,null);
	}
	
	/**
	 * 查询人员总数
	 * @return
	 */
	public int findUsersCount(){
		return dao.count(User.class);
	}
	/**
	 * 添加人员
	 * @param id
	 * @return
	 */
	public User addUser(User user){
		return dao.insert(user);
	}
	/**
	 * 根据ID查询
	 */
	public User findUserById(int id){
		User user = dao.fetch(User.class, id);
		return user;
	}
	/**
	 * 修改人员
	 * @param id
	 * @return
	 */
	public int editUser(User user){
		return dao.update(user);
	}
	
	/**
	 * 删除人员
	 * @param id
	 * @return
	 */
	public int deleteUser(int id){
		return dao.delete(User.class, id);
	}
}
