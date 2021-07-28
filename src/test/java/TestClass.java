import api.GetAllCharacters;
import api.GetAndPrintCharacterInfo;
import org.testng.annotations.Test;
import utils.PropertiesManager;
//import static io.restassured.path.json.JsonPath.given;
//import static org.hamcrest.*;




public class TestClass extends BaseTest{

    @Test
    public static void getCharacterInfoAndPrint(){
        System.out.println("Starting Get Character Info And Print Test");

        String characterName ="Walter+White";

        GetAndPrintCharacterInfo getAndPrintCharacterInfo = new GetAndPrintCharacterInfo(PropertiesManager.getProperty("baseURI"));
        getAndPrintCharacterInfo.setCharacterName(characterName);
        getAndPrintCharacterInfo.createRequest();
        getAndPrintCharacterInfo.executeRequest();
        getAndPrintCharacterInfo.validateResponse();
        getAndPrintCharacterInfo.printCharacterInformation();
    }

    @Test
    public static void getAllCharacters(){
        System.out.println("\nStarting Get All Characters Test");

        GetAllCharacters getAllCharacters = new GetAllCharacters(PropertiesManager.getProperty("baseURI"));

        getAllCharacters.createRequest();
        getAllCharacters.executeRequest();
        getAllCharacters.printAllCharacters();
    }

}
