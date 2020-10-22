package py.com.progweb.fidelizacionclientes.util;

import py.com.progweb.fidelizacionclientes.model.Puntosextra;

public class DemoPuntosextra {


    public static final String[] nombreconcepto = {"vale de compras", "promocionhalloween", "promoweeknd"};
    public static AbstractPuntos getPuntosConcepto(String concepto)
    {
        for (int i = 0; i < nombreconcepto.length; i++)
        {
            if (nombreconcepto[i].equalsIgnoreCase(concepto))
            {
                return new Puntosextra(concepto);
            }
        }
        return new PuntosNulos();
    }
}
