package py.com.progweb.fidelizacionclientes.rest;

import py.com.progweb.fidelizacionclientes.ejb.ClienteDAO;
import py.com.progweb.fidelizacionclientes.model.Cliente;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.text.ParseException;

@Path("cliente")
@Consumes("application/json")
@Produces("application/json")

public class ClienteREST {

    @Inject
    private ClienteDAO clienteDAO;

    @GET
    @Path("/")
    public Response listar(){
        return Response.ok(clienteDAO.lista()).build();
    }

    @POST
    @Path("/")
    public Response crear(Cliente c){
        this.clienteDAO.agregar(c);
    return Response.ok().build();

    }

    @PUT
    @Path("/{id}")
    public Response modificar(@PathParam("id") int id,Cliente c){
        this.clienteDAO.modificar(id,c);
        return Response.ok().build();
    }

  @GET
  @Path("/nombre")
  public Response listarPorNombre(@QueryParam("nombre") String nombre){
    return Response.ok(clienteDAO.listapornombre(nombre)).build();
  }

  @GET
  @Path("/apellido")
  public Response listarPorApellido(@QueryParam("apellido") String apellido){
    return Response.ok(clienteDAO.listaporapellido(apellido)).build();
  }

  @GET
  @Path("/cumple")
  public Response listarPorCumple(@QueryParam("cumple") String fechanacimiento) throws ParseException {
    return Response.ok(clienteDAO.listaporcumple(fechanacimiento)).build();
  }
}
