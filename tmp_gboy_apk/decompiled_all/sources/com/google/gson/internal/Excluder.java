package com.google.gson.internal;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.gson.ExclusionStrategy;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class Excluder implements TypeAdapterFactory, Cloneable {

    /* renamed from: B3GDIM, reason: collision with root package name */
    public static final Excluder f12069B3GDIM = new Excluder();

    /* renamed from: AcNBzu, reason: collision with root package name */
    public double f12070AcNBzu = -1.0d;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f12071AlLFFp = MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_DECLARE_LENGTH;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public boolean f12072AmA8tU = true;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public boolean f12073AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public List f12074B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public List f12075B2KMhB;

    static {
        pBEpS();
    }

    public Excluder() {
        List list = Collections.EMPTY_LIST;
        this.f12074B25kr6 = list;
        this.f12075B2KMhB = list;
    }

    private static /* synthetic */ void pBEpS() {
        char[] charArray = "\u0095\u0099\u009bØ\u0091\u0097\u009b\u0093Ø\u0094\u0099\u008fØ\u0085\u009e\u0093\u009a\u009aØ¼\u0098\u009f´\u0084\u009f\u0092\u0091\u0093".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 246);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0095\u009a\u009f\u0098\u009f\u0082".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 246);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    /* renamed from: A2egSU, reason: merged with bridge method [inline-methods] */
    public final Excluder clone() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final boolean A4TApA(Class cls, boolean z) {
        if (this.f12070AcNBzu != -1.0d) {
            PlKZ28.ADYaiT aDYaiT = (PlKZ28.ADYaiT) cls.getAnnotation(PlKZ28.ADYaiT.class);
            PlKZ28.AMqCpz aMqCpz = (PlKZ28.AMqCpz) cls.getAnnotation(PlKZ28.AMqCpz.class);
            if ((aDYaiT != null && aDYaiT.value() > this.f12070AcNBzu) || (aMqCpz != null && aMqCpz.value() <= this.f12070AcNBzu)) {
                return true;
            }
        }
        if (!this.f12072AmA8tU && cls.isMemberClass() && (cls.getModifiers() & 8) == 0) {
            return true;
        }
        if (!Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass())) {
            return true;
        }
        Iterator it = (z ? this.f12074B25kr6 : this.f12075B2KMhB).iterator();
        while (it.hasNext()) {
            if (((ExclusionStrategy) it.next()).shouldSkipClass(cls)) {
                return true;
            }
        }
        return false;
    }

    public final Excluder A5SV6n(ExclusionStrategy exclusionStrategy, boolean z, boolean z2) {
        Excluder clone = clone();
        if (z) {
            ArrayList arrayList = new ArrayList(this.f12074B25kr6);
            clone.f12074B25kr6 = arrayList;
            arrayList.add(exclusionStrategy);
        }
        if (z2) {
            ArrayList arrayList2 = new ArrayList(this.f12075B2KMhB);
            clone.f12075B2KMhB = arrayList2;
            arrayList2.add(exclusionStrategy);
        }
        return clone;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public final TypeAdapter create(final Gson gson, final TypeToken typeToken) {
        Class rawType = typeToken.getRawType();
        final boolean A4TApA2 = A4TApA(rawType, true);
        final boolean A4TApA3 = A4TApA(rawType, false);
        if (A4TApA2 || A4TApA3) {
            return new TypeAdapter<Object>() { // from class: com.google.gson.internal.Excluder.1

                /* renamed from: A2egSU, reason: collision with root package name */
                public TypeAdapter f12076A2egSU;

                @Override // com.google.gson.TypeAdapter
                /* renamed from: read */
                public final Object read2(Q2dWmT.A4TApA a4TApA) {
                    if (A4TApA3) {
                        a4TApA.BPw6Q8();
                        return null;
                    }
                    TypeAdapter typeAdapter = this.f12076A2egSU;
                    if (typeAdapter == null) {
                        typeAdapter = gson.getDelegateAdapter(Excluder.this, typeToken);
                        this.f12076A2egSU = typeAdapter;
                    }
                    return typeAdapter.read2(a4TApA);
                }

                @Override // com.google.gson.TypeAdapter
                public final void write(Q2dWmT.A5SV6n a5SV6n, Object obj) {
                    if (A4TApA2) {
                        a5SV6n.AZOQYO();
                        return;
                    }
                    TypeAdapter typeAdapter = this.f12076A2egSU;
                    if (typeAdapter == null) {
                        typeAdapter = gson.getDelegateAdapter(Excluder.this, typeToken);
                        this.f12076A2egSU = typeAdapter;
                    }
                    typeAdapter.write(a5SV6n, obj);
                }
            };
        }
        return null;
    }
}
