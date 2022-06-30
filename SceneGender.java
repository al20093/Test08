/**********************************************/
/*author:原田　拓十 6/27更新
/*C3:性別処理部所属
/*SceneGender:
/*GUIを表示する
/**********************************************/

package application;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SceneGender extends SceneMain
{
	Scene scene;
	
	//-------------------------------------------- 
	//SceneGender(Stage stage)
	//スーパークラスからステージ情報を受け取る
	//stage:シーンの割り当てられたステージ
	//--------------------------------------------
	SceneGender(Stage stage)
	{
		super(stage);
	}
	
	//GUIを作成し表示する
	void createGender() 
	{
		BorderPane bp = new BorderPane(); //ペイン作成
		Label lb = new Label(); //ラベル作成
		EventGender event = new EventGender(this); //イベントオブジェクト作成
		
		lb.setText("どちらかの性別を選択してください");
		lb.setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,20));
		//ボタンリスト作成
		List<Button> bt = new ArrayList<Button>();
		bt.add(new Button("男性"));
		bt.add(new Button("女性"));
		bt.add(new Button("キャンセル"));
		
		bt.get(0).setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,30));
		bt.get(1).setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,30));
		bt.get(2).setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,20));
		
		//上部コントロール
		VBox vb_top = new VBox();
		vb_top.setAlignment(Pos.CENTER);
		vb_top.setPadding(new Insets(0, 0, 0, 0));
		vb_top.setSpacing(10);
		vb_top.getChildren().addAll(SceneContents.subTitle("設定"), lb);
		
		//中部コントロール
		VBox vb_center = new VBox();
		vb_center.setAlignment(Pos.CENTER);
		vb_center.setPadding(new Insets(10, 10, 10, 10));
		vb_center.setSpacing(40);
		vb_center.getChildren().addAll(bt.get(0), bt.get(1));
		
		//下部コントロール
		bt.get(2).setAlignment(Pos.CENTER_LEFT);
		bt.get(2).setTranslateX(16.8);
		bt.get(2).setTranslateY(-8.5);
		
		//ペイン割り当て
		bp.setTop(vb_top);
		bp.setCenter(vb_center);
		bp.setBottom(bt.get(2));
		
		//ボタンにイベント割り当て
		event.selectionMan(bt.get(0));
		event.selectionWoman(bt.get(1));
		event.selectionCancel(bt.get(2));
		
		//シーンの作成処理
		scene = new Scene(bp, Constant.WIDTH, Constant.HEIGHT);
		

	}
	//-------------------------------------------- 
	//void getScene()
	//シーン情報を返すメソッド
	//画面遷移に利用する
	//scene:シーンのレイアウト情報
	//--------------------------------------------
	Scene getScene() 
	{
		return scene;
	}
}