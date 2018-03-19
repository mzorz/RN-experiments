package com.example.mariozorz.myapplication.component;

import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

import java.util.Map;


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
        //view.setText(text);
        view.fromHtml(text);
    }

    @ReactProp(name = "color")
    public void setColor(AztecTextRNView view, String color) {
        int newColor = Color.BLACK;
        try {
            newColor = Color.parseColor(color);
        } catch (IllegalArgumentException e) {
        }
        view.setTextColor(newColor);
    }

//    @ReactProp(name = "autoGrow")
//    public void setAutoGrow(AztecTextRNView view, boolean autoGrow) {
//        view.setau
//    }
//

    @ReactProp(name = "onLineCountChange", defaultBoolean = false)
    public void setOnLineCountChange(final AztecTextRNView view, boolean watchOnLineCountChange) {
        if (watchOnLineCountChange) {
            //view.setLineCountWatcher(new ReactContentSizeWatcher(view));
        } else {
            //view.setLineCountWatcher(null);
        }
    }

    @Override
    public Map getExportedCustomBubblingEventTypeConstants() {
//        return MapBuilder.builder()
//                .put(
//                        "topChange",
//                        MapBuilder.of(
//                                "phasedRegistrationNames",
//                                MapBuilder.of("bubbled", "onChange")))
//                .build();

        return MapBuilder.builder()
                .put("topChange", MapBuilder.of("registrationName", "onChange"))
                .build();
    }

    @Override
    protected void addEventEmitters(ThemedReactContext reactContext, AztecTextRNView view) {
        view.setLineCountWatcher(new ReactContentSizeWatcher(reactContext, view));
    }

    public class ReactContentSizeWatcher implements TextWatcher {
        private ThemedReactContext mReactContext;
        private AztecTextRNView mAztecTextRNView;
        private int mLineCount = 0;

        public ReactContentSizeWatcher(ThemedReactContext reactContext, AztecTextRNView view) {
            mReactContext = reactContext;
            mAztecTextRNView = view;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            // no op
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            // no op
        }

        @Override
        public void afterTextChanged(Editable s) {
            int currentLineCount = mAztecTextRNView.getLineCount();
            if (mLineCount != currentLineCount) {
                mLineCount = currentLineCount;
                // TODO here send signal to JS so the RN component can change its space
                final WritableMap event = Arguments.createMap();
                event.putString("message", "MyMessage");
                event.putInt("lineCount", currentLineCount);
                mReactContext.getNativeModule(UIManagerModule.class).getEventDispatcher().dispatchEvent(
                        new Event(mAztecTextRNView.getId()) {
                            @Override
                            public String getEventName() {
                                return "topChange";
                            }

                            @Override
                            public void dispatch(RCTEventEmitter rctEventEmitter) {
                                rctEventEmitter.receiveEvent(getViewTag(), getEventName(), event);
                            }
                        }
                );
            }
        }
    }
}
