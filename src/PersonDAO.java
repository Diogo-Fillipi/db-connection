import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

public class PersonDAO{

    public void toInsert(PersonDTO personDTO){

        Connection connection = DbConnection.getConnection();
        String SQL = "INSERT INTO [yourTableName] ([yourColumnName], [yourColumnName]) VALUES(?, ?)";
        try{
            PreparedStatement PS = connection.prepareStatement(SQL);
            PS.setString(1, personDTO.getName());
            PS.setInt(2, personDTO.getAge());
            PS.execute();
            PS.close();
        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    public List<PersonDTO> toRead(){

        List<PersonDTO> listData = new ArrayList<PersonDTO>();
        Connection connection = DbConnection.getConnection();
        String SQL = "SELECT * FROM [yourTableName]";

        try(PreparedStatement PS = connection.prepareStatement(SQL)){
            ResultSet resultSet = PS.executeQuery();

            while(resultSet.next()){
                PersonDTO personDTO = new PersonDTO(null, (Integer) null);
                personDTO.setPersonId(resultSet.getInt("[yourColumnName]"));
                personDTO.setName(resultSet.getString("[yourColumnName]"));
                personDTO.setAge(resultSet.getInt("[yourColumnName]"));

                listData.add(personDTO);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }


        return listData;
    }

    public void toDelete(int personId){
        Connection connection = DbConnection.getConnection();
        String SQL = "DELETE FROM [yourTableName] WHERE [yourColumnName] = ?";
        
        try(PreparedStatement PS = connection.prepareStatement(SQL)){
            PS.setInt(1, personId);
            PS.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    public void toUpdate(PersonDTO personDTO){
        Connection connection = DbConnection.getConnection();
        String SQL = "UPDATE [yourTableName] SET [[yourColumnName]] = ? WHERE [yourColumnName] = ?";
        
        try(PreparedStatement PS = connection.prepareStatement(SQL)){
            PS.setString(1, personDTO.getName());
            PS.setInt(2, personDTO.getPersonId());
            PS.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }

    }

}

