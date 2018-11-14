/* File: Main.java
 * Authors: Marc Sun Bog & Simon Amtoft Pedersen
 *
 * The following file is the main file for the RISCV-Simulator of the RV32I instructions.
 */
package RISCVSimulator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    static Instruction[] programInst;  // Array of all program instructions
    static Memory memory = new Memory(512) ;

    public static void main(String[] args) {
        CPU cpu = new CPU();




        launch(args);
    }

    /* This method starts the GUI
     * @Override method in Application
     */
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Layout.fxml"));
        primaryStage.setTitle("RV32I Simulator");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();
    }

}
