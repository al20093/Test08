/**********************************************/
/*author:西村　美玖 6/21更新
/*C7:服装設定処理部所属
/*SceneSettingClothing:
/*服装設定モードの際に表示する画面を作成したクラス
/**********************************************/
package application;

import java.util.List;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SceneSettingClothing extends SceneMain {
	
	Scene scene;
	
	SceneSettingClothing(Stage stage)
	{
		super(stage);
	}

	void createAddition() {
		
		//オブジェクト作成
		BorderPane bp = new BorderPane();
		EventSettingClothing event = new EventSettingClothing(this);
		Label title = new Label("追加する服装の情報を入力してください");
		
		List<Label> lb = new ArrayList<Label>()
		{
			{
				add(new Label("名称"));
				add(new Label("服装分類"));
				add(new Label("部位分類"));
				add(new Label("服装指数"));
			}
		};
		
		Button delete = new Button("削除");
		List<Button> button = new ArrayList<Button>()
		{
			{
				add(new Button("キャンセル"));
				add(new Button("登録"));
			}
		};
		
		List<TextField> tf = new ArrayList<TextField>()
		{
			{
				add(new TextField());
				add(new TextField());
				add(new TextField());
				add(new TextField());
			}
		};
		
		//フォント設定
		title.setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,20));
		button.get(0).setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,20));
		button.get(1).setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,20));
		delete.setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,20));
		
		for(int i = 0; i < lb.size(); ++i)
		{
			//ラベルフォント設定
			lb.get(i).setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,15));
			//テキストボックスサイズ
			tf.get(i).setMaxWidth(150);
		}
		
		//上部：左上サブタイトル　メッセージ
		VBox vb_top = new VBox();
		vb_top.getChildren().add(SceneContents.subTitle("設定"));
		vb_top.getChildren().add(title);
		vb_top.setSpacing(10);
		vb_top.setAlignment(Pos.CENTER);
		
		//右部　削除ボタン
		delete.setTranslateX(-20);
		delete.setTranslateY(30);
		
		//中心　テキストフィールドとその説明
		VBox vb_center = new VBox();
		for(int i = 0; i < lb.size(); ++i)
		{
			vb_center.getChildren().add(lb.get(i));
			vb_center.getChildren().add(tf.get(i));
		}
		vb_center.setAlignment(Pos.CENTER);
		vb_center.setTranslateX(-50);
		vb_center.setSpacing(10);
		
		//下部　キャンセルと登録
		HBox hb_bottom = new HBox();
		hb_bottom.getChildren().addAll(button);
		hb_bottom.setPadding(new Insets(9, 9, 9, 9));
		hb_bottom.setSpacing(171);
		hb_bottom.setAlignment(Pos.CENTER);
		
		//ペイン割り当て
		bp.setTop(vb_top);
		bp.setRight(delete);
		bp.setCenter(vb_center);
		bp.setBottom(hb_bottom);
		
		//イベント処理系
		event.clickDelete(delete);
		event.clickCancel(button.get(0));
		event.clickRegister1(button.get(1), tf);
		
		this.scene = new Scene(bp, Constant.WIDTH, Constant.HEIGHT);
	 }
	 
	 void createDelete()
	 {
 		//オブジェクト作成
		Stage subStage = new Stage();
		BorderPane bp = new BorderPane();
 		EventSettingClothing event = new EventSettingClothing(this);
 		ListView<String> lv = new ListView<String>();
		Button addition = new Button("追加");
		Label title = new Label("削除する服装の情報を入力してください");
		List<Button> button = new ArrayList<Button>()
		{
			{
				add(new Button("キャンセル"));
				add(new Button("決定"));
			}
		};
		
		//フォント設定
		title.setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,20));
		button.get(0).setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,20));
		button.get(1).setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,20));
		addition.setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,20));
		
		//上部：左上サブタイトル　メッセージ
		VBox vb_top = new VBox();
		vb_top.getChildren().add(SceneContents.subTitle("設定"));
		vb_top.getChildren().add(title);
		vb_top.setSpacing(10);
		vb_top.setAlignment(Pos.CENTER);
		
		//右部　削除ボタン
		addition.setTranslateX(-20);
		addition.setTranslateY(30);
		
		//下部　キャンセルと登録
		HBox hb_bottom = new HBox();
		hb_bottom.getChildren().addAll(button);
		hb_bottom.setPadding(new Insets(9, 9, 9, 9));
		hb_bottom.setSpacing(171);
		hb_bottom.setAlignment(Pos.CENTER);
		
		//データ処理部より服装データを取得するメソッドを呼び出す
		//List<Clothes> clothes = new DataSettingClothing().getClothes();
		
		ObservableList<String> ol =
				FXCollections.observableArrayList();
		//for(int i = 0; i < clothes.size(); i++)
		//{
		//	ol.add(clothes.get(i).name);  //Labelに服装名称を追加する
		//}
		
		ol.add("上着A");
	
		lv.setItems(ol);	
		
		event.clickCancel(button.get(0));
		event.clickAddition(addition);
		
		//ペイン割り当て
		bp.setTop(vb_top);
		bp.setCenter(lv);
		bp.setRight(addition);
		bp.setBottom(hb_bottom);

		//event.clickRegister2(register, ol, lv);
		this.scene = new Scene(bp, Constant.WIDTH, Constant.HEIGHT);
	}

	Scene getScene() 
	{
		return this.scene;
	}
}
