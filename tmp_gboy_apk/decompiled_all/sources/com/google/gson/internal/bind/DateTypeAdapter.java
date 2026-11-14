package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class DateTypeAdapter extends TypeAdapter<Date> {

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final TypeAdapterFactory f12135A5SV6n = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.DateTypeAdapter.1
        @Override // com.google.gson.TypeAdapterFactory
        public final TypeAdapter create(Gson gson, TypeToken typeToken) {
            if (typeToken.getRawType() == Date.class) {
                return new DateTypeAdapter();
            }
            return null;
        }
    };

    /* renamed from: A2egSU, reason: collision with root package name */
    public final DateFormat f12136A2egSU = DateFormat.getDateTimeInstance(2, 2, Locale.US);

    /* renamed from: A4TApA, reason: collision with root package name */
    public final DateFormat f12137A4TApA = DateFormat.getDateTimeInstance(2, 2);

    static {
        GFgRco();
    }

    private static /* synthetic */ void GFgRco() {
        char[] charArray = "xtv5|zv~5ytb5hs~ww5QurYir\u007f|~".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 27);
        }
        String str = new String(charArray);
        char[] charArray2 = "xwruro".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 27);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Date read2(Q2dWmT.A4TApA a4TApA) {
        Date parse;
        if (a4TApA.BChYOn() == 9) {
            a4TApA.B3GDIM();
            return null;
        }
        String B7CMnp2 = a4TApA.B7CMnp();
        synchronized (this) {
            try {
                try {
                    try {
                        parse = this.f12137A4TApA.parse(B7CMnp2);
                    } catch (ParseException e) {
                        throw new JsonSyntaxException(B7CMnp2, e);
                    }
                } catch (ParseException unused) {
                    return PnmUpl.A2egSU.A4TApA(B7CMnp2, new ParsePosition(0));
                }
            } catch (ParseException unused2) {
                return this.f12136A2egSU.parse(B7CMnp2);
            }
        }
        return parse;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(Q2dWmT.A5SV6n a5SV6n, Date date) {
        Date date2 = date;
        synchronized (this) {
            if (date2 == null) {
                a5SV6n.AZOQYO();
            } else {
                a5SV6n.B25kr6(this.f12136A2egSU.format(date2));
            }
        }
    }
}
