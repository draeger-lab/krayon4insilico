package de.krayon4insilico.containers;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;

import krayon.editor.sbgn.KrayonForSbgn;
import krayon.editor.sbgn.ui.*;

public class Krayon4sbgnWrapper {
	private static boolean IsSetup=false;
	private static KrayonForSbgn Krayon = KrayonForSbgn.INSTANCE;
	
	public static void setup() {
		Krayon.setup();
		IsSetup=true;
	}
	
	public static JSplitPane getsidePane() {
		return Krayon.getSidePane();
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

	public static boolean isSetup() {
		return IsSetup;
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

}
