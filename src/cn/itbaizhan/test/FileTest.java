package cn.itbaizhan.test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class FileTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		File file=new File("C:/Users/gzq/Desktop/123.jpg");
		File desFile=new File("C:/Users/gzq/Desktop/trest1.png");
		desFile.createNewFile();
		FileOutputStream out=new FileOutputStream(desFile);
		FileInputStream in =new FileInputStream(file);
		byte[] stream=new byte[in.available()];
		in.read(stream);
		out.write(stream);
		out.close();
		in.close();
	}

}
