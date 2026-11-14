package com.game.boy.activity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.czhj.sdk.common.Constants;
import com.game.boy.MyApp;
import com.google.android.material.appbar.MaterialToolbar;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class PackageActivity extends A5SV6n implements LLiCI0.BmvVmW {

    /* renamed from: BI9f7h, reason: collision with root package name */
    public static final /* synthetic */ int f11068BI9f7h = 0;

    /* renamed from: B25kr6, reason: collision with root package name */
    public RecyclerView f11069B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public SwipeRefreshLayout f11070B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public ProgressBar f11071B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public TextView f11072B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public LLiCI0.BpkvW3 f11073B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public I3HV03.A4TApA f11074B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public LlW7FF.ASJ6gh f11075BChYOn;

    public final void AYUAbz() {
        this.f11069B25kr6.setVisibility(8);
        this.f11072B4ZgIw.setVisibility(8);
        this.f11071B3GDIM.setVisibility(0);
        this.f11070B2KMhB.setRefreshing(false);
        LlW7FF.ASJ6gh aSJ6gh = this.f11075BChYOn;
        String B25kr62 = this.f11074B9tovu.B25kr6("user_token");
        COJEAR cojear = new COJEAR(this);
        aSJ6gh.getClass();
        String ASJ6gh2 = LlW7FF.ASJ6gh.ASJ6gh("get_packages", B25kr62);
        if (aSJ6gh.A5SV6n(ASJ6gh2)) {
            aSJ6gh.ARc23Z(aSJ6gh.ADYaiT(LlW7FF.ASJ6gh.A4TApA("action", "get_packages", Constants.TOKEN, B25kr62)), MTKlkd.A5SV6n.class, cojear, ASJ6gh2, true);
        } else {
            aSJ6gh.AZOQYO(cojear, "获取套餐信息请求正在进行中，请稍候", true);
        }
    }

    @Override // com.game.boy.activity.A5SV6n, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.AmA8tU, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131492900);
        this.f11074B9tovu = new I3HV03.A4TApA((Context) this);
        this.f11075BChYOn = MyApp.f10880AzWtSf;
        MaterialToolbar materialToolbar = (MaterialToolbar) findViewById(2131298113);
        materialToolbar.setTitle("套餐选择");
        setSupportActionBar(materialToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().AlLFFp(true);
            getSupportActionBar().AmA8tU();
        }
        this.f11069B25kr6 = (RecyclerView) findViewById(2131297794);
        this.f11070B2KMhB = (SwipeRefreshLayout) findViewById(2131298040);
        this.f11071B3GDIM = (ProgressBar) findViewById(2131297775);
        this.f11072B4ZgIw = (TextView) findViewById(2131296634);
        this.f11070B2KMhB.setOnRefreshListener(new NGepWW.A2egSU(15, this));
        AYUAbz();
    }

    @Override // com.game.boy.activity.A5SV6n, ADYaiT.B2KMhB
    public final boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
