package org.insilico.krayon4insilico;

import org.osgi.framework.BundleActivator;
import org.insilico.ui.windows.*;
import org.insilico.krayon4insilico.view.View;
import org.osgi.framework.BundleContext;
import javafx.application.Application;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator implements BundleActivator {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.insilico.kayon4insilico"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	@Override
	public void start(BundleContext context) throws Exception {
		plugin = this;
		System.out.println("hello");
		Application.launch(View.class);	
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

}
