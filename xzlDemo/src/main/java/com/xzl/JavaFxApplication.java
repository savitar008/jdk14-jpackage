/**
 * Author:   徐志林
 * Date:     2020/3/12/012 19:50
 */
package com.xzl;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author xzl
 * @create 2020/3/12
 */
public class JavaFxApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage){
        Text text = new Text("JDK14，JAVAFX14瘦身啦！");
        HBox sceneBox = new HBox(text);
        sceneBox.setStyle("-fx-alignment: center;-fx-font-size: 1.8em;");
        Scene scene = new Scene(sceneBox,600,400);
        stage.setScene(scene);
        stage.show();
    }
}