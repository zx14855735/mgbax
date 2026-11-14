package F1loUV;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU extends Exception {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final int f2563AcNBzu;

    public A2egSU(int i) {
        super(A2egSU(null, i));
        this.f2563AcNBzu = i;
    }

    public static String A2egSU(Exception exc, int i) {
        return exc != null ? exc.toString() : i != 100 ? i != 408 ? i != 500 ? i != 801 ? "网络请求报错" : "网络请求被取消了" : "无网络" : "网络请求超时" : "网络请求失败";
    }

    public A2egSU(int i, int i2) {
        super(A2egSU(null, i));
        this.f2563AcNBzu = i;
    }
}
