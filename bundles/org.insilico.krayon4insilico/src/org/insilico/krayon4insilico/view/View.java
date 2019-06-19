package org.insilico.krayon4insilico.view;

import javafx.embed.swing.*;
import javafx.scene.layout.BorderPane;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.ui.model.application.ui.basic.MTrimmedWindow;

import org.insilico.krayon4insilico.containers.Krayon4SbgnWrapper;

import krayon.editor.sbgn.ui.SbgnGraphComponent;

public class View {
	/**
	 * The {@link SbgnGraphComponent} injected after {@link SbgnDocumentLoader} loaded a sbgn file.
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
        
        SwingNode swingNodeGraphComponent = new SwingNode();
        SwingNode swingNodeToolBar = new SwingNode();
        SwingNode swingNodeRight = new SwingNode();
        
        swingNodeGraphComponent.setContent(Krayon4SbgnWrapper.getEditorContainer());
		swingNodeToolBar.setContent(Krayon4SbgnWrapper.getToolBar());
		swingNodeRight.setContent(Krayon4SbgnWrapper.getSidePane());

        parent.setTop(swingNodeToolBar);
        parent.setCenter(swingNodeGraphComponent);
        parent.setRight(swingNodeRight);
        
        return parent;
        }
}
