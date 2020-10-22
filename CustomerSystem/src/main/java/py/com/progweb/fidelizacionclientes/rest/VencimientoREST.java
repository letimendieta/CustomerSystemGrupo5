package py.com.progweb.fidelizacionclientes.rest;


import py.com.progweb.fidelizacionclientes.ejb.VencimientoDAO;
import py.com.progweb.fidelizacionclientes.model.Vencimiento;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Path(value = "vencimiento")
@Consumes("application/json")
@Produces("application/json")
public class VencimientoREST {

    @Inject
    private VencimientoDAO vencimientoDAO;

    @POST
    @Path("/")
    public Response create() {
      Vencimiento entity = new Vencimiento();
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(new Date());
      calendar.add(Calendar.DAY_OF_YEAR, 10);
      entity.setFechaInicioValidez(new Date());
      entity.setFechaFinValidez(calendar.getTime());
      entity.setDiasDuracion(10);
      vencimientoDAO.agregar(entity);
      return Response.ok().build();
    }

    @PUT
    @Path("{id}")
    @Consumes("application/json")
    public void edit(@PathParam("id") Integer id, Vencimiento entity) {
        vencimientoDAO.modificar(id,entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        vencimientoDAO.borrar(id);
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Vencimiento find(@PathParam("id") Integer id) {
        return vencimientoDAO.listarPorId(id);
    }

    @GET
    @Produces("application/json")
    public List<Vencimiento> findAll() {
        return vencimientoDAO.listar();
    }


}
