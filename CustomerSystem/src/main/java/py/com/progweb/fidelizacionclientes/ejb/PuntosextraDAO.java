package py.com.progweb.fidelizacionclientes.ejb;

import py.com.progweb.fidelizacionclientes.model.Puntos;
import py.com.progweb.fidelizacionclientes.model.Puntosextra;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class PuntosextraDAO {
    @PersistenceContext(unitName = "customersystemPU")
    private EntityManager entityManager;

    public void agregar(Puntosextra puntosextra){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(puntosextra);
            entityManager.getTransaction().commit();
        }catch (Exception e){

        }

    }

    public Puntos listarPorId(Integer id_puntosextra){
        Query q= entityManager
                .createQuery("select pe from Puntosextra  pe  WHERE pe.id_puntosextra = :id_puntosextra")
                .setParameter("id_puntosextra", id_puntosextra);
        return (Puntos) q.getSingleResult();
    }

    public List<Puntosextra> listar(){
        Query q= entityManager
                .createQuery("select pe from Puntosextra  pe ");
        return (List<Puntosextra>) q.getResultList();
    }

    public void modificar(Integer id, Puntosextra pe){
        entityManager.getTransaction().begin();
        Puntosextra puntosextra = entityManager.find(Puntosextra.class, id);
        entityManager.merge(puntosextra);
        entityManager.getTransaction().commit();

    }

    public void delete(Integer id){
        entityManager.getTransaction().begin();
        Puntosextra puntosextra = entityManager.find(Puntosextra.class, id);
        entityManager.remove(puntosextra);
        entityManager.getTransaction().commit();
    }



}
