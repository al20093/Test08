/**********************************************/
/*author:金　東柱 6/25更新
/*C9:ユーザ情報管理部
/*UserData:
/*ユーザ情報を処理を記述したクラス
/**********************************************/

package application;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class UserData 
{
	
	void genderWrite(boolean gender)
	{
		JSONObject obj = new JSONObject();
		obj.put("gender", gender);
		
		try
		{
			FileWriter file = new FileWriter("./data.json");
			file.write(obj.toJSONString());
			file.flush();
			file.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	boolean genderRead()
	{
		JSONObject obj = new JSONObject();
		JSONParser parser = new JSONParser();
		boolean gender = true;
		try 
		{
			FileReader reader = new FileReader("./data.json");
			obj = (JSONObject)parser.parse(reader);
			gender = (boolean)obj.get("gender");
			
			reader.close();
		} catch(IOException | ParseException e) {
			e.printStackTrace();
		}
		return gender;
	}
	
	void weightWrite(ArrayList<Double> weight)
	{
		JSONObject obj = new JSONObject();
		obj.put("weight", weight);
		
		try
		{
			FileWriter file = new FileWriter("./data.json");
			file.write(obj.toJSONString());
			file.flush();
			file.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	ArrayList<Double> weightRead()
	{
		JSONObject obj = new JSONObject();
		JSONParser parser = new JSONParser();
		ArrayList<Double> weightRead = new ArrayList<Double>();
		try
		{
			FileReader reader = new FileReader("./data.json");
			obj = (JSONObject)parser.parse(reader);
			JSONArray weightData = (JSONArray)obj.get("weight");
			if(weightData != null) 
			{
				for(int i=0; i<weightData.size(); i++) 
				{
					weightRead.add((double)weightData.get(i));
				}
			}
			
			reader.close();
		} catch(IOException | ParseException e) {
			e.printStackTrace();
		}
		return weightRead;
	}
	void feedbackWrite(ArrayList<Double> feedback)
	{
		JSONObject obj = new JSONObject();
		obj.put("feedback", feedback);
		
		try
		{
			FileWriter file = new FileWriter("./data.json");
			file.write(obj.toJSONString());
			file.flush();
			file.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	ArrayList<Double> feedbackRead()
	{
		JSONObject obj = new JSONObject();
		JSONParser parser = new JSONParser();
		ArrayList<Double> fbRead = new ArrayList<Double>();
		try
		{
			FileReader reader = new FileReader("./data.json");
			obj = (JSONObject)parser.parse(reader);
			JSONArray fbData = (JSONArray)obj.get("feedback");
			if(fbData != null) 
			{
				for(int i=0; i<fbData.size(); i++) 
				{
					fbRead.add((double)fbData.get(i));
				}
			}
			
			reader.close();
		} catch(IOException | ParseException e) {
			e.printStackTrace();
		}
		return fbRead;
	}
	

	
}



