package ressources;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

@Path("/pseudo")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class AuthentificationRessource {

    // Fonction d'authentification
    @POST
    @Path("/{user}")
    public Boolean seConnecter(@QueryParam("user") String user, String mdp){

        return false ; // 
    }

    @GET
    public String getPage(){
        return "Bienvenue au niveau du serveur de transaction" ;
    }

 
}
