package com.bytedance.pangle.wrapper;

import android.os.storage.StorageVolume;
import java.io.Serializable;
import java.util.function.Function;
import java.util.function.LongSupplier;
import javax.net.ssl.SNIHostName;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract /* synthetic */ class A5SV6n {
    public static /* bridge */ /* synthetic */ StorageVolume ASJ6gh(Object obj) {
        return (StorageVolume) obj;
    }

    public static /* bridge */ /* synthetic */ Function AzWtSf(Serializable serializable) {
        return (Function) serializable;
    }

    public static /* bridge */ /* synthetic */ LongSupplier B25kr6(Object obj) {
        return (LongSupplier) obj;
    }

    public static /* synthetic */ SNIHostName B2KMhB(String str) {
        return new SNIHostName(str);
    }

    public static /* synthetic */ void B3GDIM() {
    }

    public static /* bridge */ /* synthetic */ boolean BNL6CD(Serializable serializable) {
        return serializable instanceof Function;
    }

    public static /* bridge */ /* synthetic */ boolean BPw6Q8(Object obj) {
        return obj instanceof LongSupplier;
    }
}
