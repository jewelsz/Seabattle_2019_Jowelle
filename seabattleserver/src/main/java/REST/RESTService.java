package REST;

import REST.Models.Player;
import javax.ws.rs.core.Response;
import javax.ws.rs.*;


@Path("/zeeslagRegister")
public class RESTService
{
    @POST
    @Path("/player")
    @Consumes("application/json")
    @Produces("application/json")
    public Response addPlayer(Player player) {

        System.out.println("[Server addPlayer]");

        // Check request
        if (player == null) {
            // Client error 400 - Bad Request
            return Response.status(400).entity(RESTResponseHelper.getErrorResponseString()).build();
        }

        Player newplayer = PlayerLibrary.getInstance().addPlayer(player);

        // Define response
        return Response.status(200).entity(RESTResponseHelper.getSinglePlayerResponse(newplayer)).build();
    }


}
