package org.insilico.krayon4insilico.containers;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;

import krayon.editor.sbgn.KrayonForSbgn;
import krayon.editor.sbgn.ui.*;

/**
 * The {@link Krayon4SbgnWrapper} gives access to swing components 
 * and some methods from the {@link KrayonForSbgn} singleton main class.
 * 
 * @author Anton
 *
 */
public class Krayon4SbgnWrapper {
	
	private static KrayonForSbgn Krayon = KrayonForSbgn.INSTANCE;
	private static boolean IsSetup=false;
	
	
	public static void setup() {
		Krayon.setup();
		IsSetup=true;
	}
	public static boolean isSetup() {
		return IsSetup;
	}
	
	public static JSplitPane getSidePane() {
		return Krayon.getSidePane();
	}
	
	public static JSplitPane getMainSplit() {
		return Krayon.getMainSplit();
	}
	
	public static SbgnGraphComponent getGraphComponent() {
		return Krayon.getGraphComponent();
	}
	
	public static JPanel getEditorContainer() {
		return Krayon.getEditorContainer();
	}
	
	public static JToolBar getToolBar() {
		return Krayon.createToolBar();
	}
	
	public static JSplitPane getTableAndBrickPane() {
		return Krayon.getTableAndBrickPane();
	}
	
	public static JScrollPane getPropertyTableContainer() {
		return Krayon.getPropertyTableContainer();
	}
	
	public static JScrollPane getPaletteContainer() {
		return Krayon.getPaletteContainer();
	}
	public static void addGraphComponent(SbgnGraphComponent graphComponent) {
		Krayon.configureGraphComponent(graphComponent);
	}
}
