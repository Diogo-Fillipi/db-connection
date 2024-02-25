public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        PersonDAO personDAO = new PersonDAO();
        PersonDTO personDTO = new PersonDTO("Diogo", 18);

   

        personDAO.toInsert(personDTO);


    }
}
