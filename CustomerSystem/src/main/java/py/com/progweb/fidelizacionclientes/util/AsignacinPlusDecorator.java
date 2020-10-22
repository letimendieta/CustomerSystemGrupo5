package py.com.progweb.fidelizacionclientes.util;


import py.com.progweb.fidelizacionclientes.model.Asignacion;

public class AsignacinPlusDecorator extends AsignacionDecorator {

    public AsignacinPlusDecorator(Asignacion asignacion) {
        super(asignacion);
    }

    @Override
    public void establecerPorcentajeDescuento(){
        super.establecerPorcentajeDescuento();
        this.masDetalle();
    }

    private void masDetalle() {
        System.out.print("Mas Feriado especial");
    }


}
