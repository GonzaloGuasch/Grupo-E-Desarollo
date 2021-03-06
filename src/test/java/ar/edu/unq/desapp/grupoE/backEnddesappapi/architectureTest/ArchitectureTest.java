package ar.edu.unq.desapp.grupoE.backEnddesappapi.architectureTest;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.beans.factory.annotation.Autowired;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;

@AnalyzeClasses(packages = "ar.edu.unq.desapp.grupoE.backEnddesappapi")
public class ArchitectureTest {

    @ArchTest
    public static final ArchRule class_and_package_contaiment_checks = classes()
            .that().haveSimpleNameStartingWith("Service")
            .should().resideInAPackage("ar.edu.unq.desapp.grupoE.backEnddesappapi.service");


    @ArchTest
    public static final ArchRule code_units_in_service_layer_should_be_autowired =
            noCodeUnits().that().areDeclaredInClassesThat().resideInAPackage("ar.edu.unq.desapp.grupoE.backEnddesappapi.service")
                    .should().beMetaAnnotatedWith(Autowired.class);

    @ArchTest
    public static final ArchRule services_should_not_access_controllers =
            noClasses().that().resideInAPackage("..ar.edu.unq.desapp.grupoE.backEnddesappapi.service")
                    .should().accessClassesThat().resideInAPackage("..ar.edu.desapp.grupoE.backEnddesappapi.webservice");

    @ArchTest
    public static final ArchRule repository_only_accesed_by_service = classes()
            .that().resideInAPackage("..repository..")
                    .should().onlyBeAccessed().byAnyPackage("..service","..repository..");

    @ArchTest
    public static final ArchRule should_package_model_independent_of_other_packages = noClasses()
            .that().resideInAPackage("..model..")
            .should().dependOnClassesThat().resideInAnyPackage("..repository..","..service..");

}
