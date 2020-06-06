package ir.ac.kntu;

import java.util.List;

public interface PersonDAO {
    List<Person> getAllPersons();
    void saveAllPersons(List<Person> list);
}
