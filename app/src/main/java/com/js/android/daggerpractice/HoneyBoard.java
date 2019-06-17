package com.js.android.daggerpractice;

import android.graphics.Color;
import android.inputmethodservice.InputMethodService;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.js.android.core.languagepack.LanguagePackManager;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class HoneyBoard extends InputMethodService {

    @Inject
    String test;

    @Inject
    LanguagePackManager mLanguagePackManager;

    @Override
    public void onCreate() {
        AndroidInjection.inject(this);
        super.onCreate();
    }

    @Override
    public View onCreateInputView() {
        Button button1 = new Button(this);
        button1.setText("Honey");
        button1.setTextColor(Color.RED);

        Button button2 = new Button(this);
        button2.setText("Board");
        button2.setTextColor(Color.RED);

        Button button3 = new Button(this);
        button3.setText(mLanguagePackManager.getCurrentLanguage());
        button3.setTextColor(Color.RED);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Button) v).setText(mLanguagePackManager.getNextLanguage());
            }
        });

        final LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.addView(button1);
        layout.addView(button2);
        layout.addView(button3);
        return layout;
    }
}
