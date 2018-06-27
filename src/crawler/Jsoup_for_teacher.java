package crawler;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Jsoup_for_teacher {
	public static void main(String[] args) {
		
		Document doc = null;
		String url = "";
		
		//获取目标url
		try {
			/*
			 * 模拟post请求
			 * doc= Jsoup.connect(url).data("", "").userAgent("").cookie("auth", "token").timeout(1000).post(); 
			 */
			//doc = Jsoup.parse(file, "GBK"); 从本地文件获取页面
			doc = Jsoup.connect(url).timeout(1000).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//DOM处理
	}
}
