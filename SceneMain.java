package application;

import javafx.stage.Stage;

public class SceneMain{
	//フィールド
	Stage stage;
	
	SceneMain(Stage stage)
	{
		try
		{
			this.stage = stage;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	Stage getStage()
	{
		return stage;
	}
	
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