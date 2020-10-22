package py.com.progweb.fidelizacionclientes.model;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name ="cliente")
public class Cliente {

    @Id
    @Column(name = "id_cliente")
    @Basic(optional = false)
    @GeneratedValue(generator = "clienteSec", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "clienteSec", sequenceName = "cliente_id_seq", allocationSize = 0)
    private Integer id_cliente;


    @Column(name = "nombre", length = 20)
    @Basic(optional = false)
    private String nombre;

    @Column(name = "apellido", length = 20)
    @Basic(optional = false)
    private String apellido;

    @Column(name = "numero_documento")
    @Basic(optional = false)
    private Integer numeroDocumento;

    @Column(name = "tipo_documento", length = 30)
    @Basic(optional = false)
    private String tipoDocumento;

    @Column(name = "nacionalidad", length = 30)
    @Basic(optional = false)
    private String nacionalidad;

    @Column(name = "email", length = 30)
    @Basic(optional = false)
    private String email;

    @Column(name = "telefono", length = 30)
    @Basic(optional = false)
    private String telefono;

    @Column(name = "fecha_nacimiento")
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;


    //lista de bolsa de puntos
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Bolsapuntos> listaBolsaPuntos;

    /*   //lista de uso de puntos cabecera
       @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
       @LazyCollection(LazyCollectionOption.FALSE)
       private List<Usopuntoscabecera> listaPuntosCab;
   */
    public Cliente(ClienteBuilder clienteBuilder) {

        this.id_cliente = clienteBuilder.id_cliente;
        this.nombre = clienteBuilder.nombre;
        this.apellido = clienteBuilder.apellido;
    }

    public Cliente() {

    }


    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(Integer numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }


    public List<Bolsapuntos> getListaBolsaPuntos() {
        return listaBolsaPuntos;
    }

    public void setListaBolsaPuntos(List<Bolsapuntos> listaBolsaPuntos) {
        this.listaBolsaPuntos = listaBolsaPuntos;
    }

  /*  public List<Usopuntoscabecera> getListaPuntosCab() {
        return listaPuntosCab;
    }

    public void setListaPuntosCab(List<Usopuntoscabecera> listaPuntosCab) {
        this.listaPuntosCab = listaPuntosCab;
    }
*/



    public static class ClienteBuilder {
        private Integer id_cliente;


        private String nombre;


        private String apellido;





        public ClienteBuilder() {}


        public ClienteBuilder(Integer id_cliente, String nombre, String apellido) {
            this.id_cliente = id_cliente;
            this.nombre = nombre;
            this.apellido = apellido;
        }

        public Integer getId_cliente() {
            return id_cliente;
        }

        public void setId_cliente(Integer id_cliente) {
            this.id_cliente = id_cliente;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }
        public Cliente build()
        {
            return new Cliente(this);
        }

    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id_cliente=" + id_cliente +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", numeroDocumento=" + numeroDocumento +
                ", tipoDocumento='" + tipoDocumento + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}
