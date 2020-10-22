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
@Table(name = "uso_puntos_cabecera")
public class Usopuntoscabecera {
    @Id
    @Column(name = "id_uso_puntos_cabecera")
    @Basic(optional = false)
    @GeneratedValue(generator = "uso_puntos_cabecera_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "uso_puntos_cabecera_id_seq", sequenceName = "uso_puntos_cabecera_id_seq", allocationSize = 0)
    private Integer id_uso_puntos_cabecera;

    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false)
    private Cliente cliente;

    @Column(name = "puntaje_utilizado")
    @Basic(optional = false)
    private Integer puntajeUtilizado;

    @Column(name = "fecha")
    @Basic(optional = false)
    private Date fecha;

    @Column(name = "concepto", length = 45)
    @Basic(optional = false)
    private String concepto;

    @OneToMany(mappedBy = "usopuntoscabecera")
    private List<Usopuntosdetalle> listaUsopuntosdetallesList;

    public Usopuntoscabecera() {
    }

    public Integer getId_uso_puntos_cabecera() {
        return id_uso_puntos_cabecera;
    }

    public void setId_uso_puntos_cabecera(Integer id_uso_puntos_cabecera) {
        this.id_uso_puntos_cabecera = id_uso_puntos_cabecera;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getPuntajeUtilizado() {
        return puntajeUtilizado;
    }

    public void setPuntajeUtilizado(Integer puntajeUtilizado) {
        this.puntajeUtilizado = puntajeUtilizado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

  public List<Usopuntosdetalle> getListaUsopuntosdetallesList() {
    return listaUsopuntosdetallesList;
  }

  public void setListaUsopuntosdetallesList(List<Usopuntosdetalle> listaUsopuntosdetallesList) {
    this.listaUsopuntosdetallesList = listaUsopuntosdetallesList;
  }
}
