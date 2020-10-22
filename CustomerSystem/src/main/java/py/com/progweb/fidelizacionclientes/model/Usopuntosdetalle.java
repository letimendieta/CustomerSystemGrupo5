package py.com.progweb.fidelizacionclientes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "uso_puntos_detalle")
public class Usopuntosdetalle{

    @Id
    @Column(name = "id_uso_puntos_detalle")
    @Basic (optional = false)
    @GeneratedValue(generator = "uso_puntos_detalle_id_seq",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "uso_puntos_detalle_id_seq", sequenceName = "uso_puntos_detalle_id_seq", allocationSize = 0)
    private Integer id_uso_puntos_detalle;

    @Column(name = "puntaje_utilizado")
    @Basic (optional = false)
    private Integer puntajeUtilizado;

    @JoinColumn(name = "id_uso_puntos_cabecera", referencedColumnName = "id_uso_puntos_cabecera")
    @ManyToOne(optional = false)
    private Usopuntoscabecera usopuntoscabecera;

    @JoinColumn(name = "id_bolsa_puntos", referencedColumnName = "id_bolsa_puntos")
    @ManyToOne(optional = false)
    private Bolsapuntos bolsapuntos;

    public Usopuntosdetalle() {
    }

    public Integer getId_uso_puntos_detalle() {
        return id_uso_puntos_detalle;
    }

    public void setId_uso_puntos_detalle(Integer id_uso_puntos_detalle) {
        this.id_uso_puntos_detalle = id_uso_puntos_detalle;
    }

    public Integer getPuntajeUtilizado() {
        return puntajeUtilizado;
    }

    public void setPuntajeUtilizado(Integer puntajeUtilizado) {
        this.puntajeUtilizado = puntajeUtilizado;
    }

    public Usopuntoscabecera getUsopuntoscabecera() {
        return usopuntoscabecera;
    }

    public void setUsopuntoscabecera(Usopuntoscabecera usopuntoscabecera) {
        this.usopuntoscabecera = usopuntoscabecera;
    }

    public Bolsapuntos getBolsapuntos() {
        return bolsapuntos;
    }

    public void setBolsapuntos(Bolsapuntos bolsapuntos) {
        this.bolsapuntos = bolsapuntos;
    }
}
