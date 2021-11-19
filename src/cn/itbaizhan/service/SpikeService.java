package cn.itbaizhan.service;

import java.util.List;
import java.util.Map;

import org.nutz.dao.Cnd;
import org.nutz.dao.pager.Pager;
import org.nutz.ioc.loader.annotation.IocBean;

import cn.itbaizhan.bean.User;

@IocBean(name="spikeService",fields={"dao"})
public class SpikeService extends BaseService{

	/**
	*查询全部人
	*/
	public List<Map<String, String>> findListUsers(){
		return null;
	}
	
	
}
