package com.kwad.sdk.widget;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.o.m;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class e extends c {
    private String biA;
    private int biB;
    private String biC;
    private int biD;
    private b bix;
    private String biy;

    public static class a {
        private String biA;
        private int biB;
        private String biC;
        private int biD;
        private b bix;
        private String biy;
        private Context mContext;

        public a(Context context) {
            this.mContext = context;
        }

        public final e UG() {
            return new e(this);
        }

        public final a a(b bVar) {
            this.bix = bVar;
            return this;
        }

        public final a ia(String str) {
            this.biy = str;
            return this;
        }

        public final a ib(String str) {
            this.biA = str;
            return this;
        }

        public final a ic(String str) {
            this.biC = str;
            return this;
        }
    }

    public interface b {
        void a(DialogInterface dialogInterface);

        void b(DialogInterface dialogInterface);

        void c(DialogInterface dialogInterface);
    }

    public e(a aVar) {
        super(aVar.mContext);
        a(aVar);
    }

    private View sP() {
        View inflate = LayoutInflater.from(m.wrapContextIfNeed(getContext())).inflate(R.layout.ksad_no_title_common_dialog_content_layout, (ViewGroup) null, false);
        inflate.findViewById(R.id.ksad_no_title_common_dialog_layout).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.widget.e.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (e.this.bix != null) {
                    e.this.bix.c(e.this);
                }
            }
        });
        TextView textView = (TextView) inflate.findViewById(R.id.ksad_no_title_common_positive_btn);
        if (!TextUtils.isEmpty(this.biA)) {
            textView.setText(this.biA);
        }
        textView.setTextColor(this.biB);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.widget.e.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (e.this.bix != null) {
                    e.this.bix.a(e.this);
                }
            }
        });
        TextView textView2 = (TextView) inflate.findViewById(R.id.ksad_no_title_common_negative_btn);
        if (!TextUtils.isEmpty(this.biC)) {
            textView2.setText(this.biC);
        }
        textView2.setTextColor(this.biD);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.widget.e.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (e.this.bix != null) {
                    e.this.bix.b(e.this);
                }
            }
        });
        ((TextView) inflate.findViewById(R.id.ksad_no_title_common_content_text)).setText(this.biy);
        return inflate;
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            requestWindowFeature(1);
            setContentView(sP());
            setCanceledOnTouchOutside(true);
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getWindow().setLayout(-1, -1);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private void a(a aVar) {
        if (aVar.mContext instanceof Activity) {
            setOwnerActivity((Activity) aVar.mContext);
        }
        this.bix = aVar.bix;
        this.biy = aVar.biy;
        this.biA = !TextUtils.isEmpty(aVar.biA) ? aVar.biA : aVar.mContext.getString(R.string.ksad_no_title_common_dialog_positivebtn_title);
        this.biB = aVar.biB != 0 ? aVar.biB : aVar.mContext.getResources().getColor(R.color.ksad_no_title_common_dialog_positivebtn_color);
        this.biC = !TextUtils.isEmpty(aVar.biC) ? aVar.biC : aVar.mContext.getString(R.string.ksad_no_title_common_dialog_negativebtn_title);
        this.biD = aVar.biD != 0 ? aVar.biD : aVar.mContext.getResources().getColor(R.color.ksad_no_title_common_dialog_negativebtn_color);
    }
}
