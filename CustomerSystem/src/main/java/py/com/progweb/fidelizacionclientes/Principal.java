package py.com.progweb.fidelizacionclientes;

import py.com.progweb.fidelizacionclientes.model.*;
import py.com.progweb.fidelizacionclientes.util.*;

import py.com.progweb.fidelizacionclientes.util.interfaces.IPuntosComposicionInterfaz;
import py.com.progweb.fidelizacionclientes.util.interfaces.IPuntosInterfaz;

import java.util.Calendar;
import java.util.Date;

public class Principal {

    public static void main(String[] args) throws CloneNotSupportedException {

        IPuntosInterfaz puntos = new Puntos();
        puntos.setId_puntos(3);
        puntos.setConcepto("vale de compras");
        puntos.setPuntosRequeridos(30);

        System.out.println("-----Prueba Pattern Adapter para puntos-----");
        System.out.println("Puntos: " + puntos.getId_puntos()+"--" + puntos.getConcepto() +"--"+ puntos.getPuntosRequeridos());

        IPuntosInterfaz puntosextra = new AdaptadorIPuntos();
        puntosextra.setId_puntos(20);
        puntosextra.setConcepto("compras de productos en promocion");
        puntosextra.setPuntosRequeridos(10);

        System.out.println("-----Prueba Pattern Adapter para puntosextra-----");
        System.out.println("Puntos extra: " + puntosextra.getId_puntos() +"--"+ puntosextra.getConcepto()+"--" + puntosextra.getPuntosRequeridos());

        System.out.println("-----Prueba Pattern Strategy-----");
        Puntos puntos2 = new Puntos();
        puntos2.setId_puntos(4);
        puntos2.setPuntosRequeridos(10);
        puntos2.usarPuntos(2);

        System.out.println("Prueba para puntos  " +  puntos2.usarPuntos(2));
        Puntosextra puntos3 = new Puntosextra();
        puntos3.establecerId_puntos(4);
        puntos3.establecerPuntosRequeridos(10);
        puntos3.usarPuntos(2);

        System.out.println("Prueba para puntosextra  " +  puntos3.usarPuntos(2));

        System.out.println("-----Prueba Pattern Null Object-----");

        AbstractPuntos p1 = DemoPuntosextra.getPuntosConcepto("vale de compras");
        AbstractPuntos p2 = DemoPuntosextra.getPuntosConcepto("promocionhalloween");
        AbstractPuntos p3 = DemoPuntosextra.getPuntosConcepto("promoweeknd");
        AbstractPuntos p4 = DemoPuntosextra.getPuntosConcepto("promonavidad");

        System.out.println("Prueba para puntos nulos Puntoextra 1\n");
        System.out.println(p1.verConcepto());
        System.out.println("Puntoextra 2\n");
        System.out.println(p2.verConcepto());
        System.out.println("Puntoextra 3\n");
        System.out.println(p3.verConcepto());
        System.out.println("Puntoextra 4\n");
        System.out.println(p4.verConcepto());


        System.out.println("-----Prueba Builder Pattern-----");
        Cliente cliente = new Cliente.ClienteBuilder(1,"Maria","Jara").build();
        System.out.println(cliente.toString());

        System.out.println("-----Prueba Prototype Pattern-----");
        Vencimiento vencimiento = new Vencimiento(1,new Date(),new Date(),2);
        Vencimiento vencimiento1 = (Vencimiento) vencimiento.clone();

        System.out.println(" Vencimiento original " + vencimiento);
        System.out.println(" Vencimiento clonado " + vencimiento1);

        System.out.println("-----Prueba Decorator Pattern-----");
        Asignacion a1 = new Asignacion();
        a1.establecerPorcentajeDescuento();
        System.out.println("\n---------");

         AsignacionDecorator a1decorator = new AsignacinPlusDecorator(a1);
        a1decorator.establecerPorcentajeDescuento();
        System.out.println("\n---------");

        System.out.println("-----Prueba State Pattern-----");
        Vencimiento vencimiento2 = new Vencimiento();
        vencimiento2.setFechaFinValidez(new Date());
        vencimiento2.yaVencio(vencimiento2);
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, 1);
        dt = c.getTime();
        Vencimiento vencimiento3 = new Vencimiento();
        vencimiento3.setFechaFinValidez(dt);
        System.out.println("Dia para vencimiento 3 " + dt );
        System.out.println("\n---------");

        System.out.println("-----Prueba Composite Pattern-----");
        Puntos puntos1 = new Puntos();
        puntos1.setId_puntos(1);
        puntos1.setConcepto("Promocion Fin de Semana");
        puntos1.setPuntosRequeridos(10);
        Puntos puntos4 = new Puntos();
        puntos4.setId_puntos(2);
        puntos4.setConcepto("Promocion Halloween");
        puntos4.setPuntosRequeridos(5);
        DetallePuntos detallePuntos = new DetallePuntos();
        detallePuntos.agregarPunto(puntos1);
        detallePuntos.agregarPunto(puntos4);

        Puntosextra puntosextra1 = new Puntosextra();
        puntosextra1.establecerId_puntos(3);
        puntosextra1.establecerConcepto("Promocion Happy Holiday");
        puntosextra1.establecerPuntosRequeridos(8);

        DetallePuntos detallePuntosextra = new DetallePuntos();
        detallePuntosextra.agregarPunto(puntosextra1);

        DetallePuntos getAllPuntos = new DetallePuntos();
        getAllPuntos.agregarPunto(detallePuntos);
        getAllPuntos.agregarPunto(detallePuntosextra);
        getAllPuntos.mostrarDetallePuntos();


    }
}