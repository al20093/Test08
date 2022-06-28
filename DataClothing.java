
/****************************************/ 
/*author:名久井愛紗 6/28更新 
/*C5:服装提案部所属 
/*DataClothing: 
/*服装提案部でのデータ処理を記述する
/****************************************/

package application;

import java.util.List;

public class DataClothing {
	
	//-------------------------------------------- 
	//String[] getWeather() 
	////天気情報要求
	//--------------------------------------------
	double[] getWeather(String area)
	{
		ControlWeb web = new ControlWeb(area);	
		double[] getweather;
		getweather[0] = web.aveTemp();
		getweather[1] = web.humidity();
		getweather[2] = web.Weather();
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
		
		
		double[] weatherdata = getWeather(area);
		double[] index = calculateIndex(weatherdata[0], weatherdata[1], weatherdata[2], getWeight());
		
		
		List<Clothes> result; //５つ
		
		
		List<Clothes> tclothes; 
		for(int x=0; x<5; x++) {
			for(int i=0; i<clothes.size(); i++) {
				tclothes = clothes.get(i).kind=="頭";
			}
			double min = 99;
			double sum = 0;
			for(int i=0; i<clothes.size(); i++) {
				sum = (tclothes.get(i).index - index[0]) * (tclothes.get(i).index - index[0]);
				if(min>sum) {
					min = sum;
					result = tclothes;
				}
			}
			
			for(int i=0; i<clothes.size(); i++) {
				tclothes = clothes.get(i).kind=="手";
			}
			double min1 = 99;
			double sum1 = 0;
			for(int i=0; i<clothes.size(); i++) {
				sum1 = (tclothes.get(i).index - index[1]) * (tclothes.get(i).index - index[1]);
				if(min1>sum1) {
					min1 = sum1;
					result = tclothes;
				}
			}

			for(int i=0; i<clothes.size(); i++) {
				tclothes = clothes.get(i).kind=="上半身";
			}
			double min2 = 99;
			double sum2 = 0;
			for(int i=0; i<clothes.size(); i++) {
				sum2 = (tclothes.get(i).index - index[2]) * (tclothes.get(i).index - index[2]);
				if(min2>sum2) {
					min2 = sum2;
					result = tclothes;
				}
			}
			

			for(int i=0; i<clothes.size(); i++) {
				tclothes = clothes.get(i).kind=="下半身";
			}
			double min3 = 99;
			double sum3 = 0;
			for(int i=0; i<clothes.size(); i++) {
				sum3 = (tclothes.get(i).index - index[3]) * (tclothes.get(i).index - index[3]);
				if(min3>sum3) {
					min3 = sum3;
					result = tclothes;
				}
			}

			for(int i=0; i<clothes.size(); i++) {
				tclothes = clothes.get(i).kind=="足";
			}
			double min4 = 99;
			double sum4 = 0;
			for(int i=0; i<clothes.size(); i++) {
				sum4 = (tclothes.get(i).index - index[4]) * (tclothes.get(i).index - index[4]);
				if(min4>sum4) {
					min4 = sum4;
					result = tclothes;
				}
			}
			
		}
		
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
		new UserData().getCList(); //服装データリスト取得
	}
	
	
	//-------------------------------------------- 
	//double[] calculateIndex(int tem気温, int 湿度, String 天気, double[] 各部位重み, double フィードバックの重み)
	////服装指数計算
	//tem:気温 humidity:湿度 weather:天気 partweight:各部位の重み feedbackweight:フィードバックの重み
	//--------------------------------------------
	double[] calculateIndex(double tem, double humidity, double weather, double[] getWeight)
	{
		double[] index = {};
		//計算
		for(int i=0; i<5; i++) {
		index[i] = SceneContents.Lagrange( tem, humidity, weather, getWeight[i]);
		}
		return index;
	}
	
	
	//-------------------------------------------- 
	//void getClothes()
	////服装提案確定
	//--------------------------------------------
	void getClothes()
	{
		List<Clothes> result;
		result = orderList(clothes);
	}
	

}
