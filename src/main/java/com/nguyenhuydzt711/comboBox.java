package com.nguyenhuydzt711;

import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Pair;

public class comboBox extends Application {

    private final ComboBox<Pair<String, String>> account = new ComboBox<>();
    private final static Pair<String, String> EMPTY_PAIR = new Pair<>("", "");

    public void initCombo() {
        List<Pair<String, String>> accounts = new java.util.ArrayList<>();
        accounts.add(new Pair<>("Auto Expense", "60000"));
        accounts.add(new Pair<>("Interest Expense", "61000"));
        accounts.add(new Pair<>("Office Expense", "62000"));
        accounts.add(new Pair<>("Salaries Expense", "63000"));
        account.getItems().addAll(accounts);
        account.getItems().add(EMPTY_PAIR);
        account.getSelectionModel().select(0);
        Callback<ListView<Pair<String, String>>, ListCell<Pair<String, String>>> cellFactory = (
                lv) -> new ListCell<Pair<String, String>>() {
                    @Override
                    protected void updateItem(Pair<String, String> item, boolean empty) {
                        super.updateItem(item, empty);
                        setText(empty ? "" : item.getKey());
                    }
                };
        account.setCellFactory(cellFactory);
        account.setButtonCell(cellFactory.call(null));
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label label = new Label("Asset Class:");
        account.setPrefWidth(200);
        Button saveButton = new Button("Save");

        HBox hbox = new HBox(label, account, saveButton);
        hbox.setSpacing(10.0d);
        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(40));

        Scene scene = new Scene(hbox);

        initCombo();

        saveButton.setOnAction((evt) -> {
            if (account.getValue().equals(EMPTY_PAIR)) {
                System.out.println("no save needed; no item selected");
            } else {
                System.out.println("saving " + account.getValue());
            }
        });

        primaryStage.setTitle("ComboBox Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}