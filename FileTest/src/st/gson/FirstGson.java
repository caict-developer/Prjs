package st.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import st.gson.domain.Student;

public class FirstGson {
	public static void main(String[] args) {
		//testToJson();
		GsonBuilder gb = new GsonBuilder();
		GsonBuilder builder = gb.setPrettyPrinting();
		Gson gson = builder.create();
		Student st = gson.fromJson("{\"name\":\"Ron\",\"sex\":\"female\"}", Student.class);
		System.out.println("name=" + st.getName() + ",sex=" + st.getSex());
	}

	private static void testToJson() {
		GsonBuilder gb = new GsonBuilder();
		GsonBuilder builder = gb.setPrettyPrinting();
		Gson gson = builder.create();
		Student st = new Student("Ron","female");
		String json = gson.toJson(st);
		System.out.println(json);
	}

}
