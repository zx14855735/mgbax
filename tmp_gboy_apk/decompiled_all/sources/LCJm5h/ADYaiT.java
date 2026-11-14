package LCJm5h;

import C4FrIb.B4ZgIw;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ADYaiT implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f4425AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ long f4426AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ String f4427AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final /* synthetic */ B4ZgIw f4428AzWtSf;

    public ADYaiT(B4ZgIw b4ZgIw, int i, long j, String str) {
        this.f4428AzWtSf = b4ZgIw;
        this.f4425AcNBzu = i;
        this.f4426AlLFFp = j;
        this.f4427AmA8tU = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ARc23Z.f4431A5SV6n.set(false);
        B4ZgIw b4ZgIw = this.f4428AzWtSf;
        int i = this.f4425AcNBzu;
        String str = i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? "文件" : "ZIP压缩包(GBA游戏)" : "游戏封面图片" : "游戏存档文件" : "游戏补丁文件" : "GBA游戏文件";
        String A2egSU2 = ARc23Z.A2egSU(this.f4426AlLFFp);
        Locale locale = Locale.ROOT;
        ((AMqCpz) b4ZgIw.f1585AzWtSf).A4TApA(i, com.bykv.vk.component.ttvideo.player.A2egSU.AzWtSf(B4ZgIw.AYUAbz.A5SV6n(str, "导入成功: "), this.f4427AmA8tU, " (", A2egSU2, ")"));
    }
}
