package EmployeeObjects;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface EmployeeType {
String type();
}

@Retention(RetentionPolicy.RUNTIME)
@interface WeeklyPayCalculator{
}

@Retention(RetentionPolicy.RUNTIME)
@interface PayRate{
    String type();
}
