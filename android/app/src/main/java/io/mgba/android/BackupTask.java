/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package io.mgba.android;

import android.app.Activity;
import android.content.SharedPreferences;
import android.net.Uri;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * Full backup, in the spirit of Pizza Boy's: every preference as
 * settings.json plus the save and savestate directories, packed into one zip
 * the player picks through the system file picker. Restoring rewrites the
 * preferences and copies the files back.
 */
public final class BackupTask {
    /** Activity.getPreferences() stores under the local class name. */
    private static final String PREFS_NAME = "EmulatorActivity";
    private static final String ENTRY_PREFS = "settings.json";
    private static final String DIR_SAVES = "saves/";
    private static final String DIR_STATES = "states/";

    private BackupTask() {
    }

    /** Packs preferences + saves + states into the picked destination. */
    public static String export(Activity activity, Uri dest) throws Exception {
        SharedPreferences prefs = activity.getSharedPreferences(PREFS_NAME, Activity.MODE_PRIVATE);
        JSONObject settings = new JSONObject();
        Map<String, ?> all = prefs.getAll();
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof Integer || value instanceof Long || value instanceof Boolean
                    || value instanceof Float || value instanceof String) {
                settings.put(entry.getKey(), value);
            }
        }
        File saves = SaveLocation.prepare(activity);
        File states = new File(activity.getFilesDir(), "states");
        OutputStream target = activity.getContentResolver().openOutputStream(dest, "wt");
        if (target == null) {
            throw new IllegalStateException("no stream");
        }
        try (ZipOutputStream zip = new ZipOutputStream(target)) {
            zip.putNextEntry(new ZipEntry(ENTRY_PREFS));
            zip.write(settings.toString().getBytes(StandardCharsets.UTF_8));
            zip.closeEntry();
            List<String> failed = new ArrayList<>();
            addDir(zip, saves, DIR_SAVES, failed);
            addDir(zip, states, DIR_STATES, failed);
            return failed.isEmpty() ? null : "部分文件跳过: " + failed.size();
        }
    }

    private static void addDir(ZipOutputStream zip, File dir, String prefix, List<String> failed) {
        if (dir == null || !dir.isDirectory()) {
            return;
        }
        File[] files = dir.listFiles();
        if (files == null) {
            return;
        }
        for (File file : files) {
            if (file.isDirectory()) {
                addDir(zip, file, prefix + file.getName() + "/", failed);
                continue;
            }
            try (InputStream in = new FileInputStream(file)) {
                zip.putNextEntry(new ZipEntry(prefix + file.getName()));
                byte[] buffer = new byte[65536];
                int n;
                while ((n = in.read(buffer)) > 0) {
                    zip.write(buffer, 0, n);
                }
                zip.closeEntry();
            } catch (Exception e) {
                failed.add(file.getName());
            }
        }
    }

    /**
     * Restores a backup: rewrites the preferences and copies the saved files
     * back. Returns a human-readable summary of what landed.
     */
    public static String restore(Activity activity, Uri source) throws Exception {
        InputStream input = activity.getContentResolver().openInputStream(source);
        if (input == null) {
            throw new IllegalStateException("no stream");
        }
        // The stream cannot be read twice; stage the zip in the cache first.
        File staged = new File(activity.getCacheDir(), "restore.zip");
        try (OutputStream out = new FileOutputStream(staged)) {
            byte[] buffer = new byte[65536];
            int n;
            while ((n = input.read(buffer)) > 0) {
                out.write(buffer, 0, n);
            }
        } finally {
            input.close();
        }
        File saves = SaveLocation.prepare(activity);
        File states = new File(activity.getFilesDir(), "states");
        int files = 0;
        try (ZipFile zip = new ZipFile(staged)) {
            Enumeration<? extends ZipEntry> items = zip.entries();
            while (items.hasMoreElements()) {
                ZipEntry entry = items.nextElement();
                String name = entry.getName();
                if (name.equals(ENTRY_PREFS)) {
                    JSONObject settings = new JSONObject(readText(zip.getInputStream(entry)));
                    applyPrefs(activity, settings);
                    continue;
                }
                if (entry.isDirectory()) {
                    continue;
                }
                File dest;
                if (name.startsWith(DIR_SAVES)) {
                    dest = new File(saves, name.substring(DIR_SAVES.length()));
                } else if (name.startsWith(DIR_STATES)) {
                    dest = new File(states, name.substring(DIR_STATES.length()));
                } else {
                    continue;
                }
                if (!dest.getCanonicalPath().startsWith(dest.getParentFile().getCanonicalPath())) {
                    continue;
                }
                dest.getParentFile().mkdirs();
                try (InputStream in = zip.getInputStream(entry);
                     OutputStream out = new FileOutputStream(dest)) {
                    byte[] buffer = new byte[65536];
                    int n;
                    while ((n = in.read(buffer)) > 0) {
                        out.write(buffer, 0, n);
                    }
                }
                files++;
            }
        } finally {
            staged.delete();
        }
        return files + " 个文件已恢复";
    }

    private static void applyPrefs(Activity activity, JSONObject settings) {
        SharedPreferences.Editor editor = activity.getSharedPreferences(PREFS_NAME, Activity.MODE_PRIVATE).edit();
        java.util.Iterator<String> keys = settings.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            Object value = settings.opt(key);
            if (value instanceof Integer) {
                editor.putInt(key, (Integer) value);
            } else if (value instanceof Long) {
                editor.putLong(key, (Long) value);
            } else if (value instanceof Boolean) {
                editor.putBoolean(key, (Boolean) value);
            } else if (value instanceof Double) {
                editor.putFloat(key, ((Double) value).floatValue());
            } else if (value instanceof String) {
                editor.putString(key, (String) value);
            }
        }
        editor.apply();
    }

    private static String readText(InputStream in) throws Exception {
        StringBuilder out = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                out.append(line).append('\n');
            }
        }
        return out.toString();
    }
}
