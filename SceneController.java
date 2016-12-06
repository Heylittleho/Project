import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;
import java.util.List;

public class SceneController
{    
    
    private static Stage stage;     
    @FXML   private ListView mainListView;
    @FXML   private Button addButton;
    @FXML   private Button editButton;
    @FXML   private Button deleteButton;
    @FXML   private TextField searchTextField;
    @FXML   private Button searchButton;
    @FXML   private Button exitButton;

    public SceneController()          
    {
        System.out.println("Initialising controllers...");

               
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
            assert mainListView != null : "Can't find mainListView";
            assert addButton != null : "Can't find addButton";
            assert editButton != null : "Can't find editButton";
            assert deleteButton != null : "Can't find deleteButton";
            assert searchTextField != null : "Can't find searchTextField";
            assert searchButton != null : "Can't find searchButton";
            assert exitButton != null : "Can't find exitButton";
        }
        catch (AssertionError ae)
        {
            System.out.println("FXML assertion failure: " + ae.getMessage());
            Application.terminate();
        }           
    }

    
    public void prepareStageEvents(Stage stage)
    {
        System.out.println("Preparing stage events...");

      SceneController.stage = stage;

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                public void handle(WindowEvent we) {
                    System.out.println("Close button was clicked!");
                    Application.terminate();
                }
            });
    }       

   
    @FXML   void yesClicked()
    {
        System.out.println("Yes was clicked!");        
    }

    @FXML   void addClicked()
    {
        System.out.println("Add was clicked, opening secondary scene.");
        
      
        
        try
          
        {
            FXMLLoader loader= new FXMLLoader(Application.class.getResource("SecondScene.fxml"));
            
            Stage stage=new Stage();
            stage.setTitle(" Secondary Scene");
            stage.setScene(new Scene(loader.load()));
            stage.show();
            
            SceneController controller = loader.getController();
            controller.prepareStageEvents(stage);
            
        }
        catch (Exception ex)
        { System.out.println(ex.getMessage());
           
        }
    }

    @FXML   void editClicked()
    {
        System.out.println("Edit was clicked, opening secondary scene.");
    }

    @FXML   void deleteClicked()
    {
        System.out.println("Delete was clicked!");
        
    }

    @FXML   void goClicked()
    {
        System.out.println("Go was clicked - this feature is not yet implemented!");
    }

    @FXML   void exitClicked()
    {
        System.out.println("Exit was clicked!");        
        Application.terminate();        
    }

    
    @FXML   void listViewClicked()
    {
        System.out.println("List was clicked!");
      }

    

    }

