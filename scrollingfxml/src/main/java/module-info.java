module com.example.scrollingfxml {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.scrollingfxml to javafx.fxml;
    exports com.example.scrollingfxml;
}