package com.js.android.core.languagepack;

public class LanguagePackManager {

    String mCurrentLanguage;

    public LanguagePackManager() {
        mCurrentLanguage = "Korean";
    }

    public String getNextLanguage() {
        switch (mCurrentLanguage) {
            case "Korean":
                mCurrentLanguage = "English";
                break;
            case "English":
                mCurrentLanguage = "Korean";
                break;
        }
        return mCurrentLanguage;
    }

    public String getCurrentLanguage() {
        return mCurrentLanguage;
    }


}
