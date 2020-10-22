package py.com.progweb.fidelizacionclientes.rest;


import py.com.progweb.fidelizacionclientes.ejb.BolsaPuntosDAO;
import py.com.progweb.fidelizacionclientes.ejb.UsopuntosDAO;
import py.com.progweb.fidelizacionclientes.ejb.VencimientoDAO;
import py.com.progweb.fidelizacionclientes.model.Asignacion;

import javax.inject.Inject;
import javax.ws.rs.*;

import javax.ws.rs.core.Response;
import java.text.ParseException;

@Path("bolsapuntos")
@Consumes("application/json")
@Produces("application/json")
public class BolsapuntosREST {

  @Inject
  private BolsaPuntosDAO bolsaPuntosDAO;

  @GET
  @Path("/cliente")
  public Response  consultaPorCliente(@QueryParam("id_cliente")Integer id_cliente){
    return Response.ok(bolsaPuntosDAO.consultaPor(id_cliente)).build();
  }
  @GET
  @Path("/puntos")
  public Response  consultaPorPuntos(@QueryParam("puntos")Integer puntos ){
    return Response.ok(bolsaPuntosDAO.consultaPorPuntos(puntos)).build();
  }

  @GET
  @Path("/puntosavencer")
  public Response consultaPorPuntosavencer(@QueryParam("fecha")String fecha ) throws ParseException {
    return Response.ok(bolsaPuntosDAO.listaclientepuntosavencer(fecha)).build();
  }

}
