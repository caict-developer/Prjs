package st.gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import st.gson.domain.Student;

public class JsonFileRW {
	
	public static void writeToJsonFile(Student st) throws IOException{
		GsonBuilder gb = new GsonBuilder();
		Gson gson = gb.create();
		FileWriter fw = new FileWriter("st.json");
		fw.write(gson.toJson(st));
		fw.close();
	}
	
	public static Student readFromJsonFile() throws IOException{
		GsonBuilder gb = new GsonBuilder();
		Gson gson = gb.create();
		BufferedReader br = new BufferedReader(new FileReader("st.json"));
		Student st = gson.fromJson(br, Student.class);
		return st;
	}
	
	public static void main(String[] args) throws IOException {
		/*Student st = new Student("zhang","male");
		writeToJsonFile(st);*/
		Student st = readFromJsonFile();
		System.out.println("name=" + st.getName() + ",sex=" + st.getSex());
	}

}
