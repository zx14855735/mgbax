package com.czhj.sdk.common.network;

import java.net.InetAddress;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
class InetAddressUtils {
    private InetAddressUtils() {
    }

    public static InetAddress getInetAddressByName(String str) {
        return InetAddress.getByName(str);
    }
}
