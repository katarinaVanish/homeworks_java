package org.knit.lab9;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Validator {
    public static void validate(Object obj) throws IllegalAccessException {
        List<String> errors = new ArrayList<>();

        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            //разрешает доступ к private переменным
            field.setAccessible(true);
            Object value = field.get(obj);

            // Проверка @NotNull
            if (field.isAnnotationPresent(NotNull.class) && value == null) {
                errors.add("Поле " + field.getName() + " не должно быть null.");
            }

            // Проверка @MaxLength
            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength maxLength = field.getAnnotation(MaxLength.class);
                if (value instanceof String && ((String) value).length() > maxLength.value()) {
                    errors.add("Поле " + field.getName() + " превышает максимальную длину " + maxLength.value() + ".");
                }
            }

            // Проверка @Min
            if (field.isAnnotationPresent(Min.class)) {
                Min min = field.getAnnotation(Min.class);
                if (value instanceof Integer && (Integer) value < min.value()) {
                    errors.add("Поле " + field.getName() + " должно быть не меньше " + min.value() + ".");
                }
            }
        }

        if (!errors.isEmpty()){
            for (String error : errors){
                System.out.println(error);
            }
        } else {
            System.out.println("Все поля валидны.");
        }
    }
}
