package OLy1FW;

import Oay4Bh.C4FrIb;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.fragment.app.D9tr6l;
import androidx.lifecycle.CikNvS;
import androidx.lifecycle.CqNSpT;
import com.game.boy.MyApp;
import com.google.android.material.tabs.TabLayout;
import io.dcloud.ads.core.v2.reward.DCRewardAdListener;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AzWtSf implements AlLFFp, CqNSpT, DCRewardAdListener, O0Tw8S.A5SV6n, OpB85q.AmA8tU, com.google.gson.internal.AlLFFp {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f6374AcNBzu;

    public /* synthetic */ AzWtSf(int i, byte b) {
        this.f6374AcNBzu = i;
    }

    public static RectF A5SV6n(TabLayout tabLayout, View view) {
        if (view == null) {
            return new RectF();
        }
        if (tabLayout.f11872CikNvS || !(view instanceof com.google.android.material.tabs.ADYaiT)) {
            return new RectF(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
        com.google.android.material.tabs.ADYaiT aDYaiT = (com.google.android.material.tabs.ADYaiT) view;
        int contentWidth = aDYaiT.getContentWidth();
        int contentHeight = aDYaiT.getContentHeight();
        int AYUAbz2 = (int) C4FrIb.AYUAbz(aDYaiT.getContext(), 24);
        if (contentWidth < AYUAbz2) {
            contentWidth = AYUAbz2;
        }
        int right = (aDYaiT.getRight() + aDYaiT.getLeft()) / 2;
        int bottom = (aDYaiT.getBottom() + aDYaiT.getTop()) / 2;
        int i = contentWidth / 2;
        return new RectF(right - i, bottom - (contentHeight / 2), i + right, (right / 2) + bottom);
    }

    @Override // OLy1FW.AlLFFp
    public void A2egSU() {
    }

    @Override // androidx.lifecycle.CqNSpT
    public CikNvS A4TApA(Class cls) {
        return new D9tr6l(true);
    }

    public float ADYaiT(float f) {
        return 1.0f;
    }

    public boolean AMqCpz(CharSequence charSequence) {
        return false;
    }

    public void ARc23Z(TabLayout tabLayout, View view, View view2, float f, Drawable drawable) {
        RectF A5SV6n2 = A5SV6n(tabLayout, view);
        RectF A5SV6n3 = A5SV6n(tabLayout, view2);
        drawable.setBounds(NdEzCJ.A2egSU.A5SV6n(f, (int) A5SV6n2.left, (int) A5SV6n3.left), drawable.getBounds().top, NdEzCJ.A2egSU.A5SV6n(f, (int) A5SV6n2.right, (int) A5SV6n3.right), drawable.getBounds().bottom);
    }

    @Override // com.google.gson.internal.AlLFFp
    public Object AZkASS() {
        switch (this.f6374AcNBzu) {
            case 21:
                return new ConcurrentHashMap();
            case 22:
                return new TreeMap();
            case 23:
                return new LinkedHashMap();
            case 24:
                return new com.google.gson.internal.AcNBzu();
            case 25:
                return new TreeSet();
            case 26:
                return new LinkedHashSet();
            case 27:
                return new ArrayDeque();
            case 28:
                return new ArrayList();
            default:
                return new ConcurrentSkipListMap();
        }
    }

    @Override // androidx.lifecycle.CqNSpT
    public CikNvS AzWtSf(Class cls, D9tr6l.ADYaiT aDYaiT) {
        return A4TApA(cls);
    }

    @Override // io.dcloud.ads.core.v2.reward.DCRewardAdListener, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaa0aaaa.aaaaaaa0
    public void onClick() {
    }

    @Override // io.dcloud.ads.core.v2.reward.DCRewardAdListener, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaa0aaaa.aaaaaaa0
    public void onClose() {
    }

    @Override // io.dcloud.ads.core.v2.reward.DCRewardAdListener, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaa0aaaa.aaaaaaa0
    public void onReward(JSONObject jSONObject) {
        MyApp.A2egSU("奖励已发放");
    }

    @Override // io.dcloud.ads.core.v2.reward.DCRewardAdListener, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaa0aaaa.aaaaaaa0
    public void onShow() {
    }

    @Override // io.dcloud.ads.core.v2.reward.DCRewardAdListener, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaa0aaaa.aaaaaaa0
    public void onShowError(int i, String str) {
    }

    @Override // io.dcloud.ads.core.v2.reward.DCRewardAdListener, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaa0aaaa.aaaaaaa0
    public void onSkip() {
    }

    @Override // io.dcloud.ads.core.v2.reward.DCRewardAdListener, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaa0aaaa.aaaaaaa0
    public void onVideoPlayEnd() {
    }

    public AzWtSf(int i) {
        this.f6374AcNBzu = 9;
    }
}
