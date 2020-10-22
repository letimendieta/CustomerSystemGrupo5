package py.com.progweb.fidelizacionclientes.model;

import py.com.progweb.fidelizacionclientes.util.AbstractPuntos;
import py.com.progweb.fidelizacionclientes.util.interfaces.IPuntosComposicionInterfaz;
import py.com.progweb.fidelizacionclientes.util.interfaces.IStrategyUsarPuntos;

public class Puntosextra extends AbstractPuntos implements IStrategyUsarPuntos, IPuntosComposicionInterfaz {

    private Integer id_puntos;


    private String concepto;


    private Integer puntosRequeridos;

    public Puntosextra() {

    }

    public Puntosextra(String concepto) {
        this.concepto = concepto;
    }

    public Integer obtenerId_puntos() {
        return id_puntos;
    }

    public void establecerId_puntos(Integer id_puntos) {
        this.id_puntos = id_puntos;
    }

    public String obtenerConcepto() {
        return concepto;
    }

    public void establecerConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Integer obtenerPuntosRequeridos() {
        return puntosRequeridos;
    }

    public void establecerPuntosRequeridos(Integer puntosRequeridos) {
        this.puntosRequeridos = puntosRequeridos;
    }

    @Override
    public String usarPuntos(Integer puntos) {
        return "No esta habilitado para usar puntos extra";
    }

    @Override
    public boolean esNulo() {
        return false;
    }

    @Override
    public String verConcepto() {
        return concepto;
    }

    @Override
    public void mostrarDetallePuntos() {
        System.out.println("Puntos Extra : " + id_puntos+" " + concepto +" " + puntosRequeridos);

    }
}
