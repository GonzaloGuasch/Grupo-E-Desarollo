package ar.edu.unq.desapp.grupoE.backEnddesappapi.mocks;

public class ProyectoMock {

    public Integer recibirDonancion(Integer cantidadDeDinero){
        if(cantidadDeDinero < 1000){
            return 0;
        }else{
            return cantidadDeDinero;
        }
    }
}
