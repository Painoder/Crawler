package crawler;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Jsoup_for_teacher {
	public static void main(String[] args) {
		
		Document doc = null;
		String url = "";
		
		//��ȡĿ��url
		try {
			/*
			 * ģ��post����
			 * doc= Jsoup.connect(url).data("", "").userAgent("").cookie("auth", "token").timeout(1000).post(); 
			 */
			//doc = Jsoup.parse(file, "GBK"); �ӱ����ļ���ȡҳ��
			doc = Jsoup.connect(url).timeout(1000).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//DOM����
	}
}
