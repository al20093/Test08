/**********************************************/
/*author:金　東柱 6/25更新
/*		:佐野　渉 06/27更新 
/*C9:ユーザ情報管理部
/*UserData:
/*ユーザ情報の入出力処理を記述したクラス
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

class UserData 
{
	private static Connection con = null;
	private static JSONObject jsonObj;
	
	//---------------------------------------------------
	//UserData()
	//jsonObjを初期化するコンストラクタ
	//---------------------------------------------------
	UserData()
	{
		//UserDataが初めて呼び出されたとき
		if(jsonObj == null)
		{
			//jsonObjの初期化を行う
			jsonObj = jsonRead();
		}
	}
	
	//--------------------------------------------
	//boolean checkBoot()
	//初起動かどうかチェックするメソッド
	//boolean:初起動のときfalse
	//--------------------------------------------
	boolean checkBoot()
	{
		return (boolean)jsonObj.get("boot");
	}
	
	//---------------------------------------------
	//void defaultWrite()
	//外部ファイルにデフォルトの値を格納するメソッド
	//---------------------------------------------
	void defaultWrite()
	{
		//デフォルト設定書き込み
		//性別
		jsonObj.put("gender", Constant.GENDER);
		//重み
		jsonObj.put("weight", Constant.WEIGHT);
		//フィードバックフラグ
		jsonObj.put("flag", false);
		//服装データ
		clothesReset(); //DBテーブル初期化
		for(int i = 0; i < Constant.CLOTHES.size(); ++i)
		{
			clothesWrite(Constant.CLOTHES.get(i));
		}
		//既起動に変更
		jsonObj.put("boot", true);
		//JSON書き込み
		jsonWrite();
	}
	
	//---------------------------------------------
	//void jsonWrite()
	//JSONファイルに書き込みを行うメソッド
	//---------------------------------------------
	void jsonWrite()
	{
		try
		{
			FileWriter file = new FileWriter(Constant.JSONPATH);
			file.write(jsonObj.toJSONString());
			file.flush();
			file.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//---------------------------------------------
	//void jsonRead()
	//JSONファイルの読出しを行うメソッド
	//obj:jsonファイルの内容をJSONオブジェクトとして
	//	　取得する
	//---------------------------------------------
	JSONObject jsonRead()
	{
		JSONObject obj = new JSONObject();
		JSONParser parser = new JSONParser();
		try 
		{
			FileReader reader = new FileReader(Constant.JSONPATH);
			obj = (JSONObject)parser.parse(reader);
			reader.close();
		} catch(IOException | ParseException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	//---------------------------------------------------
	//void arrayRead()
	//JSONのリスト形式をDouble型リストに変換するメソッド
	//key:JSONファイルから取り出すリストのキー
	//result:JSONリスト形式から変換されたDouble型リスト
	//---------------------------------------------------
	List<Double> arrayRead(String key)
	{
		List<Double> result = new ArrayList<Double>();
		JSONArray arr = (JSONArray)jsonRead().get(key);
		
		if(arr != null)
		{
			for(int i = 0; i < arr.size(); ++i)
			{
				result.add((Double)arr.get(i));
			}
		}
		return result;
	}

	//---------------------------------------------------
	//void flagWrite(boolean flag)
	//フィードバックを行ったかを示すフィードバックフラグ
	//をJSONファイルに書き込むメソッド
	//flag:書き込むフィードバックフラグの状態
	//	   false:フィードバック不可
	//	   true:フィードバック可能
	//---------------------------------------------------
	void flagWrite(boolean flag)
	{
		jsonObj.put("flag", flag);
		jsonWrite();
	}
	
	//---------------------------------------------------
	//void flagRead()
	//フィードバックを行ったかを示すフィードバックフラグ
	//をJSONファイルから読み込むメソッド
	//boolean:読み込んだフィードバックフラグの状態
	//---------------------------------------------------
	boolean flagRead()
	{
		return (boolean)jsonRead().get("flag");
	}
	
	void genderWrite(boolean gender)
	{
		jsonObj.put("gender", gender);
		jsonWrite();
	}
	
	boolean genderRead()
	{
		return (boolean)jsonRead().get("gender");
	}
	
	void weightWrite(List<Double> weight)
	{
		jsonObj.put("weight", weight);
		jsonWrite();
	}
	
	List<Double> weightRead()
	{
		return arrayRead("weight");
	}
	void feedbackWrite(List<Double> feedback)
	{
		jsonObj.put("feedback", feedback);
		jsonWrite();
	}
	
	List<Double> feedbackRead()
	{	
		return arrayRead("feedback");
	}
	
	static void closeConnection()
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
	
	static void getConnection() 
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
	}
	
	void clothesWrite(Clothes clothes) 
	{
		String sql = "INSERT INTO " + Constant.TABLENAME1 + 
				" (name, kind, part, cindex) VALUES (?, ?, ?, ?)";
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
		String sql = "UPDATE " + Constant.TABLENAME1 + 
				" SET name = ?, kind = ?, part = ?, cindex = ? WHERE id = ?";
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
		String sql = "DELETE FROM " + Constant.TABLENAME1 + " WHERE id = ?";
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
			String sql = "SELECT * FROM " + Constant.TABLENAME1;
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) 
			{
				cRead.add(new Clothes(rs.getInt("id"), rs.getString("name"), rs.getString("kind"), 
											rs.getString("part"), rs.getDouble("cindex")));
			}
			stmt.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return cRead;
	}
	
	//---------------------------------------------------
	//void clothesReset()
	//DBに格納された服装情報をすべて削除するメソッド
	//---------------------------------------------------
	void clothesReset()
	{
		String sql1 = "DELETE FROM " + Constant.TABLENAME1;
		String sql2 = "DELETE FROM " + Constant.TABLENAME2;
		PreparedStatement prestmt;
		try
		{
			prestmt = con.prepareStatement(sql1);
			prestmt.executeUpdate();
			prestmt = con.prepareStatement(sql2);
			prestmt.executeUpdate();
			prestmt.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//---------------------------------------------------
	//void createCList()
	//提案された服装をDBテーブルに一時格納するメソッド
	//clothes:C5服装提案部により提案された服装データ
	//---------------------------------------------------
	void createCList(List<Clothes> clothes) 
	{
		String sql = "INSERT INTO " + Constant.TABLENAME2 + " (name, kind, part, cindex) VALUES (?, ?, ?, ?)";
		PreparedStatement prestmt;
		try
		{
			//テーブルの初期化
			prestmt = con.prepareStatement("DELETE FROM " + Constant.TABLENAME2);
			prestmt.executeUpdate();
			//テーブルに服装情報を格納していく
			prestmt = con.prepareStatement(sql);
			for(int i = 0; i < clothes.size(); ++i)
			{
				prestmt.setString(1, clothes.get(i).name);
				prestmt.setString(2, clothes.get(i).kind);
				prestmt.setString(3, clothes.get(i).part);
				prestmt.setDouble(4, clothes.get(i).index);
					
				prestmt.executeUpdate();
			}
			prestmt.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//------------------------------------------------
	//List<Clothes> getCList()
	//DBテーブルに格納された提案された服装データを
	//取り出すメソッド
	//clothes:C5服装提案部により提案された服装データ
	//------------------------------------------------
	List<Clothes> getCList()
	{
		List<Clothes> clothes = new ArrayList<Clothes>();
		try 
		{
			Statement stmt = con.createStatement();
			String sql = "SELECT * FROM " + Constant.TABLENAME2;
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) 
			{
				clothes.add(new Clothes(rs.getInt("id"), rs.getString("name"), rs.getString("kind"), 
											rs.getString("part"), rs.getDouble("cindex")));
			}
			stmt.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return clothes;
	}
}