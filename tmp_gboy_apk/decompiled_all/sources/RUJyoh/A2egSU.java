package RUJyoh;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class A2egSU {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final Integer f7879A2egSU;

    static {
        Integer num;
        Object obj;
        Integer num2 = null;
        try {
            obj = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
        } catch (Throwable unused) {
        }
        if (obj instanceof Integer) {
            num = (Integer) obj;
            if (num != null && num.intValue() > 0) {
                num2 = num;
            }
            f7879A2egSU = num2;
        }
        num = null;
        if (num != null) {
            num2 = num;
        }
        f7879A2egSU = num2;
    }
}
