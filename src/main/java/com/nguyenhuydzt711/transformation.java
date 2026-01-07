package com.nguyenhuydzt711;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
// import javafx.scene.text.Text;
import javafx.stage.Stage;

public class transformation extends Application {
    public static void transform(Rectangle rect) {
        rect.setRotate(30);
        rect.setScaleX(1.5);
        rect.setScaleY(1.5);
        rect.setTranslateX(100);
        rect.setTranslateY(200);
    }

    private Parent createContent() {
        Rectangle rect = new Rectangle(100, 50, Color.CYAN);
        transform(rect);
        return new StackPane(rect);
    }

    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(createContent(), 300, 300, Color.GRAY));
        stage.show();
    }

    static public void main(String[] args) {
        launch(args);
    }
}
