package org.insilico.krayon4insilico.services.provider;

import org.eclipse.fx.code.editor.fx.e4.EditorClassURLProvider;
import org.insilico.krayon4insilico.view.View;
import org.osgi.service.component.annotations.Component;

@Component
public class SbgnEditorProvider implements EditorClassURLProvider {

    @Override
    public boolean test(String t) {
        return t.endsWith("sbgn");
    }

    @Override
    public String getBundleClassURI(String uri) {
        return "bundleclass://org.insilico.krayon4insilico/" + View.class.getName();
    }
}
