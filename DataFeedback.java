
/****************************************/ 
/*author:西村美玖 6/24更新 
/*C6:フィードバック処理部所属 
/*DataFeedback: 
/*フィードバック処理部でのデータ処理を記述する
/****************************************/

package application;

import java.util.List;

public class DataFeedback {
	
	//-------------------------------------------- 
	//List<Clothes> getList()
	//服装データをとってくる処理
	//--------------------------------------------
	List<Clothes> getList()
	{
		return new UserData.getCList(); //インスタンスの生成
		
	}
	
	
	//-------------------------------------------- 
	//double getWeight(int value)
	//重みをラグランジュ補完から取得する
	//--------------------------------------------
		double[] getWeight(int value[])
		{
			
			double weightClothes[] = {};
			//ラグランジュ補完を呼び出す
			for(int i = 0; i < 5; i++)
			{
				weightClothes[i] = SceneContents.Lagrange(value[i], 1, 0.5, 6, 1, 11, 2);
			}
			
			return weightClothes;
		}
	
	
	//-------------------------------------------- 
	//List<Clothes> calculateFeedback(double weightClothes[])
	//重みとフィードバック数値をかけ合わせる
	//--------------------------------------------
		List<Clothes> calculateFeedback(double weightClothes[])
		{
			//ユーザ情報管理部から服装データリストをとってくる
			List<Clothes> clothes = getList();
			
			for(int i = 0; i < 5; i++)
			{
				clothes.get(i).index = clothes.get(i).index * weightClothes[i];
			}
			return clothes;
		}
		
	//-------------------------------------------- 
	//void writeUser(List<Clothes> clothes)
	//ユーザ情報管理部に書き込みの命令を出す
	//--------------------------------------------
		
		void writeUser(List<Clothes> clothes)
		{
			//書き込み命令
			new UserData().();
		}
}

