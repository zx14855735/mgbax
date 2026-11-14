package com.google.gson.internal.bind;

import ADYaiT.CtFAbx;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ADYaiT extends Q2dWmT.A5SV6n {

    /* renamed from: BNL6CD, reason: collision with root package name */
    public static final A5SV6n f12086BNL6CD = new A5SV6n();

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public static final JsonPrimitive f12087BPw6Q8 = new JsonPrimitive("closed");

    /* renamed from: BI9f7h, reason: collision with root package name */
    public final ArrayList f12088BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public String f12089BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public JsonElement f12090BJ7GGh;

    static {
        dPKyDX();
    }

    public ADYaiT() {
        super(f12086BNL6CD);
        this.f12088BI9f7h = new ArrayList();
        this.f12090BJ7GGh = JsonNull.INSTANCE;
    }

    private static /* synthetic */ void dPKyDX() {
        char[] charArray = "R^\\\u001fVP\\T\u001fS^H\u001fBYT]]\u001f{_XsCXUVT".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '1');
        }
        String str = new String(charArray);
        char[] charArray2 = "R]X_XE".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '1');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // Q2dWmT.A5SV6n
    public final void A4TApA() {
        JsonArray jsonArray = new JsonArray();
        B9tovu(jsonArray);
        this.f12088BI9f7h.add(jsonArray);
    }

    @Override // Q2dWmT.A5SV6n
    public final void A5SV6n() {
        JsonObject jsonObject = new JsonObject();
        B9tovu(jsonObject);
        this.f12088BI9f7h.add(jsonObject);
    }

    @Override // Q2dWmT.A5SV6n
    public final void AMqCpz() {
        ArrayList arrayList = this.f12088BI9f7h;
        if (arrayList.isEmpty() || this.f12089BIYEnU != null) {
            throw new IllegalStateException();
        }
        if (!(B7CMnp() instanceof JsonArray)) {
            throw new IllegalStateException();
        }
        arrayList.remove(arrayList.size() - 1);
    }

    @Override // Q2dWmT.A5SV6n
    public final void ARc23Z() {
        ArrayList arrayList = this.f12088BI9f7h;
        if (arrayList.isEmpty() || this.f12089BIYEnU != null) {
            throw new IllegalStateException();
        }
        if (!(B7CMnp() instanceof JsonObject)) {
            throw new IllegalStateException();
        }
        arrayList.remove(arrayList.size() - 1);
    }

    @Override // Q2dWmT.A5SV6n
    public final void ASJ6gh(String str) {
        if (this.f12088BI9f7h.isEmpty() || this.f12089BIYEnU != null) {
            throw new IllegalStateException();
        }
        if (!(B7CMnp() instanceof JsonObject)) {
            throw new IllegalStateException();
        }
        this.f12089BIYEnU = str;
    }

    @Override // Q2dWmT.A5SV6n
    public final Q2dWmT.A5SV6n AZOQYO() {
        B9tovu(JsonNull.INSTANCE);
        return this;
    }

    @Override // Q2dWmT.A5SV6n
    public final void AlLFFp(long j) {
        B9tovu(new JsonPrimitive((Number) Long.valueOf(j)));
    }

    @Override // Q2dWmT.A5SV6n
    public final void AmA8tU(Boolean bool) {
        if (bool == null) {
            B9tovu(JsonNull.INSTANCE);
        } else {
            B9tovu(new JsonPrimitive(bool));
        }
    }

    @Override // Q2dWmT.A5SV6n
    public final void AzWtSf(Number number) {
        if (number == null) {
            B9tovu(JsonNull.INSTANCE);
            return;
        }
        if (!this.f7450B2KMhB) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        B9tovu(new JsonPrimitive(number));
    }

    @Override // Q2dWmT.A5SV6n
    public final void B25kr6(String str) {
        if (str == null) {
            B9tovu(JsonNull.INSTANCE);
        } else {
            B9tovu(new JsonPrimitive(str));
        }
    }

    @Override // Q2dWmT.A5SV6n
    public final void B2KMhB(boolean z) {
        B9tovu(new JsonPrimitive(Boolean.valueOf(z)));
    }

    public final JsonElement B4ZgIw() {
        ArrayList arrayList = this.f12088BI9f7h;
        if (arrayList.isEmpty()) {
            return this.f12090BJ7GGh;
        }
        throw new IllegalStateException("Expected one JSON element but was " + arrayList);
    }

    public final JsonElement B7CMnp() {
        return (JsonElement) CtFAbx.ADYaiT(this.f12088BI9f7h, 1);
    }

    public final void B9tovu(JsonElement jsonElement) {
        if (this.f12089BIYEnU != null) {
            if (!jsonElement.isJsonNull() || this.f7453B7CMnp) {
                ((JsonObject) B7CMnp()).add(this.f12089BIYEnU, jsonElement);
            }
            this.f12089BIYEnU = null;
            return;
        }
        if (this.f12088BI9f7h.isEmpty()) {
            this.f12090BJ7GGh = jsonElement;
            return;
        }
        JsonElement B7CMnp2 = B7CMnp();
        if (!(B7CMnp2 instanceof JsonArray)) {
            throw new IllegalStateException();
        }
        ((JsonArray) B7CMnp2).add(jsonElement);
    }

    @Override // Q2dWmT.A5SV6n, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ArrayList arrayList = this.f12088BI9f7h;
        if (!arrayList.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        arrayList.add(f12087BPw6Q8);
    }

    @Override // Q2dWmT.A5SV6n, java.io.Flushable
    public final void flush() {
    }
}
