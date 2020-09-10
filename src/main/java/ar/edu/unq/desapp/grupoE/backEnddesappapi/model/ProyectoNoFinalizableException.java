package ar.edu.unq.desapp.grupoE.backEnddesappapi.model;

public class ProyectoNoFinalizableException extends RuntimeException{

    public ProyectoNoFinalizableException(String errorMessage) {
        super(errorMessage);
    }
}
