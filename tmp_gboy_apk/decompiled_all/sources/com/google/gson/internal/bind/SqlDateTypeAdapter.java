package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Method;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class SqlDateTypeAdapter extends TypeAdapter<Date> {

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final TypeAdapterFactory f12152A4TApA = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.SqlDateTypeAdapter.1
        @Override // com.google.gson.TypeAdapterFactory
        public final TypeAdapter create(Gson gson, TypeToken typeToken) {
            if (typeToken.getRawType() == Date.class) {
                return new SqlDateTypeAdapter();
            }
            return null;
        }
    };

    /* renamed from: A2egSU, reason: collision with root package name */
    public final SimpleDateFormat f12153A2egSU = new SimpleDateFormat("MMM d, yyyy");

    static {
        ERyNfaf();
    }

    private static /* synthetic */ void ERyNfaf() {
        char[] charArray = "\u0003\u000f\rN\u0007\u0001\r\u0005N\u0002\u000f\u0019N\u0013\b\u0005\f\fN*\u000e\t\"\u0012\t\u0004\u0007\u0005".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '`');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0003\f\t\u000e\t\u0014".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '`');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Date read2(Q2dWmT.A4TApA a4TApA) {
        synchronized (this) {
            if (a4TApA.BChYOn() == 9) {
                a4TApA.B3GDIM();
                return null;
            }
            try {
                return new Date(this.f12153A2egSU.parse(a4TApA.B7CMnp()).getTime());
            } catch (ParseException e) {
                throw new JsonSyntaxException(e);
            }
        }
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(Q2dWmT.A5SV6n a5SV6n, Date date) {
        Date date2 = date;
        synchronized (this) {
            a5SV6n.B25kr6(date2 == null ? null : this.f12153A2egSU.format((java.util.Date) date2));
        }
    }
}
