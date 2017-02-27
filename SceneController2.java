import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;
import java.util.List;

public class SceneController2
{
    
    private Stage stage;     
    
    private SceneController parent ;
    
    //@FXML private TextField nameTextField;
    @FXML private Button saveButton;
    @FXML private Button cancelButton;
    
    private Clothes clothes;
    
    public SceneController2()
    
    { System.out.println("Initialising controllers...");
    }
    
    public void prepareStageEvents(Stage stage)
    { 
        System.out.println("Preparing stage events...");
        
        this.stage=stage;
         stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                public void handle(WindowEvent we) {
                    System.out.println("Close button was clicked!");
                    stage.close();
                }
            });
        }
    
    @FXML   void initialize()           
    {     
        System.out.println("Asserting controls...");
        try
        {
        //    assert nameTextField != null : "Can't find nameTextField";
            assert saveButton != null : "Can't find saveButton";
            assert cancelButton != null : "Can't find cancelButton";
        }
        catch (AssertionError ae)
        {
            System.out.println("FXML assertion failure: " + ae.getMessage());
            Application.terminate();
        }  
        System.out.println("Populating scene with items from the database...");        
        //@SuppressWarnings("unchecked")
        //List<Clothes> targetList = categoryChoiceBox.getItems();  
        //Clothes.readAll(targetList);       
        //categoryChoiceBox.getSelectionModel().selectFirst();
    }
    
    public void setParent(SceneController parent)
    {
        this.parent = parent;
    }

    @FXML   void saveButtonClicked()
    {
        System.out.println("Save button clicked!");        

        if (clothes == null)
        {   
            clothes = new Clothes(0,0,0,0,0,"");
        }

        //clothes.Names = nameTextField.getText();

        //Category selectedCategory = (Category) categoryChoiceBox.getSelectionModel().getSelectedItem();        
        //clothes.categoryId = selectedCategory.id;

        clothes.save();

        parent.initialize();

        stage.close();
    }
     @FXML   void cancelButtonClicked()
    {
        System.out.println("Cancel button clicked!");        
        stage.close();
    }
}