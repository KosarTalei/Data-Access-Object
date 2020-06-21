package ir.ac.kntu.dao;

import ir.ac.kntu.model.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PlainTextPersonDAO implements PersonDAO {
    private final String sourceFileName;

    public PlainTextPersonDAO(String sourceFileName) {
        this.sourceFileName = sourceFileName;
    }

    @Override
    public List<Person> getAllPersons() {
        List<Person> personList = new ArrayList<>();
        File file = new File(sourceFileName);
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String firstName = bufferedReader.readLine();
                String lastName = bufferedReader.readLine();
                int age = bufferedReader.read();

                Person person = new Person(firstName,lastName,age);
                personList.add(person);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return personList;
    }

    @Override
    public void saveAllPersons(List<Person> list) {
        File file = new File(sourceFileName);
        try(BufferedWriter bufferedReader = new BufferedWriter(new FileWriter(file))){
            bufferedReader.write("Test");
            for(Person person : list){
                bufferedReader.write(person.getFirstName());
                bufferedReader.newLine();
                bufferedReader.write(person.getLastName());
                bufferedReader.newLine();
                bufferedReader.write(person.getAge());
                bufferedReader.newLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
