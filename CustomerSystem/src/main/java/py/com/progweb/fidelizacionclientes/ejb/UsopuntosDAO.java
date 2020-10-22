package py.com.progweb.fidelizacionclientes.ejb;



import py.com.progweb.fidelizacionclientes.model.Usopuntoscabecera;
import py.com.progweb.fidelizacionclientes.model.Usopuntosdetalle;
import py.com.progweb.fidelizacionclientes.model.Vencimiento;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Stateless
public class UsopuntosDAO {
  @PersistenceContext(unitName = "customersystemPU")
  private EntityManager entityManager;

  public void agregarusopuntoscabecera(Usopuntoscabecera usopuntoscabecerapuntos) {
    this.entityManager.persist(usopuntoscabecerapuntos);

  }
  public void agregarusopuntosdetalle(Usopuntosdetalle usopuntosdetalle) {
    this.entityManager.persist(usopuntosdetalle);

  }

  public List<Usopuntoscabecera> consultaPorConcepto(String concepto) {
    Query q= entityManager
      .createQuery("select distinct usc.concepto, usc.puntajeUtilizado , function('to_char',usc.fecha,'yyyy-mm-dd'),usc.cliente.numeroDocumento, usc.cliente.nombre, usc.cliente.apellido from Usopuntoscabecera usc left join  usc.cliente.listaBolsaPuntos l WHERE usc.cliente.id_cliente=l.cliente.id_cliente and usc.concepto = :valor")

      .setParameter("valor", concepto);
    return q.getResultList();
  }
  public List<Usopuntoscabecera> consultaPorFecha(String fecha) throws ParseException {
    SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
    String strFecha = fecha;

    Query q= entityManager
      .createQuery("select distinct usc.concepto, usc.puntajeUtilizado , function('to_char',usc.fecha,'yyyy-mm-dd'),usc.cliente.numeroDocumento, usc.cliente.nombre, usc.cliente.apellido from Usopuntoscabecera usc left join  usc.cliente.listaBolsaPuntos l WHERE usc.cliente.id_cliente=l.cliente.id_cliente and usc.fecha = :valor")
      .setParameter("valor", formatoDelTexto.parse(strFecha));
    return q.getResultList();

  }
  public List<Usopuntoscabecera> consultaPorCliente(Integer id_cliente) {
    Query q= entityManager
      .createQuery("select distinct usc.concepto, usc.puntajeUtilizado , function('to_char',usc.fecha,'yyyy-mm-dd'),usc.cliente.numeroDocumento, usc.cliente.nombre, usc.cliente.apellido from Usopuntoscabecera usc left join  usc.cliente.listaBolsaPuntos l WHERE usc.cliente.id_cliente=l.cliente.id_cliente and usc.cliente.id_cliente = :valor")

      .setParameter("valor", id_cliente);
    return q.getResultList();
  }
}
