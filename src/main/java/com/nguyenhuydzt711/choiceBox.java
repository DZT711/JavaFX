package com.nguyenhuydzt711;

import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Pair;



public class choiceBox extends Application {

    private final ChoiceBox<Pair<String, String>> assetClass = new ChoiceBox<>();
    private final static Pair<String, String> EMPTY_PAIR = new Pair<>("", "");

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
        List<Pair<String,String>> classes = new java.util.ArrayList<>();
        classes.add(new Pair<>("Equiment", "20000")); 
        classes.add(new Pair<>("Furniture", "21000")); 
        classes.add(new Pair<>("Investment", "22000")); 
        assetClass.setConverter(new javafx.util.StringConverter<Pair<String, String>>() {
            @Override
            public String toString(Pair<String, String> object) {
                return object == null ? "" : object.getKey();
            }

            @Override
            public Pair<String, String> fromString(String string) {
                return null; // Not needed
            }
        });
        assetClass.getItems().add(EMPTY_PAIR);
        assetClass.getItems().addAll(classes);
        assetClass.setValue(EMPTY_PAIR);
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}
