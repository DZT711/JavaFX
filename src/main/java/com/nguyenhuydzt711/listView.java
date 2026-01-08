package com.nguyenhuydzt711;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class listView extends Application {

    static class Player {
        private final String name;
        private final String team;

        Player(String name, String team) {
            this.name = name;
            this.team = team;
        }

        public String getName() {
            return name;

        }

        public String getTeam() {
            return team;
        }

        @Override
        public String toString() {
            return name + " - " + team;
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Player[] players = {
                new Player("Lionel Messi", "Inter Miami"),
                new Player("Cristiano Ronaldo", "Al-Nassr"),
                new Player("Sadio Mane", "Al-Nassr"),
                new Player("Neymar Jr.", "Santos FC"),
                new Player("Kylian Mbappe", "Real Madrid"),
                new Player("Thibaut Courtois", "Real Madrid"),
                new Player("Kevin De Bruyne", "Napoli")
        };
        ReadOnlyObjectProperty<ObservableList<Player>> PlayersProperty = new SimpleObjectProperty<>(
                FXCollections.observableArrayList(players));
        ReadOnlyObjectProperty<FilteredList<Player>> viewablePlayersProperty = new SimpleObjectProperty<FilteredList<Player>>(
                new FilteredList<>(PlayersProperty.get()));
        ObjectProperty<Predicate<? super Player>> playerFilterProperty = viewablePlayersProperty.get()
                .predicateProperty();

        VBox box = new VBox();
        box.setPadding(new Insets(10));
        box.setSpacing(4);

        HBox hbox = new HBox();
        hbox.setSpacing(2);
        ToggleGroup filterTG = new ToggleGroup();

        @SuppressWarnings("unchecked")
        EventHandler<ActionEvent> toggleHandler = (evt) -> {
            ToggleButton rb = (ToggleButton) evt.getSource();
            Predicate<Player> filter = (Predicate<Player>) rb.getUserData();
            playerFilterProperty.set(filter);
        };
        ToggleButton allBtn = new ToggleButton("Show All");
        allBtn.setSelected(true);
        allBtn.setToggleGroup(filterTG);
        allBtn.setOnAction(toggleHandler);
        allBtn.setUserData((Predicate<Player>) (Player p) -> true);

        List<ToggleButton> tbs = Arrays.asList(players).stream().map((p) -> p.getTeam()).distinct().map(team -> {
            ToggleButton tb = new ToggleButton(team);
            tb.setToggleGroup(filterTG);
            tb.setOnAction(toggleHandler);
            tb.setUserData((Predicate<Player>) (Player p) -> p.getTeam().equals(team));
            return tb;
        }).collect(Collectors.toList());
        hbox.getChildren().addAll(allBtn);
        hbox.getChildren().addAll(tbs);

        ListView<Player> lv = new ListView<>();
        lv.itemsProperty().bind(viewablePlayersProperty);
        box.getChildren().addAll(hbox, lv);
        Scene scene = new Scene(box);
        primaryStage.setTitle("ListView Example");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
