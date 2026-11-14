package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaoaaaaa;

import android.content.Context;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaeo;
import java.io.InputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aaaaaaaa implements Runnable {
    private Context aaaaaaa0;
    private InterfaceC0539aaaaaaaa aaaaaaaa;
    private String aaaaaaac;
    private String aaaaaaao;

    /* renamed from: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaoaaaaa.aaaaaaaa$aaaaaaaa, reason: collision with other inner class name */
    public interface InterfaceC0539aaaaaaaa {
        void aaaaaaa0(aaaaaaaa aaaaaaaaVar);

        void aaaaaaaa(aaaaaaaa aaaaaaaaVar);
    }

    public String aaaaaaa0() {
        return this.aaaaaaac;
    }

    public void aaaaaaaa(Context context, String str, String str2) {
        this.aaaaaaa0 = context;
        this.aaaaaaao = str;
        this.aaaaaaac = str2;
    }

    public String aaaaaaao() {
        return this.aaaaaaao;
    }

    @Override // java.lang.Runnable
    public void run() {
        InputStream aaaaaaaa = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.acaaaaaa.aaaaaaac.aaaaaaaa(this.aaaaaaao, KSImageLoader.InnerImageLoadingListener.MAX_DURATION, true, new String[1]);
        InterfaceC0539aaaaaaaa interfaceC0539aaaaaaaa = this.aaaaaaaa;
        if (interfaceC0539aaaaaaaa != null) {
            if (aaaaaaaa == null) {
                interfaceC0539aaaaaaaa.aaaaaaa0(this);
            } else {
                aaaaaaeo.aaaaaaaa(aaaaaaaa, this.aaaaaaac);
                this.aaaaaaaa.aaaaaaaa(this);
            }
        }
    }

    public void aaaaaaaa(InterfaceC0539aaaaaaaa interfaceC0539aaaaaaaa) {
        this.aaaaaaaa = interfaceC0539aaaaaaaa;
    }

    public Context aaaaaaaa() {
        return this.aaaaaaa0;
    }
}
