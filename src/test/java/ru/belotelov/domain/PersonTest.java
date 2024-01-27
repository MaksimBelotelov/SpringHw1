package ru.belotelov.domain;

import junit.framework.TestCase;
import org.junit.Test;

public class PersonTest extends TestCase {
    public void testTestToString() {
        Person person = new Person("Иван", "Иванов", 20);
        String expected = "Person[\nFirst name=Иван,\nLast name=Иванов,\nAge=20]";
        assertEquals(expected, person.toString());
    }

    public void testTestEquals() {
        Person p1 = new Person("Иван", "Иванов", 21);
        Person p2 = new Person("Иван", "Иванов", 21);
        Person p11 = p1;
        Person p3 = new Person("Петр", "Иванов", 21);
        Person p4 = new Person("Иван", "Петров", 21);
        Person p5 = new Person("Иван", "Иванов", 22);

        assertTrue(p1.equals(p11));
        assertTrue(p1.equals(p2));
        assertFalse(p1.equals(p3));
        assertFalse(p1.equals(p4));
        assertFalse(p1.equals(p5));
    }

    public void testTestHashCode() {
        Person p1 = new Person("Иван", "Иванов", 20);
        Person p2 = new Person("Иван", "Иванов", 20);

        assertEquals(p1.hashCode(), p2.hashCode());
    }
}