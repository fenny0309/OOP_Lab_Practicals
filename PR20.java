 /*
 AIM:
 Create a JavaFX app that shows a circle which continuously bounces (left↔right) inside the scene.
Provide:
● A Start and Stop button.
● A Slider to control the ball speed (min: slow, max: fast).
● When window is resized, the ball should keep bouncing within new bounds.
UI / Classes to use: Pane or AnchorPane, Circle, TranslateTransition or AnimationTimer, Button,
Slider.
Following behavior is expected:
● Press Start → ball moves horizontally and reverses on boundaries.
● Move Slider while running → ball speed updates.
● Press Stop → animation pauses.
*/

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class PR20 extends Application {

    private double dx = 2; 
    private boolean running = false;

    @Override
    public void start(Stage primaryStage) {
        
        Circle ball = new Circle(20, Color.DODGERBLUE);
        ball.setCenterX(50);
        ball.setCenterY(150);

        Pane canvas = new Pane();
        canvas.setStyle("-border-color: black; -fx-border-width: 2; -fx-background-color: #f4f4f4;");
        canvas.getChildren().add(ball);

        Button startBtn = new Button("Start");
        Button stopBtn = new Button("Stop");
        
        Slider speedSlider = new Slider(1, 10, 2);
        speedSlider.setShowTickLabels(true);
        speedSlider.setShowTickMarks(true);
        
        Label speedLabel = new Label("Speed:");

        HBox controls = new HBox(15, startBtn, stopBtn, speedLabel, speedSlider);
        controls.setPadding(new Insets(10));
        controls.setAlignment(Pos.CENTER);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (!running) return;

                double currentSpeed = speedSlider.getValue();

                ball.setTranslateX(ball.getTranslateX() + (dx > 0 ? currentSpeed : -currentSpeed));

                if (ball.getCenterX() + ball.getTranslateX() + ball.getRadius() >= canvas.getWidth()) {
                    dx = -1;
                }

                if (ball.getCenterX() + ball.getTranslateX() - ball.getRadius() <= 0) {
                    dx = 1;
                }
            }
        };

        startBtn.setOnAction(e -> {
            running = true;
            timer.start();
        });

        stopBtn.setOnAction(e -> {
            running = false;
        });

        canvas.widthProperty().addListener((obs, oldVal, newVal) -> {
            double rightEdge = ball.getCenterX() + ball.getTranslateX() + ball.getRadius();
            if (rightEdge > newVal.doubleValue()) {
                ball.setTranslateX(newVal.doubleValue() - ball.getCenterX() - ball.getRadius());
            }
        });

        BorderPane root = new BorderPane();
        root.setCenter(canvas);
        root.setBottom(controls);

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("JavaFX Bouncing Ball");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}