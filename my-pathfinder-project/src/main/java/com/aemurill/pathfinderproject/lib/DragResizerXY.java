package com.aemurill.pathfinderproject.lib;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;

/**
 * {@link DragResizerXY} can be used to add mouse listeners to a {@link Region}
 * and make it resizable by the user by clicking and dragging the border in the
 * same way as a window.
 * <p>
 * Height and Width resizing is working (hopefully) properly
 * 
 * <pre>
 * DragResizer.makeResizable(myAnchorPane);
 * </pre>
 *
 * @author Cannibalsticky (modified from the original DragResizer created by AndyTill)
 *
 */
public class DragResizerXY {

	/**
	 * The margin around the control that a user can click in to start resizing
	 * the region.
	 */
	private static int RESIZE_MARGIN = 10;

	private final Region region;

	private double y;

	private double x;

	private boolean initMinHeight;

	private boolean initMinWidth;

	private boolean draggableZoneX, draggableZoneY;

	private boolean dragging;

	private DragResizerXY(Region aRegion) {
		region = aRegion;
	}

	private static void correctWidth(Region region, double newWidth, Pane pane) {
		System.out.println("w" + newWidth +" "+ pane.getWidth());
		if (newWidth < 50){
			newWidth = 50;			
		}
		if (newWidth > pane.getWidth() - 5){
			newWidth = pane.getWidth() - 5;			
		}

		region.setMinWidth(newWidth);
	}

	private static void correctHeight(Region region, double newHeight, Pane pane) {
		System.out.println("h"+newHeight +" "+ pane.getHeight());
		if (newHeight < 50){
			newHeight = 50;			
		}
		if (newHeight > pane.getHeight() - 5){
			newHeight = pane.getHeight() - 5;			
		}

		region.setMinHeight(newHeight);
	}

	public static void makeResizableXY(Region region, Pane pane, int resizeMargin, boolean Left, boolean Top){
		if (resizeMargin > 1) RESIZE_MARGIN = resizeMargin;
		final DragResizerXY resizer = new DragResizerXY(region);

		region.widthProperty().addListener((obs, oldVal, newVal) -> {
			correctWidth(resizer.region, region.getWidth(), pane);
		});
		region.heightProperty().addListener((obs, oldVal, newVal) -> {
			correctHeight(resizer.region, region.getHeight(), pane);
		});
		makeResizable(region, pane, resizer, 0, Left, Top);
	}
	
	public static void makeResizableX(Region region, Pane pane, int resizeMargin, boolean Left){
		if (resizeMargin > 1) RESIZE_MARGIN = resizeMargin;
		final DragResizerXY resizer = new DragResizerXY(region);

		region.widthProperty().addListener((obs, oldVal, newVal) -> {
			correctWidth(resizer.region, region.getWidth(), pane);
		});
		makeResizable(region, pane, resizer, 1, Left, false);
	}

	public static void makeResizableY(Region region, Pane pane, int resizeMargin, boolean Top){
		if (resizeMargin > 1) RESIZE_MARGIN = resizeMargin;
		final DragResizerXY resizer = new DragResizerXY(region);

		region.heightProperty().addListener((obs, oldVal, newVal) -> {
			correctHeight(resizer.region, region.getHeight(), pane);
		});
		makeResizable(region, pane, resizer, 2, false, Top);
	}

	public static void makeResizable(Region region, Pane pane, final DragResizerXY resizer, int mode, boolean Left, boolean Top) {		
		region.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				resizer.mousePressed(event);
			}
		});
		region.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				resizer.mouseDragged(event, pane, mode);
			}
		});
		region.setOnMouseMoved(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				resizer.mouseOver(event, mode);
			}
		});
		region.setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				resizer.mouseReleased(event);
			}
		});
	}

	protected void mouseReleased(MouseEvent event) {
		dragging = false;
		region.setCursor(Cursor.DEFAULT);
	}

	protected void mouseOver(MouseEvent event, int mode) {
		if (isInDraggableZone(event) || dragging) {
			if (draggableZoneY && (mode == 2 || mode == 0)) {
				region.setCursor(Cursor.S_RESIZE);
			}

			if (draggableZoneX && (mode == 1 || mode == 0)) {
				region.setCursor(Cursor.E_RESIZE);
			}

			if(draggableZoneY && draggableZoneX && mode == 0){
				region.setCursor(Cursor.SE_RESIZE);
			} 

		} else {
			region.setCursor(Cursor.DEFAULT);
		}
	}
	
	
	//had to use 2 variables for the controll, tried without, had unexpected behaviour (going big was ok, going small nope.)
	protected boolean isInDraggableZone(MouseEvent event) {
		draggableZoneY = (boolean)(event.getY() > (region.getHeight() - RESIZE_MARGIN));
		draggableZoneX = (boolean)(event.getX() > (region.getWidth() - RESIZE_MARGIN));
		return (draggableZoneY || draggableZoneX);
	}

	protected void mouseDragged(MouseEvent event, Pane pane, int mode) {
		if (!dragging) {
			return;
		}

		if (draggableZoneY ){//&& (mode == 2 || mode == 0)) {
			double mousey = event.getY();

			double newHeight = region.getMinHeight() + (mousey - y);
			correctHeight(region, newHeight, pane);
			y = mousey;
		}

		if (draggableZoneX){//) && (mode == 1 || mode == 0)) {
			double mousex = event.getX();

			double newWidth = region.getMinWidth() + (mousex - x);
			correctWidth(region, newWidth, pane);
			x = mousex;

		}

	}


	protected void mousePressed(MouseEvent event) {

		// ignore clicks outside of the draggable margin
		if (!isInDraggableZone(event)) {
			return;
		}

		dragging = true;

		// make sure that the minimum height is set to the current height once,
		// setting a min height that is smaller than the current height will
		// have no effect
		if (!initMinHeight) {
			region.setMinHeight(region.getHeight());
			initMinHeight = true;
		}

		y = event.getY();

		if (!initMinWidth) {
			region.setMinWidth(region.getWidth());
			initMinWidth = true;
		}

		x = event.getX();
	}

	//public class SimpleChangeListener extends ChangeListener<
}