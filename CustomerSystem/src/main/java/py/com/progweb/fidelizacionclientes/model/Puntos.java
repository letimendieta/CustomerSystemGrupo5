package py.com.progweb.fidelizacionclientes.model;

import py.com.progweb.fidelizacionclientes.util.interfaces.IPuntosComposicionInterfaz;
import py.com.progweb.fidelizacionclientes.util.interfaces.IPuntosInterfaz;
import py.com.progweb.fidelizacionclientes.util.interfaces.IStrategyUsarPuntos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name = "puntos")
public class Puntos implements IPuntosInterfaz, IStrategyUsarPuntos, IPuntosComposicionInterfaz {
    @Id
    @Column(name = "id_puntos")
    @Basic (optional = false)
    @GeneratedValue(generator = "puntos_id_seq",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "puntos_id_seq", sequenceName = "puntos_id_seq", allocationSize = 0)
    private Integer id_puntos;

    @Column(name = "concepto", length = 45)
    @Basic (optional = false)
    private String concepto;

    @Column(name = "puntos_requeridos")
    @Basic (optional = false)
    private Integer puntosRequeridos;

    public Puntos() {
    }

    public Integer getId_puntos() {
        return id_puntos;
    }

    public void setId_puntos(Integer id_puntos) {
        this.id_puntos = id_puntos;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Integer getPuntosRequeridos() {
        return puntosRequeridos;
    }

    public void setPuntosRequeridos(Integer puntosRequeridos) {
        this.puntosRequeridos = puntosRequeridos;
    }

    @Override
    public String usarPuntos(Integer puntos) {
        int puntosutilizados= getPuntosRequeridos() - puntos;
        return "Puntos utilizados" + puntosutilizados;
    }

    @Override
    public void mostrarDetallePuntos() {
        System.out.println("Puntos : " + id_puntos+" " + concepto +" " + puntosRequeridos);
    }
}
