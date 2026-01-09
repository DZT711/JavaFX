package com.nguyenhuydzt711;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class tableView extends Application {
    public class Item {
        private final String sku;
        private final String descr;
        private final Float price;
        private final Boolean taxable;

        public Item(String sku, String descr, Float price, Boolean taxable) {
            this.sku = sku;
            this.descr = descr;
            this.price = price;
            this.taxable = taxable;
        }

        public String getSku() {
            return sku;
        }

        public String getDescr() {
            return descr;
        }

        public Float getPrice() {
            return price;
        }

        public Boolean getTaxable() {
            return taxable;
        }

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        TableView<Item> tableView = new TableView<>();
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        VBox.setVgrow(tableView, Priority.ALWAYS);
        TableColumn<Item, String> skuCol = new TableColumn<>("SKU");
        TableColumn<Item, String> descrCol = new TableColumn<>("Description");
        TableColumn<Item, Float> priceCol = new TableColumn<>("Price");
        TableColumn<Item, Boolean> taxableCol = new TableColumn<>("Taxable");

        skuCol.setCellValueFactory(new PropertyValueFactory<>("sku"));
        descrCol.setCellValueFactory(new PropertyValueFactory<>("descr"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        taxableCol.setCellValueFactory(new PropertyValueFactory<>("taxable"));

        tableView.getColumns().addAll(skuCol, descrCol, priceCol, taxableCol);


        tableView.getItems().addAll(
                new Item("A101", "Toaster", 29.99f, true),
                new Item("B205", "Hair Dryer", 24.99f, true),
                new Item("C222", "Microwave Oven", 89.99f, true),
                new Item("D330", "Electric Blanket", 39.99f, false)
        );

        
        Button btnInventory = new Button("Inventory");
        Button btnCalcTax = new Button("Tax");
        btnInventory.disableProperty().bind(tableView.getSelectionModel().selectedItemProperty().isNull());
        btnCalcTax.disableProperty().bind(tableView.getSelectionModel().selectedItemProperty().isNull().or(
                Bindings.select(tableView.getSelectionModel().selectedItemProperty(), "taxable").isEqualTo(false)
        ));
        

        HBox buttonBox = new HBox(btnInventory, btnCalcTax);
        buttonBox.setSpacing(8);
        VBox vbox = new VBox(tableView, buttonBox);
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10));
        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.setTitle("TableView Example");
        primaryStage.show();
        primaryStage.setHeight(367);
        primaryStage.setWidth(667);

    }
    public static void main(String[] args) {
        launch(args);
    }
}
    