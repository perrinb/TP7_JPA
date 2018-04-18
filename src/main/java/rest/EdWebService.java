package rest;

import dao.ElectronicDeviceDao;
import dao.HomeDao;
import domain.ElectronicDevice;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/electronicdevice")
public class EdWebService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ElectronicDevice> getAllEd() {
        return ElectronicDeviceDao.getHeaters();
    }

    @GET
    @Path("search/{id}")
    @Produces({ MediaType.APPLICATION_JSON })
    public ElectronicDevice findById(@PathParam("id") int id) {
        return ElectronicDeviceDao.getHeaterById(id);
    }

    @PUT
    @Path("create")
    @Produces({ MediaType.APPLICATION_JSON })
    public Boolean createEd(String jsonStringEd) {
        JSONObject jsonEd = new JSONObject(jsonStringEd);
        ElectronicDevice ed = new ElectronicDevice();
        ed.setConsomation(jsonEd.getInt("consumption"));
        ed.setFonction(jsonEd.getString("fonction"));
        ed.setResidence(HomeDao.getHomeById(jsonEd.getInt("idHome")));
        return ElectronicDeviceDao.createElectronicDevice(ed);
    }
}
