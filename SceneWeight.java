/**********************************************/
/*author:金　東柱 7/5更新
/*C4:重み処理部所属
/*SceneWeight:
/*重み入力画面の画面を記述したクラス
/**********************************************/

package application;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

class SceneWeight extends SceneMain 
{
	Scene scene;
	
	//-------------------------------------------- 
	//SceneWeight(Stage stage)
	//スーパークラスからステージ情報を受け取る
	//stage:シーンの割り当てられたステージ
	//--------------------------------------------
	SceneWeight(Stage stage)
	{
		super(stage);
	}
	
	//-------------------------------------------- 
	//void createWeight() 
	//W3重み入力画面作成
	//--------------------------------------------
	void createWeight()
	{		
			//ペイン作成
			BorderPane bp = new BorderPane();
			VBox cvbox = new VBox();
			GridPane gptf = new GridPane();
			HBox chbox = new HBox();
			//イベントオブジェクト作成
			EventWeight event = new EventWeight(this);
			//ラベルリスト作成
			List<Label> lb = new ArrayList<Label>()
			{
				{
					add(new Label("各部位の冷えやすさを入力してください"));
					add(new Label("  1  2  3  4  5  6  7  8  9  10  11  "));
					add(new Label("←寒い             適切             暑い→"));
				}
			};
			List<Label> lb2 = new ArrayList<Label>()
			{
				{
					add(new Label("頭"));
					add(new Label("手"));
					add(new Label("上半身"));
					add(new Label("下半身"));
					add(new Label("足"));
				}
			};
			List<TextField> chtf = new ArrayList<TextField>()
			{
				{
					add(new TextField());
					add(new TextField());
					add(new TextField());
					add(new TextField());
					add(new TextField());
				}
			};
			List<Button> button = new ArrayList<Button>()
			{
				{
					add(new Button("キャンセル"));
					add(new Button("登録"));
				}
			};
			
			lb.get(0).setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,20));
			lb.get(1).setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,25));
			lb.get(2).setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,25));
			
			button.get(0).setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,20));
			button.get(1).setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,20));
			
			cvbox.getChildren().add(SceneContents.subTitle("設定"));
			cvbox.getChildren().addAll(lb);
			cvbox.setPadding(new Insets(0, 0, 0, 0));
			cvbox.setSpacing(10);
			cvbox.setAlignment(Pos.CENTER);
			
			for(int i = 0; i < lb2.size(); ++i)
			{
				gptf.add(lb2.get(i), 0, i);
				gptf.add(chtf.get(i), 1, i);
				lb2.get(i).setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,20));
				chtf.get(i).setPrefWidth(70);
			}
			gptf.setPadding(new Insets(10, 10, 10, 10));
			gptf.setVgap(10);
			gptf.setHgap(10);
			gptf.setAlignment(Pos.CENTER);
			
			chbox.getChildren().addAll(button);
			chbox.setPadding(new Insets(9, 9, 9, 9));
			chbox.setSpacing(171);
			chbox.setAlignment(Pos.CENTER);
			
			//ペイン割り当て
			bp.setTop(cvbox);
			bp.setCenter(gptf);
			bp.setBottom(chbox);
			
			//イベント割り当て
			event.clickCancel(button.get(0));
			event.clickRegister(button.get(1), chtf);

			//シーンの作成
			this.scene = new Scene(bp, Constant.WIDTH, Constant.HEIGHT);
	}
	
	//-------------------------------------------- 
	//void getScene()
	//シーン情報を返すメソッド
	//画面遷移に利用する
	//scene:シーンのレイアウト情報
	//--------------------------------------------
	Scene getScene() 
	{
		return this.scene;
	}
}