package de.krayon4insilico.view;

import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import krayon.editor.sbgn.KrayonForSbgn;
import de.krayon4insilico.containers.Krayon4sbgnWrapper;

public class View extends Application {
	
    private SwingNode swingNodeGraphComponent = new SwingNode();
    private SwingNode swingNodeRight = new SwingNode();
    private SwingNode swingNodeToolBar = new SwingNode();
    private SwingNode swingNodeRight2 = new SwingNode();

    @Override
    public void start (Stage stage) {	
        
        Krayon4sbgnWrapper.setup();
        swingNodeGraphComponent.setContent(Krayon4sbgnWrapper.getGraphComponent());
		swingNodeToolBar.setContent(Krayon4sbgnWrapper.getToolBar());
		swingNodeRight.setContent(Krayon4sbgnWrapper.getPaletteContainer());
		swingNodeRight2.setContent(Krayon4sbgnWrapper.getTableAndBrickPane());
        
//		SbgnGraphComponent graphComponent = new SbgnGraphComponent();
//		graphComponent.setInputMode(graphComponent.createEditorMode());
//		graphComponent.setPreferredSize(new Dimension(600, 600));
		
//		SbgnReader reader = new SbgnReader();
//		FileInputStream in;
//		try {
//			in = new FileInputStream("camkii-signaling-pathway.sbgn");
//			reader.read(in,  graphComponent.getGraph(), graphComponent);
//			graphComponent.updateContentRect();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	    BorderPane mainPane = new BorderPane();
        GridPane rightPane = new GridPane();
        
        rightPane.add(swingNodeRight, 0, 0);
        rightPane.add(swingNodeRight2, 0, 1);
        
        mainPane.setTop(swingNodeToolBar);
        mainPane.setCenter(swingNodeGraphComponent);
        mainPane.setRight(rightPane);
        
        stage.setTitle("KrayonTestGui");
        stage.setScene(new Scene(mainPane, 500, 700));
        stage.show();
        }
}

