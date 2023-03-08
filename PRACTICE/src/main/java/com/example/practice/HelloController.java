package com.example.practice;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import  javafx.scene.Parent;
import javafx.scene.Scene;
import  javafx.stage.Stage;
import  javafx.scene.control.TextField;
import  javafx.scene.control.PasswordField;
import java.io.IOException;
import java.security.PrivateKey;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.util.Pair;
public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private TextField name;


    @FXML
    private  PasswordField passwordField;

    public HelloController() {
    }

   // @FXML
   // protected void onHelloButtonClick() {
   //     welcomeText.setText("Welcome to JavaFX Application!");
   // }

    @FXML
    private  TextField namefield;
    private  Stage stage;
    private  Scene scene;
    private Parent root;
    public void switchToScene2(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("RegisterpageD.fxml"));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 720, 480);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    private  Label unmatchedMessage;

    public void switchToScene3(ActionEvent event,String username) throws IOException {
        String s1="userLoggedIn.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(s1));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 720, 480);
        stage.setTitle("e-MED");
        stage.setScene(scene);
        stage.show();

    }






    public  ArrayList<Pair<String,String>> string_processing(String s1)
    {
        ArrayList<Pair<String,String>> array_of_product=new ArrayList<Pair<String,String>>();
        Pair<String,String>p=new Pair<>("s1","description");
        array_of_product.add(1,p);

        // search the string in the database return arrays of product names and the location of the picture of the products

        return  array_of_product;
    }



    public void login_button_click(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {

        if(name.getText().isBlank()==false && passwordField.getText().isBlank()==false )
        {
          /*  if(name.getText().equals("Niloy") && passwordField.getText().equals("123"))  /// here the databases users has to be connected
            {

            }
            else
            System.out.println("Successfull");
*/
           String Name=name.getText();
           System.out.println(Name );
            String Password=passwordField.getText();
            System.out.println(Password);
            table obj = new table();
          // obj.insert_val("niloyfdfrry", "12tr3", "0171", "email");
           boolean output = obj.login(Name, Password);

          if (output)
              switchToScene3(event,Name);
           else
              unmatchedMessage.setText(" Username and Password don't Match");

        }

       else unmatchedMessage.setText("Please Enter Username and Password");

    }


    @FXML
    private  Label regunmatchedMessage;
    @FXML
    private  TextField regname;
    @FXML
    private PasswordField regpassword;
    @FXML
    private  TextField regmail;
    @FXML
    private  TextField regphone;


    public void register_button_click(ActionEvent event) throws IOException, SQLException, ClassNotFoundException{

            System.out.println("clicked");
            String u_name,key,mob_no,mail_id;
u_name=regname.getText();
key=regpassword.getText();
mob_no=regphone.getText();
mail_id=regmail.getText();
            table obj=new table();
            boolean inserted=obj.insert_val(u_name, key, mob_no, mail_id);


            if(inserted==true)
            {
                System.out.println("Inserted");
                switchToScene3(event,u_name);
            }

            else
            {
               regunmatchedMessage.setText(" Username Already Exists");
                System.out.println("could not be Inserted");

            }



    }



}