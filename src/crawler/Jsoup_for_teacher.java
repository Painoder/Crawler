package crawler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Jsoup_for_teacher {
	public static void main(String[] args) {
		
		Document doc = null;
		String url = "";
		
		String major_name = "";
		String href = "";
		HashMap<String, String> teacher_map = null;
		ArrayList<HashMap<String, String>> arr = new ArrayList<>();
		File file = new File("D:\test\teacherinfo.txt");
		PrintWriter pw = null;
		
		//获取目标url
		try {
			/*
			 * 模拟post请求
			 * doc= Jsoup.connect(url).data("", "").userAgent("").cookie("auth", "token").timeout(1000).post(); 
			 */
			//doc = Jsoup.parse(file, "GBK"); 从本地文件获取页面
			doc = Jsoup.connect(url).timeout(1000).get();
			Elements elements =  doc.body().getElementsByTag("tr");
			for(Element element : elements) {
				major_name = element.child(0).getElementsByTag("b").text();
				if(major_name == "会计系") {
					for(int i = 1; i<element.childNodeSize(); i++) {
						href = element.child(i).getElementsByTag("a").attr("href");
						teacher_map = get_TeacherInfo(href);
						arr.add(teacher_map);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i<arr.size() ; i++) {
			teacher_map = arr.get(i);
			try {
				pw = new PrintWriter(file);
				pw.write(teacher_map.get("name")+" ");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	public static HashMap<String, String> get_TeacherInfo (String href){
		
		HashMap<String, String> map = new HashMap<>();
		String teacher_name = "";
		String teacher_sex = "";
		String teacher_job = "";
		String teacher_email = "";
		
		//DOM操作
		
		map.put("name", teacher_name);
		map.put("sex", teacher_sex);
		map.put("job", teacher_job);
		map.put("email", teacher_email);
		
		return map;
	}
	
	
	
	
	
	
	
	
}
