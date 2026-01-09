package com.nguyenhuydzt711;

import javafx.application.Application;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class lineChart extends Application {
    @Override
    public void start(javafx.stage.Stage primaryStage) throws Exception {
        XYChart.Series<Double, Double> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>(0.0, 0.0));
        series.getData().add(new XYChart.Data<>(1.0, 3.0));
        series.getData().add(new XYChart.Data<>(2.0, 4.0));
        series.getData().add(new XYChart.Data<>(3.0, 2.0));
        series.getData().add(new XYChart.Data<>(4.0, 3.75));
        series.getData().add(new XYChart.Data<>(5.0, 4.0));
        series.getData().add(new XYChart.Data<>(6.0, 4.75));
        series.getData().add(new XYChart.Data<>(7.0, 4.5));
        series.getData().add(new XYChart.Data<>(8.0, 8.95));
        series.getData().add(new XYChart.Data<>(9.0, 7.25));
        series.getData().add(new XYChart.Data<>(10.0, 10.0));
        LineChart lc = new LineChart(
            new NumberAxis("Time", 0.0, 10.0, 1.0),
            new NumberAxis("Value", 0.0, 10.0, 1.0)
        );
        lc.getData().add(series);
        lc.setTitle("ABC company's stock price");
        lc.setStyle("-fx-background-color: BEIGE;");
        lc.setCreateSymbols(false);
        lc.setLegendVisible(false);
        javafx.scene.layout.StackPane root = new javafx.scene.layout.StackPane(lc);
        javafx.scene.Scene scene = new javafx.scene.Scene(root, 600, 400);
        primaryStage.setTitle("LineChart Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
