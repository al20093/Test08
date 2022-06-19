package application;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class EventBasic {
	SceneBasic basic;
	
	EventBasic(SceneBasic basic)
	{
		this.basic = basic;
	}
	
	void clickWindow()
	{
		basic.getScene().addEventHandler(MouseEvent.MOUSE_CLICKED, 
			(MouseEvent) -> { basic.assignSceneToStage("home"); });
	}
	
	void transitionReference(Button bt)
	{
		bt.setOnAction((ActionEvent) ->
			{ basic.assignSceneToStage("feedback"); });
	}
	
	void transitionClothing(Button bt)
	{ 
		bt.setOnAction((ActionEvent) ->
			{
				boolean check = new CreateAlert().confirm("処理完了しました。");
				if(check == true)
				{
					System.out.println("true");
				} else {
					System.out.println("false");
				}
			});
	}
}
