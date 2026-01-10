package com.nguyenhuydzt711;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class pagination extends Application {
    private Image[] imageURLs = {
            new Image("file:src/main/java/com/nguyenhuydzt711/pagination_img/download.jfif"),
            new Image("file:src/main/java/com/nguyenhuydzt711/pagination_img/download (1).jfif"),
            new Image("file:src/main/java/com/nguyenhuydzt711/pagination_img/download (2).jfif"),
            new Image("file:src/main/java/com/nguyenhuydzt711/pagination_img/geforce-rtx-5090-learn-more-og-1200x630.jpg"),
            new Image("file:src/main/java/com/nguyenhuydzt711/pagination_img/lightning-20260101-1.jpg")
    };

    @Override
    public void start(javafx.stage.Stage primaryStage) throws Exception {
        javafx.scene.control.Pagination pagination = new javafx.scene.control.Pagination(imageURLs.length, 0);
        pagination.setPageFactory(
                pageIndex -> {
                    ImageView imageView = new ImageView(imageURLs[pageIndex]);
                    imageView.setFitWidth(600);
                    imageView.setFitHeight(400);
                    imageView.setPreserveRatio(true);
                    return imageView;
                });

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(5), event -> {
                    int nextPage = (pagination.getCurrentPageIndex() + 1) % imageURLs.length;
                    pagination.setCurrentPageIndex(nextPage);
                }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        VBox vbox = new VBox(pagination);
        vbox.setStyle("-fx-alignment: center;");
        javafx.scene.Scene scene = new javafx.scene.Scene(vbox, 800, 600);

        primaryStage.setTitle("Pagination Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
