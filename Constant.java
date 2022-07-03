/**********************************************/
/*author:佐野　渉 6/28更新
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
	//DBファイルパス
	final static String DBPATH = "./user.sqlite3";
	//DBのテーブル名
	final static String TABLENAME1 = "clothes";
	final static String TABLENAME2 = "clist";
	//WebのURL
	final static String WEBURL = "https://tenki.jp/";
	//重みの範囲
	final static double[] WEIGHTRANGE = {1.15, 0.86};
	//気温の範囲
	final static double[] TEMPRANGE = {10, 30};
	//湿度の範囲
	final static double[] HUMIDITYRANGE = {100, 55, 0};
	//体部位名称
	final static String[] PARTNAME = {"頭", "手", "上半身", "下半身", "足"};
	//地域名の集合
	final static String[] AREANAMES = {"札幌", "釧路", "仙台", "新潟", "東京", "金沢", "名古屋",
										"大阪", "広島", "高知","福岡", "鹿児島", "那覇"};
	
	//アラート画面に表示するメッセージ
	//キャンセル時メッセージ
	final static String CANCELMESSAGE = "本当に戻りますか？";
	//登録時メッセージ
	final static String REGISTERMESSAGE = "登録が完了しました。";
	//削除確認メッセージ
	final static String DELETEQUESTION = "本当に削除しますか？";
	//削除時メッセージ
	final static String DELETECOMPLETE = "削除が完了しました。";
	//服装提案時確認メッセージ
	final static String PROPOSALCONFIRM = "服装提案を行いますか？";
	//名称エラー
	final static String NAMEERROR = "名称は１６文字以内で入力してください。";
	//服装分類エラー
	final static String CLOTHESERROR = "服装分類は１６文字以内で入力してください。";
	//部位分類エラー
	final static String PARTERROR = "部位分類は１６文字以内で入力してください。";
	//服装指数エラー
	final static String INDEXERROR = "服装指数は半角小数形式、小数第二位以内で入力してください。";
	//空欄エラー
	final static String EMPTYERROR = "入力欄には何かしらの値を入れる必要があります。";
	//服装追加時エラー
	final static String ADDCLOTHESERROR = "すでに同じ名称の服装が登録されています。";
	//服装削除時エラー
	final static String DELETECLOTHEERROR = "服装が未選択です。";
	//ラジオボタン未選択エラー
	final static String EMPTYRADIOERROR = "ラジオボタンが未選択です。";
	//地域名未選択エラー
	final static String EMPTYAREAERROR = "地域名が未選択です。";
	//インターネット接続エラー
	final static String INTERNETERROR = "インターネットが未接続です。";
	//不明エラー
	final static String UNKNOWNERROR = "原因不明なエラーです。";
	
	//フィードバックフラグfalse時メッセージ
	final static String FLAGMESSAGE = "フィードバックは服装提案後に行うことができます。";
	//テキストボックス文字数制限
	//文字形式
	final static int LIMITWORDS = 16;
	//数字形式
	final static int LIMITNUMBER = 5;
	//ここまで------------------------------------------------
}
