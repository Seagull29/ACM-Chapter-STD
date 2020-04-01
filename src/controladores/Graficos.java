package controladores;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.util.Duration;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.text.TextAlignment;

public class Graficos implements GenerarGraficos {

    private Node nodo;
    private BarChart<String, Number> bcBarras;
    private LineChart<String, Number> lcLineas;
    private final CategoryAxis ejeX = new CategoryAxis();
    private final NumberAxis ejeY = new NumberAxis();

    private final Button btnSiguiente = new Button("Siguiente");
    private final Button btnAtras = new Button("Atras");

    public Graficos() {
    }

    public Button getBotonSiguiente() {
        btnSiguiente.setAlignment(Pos.CENTER);
        btnSiguiente.setTextAlignment(TextAlignment.CENTER);
        btnSiguiente.setMinSize(100, 50);
        btnSiguiente.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        return btnSiguiente;
    }

    public Button getBotonAtras() {
        btnAtras.setAlignment(Pos.CENTER);
        btnAtras.setTextAlignment(TextAlignment.CENTER);
        btnAtras.setMinSize(100, 50);
        btnAtras.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        return btnAtras;
    }

    @Override
    public Node BarrasPorcina() {
        ejeY.setLabel("Cantidad de personas");
        long[] muertos = {220, 713, 2352, 6821, 14716};
        long[] infectados = {37065, 155710, 386804, 655810, 1236301};
        long[] contador = {0, 0, 0, 0, 0};
        long[] contador0 = {0, 0, 0, 0, 0};
        XYChart.Series<String, Number> muertosC = new XYChart.Series<>();
        muertosC.setName("Muertos");
        muertosC.getData().addAll(new XYChart.Data<>("Mayo", muertos[0]),
                new XYChart.Data<>("Junio", muertos[1]),
                new XYChart.Data<>("Julio", muertos[2]),
                new XYChart.Data<>("Agosto", muertos[3]),
                new XYChart.Data<>("Septiembre", muertos[4]));

        XYChart.Series<String, Number> infectadosC = new XYChart.Series<>();
        infectadosC.setName("Infectados");
        infectadosC.getData().addAll(new XYChart.Data<>("Mayo", infectados[0]),
                new XYChart.Data<>("Junio", infectados[1]),
                new XYChart.Data<>("Julio", infectados[2]),
                new XYChart.Data<>("Agosto", infectados[3]),
                new XYChart.Data<>("Septiembre", infectados[4]));

        ObservableList<XYChart.Series<String, Number>> datos = FXCollections.observableArrayList();
        datos.addAll(infectadosC, muertosC);
        bcBarras = new BarChart(ejeX, ejeY, datos);
        bcBarras.setAnimated(false);
        bcBarras.setTitle("Cantidad de infectados y muertos por la gripe porcina \"H1N1\"\n en el año 2009");
        bcBarras.setMinSize(700, 600);
        //Animacion de Barra de Muertos
        Timeline tm = new Timeline();
        tm.getKeyFrames().add(
                new KeyFrame(Duration.millis(10), (ActionEvent actionEvent) -> {
                    if (contador0[0] <= muertos[0]) {
                        contador0[0] = contador0[0] + (int)(Math.random() * 10)+1;
                        muertosC.getData().set(0, new XYChart.Data("Mayo", contador0[0]));
                    }
                    if (contador0[1] <= muertos[1]) {
                        contador0[1] = contador0[1] + (int)(Math.random() * 10)+1;
                        muertosC.getData().set(1, new XYChart.Data("Junio", contador0[1]));
                    }
                    if (contador0[2] <= muertos[2]) {
                        contador0[2] = contador0[2] + (int)(Math.random() * 10)+1;
                        muertosC.getData().set(2, new XYChart.Data("Julio", contador0[2]));
                    }
                    if (contador0[3] <= muertos[3]) {
                        contador0[3] = contador0[3] + (int)(Math.random() * 10)+1;
                        muertosC.getData().set(3, new XYChart.Data("Agosto", contador0[3]));
                    }

                    if (contador0[4] <= muertos[4]) {
                        contador0[4] = contador0[4] + (int)(Math.random() * 10)+1;
                        muertosC.getData().set(4, new XYChart.Data("Septiembre", contador0[4]));
                    }

                }));
        tm.setCycleCount(1000);
        tm.play();
        //Animacion de Barra de infectados
        Timeline tl = new Timeline();
        tl.getKeyFrames().add(
                new KeyFrame(Duration.millis(10), (ActionEvent actionEvent) -> {
                    if (contador[0] <= infectados[0]) {
                        contador[0] = contador[0] + (int)(Math.random() * 1000)+100;
                        infectadosC.getData().set(0, new XYChart.Data("Mayo", contador[0]));
                    }
                    if (contador[1] <= infectados[1]) {
                        contador[1] = contador[1] + (int)(Math.random() * 1000)+100;
                        infectadosC.getData().set(1, new XYChart.Data("Junio", contador[1]));
                    }
                    if (contador[2] <= infectados[2]) {
                        contador[2] = contador[2] + (int)(Math.random() * 1000)+100;
                        infectadosC.getData().set(2, new XYChart.Data("Julio", contador[2]));
                    }
                    if (contador[3] <= infectados[3]) {
                        contador[3] = contador[3] + (int)(Math.random() * 1000)+100;
                        infectadosC.getData().set(3, new XYChart.Data("Agosto", contador[3]));
                    }
                    if (contador[4] <= infectados[4]) {
                        contador[4] = contador[4] + (int)(Math.random() * 1000)+100;
                        infectadosC.getData().set(4, new XYChart.Data("Septiembre", contador[4]));
                    }

                }));
        tl.setCycleCount(10000);
        tl.play();
        nodo = new Group(bcBarras);

        return nodo;
    }

    @Override
    public Node BarrasSida() {
        int[] Casos = {1201, 1273, 1267, 1697, 1938, 2252, 1780, 1726, 1928, 1446, 1443};
        int[] contador = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        XYChart.Series<String, Number> casos = new XYChart.Series<>();
        casos.setName("Casos");
        casos.getData().addAll(new XYChart.Data<>("2000", Casos[0]),
                new XYChart.Data<>("2001", Casos[1]),
                new XYChart.Data<>("2002", Casos[2]),
                new XYChart.Data<>("2003", Casos[3]),
                new XYChart.Data<>("2004", Casos[4]),
                new XYChart.Data<>("2005", Casos[5]),
                new XYChart.Data<>("2006", Casos[6]),
                new XYChart.Data<>("2007", Casos[7]),
                new XYChart.Data<>("2008", Casos[8]),
                new XYChart.Data<>("2009", Casos[9]),
                new XYChart.Data<>("2010", Casos[10]));

        ObservableList<XYChart.Series<String, Number>> datos = FXCollections.observableArrayList();
        datos.add(casos);

        ejeY.setLabel("Cantidad de personas");
        bcBarras = new BarChart(ejeX, ejeY, datos, 5);
        bcBarras.setTitle("Cantidad de casos de sida en la primera decada - Peru");
        bcBarras.setAnimated(false);
        bcBarras.setMinSize(700, 600);
        //Animacion de Barras
        Timeline tl = new Timeline();
        tl.getKeyFrames().add(
                new KeyFrame(Duration.millis(30), (ActionEvent actionEvent) -> {

                    if (contador[0] <= Casos[0]) {
                        contador[0] = contador[0] + (int)(Math.random() * 10)+1;
                        casos.getData().set(0, new XYChart.Data("2000", contador[0]));
                    }
                    if (contador[1] <= Casos[1]) {
                        contador[1] = contador[1] + (int)(Math.random() * 10)+1;
                        casos.getData().set(1, new XYChart.Data("2001", contador[1]));
                    }
                    if (contador[2] <= Casos[2]) {
                        contador[2] = contador[2] + (int)(Math.random() * 10)+1;
                        casos.getData().set(2, new XYChart.Data("2002", contador[2]));
                    }
                    if (contador[3] <= Casos[3]) {
                        contador[3] = contador[3] + (int)(Math.random() * 10)+1;
                        casos.getData().set(3, new XYChart.Data("2003", contador[3]));
                    }
                    if (contador[4] <= Casos[4]) {
                        contador[4] = contador[4] + (int)(Math.random() * 10)+1;
                        casos.getData().set(4, new XYChart.Data("2004", contador[4]));
                    }
                    if (contador[5] <= Casos[5]) {
                        contador[5] = contador[5] + (int)(Math.random() * 10)+1;
                        casos.getData().set(5, new XYChart.Data("2005", contador[5]));
                    }
                    if (contador[6] <= Casos[6]) {
                        contador[6] = contador[6] + (int)(Math.random() * 10)+1;
                        casos.getData().set(6, new XYChart.Data("2006", contador[6]));
                    }
                    if (contador[7] <= Casos[7]) {
                        contador[7] = contador[7] + (int)(Math.random() * 10)+1;
                        casos.getData().set(7, new XYChart.Data("2007", contador[7]));
                    }
                    if (contador[8] <= Casos[8]) {
                        contador[8] = contador[8] + (int)(Math.random() * 10)+1;
                        casos.getData().set(8, new XYChart.Data("2008", contador[8]));
                    }
                    if (contador[9] <= Casos[9]) {
                        contador[9] = contador[9] + (int)(Math.random() * 10)+1;
                        casos.getData().set(9, new XYChart.Data("2009", contador[9]));
                    }
                    if (contador[10] <= Casos[10]) {
                        contador[10] = contador[10] + (int)(Math.random() * 10)+1;
                        casos.getData().set(10, new XYChart.Data("2010", contador[10]));
                    }

                }));
        tl.setCycleCount(10000);
        tl.play();
        nodo = new Group(bcBarras);

        return nodo;
    }

    @Override
    public Node BarrasSARS() {
        int[] Casos = {250, 5327, 1755, 307, 71};
        int[] Muertos = {38, 348, 297, 47, 0};
        int[] Contador = {0, 0, 0, 0, 0};
        int[] Contador1 = {0, 0, 0, 0, 0};
        XYChart.Series<String, Number> casos = new XYChart.Series<>();
        casos.setName("Casos");
        casos.getData().addAll(new XYChart.Data<>("Canada", 250),
                new XYChart.Data<>("China", 5327),
                new XYChart.Data<>("Hong Kong", 1755),
                new XYChart.Data<>("Taiwan", 307),
                new XYChart.Data<>("EE.UU", 71));

        XYChart.Series<String, Number> muertos = new XYChart.Series<>();
        muertos.setName("Muertos");
        muertos.getData().addAll(new XYChart.Data<>("Canada", 38),
                new XYChart.Data<>("China", 348),
                new XYChart.Data<>("Hong Kong", 297),
                new XYChart.Data<>("Taiwan", 47),
                new XYChart.Data<>("EE.UU", 0));

        ObservableList<XYChart.Series<String, Number>> datos = FXCollections.observableArrayList();
        datos.addAll(casos, muertos);

        ejeY.setLabel("Cantidad de personas");
        bcBarras = new BarChart(ejeX, ejeY, datos, 5);
        bcBarras.setTitle("Muertos e infectados por el SARS el 11 de Julio del 2003");
        bcBarras.setAnimated(false);
        bcBarras.setMinSize(700, 600);
        //Animacion de Barras
        Timeline tl = new Timeline();
        tl.getKeyFrames().add(
                new KeyFrame(Duration.millis(10), (ActionEvent actionEvent) -> {
                    //CASOS
                    if (Contador[0] < Casos[0]) {
                        Contador[0] = Contador[0] + (int)(Math.random() * 10)+1;
                        casos.getData().set(0, new XYChart.Data("Canada", Contador[0]));
                    }
                    if (Contador[1] < Casos[1]) {
                        Contador[1] = Contador[1] + (int)(Math.random() * 10)+1;
                        casos.getData().set(1, new XYChart.Data("China", Contador[1]));
                    }
                    if (Contador[2] < Casos[2]) {
                        Contador[2] = Contador[2] + (int)(Math.random() * 10)+1;
                        casos.getData().set(2, new XYChart.Data("Hong Kong", Contador[2]));
                    }
                    if (Contador[3] < Casos[3]) {
                        Contador[3] = Contador[3] + (int)(Math.random() * 10)+1;
                        casos.getData().set(3, new XYChart.Data("Taiwan", Contador[3]));
                    }
                    if (Contador[4] < Casos[4]) {
                        Contador[4] = Contador[4] + (int)(Math.random() * 10)+1;
                        casos.getData().set(4, new XYChart.Data("EE.UU", Contador[4]));
                    }
                    //MUERTES
                    if (Contador1[0] < Muertos[0]) {
                        Contador1[0] = Contador1[0] + (int)(Math.random() * 10)+1;
                        muertos.getData().set(0, new XYChart.Data("Canada", Contador1[0]));
                    }
                    if (Contador1[1] < Muertos[1]) {
                        Contador1[1] = Contador1[1] + (int)(Math.random() * 10)+1;
                        muertos.getData().set(1, new XYChart.Data("China", Contador1[1]));
                    }
                    if (Contador1[2] < Muertos[2]) {
                        Contador1[2] = Contador1[2] + (int)(Math.random() * 10)+1;
                        muertos.getData().set(2, new XYChart.Data("Hong Kong", Contador1[2]));
                    }
                    if (Contador1[3] < Muertos[3]) {
                        Contador1[3] = Contador1[3] + (int)(Math.random() * 10)+1;
                        muertos.getData().set(3, new XYChart.Data("Taiwan", Contador1[3]));
                    }
                    if (Contador1[4] < Muertos[4]) {
                        Contador1[4] = Contador1[4] + (int)(Math.random() * 10)+1;
                        muertos.getData().set(4, new XYChart.Data("EE.UU", Contador1[4]));
                    }
                }));
        tl.setCycleCount(500);
        tl.play();
        nodo = new Group(bcBarras);

        return nodo;
    }

    @Override
    public Node LineasPorcina() {
        long[] muertos = {220, 713, 2352, 6821, 14716};
        long[] infectados = {37065, 155710, 386804, 655810, 1236301};
        long[] contador = {0, 0, 0, 0, 0};
        long[] contador0 = {0, 0, 0, 0, 0};

        XYChart.Series<String, Number> infectadosC = new XYChart.Series<>();
        infectadosC.setName("Muertos");
        infectadosC.getData().addAll(new XYChart.Data<>("Mayo", infectados[0]),
                new XYChart.Data<>("Junio", infectados[1]),
                new XYChart.Data<>("Julio", infectados[2]),
                new XYChart.Data<>("Agosto", infectados[3]),
                new XYChart.Data<>("Septiembre", infectados[4]));

        XYChart.Series<String, Number> muertosC = new XYChart.Series<>();
        muertosC.setName("Infectados");
        muertosC.getData().addAll(new XYChart.Data<>("Mayo", muertos[0]),
                new XYChart.Data<>("Junio", muertos[1]),
                new XYChart.Data<>("Julio", muertos[2]),
                new XYChart.Data<>("Agosto", muertos[3]),
                new XYChart.Data<>("Septiembre", muertos[4]));

        ObservableList<XYChart.Series<String, Number>> datos = FXCollections.observableArrayList();
        datos.addAll(infectadosC, muertosC);

        ejeY.setLabel("Cantidad de personas");
//        ejeX.setLabel("Personas infectadas");
        lcLineas = new LineChart(ejeX, ejeY, datos);
        lcLineas.setAnimated(false);
        lcLineas.setMinSize(700, 600);
        lcLineas.setTitle("Cantidad de infectados y muertos por la gripe porcina \"H1N1\"\n en el año 2009");
        Timeline tl = new Timeline();
        tl.getKeyFrames().add(
                new KeyFrame(Duration.millis(10), (ActionEvent actionEvent) -> {
                    //CASOS
                    if (contador[0] <= infectados[0]) {
                        contador[0] = contador[0] + 1000;
                        infectadosC.getData().set(0, new XYChart.Data("Mayo", contador[0]));
                    }
                    if (contador[1] <= infectados[1]) {
                        contador[1] = contador[1] + 1000;
                        infectadosC.getData().set(1, new XYChart.Data("Junio", contador[1]));
                    }
                    if (contador[2] <= infectados[2]) {
                        contador[2] = contador[2] + 1000;
                        infectadosC.getData().set(2, new XYChart.Data("Julio", contador[2]));
                    }
                    if (contador[3] <= infectados[3]) {
                        contador[3] = contador[3] + 1000;
                        infectadosC.getData().set(3, new XYChart.Data("Agosto", contador[3]));
                    }
                    if (contador[4] <= infectados[4]) {
                        contador[4] = contador[4] + 1000;
                        infectadosC.getData().set(4, new XYChart.Data("Septiembre", contador[4]));
                    }
                    //MUERTOS
                    if (contador0[0] <= muertos[0]) {
                        contador0[0] = contador0[0] + 10;
                        muertosC.getData().set(0, new XYChart.Data("Mayo", contador0[0]));
                    }
                    if (contador0[1] <= muertos[1]) {
                        contador0[1] = contador0[1] + 10;
                        muertosC.getData().set(1, new XYChart.Data("Junio", contador0[1]));
                    }
                    if (contador0[2] <= muertos[2]) {
                        contador0[2] = contador0[2] + 10;
                        muertosC.getData().set(2, new XYChart.Data("Julio", contador0[2]));
                    }
                    if (contador0[3] <= muertos[3]) {
                        contador0[3] = contador0[3] + 10;
                        muertosC.getData().set(3, new XYChart.Data("Agosto", contador0[3]));
                    }

                    if (contador0[4] <= muertos[4]) {
                        contador0[4] = contador0[4] + 10;
                        muertosC.getData().set(4, new XYChart.Data("Septiembre", contador0[4]));
                    }
                }));
        tl.setCycleCount(10000);
        tl.play();
        nodo = new Group(lcLineas);

        return nodo;
    }

    @Override
    public Node LineasSida() {
        int[] Casos = {1201, 1273, 1267, 1697, 1938, 2252, 1780, 1726, 1928, 1446, 1443};
        int[] contador = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        XYChart.Series<String, Number> casos = new XYChart.Series<>();
        casos.setName("Casos");
        casos.getData().addAll(new XYChart.Data<>("2000", 1201),
                new XYChart.Data<>("2001", 1273),
                new XYChart.Data<>("2002", 1267),
                new XYChart.Data<>("2003", 1697),
                new XYChart.Data<>("2004", 1938),
                new XYChart.Data<>("2005", 2252),
                new XYChart.Data<>("2006", 1780),
                new XYChart.Data<>("2007", 1726),
                new XYChart.Data<>("2008", 1928),
                new XYChart.Data<>("2009", 1446),
                new XYChart.Data<>("2010", 1443));

        ObservableList<XYChart.Series<String, Number>> datos = FXCollections.observableArrayList();
        datos.add(casos);

        ejeY.setLabel("Cantidad de personas");
//        ejeX.setLabel("Casos de infeccion");
        lcLineas = new LineChart(ejeX, ejeY, datos);

        lcLineas.setTitle("Cantidad de casos de sida en la primera decada - Peru");
        lcLineas.setAnimated(false);
        lcLineas.setMinSize(700, 600);
        lcLineas.setMinSize(Control.USE_PREF_SIZE, Control.USE_PREF_SIZE);
        lcLineas.setPrefSize(700, 600);
        lcLineas.setMaxSize(Control.USE_PREF_SIZE, Control.USE_PREF_SIZE);
        
        Timeline tl = new Timeline();
        tl.getKeyFrames().add(
                new KeyFrame(Duration.millis(50), (ActionEvent actionEvent) -> {
                    if (contador[0] <= Casos[0]) {
                        contador[0] = contador[0] + (int)(Math.random() * 10)+1;
                        casos.getData().set(0, new XYChart.Data("2000", contador[0]));
                    }
                    if (contador[1] <= Casos[1]) {
                        contador[1] = contador[1] + (int)(Math.random() * 10)+1;
                        casos.getData().set(1, new XYChart.Data("2001", contador[1]));
                    }
                    if (contador[2] <= Casos[2]) {
                        contador[2] = contador[2] + (int)(Math.random() * 10)+1;
                        casos.getData().set(2, new XYChart.Data("2002", contador[2]));
                    }
                    if (contador[3] <= Casos[3]) {
                        contador[3] = contador[3] + (int)(Math.random() * 10)+1;
                        casos.getData().set(3, new XYChart.Data("2003", contador[3]));
                    }
                    if (contador[4] <= Casos[4]) {
                        contador[4] = contador[4] + (int)(Math.random() * 10)+1;
                        casos.getData().set(4, new XYChart.Data("2004", contador[4]));
                    }
                    if (contador[5] <= Casos[5]) {
                        contador[5] = contador[5] + (int)(Math.random() * 10)+1;
                        casos.getData().set(5, new XYChart.Data("2005", contador[5]));
                    }
                    if (contador[6] <= Casos[6]) {
                        contador[6] = contador[6] + (int)(Math.random() * 10)+1;
                        casos.getData().set(6, new XYChart.Data("2006", contador[6]));
                    }
                    if (contador[7] <= Casos[7]) {
                        contador[7] = contador[7] + (int)(Math.random() * 10)+1;
                        casos.getData().set(7, new XYChart.Data("2007", contador[7]));
                    }
                    if (contador[8] <= Casos[8]) {
                        contador[8] = contador[8] + (int)(Math.random() * 10)+1;
                        casos.getData().set(8, new XYChart.Data("2008", contador[8]));
                    }
                    if (contador[9] <= Casos[9]) {
                        contador[9] = contador[9] + (int)(Math.random() * 10)+1;
                        casos.getData().set(9, new XYChart.Data("2009", contador[9]));
                    }
                    if (contador[10] <= Casos[10]) {
                        contador[10] = contador[10] + (int)(Math.random() * 10)+1;
                        casos.getData().set(10, new XYChart.Data("2010", contador[10]));
                    }

                }));
        tl.setCycleCount(450);
        tl.play();

        nodo = new Group(lcLineas);

        return nodo;
    }

    @Override
    public Node LineasSARS() {
        int[] Casos = {250, 5327, 1755, 307, 71};
        int[] Muertos = {38, 348, 297, 47, 0};
        int[] Contador = {0, 0, 0, 0, 0};
        int[] Contador1 = {0, 0, 0, 0, 0};
        XYChart.Series<String, Number> casos = new XYChart.Series<>();
        casos.setName("Casos");
        casos.getData().addAll(new XYChart.Data<>("Canada", 250),
                new XYChart.Data<>("China", 5327),
                new XYChart.Data<>("Hong Kong", 1755),
                new XYChart.Data<>("Taiwan", 307),
                new XYChart.Data<>("EE.UU", 71));

        XYChart.Series<String, Number> muertos = new XYChart.Series<>();
        muertos.setName("Muertos");
        muertos.getData().addAll(new XYChart.Data<>("Canada", 38),
                new XYChart.Data<>("China", 348),
                new XYChart.Data<>("Hong Kong", 297),
                new XYChart.Data<>("Taiwan", 47),
                new XYChart.Data<>("EE.UU", 0));

        ObservableList<XYChart.Series<String, Number>> datos = FXCollections.observableArrayList();
        datos.addAll(casos, muertos);

        ejeY.setLabel("Cantidad de personas");
        lcLineas = new LineChart(ejeX, ejeY, datos);
        lcLineas.setTitle("Muertos e infectados por el SARS el 11 de Julio del 2003");
        lcLineas.setAnimated(false);
        lcLineas.setMinSize(700, 600);
        Timeline tl = new Timeline();
        tl.getKeyFrames().add(
                new KeyFrame(Duration.millis(10), (ActionEvent actionEvent) -> {
                    //CASOS
                    if (Contador[0] < Casos[0]) {
                        Contador[0] = Contador[0] + (int)(Math.random() * 10)+1;
                        casos.getData().set(0, new XYChart.Data("Canada", Contador[0]));
                    }
                    if (Contador[1] < Casos[1]) {
                        Contador[1] = Contador[1] + (int)(Math.random() * 10)+1;
                        casos.getData().set(1, new XYChart.Data("China", Contador[1]));
                    }
                    if (Contador[2] < Casos[2]) {
                        Contador[2] = Contador[2] + (int)(Math.random() * 10)+1;
                        casos.getData().set(2, new XYChart.Data("Hong Kong", Contador[2]));
                    }
                    if (Contador[3] < Casos[3]) {
                        Contador[3] = Contador[3] + (int)(Math.random() * 10)+1;
                        casos.getData().set(3, new XYChart.Data("Taiwan", Contador[3]));
                    }
                    if (Contador[4] < Casos[4]) {
                        Contador[4] = Contador[4] + (int)(Math.random() * 10)+1;
                        casos.getData().set(4, new XYChart.Data("EE.UU", Contador[4]));
                    }
                    //MUERTES
                    if (Contador1[0] < Muertos[0]) {
                        Contador1[0] = Contador1[0] + (int)(Math.random() * 10)+1;
                        muertos.getData().set(0, new XYChart.Data("Canada", Contador1[0]));
                    }
                    if (Contador1[1] < Muertos[1]) {
                        Contador1[1] = Contador1[1] + (int)(Math.random() * 10)+1;
                        muertos.getData().set(1, new XYChart.Data("China", Contador1[1]));
                    }
                    if (Contador1[2] < Muertos[2]) {
                        Contador1[2] = Contador1[2] + (int)(Math.random() * 10)+1;
                        muertos.getData().set(2, new XYChart.Data("Hong Kong", Contador1[2]));
                    }
                    if (Contador1[3] < Muertos[3]) {
                        Contador1[3] = Contador1[3] + (int)(Math.random() * 10)+1;
                        muertos.getData().set(3, new XYChart.Data("Taiwan", Contador1[3]));
                    }
                    if (Contador1[4] < Muertos[4]) {
                        Contador1[4] = Contador1[4] + (int)(Math.random() * 10)+1;
                        muertos.getData().set(4, new XYChart.Data("EE.UU", Contador1[4]));
                    }
                }));
        tl.setCycleCount(500);
        tl.play();
        
        nodo = new Group(lcLineas);

        return nodo;
    }

    @Override
    public Node CirculoPorcinaMuertos() {
        long[] muertos = {220, 713, 2352, 6821, 14716};
        long[] contador0 = {0, 0, 0, 0, 0};
        ObservableList<PieChart.Data> datosMuertos = FXCollections.observableArrayList();
        datosMuertos.addAll(new PieChart.Data("Mayo", contador0[0]),
                new PieChart.Data("Junio", contador0[1]),
                new PieChart.Data("Julio", contador0[2]),
                new PieChart.Data("Agosto", contador0[3]),
                new PieChart.Data("Septiembre", contador0[4]));

        PieChart pcMuertos = new PieChart(datosMuertos);
        pcMuertos.setTitle("Cantidad de muertos por gripe porcina \"H1N1\"\nen el año 2009");
        pcMuertos.setLegendSide(Side.LEFT);
        pcMuertos.setLabelLineLength(20);
        pcMuertos.setMinSize(700, 600);

        //Animacion de Pie de Muertos
        Timeline tm = new Timeline();
        tm.getKeyFrames().add(
                new KeyFrame(Duration.millis(7), (ActionEvent actionEvent) -> {
                    if (contador0[0] <= muertos[0]) {
                        contador0[0] = contador0[0] + 100;
                        datosMuertos.set(0, new PieChart.Data("Mayo", muertos[0]));
                    }
                    if (contador0[1] <= muertos[1]) {
                        contador0[1] = contador0[1] + 100;
                        datosMuertos.set(1, new PieChart.Data("Junio", muertos[1]));
                    }
                    if (contador0[2] <= muertos[2]) {
                        contador0[2] = contador0[2] + 100;
                        datosMuertos.set(2, new PieChart.Data("Julio", muertos[2]));
                    }
                    if (contador0[3] <= muertos[3]) {
                        contador0[3] = contador0[3] + 100;
                        datosMuertos.set(3, new PieChart.Data("Agosto", muertos[3]));
                    }

                    if (contador0[4] <= muertos[4]) {
                        contador0[4] = contador0[4] + 100;
                        datosMuertos.set(4, new PieChart.Data("Septiembre", muertos[4]));
                    }

                }));
        tm.setCycleCount(1000);
        tm.play();
        pcMuertos.getData().forEach(this::Mensaje);

        nodo = new HBox(10, pcMuertos, btnSiguiente);

        return nodo;
    }

    @Override
    public Node CirculoPorcinaInfectados() {
        long[] infectados = {37065, 155710, 386804, 655810, 1236301};
        long[] contador = {0, 0, 0, 0, 0};

        ObservableList<PieChart.Data> datosInfectados = FXCollections.observableArrayList();
        datosInfectados.addAll(new PieChart.Data("Mayo", contador[0]),
                new PieChart.Data("Junio", contador[1]),
                new PieChart.Data("Julio", contador[2]),
                new PieChart.Data("Agosto", contador[3]),
                new PieChart.Data("Septiembre", contador[4]));

        PieChart pcInfectados = new PieChart(datosInfectados);
        pcInfectados.setTitle("Cantidad de infectados por gripe porcina \"H1N1\"\nen el año 2009");
        pcInfectados.setLegendSide(Side.LEFT);
        pcInfectados.setLabelLineLength(20);
      
        pcInfectados.setMinSize(700, 600);

        Timeline tl = new Timeline();
        tl.getKeyFrames().add(
                new KeyFrame(Duration.millis(8), (ActionEvent actionEvent) -> {

                    if (contador[0] <= infectados[0]) {
                        contador[0] = contador[0] + 10000;
                        datosInfectados.set(0, new PieChart.Data("Mayo", infectados[0]));
                    }
                    if (contador[1] <= infectados[1]) {
                        contador[1] = contador[1] + 10000;
                        datosInfectados.set(1, new PieChart.Data("Junio", infectados[1]));
                    }
                    if (contador[2] <= infectados[2]) {
                        contador[2] = contador[2] + 10000;
                        datosInfectados.set(2, new PieChart.Data("Julio", infectados[2]));
                    }
                    if (contador[3] <= infectados[3]) {
                        contador[3] = contador[3] + 10000;
                        datosInfectados.set(3, new PieChart.Data("Agosto", infectados[3]));
                    }
                    if (contador[4] <= infectados[4]) {
                        contador[4] = contador[4] + 10000;
                        datosInfectados.set(4, new PieChart.Data("Septiembre", infectados[4]));
                    }
                }));
        tl.setCycleCount(10000);
        tl.play();
         pcInfectados.getData().forEach(this::Mensaje);

        nodo = new HBox(10, pcInfectados, btnAtras);

        return nodo;
    }

    @Override
    public Node CirculoSida() {
        int[] Casos = {1201, 1273, 1267, 1697, 1938, 2252, 1780, 1726, 1928, 1446, 1443};
        int[] contador = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        ObservableList<PieChart.Data> datos = FXCollections.observableArrayList();
        datos.addAll(new PieChart.Data("2000", contador[0]),
                new PieChart.Data("2001", contador[1]),
                new PieChart.Data("2002", contador[2]),
                new PieChart.Data("2003", contador[3]),
                new PieChart.Data("2004", contador[4]),
                new PieChart.Data("2005", contador[5]),
                new PieChart.Data("2006", contador[6]),
                new PieChart.Data("2007", contador[7]),
                new PieChart.Data("2008", contador[8]),
                new PieChart.Data("2009", contador[9]),
                new PieChart.Data("2010", contador[10]));

        PieChart pcCasos = new PieChart(datos);
        pcCasos.setTitle("Casos de Sida en el Peru en la decada de 2000 - 2010");
        pcCasos.setLegendSide(Side.LEFT);
        pcCasos.setLabelLineLength(20);
       
        pcCasos.setMinSize(700, 600);
        //Animacion de Barras
        Timeline tl = new Timeline();
        tl.getKeyFrames().add(
                new KeyFrame(Duration.millis(50), (ActionEvent actionEvent) -> {

                    if (contador[0] <= Casos[0]) {
                        contador[0] = contador[0] + 75;
                        datos.set(0, new PieChart.Data("2000", contador[0]));
                    }
                    if (contador[1] <= Casos[1]) {
                        contador[1] = contador[1] + 75;
                        datos.set(1, new PieChart.Data("2001", contador[1]));
                    }
                    if (contador[2] <= Casos[2]) {
                        contador[2] = contador[2] + 75;
                        datos.set(2, new PieChart.Data("2002", contador[2]));
                    }
                    if (contador[3] <= Casos[3]) {
                        contador[3] = contador[3] + 75;
                        datos.set(3, new PieChart.Data("2003", contador[3]));
                    }
                    if (contador[4] <= Casos[4]) {
                        contador[4] = contador[4] + 75;
                        datos.set(4, new PieChart.Data("2004", contador[4]));
                    }
                    if (contador[5] <= Casos[5]) {
                        contador[5] = contador[5] + 75;
                        datos.set(5, new PieChart.Data("2005", contador[5]));
                    }
                    if (contador[6] <= Casos[6]) {
                        contador[6] = contador[6] + 75;
                        datos.set(6, new PieChart.Data("2006", contador[6]));
                    }
                    if (contador[7] <= Casos[7]) {
                        contador[7] = contador[7] + 75;
                        datos.set(7, new PieChart.Data("2007", contador[7]));
                    }
                    if (contador[8] <= Casos[8]) {
                        contador[8] = contador[8] + 75;
                        datos.set(8, new PieChart.Data("2008", contador[8]));
                    }
                    if (contador[9] <= Casos[9]) {
                        contador[9] = contador[9] + 75;
                        datos.set(9, new PieChart.Data("2009", contador[9]));
                    }
                    if (contador[10] <= Casos[10]) {
                        contador[10] = contador[10] + 75;
                        datos.set(10, new PieChart.Data("2010", contador[10]));
                    }

                }));
        tl.setCycleCount(10000);
        tl.play();
         pcCasos.getData().forEach(this::Mensaje);
        nodo = new Group(pcCasos);

        return nodo;
    }

    @Override
    public Node CirculoSARSInfectados() {
        int[] Casos = {250, 5327, 1755, 307, 71};

        int[] contador = {0, 0, 0, 0, 0};
        ObservableList<PieChart.Data> datosInfectados = FXCollections.observableArrayList();
        datosInfectados.addAll(new PieChart.Data("Canada", Casos[0]),
                new PieChart.Data("China", Casos[1]),
                new PieChart.Data("Hong Kong", Casos[2]),
                new PieChart.Data("Taiwan", Casos[3]),
                new PieChart.Data("EE.UU", Casos[4]));

        PieChart pcInfectados = new PieChart(datosInfectados);
        pcInfectados.setTitle("Infectados por SARS 11 de Julio del 2003");
        pcInfectados.setLegendSide(Side.LEFT);
        pcInfectados.setLabelLineLength(20);
        
        pcInfectados.setMinSize(700, 600);
        Timeline tl = new Timeline();
        tl.getKeyFrames().add(
                new KeyFrame(Duration.millis(100), (ActionEvent actionEvent) -> {

                    if (contador[0] <= Casos[0]) {
                        contador[0] = contador[0] + 10;
                        datosInfectados.set(0, new PieChart.Data("Canada", contador[0]));
                    }
                    if (contador[1] <= Casos[1]) {
                        contador[1] = contador[1] + 500;
                        datosInfectados.set(1, new PieChart.Data("China", contador[1]));
                    }
                    if (contador[2] <= Casos[2]) {
                        contador[2] = contador[2] + 100;
                        datosInfectados.set(2, new PieChart.Data("Hong Kong", contador[2]));
                    }
                    if (contador[3] <= Casos[3]) {
                        contador[3] = contador[3] + 10;
                        datosInfectados.set(3, new PieChart.Data("Taiwan", contador[3]));
                    }
                    if (contador[4] <= Casos[4]) {
                        contador[4] = contador[4] + 10;
                        datosInfectados.set(4, new PieChart.Data("EE.UU", contador[4]));
                    }
                }));

        tl.setCycleCount(1000);
        tl.play();
        pcInfectados.getData().forEach(this::Mensaje);
        nodo = new HBox(10, pcInfectados, btnSiguiente);

        return nodo;
    }

    @Override
    public Node CirculoSARSMuertos() {
        int[] Muertos = {38, 348, 297, 47, 0};
        int[] Contador1 = {0, 0, 0, 0, 0};

        ObservableList<PieChart.Data> datosMuertos = FXCollections.observableArrayList();
        datosMuertos.addAll(new PieChart.Data("Canada", Muertos[0]),
                new PieChart.Data("China", Muertos[1]),
                new PieChart.Data("Hong Kong", Muertos[2]),
                new PieChart.Data("Taiwan", Muertos[3]),
                new PieChart.Data("EE.UU", Muertos[4]));

        PieChart pcMuertos = new PieChart(datosMuertos);
        pcMuertos.setTitle("Muertos por SARS 13 de Julio del 2003");
        pcMuertos.setLegendSide(Side.LEFT);
        pcMuertos.setLabelLineLength(20);
       
        pcMuertos.setMinSize(700, 600);

        Timeline t1 = new Timeline();
        t1.getKeyFrames().add(new KeyFrame(Duration.millis(100), (ActionEvent actionEvent) -> {
            if (Contador1[0] < Muertos[0]) {
                Contador1[0] = Contador1[0] + (int)(Math.random() * 20)+1;
                datosMuertos.set(0, new PieChart.Data("Canada", Contador1[0]));
            }
            if (Contador1[1] < Muertos[1]) {
                Contador1[1] = Contador1[1] + (int)(Math.random() * 10)+1;
                datosMuertos.set(1, new PieChart.Data("China", Contador1[1]));
            }
            if (Contador1[2] < Muertos[2]) {
                Contador1[2] = Contador1[2] + (int)(Math.random() * 10)+1;
                datosMuertos.set(2, new PieChart.Data("Hong Kong", Contador1[2]));
            }
            if (Contador1[3] < Muertos[3]) {
                Contador1[3] = Contador1[3] + (int)(Math.random() * 5)+1;
                datosMuertos.set(3, new PieChart.Data("Taiwan", Contador1[3]));
            }
            if (Contador1[4] < Muertos[4]) {
                Contador1[4] = Contador1[4] + (int)(Math.random() * 5)+1;
                datosMuertos.set(4, new PieChart.Data("EE.UU", Contador1[4]));
            }
        }));
        t1.setCycleCount(1000);
        t1.play();
        pcMuertos.getData().forEach(this::Mensaje);

        nodo = new HBox(10, pcMuertos, btnAtras);
        return nodo;
    }

    private void Mensaje(PieChart.Data mensaje) {
        Tooltip dato = new Tooltip(mensaje.getName() + " : " + mensaje.getPieValue());
        Tooltip.install(mensaje.getNode(), dato);
    }
}
