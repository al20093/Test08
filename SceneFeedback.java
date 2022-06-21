package application;

import java.util.*;

import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.*;
import javafx.scene.layout.*;

class SceneFeedback extends SceneMain 
{
	Scene scene;
	
	SceneFeedback(Stage stage)
	{
		super(stage);
	}
	
	void createFeedback()
	{
		BorderPane bp = new BorderPane();
		ToggleGroup tg = new ToggleGroup();
		List<RadioButton> rb = new ArrayList<RadioButton>()
		{
			{
				for(int i = 1; i <= 11; ++i)
				{
					add(new RadioButton(Integer.toString(i)));
				}
			}
		};
		
		for(int i=0; i<rb.size(); ++i)
		{
			rb.get(i).setToggleGroup(tg);
			//rb.get(i).setOnAction(new EventFeedback(this));
		}
		//ボタンをHBoxに割り当てる
		HBox hb = new HBox();
		hb.setAlignment(Pos.CENTER);
		hb.getChildren().addAll(rb);
		//ペイン割り当て
		bp.setCenter(hb);
		//シーンの作成
		this.scene = new Scene(bp, Constant.WIDTH, Constant.HEIGHT);
	}
	
	Scene getScene() 
	{
		return this.scene;
	}
}