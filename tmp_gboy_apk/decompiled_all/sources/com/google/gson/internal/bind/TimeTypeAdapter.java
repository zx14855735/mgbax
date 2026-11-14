package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Method;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class TimeTypeAdapter extends TypeAdapter<Time> {

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final TypeAdapterFactory f12154A4TApA = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TimeTypeAdapter.1
        @Override // com.google.gson.TypeAdapterFactory
        public final TypeAdapter create(Gson gson, TypeToken typeToken) {
            if (typeToken.getRawType() == Time.class) {
                return new TimeTypeAdapter();
            }
            return null;
        }
    };

    /* renamed from: A2egSU, reason: collision with root package name */
    public final SimpleDateFormat f12155A2egSU = new SimpleDateFormat("hh:mm:ss a");

    static {
        kiDIO();
    }

    private static /* synthetic */ void kiDIO() {
        char[] charArray = "ÝÑÓ\u0090ÙßÓÛ\u0090ÜÑÇ\u0090ÍÖÛÒÒ\u0090ôÐ×üÌ×ÚÙÛ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 190);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÝÒ×Ð×Ê".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 190);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Time read2(Q2dWmT.A4TApA a4TApA) {
        synchronized (this) {
            if (a4TApA.BChYOn() == 9) {
                a4TApA.B3GDIM();
                return null;
            }
            try {
                return new Time(this.f12155A2egSU.parse(a4TApA.B7CMnp()).getTime());
            } catch (ParseException e) {
                throw new JsonSyntaxException(e);
            }
        }
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(Q2dWmT.A5SV6n a5SV6n, Time time) {
        Time time2 = time;
        synchronized (this) {
            a5SV6n.B25kr6(time2 == null ? null : this.f12155A2egSU.format((Date) time2));
        }
    }
}
