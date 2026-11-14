package IzHBwY;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AYUAbz {

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final ASJ6gh f4117A5SV6n = new AYUAbz(new SparseArray(0)).A2egSU();

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static final A5SV6n f4118ADYaiT = new A5SV6n(1);

    /* renamed from: A2egSU, reason: collision with root package name */
    public final SparseArray f4119A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final PluginValueSet f4120A4TApA;

    static {
        SFLc();
    }

    public AYUAbz(SparseArray sparseArray, PluginValueSet pluginValueSet) {
        this.f4119A2egSU = sparseArray;
        this.f4120A4TApA = pluginValueSet;
    }

    public static final AYUAbz A4TApA() {
        return new AYUAbz(new SparseArray());
    }

    public static final AYUAbz A5SV6n(PluginValueSet pluginValueSet) {
        return new AYUAbz(new SparseArray(), pluginValueSet);
    }

    private static /* synthetic */ void SFLc() {
        char[] charArray = "¦ª¨ë¢¤¨ ë§ª¼ë¶\u00ad ©©ë\u008f«¬\u0087·¬¡¢ ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 197);
        }
        String str = new String(charArray);
        char[] charArray2 = "¦©¬«¬±".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 197);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final ASJ6gh A2egSU() {
        return new ASJ6gh(this.f4119A2egSU, this.f4120A4TApA);
    }

    public final void ADYaiT(float f, int i) {
        this.f4119A2egSU.put(i, Float.valueOf(f));
    }

    public final void AMqCpz(int i, int i2) {
        this.f4119A2egSU.put(i, Integer.valueOf(i2));
    }

    public final void ARc23Z(int i, Object obj) {
        this.f4119A2egSU.put(i, obj);
    }

    public final void ASJ6gh(int i, String str) {
        this.f4119A2egSU.put(i, str);
    }

    public final void AYUAbz(int i, boolean z) {
        this.f4119A2egSU.put(i, Boolean.valueOf(z));
    }

    public AYUAbz(SparseArray sparseArray) {
        this.f4119A2egSU = sparseArray == null ? new SparseArray() : sparseArray;
    }
}
