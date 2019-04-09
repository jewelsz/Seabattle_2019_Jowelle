package REST;

import java.util.ArrayList;

import REST.Models.Player;
import com.google.gson.Gson;

public class RESTResponseHelper
{
    private static final Gson gson = new Gson();

    public static String getErrorResponseString()
    {
        ZeeslagResponse response = new ZeeslagResponse();
        response.setSuccess(false);
        String output = gson.toJson(response);
        System.out.println("[Server response] " + output);
        return output;
    }


    public static String getSinglePlayerResponse(Player playerFromLibrary)
    {
        ZeeslagResponse response = new ZeeslagResponse();
        response.setSuccess(true);
        Player player = new Player( playerFromLibrary.getName(), playerFromLibrary.getPassword());

        response.setPlayer(player);
        String output = gson.toJson(response);
        System.out.println("[Server response] " + output);
        return output;
    }

    public static String getSuccessResponse(boolean success)
    {
        ZeeslagResponse response = new ZeeslagResponse();
        response.setSuccess(success);
        String output = gson.toJson(response);
        System.out.println("[Server response] " + output);
        return output;
    }

}
