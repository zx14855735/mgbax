package LCJm5h;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A4TApA implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f4420AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ AMqCpz f4421AlLFFp;

    public /* synthetic */ A4TApA(AMqCpz aMqCpz, int i) {
        this.f4420AcNBzu = i;
        this.f4421AlLFFp = aMqCpz;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4420AcNBzu) {
            case 0:
                AMqCpz aMqCpz = this.f4421AlLFFp;
                if (aMqCpz != null) {
                    aMqCpz.onError("正在处理其他文件，请稍后再试");
                    break;
                }
                break;
            default:
                AMqCpz aMqCpz2 = this.f4421AlLFFp;
                if (aMqCpz2 != null) {
                    aMqCpz2.onError("正在处理其他文件，请稍后再试");
                    break;
                }
                break;
        }
    }
}
