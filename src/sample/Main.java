package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {

    Stage window;
    File copyDeck;
    FileChooser fileChooser = new FileChooser();

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("AMPgen");

        BorderPane mainLayout = new BorderPane();
        HBox source = new HBox();
        fillHbox(source);








        mainLayout.setTop(source);

        Scene scene = new Scene(mainLayout, 600, 400);
        window.setScene(scene);
        window.show();
    }

    private void fillHbox(HBox source) {
        Label copydeckSource = new Label("source: ");
        source.getChildren().add(copydeckSource);


        TextField path = new TextField();
        if (copyDeck != null) {
            path.setText(copyDeck.getPath());
        }
        source.getChildren().add(path);



        Button chooseFile = new Button("open");
        chooseFile.setOnAction(event -> {
            copyDeck = fileChooser.showOpenDialog(window);
            path.setText(copyDeck.getPath());
        });
        source.getChildren().add(chooseFile);

    }



    public static void main(String[] args) {
        launch(args);
    }
}

