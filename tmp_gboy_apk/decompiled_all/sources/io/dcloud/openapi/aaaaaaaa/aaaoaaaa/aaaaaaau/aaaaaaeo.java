package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaau;

import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaacaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaoaaa;
import java.net.Proxy;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class aaaaaaeo {
    private static boolean aaaaaaa0(aaaacaaa aaaacaaaVar, Proxy.Type type) {
        return !aaaacaaaVar.aaaaaaac() && type == Proxy.Type.HTTP;
    }

    public static String aaaaaaaa(aaaacaaa aaaacaaaVar, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(aaaacaaaVar.aaaaaaau());
        sb.append(' ');
        if (aaaaaaa0(aaaacaaaVar, type)) {
            sb.append(aaaacaaaVar.aaaaaaae());
        } else {
            sb.append(aaaaaaaa(aaaacaaaVar.aaaaaaae()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    public static String aaaaaaaa(aaaaoaaa aaaaoaaaVar) {
        String aaaaaaao = aaaaoaaaVar.aaaaaaao();
        String aaaaaaau = aaaaoaaaVar.aaaaaaau();
        if (aaaaaaau == null) {
            return aaaaaaao;
        }
        return aaaaaaao + '?' + aaaaaaau;
    }
}
