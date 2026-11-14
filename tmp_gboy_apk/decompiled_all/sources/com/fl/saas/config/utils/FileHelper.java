package com.fl.saas.config.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class FileHelper {
    public static void deleteAllFilesInDirectory(File file) {
        File[] listFiles;
        if (!file.isDirectory() || (listFiles = file.listFiles()) == null || listFiles.length == 0) {
            return;
        }
        for (File file2 : listFiles) {
            if (file2.isFile()) {
                try {
                    file2.delete();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (file2.isDirectory()) {
                deleteAllFilesInDirectory(file2);
            }
        }
    }

    public static void deleteFile(File file) {
        if (file == null || file.exists()) {
            return;
        }
        try {
            if (file.isFile()) {
                file.delete();
            } else if (file.isDirectory()) {
                deleteAllFilesInDirectory(file);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteNotSelectedFilesInDirectory(File file, List<String> list) {
        deleteSelectedFilesDirectory(file, list, false);
    }

    private static void deleteSelectedFilesDirectory(File file, List<String> list, boolean z) {
        File[] listFiles;
        if (!file.isDirectory() || (listFiles = file.listFiles()) == null || listFiles.length == 0) {
            return;
        }
        for (File file2 : listFiles) {
            if (list.contains(file2.getName()) == z) {
                return;
            }
            if (file2.isFile()) {
                try {
                    file2.delete();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                deleteAllFilesInDirectory(file2);
            }
        }
    }

    public static void deleteSelectedFilesInDirectory(File file, List<String> list) {
        deleteSelectedFilesDirectory(file, list, true);
    }

    public static InputStream getAssets(String str) {
        try {
            return DeviceUtil.getContext().getAssets().open(str);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<String> getFileNamesInDirectory(File file) {
        File[] listFiles;
        ArrayList arrayList = new ArrayList();
        if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    arrayList.add(file2.getPath());
                }
            }
        }
        return arrayList;
    }
}
