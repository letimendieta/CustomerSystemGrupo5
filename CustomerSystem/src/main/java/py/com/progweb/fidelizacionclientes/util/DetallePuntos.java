package py.com.progweb.fidelizacionclientes.util;

import py.com.progweb.fidelizacionclientes.model.Puntos;
import py.com.progweb.fidelizacionclientes.util.interfaces.IPuntosComposicionInterfaz;

import java.util.ArrayList;
import java.util.List;

public class DetallePuntos implements IPuntosComposicionInterfaz {
    private List<IPuntosComposicionInterfaz> puntosLista = new ArrayList<IPuntosComposicionInterfaz>();

    public void agregarPunto(IPuntosComposicionInterfaz p)
    {
        puntosLista.add(p);
    }

    public void quitarPunto(IPuntosComposicionInterfaz p)
    {
        puntosLista.remove(p);
    }

    @Override
    public void mostrarDetallePuntos() {
        for(IPuntosComposicionInterfaz puntoslist:puntosLista)
        {
            puntoslist.mostrarDetallePuntos();
        }
    }
}
