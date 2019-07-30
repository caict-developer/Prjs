package st.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Hashtable;

public class Demo {
	public static void main(String[] args) throws IOException {
		//test();
		byte[] arr = new byte[3];
		testBasicType(arr);
		System.out.println(arr[2]);
	}
	
	private static void testBasicType(byte[] arr){
		arr[0] = 2;
		arr[1] = 20;
		arr[2] = 30;
	}

	private static void test() throws IOException {
		File f = new File("C:\\Users\\fengyuan\\Desktop\\ttt.txt");
		//ArrayList<String> a2 = readFiletoList(f);
		//System.out.println("a2" + a2.toString());
		Hashtable<String,Object> h = new Hashtable<>();
		h = readFiletoMap(f);
		System.out.println(h.toString());
	}
	
	public static ArrayList<String> readFiletoList(File f) throws IOException{
		FileInputStream fis = new FileInputStream(f);
		Reader r = new InputStreamReader(fis);
		ArrayList<String> list = new ArrayList<String>();
		StringBuffer sb = new StringBuffer();
		while(true){
			int read = r.read();
			if(read == -1){
				r.close();
				return list;
			} else if((char)read == ' '){
				if(sb != null){
					list.add(sb.toString());
					sb.delete(0, sb.length());
				}
				continue;
			} else {
				StringBuffer append = sb.append((char)read);
			}
		}
	}
	
	public static Hashtable<String,Object> readFiletoMap(File f) throws IOException{
		Hashtable <String,Object> map = new Hashtable<>();
		Reader r = new InputStreamReader(new FileInputStream(f));
		while(true){
			String key = null;
			String value = null;
			int ch = r.read();
			if(ch == -1){
				return map;
			} else if((char)ch == '"'){
				key = readString(r);
			}
			
			
			int v = r.read();
			if((char)v == '='){
				int v1=r.read();
				if((char)v1 == '"'){
					value = readString(r);
				} else if((char)v1 == '{'){
					
				}
			}
			
			map.put(key, value);
		}
	}
	
	public static String readString(Reader r) throws IOException{
		StringBuffer sb = new StringBuffer();
		while(true){
			int ch = r.read();
			if((char)ch=='"'|| ch==-1)
				return sb.toString();
			else {
				sb.append((char)ch);
			}
		}
	}
}
