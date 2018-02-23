package com.example.mariozorz.myapplication;

import android.text.InputFilter;
import android.text.Spanned;
import android.util.Log;
import android.widget.EditText;

/**
 * Created by mariozorz on 11/27/17.
 */

public class TestEditMario {

    EditText mEditText;

    public TestEditMario(EditText editText ) {
        mEditText = editText;
    }

    public InputFilter[] getMyFilters() {
        return mEditText.getFilters();
    }

    public void setMyFilters(InputFilter[] newFilters) {
        mEditText.setFilters(newFilters);
    }

    public InputFilter getExampleFilter() {
        return new InputFilter() {
            @Override
            public CharSequence filter(CharSequence charSequence, int start, int end, Spanned dest, int dstart, int dend) {
                Log.d("NORMAL TEST", "FILTER: \"" + charSequence + "\" start: " + start + " end: " + end + " dest: \"" + dest
                + "\" dstart: " + dstart + " dend: " + dend);
                return charSequence;
            }
        };
    }

    public void addExampleFilter() {
        InputFilter[] oldfilters = mEditText.getFilters();
        Log.d("NORMAL TEST", "amount of filters: \"" + oldfilters.length + "\"");
        InputFilter[] newFilters = new InputFilter[oldfilters.length+1];
        for (int i = 0; i < oldfilters.length; i++) {
            newFilters[i] = oldfilters[i];
        }
        newFilters[oldfilters.length] = getExampleFilter();
        setMyFilters(newFilters);
    }
}
