package py.com.progweb.fidelizacionclientes.ejb;


import py.com.progweb.fidelizacionclientes.model.Asignacion;
import py.com.progweb.fidelizacionclientes.model.Bolsapuntos;
import py.com.progweb.fidelizacionclientes.model.Cliente;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class AsignacionDAO {
    @PersistenceContext(unitName = "customersystemPU")
    private EntityManager entityManager;

    public void agregar(Asignacion asignacion){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(asignacion);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }

    }

    public Asignacion listarPorId(Integer id){
        Query q= entityManager
                .createQuery("select a  from Asignacion a  WHERE a.id_asignacion = :id")
                .setParameter("id", id);
        return (Asignacion) q.getResultList();
    }

    public List<Asignacion> listar(){
        Query q= entityManager
                .createQuery("select a  from Asignacion a  ");
        return (List<Asignacion>) q.getResultList();
    }

    public void modificar(Integer id, Asignacion a){
        entityManager.getTransaction().begin();
        Cliente cliente = entityManager.find(Cliente.class, id);
        entityManager.merge(cliente);
        entityManager.getTransaction().commit();
    }

    public void borrar(Integer id){
        entityManager.getTransaction().begin();
        Asignacion asignacion = entityManager.find(Asignacion.class, id);
        entityManager.remove(asignacion);
        entityManager.getTransaction().commit();
    }

  public Asignacion obtenerPorMonto(Integer monto){
    Query q= entityManager
      .createQuery("select a from Asignacion  a  WHERE a.limite_inferior <= :monto AND a.limite_superior >= :monto")
      .setParameter("monto", monto);

    return (Asignacion) q.getSingleResult();
  }
}
