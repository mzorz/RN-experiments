package com.example.mariozorz.myapplication.component.inflated;

import android.graphics.Color;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;


/**
 * Created by mariozorz on 3/2/18.
 */

public class AztecRNViewInflatedManager extends SimpleViewManager<AztecTextRNInflatedView> {

    public static final String REACT_CLASS = "AztecTextRNInflatedView";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected AztecTextRNInflatedView createViewInstance(ThemedReactContext reactContext) {
        return new AztecTextRNInflatedView(reactContext);
    }

    // prop setters
    @ReactProp(name = "text")
    public void setText(AztecTextRNInflatedView view, String text) {
        //view.setText(text);
        view.getAztecText().fromHtml(text);
    }

    @ReactProp(name = "color")
    public void setColor(AztecTextRNInflatedView view, String color) {
        int newColor = Color.BLACK;
        try {
            newColor = Color.parseColor(color);
        } catch (IllegalArgumentException e) {
        }
        view.getAztecText().setTextColor(newColor);
    }

//    @ReactProp(name = "autoGrow")
//    public void setAutoGrow(AztecTextRNView view, boolean autoGrow) {
//        view.setau
//    }
//
}
