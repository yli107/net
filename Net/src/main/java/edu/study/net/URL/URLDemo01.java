package edu.study.net.URL;

import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo01 {
	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("http://localhost:8080/helloworld/index.jsp?name=leo&password=123");
		
		System.out.println(url.getPath());
		System.out.println(url.getHost());
		System.out.println(url.getPath());
		System.out.println(url.getPort());
		System.out.println(url.getFile());
		System.out.println(url.getQuery());	
		
	}
}
