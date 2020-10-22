package py.com.progweb.fidelizacionclientes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "bolsa_puntos")
public class Bolsapuntos {
    @Id
    @Column(name = "id_bolsa_puntos")
    @Basic(optional = false )
    @GeneratedValue(generator = "bolsa_puntos_id_seq",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "bolsa_puntos_id_seq", sequenceName = "bolsa_puntos_id_seq", allocationSize = 0)
    private Integer id_bolsa_puntos;


    @Column(name = "fecha_asignacion_puntaje")
    @Basic (optional = false)
    @Temporal(TemporalType.DATE)
    private Date fechaAsignacionPuntaje;

    @Column(name = "fecha_caducidad_puntaje")
    @Basic (optional = false)
    @Temporal(TemporalType.DATE)
    private Date fechaCaducidadPuntaje;

    @Column(name = "puntaje_asignado")
    @Basic (optional = false)
    private Integer puntajeAsignado;

    @Column(name = "puntaje_utilizado")
    @Basic (optional = false)
    private Integer puntajeUtilizado;

    @Column(name = "saldo_punto")
    @Basic (optional = false)
    private Integer saldoPunto;

    @Column(name = "monto_operacion")
    @Basic (optional = false)
    private Integer montoOperacion;


  //id perteneciente a la tabla de cliente
  @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
  @ManyToOne(optional = false)
  private Cliente cliente;

  @JoinColumn(name = "id_vencimiento", referencedColumnName = "id_vencimiento")
  @ManyToOne(optional = false)
  private Vencimiento vencimiento;

  public Vencimiento getVencimiento() {
    return vencimiento;
  }

  public void setVencimiento(Vencimiento vencimiento) {
    this.vencimiento = vencimiento;
  }

  public Bolsapuntos() {
    }


    public Integer getId_bolsa_puntos() {
        return id_bolsa_puntos;
    }

    public void setId_bolsa_puntos(Integer id_bolsa_puntos) {
        this.id_bolsa_puntos = id_bolsa_puntos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFechaAsignacionPuntaje() {
        return fechaAsignacionPuntaje;
    }

    public void setFechaAsignacionPuntaje(Date fechaAsignacionPuntaje) {
        this.fechaAsignacionPuntaje = fechaAsignacionPuntaje;
    }

    public Date getFechaCaducidadPuntaje() {
        return fechaCaducidadPuntaje;
    }

    public void setFechaCaducidadPuntaje(Date fechaCaducidadPuntaje) {
        this.fechaCaducidadPuntaje = fechaCaducidadPuntaje;
    }

    public Integer getPuntajeAsignado() {
        return puntajeAsignado;
    }

    public void setPuntajeAsignado(Integer puntajeAsignado) {
        this.puntajeAsignado = puntajeAsignado;
    }

    public Integer getPuntajeUtilizado() {
        return puntajeUtilizado;
    }

    public void setPuntajeUtilizado(Integer puntajeUtilizado) {
        this.puntajeUtilizado = puntajeUtilizado;
    }

    public Integer getSaldoPunto() {
        return saldoPunto;
    }

    public void setSaldoPunto(Integer saldoPunto) {
        this.saldoPunto = saldoPunto;
    }

    public Integer getMontoOperacion() {
        return montoOperacion;
    }

    public void setMontoOperacion(Integer montoOperacion) {
        this.montoOperacion = montoOperacion;
    }


}
