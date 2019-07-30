package st.demo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class FileCopy {
	public static void main(String[] args) throws IOException {
		System.out.println("begin to copy---------");
		String[] arr = null;
		if(args.length != 0){
			arr = args[0].split("\\.");
		}else{
			arr = getDataString();
		}
		String year = arr[0];
		String month = arr[1];
		if(month.startsWith("0"))
			month = month.substring(1);
		String day = arr[2];
		if(day.startsWith("0"))
			day = day.substring(1);
		String dest = "C:\\Users\\fengyuan\\Desktop\\mail\\file\\中国信通院--每日ICT要闻（"+year+"年"+month+"月"+ day +"日）.docx";
		String src = "D:\\工作\\日常维护工作\\中国信通院--每日ICT要闻（"+year+"年"+month+"月"+ day +"日）\\中国信通院--每日ICT要闻（"+year+"年"+month+"月"+ day +"日）.docx";
		copyAnyTypeFie(src, dest);
		System.out.println("copy" +src+"success!!!");
		String srcPic = "D:\\工作\\日常维护工作\\中国信通院--每日ICT要闻（"+year+"年"+month+"月"+ day +"日）\\";
		String destPic = "C:\\Users\\fengyuan\\Desktop\\mail\\file\\";
		copyPics(srcPic,destPic);
		
	}
	
	public static String[] getDataString(){
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy.MM.dd");
		String format = df.format(date);
		System.out.println(format);
		return format.split("\\.");
	}
	
	private static void copyPics(String srcPic,String destPic) throws IOException{
		for(int i=0; i<6; i++){
			String src = srcPic + (i+1) +".png";
			String dest = destPic + (i+1) +".png";
			System.out.println((i+1)+":" + src);
			System.out.println((i+1)+":" + dest);
			copyAnyTypeFie(src,dest);
		}
		
	}

	private static void copyTXTFile(String src,String dest) {
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader(src);
			fw = new FileWriter(dest);
			char[] buf = new char[1024];
			int len;
			while((len=fr.read(buf))!=-1){
				fw.write(buf, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fr != null){
				try {
					fr.close();
				} catch (IOException e) {
					System.out.println("error");
				}
			}
			
			if(fw != null){
				try {
					fw.close();
				} catch (IOException e) {
					System.out.println("error");
				}		
			}
		}
	}
	
	public static void copyAnyTypeFie(String src,String dest) throws IOException{
		FileInputStream is = new FileInputStream(src);
		FileOutputStream out = new FileOutputStream(dest);
		BufferedInputStream bis = new BufferedInputStream(is);
		BufferedOutputStream bout = new BufferedOutputStream(out);
		byte[] bs = new byte[1024];
		int len;
		while((len=bis.read(bs))!=-1){
			bout.write(bs, 0, len);
		}
		bout.close();
		bis.close();
	}

}
