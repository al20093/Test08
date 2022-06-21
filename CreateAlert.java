package application;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class CreateAlert
{
	void alertTypeA(String title, String text, Alert.AlertType type)
	{
		Alert al = new Alert(type);
		al.setTitle(title);
		al.getDialogPane().setHeaderText(text);
		al.show();
	}
	
	boolean alertTypeB(String title, String text, Alert.AlertType type)
	{
		Alert al = new Alert(type);
		al.setTitle(title);
		al.getDialogPane().setHeaderText(text);
		Optional<ButtonType> res = al.showAndWait();
		
		if(res.get() == ButtonType.OK)
		{
			return true;
		} else {
			return false;
		}
	}
	
	void complete(String text)
	{
		alertTypeA("完了", text, Alert.AlertType.INFORMATION);
	}
	
	void failure(String text)
	{
		alertTypeA("失敗", text, Alert.AlertType.ERROR);
	}
	
	boolean confirm(String text)
	{
		return alertTypeB("確認", text, Alert.AlertType.CONFIRMATION);
	}
	
	boolean cancel(String text)
	{
		return alertTypeB("キャンセル", text, Alert.AlertType.CONFIRMATION);
	}
}