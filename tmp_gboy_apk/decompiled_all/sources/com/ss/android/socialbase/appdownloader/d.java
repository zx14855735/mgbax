package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import com.bytedance.sdk.component.utils.pl;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class d {
    public static int hf(String str) {
        return xj(com.ss.android.socialbase.downloader.downloader.w.tj(), str);
    }

    public static int kd(String str) {
        try {
            return com.ss.android.socialbase.downloader.downloader.w.tj().getResources().getIdentifier(str, com.sigmob.sdk.downloader.core.breakpoint.f.f13353a, com.ss.android.socialbase.downloader.downloader.w.tj().getPackageName());
        } catch (Exception e) {
            pl.xj(e);
            return 0;
        }
    }

    public static int u(String str) {
        try {
            return com.ss.android.socialbase.downloader.downloader.w.tj().getResources().getIdentifier(str, "style", com.ss.android.socialbase.downloader.downloader.w.tj().getPackageName());
        } catch (Exception e) {
            pl.xj(e);
            return 0;
        }
    }

    public static int w(String str) {
        try {
            return xj(str, com.ss.android.socialbase.downloader.downloader.w.tj().getPackageName());
        } catch (Exception e) {
            pl.xj(e);
            return 0;
        }
    }

    public static int xj(String str) {
        try {
            return com.ss.android.socialbase.downloader.downloader.w.tj().getResources().getIdentifier(str, "layout", com.ss.android.socialbase.downloader.downloader.w.tj().getPackageName());
        } catch (Exception e) {
            pl.xj(e);
            return 0;
        }
    }

    public static int y(String str) {
        try {
            return com.ss.android.socialbase.downloader.downloader.w.tj().getResources().getIdentifier(str, "color", com.ss.android.socialbase.downloader.downloader.w.tj().getPackageName());
        } catch (Exception e) {
            pl.xj(e);
            return 0;
        }
    }

    public static int hf(String str, String str2) {
        try {
            return com.ss.android.socialbase.downloader.downloader.w.tj().getResources().getIdentifier(str, "attr", str2);
        } catch (Exception e) {
            pl.xj(e);
            return 0;
        }
    }

    public static int xj(Context context, String str) {
        try {
            return context.getResources().getIdentifier(str, "string", context.getPackageName());
        } catch (Exception e) {
            pl.xj(e);
            return 0;
        }
    }

    public static int xj(String str, String str2) {
        try {
            return com.ss.android.socialbase.downloader.downloader.w.tj().getResources().getIdentifier(str, "drawable", str2);
        } catch (Exception e) {
            pl.xj(e);
            return 0;
        }
    }
}
