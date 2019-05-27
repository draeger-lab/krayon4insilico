package org.insilico.krayon4insilico;

import org.insilico.krayon4insilico.view.View;

import javafx.application.Application;
import krayon.editor.sbgn.*;

public class Main {
	public static void main (String... args){
		System.out.println("hello");
		Application.launch(View.class, args);
	}

}
