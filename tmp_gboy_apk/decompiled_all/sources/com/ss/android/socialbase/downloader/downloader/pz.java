package com.ss.android.socialbase.downloader.downloader;

import com.ss.android.socialbase.downloader.network.IDownloadHttpService;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface pz {

    public static class xj implements pz {
        @Override // com.ss.android.socialbase.downloader.downloader.pz
        public IDownloadHttpService hf() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.pz
        public com.ss.android.socialbase.downloader.network.f w() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.pz
        public com.ss.android.socialbase.downloader.exception.c xj(Throwable th, String str) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.pz
        public boolean xj() {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.pz
        public boolean xj(Throwable th) {
            return false;
        }
    }

    IDownloadHttpService hf();

    com.ss.android.socialbase.downloader.network.f w();

    com.ss.android.socialbase.downloader.exception.c xj(Throwable th, String str);

    boolean xj();

    boolean xj(Throwable th);
}
