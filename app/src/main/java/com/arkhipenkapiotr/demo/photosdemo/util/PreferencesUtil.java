package com.arkhipenkapiotr.demo.photosdemo.util;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.arkhipenkapiotr.demo.photosdemo.app.api_models.UserDTO;

/**
 * Created by arhip on 15.02.2018.
 */

public class PreferencesUtil {
    private static final String LOGIN_KEY = "login_key";
    private static final String TOKEN_KEY = "token_key";
    private static final String USER_ID_KEY = "user_id_key";
    private static final Long TOKEN_DEFAULT = 0L;

    public static void putUserDTO (Activity activity, UserDTO userDTO){
        SharedPreferences sharedPreferences = activity.getPreferences(Context.MODE_PRIVATE);
        if (sharedPreferences!=null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(LOGIN_KEY, userDTO.getLogin());
            editor.putString(TOKEN_KEY, userDTO.getToken());
            editor.putLong(USER_ID_KEY, userDTO.getUserId());

            editor.commit();
        }
    }

    public static UserDTO getUserDTO(Activity activity){
        SharedPreferences sharedPreferences = activity.getPreferences(Context.MODE_PRIVATE);
        String login = sharedPreferences.getString(LOGIN_KEY,null);
        String token = sharedPreferences.getString(TOKEN_KEY, null);
        Long userId = sharedPreferences.getLong(USER_ID_KEY, TOKEN_DEFAULT);

        return new UserDTO(login, token, userId);
    }
}
