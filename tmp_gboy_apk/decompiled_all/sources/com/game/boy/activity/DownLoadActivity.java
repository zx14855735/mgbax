package com.game.boy.activity;

import android.R;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.appbar.MaterialToolbar;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class DownLoadActivity extends A5SV6n {

    /* renamed from: BI9f7h, reason: collision with root package name */
    public static final /* synthetic */ int f10972BI9f7h = 0;

    /* renamed from: B25kr6, reason: collision with root package name */
    public RecyclerView f10973B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public SwipeRefreshLayout f10974B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public LLiCI0.B3GDIM f10975B3GDIM;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public L5dZB6.A2egSU f10977B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public ExecutorService f10978B9tovu;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final ArrayList f10976B4ZgIw = new ArrayList();

    /* renamed from: BChYOn, reason: collision with root package name */
    public final ADYaiT.CTkVKb f10979BChYOn = new ADYaiT.CTkVKb(7, this);

    @Override // com.game.boy.activity.A5SV6n, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.AmA8tU, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131492895);
        this.f10978B9tovu = Executors.newSingleThreadExecutor();
        MaterialToolbar materialToolbar = (MaterialToolbar) findViewById(2131298113);
        materialToolbar.setTitle("下载");
        setSupportActionBar(materialToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().AlLFFp(true);
            getSupportActionBar().AmA8tU();
        }
        this.f10974B2KMhB = (SwipeRefreshLayout) findViewById(2131298041);
        int A4TApA2 = L2suez.B9tovu.A4TApA(this, R.attr.colorPrimary);
        int A4TApA3 = L2suez.B9tovu.A4TApA(this, R.attr.colorSecondary);
        this.f10974B2KMhB.setColorSchemeColors(A4TApA2, A4TApA3, A4TApA3, L2suez.B9tovu.A4TApA(this, R.attr.colorError));
        this.f10974B2KMhB.setOnRefreshListener(new NGepWW.A2egSU(13, this));
        RecyclerView recyclerView = (RecyclerView) findViewById(2131297794);
        this.f10973B25kr6 = recyclerView;
        recyclerView.setHasFixedSize(true);
        this.f10973B25kr6.setItemAnimator(null);
        this.f10973B25kr6.setLayoutManager(new LinearLayoutManager(1));
        this.f10977B7CMnp = new L5dZB6.A2egSU(this);
        this.f10975B3GDIM = new LLiCI0.B3GDIM(this.f10976B4ZgIw, new A2egSU(this));
        this.f10973B25kr6.addOnScrollListener(new ARc23Z(this));
        this.f10973B25kr6.setAdapter(this.f10975B3GDIM);
        this.f10978B9tovu.execute(new ASJ6gh(0, this));
        DG07BK.A5SV6n.A2egSU(this).registerReceiver(this.f10979BChYOn, new IntentFilter("com.game.boy.DOWNLOAD_UPDATE"));
    }

    @Override // android.app.Activity
    public final boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(2131623943, menu);
        return true;
    }

    @Override // com.game.boy.activity.A5SV6n, ADYaiT.B2KMhB, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        this.f10978B9tovu.shutdown();
        DG07BK.A5SV6n.A2egSU(this).unregisterReceiver(this.f10979BChYOn);
        this.f10977B7CMnp.close();
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 2131296327) {
            return super.onOptionsItemSelected(menuItem);
        }
        OOnEhG.A4TApA a4TApA = new OOnEhG.A4TApA(this);
        ADYaiT.AZOQYO azoqyo = a4TApA.f81AcNBzu;
        azoqyo.AMqCpz = "提示";
        azoqyo.f28ASJ6gh = "是否清空下载记录？";
        a4TApA.AzWtSf("确定", new DRlcZ9.ASJ6gh(10, this));
        a4TApA.AcNBzu("取消", null);
        a4TApA.AMqCpz();
        return true;
    }

    @Override // com.game.boy.activity.A5SV6n, ADYaiT.B2KMhB
    public final boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
