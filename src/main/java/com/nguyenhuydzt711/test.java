package com.nguyenhuydzt711;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Pagination;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class test extends Application {
        private Image[] imageURLs = {
            new Image("file:src/main/java/com/nguyenhuydzt711/pagination_img/download.jfif"),
            new Image("file:src/main/java/com/nguyenhuydzt711/pagination_img/download (1).jfif"),
            new Image("file:src/main/java/com/nguyenhuydzt711/pagination_img/download (2).jfif"),
            new Image("file:src/main/java/com/nguyenhuydzt711/pagination_img/geforce-rtx-5090-learn-more-og-1200x630.jpg"),
            new Image("file:src/main/java/com/nguyenhuydzt711/pagination_img/lightning-20260101-1.jpg")
    };

    @Override
    public void start(Stage primaryStage) throws Exception {

        Pagination pagination = new Pagination(imageURLs.length, 0);
        pagination.setPageFactory(
            pageIndex -> new ImageView(imageURLs[pageIndex])
        );

        VBox vbox = new VBox( pagination );

        Scene scene = new Scene(vbox);

        primaryStage.setScene( scene );
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
