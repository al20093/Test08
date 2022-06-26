/****************************************/ 
/*author:名久井愛紗 6/19更新 
/*C5:服装提案部所属 
/*DataClothing: 
/*服装提案部でのデータ処理を記述する
/****************************************/

package application;

public class DataClothing {
	
	//-------------------------------------------- 
	//String[] getWeather() 
	////天気情報要求
	//--------------------------------------------
	String[] getWeather()
	{
		String weatherData;
		weatherData = //web情報管理部を呼び出す
		return weatherData;
	}
	
	
	//-------------------------------------------- 
	//List<Clothes> getClothes(double[] index) 
	////服装データ要求
	//index:服装指数
	//--------------------------------------------
	List<Clothes> getClothes(double[] index)
	{
		List<Clothes> result; //５つ
		List<Clothes> user; //ユーザ情報管理部 100個
		List<Clothes> clothes;
		clothes = new ～();
		//マッチング
	
		
		if(user.kind == "頭")
		{
			double min = 99;
			double sum =0;
			for(int i=0; i<user.size(); i++) {
				sum = (user.index - index[0]) * (user.index - index[0]);
				if(min>sum) {
					min = sum;
					clothes = user;
				}
			}
			
		}
		

		if(user.kind == "手")
		{
			double min = 99;
			double sum =0;
			for(int i=0; i<user.size(); i++) {
				sum = (user.index - index[1]) * (user.index - index[1]);
				if(min>sum) {
					min = sum;
					clothes = user;
				}
			}
			
		}
		

		if(user.kind == "上半身")
		{
			double min = 99;
			double sum =0;
			for(int i=0; i<user.size(); i++) {
				sum = (user.index - index[2]) * (user.index - index[2]);
				if(min>sum) {
					min = sum;
					clothes = user;
				}
			}
			
		}
		

		if(user.kind == "下半身")
		{
			double min = 99;
			double sum =0;
			for(int i=0; i<user.size(); i++) {
				sum = (user.index - index[3]) * (user.index - index[3]);
				if(min>sum) {
					min = sum;
					clothes = user;
				}
			}
			
		}
		

		if(user.kind == "足")
		{
			double min = 99;
			double sum =0;
			for(int i=0; i<user.size(); i++) {
				sum = (user.index - index[4]) * (user.index - index[4]);
				if(min>sum) {
					min = sum;
					clothes = user;
				}
			}
			
		}
		
		result = clothes;
		//5個
		return result;
	}
	

	//-------------------------------------------- 
	//boolean getGender()
	////性別データ要求
	//--------------------------------------------
	boolean getGender()
	{
		boolean gender;
		gender = //ユーザ情報管理部
		return gender;
	}
	
	
	//-------------------------------------------- 
	//double[] getWeight()
	////フィードバックの重み要求
	//--------------------------------------------
	double[] getWeight()
	{
		return //ユーザ情報管理部
	}
	

	//-------------------------------------------- 
	//void orderList(List<Clothes> clothes)
	////データリスト作成要求
	//clothes:服装提案結果の服装
	//--------------------------------------------
	void orderList(List<Clothes> clothes)
	{
		//ユーザ情報管理部（new ～();）
	}
	
	
	//-------------------------------------------- 
	//double[] calculateIndex(int tem気温, int 湿度, String 天気, double[] 各部位重み, double フィードバックの重み)
	////服装指数計算
	//tem:気温 humidity:湿度 weather:天気 partweight:各部位の重み feedbackweight:フィードバックの重み
	//--------------------------------------------
	double[] calculateIndex(int tem, int humidity, String weather, double[] partweight, double feedbackweight)
	{
		double[] index;
		//計算
		tem 気温
		index 服装指数
		index = 0.53tem - 5.1	
		return index
	}
	
	
	//-------------------------------------------- 
	//void getClothes()
	////服装提案確定
	//--------------------------------------------
	void getClothes()
	{
		List<Clothes> result;
		result = orderList()
		return result;
	}



	

}