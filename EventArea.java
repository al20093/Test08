/****************************************/ 
/*author:名久井愛紗 6/28更新 
/*C5:服装提案部所属 
/*EventArea: 
/*服装提案部でのイベント処理を記述する
/****************************************/

package application;

import java.util.List;

import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class EventArea {
SceneArea area;
	
	EventArea(SceneArea area)
	{
		this.area = area;
	}
	
	void transitionResult(Button bt, ListView<String> lv, ObservableList<String> items)
	{
		bt.setOnAction((ActionEvent) ->
			{ 
				area.assignSceneToStage("clothing"); 
				String areaname;
				//areaname = lv.getItems(items);
				areaname = lv.getSelectionModel().getSelectedItem();
				List<Clothes> result = new DataClothing().getClothes(areaname);
				new DataClothing().orderList(result);
			});
	}
	
	void transitionHome(Button bt)
	{
		bt.setOnAction((ActionEvent) ->
			{ area.assignSceneToStage("home"); });
	}
	
}
