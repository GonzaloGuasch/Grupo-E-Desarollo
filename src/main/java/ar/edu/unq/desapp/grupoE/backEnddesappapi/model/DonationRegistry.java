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

    public Integer darBonoSiEsLaSegundaDonacionDelMes(Month mesDeLaDonacion) {
        Integer montoDelBono = 0;
         for(EntradaDeRegistroDeDonacion entradaDeRegistroDeDonacion: this.registroDeDonaciones){
             if(entradaDeRegistroDeDonacion.esDeMes(mesDeLaDonacion)){
                 montoDelBono = 500;
             }
         }

        return montoDelBono;
    }
    public void registrarNuevaDonacion(String nombreDeProyectoADonar, Integer cantidadDeDineroADonar) {
        EntradaDeRegistroDeDonacion nuevaDonacion = new EntradaDeRegistroDeDonacion(nombreDeProyectoADonar, LocalDate.now(), cantidadDeDineroADonar);
        this.registroDeDonaciones.add(nuevaDonacion);
    }


    public Integer cantidadDeRegistros() {
        return this.registroDeDonaciones.size();
    }
}
