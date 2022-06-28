
/****************************************/ 
/*author:名久井愛紗 6/28更新 
/*C5:服装提案部所属 
/*DataClothing: 
/*服装提案部でのデータ処理を記述する
/****************************************/

package application;

import java.util.ArrayList;
import java.util.List;

public class DataClothing {
	
	
	static List<Clothes> resultClothes;
	
	//-------------------------------------------- 
	//String[] getWeather() 
	////天気情報要求
	//--------------------------------------------
	String[] getWeather(String area)
	{
		ControlWeb web = new ControlWeb(area);	
		String[] getweather = {};
		getweather[0] = web.aveTemp();
		getweather[1] = web.humidity();
		getweather[2] = web.weather();
		return getweather;
	}
	
	
	//-------------------------------------------- 
	//List<Clothes> getClothes(double[] index) 
	////服装データ要求
	//index:服装指数
	//--------------------------------------------
	List<Clothes> getClothes(String area)
	{
		UserData user = new UserData();
		List<Clothes> clothes = new UserData().clothesRead();
		
		
		String[] weatherdata = getWeather(area);
		double[] index = calculateIndex(weatherdata[0], weatherdata[1],  getWeight());
		
		
		List<Clothes> result; //５つ
		
		
		List<Clothes> tclothes; 
		
		Clothes tmp;
		
		for(int x=0; x<5; x++) {
			for(int i=0; i<clothes.size(); i++) {
				if(clothes.get(i).kind.equals("頭")) {
				tclothes.add(clothes.get(i));
				}
			}
			double min = 99;
			double sum = 0;
			for(int i=0; i<clothes.size(); i++) {
				sum = (tclothes.get(i).index - index[0]) * (tclothes.get(i).index - index[0]);
				if(min>sum) {
					min = sum;
					tmp = tclothes.get(i);
				}
			}
			
			
			result.add(tmp);
			
			
			for(int i=0; i<clothes.size(); i++) {
				if(clothes.get(i).kind.equals("手")) {
				tclothes.add(clothes.get(i));
				}
			}
			double min1 = 99;
			double sum1 = 0;
			for(int i=0; i<clothes.size(); i++) {
				sum1 = (tclothes.get(i).index - index[1]) * (tclothes.get(i).index - index[1]);
				if(min1>sum1) {
					min1 = sum1;
					tmp = tclothes.get(i);
				}
			}
			
			
			result.add(tmp);
			
			for(int i=0; i<clothes.size(); i++) {
				if(clothes.get(i).kind.equals("上半身")) {
				tclothes.add(clothes.get(i));
				}
			}
			double min2 = 99;
			double sum2 = 0;
			for(int i=0; i<clothes.size(); i++) {
				sum2 = (tclothes.get(i).index - index[2]) * (tclothes.get(i).index - index[2]);
				if(min2>sum2) {
					min2 = sum2;
					tmp = tclothes.get(i);
				}
			}
			
			
			result.add(tmp);

			for(int i=0; i<clothes.size(); i++) {
				if(clothes.get(i).kind.equals("下半身")) {
				tclothes.add(clothes.get(i));
				}
			}
			double min3 = 99;
			double sum3 = 0;
			for(int i=0; i<clothes.size(); i++) {
				sum3 = (tclothes.get(i).index - index[3]) * (tclothes.get(i).index - index[3]);
				if(min3>sum3) {
					min3 = sum3;
					tmp = tclothes.get(i);
				}
			}
			
			
			result.add(tmp);

			for(int i=0; i<clothes.size(); i++) {
				if(clothes.get(i).kind.equals("足")) {
				tclothes.add(clothes.get(i));
				}
			}
			double min4 = 99;
			double sum4 = 0;
			for(int i=0; i<clothes.size(); i++) {
				sum4 = (tclothes.get(i).index - index[4]) * (tclothes.get(i).index - index[4]);
				if(min4>sum4) {
					min4 = sum4;
					tmp = tclothes.get(i);
				}
			}
			
			
			result.add(tmp);
			
		}
		
		resultClothes = result;
		
		return result;
	}
	

	//-------------------------------------------- 
	//boolean getGender()
	////性別データ要求
	//--------------------------------------------
	boolean getGender()
	{
		return new UserData().genderRead();
	}
	
	
	//-------------------------------------------- 
	//double[] getWeight()
	////部位とフィードバックの重み要求
	//--------------------------------------------
	List<Double> getWeight()
	{
		return new UserData().weightRead();
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
	//double[] calculateIndex(int tem気温, int 湿度, String 天気, double[] 各部位重み, double フィードバックの重み)
	////服装指数計算
	//tem:気温 humidity:湿度 weather:天気 partweight:各部位の重み feedbackweight:フィードバックの重み
	//--------------------------------------------
	double[] calculateIndex(double tem, double humidity, List<Double> getWeight)
	{
		double[] index = {};
		//計算
		for(int i=0; i<5; i++) {
		index[i] = SceneContents.Lagrange( tem, 10, 0.5, 30, 2);
		index[i] *= SceneContents.Lagrange( humidity, 0, 0.5, 55, 1, 100, 2);
		index[i] *= getWeight.get(i);
		}
		return index;
	}
	
	List<String> getResult()
	{
		
		List<String> resultName = new ArrayList<String>();
		for(int i=0;i<resultClothes.size(); i++) {
			resultName.add(resultClothes.get(i).name);
		}
		return resultName;
		
	}
}
