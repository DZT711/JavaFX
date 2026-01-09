package com.nguyenhuydzt711;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class imageView extends Application {
    private final static String IMAGE_URL = "file:src/main/java/com/nguyenhuydzt711/download.jfif";

    @Override
    public void start(javafx.stage.Stage primaryStage) throws Exception {
        Image image = new Image(IMAGE_URL);
        Image image2 = new Image(IMAGE_URL, 360.0d, 360.0d, true, true);
        Image image3 = new Image(IMAGE_URL, 360.0d, 360.0d, false, true);

        ImageView iv1 = new ImageView(image);
        ImageView iv2 = new ImageView(image2);
        ImageView iv3 = new ImageView(image3);
        ImageView iv4 = new ImageView(IMAGE_URL);

        iv4.setPreserveRatio(true);
        iv4.setFitHeight(360);
        iv4.setFitWidth(360);
        Rectangle2D vprec = new Rectangle2D(20, 50, 100, 100);
        iv4.setViewport(vprec);
        // javafx.scene.layout.StackPane root = new javafx.scene.layout.StackPane(iv4);
        javafx.scene.layout.StackPane root = new javafx.scene.layout.StackPane(iv1);
        // javafx.scene.layout.StackPane root = new javafx.scene.layout.StackPane(iv2);
        // javafx.scene.layout.StackPane root = new javafx.scene.layout.StackPane(iv3);
        javafx.scene.Scene scene = new javafx.scene.Scene(root, 450, 300);

        primaryStage.setTitle("ImageView Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
