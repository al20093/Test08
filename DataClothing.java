
/****************************************/ 
/*author:名久井愛紗 6/28更新 
/*C5:服装提案部所属 
/*DataClothing: 
/*服装提案部でのデータ処理を記述する
/****************************************/

package application;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Label;

public class DataClothing 
{
	
	static List<Clothes> resultClothes; //5つの提案された服装
	
	//-------------------------------------------- 
	//String[] getWeather(String area) 
	////天気情報要求
	//area:地域名
	//--------------------------------------------
	String[] getWeather(String area)
	{
		ControlWeb web = new ControlWeb(area); //地域名から天気情報を取得
		String[] getweather = {}; //気温・湿度・天気の順に格納する配列
		getweather[0] = web.aveTemp();
		getweather[1] = web.humidity();
		getweather[2] = web.weather();
		return getweather;
	}
	
	//-------------------------------------------- 
	//List<Clothes> getClothes(String area) 
	////服装データ要求
	//area:地域名
	//--------------------------------------------
	List<Clothes> getClothes(String area)
	{
		//UserData user = new UserData(); 
		List<Clothes> clothes = new UserData().clothesRead(); //ユーザ情報の服装データを格納
		String[] weatherdata = getWeather(area); //天気情報を要求
		double[] index = calculateIndex(weatherdata[0], weatherdata[1],  getWeight()); //服装指数の計算結果
		
		List<Clothes> result; //5つ提案された服装を格納
		List<Clothes> tclothes; //仮の提案された服装を格納
		Clothes tmp; //服装データを仮で保持
		
		//部位ごとに、服装に割り当てられた服装指数と計算結果から出た服装指数の差を求め、差の小さいものを提案する
		for(int x = 0; x < 5; x++)
		{
			for(int i = 0; i < clothes.size(); i++) 
			{
				if(clothes.get(i).kind.equals("頭")) 
				{
					tclothes.add(clothes.get(i));
				}
			}
			double min = 99;
			double sum = 0;
			for(int i = 0; i < clothes.size(); i++) 
			{
				sum = (tclothes.get(i).index - index[0]) * (tclothes.get(i).index - index[0]);
				if(min > sum) 
				{
					min = sum;
					tmp = tclothes.get(i);
				}
			}
			result.add(tmp);
			
			
			for(int i = 0; i < clothes.size(); i++) 
			{
				if(clothes.get(i).kind.equals("手")) 
				{
					tclothes.add(clothes.get(i));
				}
			}
			double min1 = 99;
			double sum1 = 0;
			for(int i = 0; i < clothes.size(); i++) 
			{
				sum1 = (tclothes.get(i).index - index[1]) * (tclothes.get(i).index - index[1]);
				if(min1 > sum1) 
				{
					min1 = sum1;
					tmp = tclothes.get(i);
				}
			}
			result.add(tmp);
			
			
			for(int i = 0; i < clothes.size(); i++) 
			{
				if(clothes.get(i).kind.equals("上半身"))
				{
					tclothes.add(clothes.get(i));
				}
			}
			double min2 = 99;
			double sum2 = 0;
			for(int i = 0; i < clothes.size(); i++) 
			{
				sum2 = (tclothes.get(i).index - index[2]) * (tclothes.get(i).index - index[2]);
				if(min2 > sum2) 
				{
					min2 = sum2;
					tmp = tclothes.get(i);
				}
			}
			result.add(tmp);

			
			for(int i = 0; i < clothes.size(); i++)
			{
				if(clothes.get(i).kind.equals("下半身")) 
				{
					tclothes.add(clothes.get(i));
				}
			}
			double min3 = 99;
			double sum3 = 0;
			for(int i = 0; i < clothes.size(); i++) 
			{
				sum3 = (tclothes.get(i).index - index[3]) * (tclothes.get(i).index - index[3]);
				if(min3 > sum3) 
				{
					min3 = sum3;
					tmp = tclothes.get(i);
				}
			}	
			result.add(tmp);

			
			for(int i = 0; i < clothes.size(); i++) 
			{
				if(clothes.get(i).kind.equals("足"))
				{
					tclothes.add(clothes.get(i));
				}
			}
			double min4 = 99;
			double sum4 = 0;
			for(int i = 0; i < clothes.size(); i++) 
			{
				sum4 = (tclothes.get(i).index - index[4]) * (tclothes.get(i).index - index[4]);
				if(min4 > sum4) 
				{
					min4 = sum4;
					tmp = tclothes.get(i);
				}
			}
			result.add(tmp);
		}
		resultClothes = result; //提案された服装を代入
		
		return result;
	}
	
	//-------------------------------------------- 
	//boolean getGender()
	////性別データ要求
	//--------------------------------------------
	boolean getGender()
	{
		return new UserData().genderRead(); //ユーザ情報の性別データを返す
	}
	
	//-------------------------------------------- 
	//List<Double> getWeight()
	////部位とフィードバックの重み要求
	//--------------------------------------------
	List<Double> getWeight()
	{
		return new UserData().weightRead(); //ユーザ情報の部位とフィードバックの重みデータを返す
	}

	//-------------------------------------------- 
	//void orderList(List<Clothes> clothes)
	////データリスト作成要求
	//clothes:服装提案結果の服装
	//--------------------------------------------
	void orderList(List<Clothes> clothes)
	{
		new UserData().createCList(clothes); //服装データリスト取得
	}
	
	//-------------------------------------------- 
	//double[] calculateIndex(double tem, double humidity, List<Double> getWeight)
	////服装指数計算
	//tem:気温 humidity:湿度 getWeight:各部位とフィードバックの重み
	//--------------------------------------------
	double[] calculateIndex(double tem, double humidity, List<Double> getWeight)
	{
		double[] index = {}; //部位ごとの計算された服装指数を格納
		//計算
		for(int i = 0; i < 5; i++)
		{
			index[i] = SceneContents.Lagrange( tem, 10, 0.5, 30, 2);
			index[i] *= SceneContents.Lagrange( humidity, 0, 0.5, 55, 1, 100, 2);
			index[i] *= getWeight.get(i);
		}
		
		return index;
	}

	//-------------------------------------------- 
	//List<Label> getResult()
	////提案された服装の名称要求
	//--------------------------------------------
	List<Label> getResult()
	{
		
		List<Label> resultName = new ArrayList<Label>(); //提案された服装を格納
		//5つの服装の名称を追加
		for(int i = 0; i < resultClothes.size(); i++) 
		{
			resultName.add(new Label(resultClothes.get(i).name));
		}
		
		return resultName;	
	}
}
