package com.bytedance.sdk.openadsdk.api.plugin;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj extends ContextWrapper {
    private File c;
    private File f;
    private File hf;
    private File kd;
    private File u;
    private File w;
    private final Object xj;
    private File y;

    public xj(Context context) {
        super(context);
        this.xj = new Object();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String[] databaseList() {
        if (xj() == null) {
            return super.databaseList();
        }
        String[] databaseList = super.databaseList();
        int length = databaseList.length;
        boolean[] zArr = new boolean[length];
        int i = 0;
        for (int i2 = 0; i2 < databaseList.length; i2++) {
            if (databaseList[i2].startsWith(xj())) {
                zArr[i2] = true;
                i++;
            } else {
                zArr[i2] = false;
            }
        }
        String[] strArr = new String[i];
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (zArr[i4]) {
                strArr[i3] = databaseList[i4];
                i3++;
            }
        }
        return strArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteDatabase(String str) {
        return xj() == null ? super.deleteDatabase(str) : super.deleteDatabase(xj(str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteFile(String str) {
        return xj(getFilesDir(), str).delete();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteSharedPreferences(String str) {
        return xj() == null ? super.deleteSharedPreferences(str) : super.deleteSharedPreferences(xj(str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getCacheDir() {
        File xj;
        if (xj() == null) {
            return super.getCacheDir();
        }
        synchronized (this.xj) {
            try {
                if (this.y == null) {
                    this.y = new File(super.getCacheDir(), xj());
                }
                xj = xj(this.y);
            } catch (Throwable th) {
                throw th;
            }
        }
        return xj;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getCodeCacheDir() {
        File xj;
        if (xj() == null) {
            return super.getCodeCacheDir();
        }
        synchronized (this.xj) {
            try {
                if (this.c == null) {
                    this.c = new File(super.getCodeCacheDir(), xj());
                }
                xj = xj(this.c);
            } catch (Throwable th) {
                throw th;
            }
        }
        return xj;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDataDir() {
        File xj;
        if (xj() == null) {
            return super.getDataDir();
        }
        synchronized (this.xj) {
            try {
                if (this.hf == null) {
                    this.hf = new File(hf(), xj());
                }
                xj = xj(this.hf);
            } catch (Throwable th) {
                throw th;
            }
        }
        return xj;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDatabasePath(String str) {
        return xj() == null ? super.getDatabasePath(str) : super.getDatabasePath(xj(str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDir(String str, int i) {
        return (i != 0 || xj() == null) ? super.getDir(str, i) : xj(new File(super.getDir(str, i), xj()));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getExternalCacheDir() {
        File xj;
        if (xj() == null) {
            return super.getExternalCacheDir();
        }
        synchronized (this.xj) {
            try {
                if (this.f == null) {
                    this.f = new File(super.getExternalCacheDir(), xj());
                }
                xj = xj(this.f);
            } catch (Throwable th) {
                throw th;
            }
        }
        return xj;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalCacheDirs() {
        if (xj() == null) {
            return super.getExternalCacheDirs();
        }
        File[] externalCacheDirs = super.getExternalCacheDirs();
        File[] fileArr = new File[externalCacheDirs.length];
        for (int i = 0; i < externalCacheDirs.length; i++) {
            fileArr[i] = xj(new File(externalCacheDirs[i], xj()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getExternalFilesDir(String str) {
        return xj() == null ? super.getExternalFilesDir(str) : xj(new File(super.getExternalFilesDir(str), xj()));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalFilesDirs(String str) {
        if (xj() == null) {
            return super.getExternalFilesDirs(str);
        }
        File[] externalFilesDirs = super.getExternalFilesDirs(str);
        File[] fileArr = new File[externalFilesDirs.length];
        for (int i = 0; i < externalFilesDirs.length; i++) {
            fileArr[i] = xj(new File(externalFilesDirs[i], xj()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getExternalMediaDirs() {
        if (xj() == null) {
            return super.getExternalMediaDirs();
        }
        File[] externalMediaDirs = super.getExternalMediaDirs();
        File[] fileArr = new File[externalMediaDirs.length];
        for (int i = 0; i < externalMediaDirs.length; i++) {
            fileArr[i] = xj(new File(externalMediaDirs[i], xj()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getFilesDir() {
        File xj;
        if (xj() == null) {
            return super.getFilesDir();
        }
        synchronized (this.xj) {
            try {
                if (this.w == null) {
                    this.w = new File(super.getFilesDir(), xj());
                }
                xj = xj(this.w);
            } catch (Throwable th) {
                throw th;
            }
        }
        return xj;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getNoBackupFilesDir() {
        File xj;
        if (xj() == null) {
            return super.getNoBackupFilesDir();
        }
        synchronized (this.xj) {
            try {
                if (this.u == null) {
                    this.u = new File(super.getNoBackupFilesDir(), xj());
                }
                xj = xj(this.u);
            } catch (Throwable th) {
                throw th;
            }
        }
        return xj;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getObbDir() {
        File xj;
        if (xj() == null) {
            return super.getObbDir();
        }
        synchronized (this.xj) {
            try {
                if (this.kd == null) {
                    this.kd = new File(super.getObbDir(), xj());
                }
                xj = xj(this.kd);
            } catch (Throwable th) {
                throw th;
            }
        }
        return xj;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File[] getObbDirs() {
        if (xj() == null) {
            return super.getObbDirs();
        }
        File[] obbDirs = super.getObbDirs();
        File[] fileArr = new File[obbDirs.length];
        for (int i = 0; i < obbDirs.length; i++) {
            fileArr[i] = xj(new File(obbDirs[i], xj()));
        }
        return fileArr;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i) {
        return (i != 0 || xj() == null) ? super.getSharedPreferences(str, i) : super.getSharedPreferences(xj(str), i);
    }

    public File hf() {
        return super.getFilesDir().getParentFile();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean moveDatabaseFrom(Context context, String str) {
        if (xj() == null) {
            return super.moveDatabaseFrom(context, str);
        }
        throw new UnsupportedOperationException("Calling moveDatabaseFrom in plugins is not supported.");
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileInputStream openFileInput(String str) {
        return xj() == null ? super.openFileInput(str) : new FileInputStream(xj(getFilesDir(), str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileOutputStream openFileOutput(String str, int i) {
        return (i != 0 || xj() == null) ? super.openFileOutput(str, i) : new FileOutputStream(xj(getFilesDir(), str), false);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory) {
        return (i != 0 || xj() == null) ? super.openOrCreateDatabase(str, i, cursorFactory) : super.openOrCreateDatabase(xj(str), i, cursorFactory);
    }

    public String xj() {
        return "pangle_com.byted.pangle";
    }

    private String xj(String str) {
        return xj() + "_" + str;
    }

    private static File xj(File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        if (i == 0 && xj() != null) {
            return super.openOrCreateDatabase(xj(str), i, cursorFactory, databaseErrorHandler);
        }
        return super.openOrCreateDatabase(str, i, cursorFactory, databaseErrorHandler);
    }

    private static File xj(File file, String str) {
        if (str.indexOf(File.separatorChar) < 0) {
            return new File(file, str);
        }
        throw new IllegalArgumentException(CtFAbx.BI9f7h("File ", str, " contains a path separator"));
    }
}
