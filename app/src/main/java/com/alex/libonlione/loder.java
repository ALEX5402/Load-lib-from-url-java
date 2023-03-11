package com.alex.libonlione;

import android.content.Context;
import android.widget.Toast;

public class loder

{

    static {
        System.loadLibrary("native");



    }

public static native String link();
public static native String libname();
public static void Start(Context context){
try{
    if(libload()){
        new alex(context, link(), libname()).execute();
        Toast.makeText(context, "Downloading", Toast.LENGTH_SHORT).show();
    }
}catch (Exception e) {
    e.printStackTrace();
}
}
private static boolean libload(){
    try {
        System.loadLibrary("native");
        return true;
    }catch (Exception e){
        return false;   // cheak the lib is loaded or not
    }
}


}
