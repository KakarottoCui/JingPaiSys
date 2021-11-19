package cn.itbaizhan.action;

import cn.itbaizhan.bean.Product;
import cn.itbaizhan.common.PagerUtil;
import cn.itbaizhan.service.ProductService;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.View;
import org.nutz.mvc.annotation.AdaptBy;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.upload.TempFile;
import org.nutz.mvc.upload.UploadAdaptor;
import org.nutz.mvc.view.JspView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@SuppressWarnings("unchecked")
@IocBean
@At("/product")
public class ProductAction {

	@Inject("refer:productService")
	private ProductService productService;

	/**
	 * 商品列表
	 *
	 * @param request
	 * @return
	 */
	@At("/list")
	public View list(HttpServletRequest request) {
		String pagerNum = request.getParameter("pagerNum");
		if (pagerNum == null) {
			pagerNum = "1";
		}
		// 总数量
		List<Product> list = productService.findListProduct1();
		request.setAttribute("count", list.size());
		request.setAttribute("maxPager", PagerUtil.getMaxPager(list.size()));
		list = (List<Product>) PagerUtil.getPager(list,
				Integer.parseInt(pagerNum));
		request.setAttribute("list", list);
		request.setAttribute("pagerNum", pagerNum);
		return new JspView("jsp.admin.product.list");
	}

	/**
	 * 跳转到添加商品页面
	 *
	 * @param request
	 * @return
	 */
	@At("/toadd")
	public View toadd(HttpServletRequest request) {
		return new JspView("jsp.admin.product.add");
	}

	/**
	 * add pro
	 *
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@At("/add")
	@AdaptBy(type = UploadAdaptor.class, args = { "${app.root}/WEB-INF/tmp" })
	public View add(HttpServletRequest request, @Param("file") TempFile file,
			@Param("name") String name, @Param("price") String price,
			@Param("content") String content) throws IOException {

		Product product = new Product();
		product.setName(name);
		product.setPrice(price);
		product.setContent(content);

		// 保存图片开始
		File f = file.getFile();
		String filename = f.getName();
		int address = filename.lastIndexOf(".");
		String type = filename.substring(address + 1, filename.length());
		String date = new SimpleDateFormat("yyyyMMddHHmmssSS").format(Calendar
				.getInstance().getTime());
		String yp = "D:\\file\\";
		String changePath = yp + date + "." + type;// 实际保存路径
		File desFile = new File(changePath);
		File pck = new File(yp);
		// 检查目录
		if (!pck.exists()) {
			pck.mkdirs();
		}
		desFile.createNewFile();
		FileOutputStream out = new FileOutputStream(desFile);
		FileInputStream in = new FileInputStream(f);
		byte[] stream = new byte[in.available()];
		in.read(stream);
		out.write(stream);
		out.close();
		in.close();
		// 保存到硬盘结束

		// //////////////////
		product.setImg(changePath);
		product = productService.addProduct(product);
		if (product != null) {
			request.setAttribute("msg", "添加成功");
		} else {
			request.setAttribute("msg", "添加失败");
		}

		// ****
		String pagerNum = request.getParameter("pagerNum");
		if (pagerNum == null) {
			pagerNum = "1";
		}
		List<Product> list = productService.findListProduct();
		request.setAttribute("count", list.size());
		request.setAttribute("maxPager", PagerUtil.getMaxPager(list.size()));
		list = (List<Product>) PagerUtil.getPager(list,
				Integer.parseInt(pagerNum));
		request.setAttribute("list", list);
		request.setAttribute("pagerNum", pagerNum);
		return new JspView("jsp.admin.product.list");
	}

	/**
	 * del pro
	 *
	 * @param request
	 * @return
	 */
	@At("/delete")
	public View delete(HttpServletRequest request) {
		String id = request.getParameter("id");
		int i = productService.deleteProduct(Integer.parseInt(id));
		if (i == 1) {
			request.setAttribute("msg", "删除成功");
		} else {
			request.setAttribute("msg", "删除失败");
		}
		// ****
		String pagerNum = request.getParameter("pagerNum");
		if (pagerNum == null) {
			pagerNum = "1";
		}
		List<Product> list = productService.findListProduct();
		request.setAttribute("count", list.size());
		request.setAttribute("maxPager", PagerUtil.getMaxPager(list.size()));
		list = (List<Product>) PagerUtil.getPager(list,
				Integer.parseInt(pagerNum));
		request.setAttribute("list", list);
		request.setAttribute("pagerNum", pagerNum);
		return new JspView("jsp.admin.product.list");
	}

	@At("/toupdate")
	public View toupdate(HttpServletRequest request) {
		String id = request.getParameter("id");
		Product product = productService.findProductById(Integer.parseInt(id));
		request.setAttribute("product", product);
		return new JspView("jsp.admin.product.update");
	}

	/**
	 * update pro
	 *
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@At("/update")
	@AdaptBy(type = UploadAdaptor.class, args = { "${app.root}/WEB-INF/tmp" })
	public View update(HttpServletRequest request,
			@Param("file") TempFile file, @Param("name") String name,
			@Param("price") String price, @Param("content") String content,
			@Param("id") String id) throws IOException {

		Product product = productService.findProductById(Integer.parseInt(id));
		product.setName(name);
		product.setPrice(price);
		product.setContent(content);
		String changePath = product.getImg();
		if (file != null) {
			// 保存图片开始
			String pathprefix = request.getServletContext().getRealPath("/")+"resources\\file\\";

			File f = file.getFile();
			String filename = f.getName();
			int address = filename.lastIndexOf(".");
			String type = filename.substring(address + 1, filename.length());
			String date = new SimpleDateFormat("yyyyMMddHHmmssSS")
					.format(Calendar.getInstance().getTime());
			String yp = pathprefix;
			changePath = yp + date + "." + type;// 实际保存路径
			File desFile = new File(changePath);
			File pck = new File(yp);
			// 检查目录
			if (!pck.exists()) {
				pck.mkdirs();
			}
			desFile.createNewFile();
			FileOutputStream out = new FileOutputStream(desFile);
			FileInputStream in = new FileInputStream(f);
			byte[] stream = new byte[in.available()];
			in.read(stream);
			out.write(stream);
			out.close();
			in.close();
			// 保存到硬盘结束
			// //////////////////
			String path="resources/file/"+date+"."+type;
				product.setImg(path);
		}



		int i = productService.editProduct(product);
		if (i == 1) {
			request.setAttribute("msg", "修改成功");
		} else {
			request.setAttribute("msg", "修改失败");
		}

		// ****
		String pagerNum = request.getParameter("pagerNum");
		if (pagerNum == null) {
			pagerNum = "1";
		}
		List<Product> list = productService.findListProduct();
		request.setAttribute("count", list.size());
		request.setAttribute("maxPager", PagerUtil.getMaxPager(list.size()));
		list = (List<Product>) PagerUtil.getPager(list,
				Integer.parseInt(pagerNum));
		request.setAttribute("list", list);
		request.setAttribute("pagerNum", pagerNum);
		return new JspView("jsp.admin.product.list");
	}

	@At("/toszcx")
	public View toszcx(HttpServletRequest request) {
		String id = request.getParameter("id");
		Product product = productService.findProductById(Integer.parseInt(id));
		request.setAttribute("product", product);
		return new JspView("jsp.admin.product.szcx");
	}

	@At("/szcx")
	public View szcx(HttpServletRequest request) {
		String id = request.getParameter("id");
		String newprice = request.getParameter("newprice");
		Product product = productService.findProductById(Integer.parseInt(id));
		product.setNewprice(newprice);
		product.setSfcx(1);
		int i = productService.editProduct(product);
		if (i == 1) {
			request.setAttribute("msg", "修改成功");
		} else {
			request.setAttribute("msg", "修改失败");
		}

		// ****
		String pagerNum = request.getParameter("pagerNum");
		if (pagerNum == null) {
			pagerNum = "1";
		}
		List<Product> list = productService.findListProduct();
		request.setAttribute("count", list.size());
		request.setAttribute("maxPager", PagerUtil.getMaxPager(list.size()));
		list = (List<Product>) PagerUtil.getPager(list,
				Integer.parseInt(pagerNum));
		request.setAttribute("list", list);
		request.setAttribute("pagerNum", pagerNum);
		return new JspView("jsp.admin.product.list");
	}

	@At("/qxcx")
	public View qxcx(HttpServletRequest request) {
		String id = request.getParameter("id");
		Product product = productService.findProductById(Integer.parseInt(id));
		product.setSfcx(0);
		product.setNewprice(null);
		int i = productService.editProduct(product);
		if (i == 1) {
			request.setAttribute("msg", "修改成功");
		} else {
			request.setAttribute("msg", "修改失败");
		}

		// ****
		String pagerNum = request.getParameter("pagerNum");
		if (pagerNum == null) {
			pagerNum = "1";
		}
		List<Product> list = productService.findListProduct();
		request.setAttribute("count", list.size());
		request.setAttribute("maxPager", PagerUtil.getMaxPager(list.size()));
		list = (List<Product>) PagerUtil.getPager(list,
				Integer.parseInt(pagerNum));
		request.setAttribute("list", list);
		request.setAttribute("pagerNum", pagerNum);
		return new JspView("jsp.admin.product.list");
	}

	// 秒杀开始**************************************************
	/**
	 * 秒杀列表
	 *
	 * @param request
	 * @return
	 */
	@At("/spikelist")
	public View spikelist(HttpServletRequest request) {
		String pagerNum = request.getParameter("pagerNum");
		if (pagerNum == null) {
			pagerNum = "1";
		}
		List<Product> list = productService.findListSpike();
		request.setAttribute("count", list.size());
		request.setAttribute("maxPager", PagerUtil.getMaxPager(list.size()));
		list = (List<Product>) PagerUtil.getPager(list,
				Integer.parseInt(pagerNum));
		request.setAttribute("list", list);
		request.setAttribute("pagerNum", pagerNum);
		return new JspView("jsp.admin.product.spikelist");
	}

	@At("/toszms")
	public View toszms(HttpServletRequest request) {
		String id = request.getParameter("id");
		Product product = productService.findProductById(Integer.parseInt(id));
		request.setAttribute("product", product);
		return new JspView("jsp.admin.product.szms");
	}

	@At("/szms")
	public View szms(HttpServletRequest request) {
		String id = request.getParameter("id");
		Product product = productService.findProductById(Integer.parseInt(id));
		String price = request.getParameter("price");
		String count = request.getParameter("count");
		String time = request.getParameter("time");
		if (count == null) {
			count = "0";
		}
		product.setSfms(1);
		product.setMscount(Integer.parseInt(count));
		product.setMsprice(price);
		product.setMsdate(time);

		int i = productService.editProduct(product);

		if (i == 1) {
			request.setAttribute("msg", "修改成功");
		} else {
			request.setAttribute("msg", "修改失败");
		}

		String pagerNum = request.getParameter("pagerNum");
		if (pagerNum == null) {
			pagerNum = "1";
		}
		List<Product> list = productService.findListSpike();
		request.setAttribute("count", list.size());
		request.setAttribute("maxPager", PagerUtil.getMaxPager(list.size()));
		list = (List<Product>) PagerUtil.getPager(list,
				Integer.parseInt(pagerNum));
		request.setAttribute("list", list);
		request.setAttribute("pagerNum", pagerNum);
		return new JspView("jsp.admin.product.spikelist");
	}

	@At("/qxms")
	public View qxms(HttpServletRequest request) {
		String id = request.getParameter("id");
		Product product = productService.findProductById(Integer.parseInt(id));
		product.setSfms(0);
		product.setNewprice(null);
		product.setMscount(0);
		product.setMsprice(null);
		product.setMsdate(null);
		int i = productService.editProduct(product);
		if (i == 1) {
			request.setAttribute("msg", "修改成功");
		} else {
			request.setAttribute("msg", "修改失败");
		}
		// ****
		String pagerNum = request.getParameter("pagerNum");
		if (pagerNum == null) {
			pagerNum = "1";
		}
		List<Product> list = productService.findListSpike();
		request.setAttribute("count", list.size());
		request.setAttribute("maxPager", PagerUtil.getMaxPager(list.size()));
		list = (List<Product>) PagerUtil.getPager(list,
				Integer.parseInt(pagerNum));
		request.setAttribute("list", list);
		request.setAttribute("pagerNum", pagerNum);
		return new JspView("jsp.admin.product.spikelist");
	}

	// 秒杀结束**************************************************

	// 竞拍开始**************************************************
	/**
	 * 竞拍列表
	 *
	 * @param request
	 * @return
	 */
	@At("/promolist")
	public View promolist(HttpServletRequest request) {
		String pagerNum = request.getParameter("pagerNum");
		if (pagerNum == null) {
			pagerNum = "1";
		}
		List<Product> list = productService.findListPromo();
		request.setAttribute("count", list.size());
		request.setAttribute("maxPager", PagerUtil.getMaxPager(list.size()));
		list = (List<Product>) PagerUtil.getPager(list,
				Integer.parseInt(pagerNum));
		request.setAttribute("list", list);
		request.setAttribute("pagerNum", pagerNum);
		return new JspView("jsp.admin.product.promolist");
	}

	@At("/toszjp")
	public View toszjp(HttpServletRequest request) {
		String id = request.getParameter("id");
		Product product = productService.findProductById(Integer.parseInt(id));
		request.setAttribute("product", product);
		return new JspView("jsp.admin.product.szjp");
	}

	@At("/szjp")
	public View szjp(HttpServletRequest request) {
		String id = request.getParameter("id");
		Product product = productService.findProductById(Integer.parseInt(id));
		String price = request.getParameter("price");
		String time = request.getParameter("time");
		product.setSfjp(1);
		product.setJpprice(price);
		product.setJpdate(time);

		int i = productService.editProduct(product);

		if (i == 1) {
			request.setAttribute("msg", "修改成功");
		} else {
			request.setAttribute("msg", "修改失败");
		}

		String pagerNum = request.getParameter("pagerNum");
		if (pagerNum == null) {
			pagerNum = "1";
		}
		List<Product> list = productService.findListSpike();
		request.setAttribute("count", list.size());
		request.setAttribute("maxPager", PagerUtil.getMaxPager(list.size()));
		list = (List<Product>) PagerUtil.getPager(list,
				Integer.parseInt(pagerNum));
		request.setAttribute("list", list);
		request.setAttribute("pagerNum", pagerNum);
		return new JspView("jsp.admin.product.promolist");
	}

	@At("/qxjp")
	public View qxjp(HttpServletRequest request) {
		String id = request.getParameter("id");
		Product product = productService.findProductById(Integer.parseInt(id));
		product.setSfjp(0);
		product.setQpprice(null);
		product.setJpdate(null);
		product.setJpprice(null);
		int i = productService.editProduct(product);
		if (i == 1) {
			request.setAttribute("msg", "修改成功");
		} else {
			request.setAttribute("msg", "修改失败");
		}
		// ****
		String pagerNum = request.getParameter("pagerNum");
		if (pagerNum == null) {
			pagerNum = "1";
		}
		List<Product> list = productService.findListPromo();
		request.setAttribute("count", list.size());
		request.setAttribute("maxPager", PagerUtil.getMaxPager(list.size()));
		list = (List<Product>) PagerUtil.getPager(list,
				Integer.parseInt(pagerNum));
		request.setAttribute("list", list);
		request.setAttribute("pagerNum", pagerNum);
		return new JspView("jsp.admin.product.promolist");
	}
	// 竞拍结束**************************************************
}
