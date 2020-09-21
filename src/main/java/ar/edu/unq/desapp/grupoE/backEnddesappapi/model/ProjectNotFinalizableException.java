package ar.edu.unq.desapp.grupoE.backEnddesappapi.model;

public class ProjectNotFinalizableException extends RuntimeException{

    public ProjectNotFinalizableException(String errorMessage) {
        super(errorMessage);
    }
}
