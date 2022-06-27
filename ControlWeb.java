/**********************************************/
/*author:原田　拓十 6/27更新
/*C8:web情報処理部所属
/*ControlWeb:
/*webから情報を読み取り出力するクラス
/**********************************************/
package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class ControlWeb 
{
	static double ave; //平均気温
	static int hum; //湿度
	static String Weather; //天気
	public static void main(String[] args) 
	{
		
		BufferedReader br = null;
		try {
			//URL読み込み
			URL url = new URL("https://tenki.jp/");
	        InputStream is = url.openStream();
	        InputStreamReader isr = new InputStreamReader(is,"UTF-8");
	        br = new BufferedReader(isr);
	        
	        String str = new String("");  //URLの文字列
	        String area = "新潟"; //入力される地域
	        
	        for(int i = 0;i < 900;i ++) 
	        {
	        	str += br.readLine();
	        }
	        String[]  info = str.split("[%<>\"]"); //strを分割した文字集合
	        for(int i = 0;i < info.length;i ++) 
	        {
	        	if(info[i].equals(area)) 
	        	{
	        		int max = Integer.parseInt(info[i + 20]); //最高気温
	        		int min = Integer.parseInt(info[i + 32]); //最低気温
	        		hum = Integer.parseInt(info[i + 40]);
	        		ave = max + min;
	        		ave /= 2;
	        		Weather  = info[i + 8]; 
	        		break;
	        	}
	        }
		} catch (IOException e) 
		{
			e.printStackTrace();
	    }finally 
		{
	    	try 
	    	{
	    		br.close();
	    	} catch (IOException e) 
	    	{
	    		e.printStackTrace();
	    	}
	    }
	}
	//平均気温を返す
	double aveTemp()
	{
		return ave;
	}
	//湿度を返す
	int humidity() {
		
		return hum;
	}
	//天気を返す
	String Weather() 
	{
		return Weather;
	}
}
