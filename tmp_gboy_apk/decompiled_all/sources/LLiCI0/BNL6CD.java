package LLiCI0;

import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class BNL6CD implements View.OnLongClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ LHpdLt.BV3sI0 f4742AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ BPw6Q8 f4743AlLFFp;

    public BNL6CD(BPw6Q8 bPw6Q8, LHpdLt.BV3sI0 bV3sI0) {
        this.f4743AlLFFp = bPw6Q8;
        this.f4742AcNBzu = bV3sI0;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        int indexOf;
        BTvldC bTvldC = this.f4743AlLFFp.f4747AzWtSf;
        AZkASS.ARc23Z aRc23Z = bTvldC.f4750AmA8tU;
        if (aRc23Z != null) {
            bTvldC.getClass();
            LHpdLt.BV3sI0 bV3sI0 = this.f4742AcNBzu;
            String A2egSU2 = L2suez.B7CMnp.A2egSU(bV3sI0.f4601A4TApA);
            if (A2egSU2 == null) {
                A2egSU2 = "";
            }
            if (A2egSU2.startsWith("【QUOTE||") && (indexOf = A2egSU2.indexOf("】")) >= 0) {
                A2egSU2 = A2egSU2.substring(indexOf + 1).trim();
            }
            if (A2egSU2.isEmpty()) {
                A2egSU2 = "[消息]";
            }
            if (A2egSU2.length() > 20) {
                A2egSU2 = A2egSU2.substring(0, 20) + "…";
            }
            ((LHpdLt.AZOQYO) aRc23Z.f451AlLFFp).f4485B25kr6.setQuoteMessage(com.bykv.vk.component.ttvideo.player.A2egSU.AzWtSf(new StringBuilder("【QUOTE||"), bV3sI0.f4600A2egSU, "||", A2egSU2, "】"));
        }
        return true;
    }
}
