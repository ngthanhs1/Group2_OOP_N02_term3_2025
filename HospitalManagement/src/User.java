


















public class User {

    //Bien de mieu ta User
    String firstName;
    String lastName;
    String dateOfBirth;
    String address;
    String username;
    String password;




    //Xay dung Constructor: phuong thuc dac biet

    public User(String un,  String pw){

        username = un;
        password = pw;

    }


    //Phuong thuc de mieu ta hoat dong

    public void getUserInformation(){

        System.out.println("username:"+ username);

    }

    
}
