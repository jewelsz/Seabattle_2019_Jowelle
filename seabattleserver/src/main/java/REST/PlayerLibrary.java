package REST;

import REST.Models.Player;

import java.util.HashMap;
import java.util.Map;

public class PlayerLibrary
{
    private final Map<String, Player> savedPlayers;
    // Instance of pet store (singleton pattern)
    private static PlayerLibrary instance;

    public PlayerLibrary()
    {
        savedPlayers = new HashMap<>();
    }

    public static PlayerLibrary getInstance() {
        if (instance == null) {
            instance = new PlayerLibrary();
        }
        return instance;
    }

    public Player getPokemon(String name)
    {
        return savedPlayers.get(name);
    }


    public Player addPlayer(Player pokemon) {

        savedPlayers.put(pokemon.getName(),pokemon);

        // Return the new pet
        return pokemon;
    }

}
