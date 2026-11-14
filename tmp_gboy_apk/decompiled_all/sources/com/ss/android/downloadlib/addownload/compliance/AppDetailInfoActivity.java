package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class AppDetailInfoActivity extends Activity {
    private List<Pair<String, String>> c;
    private TextView hf;
    private long kd;
    private ListView u;
    private LinearLayout w;
    private ImageView xj;
    private long y;

    public static class hf {
        public TextView hf;
        public View w;
        public TextView xj;

        private hf() {
        }
    }

    public class xj extends BaseAdapter {
        private xj() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return AppDetailInfoActivity.this.c.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return AppDetailInfoActivity.this.c.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            hf hfVar;
            if (view == null) {
                view = View.inflate(AppDetailInfoActivity.this, 2131493356, null);
                hfVar = new hf();
                hfVar.xj = (TextView) view.findViewById(2131298225);
                hfVar.hf = (TextView) view.findViewById(2131298224);
                hfVar.w = view.findViewById(2131296551);
                view.setTag(hfVar);
            } else {
                hfVar = (hf) view.getTag();
            }
            hfVar.xj.setText((CharSequence) ((Pair) AppDetailInfoActivity.this.c.get(i)).first);
            hfVar.hf.setText((CharSequence) ((Pair) AppDetailInfoActivity.this.c.get(i)).second);
            if (i == getCount() - 1) {
                hfVar.w.setVisibility(8);
            }
            return view;
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        c.xj("lp_app_detail_click_close", this.y);
        super.onBackPressed();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131493352);
        if (xj()) {
            hf();
        } else {
            com.ss.android.socialbase.appdownloader.w.xj((Activity) this);
        }
    }

    private void hf() {
        this.xj = (ImageView) findViewById(2131296765);
        this.hf = (TextView) findViewById(2131298199);
        this.u = (ListView) findViewById(2131297760);
        this.w = (LinearLayout) findViewById(2131297528);
        if (this.c.isEmpty()) {
            this.u.setVisibility(8);
            this.hf.setVisibility(0);
        } else {
            this.u.setAdapter((ListAdapter) new xj());
        }
        this.xj.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.xj("lp_app_detail_click_close", AppDetailInfoActivity.this.y);
                AppDetailInfoActivity.this.finish();
            }
        });
        this.w.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.xj("lp_app_detail_click_download", AppDetailInfoActivity.this.y);
                com.ss.android.downloadlib.addownload.compliance.hf.xj().hf(AppDetailInfoActivity.this.y);
                com.ss.android.socialbase.appdownloader.w.xj((Activity) AppDetailInfoActivity.this);
                com.ss.android.socialbase.appdownloader.w.xj(com.ss.android.downloadlib.addownload.compliance.hf.xj().hf());
            }
        });
    }

    public static void xj(Activity activity, long j) {
        Intent intent = new Intent(activity, (Class<?>) AppDetailInfoActivity.class);
        intent.putExtra("app_info_id", j);
        activity.startActivity(intent);
    }

    private boolean xj() {
        this.kd = getIntent().getLongExtra("app_info_id", 0L);
        com.ss.android.downloadlib.addownload.hf.hf xj2 = w.xj().xj(this.kd);
        if (xj2 == null) {
            return false;
        }
        this.y = xj2.hf;
        this.c = xj2.f;
        return true;
    }
}
