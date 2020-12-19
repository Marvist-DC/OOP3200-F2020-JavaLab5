/**
 * @AuthorL Duy Tan Vu
 * @Author: Domenic Catalano
 * @Date: December 17, 2020
 * @Description: Java lab 05: JavaFX
 */

package ca.durhamcollege;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        // Stage window size
        final int WIDTH = 480;
        final int HEIGHT = 440;

        // Set title for the stage
        primaryStage.setTitle("BMI Calculator");

        // GridPane Initialization
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(7, 14);
        gridPane.setMaxSize(7, 14);
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(10));

        // Prompt user for their weight
        Label lblWeight = new Label("My weight: ");
        gridPane.add(lblWeight, 0, 0);

        TextField txtWeight = new TextField();
        gridPane.add(txtWeight, 1, 0);

        // Prompt user for their height
        Label lblHeight = new Label("My height: ");
        gridPane.add(lblHeight, 0, 1);

        TextField txtHeight = new TextField();
        gridPane.add(txtHeight, 1, 1);

        // Group of radio buttons
        final ToggleGroup group = new ToggleGroup();

        RadioButton rb1 = new RadioButton("Imperial");
        rb1.setToggleGroup(group);
        rb1.setUserData("imperial");
        gridPane.add(rb1, 0, 3);

        RadioButton rb2 = new RadioButton("Metric");
        rb2.setToggleGroup(group);
        rb2.setUserData("metric");
        gridPane.add(rb2, 1, 3);

        // Calculate button
        Button btnCalculate = new Button("Calculate");
        btnCalculate.setStyle("-fx-font-family: Arial");
        gridPane.add(btnCalculate, 0, 5);

        // Result
        gridPane.add(new Label("Your BMI is: "), 0, 7);
        TextField txtResult = new TextField();
        gridPane.add(txtResult, 1, 7);

        /**
         * Calculate BMI and display result
         */
        btnCalculate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                double bmiResult;
                double myWeight = Double.parseDouble(txtWeight.getText());
                double myHeight = Double.parseDouble(txtHeight.getText());
                if (group.getSelectedToggle().getUserData().toString() == "imperial")
                {
                    bmiResult = (myWeight * 703) / Math.pow(myHeight, 2);
                }
                else
                {
                    bmiResult = myWeight / Math.pow(myHeight, 2);
                }
                txtResult.setText(String.valueOf(bmiResult));
            }
        });

        // Add the result table
        gridPane.add(new Label("BMI Scale"), 0, 9);
        gridPane.add(new Label("Underweight"), 0, 10);
        gridPane.add(new Label("Normal"), 0, 11);
        gridPane.add(new Label("Overweight"), 0, 12);
        gridPane.add(new Label("Obese"), 0, 13);

        gridPane.add(new Label("Result"), 1, 9);
        gridPane.add(new Label("less than 18.5"), 1, 10);
        gridPane.add(new Label("between 18.5 and 24.9"), 1, 11);
        gridPane.add(new Label("between 25 and 29.9"), 1, 12);
        gridPane.add(new Label("30 or greater"), 1, 13);

        // Set grid pane border and fontsize
        gridPane.setStyle(
                "-fx-border-color: black; " +
                        "-fx-font-size: 20;" +
                        " -fx-font-family: Consolas;"
        );

        // Display the stage
        Scene scene = new Scene(gridPane, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
