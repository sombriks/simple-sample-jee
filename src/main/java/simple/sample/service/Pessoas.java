package simple.sample.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import simple.sample.model.Pessoa;

@Path("/pessoas")
public class Pessoas {
  
  @PersistenceContext
  private EntityManager em;

  @GET
  @Path("/hello")
  public String hello() { return "hello!"; }

  @GET
  @Path("/add")
  @Produces("application/json")
  public Pessoa add(@QueryParam("nome") String nome) {
    Pessoa p = new Pessoa();
    p.setNome(nome+""+System.currentTimeMillis());
    em.persist(p);
    return p;
  }
}
