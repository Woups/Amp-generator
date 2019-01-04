package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class WarningWindow {

    static boolean answer;

    public static void display(String title, String message) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        Label messageToShow = new Label(message);

        Button yesButton = new Button("OK");

        yesButton.setOnAction(event -> {
            answer = true;
            window.close();
        });


        VBox layout = new VBox();
        HBox options = new HBox();

        layout.setPadding(new Insets(5,5,5,5));
        layout.setAlignment(Pos.CENTER);
        options.setAlignment(Pos.CENTER);
        options.setSpacing(5);

        options.getChildren().addAll(yesButton);

        layout.getChildren().addAll(messageToShow,options);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}
