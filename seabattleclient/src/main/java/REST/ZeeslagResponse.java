package REST;

import Models.Player;

import java.util.List;

public class ZeeslagResponse
{
    private boolean success;

    private List<Player> players;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<Player> getPlayer() {
        return players;
    }

    public void setPlayer(List<Player> player) {
        this.players = player;
    }

}
