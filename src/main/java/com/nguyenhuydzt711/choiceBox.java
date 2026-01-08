package com.nguyenhuydzt711;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Pair;



public class choiceBox extends Application {

    private final ChoiceBox<Pair<String, String>> assetClass = new ChoiceBox<>();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label label = new Label("Asset Class:");
        assetClass.setPrefWidth(200);
        Button saveButton = new Button("Save");

        HBox hbox = new HBox(label, assetClass, saveButton);
        hbox.setSpacing(10.0d);
        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(40));

        Scene scene = new Scene(hbox);

        initChoice();

        saveButton.setOnAction((evt) -> System.out.println("saving " + assetClass.getValue()));

        primaryStage.setTitle("ChoiceBox Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }



    public void initChoice() {
        assetClass.getItems().addAll(
                new Pair<>("EQ", "Equity"),
                new Pair<>("FI", "Fixed Income"),
                new Pair<>("CO", "Commodities"),
                new Pair<>("FX", "Forex"));
        assetClass.setValue(assetClass.getItems().get(0));
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}
