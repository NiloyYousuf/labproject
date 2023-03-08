package com.example.scrollingfxml;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Remainder implements Initializable {

    @FXML
    private VBox itemContainer;

    @FXML
    private  Button Cart;

    @FXML
    private  Label cartlabel;
    private List<Item> itemList = new ArrayList<>();


    public  void searchbuttonclicked()
    {

    }

    ArrayList<items> itemsadded;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Initialize the item list
        itemList.add(new Item("Item 1", "This is item 1", "C://Users//yousu//IdeaProjects//scrollingfxml//src//main//resources//com//example//img.png"));
        itemList.add(new Item("Item 2", "This is item 2", "C://Users//yousu//IdeaProjects//scrollingfxml//src//main//resources//com//example//img.png"));
        itemList.add(new Item("Item 3", "This is item 3", "C://Users//yousu//IdeaProjects//scrollingfxml//src//main//resources//com//example//img.png"));
        itemList.add(new Item("Item 4", "This is item 4", "C://Users//yousu//IdeaProjects//scrollingfxml//src//main//resources//com//example//img.png"));
        //   itemList.add(new Item("Item 5", "This is item 5", "C://Users//yousu//IdeaProjects//scrollingfxml//src//main//resources//com//example//img.png"));

        // Add the items to the item container
        for (Item item : itemList) {
            HBox itemBox = new HBox(30);
            ImageView imageView = new ImageView(item.getImageUrl());
            imageView.setFitWidth(160);
            imageView.setFitHeight(120);
            Label descriptionLabel = new Label(item.getDescription());
            Label nameLabel = new Label(item.getName());
            VBox NameAndDesc=new VBox(nameLabel,descriptionLabel);
            Button button =new Button();
            Button button1=new Button();
            Label Quantity=new Label();
            Quantity.setMinSize(50,10);
            Quantity.setText("0");
            button.setText("+");
            button1.setText("-");
            //  button.setOnAction(event -> Quantity.setText(Integer.toString(Integer.parseInt(Quantity.getText())+1)));
            // button1.setOnAction(event -> Quantity.setText(Integer.toString(Integer.parseInt(Quantity.getText())-1)));
            button1.setOnAction(event ->decrease(button1,Quantity,item));
            button.setOnAction(event ->increase(button,Quantity,item));
            NameAndDesc.setMinWidth(400);
            button.setMinSize(40,20);
            button1.setMinSize(40,20);
            button.onMouseClickedProperty();
            itemBox.getChildren().addAll(new HBox(imageView,NameAndDesc,Quantity,button,button1));
            itemContainer.getChildren().add(itemBox);
        }




    }




    public void decrease(Button button1, Label Quantity,Item item)
    {
        if(!Quantity.getText().equals("0")) {
            Quantity.setText(Integer.toString(Integer.parseInt(Quantity.getText()) - 1));
            cartlabel.setText(Integer.toString(Integer.parseInt(cartlabel.getText()) - 1));
            item.quantity--;
        }


    }

    public  void increase(Button button1, Label Quantity,Item item)
    {

        Quantity.setText(Integer.toString(Integer.parseInt(Quantity.getText())+1));
        cartlabel.setText(Integer.toString(Integer.parseInt(cartlabel.getText())+1));
        item.quantity++;
    }


    public void cartpressed()
    {
        for(int i=0;i<itemList.size();i++)
        {
            if(itemList.get(i).quantity!=0)
            {
                System.out.println(itemList.get(i).name+"   "+itemList.get(i).quantity);
            }
        }


    }

    private static class Item {
        private final String name;
        private final String description;
        private final String imageUrl;
        public   Integer quantity=0;

        public Item(String name, String description, String imageUrl) {
            this.name = name;
            this.description = description;
            this.imageUrl=imageUrl;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public String getImageUrl() {
            return imageUrl;
        }
        public Integer getquantity(){return  quantity;}
    }


}