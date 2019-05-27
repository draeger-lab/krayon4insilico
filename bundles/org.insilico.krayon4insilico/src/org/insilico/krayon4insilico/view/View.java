package org.insilico.krayon4insilico.view;

import javafx.application.Application;
import javafx.embed.swing.*;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import krayon.editor.sbgn.KrayonForSbgn;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

import org.insilico.krayon4insilico.containers.Krayon4SbgnWrapper;

public class View extends Application {
	
    private SwingNode swingNodeGraphComponent = new SwingNode();
    private SwingNode swingNodeToolBar = new SwingNode();
    private SwingNode swingNodeRight = new SwingNode();

    @Override
    public void start (Stage stage) {	
        Krayon4SbgnWrapper.setup();
          swingNodeGraphComponent.setContent(Krayon4SbgnWrapper.getEditorContainer());
		  swingNodeToolBar.setContent(Krayon4SbgnWrapper.getToolBar());
		  swingNodeRight.setContent(Krayon4SbgnWrapper.getSidePane());

	    BorderPane mainPane = new BorderPane();
          mainPane.setTop(swingNodeToolBar);
          mainPane.setCenter(swingNodeGraphComponent);
          mainPane.setRight(swingNodeRight);
        
        stage.setTitle("KrayonTestGui");
        stage.setScene(new Scene(mainPane, 500, 700));
        stage.show();
	    
/*
 *  Drag and drop works when a swing frame is composed.
 */
//		JSplitPane tableAndBrickPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, Krayon4sbgnWrapper.getEditorContainer(), Krayon4sbgnWrapper.getSidePane());
//	    JSplitPane swingPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, Krayon4sbgnWrapper.getToolBar(),tableAndBrickPane);
//        
//	    JFrame frame = new JFrame();
//        frame.add(swingPane);
//        frame.setVisible(true);
//	    
        }
}
