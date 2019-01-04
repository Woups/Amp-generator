package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.regex.Pattern;

public class Main extends Application {

    Stage window;
    File copyDeck;
    FileChooser fileChooser = new FileChooser();
    Button generate = new Button("Generate");

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("AMPgen");

        BorderPane mainLayout = new BorderPane();


        HBox source = new HBox();
        fillHbox(source);
        source.setAlignment(Pos.CENTER);

        VBox setup = new VBox();
        fillSetup(setup);

        mainLayout.setTop(source);
        mainLayout.setLeft(setup);


        Scene scene = new Scene(mainLayout, 600, 400);
        window.setScene(scene);
        window.show();
    }

    private void fillSetup(VBox setup) {
        //TODO FillSetup Ask Nick what to put there
        HBox chooseColumn = new HBox();
        Label column = new Label("Column");
        TextField columnPicker = new TextField();
        chooseColumn.getChildren().addAll(column, columnPicker);

        generate.setDisable(true);

        generate.setOnAction(actionEvent -> generateAMPFile(copyDeck));

        setup.getChildren().addAll(chooseColumn, generate);

    }

    private void generateAMPFile(File copyDeck) {
    }

    private void fillHbox(HBox source) {
        Label copyDeckSource = new Label("source: ");

        TextField path = new TextField();
        if (copyDeck != null) {
            path.setText(copyDeck.getPath());
        }
        path.setPrefWidth(300);

        Button chooseFile = new Button("open");
        chooseFile.setOnAction(event -> {
            copyDeck = fileChooser.showOpenDialog(window);
            if (copyDeck != null) {
                String fileName = copyDeck.getName();
                if (!Pattern.matches("^\\w+\\.xlsx$" , fileName.trim())){
                    WarningWindow.display("incorrect format", "This file format is not possible to use\n please use .xlsx");
                    copyDeck = null;
                    generate.setDisable(true);
                }
                else{
                    path.setText(copyDeck.getPath());
                    generate.setDisable(false);
                }
            }
        });


        source.getChildren().addAll(copyDeckSource, path, chooseFile);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
