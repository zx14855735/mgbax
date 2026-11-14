package com.game.boy.activity;

import android.R;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.czhj.sdk.common.Constants;
import com.game.boy.MyApp;
import com.google.android.material.appbar.MaterialToolbar;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class FavoriteActivity extends A5SV6n {

    /* renamed from: BChYOn, reason: collision with root package name */
    public static final /* synthetic */ int f11033BChYOn = 0;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public SwipeRefreshLayout f11035B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public RecyclerView f11036B3GDIM;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public LlW7FF.ASJ6gh f11038B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public LLiCI0.CcAIMM f11039B9tovu;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final ADYaiT.CTkVKb f11034B25kr6 = new ADYaiT.CTkVKb(9, this);

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final ArrayList f11037B4ZgIw = new ArrayList();

    public final void AYUAbz() {
        this.f11037B4ZgIw.clear();
        LLiCI0.CcAIMM ccAIMM = this.f11039B9tovu;
        ccAIMM.f4788AmA8tU.clear();
        ccAIMM.notifyDataSetChanged();
        LlW7FF.ASJ6gh aSJ6gh = this.f11038B7CMnp;
        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName() + "_preferences", 0);
        sharedPreferences.edit().apply();
        String string = sharedPreferences.getString("user_token", null);
        BV3sI0 bV3sI0 = new BV3sI0(this);
        aSJ6gh.getClass();
        String ASJ6gh2 = LlW7FF.ASJ6gh.ASJ6gh("get_favorites", string);
        if (aSJ6gh.A5SV6n(ASJ6gh2)) {
            aSJ6gh.ARc23Z(aSJ6gh.ADYaiT(LlW7FF.ASJ6gh.A4TApA("action", "get_favorites", Constants.TOKEN, string)), MTKlkd.ASJ6gh.class, bV3sI0, ASJ6gh2, false);
        } else {
            aSJ6gh.AZOQYO(bV3sI0, "查询收藏请求正在进行中，请稍候", false);
        }
    }

    @Override // com.game.boy.activity.A5SV6n, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.AmA8tU, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131492895);
        this.f11038B7CMnp = MyApp.f10880AzWtSf;
        MaterialToolbar materialToolbar = (MaterialToolbar) findViewById(2131298113);
        materialToolbar.setTitle("收藏");
        setSupportActionBar(materialToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().AlLFFp(true);
            getSupportActionBar().AmA8tU();
        }
        this.f11035B2KMhB = (SwipeRefreshLayout) findViewById(2131298041);
        int A4TApA2 = L2suez.B9tovu.A4TApA(this, R.attr.colorPrimary);
        int A4TApA3 = L2suez.B9tovu.A4TApA(this, R.attr.colorSecondary);
        this.f11035B2KMhB.setColorSchemeColors(A4TApA2, A4TApA3, A4TApA3, L2suez.B9tovu.A4TApA(this, R.attr.colorError));
        this.f11035B2KMhB.setOnRefreshListener(new BV3sI0(this));
        RecyclerView recyclerView = (RecyclerView) findViewById(2131297794);
        this.f11036B3GDIM = recyclerView;
        recyclerView.setHasFixedSize(true);
        this.f11036B3GDIM.setItemAnimator(null);
        this.f11036B3GDIM.setLayoutManager(new LinearLayoutManager(1));
        this.f11039B9tovu = new LLiCI0.CcAIMM(this, this.f11037B4ZgIw, new A2egSU(this));
        this.f11036B3GDIM.addOnScrollListener(new BmvVmW(this));
        this.f11036B3GDIM.setAdapter(this.f11039B9tovu);
        this.f11035B2KMhB.setRefreshing(true);
        AYUAbz();
        DG07BK.A5SV6n.A2egSU(this).registerReceiver(this.f11034B25kr6, new IntentFilter("com.game.boy.DOWNLOAD_UPDATE"));
    }

    @Override // com.game.boy.activity.A5SV6n, ADYaiT.B2KMhB, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        DG07BK.A5SV6n.A2egSU(this).unregisterReceiver(this.f11034B25kr6);
    }

    @Override // com.game.boy.activity.A5SV6n, ADYaiT.B2KMhB
    public final boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
