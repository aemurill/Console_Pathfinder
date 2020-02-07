package com.aemurill.pathfinderproject.lib;

import static com.aemurill.pathfinderproject.lib.GUIUtils.runSafe;

import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

import javafx.application.Platform;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

//https://codereview.stackexchange.com/questions/52197/console-component-in-javafx
public class Console extends BorderPane {
    protected final TextArea textArea = new TextArea();
    protected final TextField textField = new TextField();
    //private final Pane root;

    protected final List<String> history = new ArrayList<>();
    protected int historyPointer = 0;
    private boolean isOpen;
    private final TextInputControlStream stream;
    private final PrintStream out;
    private final InputStream in;

    private Consumer<String> onMessageReceivedHandler;

    public Console(Pane newRoot) {
        //root = newRoot;
        textArea.setEditable(false);
        textArea.setCache(false);
        Platform.runLater(()->{
            ScrollPane sp = (ScrollPane)textArea.getChildrenUnmodifiable().get(0);
            sp.setCache(false);
            for (Node n : sp.getChildrenUnmodifiable()) {
                n.setCache(false);
            }
        });
        
        
        setCenter(textArea);        

        stream = new TextInputControlStream(textField, Charset.defaultCharset());
        try{
            out = new PrintStream(stream.getOut(), true, Charset.defaultCharset().name());
        } catch (UnsupportedEncodingException e){
            throw new RuntimeException(e);
        }
        in = stream.getIn();

        textField.addEventHandler(KeyEvent.KEY_PRESSED, keyEvent ->{

        });

        textField.addEventHandler(KeyEvent.KEY_RELEASED, keyEvent -> {
            //if(!isOpen) return;
            switch (keyEvent.getCode()) {
                case ENTER:
                    System.out.println("ENTER");
                    stream.getIn().enterKeyPressed();
                    String text = textField.getText();
                    textArea.appendText(text + System.lineSeparator());
                    history.add(text);
                    historyPointer++;
                    if (onMessageReceivedHandler != null) {
                        onMessageReceivedHandler.accept(text);
                    }                    
                    textField.clear();
                    //root.requestFocus();
                    break;
                case UP:
                    if (historyPointer == 0) {
                        break;
                    }
                    historyPointer--;
                    runSafe(() -> {
                        textField.setText(history.get(historyPointer));
                        textField.selectAll();
                    });
                    break;
                case DOWN:
                    if (historyPointer == history.size() - 1) {
                        break;
                    }
                    historyPointer++;
                    runSafe(() -> {
                        textField.setText(history.get(historyPointer));
                        textField.selectAll();
                    });
                    break;
                default:
                    break;
            }
        });
        setBottom(textField);
        
    }

    @Override
    public void requestFocus() {
        super.requestFocus();
        textField.requestFocus();
    }

    public void setOnMessageReceivedHandler(final Consumer<String> onMessageReceivedHandler) {
        this.onMessageReceivedHandler = onMessageReceivedHandler;
    }

    public void clear() {
        runSafe(() -> textArea.clear());
    }

    public void print(final String text) {
        Objects.requireNonNull(text, "text");
        runSafe(() -> textArea.appendText(text));
    }

    public void println(final String text) {
        Objects.requireNonNull(text, "text");
        runSafe(() -> textArea.appendText(text + System.lineSeparator()));
    }

    public void println() {
        runSafe(() -> textArea.appendText(System.lineSeparator()));
    }

	public void disableCursor() {
        textArea.setCursor(Cursor.DEFAULT);
    }
    
    public PrintStream getOut() {
        return out;
      }
    
    public InputStream getIn() {
    return in;
    }
}