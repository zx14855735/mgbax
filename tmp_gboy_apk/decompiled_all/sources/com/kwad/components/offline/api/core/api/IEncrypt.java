package com.kwad.components.offline.api.core.api;

import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public interface IEncrypt {
    String getFileMD5(File file);

    byte[] getFileMD5Digest(File file);

    String getFileSha256(File file);

    String getMD5(String str);

    String getResponseData(String str);

    String getSha256(String str);
}
