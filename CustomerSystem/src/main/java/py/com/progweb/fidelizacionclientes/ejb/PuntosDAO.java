package py.com.progweb.fidelizacionclientes.ejb;



import py.com.progweb.fidelizacionclientes.model.Puntos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class PuntosDAO  {
    @PersistenceContext(unitName = "customersystemPU")
    private EntityManager entityManager;

    public void agregar(Puntos puntos){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(puntos);
            entityManager.getTransaction().commit();
        }catch (Exception e){

        }

    }

    public Puntos listarPorId(Integer id_puntos){
        Query q= entityManager
                .createQuery("select p from Puntos  p  WHERE p.id_puntos = :id_puntos")
                .setParameter("id_puntos", id_puntos);
        return (Puntos) q.getSingleResult();
    }

    public List<Puntos> listar(){
        Query q= entityManager
                .createQuery("select p from Puntos  p ");
        return (List<Puntos>) q.getResultList();
    }

    public void modificar(Integer id, Puntos p){
        entityManager.getTransaction().begin();
        Puntos puntos = entityManager.find(Puntos.class, id);
        entityManager.merge(puntos);
        entityManager.getTransaction().commit();

    }

    public void borrar(Integer id){
        entityManager.getTransaction().begin();
        Puntos puntos = entityManager.find(Puntos.class, id);
        entityManager.remove(puntos);
        entityManager.getTransaction().commit();
    }

}
