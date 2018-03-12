package com.example.mariozorz.myapplication.component;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;


/**
 * Created by mariozorz on 3/2/18.
 */

public class AztecRNViewManager extends SimpleViewManager<AztecTextRNView> {

    public static final String REACT_CLASS = "AztecTextRNView";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected AztecTextRNView createViewInstance(ThemedReactContext reactContext) {
        return new AztecTextRNView(reactContext);
    }

    // prop setters
    @ReactProp(name = "text")
    public void setText(AztecTextRNView view, String text) {
        view.setText(text);
    }

}
