import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Application
{
   
    
    public static void main(String args[]){
        JFXPanel panel = new JFXPanel();
        Platform.runLater(() -> start());
    }
    
private static void start() 
    {
        try
        {         


            FXMLLoader loader = new FXMLLoader(Application.class.getResource("PrimaryScene.fxml"));


            Stage stage = new Stage();
            stage.setTitle("PrimaryScene.fxml");
            stage.setScene(new Scene(loader.load()));
            stage.show();           

            SceneController controller = loader.getController();
            controller.prepareStageEvents(stage);
        }
        catch (Exception ex) 
        {
            System.out.println(ex.getMessage());
            terminate();
        }
    }

   
    public static void terminate()
    {
        System.out.println("Closing database connection and terminating application...");                                

       
        System.exit(0);
    }

}