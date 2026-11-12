/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package io.mgba.android;

import android.app.Application;
import android.system.ErrnoException;
import android.system.Os;
import android.util.Log;

import java.io.File;

public class MgbaApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        File files = getFilesDir();
        File configHome = new File(files, "config");
        new File(files, "saves").mkdirs();
        new File(files, "states").mkdirs();
        new File(files, "roms").mkdirs();
        new File(configHome, "mgba").mkdirs();
        try {
            Os.setenv("HOME", files.getAbsolutePath(), true);
            Os.setenv("XDG_CONFIG_HOME", configHome.getAbsolutePath(), true);
        } catch (ErrnoException e) {
            Log.e("mGBA", "setenv failed", e);
        }
    }
}
