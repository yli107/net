package edu.study.net.URL;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLDownload {
	public static void main(String[] args) throws IOException {
		// 下载地址
		URL url = new URL("http://localhost:8080/yli107/classified.txt");
		
		//连接到这个资源
		HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		
		InputStream inputStream = urlConnection.getInputStream();
		
		FileOutputStream fos = new FileOutputStream("classified.txt");
		
		byte[] buf = new byte[1024];
		int len;
		
		while((len = inputStream.read(buf))!=-1) {
			fos.write(buf, 0, len);
		}
		
	}
}
