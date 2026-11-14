package com.octopus.ad;

import android.os.Bundle;
import com.octopus.ad.internal.network.a;
import com.octopus.ad.internal.w;
import java.lang.reflect.Method;
import java.util.Date;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class AdRequest {

    /* renamed from: a, reason: collision with root package name */
    public static final String f12323a = com.octopus.ad.internal.network.a.b;
    private final a.C0411a b;

    public static final class Builder {
        private final a.C0411a mImpl;

        public Builder() {
            a.C0411a c0411a = new a.C0411a();
            this.mImpl = c0411a;
            c0411a.b(AdRequest.f12323a);
        }

        public Builder addKeyword(String str) {
            this.mImpl.a(str);
            return this;
        }

        public Builder addNetworkExtrasBundle(Class<? extends Object> cls, Bundle bundle) {
            this.mImpl.a(cls, bundle);
            return this;
        }

        public Builder addTestDevice(String str) {
            this.mImpl.b(str);
            return this;
        }

        public AdRequest build() {
            return new AdRequest(this);
        }

        public Builder setBirthday(Date date) {
            this.mImpl.a(date);
            return this;
        }

        public Builder setContentUrl(String str) {
            w.a(str, (Object) "Content URL must be non-null.");
            w.a(str, (Object) "Content URL must be non-empty.");
            w.a(str.length() <= 512, "Content URL must not exceed %d in length.  Provided length was %d.", 512, Integer.valueOf(str.length()));
            this.mImpl.c(str);
            return this;
        }

        public Builder setGender(int i) {
            this.mImpl.a(i);
            return this;
        }

        public Builder setIsDesignedForFamilies(boolean z) {
            this.mImpl.b(z);
            return this;
        }

        public Builder setRequestAgent(String str) {
            this.mImpl.d(str);
            return this;
        }

        public Builder tagForChildDirectedTreatment(boolean z) {
            this.mImpl.a(z);
            return this;
        }
    }

    static {
        wPlXUDj();
    }

    private static /* synthetic */ void wPlXUDj() {
        char[] charArray = "ËÇÅ\u0086ÏÉÅÍ\u0086ÊÇÑ\u0086ÛÀÍÄÄ\u0086âÆÁêÚÁÌÏÍ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 168);
        }
        String str = new String(charArray);
        char[] charArray2 = "ËÄÁÆÁÜ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 168);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public a.C0411a a() {
        return this.b;
    }

    private AdRequest(Builder builder) {
        this.b = builder.mImpl;
    }
}
