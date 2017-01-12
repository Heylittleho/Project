import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.List;

public class Pattern
{

    public int ClothesID;
    public int id;
    public int ColourID;
    public int PatternID;
    public int TypeID;
    public int BrandID;
    public String Names;


    public Pattern(int ClothesID, int ColourID, int PatternID, int TypeID, int BrandID, String Names)
    {
        this.ClothesID = ClothesID;        
        this.ColourID = ColourID;
        this.PatternID  = PatternID;
        this.TypeID = TypeID;
        this.BrandID = BrandID;
        this.Names = Names;
    }


    @Override public String toString()
    {
        return Names;
    }

    public static void readAll(List<Clothes> list)
    {
        list.clear();     

        
        PreparedStatement statement = Application.database.newStatement("SELECT ClothesID, ColourID, PatternID, TypeID, BrandID , Names FROM Clothes ORDER BY ClothesID"); 

        if (statement != null)    
        {
            ResultSet results = Application.database.runQuery(statement);    
            if (results != null)      
            {
                try {                              
                    while (results.next()) {                                               
                        list.add( new Clothes(results.getInt("ClothesID"), results.getInt("ColourID"),results.getInt("PatternID"),results.getInt("TypeID"),results.getInt("BrandID"),results.getString("Names")));
                    }
                }
                catch (SQLException resultsexception)      
                {
                    System.out.println("Database result processing error: " + resultsexception.getMessage());
                }
            }
        }

    }

    public static Clothes getById(int ClothesID)
    {
        Clothes thing = null;

        PreparedStatement statement = Application.database.newStatement("SELECT ClothesID, ColourID, PatternID, TypeID, BrandID , names FROM Clothes WHERE ClothesID = ?"); 

        try 
        {
            if (statement != null)
            {
                statement.setInt(1, ClothesID);
                ResultSet results = Application.database.runQuery(statement);

                if (results != null)
                {
                    thing = new Clothes(results.getInt("ClothesID"), results.getInt("ColourID"), results.getInt("PatternID"),results.getInt("TypeID"), results.getInt("BrandID"), results.getString("Names"));
                }
            }
        }
        catch (SQLException resultsexception)
        {
            System.out.println("Database result processing error: " + resultsexception.getMessage());
        }

        return thing;
    }

    public static void deleteById(int ClothesID)
    {
        try 
        {

            PreparedStatement statement = Application.database.newStatement("DELETE FROM Clothes WHERE id = ?");             
            statement.setInt(1, ClothesID);

            if (statement != null)
            {
                Application.database.executeUpdate(statement);
            }
        }
        catch (SQLException resultsexception)
        {
            System.out.println("Database result processing error: " + resultsexception.getMessage());
        }

    }
    
    public void save()    
    {
        PreparedStatement statement;

        try 
        {

            if (ClothesID == 0)
            {

                statement = Application.database.newStatement("SELECT ClothesID FROM Clothes ORDER BY ClothesID DESC");             

                if (statement != null)  
                {
                    ResultSet results = Application.database.runQuery(statement);
                    if (results != null)
                    {
                        ClothesID = results.getInt("ClothesID") + 1;
                    }
                }

                statement = Application.database.newStatement("INSERT INTO Clothes (ClothesID, ColourID, PatternID, TypeID, BrandID , Names) VALUES (?, ?, ?)");             
                statement.setInt(1, ClothesID);
                statement.setInt(2, ColourID);
                statement.setInt(3, PatternID); 
                statement.setInt(4, TypeID);
                statement.setInt(5, BrandID);
                statement.setString(6, Names);

            }
            else
            {
                statement = Application.database.newStatement("UPDATE Clothes SET Names = ?, categoryId = ? WHERE id = ?");             
                statement.setString(1, Names);
                statement.setInt(2, ClothesID);   
                statement.setInt(3, ColourID);
                statement.setInt(4, PatternID);
                statement.setInt(5, TypeID);
                statement.setInt(6, BrandID);
            }

            if (statement != null)
            {
                Application.database.executeUpdate(statement);
            }
        }
        catch (SQLException resultsexception)
        {
            System.out.println("Database result processing error: " + resultsexception.getMessage());
        }

    }

}