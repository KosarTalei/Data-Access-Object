package ir.ac.kntu.dao;

import ir.ac.kntu.model.Person;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Save and load with json dataformat
 */
public class JSONPersonDAO implements PersonDAO {

    private final String sourceFileName;

    public JSONPersonDAO(String sourceFileName) {
        this.sourceFileName = sourceFileName;
    }

    @Override
    public List<Person> getAllPersons() throws Exception {
        String sCurrentLine;
        List<Person> personList = new ArrayList<>();
        try {
            File file = new File(sourceFileName);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            JSONObject jsonObject = (JSONObject) readJsonSimpleDemo(sourceFileName);
            while ((sCurrentLine = bufferedReader.readLine()) != null) {
                Person person = new Person(
                    (String) jsonObject.get("first name"),
                    (String) jsonObject.get("last name"),
                    Integer.valueOf(jsonObject.get("age").toString()));
                personList.add(person);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return personList;
    }

    public static Object readJsonSimpleDemo(String filename) throws Exception {
        FileReader reader = new FileReader(filename);
        JSONParser jsonParser = new JSONParser();
        return jsonParser.parse(reader);
    }

    @Override
    public void saveAllPersons(List<Person> list) throws FileNotFoundException {
        try {
            JSONObject sampleObject = new JSONObject();
            for (Person person : list) {
                sampleObject.put("first name", person.getFirstName());
                sampleObject.put("last name", person.getLastName());
                sampleObject.put("age", person.getAge());
            }
            JSONArray messages = new JSONArray();
            messages.add("saved Persons!");
            sampleObject.put("messages", messages);
            Files.write(Paths.get(sourceFileName), sampleObject.toJSONString().getBytes());
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
