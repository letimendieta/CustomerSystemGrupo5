package py.com.progweb.fidelizacionclientes.util;

import py.com.progweb.fidelizacionclientes.model.Asignacion;
import py.com.progweb.fidelizacionclientes.util.interfaces.IAsignacion;

public abstract class  AsignacionDecorator implements IAsignacion {

    private final Asignacion asignacion;

    public AsignacionDecorator(Asignacion asignacion) {
        this.asignacion = asignacion;
    }


    @Override
    public void establecerPorcentajeDescuento() {
        this.asignacion.establecerPorcentajeDescuento();

    }



}
