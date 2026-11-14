package com.google.gson.internal.bind;

import B4ZgIw.AYUAbz;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.AcNBzu;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ObjectTypeAdapter extends TypeAdapter<Object> {

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final TypeAdapterFactory f12145A4TApA = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.ObjectTypeAdapter.1
        @Override // com.google.gson.TypeAdapterFactory
        public final TypeAdapter create(Gson gson, TypeToken typeToken) {
            if (typeToken.getRawType() == Object.class) {
                return new ObjectTypeAdapter(gson);
            }
            return null;
        }
    };

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Gson f12146A2egSU;

    static {
        zqQsKbc();
    }

    public ObjectTypeAdapter(Gson gson) {
        this.f12146A2egSU = gson;
    }

    private static /* synthetic */ void zqQsKbc() {
        char[] charArray = "úöô·þøôü·ûöà·êñüõõ·Ó÷ðÛëðýþü".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 153);
        }
        String str = new String(charArray);
        char[] charArray2 = "úõð÷ðí".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 153);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(Q2dWmT.A4TApA a4TApA) {
        int ADYaiT2 = AYUAbz.ADYaiT(a4TApA.BChYOn());
        if (ADYaiT2 == 0) {
            ArrayList arrayList = new ArrayList();
            a4TApA.A2egSU();
            while (a4TApA.AZOQYO()) {
                arrayList.add(read2(a4TApA));
            }
            a4TApA.AMqCpz();
            return arrayList;
        }
        if (ADYaiT2 == 2) {
            AcNBzu acNBzu = new AcNBzu();
            a4TApA.A4TApA();
            while (a4TApA.AZOQYO()) {
                acNBzu.put(a4TApA.B25kr6(), read2(a4TApA));
            }
            a4TApA.ARc23Z();
            return acNBzu;
        }
        if (ADYaiT2 == 5) {
            return a4TApA.B7CMnp();
        }
        if (ADYaiT2 == 6) {
            return Double.valueOf(a4TApA.AlLFFp());
        }
        if (ADYaiT2 == 7) {
            return Boolean.valueOf(a4TApA.AcNBzu());
        }
        if (ADYaiT2 != 8) {
            throw new IllegalStateException();
        }
        a4TApA.B3GDIM();
        return null;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(Q2dWmT.A5SV6n a5SV6n, Object obj) {
        if (obj == null) {
            a5SV6n.AZOQYO();
            return;
        }
        TypeAdapter adapter = this.f12146A2egSU.getAdapter(obj.getClass());
        if (!(adapter instanceof ObjectTypeAdapter)) {
            adapter.write(a5SV6n, obj);
        } else {
            a5SV6n.A5SV6n();
            a5SV6n.ARc23Z();
        }
    }
}
