package ir.ac.kntu.dao;
import ir.ac.kntu.model.Person;

import java.io.FileNotFoundException;
import java.util.List;

public interface PersonDAO {
    List<Person> getAllPersons() throws Exception;
    void saveAllPersons(List<Person> list) throws FileNotFoundException;
}
