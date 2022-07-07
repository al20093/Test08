/****************************************/ 
/*author:西村　美玖 6/30更新 
/* 		 佐野　渉 6/29更新
/*C7:服装情報設定処理部所属 
/*DataSettingClothing: 
/*服装設定情報処理部でのデータ処理を記述する
/****************************************/

package application;

import java.util.List;
import java.util.ArrayList;

class DataSettingClothing
{	
	//-------------------------------------------- 
	//List<Clothes> getClothes()
	//ユーザ情報管理部から全ての服装データを取ってくる
	//List<Clothes>:取得した服装データのリスト
	//--------------------------------------------
	List<Clothes> getClothes()
	{
		List<Clothes> clothes;
		//服装データを取得し服装データリストに格納
		clothes = new UserData().clothesRead();
		return clothes;
	}
	
	
	//-------------------------------------------- 
	//boolean addClothes(List<Clothes> clothes)
	//追加した服装情報をファイルに書き込む
	//boolean:名称の被りがなかった場合true
	//--------------------------------------------
	boolean addClothes(Clothes clothes)
	{
 		if(matching(clothes.name).name == null)
		{
			//同じ名称の服装はない
			//ユーザ情報処理部の書き込むメソッドを呼び出す
			new UserData().clothesWrite(clothes);
			return true;
		} else {
			//すでに同じ名称の服装がある
			return false;
		}
	}
	
	
	//-------------------------------------------- 
	//Clothes matching(String clothesName)
	//指定された名称の服装情報を全服装データから
	//持ってくる
	//clothesName:全服装データから取り出す服装名称
	//--------------------------------------------
	Clothes matching(String clothesName)
	{
		Clothes clothes = new Clothes();
		List<Clothes> allClothes = getClothes();
		//全ての服装データnameに会うデータを持ってくる
		for(int i = 0; i < allClothes.size(); i++ )
		{
			if(clothesName.equals(allClothes.get(i).name))
				{
					clothes = allClothes.get(i);
					break;
				}
		}
		return clothes;
	}
	
	//-------------------------------------------- 
	//void deleteClothes(String clothes)
	//削除した服装情報をファイルから削除する
	//--------------------------------------------
	void deleteClothes(Clothes clothes)
	{
		new UserData().clothesDelete(clothes);
	}
	
	//-------------------------------------------- 
	//int exceptionText(Clothes clothes)
	//予期せぬ入力に対するエラーケースの分類を行う
	//--------------------------------------------
	int exceptionText(Clothes clothes)
	{
		//文字数カウント用
		char[] chCount;
		//名称　文字数チェック
		chCount = clothes.name.toCharArray();
		if(chCount.length > Constant.LIMITWORDS)
		{
			return -1;
		}
		//空欄チェック
		if(chCount.length <= 0)
		{
			return -4;
		}
		//服装分類　文字数チェック
		chCount = clothes.kind.toCharArray();
		if(chCount.length > Constant.LIMITWORDS)
		{
			return -2;
		}
		//空欄チェック
		if(chCount.length <= 0)
		{
			return -4;
		}
		//部位分類
		chCount = clothes.part.toCharArray();
		//文字数チェック
		if(chCount.length > Constant.LIMITWORDS)
		{
			return -3;
		}
		//ワードチェック
		for(int i = 0; i < Constant.PARTNAME.length; ++i)
		{
			if(!clothes.part.equals(Constant.PARTNAME[i]))
			{
				if(i < Constant.PARTNAME.length - 1)
				{
					continue;
				} else {
					//頭・手・上半身・下半身・足のどれでもなかったら
					return -6;
				}
			}
			break;
		}
		//服装指数　小数点チェック
		chCount = Double.toString(clothes.index).toCharArray();
		//小数点になるまでインデックスを進める
		int i;
		for(i = 0; chCount[i] != '.'; ++i);
		if((chCount.length - 3) > i)
		{
			//小数第二位よりも大きい場合
			return -5;
		}
		//空欄チェック
		if(chCount.length <= 0)
		{
			return -4;
		}
		//正常に実行された
		return 0;
	}
}