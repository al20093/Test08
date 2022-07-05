/****************************************/ 
/*author:名久井　愛紗 6/28更新 
/*		 佐野　渉 6/29更新
/*C5:服装提案部所属 
/*DataProposal: 
/*服装提案部でのデータ処理を記述する
/****************************************/

package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.scene.control.Label;

public class DataProposal
{
	//5つの提案された服装
	static List<Clothes> resultClothes = new ArrayList<Clothes>();
	
	//-------------------------------------------- 
	//String[] getWeather(String area) 
	////天気情報要求
	//area:地域名
	//--------------------------------------------
	String[] getWeather(String area)
	{

		ControlWeb web = new ControlWeb(area); //地域名から天気情報を取得
		String[] getweather = new String[3]; //気温・湿度・天気の順に格納する配列
		getweather[0] = web.aveTemp();
		getweather[1] = web.humidity();
		getweather[2] = web.weather();
		return getweather;
	}
	
	
	//-------------------------------------------- 
	//List<Clothes> getClothes(String area) 
	////服装データ要求
	//weatherData:電気情報
	//--------------------------------------------
	List<Clothes> getClothes(String[] weatherData)
	{
		//ユーザ情報の服装データを格納
		List<Clothes> clothes = new UserData().clothesRead(); 
		//服装指数の計算結果
		double[] index = calculateIndex(Double.parseDouble(weatherData[0]),
				Double.parseDouble(weatherData[1]), getWeight());
		
		//5つ提案された服装を格納
		List<Clothes> result = new ArrayList<Clothes>();
		//仮の提案された服装を格納
		List<Clothes> tclothes = new ArrayList<Clothes>();
		//服装データを仮で保持
		Clothes tmp = new Clothes();
		
		//部位ごとに、服装に割り当てられた服装指数と計算結果から出た服装指数の差を求め、
		//差の小さいものを提案する
		for(int x = 0; x < Constant.PARTNAME.length; x++)
		{
			for(int i = 0; i < clothes.size(); i++)
			{
				if(clothes.get(i).part.equals(Constant.PARTNAME[x]))
				{
					tclothes.add(clothes.get(i));
				}
			}
			//一つも服装が見つからなければスキップする
			if(tclothes.size() > 0)
			{
				//最小値は最初の要素の差で初期化する
				double min = Math.pow(tclothes.get(0).index - index[x], 2);
				//最初の要素の服装で初期化する
				tmp = tclothes.get(0);
				//合計は０で初期化
				double sum = 0;
				for(int i = 0; i < tclothes.size(); i++) 
				{
					//提案された服装指数とDBの服装指数の差の二乗をとる
					sum = Math.pow(tclothes.get(i).index - index[x], 2);
					if(min > sum) 
					{
						//最小値を更新
						min = sum;
						//服装データを一時保管
						tmp = tclothes.get(i);
					}
				}
				if(tmp.name != null)
				{
					result.add(tmp);
				}
			}
			tclothes.clear();
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
		double[] index = new double[5]; //部位ごとの計算された服装指数を格納
		//計算
		for(int i = 0; i < 5; i++)
		{
			index[i] = tem;
			index[i] *= SceneContents.Lagrange( humidity, Constant.HUMIDITYRANGE[0], Constant.WEIGHTRANGE[0], 
												Constant.HUMIDITYRANGE[1], 1, Constant.HUMIDITYRANGE[2], 
												Constant.WEIGHTRANGE[1]);
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
	
	//-------------------------------------------- 																																																																																																																																																												//void flagReset()//-------------------------------------------- 
	//void flagOn()
	//フィードバックフラグをONにする
	//--------------------------------------------
	void flagOn()
	{
		//フィードバックフラグを有効にする
		new UserData().flagWrite(true);
	}
}
