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
import java.sql.*;
import java.util.*;

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
	
	List<Double> weightRead()
	{
		JSONObject obj = new JSONObject();
		JSONParser parser = new JSONParser();
		List<Double> weightRead = new ArrayList<Double>();
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
	
	List<Double> feedbackRead()
	{
		JSONObject obj = new JSONObject();
		JSONParser parser = new JSONParser();
		List<Double> fbRead = new ArrayList<Double>();
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
	
	void clothesWrite(Clothes clothes) 
	{
		Connection con = null;
		String dbFileUrl = "jdbc:sqlite:user.sqlite3";
		String sql = "INSERT INTO TEST_TABLE VALUES (?, ?, ?, ?, ?)";
		PreparedStatement prestmt;
		try
		{
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection(dbFileUrl);
			prestmt = con.prepareStatement(sql);
				prestmt.set
				prestmt.set
				prestmt.set
				prestmt.set
				prestmt.set
				
				prestmt.executeUpdate();
				prestmt.close();
				con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	void clothesUpdate(Clothes clothes) 
	{
		
	}
	
	void clothesDelete(Clothes clothes) 
	{
		
	}
	
	List<Clothes> clothesRead()
	{
		List<Clothes> cRead = new ArrayList<Clothes>();
		Connection con = null;
		String dbFileUrl = "jdbc:sqlite:user.sqlite3";
		try 
		{
			con = DriverManager.getConnection(dbFileUrl);
			Statement stmt = con.createStatement();
			String sql = "SELECT * FROM TEST_TABLE";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) 
			{
				//cReadの処理 = rs.getString("id"); の形
			}
			stmt.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return cRead;
	}
	
	void createCList() 
	{
		
	}
	
	List<Clothes> getCList()
	{
		
	}
}


