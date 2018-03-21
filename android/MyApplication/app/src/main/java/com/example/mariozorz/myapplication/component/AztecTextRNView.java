package com.example.mariozorz.myapplication.component;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.LinearLayout;

import org.wordpress.aztec.AztecText;
import org.wordpress.aztec.plugins.IAztecPlugin;
import org.wordpress.aztec.plugins.shortcodes.AudioShortcodePlugin;
import org.wordpress.aztec.plugins.shortcodes.CaptionShortcodePlugin;
import org.wordpress.aztec.plugins.shortcodes.VideoShortcodePlugin;
import org.wordpress.aztec.plugins.wpcomments.WordPressCommentsPlugin;
import org.wordpress.aztec.plugins.wpcomments.toolbar.MoreToolbarButton;

public class AztecTextRNView extends AztecText {

    public AztecTextRNView(Context context) {
        super(context);
        setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));

        addPlugin(new WordPressCommentsPlugin(this));
        addPlugin(new MoreToolbarButton(this));
        addPlugin(new CaptionShortcodePlugin(this));
        addPlugin(new VideoShortcodePlugin());
        addPlugin(new AudioShortcodePlugin());
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.d("AZTECTEXTNATIVE", "onLayout called!");
    }

    private void addPlugin(IAztecPlugin plugin) {
        super.getPlugins().add(plugin);
    }

    public void setLineCountWatcher(AztecRNViewManager.ReactContentSizeWatcher lineCountWatcher) {
        // try removing the listener if this very same instance is already added
        removeTextChangedListener(lineCountWatcher);
        addTextChangedListener(lineCountWatcher);
    }
}
