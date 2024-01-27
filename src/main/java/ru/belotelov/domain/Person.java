package ru.belotelov.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        ToStringBuilder.setDefaultStyle(SHORT_PREFIX_STYLE);
        return new ToStringBuilder(this).append("\nFirst name", firstName)
                .append("\nLast name", lastName)
                .append("\nAge", age).toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj.getClass() != this.getClass()) return false;

        Person another = (Person)obj;

        return new EqualsBuilder()
                .append(firstName, another.getFirstName())
                .append(lastName, another.getLastName())
                .append(age, another.getAge())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(firstName).append(lastName)
                .append(age).toHashCode();
    }
}
