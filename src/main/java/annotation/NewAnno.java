package annotation;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NewAnno {
    public String name() default "fieldName";

    public String setFuncName() default "setField";

    public String getFuncName() default "getField";

    public boolean defaultDBValue() default false;
}
