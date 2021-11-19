package cn.itbaizhan.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.nutz.dao.Dao;
import org.nutz.dao.Sqls;
import org.nutz.dao.pager.Pager;
import org.nutz.dao.sql.Sql;
import org.nutz.dao.sql.SqlCallback;

import cn.itbaizhan.common.Page;


/**
 * 基本服务
 * 
 * @author 
 *
 */
public class BaseService {

	protected Dao dao;

	public Dao getDao() {
		return dao;
	}

	public void setDao(Dao dao) {
		this.dao = dao;
	}

	/**
	 * 执行Sql语句并返�?
	 * 
	 * @param sqlStr "SELECT name FROM t_abc WHERE name LIKE @name"
	 * @param params
	 */
	public void exec(String sqlStr,
			Map<String, Object> params) {
		Sql sql = Sqls.create(sqlStr);
		if(params!=null){
			Iterator<String> it = params.keySet().iterator();
			while(it.hasNext()){
				String key = it.next();
				sql.params().set(key, params.get(key));
			}
		}
		dao.execute(sql);
	}

	/**
	 * 通过Sql直接查询得到HashMap<String,Object> 类型的列�?
	 * 
	 * @param strSql
	 * @param params
	 * @return
	 */
	public List<Map> query(String strSql,
			Map<String, Object> params) {
		Sql sql = Sqls.create(strSql);
		if(params!=null){
			Iterator<String> it = params.keySet().iterator();
			while(it.hasNext()){
				String key = it.next();
				sql.params().set(key, params.get(key));
			}
		}
		sql.setCallback(new SqlCallback() {
			public Object invoke(Connection conn, ResultSet rs, Sql sql)
					throws SQLException {
				List<Map<String, Object>> list = new LinkedList<Map<String, Object>>();
				Map<String,Object> map = null;
				ResultSetMetaData rsmd = rs.getMetaData();
				while (rs.next()){
					map = new HashMap<String, Object>();
					for(int i = 0;i<rsmd.getColumnCount();i++){
						map.put(rsmd.getColumnName(i+1).toUpperCase(), rs.getObject(i+1));
					}
					list.add(map);
				}
				return list;
			}
		});
		dao.execute(sql);
		return sql.getList(Map.class);
	}
	
	/**
	 * 得到总条�?
	 * 
	 * @param strSql �?��执行的sql语句
	 * @param params �?��传�?的参�?
	 * @return
	 */
	public int count(String strSql,
			Map<String, Object> params) {
		Sql sql = Sqls.create(strSql);
		if(params!=null){
			Iterator<String> it = params.keySet().iterator();
			while(it.hasNext()){
				String key = it.next();
				sql.params().set(key, params.get(key));
			}
		}
		sql.setCallback(new SqlCallback() {
			public Object invoke(Connection conn, ResultSet rs, Sql sql)
					throws SQLException {
				Integer result = 0;
				while (rs.next()){
					result = rs.getInt(1);
					break;
				}
				return result;
			}
		});
		dao.execute(sql);
		return sql.getInt();
	}
	
	/**
	 * 根据sql语句和分页条件查询分�?
	 * 
	 * @param strSql
	 * @param params
	 * @param pager
	 * @return
	 */
	public Page queryPager(String strSql,
			Map<String, Object> params,Pager pager){
		String sql = "select * from ( "+strSql+" ) limit @startItem,@endItem ";
		String countSql = "select count(*) itemcount from ("+strSql+") ";
		if(null == params){
			params = new HashMap<String, Object>();
		}
		params.put("startItem", (pager.getPageNumber()-1)*pager.getPageSize());
		params.put("endItem", pager.getPageSize());
		List<Map> list = query(sql, params);
		int count = count(countSql,params);
		Page page = new Page(pager);
		page.setRecordCount(count);
		page.setList(list);
		return page;
	}

}
