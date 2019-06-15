package org.insilico.krayon4insilico.services;

import static org.eclipse.fx.code.editor.Constants.DOCUMENT_URL;

import java.io.FileInputStream;
import java.net.URI;
import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.core.runtime.URIUtil;
import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.IContextFunction;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.IInjector;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.insilico.jsbml.core.SBMLUtils;
import org.osgi.service.component.annotations.Component;
import org.sbgn.*;
import krayon.editor.sbgn.io.SbgnReader;
import krayon.editor.sbgn.ui.SbgnGraphComponent;
import org.sbml.jsbml.SBMLDocument;
import org.sbml.jsbml.JSBML;


/**
 * The {@link SBMLDocumentLoader} provides a {@link GraphComponent} via dependency injection if the
 * current document is a sbgn file.
 * 
 * In oder to use this {@link IContextFunction} the context must store the location of a sbgn file
 * with the key {@link org.eclipse.fx.code.editor.Constants#DOCUMENT_URL}. This context function
 * will only compute values for the contextKey
 * {@link org.insilico.sbmlsheets.core.Constants#KEY_SBML_DOCUMENT}
 * 
 * @author roman
 *
 */
@SuppressWarnings("restriction")
@Component(service = IContextFunction.class,
        property = {"service.context.key=org.sbml.jsbml.SBMLDocument"})

public class SbgnDocumentLoader extends ContextFunction {
    // Stores weak reference to already loaded documents.
    Map<String, SbgnGraphComponent> cache = new WeakHashMap<>();

    @Override
    public Object compute(IEclipseContext context, String contextKey) {
        System.out.println("Compute...");
        System.out.println("Hallo");
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
                    SbgnReader reader = new SbgnReader();
                    FileInputStream in = new FileInputStream("camkii-signaling-pathway.sbgn");
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
