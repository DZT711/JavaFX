package com.nguyenhuydzt711;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class VBoxHBox extends Application {
    public class Customer {

        private String firstName;
        private String lastName;

        public Customer(String firstName,
                String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }

    private void loadTable(TableView<Customer> tblCustomers) {
        tblCustomers.getItems().add(new Customer("George", "Washington"));
        tblCustomers.getItems().add(new Customer("Abe", "Lincoln"));
        tblCustomers.getItems().add(new Customer("Thomas", "Jefferson"));
    }

    @Override
    public void start(javafx.stage.Stage primaryStage) throws Exception {
        VBox vbox = new VBox();
        HBox topControls = new HBox();
        VBox.setMargin(topControls, new Insets(10.0d));
        topControls.setAlignment(Pos.BOTTOM_LEFT);
        Button btnRefresh = new Button("Refresh");
        topControls.getChildren().add(btnRefresh);
        HBox topRightControls = new HBox();
        HBox.setHgrow(topRightControls, Priority.ALWAYS);
        topRightControls.setAlignment(Pos.BOTTOM_RIGHT);
        Hyperlink signOutLink = new Hyperlink("Sign Out");
        topRightControls.getChildren().add(signOutLink);
        topControls.getChildren().add(topRightControls);
        TableView<Customer> tableView = new TableView<>();
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        VBox.setVgrow(tableView, Priority.ALWAYS);
        VBox.setMargin(tableView, new Insets(0.0d, 10.0d, 10.0d, 10.0d));
        TableColumn<Customer, String> firstNameCol = new TableColumn<>("First Name");
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        TableColumn<Customer, String> lastNameCol = new TableColumn<>("LastName");
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tableView.getColumns().addAll(firstNameCol, lastNameCol);
        Separator separator = new Separator();
        HBox bottomControls = new HBox();
        bottomControls.setAlignment(Pos.BOTTOM_RIGHT);
        VBox.setMargin(bottomControls, new Insets(10.0d));
        Button btnClose = new Button("Close");
        bottomControls.getChildren().add(btnClose);
        vbox.getChildren().addAll(topControls, tableView, separator, bottomControls);
        javafx.scene.Scene scene = new javafx.scene.Scene(vbox);
        primaryStage.setTitle("VBox and HBox Example");
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        primaryStage.setOnShown((evt) -> loadTable(tableView));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
