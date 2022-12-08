module com.cs272.spellingbee {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;


    opens com.cs272.spellingbee to javafx.fxml;
    exports com.cs272.spellingbee;
}