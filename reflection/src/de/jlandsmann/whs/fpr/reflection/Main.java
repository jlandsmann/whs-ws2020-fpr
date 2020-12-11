package de.jlandsmann.whs.fpr.reflection;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Bitte geben Sie einen Klassennamen ein:");
            String className = scanner.next();
            try {
                final var target = Class.forName(className.trim());
                printClass(target);
            } catch (ClassNotFoundException e) {
                System.out.println("Klasse nicht gefunden.");
            }
        }
    }

    private static <T> void printClass(Class<T> target) {
        printClassHeader(target);
        System.out.println("\n");
        printFields(target);
        System.out.println("\n");
        printConstructors(target);
        System.out.println("\n");
        printMethods(target);
        printClassFooter(target);

    }

    private static <T> void printClassHeader(Class<T> target) {
        String modifiers = Modifier.toString(target.getModifiers());
        System.out.printf("%s class %s", modifiers, target.getName());
        final var superClass = target.getSuperclass();
        if (superClass != null) {
            System.out.printf(" extends %s", superClass.getName());
        }
        System.out.printf(" { %n");
    }

    private static <T> void printFields(Class<T> target) {
        Arrays.stream(target.getDeclaredFields())
            .sorted(Comparator.comparing(field -> Modifier.isStatic(field.getModifiers()), Boolean::compare))
            .forEach(Main::printField);
        ;
    }

    private static void printField(Field field) {
        String modifiers = Modifier.toString(field.getModifiers());
        String type = field.getType().getName();
        String name = field.getName();
        System.out.printf("    %s %s %s; %n", modifiers, type, name);

    }

    private static <T> void printConstructors(Class<T> target) {
        Arrays.stream(target.getDeclaredConstructors())
            .sorted(Comparator.comparingInt(Constructor::getParameterCount))
            .forEach(Main::printConstructor);
        ;
    }

    private static <T> void printConstructor(Constructor<T> constructor) {
        String modifiers = Modifier.toString(constructor.getModifiers());
        String name = constructor.getName();
        System.out.printf("    %s %s(", modifiers, name);
        printParameters(constructor.getParameters());
        System.out.printf("); %n");
    }

    private static <T> void printMethods(Class<T> target) {
        Arrays.stream(target.getDeclaredMethods())
            .forEach(Main::printMethod);
        ;
    }

    private static void printMethod(Method method) {
        String modifiers = Modifier.toString(method.getModifiers());
        String name = method.getName();
        System.out.printf("    %s %s(", modifiers, name);
        printParameters(method.getParameters());
        System.out.printf("); %n");
    }

    private static void printParameters(Parameter[] parameters) {
        for (int i = 0; i < parameters.length; i++) {
            printParameter(parameters[i]);
            if (i + 1 < parameters.length) {
                System.out.print(", ");
            }
        }
    }

    private static void printParameter(Parameter parameter) {
        String type = parameter.getType().getName();
        String name = parameter.getName();
        System.out.printf("%s %s", type, name);
    }

    private static <T> void printClassFooter(Class<T> target) {
        System.out.println("}");
    }
}
