package com.example.andres.login;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by andres on 11/26/17.
 */

public class LoginRequest extends StringRequest{
    private static String LOGIN_REQUEST_URL="http://172.16.7.62/usuarios/Login.php";

    private Map<String,String> params;

    public LoginRequest(String username, String password, Response.Listener<String> listener){

        super(Request.Method.POST, LOGIN_REQUEST_URL, listener, null);
        params=new HashMap<>();

        params.put("username", username);

        params.put("password", password);



    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
