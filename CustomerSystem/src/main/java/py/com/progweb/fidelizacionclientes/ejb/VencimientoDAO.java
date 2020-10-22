package py.com.progweb.fidelizacionclientes.ejb;


import py.com.progweb.fidelizacionclientes.model.Cliente;
import py.com.progweb.fidelizacionclientes.model.Vencimiento;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class VencimientoDAO {
    @PersistenceContext(unitName = "customersystemPU")
    private EntityManager entityManager;

  public void agregar(Vencimiento entidad) {
    this.entityManager.persist(entidad);

  }

  public void modificar(Integer id_vencimiento, Vencimiento v ) {
    entityManager.getTransaction().begin();
    Vencimiento vencimiento = entityManager.find(Vencimiento.class, id_vencimiento);
    entityManager.merge(vencimiento);
    entityManager.getTransaction().commit();
  }
    public Vencimiento listarPorId(Integer id){
        Query q= entityManager
                .createQuery("select v from Vencimiento v  WHERE v.id_vencimiento = :id")
                .setParameter("id", id);
        return (Vencimiento) q.getResultList();
    }

    public List<Vencimiento> listar(){
        Query q= entityManager
                .createQuery("select v from Vencimiento v");
        return (List<Vencimiento>) q.getResultList();
    }

    public void borrar(Integer id){
        entityManager.getTransaction().begin();
        Vencimiento vencimiento = entityManager.find(Vencimiento.class, id);
        entityManager.remove(vencimiento);
        entityManager.getTransaction().commit();
    }

  public Vencimiento obtenerPorId(Integer id){
    Query q= entityManager
      .createQuery("select v from Vencimiento v  WHERE v.id_vencimiento = :id")
      .setParameter("id", id);
    return (Vencimiento) q.getSingleResult();
  }
}
