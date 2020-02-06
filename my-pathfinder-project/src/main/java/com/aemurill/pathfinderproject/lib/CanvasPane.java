package com.aemurill.pathfinderproject.lib;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;

public class CanvasPane extends Pane {

    public final Canvas canvas;

    public CanvasPane(double width, double height) {
        setWidth(width);
        setHeight(height);
        canvas = new ResizableCanvas(width, height);
        //canvas = new Canvas(width, height);
        getChildren().add(canvas);

        canvas.widthProperty().bind(this.widthProperty());
        canvas.heightProperty().bind(this.heightProperty());
        this.prefHeightProperty().bind(((ResizableCanvas)canvas).prefHeight);
        this.prefWidthProperty().bind(((ResizableCanvas)canvas).prefWidth);
        
    }
}