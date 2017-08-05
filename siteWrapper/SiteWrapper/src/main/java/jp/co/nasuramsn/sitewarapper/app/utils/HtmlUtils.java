package jp.co.nasuramsn.sitewarapper.app.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;

// HTML関連のUtilクラス
public class HtmlUtils {

	// 指定されたURLのソースを返す
	public static String getHtmlSource(String urlPath) {
		URL url;
		StringBuffer response = new StringBuffer();
		try {
			url = new URL(urlPath);
			URLConnection conn = url.openConnection();

			String charset = Arrays.asList(conn.getContentType().split(";") ).get(1);
		    String encoding = Arrays.asList(charset.split("=") ).get(1);

		    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), encoding ));

		    String line;
		    while ((line= in.readLine()) != null)
		            response.append(line+"\n");
		    in.close();

		} catch (MalformedURLException mue) {
			// TODO 自動生成された catch ブロック
			mue.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		return response.toString();
	}
}
