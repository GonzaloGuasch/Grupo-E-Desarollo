package ar.edu.unq.desapp.grupoE.backEnddesappapi.aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Aspect
@Component
public class LogExecutionTimeAspectAnnotation {
    private long start;
    static Logger logger = LoggerFactory.getLogger(LogExecutionTimeAspectAnnotation.class);
    private Object[] args;
    private Signature tipoRetornoYNombreMetodo;

    @Pointcut("execution(* ar.edu.unq.desapp.grupoE.backEnddesappapi.webservice.*.*(..))")
    public void methodsStarterServicePointcut() {

    }

    @Before("methodsStarterServicePointcut()")
    public void beforeMethods(JoinPoint joinPoint) throws Throwable {
        this.tipoRetornoYNombreMetodo = joinPoint.getSignature();
        this.args = joinPoint.getArgs();
        this.start = System.currentTimeMillis();
    }

    @After("methodsStarterServicePointcut()")
    public void afterMethods() throws Throwable {
        logger.info("*****************************************************");
        logger.info("*▌▌▌▌▌▌▌▌▌▌▌ INFORMACION DE EJECUCION ▌▌▌▌▌▌▌▌▌▌▌");
        logger.info("*▌▌▌▌▌▌▌▌▌▌▌ Fecha de ejecucion del metodo: " + (new Timestamp(System.currentTimeMillis())) + " ▌▌▌▌▌▌▌▌▌▌▌");
        long timeExcecuted =  System.currentTimeMillis() - this.start;
        logger.info("*▌▌▌▌▌▌▌▌▌▌▌" + "El metodo tardo: "+ timeExcecuted +  " ms ▌▌▌▌▌▌▌▌▌▌▌▌");
        logger.info("*▌▌▌▌▌▌▌▌▌▌▌ retorna ---->" + this.tipoRetornoYNombreMetodo + "<---- EL nombre del metodo llamado ▌▌▌▌▌▌▌▌▌▌▌");
        logger.info("*↓↓↓↓↓↓↓↓↓↓↓ ARGUMENTOS EN ORDEN DE USO ↓↓↓↓↓↓↓↓↓↓↓");
        if (this.args.length == 0){
            logger.info("*▌▌▌▌▌▌▌▌▌▌▌   Este metodo no usa parametros   ▌▌▌▌▌▌▌▌▌▌▌");
        }
        for (Object argumnet: this.args){
            logger.info("*▌▌▌▌▌▌▌▌▌▌▌   " + argumnet + "   ▌▌▌▌▌▌▌▌▌▌▌");
        }
        logger.info("*↑↑↑↑↑↑↑↑↑↑↑ ARGUMENTOS EN ORDEN DE USO ↑↑↑↑↑↑↑↑↑↑↑");
        logger.info("*****************************************************");
    }

}
