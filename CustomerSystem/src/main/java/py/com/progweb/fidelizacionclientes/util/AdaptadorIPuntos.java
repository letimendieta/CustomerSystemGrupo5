package py.com.progweb.fidelizacionclientes.util;

import py.com.progweb.fidelizacionclientes.model.Puntosextra;
import py.com.progweb.fidelizacionclientes.util.interfaces.IPuntosInterfaz;

public class AdaptadorIPuntos implements IPuntosInterfaz {

    Puntosextra pe = new Puntosextra();
    @Override
    public Integer getId_puntos() {
        return pe.obtenerId_puntos();
    }

    @Override
    public void setId_puntos(Integer id_puntos) {
    pe.establecerId_puntos(id_puntos);
    }

    @Override
    public String getConcepto() {
        return pe.obtenerConcepto();
    }

    @Override
    public void setConcepto(String concepto) {
        pe.establecerConcepto(concepto);
    }

    @Override
    public Integer getPuntosRequeridos() {
        return pe.obtenerPuntosRequeridos();
    }

    @Override
    public void setPuntosRequeridos(Integer puntosRequeridos) {
        pe.establecerPuntosRequeridos(puntosRequeridos);
    }
}
