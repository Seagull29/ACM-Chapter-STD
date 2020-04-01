
package controladores;

import javafx.scene.Node;


public interface GenerarGraficos {
    public Node BarrasPorcina();
    public Node BarrasSida();
    public Node BarrasSARS();
    public Node LineasPorcina();
    public Node LineasSida();
    public Node LineasSARS();
    public Node CirculoPorcinaMuertos();
    public Node CirculoPorcinaInfectados();
    public Node CirculoSida();
    public Node CirculoSARSInfectados();
    public Node CirculoSARSMuertos();
}
