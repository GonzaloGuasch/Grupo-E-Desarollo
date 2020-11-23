package ar.edu.unq.desapp.grupoE.backEnddesappapi.architectureTest;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "ar.edu.unq.desapp.grupoE.backEnddesappapi")
public class ArchitectureTest {

    @ArchTest
    public static final ArchRule class_and_package_contaiment_checks = classes()
            .that().haveSimpleNameStartingWith("LocalityService")
            .should().resideInAPackage("ar.edu.unq.desapp.grupoE.backEnddesappapi.service");

}
