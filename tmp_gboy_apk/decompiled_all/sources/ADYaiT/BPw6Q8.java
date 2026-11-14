package ADYaiT;

import AaHO0E.HPJABZ;
import AaHO0E.HSHyT0;
import COJEAR.EdQ5bb;
import COJEAR.EmJGcg;
import COJEAR.FG7pZc;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.widget.ActionBarContextView;
import com.fl.saas.videocache.ProxyCacheUtils;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BPw6Q8 implements COJEAR.BNL6CD, AZkASS.BJ7GGh {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ CkXcdM f108AcNBzu;

    public /* synthetic */ BPw6Q8(CkXcdM ckXcdM) {
        this.f108AcNBzu = ckXcdM;
    }

    @Override // AZkASS.BJ7GGh
    public void A2egSU(AZkASS.AmA8tU amA8tU, boolean z) {
        this.f108AcNBzu.B4ZgIw(amA8tU);
    }

    @Override // AZkASS.BJ7GGh
    public boolean AMqCpz(AZkASS.AmA8tU amA8tU) {
        Window.Callback callback = this.f108AcNBzu.f158BI9f7h.getCallback();
        if (callback == null) {
            return true;
        }
        callback.onMenuOpened(108, amA8tU);
        return true;
    }

    @Override // COJEAR.BNL6CD
    public FG7pZc B3GDIM(View view, FG7pZc fG7pZc) {
        boolean z;
        FG7pZc fG7pZc2;
        boolean z2;
        int ADYaiT2 = fG7pZc.ADYaiT();
        CkXcdM ckXcdM = this.f108AcNBzu;
        ckXcdM.getClass();
        int ADYaiT3 = fG7pZc.ADYaiT();
        ActionBarContextView actionBarContextView = ckXcdM.f167C2rE4F;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) ckXcdM.f167C2rE4F.getLayoutParams();
            if (ckXcdM.f167C2rE4F.isShown()) {
                if (ckXcdM.Ddcejp == null) {
                    ckXcdM.Ddcejp = new Rect();
                    ckXcdM.f199De4eam = new Rect();
                }
                Rect rect = ckXcdM.Ddcejp;
                Rect rect2 = ckXcdM.f199De4eam;
                rect.set(fG7pZc.A4TApA(), fG7pZc.ADYaiT(), fG7pZc.A5SV6n(), fG7pZc.A2egSU());
                ViewGroup viewGroup = ckXcdM.f172CQhlFr;
                if (Build.VERSION.SDK_INT >= 29) {
                    boolean z3 = HSHyT0.f933A2egSU;
                    HPJABZ.A2egSU(viewGroup, rect, rect2);
                } else {
                    if (!HSHyT0.f933A2egSU) {
                        HSHyT0.f933A2egSU = true;
                        try {
                            Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", Rect.class, Rect.class);
                            HSHyT0.f934A4TApA = declaredMethod;
                            if (!declaredMethod.isAccessible()) {
                                HSHyT0.f934A4TApA.setAccessible(true);
                            }
                        } catch (NoSuchMethodException unused) {
                        }
                    }
                    Method method = HSHyT0.f934A4TApA;
                    if (method != null) {
                        try {
                            method.invoke(viewGroup, rect, rect2);
                        } catch (Exception unused2) {
                        }
                    }
                }
                int i = rect.top;
                int i2 = rect.left;
                int i3 = rect.right;
                FG7pZc AZOQYO2 = COJEAR.DG07BK.AZOQYO(ckXcdM.f172CQhlFr);
                int A4TApA2 = AZOQYO2 == null ? 0 : AZOQYO2.A4TApA();
                int A5SV6n2 = AZOQYO2 == null ? 0 : AZOQYO2.A5SV6n();
                if (marginLayoutParams.topMargin == i && marginLayoutParams.leftMargin == i2 && marginLayoutParams.rightMargin == i3) {
                    z2 = false;
                } else {
                    marginLayoutParams.topMargin = i;
                    marginLayoutParams.leftMargin = i2;
                    marginLayoutParams.rightMargin = i3;
                    z2 = true;
                }
                Context context = ckXcdM.f157BChYOn;
                if (i <= 0 || ckXcdM.f174CTkVKb != null) {
                    View view2 = ckXcdM.f174CTkVKb;
                    if (view2 != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
                        int i4 = marginLayoutParams2.height;
                        int i5 = marginLayoutParams.topMargin;
                        if (i4 != i5 || marginLayoutParams2.leftMargin != A4TApA2 || marginLayoutParams2.rightMargin != A5SV6n2) {
                            marginLayoutParams2.height = i5;
                            marginLayoutParams2.leftMargin = A4TApA2;
                            marginLayoutParams2.rightMargin = A5SV6n2;
                            ckXcdM.f174CTkVKb.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    View view3 = new View(context);
                    ckXcdM.f174CTkVKb = view3;
                    view3.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = A4TApA2;
                    layoutParams.rightMargin = A5SV6n2;
                    ckXcdM.f172CQhlFr.addView(ckXcdM.f174CTkVKb, -1, layoutParams);
                }
                View view4 = ckXcdM.f174CTkVKb;
                r1 = view4 != null;
                if (r1 && view4.getVisibility() != 0) {
                    View view5 = ckXcdM.f174CTkVKb;
                    view5.setBackgroundColor((view5.getWindowSystemUiVisibility() & ProxyCacheUtils.DEFAULT_BUFFER_SIZE) != 0 ? BPw6Q8.ASJ6gh.A4TApA(context, 2131099654) : BPw6Q8.ASJ6gh.A4TApA(context, 2131099653));
                }
                if (!ckXcdM.f179CmUvjW && r1) {
                    ADYaiT3 = 0;
                }
                z = r1;
                r1 = z2;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z = false;
            } else {
                z = false;
                r1 = false;
            }
            if (r1) {
                ckXcdM.f167C2rE4F.setLayoutParams(marginLayoutParams);
            }
        }
        View view6 = ckXcdM.f174CTkVKb;
        if (view6 != null) {
            view6.setVisibility(z ? 0 : 8);
        }
        if (ADYaiT2 != ADYaiT3) {
            int A4TApA3 = fG7pZc.A4TApA();
            int A5SV6n3 = fG7pZc.A5SV6n();
            int A2egSU2 = fG7pZc.A2egSU();
            EdQ5bb edQ5bb = new EdQ5bb(fG7pZc);
            BV3sI0.A5SV6n A4TApA4 = BV3sI0.A5SV6n.A4TApA(A4TApA3, ADYaiT3, A5SV6n3, A2egSU2);
            EmJGcg emJGcg = edQ5bb.f1721A2egSU;
            emJGcg.ASJ6gh(A4TApA4);
            fG7pZc2 = emJGcg.A4TApA();
        } else {
            fG7pZc2 = fG7pZc;
        }
        return COJEAR.DG07BK.AmA8tU(view, fG7pZc2);
    }
}
