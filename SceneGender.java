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
	
	SceneGender(Stage stage){
		super(stage);
	}
	
	//GUIを作成し表示する
	void createGender() 
	{
		BorderPane bp = new BorderPane(); //ペイン作成
		Label lb = new Label(); //ラベル作成
		lb.setText("どちらかの性別を選択してください");
		lb.setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,20));
		//ボタンリスト作成
		List<Button> bt = new ArrayList<Button>();
		bt.add(new Button("男性"));
		bt.add(new Button("女性"));
		bt.add(new Button("キャンセル"));
		
		//イベントオブジェクト作成
		EventGender event = new EventGender(this);
		
		for(int i = 0; i < bt.size(); i ++) 
		{
			bt.get(i).setFont(Font.font(
					Constant.FONTFAMILY,Constant.FONTWEIGHT,25));
		}
		
		
		//ボタンをVBoxに割り当てる
		VBox vb = new VBox();
		vb.setAlignment(Pos.CENTER);
		vb.setPadding(new Insets(10, 10, 10, 10));
		vb.setSpacing(30);
		vb.getChildren().addAll(lb);
		vb.getChildren().addAll(bt);
		//ペイン割り当て
		bp.setTop(SceneContents.subTitle("設定"));
		bp.setCenter(vb);
		//ボタンにイベント割り当て
		event.selectionMan(bt.get(0));
		event.selectionWoman(bt.get(1));
		event.selectionCancel(bt.get(2));
		//シーンの作成
		scene = new Scene(bp, Constant.WIDTH, Constant.HEIGHT);
		

	}
	//sceneを返す
	Scene getScene() {
		return scene;
	}
}