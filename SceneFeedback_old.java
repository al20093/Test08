package application;

import java.util.*;

import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.*;
import javafx.scene.layout.*;

class SceneFeedback_old extends SceneMain 
{
	Scene scene;
	
	SceneFeedback_old(Stage stage)
	{
		super(stage);
	}
	
	void createFeedback()
	{
		EventFeedback event = new EventFeedback(this);
		BorderPane bp = new BorderPane();
		Button bt = new Button("登録");
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
		bp.setBottom(bt);
		//イベント割り当て
		event.clickRegister(bt);
		for(int i = 0; i < rb.size(); ++i)
		{
			event.clickRadio(rb.get(i));
		}
		//シーンの作成
		this.scene = new Scene(bp, Constant.WIDTH, Constant.HEIGHT);
	}
	
	Scene getScene() 
	{
		return this.scene;
	}
}