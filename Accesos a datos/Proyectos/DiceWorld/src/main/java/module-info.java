module com.diceworld.diceworld {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.diceworld.diceworld to javafx.fxml;
    exports com.diceworld.diceworld;
    exports com.diceworld.diceworld.controlador;
    opens com.diceworld.diceworld.controlador to javafx.fxml;
}