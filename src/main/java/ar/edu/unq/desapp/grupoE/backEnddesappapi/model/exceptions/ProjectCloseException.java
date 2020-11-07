package ar.edu.unq.desapp.grupoE.backEnddesappapi.model.exceptions;

public class ProjectCloseException extends RuntimeException{

    public ProjectCloseException(String errorMessage) {
        super(errorMessage);
    }
}
