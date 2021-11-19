package cn.itbaizhan.service;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.IocBean;

import cn.itbaizhan.bean.Product;
import cn.itbaizhan.bean.User;

@IocBean(name="productService",fields={"dao"})
public class ProductService extends BaseService{
	//*************************前台使用模块开始
	/**
	 * 查询新品上市
	 * @return
	 */
	public List<Product> findNewProduct(){
		return dao.query(Product.class,Cnd.wrap("sfms=0 AND sfjp=0 order by id desc"),null);
	}
	/**
	 * 查询促销
	 * @return
	 */
	public List<Product> findCxProduct(){
		return dao.query(Product.class,Cnd.wrap("sfcx=1 and sfms=0 AND sfjp=0 order by id desc"),null);
	}
	//*************************后台木模块开始
	/**
	 * 添加Product
	 * @param id
	 * @return
	 */
	public Product addProduct(Product product){
		return dao.insert(product);
	}
	
	/**
	*查询全部Product
	*/
	public List<Product> findListProduct1(){
		return dao.query(Product.class,Cnd.wrap(" order by sfcx desc,id"),null);
	}
	/**
	*查询全部Product
	*/
	public List<Product> findListProduct(){
		return dao.query(Product.class,Cnd.wrap("sfms=0 AND sfjp=0 order by sfcx desc"),null);
	}
	/**
	*查询全部Product并让秒杀
	*/
	public List<Product> findListSpike(){
		return dao.query(Product.class,Cnd.wrap("sfjp=0 ORDER BY sfms desc"),null);
	}
	/**
	*查询全部秒杀
	*/
	public List<Product> findMsList(){
		return dao.query(Product.class,Cnd.wrap("sfms=1 ORDER BY sfms desc"),null);
	}
	/**
	*查询全部竞拍
	*/
	public List<Product> findJpList(){
		return dao.query(Product.class,Cnd.wrap("sfjp=1 ORDER BY sfms desc"),null);
	}
	/**
	*查询全部Product并让
	*/
	public List<Product> findListPromo(){
		return dao.query(Product.class,Cnd.wrap("sfms=0 ORDER BY sfjp desc"),null);
	}
	/**
	 * 删除Product
	 * @param id
	 * @return
	 */
	public int deleteProduct(int id){
		return dao.delete(Product.class, id);
	}
	/**
	 * 根据ID查询
	 */
	public Product findProductById(int id){
		Product product = dao.fetch(Product.class, id);
		return product;
	}
	/**
	 * 修改人员
	 * @param id
	 * @return
	 */
	public int editProduct(Product product){
		return dao.update(product);
	}
}
