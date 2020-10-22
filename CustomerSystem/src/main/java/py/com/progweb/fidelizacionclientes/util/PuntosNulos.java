package py.com.progweb.fidelizacionclientes.util;

public class PuntosNulos extends AbstractPuntos{
    @Override
    public boolean esNulo() {
        return true;
    }

    @Override
    public String verConcepto() {
        return "Concepto no disponible";
    }
}
