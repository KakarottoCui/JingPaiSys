package cn.itbaizhan.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;


@IocBean
public class DownloadAction {
	
	@At("download")
	public String download(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		String filePath=request.getParameter("filePath");
		//"..";
		if(filePath.indexOf("..")!=-1){
			throw new ServletException("请进行正确操作");
		}
		String path=filePath;
		File f=new File(path);
		if(f==null || !f.exists()){
			//Log.error(path+ " file not exists . ");
			return null;
		}
		FileInputStream in=new FileInputStream(f);
		response.setHeader("Content-disposition","attachment;filename="+f.getName());
		response.setContentLength((int) f.length());
		ServletOutputStream out=response.getOutputStream();
		out.flush();
		byte[] b=new byte[1024];
		int i=0;
		while((i=in.read(b))>0){
			out.write(b, 0, i);
		}
		out.flush();
		in.close();
		out.close();
		
		return null;
	}
}
