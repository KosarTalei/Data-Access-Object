package ir.ac.kntu;

import java.util.List;

/**
 * Save and load with json dataformat
 */
public class JSONPersonDAO implements PersonDAO {
    @Override
    public List<Person> getAllPersons() {
        return null;
    }

    @Override
    public void saveAllPersons(List<Person> list) {
        //same as before but here use json format
    }
}
