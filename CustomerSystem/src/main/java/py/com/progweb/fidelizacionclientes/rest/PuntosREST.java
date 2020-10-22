package py.com.progweb.fidelizacionclientes.rest;


import py.com.progweb.fidelizacionclientes.ejb.*;
import py.com.progweb.fidelizacionclientes.model.*;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.*;

@Path(value = "puntos")
public class PuntosREST {

    @Inject
    private PuntosDAO puntosDAO;

  @Inject
  private VencimientoDAO vencimientoDAO;
  @Inject
  private ClienteDAO clienteDAO;
  @Inject
  private UsopuntosDAO usopuntosDAO;

  @Inject
  private BolsaPuntosDAO bolsapuntosDAO;

  @Inject
  private AsignacionDAO asignacionDAO;
    @POST
    @Consumes("application/json")
    public void create(Puntos entity) {
        puntosDAO.agregar(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes("application/json")
    public void edit(@PathParam("id") Integer id, Puntos entity) {
        puntosDAO.modificar(id,entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        puntosDAO.borrar(id);
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Puntos find(@PathParam("id") Integer id) {
        return puntosDAO.listarPorId(id);
    }

    @GET
    @Produces("application/json")
    public List<Puntos> findAll() {
        return puntosDAO.listar();
    }

  @POST
  @Path("/cargarpuntos")
  @Consumes("application/json")
  public String cargarpuntos(@QueryParam("id_cliente") Integer id_cliente,@QueryParam("monto") Integer monto)
  {
    /*forma aleatoria fecha*/
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(new Date());
    calendar.add(Calendar.DAY_OF_YEAR, 10);

  Bolsapuntos bp = new Bolsapuntos();
  bp.setFechaAsignacionPuntaje(new Date());
  bp.setFechaCaducidadPuntaje( calendar.getTime());
  bp.setMontoOperacion(monto);
  Asignacion m = asignacionDAO.obtenerPorMonto(monto);
  Integer puntos = Math.round(monto/m.getMonto());
  bp.setPuntajeAsignado(puntos);
  bp.setCliente(clienteDAO.obtenerPorId(id_cliente));

    bp.setVencimiento(vencimientoDAO.obtenerPorId(1));
    bolsapuntosDAO.cargarpuntos(bp);

  return "puntos cargados correctamente";
  }

  @POST
  @Path("/utilizarpuntos")
  @Consumes("application/json")
  public String utilizarpuntos(@QueryParam("id_cliente") Integer id_cliente,@QueryParam("id_puntos") Integer idpuntos)
  {
    Puntos p = puntosDAO.listarPorId(idpuntos);


    Usopuntoscabecera upc =new Usopuntoscabecera();
    upc.setCliente(clienteDAO.obtenerPorId(id_cliente));
    upc.setConcepto(p.getConcepto());
    upc.setFecha(new Date());
    upc.setPuntajeUtilizado(p.getPuntosRequeridos());

    Usopuntosdetalle ud = new Usopuntosdetalle();
    ud.setBolsapuntos(bolsapuntosDAO.obtenerPorId(id_cliente));
    ud.setPuntajeUtilizado(p.getPuntosRequeridos());
    ud.setUsopuntoscabecera(upc);

    bolsapuntosDAO.actualizapuntos(p.getPuntosRequeridos(),id_cliente);
    usopuntosDAO.agregarusopuntoscabecera(upc);
    usopuntosDAO.agregarusopuntosdetalle(ud);

    return "ok,puntos utilizados";
  }

  @GET
  @Path("/cantpuntos")
  @Produces("application/json")
  public Map<String,Integer> monto(@QueryParam("monto") Integer monto) {
    Asignacion m = asignacionDAO.obtenerPorMonto(monto);
    Integer puntos = Math.round(monto/m.getMonto());
    Map<String,Integer>  mp = new HashMap<>();
    mp.put("puntos" , puntos);
    return mp;
  }

}
