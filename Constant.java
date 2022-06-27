/**********************************************/
/*author:佐野　渉 6/18更新
/*C1:UI処理部所属
/*Constant:
/*定数の宣言をするメソッド
/**********************************************/
package application;

import java.util.List;
import java.util.ArrayList;

import javafx.scene.text.FontWeight;

public class Constant {
	
	//インスタンス作成禁止
	private Constant()
	{
		
	}
	
	//ここから定数の宣言--------------------------------------
	//デフォルトデータ
	//性別:男
	final static boolean GENDER = true;
	//重み:すべて1.0　全体，頭，手，上半身，下半身，足
	final static List<Double> WEIGHT = new ArrayList<Double>()
	{
		{
			for(int i = 0; i < 6; ++i)
			{
				add(1.0);
			}
		}
	};
	//服装データ
	final static List<Clothes> CLOTHES = new ArrayList<Clothes>()
	{
		{
			add(new Clothes(1, "キャップ(夏用)", "帽子", "頭", 27.0));
			add(new Clothes(2, "上着(薄)", "シャツ", "上半身", 29.0));
			add(new Clothes(3, "上着(厚)", "シャツ", "上半身", 18.0));
			add(new Clothes(4, "コート", "コート", "上半身", 7.0));
			add(new Clothes(5, "手袋(薄)", "手袋", "手", 15.0));
			add(new Clothes(6, "手袋(厚)", "手袋", "手", 8.0));
			add(new Clothes(7, "靴下(薄)", "靴下", "足", 26.0));
			add(new Clothes(8, "靴下(厚)", "靴下", "足", 9.0));
		}
	};
	//初起動の有無を格納する定数
	final static boolean FIRSTBOOT = new UserData().checkBoot();
	//画面ウィンドウに表示されるタイトル
	final static String TITLE = "服装提案システム";
	//画面ウィンドウ幅
	final static int WIDTH = 400;
	final static int HEIGHT = 400;
	//基本フォント設定
	//フォントの種類
	final static String FONTFAMILY = "SansSerif";
	//フォントの太さ
	final static FontWeight FONTWEIGHT = FontWeight.LIGHT;
	//JSONファイルパス
	final static String JSONPATH = "./data.json";
	//DBのテーブル名
	final static String TABLENAME1 = "clothes";
	final static String TABLENAME2 = "clist";
	//ここまで------------------------------------------------
}
