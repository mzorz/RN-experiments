package com.example.mariozorz.myapplication.component.inflated;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.example.mariozorz.myapplication.R;

import org.wordpress.aztec.AztecText;
import org.wordpress.aztec.plugins.IAztecPlugin;
import org.wordpress.aztec.plugins.shortcodes.AudioShortcodePlugin;
import org.wordpress.aztec.plugins.shortcodes.CaptionShortcodePlugin;
import org.wordpress.aztec.plugins.shortcodes.VideoShortcodePlugin;
import org.wordpress.aztec.plugins.wpcomments.WordPressCommentsPlugin;
import org.wordpress.aztec.plugins.wpcomments.toolbar.MoreToolbarButton;

public class AztecTextRNInflatedView extends FrameLayout {

    private AztecText mAztecText;
    public AztecTextRNInflatedView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView();
    }

    public AztecTextRNInflatedView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public AztecTextRNInflatedView(Context context) {
        super(context);
        initView();
    }

    private void initView() {
        mAztecText = (AztecText) inflate(getContext(), R.layout.aztec_text, null);
        addView(mAztecText);

        addPlugin(mAztecText, new WordPressCommentsPlugin(mAztecText));
        addPlugin(mAztecText, new MoreToolbarButton(mAztecText));
        addPlugin(mAztecText, new CaptionShortcodePlugin(mAztecText));
        addPlugin(mAztecText, new VideoShortcodePlugin());
        addPlugin(mAztecText, new AudioShortcodePlugin());

    }

    private void addPlugin(AztecText aztecText, IAztecPlugin plugin) {
        aztecText.getPlugins().add(plugin);
    }

    public AztecText getAztecText() {
        return mAztecText;
    }
}


