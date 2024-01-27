package ru.belotelov;

import com.google.gson.Gson;
import ru.belotelov.domain.Person;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class App
{
    public static void main( String[] args ) {
        Person person = new Person("Максим", "Белотелов", 34);
        Gson gson = new Gson();

        try (FileWriter fileWriter = new FileWriter("data.txt")) {
            System.out.println("Сериализуемый объект: \n" + person.toString());
            fileWriter.write(gson.toJson(person));
        }
        catch (IOException e) {
            System.out.println("Не могу открыть/создать файл data.txt для записи");
        }

        try (FileReader fileReader = new FileReader("data.txt")) {
            Person deserializedPerson;
            deserializedPerson = gson.fromJson(fileReader, Person.class);
            System.out.println("Десериализованный объект: \n" + deserializedPerson);

            System.out.println("Исходный объект равен десериализованному: " + person.equals(deserializedPerson));
        }
        catch (IOException e) {
            System.out.println("Не могу открыть файл data.txt для чтения");
        }
    }
}
