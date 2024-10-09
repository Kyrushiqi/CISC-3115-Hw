// DO NOT MODIFY THIS FILE.

public class IntStatisticianTest {
    public static void main(String[] args) {
        IntStatistician statistician = new IntStatistician();
        statistician.record(8);
        statistician.record(9);
        statistician.record(3);
        statistician.record(8);
        statistician.record(4);
        System.out.println("After recording 8, 9, 3, 8, and 4:");
        print(statistician);

        statistician.record(10);
        System.out.println("After recording 10:");
        print(statistician);

        statistician.record(0);
        System.out.println("After recording 0:");
        print(statistician);

        IntStatistician statistician2 = new IntStatistician();
        System.out.println("New IntStatistician:");
        print(statistician2);

        System.out.println("There are no more than four fields: " + testMaxFourFields());
        System.out.println("All fields are private and of type int: " + testAllFieldsPrivate());
    }

    private static void print(IntStatistician statistician) {
        System.out.println("count = "   + statistician.count());
        System.out.println("sum = "     + statistician.sum());
        System.out.println("average = " + statistician.average());
        System.out.println("min = "     + statistician.min());
        System.out.println("max = "     + statistician.max());
        System.out.println();
    }

    // You do not have to understand this method. It uses a Java feature called "reflection."
    private static boolean testMaxFourFields() {
        return IntStatistician.class.getDeclaredFields().length <= 4;
    }

    // You do not have to understand this method. It uses a Java feature called "reflection."
    private static boolean testAllFieldsPrivate() {
        Class<IntStatistician> clazz = IntStatistician.class;
        java.lang.reflect.Field[] fields = clazz.getDeclaredFields();

        for (java.lang.reflect.Field field : fields) {
            if (!field.getType().equals(int.class) || !java.lang.reflect.Modifier.isPrivate(field.getModifiers())) {
                return false;
            }
        }

        return true;
    }
}
