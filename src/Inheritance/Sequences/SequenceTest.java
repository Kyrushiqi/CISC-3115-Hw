package Inheritance.Sequences;

// DO NOT MODIFY THIS FILE.

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Random;

class SequenceImpl extends Sequence {
    public SequenceImpl() {
        super();
    }

    public SequenceImpl(int start) {
        super(start);
    }

    @Override
    public int next() {
        return current + 5;
    }
}

class SequenceImplRandom extends Sequence {
    private Random random;

    public SequenceImplRandom() {
        random = new Random(42);
    }

    @Override
    public int next() {
        return random.nextInt(10);
    }
}

public class SequenceTest {
    public static void main(String[] args) {
        ensureCurrentIsProtected();
        ensureCorrectMethodNext();

        Sequence sequence0 = new SequenceImpl();
        sequence0.printNext(3); // 1 1 1

        Sequence sequence1 = new SequenceImpl(1);
        sequence1.printNext(4); // 6 6 6 6

        Sequence sequence2 = new SequenceImplRandom();
        sequence2.printNext(5); // 0 3 8 4 0
    }

    // ensures that the Sequence class contains a field named "current" and that it is protected.
    private static void ensureCurrentIsProtected() {
        Class<?> clazz = Sequence.class;
        String fieldName = "current";

        try {
            Field field = clazz.getDeclaredField(fieldName);

            if (!Modifier.isProtected(field.getModifiers())) {
                System.out.println("Class " + clazz.getName() + " does not have a protected field named " + fieldName);
            }
        } catch (NoSuchFieldException e) {
            System.out.println("Class " + clazz.getName() + " does not have a field named " + fieldName);
        }
    }

    // ensures that the next() method of the Sequence class exists, is abstract, and has no parameters.
    private static void ensureCorrectMethodNext() {
        Class<?> clazz = Sequence.class;
        String methodName = "next";

        try {
            Method method = clazz.getDeclaredMethod(methodName);

            if (!Modifier.isAbstract(method.getModifiers())) {
                System.out.println("Method " + methodName + " in class " + clazz.getName() + " is not abstract.");
            }

            if (method.getParameterCount() != 0) {
                System.out.println("Method " + methodName + " in class " + clazz.getName() + " has parameters.");
            }
        } catch (NoSuchMethodException e) {
            System.out.println("Method " + methodName + " not found in class " + clazz.getName());
        }
    }
}

