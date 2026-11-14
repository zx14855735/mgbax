package com.kwad.sdk.crash.utils;

import com.bykv.vk.component.ttvideo.player.A2egSU;
import java.io.File;
import java.io.IOException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class FileExistsException extends IOException {
    private static final long serialVersionUID = 1;

    public FileExistsException() {
    }

    public FileExistsException(String str) {
        super(str);
    }

    public FileExistsException(File file) {
        super(A2egSU.AlLFFp("File ", file, " already exists"));
    }
}
