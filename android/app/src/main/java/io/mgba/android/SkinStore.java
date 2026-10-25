/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package io.mgba.android;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Full PNG skins, in the spirit of Pizza Boy's 整包皮肤: a zip (or directory)
 * holding one PNG per button — dpad / a / b / l / r / select / start, with an
 * optional {@code _p} suffix for the pressed look and optional
 * bg_portrait.png / bg_landscape.png backgrounds. Skins live in
 * {@code <files>/skins/<name>/} and are picked in the skin dialog.
 */
public final class SkinStore {
    /** Button keys a skin may provide, in drawing order. */
    public static final String[] BUTTONS = {"dpad", "a", "b", "l", "r", "select", "start"};

    private final File root;

    public SkinStore(Context context) {
        root = new File(context.getFilesDir(), "skins");
        root.mkdirs();
    }

    public List<String> list() {
        List<String> out = new ArrayList<>();
        File[] dirs = root.listFiles();
        if (dirs != null) {
            for (File dir : dirs) {
                if (dir.isDirectory()) {
                    out.add(dir.getName());
                }
            }
        }
        java.util.Collections.sort(out, String.CASE_INSENSITIVE_ORDER);
        return out;
    }

    public File dirOf(String name) {
        return new File(root, sanitize(name));
    }

    /** Extracts the picked zip into a new skin directory; null on failure. */
    public String importZip(Context context, Uri source, String suggestedName) {
        String name = sanitize(suggestedName != null ? suggestedName : "skin");
        File dir = dirOf(name);
        int serial = 2;
        while (dir.isDirectory()) {
            dir = dirOf(name + "-" + serial++);
        }
        dir.mkdirs();
        int images = 0;
        try (ZipInputStream zip = new ZipInputStream(context.getContentResolver().openInputStream(source))) {
            ZipEntry entry;
            byte[] buffer = new byte[65536];
            while ((entry = zip.getNextEntry()) != null) {
                if (entry.isDirectory()) {
                    continue;
                }
                String entryName = new File(entry.getName()).getName().toLowerCase(Locale.ROOT);
                if (!entryName.endsWith(".png")) {
                    continue;
                }
                try (OutputStream out = new FileOutputStream(new File(dir, entryName))) {
                    int n;
                    while ((n = zip.read(buffer)) > 0) {
                        out.write(buffer, 0, n);
                    }
                }
                images++;
            }
        } catch (Exception e) {
            deleteRecursive(dir);
            return null;
        }
        if (images == 0 || !hasButtonImage(dir)) {
            deleteRecursive(dir);
            return null;
        }
        return dir.getName();
    }

    private static boolean hasButtonImage(File dir) {
        String[] files = dir.list();
        if (files == null) {
            return false;
        }
        for (String file : files) {
            for (String key : BUTTONS) {
                if (file.equalsIgnoreCase(key + ".png") || file.equalsIgnoreCase(key + "_p.png")) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Imports a skin from a plain folder (no file picker needed): copies the
     * PNGs into the store. Returns the imported skin name, or null when the
     * folder holds no usable button images.
     */
    public String importDir(String name, File source) {
        String[] files = source == null ? null : source.list();
        if (files == null || files.length == 0) {
            return null;
        }
        File dir = dirOf(name);
        int serial = 2;
        while (dir.isDirectory()) {
            dir = dirOf(name + "-" + serial++);
        }
        dir.mkdirs();
        int images = 0;
        try {
            for (String file : files) {
                if (!file.toLowerCase(Locale.ROOT).endsWith(".png")) {
                    continue;
                }
                try (InputStream in = new java.io.FileInputStream(new File(source, file));
                     OutputStream out = new FileOutputStream(new File(dir, file))) {
                    byte[] buffer = new byte[65536];
                    int n;
                    while ((n = in.read(buffer)) > 0) {
                        out.write(buffer, 0, n);
                    }
                }
                images++;
            }
        } catch (Exception e) {
            deleteRecursive(dir);
            return null;
        }
        if (!hasButtonImage(dir)) {
            deleteRecursive(dir);
            return null;
        }
        return dir.getName();
    }

    public void delete(String name) {
        deleteRecursive(dirOf(name));
    }

    /**
     * Loads every PNG of a skin into memory. Keys are the button names for
     * {@code <key>.png} / {@code <key>_p.png}, plus "bg_portrait" and
     * "bg_landscape". Missing entries are simply absent from the map.
     */
    public Map<String, Bitmap> load(String name) {
        Map<String, Bitmap> out = new HashMap<>();
        File dir = dirOf(name);
        String[] files = dir.list();
        if (files == null) {
            return out;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;
        for (String file : files) {
            String lower = file.toLowerCase(Locale.ROOT);
            if (!lower.endsWith(".png")) {
                continue;
            }
            String base = lower.substring(0, lower.length() - 4);
            Bitmap bitmap = BitmapFactory.decodeFile(new File(dir, file).getAbsolutePath(), options);
            if (bitmap != null) {
                out.put(base, bitmap);
            }
        }
        return out;
    }

    private static String sanitize(String name) {
        String clean = name == null ? "skin" : name.replaceAll("[\\\\/:*?\"<>|]", "_").trim();
        if (clean.isEmpty() || clean.length() > 60) {
            clean = "skin";
        }
        return clean;
    }

    private static void deleteRecursive(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        File[] children = file.listFiles();
        if (children != null) {
            for (File child : children) {
                deleteRecursive(child);
            }
        }
        file.delete();
    }
}
