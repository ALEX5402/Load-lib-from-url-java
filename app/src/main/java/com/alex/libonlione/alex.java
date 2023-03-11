package com.alex.libonlione;

import android.content.Context;
import android.os.AsyncTask;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

public class alex extends AsyncTask<Void, Void, Void> {

    private Context context;
    private String url;
    private String libName;

    public alex(Context context, String url, String libName) {
        this.context = context;
        this.url = url;
        this.libName = libName;
    }

    @Override
    protected Void doInBackground(Void... params) {
        try {
            // Download file from URL to temporary directory
            File tempDir = context.getCacheDir();
            File tempFile = new File(tempDir, libName);
            URL downloadUrl = new URL(url);
            InputStream inputStream = downloadUrl.openStream();
            FileOutputStream fileOutputStream = new FileOutputStream(tempFile);
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }
            inputStream.close();
            fileOutputStream.close();

            // Load file as a system library
            System.load(tempFile.getAbsolutePath());

            // Clean up temporary file
            tempFile.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
