package py.com.progweb.fidelizacionclientes.ejb;

import py.com.progweb.fidelizacionclientes.model.Bolsapuntos;
import py.com.progweb.fidelizacionclientes.model.Cliente;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Stateless
public class BolsaPuntosDAO {
  @PersistenceContext(unitName = "customersystemPU")
  private EntityManager entityManager;

  public void cargarpuntos(Bolsapuntos bolsapuntospuntos){
    this.entityManager.persist(bolsapuntospuntos);


  }


  public void actualizapuntos(Integer puntos,Integer id_cliente){
    Bolsapuntos bp = obtenerPorId(id_cliente);
    Integer puntofinal = bp.getPuntajeAsignado() - puntos;
    bp.setPuntajeUtilizado(puntos);
    bp.setPuntajeAsignado(puntofinal);
    bp.setSaldoPunto(puntofinal);
   this.entityManager.merge(bp);

  }

  public Bolsapuntos obtenerPorId(Integer id){
    Query q= entityManager
      .createQuery("select b from Bolsapuntos  b  WHERE b.cliente.id_cliente = :id")
      .setParameter("id", id);
    return (Bolsapuntos) q.getSingleResult();
  }

  public List<Bolsapuntos> consultaPor(Integer valor) {
    Query q= entityManager
      .createQuery("select distinct b.cliente.numeroDocumento, b.cliente.nombre , b.cliente.apellido , b.puntajeAsignado, b.puntajeUtilizado ,b.saldoPunto,b.montoOperacion, function('to_char',b.fechaAsignacionPuntaje,'yyyy-mm-dd'),function('to_char',b.fechaCaducidadPuntaje,'yyyy-mm-dd') from Bolsapuntos b left join  b.cliente.listaBolsaPuntos lb  WHERE b.cliente.id_cliente=lb.cliente.id_cliente AND b.cliente.id_cliente = :id")
      .setParameter("id", valor);
    return (List<Bolsapuntos>) q.getResultList();
  }

  public List<Bolsapuntos> consultaPorPuntos(Integer valor) {
    Query q= entityManager
      .createQuery("select distinct b.cliente.numeroDocumento, b.cliente.nombre , b.cliente.apellido , b.puntajeAsignado, b.puntajeUtilizado ,b.saldoPunto,b.montoOperacion, function('to_char',b.fechaAsignacionPuntaje,'yyyy-mm-dd'),function('to_char',b.fechaCaducidadPuntaje,'yyyy-mm-dd') from Bolsapuntos b left join  b.cliente.listaBolsaPuntos lb  WHERE b.cliente.id_cliente=lb.cliente.id_cliente AND b.puntajeAsignado <= :puntos and b.puntajeAsignado >= :puntos")
      .setParameter("puntos", valor);
    return (List<Bolsapuntos>) q.getResultList();
  }
  public  List<Cliente> listaclientepuntosavencer(String fecha) throws ParseException {
    SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
    String strFecha = fecha;
    Query q= entityManager.createQuery("select distinct b.cliente.numeroDocumento, b.cliente.nombre , b.cliente.apellido , b.puntajeAsignado, b.puntajeUtilizado ,b.saldoPunto,b.montoOperacion, function('to_char',b.fechaAsignacionPuntaje,'yyyy-mm-dd'),function('to_char',b.fechaCaducidadPuntaje,'yyyy-mm-dd'),b.vencimiento.diasDuracion from Bolsapuntos b left join  b.cliente.listaBolsaPuntos lb  WHERE b.cliente.id_cliente=lb.cliente.id_cliente AND b.vencimiento.fechaFinValidez=:valor")
      .setParameter("valor", formatoDelTexto.parse(strFecha));
    return (List<Cliente>) q.getResultList();
  }
}
