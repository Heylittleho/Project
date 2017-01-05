import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.control.TreeTableView;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;
import java.util.List;

public class SceneController2
{
    private static Stage stage;     
    
    @FXML private TreeTableView TreeTableView ;
    
    public SceneController2()
    { System.out.println("Initialising controllers...");
      if (stage != null)
      {
          System.out.println("Error, duplicate controller - terminating application!");
          System.exit(-1);
      }        
    }
    @FXML   void initialize()           
    {     
        System.out.println("Asserting controls...");
        try
        {
        }
        catch (AssertionError ae)
        {
            System.out.println("FXML assertion failure: " + ae.getMessage());
            Application.terminate();
        }  
    }
}