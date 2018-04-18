package rest;

import dao.HomeDao;
import dao.PersonDao;
import domain.Home;
import domain.Person;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/person")
public class PersonWebService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAllPersons() {
        return PersonDao.getPersons();
    }

    @GET
    @Path("search/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Person findById(@PathParam("id") int id) {
        return PersonDao.getPersonById(id);
    }

    @PUT
    @Path("create")
    @Produces({ MediaType.APPLICATION_JSON })
    public Boolean createPerson(String jsonStringPerson) {
        List<Home> residences = new ArrayList<Home>();

        JSONObject jsonPerson = new JSONObject(jsonStringPerson);
        JSONArray jsonResidences = jsonPerson.getJSONArray("homesChecked");
        for(int i = 0; i < jsonResidences.length(); i++){
            Home h = HomeDao.getHomeById(jsonResidences.getJSONObject(i).getInt("idHome"));
            residences.add(h);
        }
        Person person = new Person();
        person.setFirstname(jsonPerson.getString("firstname"));
        person.setLastname(jsonPerson.getString("lastname"));
        person.setEmail(jsonPerson.getString("email"));
        person.setResidences(residences);
        return PersonDao.createPerson(person);
    }
}
