package org.insilico.krayon4insilico.services.provider;

import static org.eclipse.fx.code.editor.Constants.DOCUMENT_URL;

import java.awt.Dimension;
import java.io.FileInputStream;
import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.IContextFunction;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.IInjector;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;

import org.osgi.service.component.annotations.Component;

import krayon.editor.sbgn.io.SbgnReader;
import krayon.editor.sbgn.ui.SbgnGraphComponent;


/**
 * The {@link SbgnDocumentLoader} provides a {@link GraphComponent} via dependency injection if the
 * current document is a sbgn file.
 * 
 * In oder to use this {@link IContextFunction} the context must store the location of a sbgn file
 * with the key {@link org.eclipse.fx.code.editor.Constants#DOCUMENT_URL}.
 * 
 * @authors roman, anton
 * 
 *
 */
@SuppressWarnings("restriction")
@Component(service = IContextFunction.class,
        property = {"service.context.key=krayon.editor.sbgn.ui.SbgnGraphComponent"})

public class SbgnDocumentLoader extends ContextFunction {
    // Stores weak reference to already loaded documents.
    Map<String, SbgnGraphComponent> cache = new WeakHashMap<>();

    @Override
    public Object compute(IEclipseContext context, String contextKey) {
        System.out.println("Compute...");
        System.out.println(context.toString());
        System.out.println(context);
        System.out.println(context.get(DOCUMENT_URL));
        
        Object urlVal = context.get(DOCUMENT_URL);

        if (urlVal == null) {
            Object partVal = context.get(MPart.class);
            if (partVal != null && partVal instanceof MPart) {
                MPart part = (MPart) partVal;
                urlVal = part.getPersistedState().get(DOCUMENT_URL);
                context.set(DOCUMENT_URL, urlVal);
            }
        }

        // Check if an input file exists
        if (urlVal != null && urlVal instanceof String) {
            String urlString = (String) urlVal;
            urlString = urlString.replace("%20", " ");
            // Check cache
            SbgnGraphComponent graphComponent = cache.get(urlString);

            if (graphComponent == null) {
                // Load if needed
                try {
                	graphComponent = new SbgnGraphComponent();
            		graphComponent.setInputMode(graphComponent.createEditorMode());
            		graphComponent.setPreferredSize(new Dimension(600, 600));
            		SbgnReader reader = new SbgnReader();
                	FileInputStream in;
            		in = new FileInputStream(DOCUMENT_URL);
            		System.out.println(DOCUMENT_URL);
            		reader.read(in,  graphComponent.getGraph(), graphComponent);
            		graphComponent.updateContentRect();
                    cache.put(urlString, graphComponent);
                }
                catch (Exception e) {
                    // Not a sbgn file?
                    e.printStackTrace();
                    System.out.println("Reading failed");
                    return IInjector.NOT_A_VALUE;
                }
            }
            return graphComponent;
        }

        System.out.println("No doc selected");
        return IInjector.NOT_A_VALUE;
    }
}
