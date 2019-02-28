package de.krayon4insilico.main;

import de.krayon4insilico.view.*;

public class Main {
	public static void main (String[] args){
		System.out.println("hello");
//		krayon.editor.sbgn.KrayonForSbgn.main(args);
		javafx.application.Application.launch(View.class, args);
	}

}
