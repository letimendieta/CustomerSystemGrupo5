package py.com.progweb.fidelizacionclientes.rest;

import py.com.progweb.fidelizacionclientes.ejb.UsopuntosDAO;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.text.ParseException;

@Path(value = "/usopuntos")

public class UsopuntosREST {

  @Inject
  private UsopuntosDAO usopuntosDAO;

  @GET
  @Path("/concepto")
  @Produces("application/json")
  public Response  consultaPorConcepto(@QueryParam("concepto")String concepto){
    return Response.ok(usopuntosDAO.consultaPorConcepto(concepto)).build();
  }
  @GET
  @Path("/fecha")
  @Produces("application/json")
  public Response  consultaPorFecha(@QueryParam("fecha")String fecha) throws ParseException {
    return Response.ok(usopuntosDAO.consultaPorFecha(fecha)).build();
  }

  @GET
  @Path("/cliente")
  @Produces("application/json")
  public Response  consultaPorCliente(@QueryParam("id_cliente")Integer id_cliente){
    return Response.ok(usopuntosDAO.consultaPorCliente(id_cliente)).build();
  }


}
