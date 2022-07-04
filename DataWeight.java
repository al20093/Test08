/**********************************************/
/*author:金　東柱 7/5更新
/*		 佐野　渉 6/28更新
/*C4:重み処理部所属
/*EventWeight:
/*重み設定画面のイベント処理を記述したクラス
/**********************************************/
package application;

import java.util.ArrayList;
import java.util.List;

class DataWeight {
	
	//-------------------------------------------- 
	//void weightSave(List<Double> wdata)
	//入力されたデータをユーザ情報管理部に
	//書込みをする
	//wdata:入力された重みのリスト
	//--------------------------------------------
	void weightSave(List<Double> wdata)
	{
		List<Double> weight = new ArrayList<Double>();
		for(int i = 0; i < wdata.size(); ++i)
		{
			weight.add(SceneContents.Lagrange(wdata.get(i), 
					1, Constant.WEIGHTRANGE[0], 6, 1, 11, Constant.WEIGHTRANGE[1]));
		}
		new UserData().weightWrite(weight);
	}
	

	//-------------------------------------------- 
	//boolean getBoot()
	//初期起動状態を取得する
	//--------------------------------------------
	boolean getBoot()
	{
		return new UserData().checkBoot();
	}
	
	//-------------------------------------------- 
	//void onBoot()
	//既起動にする
	//--------------------------------------------
	void onBoot()
	{
		new UserData().writeBoot(true);
	}
}
