package py.com.progweb.fidelizacionclientes.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import py.com.progweb.fidelizacionclientes.util.interfaces.IEstadoVencimiento;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "vencimiento")
public class Vencimiento implements Cloneable, IEstadoVencimiento {
    @Id
    @Column(name = "id_vencimiento")
    @Basic(optional = false )
    @GeneratedValue(generator = "vencimiento_id_seq",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "vencimiento_id_seq", sequenceName = "vencimiento_id_seq", allocationSize = 0)
    private Integer id_vencimiento;

    @Column(name = "fecha_inicio_validez")
    @Basic (optional = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicioValidez;

    @Column(name = "fecha_fin_validez")
    @Basic (optional = false)
    @Temporal(TemporalType.DATE)
    private Date fechaFinValidez;

    @Column(name = "dias_duracion")
    @Basic (optional = false)
    private Integer diasDuracion;


  @OneToMany(cascade=CascadeType.ALL,mappedBy = "vencimiento")
  @LazyCollection(LazyCollectionOption.FALSE)
  private List<Bolsapuntos> listbolsaPuntos;

    public Vencimiento() {
    }

    public Vencimiento(Integer id_vencimiento, Date fechaInicioValidez, Date fechaFinValidez, Integer diasDuracion) {
        this.id_vencimiento = id_vencimiento;
        this.fechaInicioValidez = fechaInicioValidez;
        this.fechaFinValidez = fechaFinValidez;
        this.diasDuracion = diasDuracion;
    }

    public List<Bolsapuntos> getListbolsaPuntos() {
    return listbolsaPuntos;
  }

  public void setListbolsaPuntos(List<Bolsapuntos> listbolsaPuntos) {
    this.listbolsaPuntos = listbolsaPuntos;
  }

  public Integer getId_vencimiento() {
        return id_vencimiento;
    }

    public void setId_vencimiento(Integer id_vencimiento) {
        this.id_vencimiento = id_vencimiento;
    }

    public Date getFechaInicioValidez() {
        return fechaInicioValidez;
    }

    public void setFechaInicioValidez(Date fechaInicioValidez) {
        this.fechaInicioValidez = fechaInicioValidez;
    }

    public Date getFechaFinValidez() {
        return fechaFinValidez;
    }

    public void setFechaFinValidez(Date fechaFinValidez) {
        this.fechaFinValidez = fechaFinValidez;
    }

    public Integer getDiasDuracion() {
        return diasDuracion;
    }

    public void setDiasDuracion(Integer diasDuracion) {
        this.diasDuracion = diasDuracion;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Vencimiento(id_vencimiento,fechaInicioValidez,fechaFinValidez,diasDuracion);
    }

    @Override
    public String toString() {
        return "Vencimiento{" +
                "id_vencimiento=" + id_vencimiento +
                ", fechaInicioValidez=" + fechaInicioValidez +
                ", fechaFinValidez=" + fechaFinValidez +
                ", diasDuracion=" + diasDuracion +
                '}';
    }

    @Override
    public void yaVencio(Vencimiento vencimiento) {
        System.out.println("Ya vencio los puntos segun dias de duracion " + getFechaFinValidez());
    }
}
