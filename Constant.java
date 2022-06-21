/**********************************************/
/*author:佐野　渉 6/18更新
/*C1:UI処理部所属
/*Constant:
/*定数の宣言をするメソッド
/**********************************************/
package application;

import javafx.scene.text.FontWeight;

public class Constant {
	
	//インスタンス作成禁止//
	private Constant()
	{
		
	}
	
	//ここから定数の宣言--------------------------------------
	//画面ウィンドウに表示されるタイトル//
	final static String TITLE = "服装提案システム";
	//画面ウィンドウ幅//
	final static int WIDTH = 400;
	final static int HEIGHT = 400;
	//基本フォント設定//
	//フォントの種類
	final static String FONTFAMILY = "SansSerif";
	//フォントの太さ
	final static FontWeight FONTWEIGHT = FontWeight.LIGHT;
	//ここまで------------------------------------------------
}
