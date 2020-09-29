package ar.edu.unq.desapp.grupoE.backEnddesappapi.model.exceptions;

public class ProjectNotFinalizableException extends RuntimeException{

    public ProjectNotFinalizableException(String errorMessage) {
        super(errorMessage);
    }
}
