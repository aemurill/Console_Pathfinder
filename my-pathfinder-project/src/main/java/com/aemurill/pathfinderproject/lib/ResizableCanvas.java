package com.aemurill.pathfinderproject.lib;

import javafx.beans.InvalidationListener;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.canvas.Canvas;

public class ResizableCanvas extends Canvas {
    public ObservableValue<? extends Number> prefWidth;
    public ObservableValue<? extends Number> prefHeight;    

	public ResizableCanvas(double width, double height) {
        super(width, height);
        this.prefWidth = new SimpleDoubleProperty();
        this.prefHeight = new SimpleDoubleProperty();
	}

    @Override
    public boolean isResizable() {
        return true;
    }
    
    @Override
    public double prefWidth(double height) {
        return 0;
    }

    @Override
    public double prefHeight(double width) {
        return 0;
    }

    class SimpleDoubleProperty extends DoubleProperty {
        @Override
        public void bind(ObservableValue<? extends Number> observable) {
        }

        @Override
        public void unbind() {
        }

        @Override
        public boolean isBound() {
            return false;
        }

        @Override
        public Object getBean() {
            return null;
        }

        @Override
        public String getName() {
            return null;
        }

        @Override
        public void addListener(InvalidationListener listener) {
        }

        @Override
        public void removeListener(InvalidationListener listener) {
        }

        @Override
        public double get() {
            return 0;
        }

        @Override
        public void set(double value) {
        }

        @Override
        public void addListener(ChangeListener<? super Number> listener) {
        }

        @Override
        public void removeListener(ChangeListener<? super Number> listener) {        
        }
    }
}