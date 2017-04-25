package com.oximasoft.aov.util;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {

    private static final String FILE_KEY = "com.oximasoft.aov.PREFERENCE_FILE_KEY";
    private static final String TOKEN = "com.oximasoft.aov.PREFERENCE_TOKEN";
    private static final String TOKEN_EXPIRE = "com.oximasoft.aov.PREFERENCE_TOKEN_EXPIRE";

    Context mContext;

    public Preferences(Context mContext) {
        this.mContext = mContext;
    }

    public void saveToken(String token, int expire) {
        SharedPreferences sharedPreferences =
                mContext.getSharedPreferences(FILE_KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TOKEN, token);
        editor.putInt(TOKEN_EXPIRE, expire);
        editor.apply();
    }
}
