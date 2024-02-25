public class PersonDTO {
    //Attributes
    private int personId;

    private String name;

    private int age;

    //Getters and setters

    public void setPersonId(int personId){
        this.personId = personId;
    }

    public int getPersonId(){
        return this.personId;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setAge(int age){
       this.age = age; 
    }

    public int getAge(){
        return this.age;
    }

    //Constructor

    public PersonDTO(String name, int age){
        this.name = name;
        this.age = age;
    }
}
