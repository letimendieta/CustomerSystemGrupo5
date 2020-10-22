package py.com.progweb.fidelizacionclientes.ejb;


import py.com.progweb.fidelizacionclientes.model.Cliente;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Stateless
public class ClienteDAO {
    @PersistenceContext(unitName = "customersystemPU")

    private EntityManager em;

    public void agregar(Cliente entidad) {
        this.em.persist(entidad);

    }

    public void modificar(Integer id_cliente, Cliente c ) {
        em.getTransaction().begin();
        Cliente cliente = em.find(Cliente.class, id_cliente);
        em.merge(cliente);
        em.getTransaction().commit();
    }

    public Object lista() {
        Query q=this.em.createQuery("select c  from Cliente c");

        return (List<Cliente>) q.getResultList();
    }

    public void borrar(Integer id){
        em.getTransaction().begin();
        Cliente cliente = em.find(Cliente.class, id);
        em.remove(cliente);
        em.getTransaction().commit();
    }
  public Cliente obtenerPorId(Integer id){
    Query q= em
      .createQuery("select c from Cliente  c  WHERE c.id_cliente = :id")
      .setParameter("id", id);

    return (Cliente) q.getSingleResult();
  }

  public List<Cliente> listapornombre(String nombre) {
    Query q= em
      .createQuery("select distinct c.nombre,c.apellido,c.email,c.telefono, function('to_char',c.fechaNacimiento,'yyyy-mm-dd')  from Cliente c  left join c.listaBolsaPuntos l WHERE c.id_cliente=l.cliente.id_cliente AND c.nombre like :valor")
      .setParameter("valor", nombre);
    return q.getResultList();
  }

  public List<Cliente> listaporapellido(String apellido) {
    Query q= em
      .createQuery("select distinct c.nombre,c.apellido,c.email,c.telefono, function('to_char',c.fechaNacimiento,'yyyy-mm-dd')  from Cliente c  left join c.listaBolsaPuntos l WHERE c.id_cliente=l.cliente.id_cliente AND c.apellido like :valor")
      .setParameter("valor", apellido);
    return q.getResultList();
  }

  public List<Cliente> listaporcumple(String fecha) throws ParseException {
    SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
    String strFecha = fecha;
    Query q= em
      .createQuery("select distinct c.nombre,c.apellido,c.email,c.telefono, function('to_char',c.fechaNacimiento,'yyyy-mm-dd')  from Cliente c left join c.listaBolsaPuntos l WHERE c.id_cliente=l.cliente.id_cliente AND c.fechaNacimiento= :valor")
      .setParameter("valor", formatoDelTexto.parse(strFecha));
    return q.getResultList();
  }
}
