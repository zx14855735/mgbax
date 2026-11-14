package com.octopus.ad.internal.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.octopus.ad.R;
import com.octopus.ad.a.b;
import com.octopus.ad.internal.k;
import com.octopus.ad.internal.utilities.ImageManager;
import com.octopus.ad.internal.utilities.ViewUtil;
import com.octopus.ad.utils.b.f;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class StopoverDialogActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    private String f12421a;
    private String b;
    private String c;
    private String d;
    private boolean e;
    private com.octopus.ad.a.a f;
    private ImageView g;
    private RelativeLayout h;
    private RelativeLayout i;
    private TextView j;
    private TextView k;
    private TextView l;

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Map map;
        super.onCreate(bundle);
        try {
            Bundle bundleExtra = getIntent().getBundleExtra("bundleData");
            if (bundleExtra == null || (map = (Map) bundleExtra.getSerializable("mapData")) == null) {
                return;
            }
            this.f12421a = (String) map.get("icon");
            this.b = (String) map.get("title");
            this.c = (String) map.get("description");
            this.d = (String) map.get("landingPageUrl");
            a();
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        k.a().a("StopoverFinish");
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        com.octopus.ad.a.a aVar = this.f;
        if (aVar != null) {
            aVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        com.octopus.ad.a.a aVar = this.f;
        if (aVar != null) {
            aVar.c();
            return;
        }
        com.octopus.ad.a.a aVar2 = new com.octopus.ad.a.a(15000L, 50L);
        this.f = aVar2;
        aVar2.a(new b() { // from class: com.octopus.ad.internal.activity.StopoverDialogActivity.3
            @Override // com.octopus.ad.a.b
            public void a(long j) {
                int i = (int) ((j / 1000) + 1);
                if (StopoverDialogActivity.this.j != null) {
                    StopoverDialogActivity.this.j.setText(String.valueOf(i));
                }
            }

            @Override // com.octopus.ad.a.b
            public void b() {
            }

            @Override // com.octopus.ad.a.b
            public void a() {
                k.a().a("getReward");
                StopoverDialogActivity.this.e = true;
                StopoverDialogActivity.this.a(2);
            }
        });
        this.f.a();
    }

    private void a() {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.OctopusAlertDialogStyle);
            View inflate = LayoutInflater.from(this).inflate(R.layout.oct_dialog_stopover, (ViewGroup) null);
            builder.setView(inflate);
            AlertDialog create = builder.create();
            create.setCancelable(false);
            create.setCanceledOnTouchOutside(false);
            this.g = (ImageView) inflate.findViewById(R.id.iv_gift);
            this.h = (RelativeLayout) inflate.findViewById(R.id.rl_tip_start);
            this.i = (RelativeLayout) inflate.findViewById(R.id.rl_tip_countdown);
            this.j = (TextView) inflate.findViewById(R.id.tv_tip_time);
            this.k = (TextView) inflate.findViewById(R.id.tv_tip_end);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_app_icon);
            TextView textView = (TextView) inflate.findViewById(R.id.tv_ad_title);
            TextView textView2 = (TextView) inflate.findViewById(R.id.tv_ad_description);
            this.l = (TextView) inflate.findViewById(R.id.tv_button);
            ImageView imageView2 = (ImageView) inflate.findViewById(R.id.iv_click);
            ImageManager.with(this).load(this.f12421a).into(imageView);
            textView.setText(this.b);
            textView2.setText(this.c);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(300L);
            alphaAnimation.setRepeatCount(-1);
            alphaAnimation.setRepeatMode(2);
            imageView2.startAnimation(alphaAnimation);
            TextView textView3 = (TextView) inflate.findViewById(R.id.tv_continue);
            textView3.setPaintFlags(textView3.getPaintFlags() | 8);
            this.l.setOnClickListener(new View.OnClickListener() { // from class: com.octopus.ad.internal.activity.StopoverDialogActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (StopoverDialogActivity.this.e) {
                        StopoverDialogActivity.this.finish();
                        return;
                    }
                    ViewUtil.openLocalBrowser(StopoverDialogActivity.this.d, 1);
                    StopoverDialogActivity.this.a(1);
                    StopoverDialogActivity.this.b();
                }
            });
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.octopus.ad.internal.activity.StopoverDialogActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    StopoverDialogActivity.this.finish();
                }
            });
            create.show();
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (i == 1) {
            this.g.setVisibility(8);
            this.h.setVisibility(8);
            this.k.setVisibility(8);
            this.i.setVisibility(0);
            this.l.setText("返回页面");
            return;
        }
        if (i != 2) {
            this.i.setVisibility(8);
            this.k.setVisibility(8);
            this.g.setVisibility(0);
            this.h.setVisibility(0);
            this.l.setText("立即前往");
            return;
        }
        this.g.setVisibility(8);
        this.h.setVisibility(8);
        this.i.setVisibility(8);
        this.k.setVisibility(0);
        this.l.setText("返回视频");
    }
}
