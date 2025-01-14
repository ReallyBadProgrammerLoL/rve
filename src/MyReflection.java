import java.lang.reflect.Field;

public class MyReflection {
    public static double sumNumericFields(Object obj) {
        double sum = 0;

        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if (field.getType() == int.class) {
                    sum += field.getInt(obj);
                } else if (field.getType() == double.class) {
                    sum += field.getDouble(obj);
                } else if (field.getType() == float.class) {
                    sum += field.getFloat(obj);
                }
            } catch (IllegalAccessException e) {
                System.out.println(e.getMessage());
            }
        }

        return sum;
    }
}

