package org.insilico.krayon4insilico.view;

import javafx.application.Application;
import javafx.embed.swing.*;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import krayon.editor.sbgn.KrayonForSbgn;

import java.io.File;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.model.application.ui.basic.MTrimmedWindow;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

import org.insilico.krayon4insilico.containers.Krayon4SbgnWrapper;

import krayon.editor.sbgn.ui.SbgnGraphComponent;

public class View {
	/**
	 * The {@link GraphComponent} injected after {@link SbgnDocumentLoader} loaded a sbgn file.
	 */
	@Inject
	SbgnGraphComponent graphComponent;
	
	/**
	 * The {@link MWindow} is a Model Window of the Insilico application. It is injected at instantiation and available
	 * inside the object.
	 */
	@Inject 
    MTrimmedWindow mWindow;
	
	/**
	 * SwingNodes containing components of the Krayon4sbgn GUI
	 */
    private SwingNode swingNodeGraphComponent = new SwingNode();
    private SwingNode swingNodeToolBar = new SwingNode();
    private SwingNode swingNodeRight = new SwingNode();
    
    /**
	 * Called after injection of {@link #project}. Generates the GUI.
	 * @param parent The {@link BorderPane} provided by Insilico.
	 */
	@PostConstruct
	private void init(BorderPane parent) {
		parent = makeView(parent);		
	}
	
	/**
	 * Builds the Krayon4sbgn View of the GraphComponent in {@link #project}.
	 * @param parent The parent {@link BorderPane} {@link Node} provided by Insilico
	 * @return The View representing {@link #project}.
	 */
    private BorderPane makeView (BorderPane parent) {	
        Krayon4SbgnWrapper.setup();
        Krayon4SbgnWrapper.addGraphComponent(graphComponent);
        
        swingNodeGraphComponent.setContent(Krayon4SbgnWrapper.getEditorContainer());
		swingNodeToolBar.setContent(Krayon4SbgnWrapper.getToolBar());
		swingNodeRight.setContent(Krayon4SbgnWrapper.getSidePane());

        parent.setTop(swingNodeToolBar);
        parent.setCenter(swingNodeGraphComponent);
        parent.setRight(swingNodeRight);
	    
/*
 *  Drag and drop works only if a swing frame is composed.
 */
//		JSplitPane tableAndBrickPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, Krayon4sbgnWrapper.getEditorContainer(), Krayon4sbgnWrapper.getSidePane());
//	    JSplitPane swingPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, Krayon4sbgnWrapper.getToolBar(),tableAndBrickPane);
//        
//	    JFrame frame = new JFrame();
//        frame.add(swingPane);
//        frame.setVisible(true);
//	     
          return parent;
        }
}
