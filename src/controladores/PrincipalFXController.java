package controladores;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class PrincipalFXController implements Initializable {

    private Label label;
    @FXML
    private VBox boxLeft;
    @FXML
    private VBox boxDato;
    @FXML
    private ToggleGroup grupDato;
    @FXML
    private RadioButton radH1N1;
    @FXML
    private RadioButton radSIDA;
    @FXML
    private Label lblSelDato;
    @FXML
    private RadioButton radBarras;
    @FXML
    private ToggleGroup grupTipoGrafic;
    @FXML
    private RadioButton radLineas;
    @FXML
    private RadioButton radCircular;
    @FXML
    private Label lblSelGrafic;
    @FXML
    private Button btnMostrarGrafico;
    @FXML
    private BorderPane raiz;
    @FXML
    private RadioButton radSARS;
    @FXML
    private Pane panelMensaje;
    @FXML
    private Label lblMensaje;
    @FXML
    private Label lblTitulo;
    @FXML
    private Button btnLimpiar;

    private Stage stage;
    private Scene escena;
    private BorderPane aviso;
    private Graficos diagramas; // Todos los graficos en la clase Graficos

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            URL direccion = new File("src/formularios/VentanaAviso.fxml").toURI().toURL();
            aviso = FXMLLoader.load(direccion);
            escena = new Scene(aviso);
            stage = new Stage();
            TituloAnimacion(lblTitulo);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(escena);
        } catch (IOException error) {
            error.printStackTrace();
        }
        diagramas = new Graficos();
    }

    private void TituloAnimacion(Label label) {
        label.setText("G");
        Timeline tm = new Timeline();
        tm.getKeyFrames().add(
                new KeyFrame(Duration.millis(100), (ActionEvent actionEvent) -> {
                    switch (label.getText()) {
                        case "G":
                            label.setText("Gr");
                            break;
                        case "Gr":
                            label.setText("Gra");
                            break;
                        case "Gra":
                            label.setText("Graf");
                            break;
                        case "Graf":
                            label.setText("Grafi");
                            break;
                        case "Grafi":
                            label.setText("Grafic");
                            break;
                        case "Grafic":
                            label.setText("Grafico");
                            break;
                        case "Grafico":
                            label.setText("Graficos");
                            break;
                        case "Graficos":
                            label.setText("Graficos ");
                            break;
                        case "Graficos ":
                            label.setText("Graficos E");
                            break;
                        case "Graficos E":
                            label.setText("Graficos Es");
                            break;
                        case "Graficos Es":
                            label.setText("Graficos Est");
                            break;
                        case "Graficos Est":
                            label.setText("Graficos Esta");
                            break;
                        case "Graficos Esta":
                            label.setText("Graficos Estad");
                            break;
                        case "Graficos Estad":
                            label.setText("Graficos Estadi");
                            break;
                        case "Graficos Estadi":
                            label.setText("Graficos Estadis");
                            break;
                        case "Graficos Estadis":
                            label.setText("Graficos Estadist");
                            break;
                        case "Graficos Estadist":
                            label.setText("Graficos Estadisti");
                            break;
                        case "Graficos Estadisti":
                            label.setText("Graficos Estadistic");
                            break;
                        case "Graficos Estadistic":
                            label.setText("Graficos Estadistico");
                            break;
                        case "Graficos Estadistico":
                            label.setText("Graficos Estadisticos");
                            break;
                        default:
                            break;
                    }
                }));
        tm.setCycleCount(100);
        tm.play();
    }

    private void setGraficos(Node nodo) {
        raiz.setCenter(nodo);
        FadeTransition ft = new FadeTransition(Duration.millis(1500));
        ft.setNode(nodo);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }

    private void setTitulo(String op1, String op2) {

        lblTitulo.setText(String.format("%s - %s", op1, op2));

    }

    @FXML
    private void Mostrar(ActionEvent event) {

        if (radH1N1.isSelected() && radBarras.isSelected()) {

            setGraficos((Node) diagramas.BarrasPorcina());
            setTitulo(radH1N1.getText(), radBarras.getText());

        } else if (radH1N1.isSelected() && radCircular.isSelected()) {

            setGraficos((Node) diagramas.CirculoPorcinaMuertos());
            diagramas.getBotonSiguiente().setOnAction(evento -> setGraficos(diagramas.CirculoPorcinaInfectados()));
            diagramas.getBotonAtras().setOnAction(evento -> setGraficos(diagramas.CirculoPorcinaMuertos()));
            setTitulo(radH1N1.getText(), radCircular.getText());

        } else if (radH1N1.isSelected() && radLineas.isSelected()) {

            setGraficos((Node) diagramas.LineasPorcina());
            setTitulo(radH1N1.getText(), radLineas.getText());

        } else if (radSIDA.isSelected() && radBarras.isSelected()) {

            setGraficos((Node) diagramas.BarrasSida());
            setTitulo(radSIDA.getText(), radBarras.getText());

        } else if (radSIDA.isSelected() && radCircular.isSelected()) {

            setGraficos((Node) diagramas.CirculoSida());
            setTitulo(radSIDA.getText(), radCircular.getText());

        } else if (radSIDA.isSelected() && radLineas.isSelected()) {

            setGraficos((Node) diagramas.LineasSida());
            setTitulo(radSIDA.getText(), radLineas.getText());

        } else if (radSARS.isSelected() && radBarras.isSelected()) {

            setGraficos((Node) diagramas.BarrasSARS());
            setTitulo(radSARS.getText(), radBarras.getText());

        } else if (radSARS.isSelected() && radCircular.isSelected()) {

            setGraficos((Node) diagramas.CirculoSARSInfectados());
            diagramas.getBotonSiguiente().setOnAction(evento -> setGraficos(diagramas.CirculoSARSMuertos()));
            diagramas.getBotonAtras().setOnAction(evento -> setGraficos(diagramas.CirculoSARSInfectados()));
            setTitulo(radSARS.getText(), radCircular.getText());

        } else if (radSARS.isSelected() && radLineas.isSelected()) {

            setGraficos((Node) diagramas.LineasSARS());
            setTitulo(radSARS.getText(), radLineas.getText());

        } else {

            stage.centerOnScreen();
            stage.show();
        }

    }

    @FXML
    private void Limpiar(ActionEvent event) {
        setGraficos((Node) panelMensaje);
        TituloAnimacion(lblTitulo);
        radBarras.setSelected(false);
        radLineas.setSelected(false);
        radCircular.setSelected(false);
        radH1N1.setSelected(false);
        radSARS.setSelected(false);
        radSIDA.setSelected(false);
    }

}
