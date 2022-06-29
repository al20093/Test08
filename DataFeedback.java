/****************************************/ 
/*author:西村美玖 6/24更新 
/* 		 佐野　渉 6/28更新
/*C6:フィードバック処理部所属 
/*DataFeedback: 
/*フィードバック処理部でのデータ処理を記述する
/****************************************/

package application;

import java.util.ArrayList;
import java.util.List;

public class DataFeedback
{
	//-------------------------------------------- 
	//List<Clothes> getList()
	//服装データをとってくる処理
	//--------------------------------------------
	List<Clothes> getList()
	{
		return new UserData().getCList(); //インスタンスの生成
	}
	
	
	//-------------------------------------------- 
	//double getWeight(List<Integer> value)
	//重みをラグランジュ補完により変換する
	//--------------------------------------------
	List<Double> getWeight(List<Integer> value)
	{
		
		List<Double> weightClothes = new ArrayList<Double>();
		//ラグランジュ補完を呼び出す
		for(int i = 0; i < value.size(); i++)
		{
			weightClothes.add(SceneContents.Lagrange(value.get(i)
					, 1, Constant.WEIGHTRANGE[0], 6, 1, 11, Constant.WEIGHTRANGE[1]));
		}
		
		return weightClothes;
	}
	
	
	//-------------------------------------------- 
	//List<Clothes> calculateFeedback(double weightClothes[])
	//重みとフィードバック数値をかけ合わせる
	//--------------------------------------------
	List<Clothes> calculateFeedback(List<Double> weightClothes)
	{
		//ユーザ情報管理部から服装データリストをとってくる
		List<Clothes> clothes = getList();
		
		for(int i = 0; i < clothes.size(); i++)
		{
			clothes.get(i).index = clothes.get(i).index * weightClothes.get(i);
			clothes.set(i, clothes.get(i));
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
		for(int i = 0; i < clothes.size(); ++i)
		{
			new UserData().clothesUpdate(clothes.get(i));
		}
	}
	
	void flagReset()
	{
		//フィードバックフラグをfalseに戻す
		new UserData().flagWrite(false);
	}
}