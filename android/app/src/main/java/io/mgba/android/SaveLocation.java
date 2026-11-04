/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package io.mgba.android;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

final class SaveLocation {
    private SaveLocation() {
    }

    static boolean hasAccess(Context context) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Environment.isExternalStorageManager();
        }
        if (context.checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            return false;
        }
        return Build.VERSION.SDK_INT < 29 || Environment.isExternalStorageLegacy();
    }

    static File prepare(Context context) {
        File dest = resolve(context);
        migrate(context, dest);
        return dest;
    }

    static String visibleFolder(Context context) {
        return displayPath(context, publicDir().getAbsolutePath());
    }

    static String displayPath(Context context, String absolutePath) {
        if (absolutePath == null || absolutePath.isEmpty()) {
            return "";
        }
        String path = absolutePath.replace('\\', '/');
        String relative = relativeToPrimary(path);
        if (relative == null) {
            return path;
        }
        String label = storageLabel(context);
        if (relative.isEmpty()) {
            return label;
        }
        return label + "/" + relative;
    }

    @SuppressWarnings("deprecation")
    private static String relativeToPrimary(String path) {
        String primary = Environment.getExternalStorageDirectory().getAbsolutePath();
        String[] roots = new String[] {primary, "/storage/emulated/0", "/storage/self/primary", "/sdcard", "/mnt/sdcard"};
        for (int i = 0; i < roots.length; i++) {
            String root = roots[i];
            if (root == null || root.isEmpty()) {
                continue;
            }
            if (path.equals(root)) {
                return "";
            }
            String prefix = root.endsWith("/") ? root : root + "/";
            if (path.startsWith(prefix)) {
                return path.substring(prefix.length());
            }
        }
        return null;
    }

    private static String storageLabel(Context context) {
        String maker = Build.MANUFACTURER == null ? "" : Build.MANUFACTURER;
        String brand = Build.BRAND == null ? "" : Build.BRAND;
        if (isHonor(maker) || isHonor(brand)) {
            return "我的手机";
        }
        StorageManager manager = (StorageManager) context.getSystemService(Context.STORAGE_SERVICE);
        if (manager != null) {
            StorageVolume volume = manager.getPrimaryStorageVolume();
            if (volume != null) {
                String desc = volume.getDescription(context);
                if (desc != null && !desc.trim().isEmpty()) {
                    return desc.trim();
                }
            }
        }
        return "内部存储";
    }

    private static boolean isHonor(String name) {
        return "HONOR".equalsIgnoreCase(name) || "HUAWEI".equalsIgnoreCase(name);
    }

    @SuppressWarnings("deprecation")
    private static File publicDir() {
        return new File(Environment.getExternalStorageDirectory(), "mGBAx/saves");
    }

    private static File resolve(Context context) {
        if (hasAccess(context)) {
            File dir = publicDir();
            if (dir.isDirectory() || dir.mkdirs()) {
                return dir;
            }
        }
        File ext = context.getExternalFilesDir(null);
        if (ext != null) {
            File dir = new File(ext, "saves");
            if (dir.isDirectory() || dir.mkdirs()) {
                return dir;
            }
        }
        File internal = new File(context.getFilesDir(), "saves");
        internal.mkdirs();
        return internal;
    }

    private static void migrate(Context context, File dest) {
        copySaves(new File(context.getFilesDir(), "saves"), dest, false);
        File ext = context.getExternalFilesDir(null);
        if (ext != null) {
            copySaves(new File(ext, "saves"), dest, false);
        }
        copySaves(new File(context.getFilesDir(), "roms"), dest, true);
        // Saves dropped by the pre-rename app (mGBA/saves) carry over too.
        copySaves(new File(Environment.getExternalStorageDirectory(), "mGBA/saves"), dest, true);
    }

    private static void copySaves(File src, File dest, boolean savOnly) {
        if (src == null || dest == null || !src.isDirectory() || sameFile(src, dest)) {
            return;
        }
        File[] files = src.listFiles();
        if (files == null) {
            return;
        }
        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            if (!file.isFile() || file.length() <= 0) {
                continue;
            }
            if (savOnly && !isBatterySave(file.getName())) {
                continue;
            }
            File target = new File(dest, file.getName());
            if (target.isFile() && target.length() > 0 && target.lastModified() >= file.lastModified()) {
                continue;
            }
            if (copy(file, target)) {
                target.setLastModified(file.lastModified());
            }
        }
    }

    private static boolean isBatterySave(String name) {
        String lower = name.toLowerCase();
        if (lower.endsWith(".sav") || lower.endsWith(".srm")) {
            return true;
        }
        return lower.matches(".*\\.sa\\d$");
    }

    private static boolean sameFile(File a, File b) {
        try {
            return a.getCanonicalPath().equals(b.getCanonicalPath());
        } catch (IOException e) {
            return a.getAbsolutePath().equals(b.getAbsolutePath());
        }
    }

    private static boolean copy(File src, File dest) {
        File parent = dest.getParentFile();
        if (parent != null) {
            parent.mkdirs();
        }
        try (InputStream in = new FileInputStream(src);
             OutputStream out = new FileOutputStream(dest)) {
            byte[] buffer = new byte[65536];
            int n;
            while ((n = in.read(buffer)) > 0) {
                out.write(buffer, 0, n);
            }
            out.flush();
            return true;
        } catch (IOException e) {
            dest.delete();
            return false;
        }
    }
}
