package org.insilico.krayon4insilico;

import org.insilico.krayon4insilico.view.View;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import javafx.application.Application;

public class Activator implements BundleActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("hello");
		Application.launch(View.class);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub

	}

}
