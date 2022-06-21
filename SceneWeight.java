package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

class SceneWeight extends SceneMain 
{
	Scene scene;
	
	SceneWeight(Stage stage)
	{
		super(stage);
	}
	
	void createWeight()
	{
		//try 
		//{
			BorderPane bp = new BorderPane();
			EventWeight event = new EventWeight(this);
			
			Label lb = new Label();
			lb.setText("各部位の冷えやすさを入力してください");
			lb.setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,20));
			VBox tvbox = new VBox();
			tvbox.setAlignment(Pos.CENTER);
			tvbox.setSpacing(5);
			tvbox.setPadding(new Insets(10, 0, 0, 0));
			HBox hbox = new HBox();
			hbox.setPadding(new Insets(10, 0, 0, 0));
			hbox.setAlignment(Pos.CENTER);
			Label lb1 = new Label();
			lb1.setText("  1  2  3  4  5  6  7  8  9  10  11  ");
			lb1.setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,25));

			hbox.getChildren().addAll(lb1);
			
			HBox hbox2 = new HBox();
			hbox2.setAlignment(Pos.CENTER);
			hbox2.setPadding(new Insets(10, 0, 0, 0));
			Label hot = new Label();
			hot.setText("←寒い             適切             暑い→");
			hot.setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,25));
			hbox2.getChildren().addAll(hot);
			tvbox.getChildren().addAll(lb, hbox, hbox2);
			bp.setTop(tvbox);
			
			VBox cvbox = new VBox();
			HBox chbox1 = new HBox();
			Label chlb1 = new Label();
			chlb1.setText("　  頭　");
			chlb1.setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,25));
			TextField chtf1 = new TextField();
			chtf1.setPrefWidth(100);
			chtf1.setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,20));
			chbox1.getChildren().addAll(chlb1, chtf1);
			chbox1.setAlignment(Pos.CENTER);
			chbox1.setSpacing(1);
			chbox1.setPadding(new Insets(1, 0, 0, 0));
			HBox chbox2 = new HBox();
			Label chlb2 = new Label();
			chlb2.setText("　  手　");
			chlb2.setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,25));
			TextField chtf2 = new TextField();
			chtf2.setPrefWidth(100);
			chtf2.setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,20));
			chbox2.getChildren().addAll(chlb2, chtf2);
			chbox2.setAlignment(Pos.CENTER);
			chbox2.setSpacing(1);
			chbox2.setPadding(new Insets(1, 0, 0, 0));
			HBox chbox3 = new HBox();
			Label chlb3 = new Label();
			chlb3.setText("下半身  ");
			chlb3.setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,25));
			TextField chtf3 = new TextField();
			chtf3.setPrefWidth(100);
			chtf3.setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,20));
			chbox3.getChildren().addAll(chlb3, chtf3);
			chbox3.setAlignment(Pos.CENTER);
			chbox3.setSpacing(1);
			chbox3.setPadding(new Insets(1, 0, 0, 0));
			HBox chbox4 = new HBox();
			Label chlb4 = new Label();
			chlb4.setText("上半身  ");
			chlb4.setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,25));
			TextField chtf4 = new TextField();
			chtf4.setPrefWidth(100);
			chtf4.setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,20));
			chbox4.getChildren().addAll(chlb4, chtf4);
			chbox4.setAlignment(Pos.CENTER);
			chbox4.setSpacing(1);
			chbox4.setPadding(new Insets(1, 0, 0, 0));
			HBox chbox5 = new HBox();
			Label chlb5 = new Label();
			chlb5.setText("　  足　");
			chlb5.setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,25));
			TextField chtf5 = new TextField();
			chtf5.setPrefWidth(100);
			chtf5.setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,20));
			chbox5.getChildren().addAll(chlb5, chtf5);
			chbox5.setAlignment(Pos.CENTER);
			chbox5.setSpacing(1);
			chbox5.setPadding(new Insets(1, 0, 0, 0));
			cvbox.getChildren().addAll(chbox1, chbox2, chbox3, chbox4, chbox5);
			bp.setCenter(cvbox);
			
			Button btn1 = new Button();
			btn1.setText("キャンセル");
			btn1.setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,20));
			Button btn2 = new Button();
			btn2.setText("登録");
			btn2.setFont(Font.font(Constant.FONTFAMILY,Constant.FONTWEIGHT,25));
			HBox bhbox = new HBox();
			bhbox.setSpacing(135);
			bhbox.setPadding(new Insets(0, 10, 10, 10));
			bhbox.getChildren().addAll(btn1, btn2);
			bp.setBottom(bhbox);
			
			event.weightCancel(btn1);
			this.scene = new Scene(bp, Constant.WIDTH, Constant.HEIGHT);
		//} catch(Exception e) {
			//e.printStackTrace();
		//}
	}
	
	Scene getScene() 
	{
		return this.scene;
	}
}