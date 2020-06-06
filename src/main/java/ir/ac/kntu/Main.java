package ir.ac.kntu;

import org.json.simple.JSONObject;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> personList = new LinkedList<>();
        Person person1 = new Person("Test","Test",21);
        Person person2 = new Person("Fariborz","Fariborzi",23);

        PersonDAO personDAO = new PlainTextPersonDAO("test.txt");
        personDAO.saveAllPersons(personList);
        //go and check the content of the file
        personDAO.getAllPersons();


        //test JSON

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","Faribors");
        jsonObject.put("lastname","Fariborzian");
        jsonObject.put("age",24);
        String json = jsonObject.toJSONString();
        System.out.println("json = " + json);

    }
}
