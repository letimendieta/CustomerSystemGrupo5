package py.com.progweb.fidelizacionclientes.rest;


import py.com.progweb.fidelizacionclientes.ejb.AsignacionDAO;
import py.com.progweb.fidelizacionclientes.model.Asignacion;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path(value = "/asignacion")
public class AsignacionREST {


    @Inject
    private AsignacionDAO asignacionDAO;

    @POST
    @Consumes(value = "application/json")
    public void crear(Asignacion asignacion){
        asignacionDAO.agregar(asignacion);
    }


    @PUT
    @Path("{idC}/{idP}")
    @Consumes("application/json")
    public void edit(@PathParam("idC") Integer id, Asignacion entity) {
        asignacionDAO.modificar(id,entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        asignacionDAO.borrar(id);
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Asignacion find(@PathParam("id") Integer id) {
        return asignacionDAO.listarPorId(id);
    }

    @GET
    @Produces("application/json")
    public List<Asignacion> findAll() {
        return asignacionDAO.listar();
    }




}
