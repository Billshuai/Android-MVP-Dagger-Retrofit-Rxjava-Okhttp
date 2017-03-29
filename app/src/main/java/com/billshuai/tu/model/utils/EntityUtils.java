package com.billshuai.tu.model.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public final class EntityUtils {

    private EntityUtils() {}

    public static final Gson gson = new GsonBuilder()
            .create();

}
