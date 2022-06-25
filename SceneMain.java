/**********************************************/
/*author:佐野　渉 6/18更新
/*C1:UI処理部所属
/*SceneMain:
/*すべてのシーンクラスのスーパークラス
/**********************************************/
package application;

import javafx.stage.Stage;

public class SceneMain
{
	//フィールド
	Stage stage;
	
	//コンストラクタ
	SceneMain(Stage stage)
	{
		try
		{
			this.stage = stage;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//------------------------------------------------
	//Stage getStage()
	//シーンが割り当てられているステージを返すメソッド
	//stage:シーンの割り当てられたステージへの参照
	//------------------------------------------------
	Stage getStage()
	{
		return stage;
	}

	//------------------------------------------
	//void assignSceneToStage(String sceneName)
	//シーン遷移を行うメソッド
	//sceneName:呼び出すシーンのマップキー
	//------------------------------------------
	void assignSceneToStage(String sceneName)
	{
		try
		{
			this.stage.setScene(SceneContents.getSmap(sceneName));
			this.stage.setTitle(Constant.TITLE);
			this.stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}