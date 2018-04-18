package rest;

import dao.HeaterDao;
import dao.HomeDao;
import domain.Heater;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/heater")
public class HeaterWebService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Heater> getAllHeaters() {
        return HeaterDao.getHeaters();
    }

    @GET
    @Path("search/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Heater findById(@PathParam("id") int id) {
        return HeaterDao.getHeaterById(id);
    }

    @PUT
    @Path("create")
    @Produces({ MediaType.APPLICATION_JSON })
    public Boolean createHeater(String jsonStringHeater) {
        JSONObject jsonHeater = new JSONObject(jsonStringHeater);
        Heater heater = new Heater();
        heater.setPower(jsonHeater.getInt("power"));
        heater.setConsomation(jsonHeater.getInt("consomation"));
        heater.setResidence(HomeDao.getHomeById(jsonHeater.getInt("idHome")));
        return HeaterDao.createHeater(heater);
    }
}
