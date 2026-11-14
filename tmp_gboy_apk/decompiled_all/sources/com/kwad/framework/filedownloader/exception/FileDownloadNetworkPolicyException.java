package com.kwad.framework.filedownloader.exception;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class FileDownloadNetworkPolicyException extends FileDownloadGiveUpRetryException {
    public FileDownloadNetworkPolicyException() {
        super("Only allows downloading this task on the wifi network type");
    }
}
