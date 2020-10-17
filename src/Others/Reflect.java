package Others;

import java.lang.reflect.Field;

public class Reflect {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException {

        Field field = Class.forName("Others.ReflectTest").getDeclaredField("testString");
        field.setAccessible(true);
        ReflectTest reflectTest = new ReflectTest();
        System.out.println(field.getType().toString());
        System.out.println(field.getName());
        System.out.println(field.getModifiers());

        Object s = field.get(reflectTest);
        System.out.println(s);
    }
}
