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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	
	private static Connection con = null;
	
	public static void closeConnection()
	{
		if(con != null) 
		{
			try 
			{
				con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Connection getConnection() 
	{
		if(con == null)
		{
			try 
			{
				Class.forName("org.sqlite.JDBC");
				con = DriverManager.getConnection("jdbc:sqlite:user.sqlite3");
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return con;
	}
	
	
	void clothesWrite(Clothes clothes) 
	{
		String sql = "INSERT INTO TEST_TABLE(name, kind, part, index) VALUES (?, ?, ?, ?)";
		PreparedStatement prestmt;
		try
		{
			prestmt = con.prepareStatement(sql);
			prestmt.setString(1, clothes.name);
			prestmt.setString(2, clothes.kind);
			prestmt.setString(3, clothes.part);
			prestmt.setDouble(4, clothes.index);
				
			prestmt.executeUpdate();
			prestmt.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	void clothesUpdate(Clothes clothes) 
	{
		String sql = "UPDATE TEST_TABLE SET name = ?, kind = ?, part = ?, index = ? WHERE id = ?";
		PreparedStatement prestmt;
		try
		{
			prestmt = con.prepareStatement(sql);
			prestmt.setInt(5, clothes.id);
			prestmt.setString(1, clothes.name);
			prestmt.setString(2, clothes.kind);
			prestmt.setString(3, clothes.part);
			prestmt.setDouble(4, clothes.index);
				
			prestmt.executeUpdate();
			prestmt.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	void clothesDelete(Clothes clothes) 
	{
		String sql = "DELETE FROM TEST_TABLE WHERE id = ?";
		PreparedStatement prestmt;
		try
		{
			prestmt = con.prepareStatement(sql);
			prestmt.setInt(1, clothes.id);
				
			prestmt.executeUpdate();
			prestmt.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	List<Clothes> clothesRead()
	{
		List<Clothes> cRead = new ArrayList<Clothes>();
		try 
		{
			Statement stmt = con.createStatement();
			String sql = "SELECT * FROM TEST_TABLE";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) 
			{
				cRead.add(new Clothes(rs.getInt("id"), rs.getString("name"), rs.getString("kind"), 
											rs.getString("part"), rs.getDouble("index")));
			}
			stmt.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return cRead;
	}
	
	List<Clothes> createCList() 
	{
		
	}
	
	List<Clothes> getCList()
	{
		
	}
}


