package servlet;

import dao.PersonDao;
import domain.Person;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Pierre-Louis on 04/04/2017.
 */
@WebServlet(name="person",urlPatterns={"/person"})
public class PersonServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printer = new PrintWriter(resp.getOutputStream());
        JSONArray jsonLstPersons = new JSONArray();

        for(Person p : PersonDao.getPersons()){
            JSONObject jsonPerson = new JSONObject();
            jsonPerson.put("firstname",p.getFirstname());
            jsonPerson.put("lastname",p.getLastname());
            jsonPerson.put("email",p.getEmail());
            jsonLstPersons.put(jsonPerson);
        }

        printer.print(jsonLstPersons);
        printer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        PrintWriter out = resp.getWriter();

        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String email = req.getParameter("email");

        Person p = new Person();
        p.setEmail(email);
        p.setLastname(lastname);
        p.setFirstname(firstname);

        JSONObject jsonPerson = new JSONObject();

        if(PersonDao.createPerson(p)){
            jsonPerson.put("firstname",firstname);
            jsonPerson.put("lastname",lastname);
            jsonPerson.put("email",email);
            jsonPerson.put("Message","L'utilisateur a été créé");
        } else {
            jsonPerson.put("Message","L'utilisateur n'a pas été créé");
        }

        out.print(jsonPerson);
    }


}
