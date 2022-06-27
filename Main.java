/**********************************************/
/*author:佐野　渉 6/27更新
/*C1:UI処理部所属
/*Main:
/*メインメソッドを有するクラス
/*主にシステム起動のための他クラス呼び出しを行う
/**********************************************/
package application;

import java.util.List;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	public void start(Stage primaryStage) {
		//シーンのスーパークラス作成
		SceneMain sceneMain = new SceneMain(primaryStage);
		//他すべてのシーンを作成する
		SceneContents.createScene(sceneMain);
		//DBとの接続
		UserData.getConnection();
		//初起動のチェック
		if(Constant.FIRSTBOOT)
		{
			//既起動の時　ホーム画面へ
			sceneMain.assignSceneToStage("home");
		} else {
			//初起動の時　初期画面へ
			sceneMain.assignSceneToStage("initial");
			//デフォルト設定を行う
			new UserData().defaultWrite();
		}
		/*List<Double> feedback = new ArrayList()
		{
			{
				add(24.2);
				add(12.1);
				add(21.4);
				add(32.5);
				add(8.9);
			}
		};
		new UserData().feedbackWrite(feedback);*/
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

