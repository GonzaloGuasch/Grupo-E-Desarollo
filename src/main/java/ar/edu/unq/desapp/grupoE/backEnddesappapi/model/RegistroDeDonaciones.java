package ar.edu.unq.desapp.grupoE.backEnddesappapi.model;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class RegistroDeDonaciones {
    private List<EntradaDeRegistroDeDonacion> registroDeDonaciones;


    public RegistroDeDonaciones(){
        this.registroDeDonaciones = new ArrayList<>();
    }

    private Integer darBonoSiEsLaSegundaDonacionDelMes(Month mesDeLaDonacion) {
        Integer montoDelBono = 0;
         for(EntradaDeRegistroDeDonacion entradaDeRegistroDeDonacion: this.registroDeDonaciones){
             if(entradaDeRegistroDeDonacion.esDeMes(mesDeLaDonacion)){
                 montoDelBono = 500;
             }
         }

        return montoDelBono;
    }
    public Integer registrarNuevaDonacion(String nombreDeProyectoADonar, Integer cantidadDeDineroADonar) {
        EntradaDeRegistroDeDonacion nuevaDonacion = new EntradaDeRegistroDeDonacion(nombreDeProyectoADonar, LocalDate.now(), cantidadDeDineroADonar);
        Integer bono =  this.darBonoSiEsLaSegundaDonacionDelMes(LocalDate.now().getMonth());
        this.registroDeDonaciones.add(nuevaDonacion);
        return bono;
    }


    public Integer cantidadDeRegistros() {
        return this.registroDeDonaciones.size();
    }
}
