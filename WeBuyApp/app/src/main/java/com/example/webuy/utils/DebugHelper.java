package com.example.webuy.utils;

import android.content.Context;
import android.widget.Toast;

public class DebugHelper {

    public static void toast(Context context) {
        toast(context, "");
    }

    public static void toast(Context context, String message) {
        String className = Thread.currentThread().getStackTrace()[4].getClassName();
        String methodName = Thread.currentThread().getStackTrace()[4].getMethodName();

        String fullMessage = "[DEBUG in " + className + "." + methodName + "] " + message;

        Toast.makeText(context, fullMessage, Toast.LENGTH_LONG).show();
    }

    public static void console(String message) {
        String className = Thread.currentThread().getStackTrace()[4].getClassName();
        String methodName = Thread.currentThread().getStackTrace()[4].getMethodName();

        String fullMessage = "[DEBUG in " + className + "." + methodName + "] " + message;

        System.out.println(fullMessage);
    }

}
