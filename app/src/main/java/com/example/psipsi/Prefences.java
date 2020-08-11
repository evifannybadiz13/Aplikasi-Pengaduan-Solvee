package com.example.psipsi;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.psipsi.retorofit.user.User;

public class Prefences {
    private static final String SHARED_PREF_NAME = "my_shared_preff";

    private static Prefences mInstance;
    private Context mCtx;

    private Prefences(Context mCtx) {
        this.mCtx = mCtx;
    }


    public static synchronized Prefences getInstance(Context mCtx) {
        if (mInstance == null) {
            mInstance = new Prefences(mCtx);
        }
        return mInstance;
    }


    public void saveUser(User user) {

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt("id", user.getId());
        editor.putString("name", user.getName());
        editor.putString("role", user.getRole());
        editor.putString("nik", user.getNik());
        editor.apply();

    }
    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        int parseInt = sharedPreferences.getInt("id" ,-1);
        return parseInt != -1;
    }

    public User getUser() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new User(
                sharedPreferences.getInt("id", 1),
                sharedPreferences.getString("name", null),
                sharedPreferences.getString("username", null),
                sharedPreferences.getString("nik", null)
        );
    }

    public void clear() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
