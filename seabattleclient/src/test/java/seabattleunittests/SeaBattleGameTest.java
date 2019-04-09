/*
 * Sea Battle Start project.
 */
package seabattleunittests;

import Models.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seabattlegame.ISeaBattleGame;
import seabattlegame.SeaBattleGame;
import seabattlegui.SquareState;

import java.security.PublicKey;

import static org.junit.Assert.assertEquals;

/**
 * Unit tests for Sea Battle game.
 * @author Nico Kuijpers
 */
public class SeaBattleGameTest {
    
    private ISeaBattleGame game;
    private MockSeaBattleApplication applicationPlayer;
    private MockSeaBattleApplication applicationOpponent;
    
    public SeaBattleGameTest() {
    }

    @BeforeEach
    public void setUp() {
        
        // Create the Sea Battle game
        game = new SeaBattleGame();
        
        // Create mock Sea Battle GUI for player
        applicationPlayer = new MockSeaBattleApplication();
        
        // Create mock Sea Battle GUI for opponent
        applicationOpponent = new MockSeaBattleApplication();
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Example test for method registerPlayerName(). 
     * Test whether an IllegalArgumentException is thrown when parameter 
     * name is null.
     * @author Nico Kuijpers
     */
    @Test() // expected=IllegalArgumentException.class
    public void testRegisterPlayerNameNull() {

        // Register player with parameter name null in single-player mode
        String name = null;
        String password = "password";
        boolean singlePlayerMode = true;
        game.registerPlayer(name, password, applicationPlayer, singlePlayerMode);
    }
    
    /**
     * Example test for method placeShipsAutomatically().
     * Test whether the correct number of squares contain a ship in the
     * ocean area of the player's application.
     * @Author Nico Kuijpers
     */
    @Test
    public void testPlaceShipsAutomatically() {
        
        // Register player in single-player mode
        game.registerPlayer("Some Name", "Some Password", applicationPlayer, true);
        
        // Place ships automatically
        int playerNr = applicationPlayer.getPlayerNumber();
        game.placeShipsAutomatically(playerNr);
        
        // Count number of squares where ships are placed in player's application
        int expectedResult = 5 + 4 + 3 + 3 + 2;
        int actualResult = applicationPlayer.numberSquaresPlayerWithSquareState(SquareState.SHIP);
        assertEquals("Wrong number of squares where ships are placed",expectedResult,actualResult);
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test.


    //Speler voert een naam in die hij zelf wilt: TestNaam123
    //Speler voert een naam in die hij zelf wilt: TestWachtwoord123
    //Verwachte resultaat: Naam is TestNaam123, wachtwoord TestWachtwoord123
    //Speler moet nu geregistreerd zijn.
    @Test
    public void registrationTest()
    {
        String name = "TestNaam123";
        String password = "TestWachtwoord123";

        Player player = new Player(name, password);

        game.registerPlayer(name, password, applicationPlayer, true);

        //Check of registratie gelukt is. bool?
    }

    //Speler voert zijn naam en wachtwoord in: TestNaam123, TestWachtwoord123.
    //Verwachte resultaat: Inlog is goedgekeurd.
    @Test
    public void correctLoginTest()
    {
        //game.playerLogin(name, passwaord)
    }

    //Speler voert zijn naam en  een verkeerd wachtwoord in: TestNaam123, foutwachtwoord.
    //Verwachte resultaat: Inlog krijgt een melding dat het inloggen niet is gelukt.

    //Speler voert een verkeerde naam en  een wachtwoord in: foutenaam, TestWachtwoord123.
    //Verwachte resultaat: Inlog krijgt een melding dat het inloggen niet is gelukt.
    @Test
    public void wrongLoginTest()
    {
        //Verkeerde gebruikersnaam

        //verkeerd wachtwoord
    }

    //Plaats schepen
    //Speler druk op “Ready”
    //Verwacht resultaat:
    //Melding: “Schepen zijn geplaatst. Wachten op tegenspeler.”
    @Test
    public void SchepenPlaatsenTest()
    {
        //Speler plaatst een “minesweeper” schip op de cellen: 5,6 (horizontaal).


        //Speler plaatst een “cruiser” schip op de cellen: 1,2,3 (horizontaal).


        //Speler plaatst een “AircraftCarrier” schip op de cellen:  10,20,30,40,50
        //(verticaal).


        //Speler plaatst een “BattleShip” schip op de cellen:  91,92,93
        //(verticaal).


        //Speler plaatst een “Submarine” schip op de cellen:  71,72,73
        //(verticaal).


    }

    //Speler verplaatst een “BattleShip” schip op de cellen:  91,92,93 naar: 65,65,67
    //(verticaal).
    //
    //Verwacht resultaat:
    //Schip is verplaatst zonder enige overlapping.
    @Test
    public void schipVerplaatsenTest()
    {

    }

    //Speler verwijderd schepen
    //en plaatst nieuwe
    //Verwacht resultaat:
    //Schepen zijn geplaatst zonder enige overlapping.
    @Test
    public void schipVerwijderenTest()
    {
        //Verwijder:
        //“Submarine”,
        //“BattleShip”,
        //“AircraftCarrier”
        //
        //En plaatst de submarine op cellen:70,71,72.
        //En plaatst de BattleShip op cellen:75,76,77.
        //
        //En plaatst de AircraftCarrier op cellen:9,19,29,39,49.
        //
    }

    //Speler druk op ready na het plaatsen van de 5 schepen op het raster
    //
    //Verwacht resultaat:
    //Melding: “Schepen zijn geplaatst. Wachten op tegenspeler.”
    @Test
    public void klaarMetPlaatsenTest()
    {

    }

    //Het is de beurt van de speler. De speler schiet op cel: 66.
    //Verwacht resultaat:
    //Cel: 66 wordt blauw. Schot is gemist.
    @Test
    public void schotTest()
    {
        //Schot mist
        //De speler schiet op cel: 66.


        //Schot Raakt
        //De speler schiet op cel: 70.
    }

}

