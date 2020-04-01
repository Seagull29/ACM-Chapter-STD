package javafxapplication8;

import java.io.File;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author selitzia
 */
public class Main extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        URL direccion = new File("src/formularios/ventanapreloader.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(direccion);
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.getIcons().add(new Image("formularios/cruz.png"));
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
