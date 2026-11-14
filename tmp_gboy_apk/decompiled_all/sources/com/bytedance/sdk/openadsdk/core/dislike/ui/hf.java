package com.bytedance.sdk.openadsdk.core.dislike.ui;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.widget.TTDislikeCommentLayout;
import com.sigmob.sdk.base.blurkit.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf extends Dialog {
    private final List<com.bytedance.sdk.openadsdk.core.dislike.hf.xj> hf;
    private EditText kd;
    private com.bytedance.sdk.openadsdk.core.dislike.hf.hf u;
    private com.bytedance.sdk.openadsdk.core.dislike.w.hf w;
    private TTDislikeCommentLayout xj;

    public hf(Context context, com.bytedance.sdk.openadsdk.core.dislike.w.hf hfVar) {
        super(context);
        this.hf = new ArrayList();
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.w = hfVar;
    }

    private void kd() {
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        Window window = getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        window.setAttributes(attributes);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        w();
        super.dismiss();
        com.bytedance.sdk.openadsdk.core.dislike.hf.hf hfVar = this.u;
        if (hfVar != null) {
            hfVar.xj();
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.bytedance.sdk.openadsdk.res.u.w(getContext()));
        TTDislikeCommentLayout tTDislikeCommentLayout = (TTDislikeCommentLayout) findViewById(2047279092);
        this.xj = tTDislikeCommentLayout;
        xj(tTDislikeCommentLayout);
        kd();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        hf();
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 80;
        window.setAttributes(attributes);
    }

    private void xj(View view) {
        EditText editText = (EditText) view.findViewById(2047279087);
        this.kd = editText;
        xj(editText);
        final TextView textView = (TextView) view.findViewById(2047279088);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.hf.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                String obj = hf.this.kd.getText().toString();
                if (obj.length() <= 0 || obj.isEmpty()) {
                    return;
                }
                Iterator it = hf.this.hf.iterator();
                while (it.hasNext()) {
                    if (((com.bytedance.sdk.openadsdk.core.dislike.hf.xj) it.next()).xj(obj, hf.this)) {
                        return;
                    }
                }
                com.bytedance.sdk.openadsdk.core.dislike.w.w wVar = new com.bytedance.sdk.openadsdk.core.dislike.w.w("0:00", obj);
                com.bytedance.sdk.openadsdk.core.dislike.xj.xj.xj().xj(hf.this.w, wVar);
                hf.this.u.xj(0, wVar);
                hf.this.dismiss();
            }
        });
        ((ImageView) view.findViewById(2047279090)).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.hf.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                hf.this.dismiss();
            }
        });
        final TextView textView2 = (TextView) findViewById(2047279086);
        this.kd.addTextChangedListener(new TextWatcher() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.hf.3
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                int round = Math.round(charSequence.length());
                textView2.setText(String.valueOf(round));
                if (round > 0) {
                    textView.setTextColor(d.f13043a);
                    textView.setClickable(true);
                } else {
                    textView.setTextColor(-7829368);
                    textView.setClickable(false);
                }
            }
        });
    }

    public void hf() {
        EditText editText;
        TTDislikeCommentLayout tTDislikeCommentLayout = this.xj;
        if (tTDislikeCommentLayout == null || (editText = (EditText) tTDislikeCommentLayout.findViewById(2047279087)) == null) {
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) editText.getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.xj.getWindowToken(), 0);
        }
        editText.clearFocus();
    }

    public String u() {
        EditText editText = this.kd;
        return editText != null ? editText.getText().toString() : "";
    }

    public void w() {
        EditText editText;
        InputMethodManager inputMethodManager;
        TTDislikeCommentLayout tTDislikeCommentLayout = this.xj;
        if (tTDislikeCommentLayout == null || (editText = (EditText) tTDislikeCommentLayout.findViewById(2047279087)) == null || (inputMethodManager = (InputMethodManager) editText.getContext().getSystemService("input_method")) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(this.xj.getWindowToken(), 0);
    }

    public static void xj(EditText editText) {
        editText.setFilters(new InputFilter[]{new InputFilter() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.hf.4
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                while (i < i2) {
                    int type = Character.getType(charSequence.charAt(i));
                    if (type == 19 || type == 28) {
                        return "";
                    }
                    i++;
                }
                return null;
            }
        }, new InputFilter.LengthFilter(500)});
    }

    public void xj(com.bytedance.sdk.openadsdk.core.dislike.hf.xj xjVar) {
        this.hf.add(xjVar);
    }

    public void xj(com.bytedance.sdk.openadsdk.core.dislike.w.hf hfVar) {
        if (hfVar == null) {
            return;
        }
        this.w = hfVar;
    }

    public void xj() {
        EditText editText;
        TTDislikeCommentLayout tTDislikeCommentLayout = this.xj;
        if (tTDislikeCommentLayout == null || (editText = (EditText) tTDislikeCommentLayout.findViewById(2047279087)) == null) {
            return;
        }
        editText.setText((CharSequence) null);
    }

    public void xj(com.bytedance.sdk.openadsdk.core.dislike.hf.hf hfVar) {
        this.u = hfVar;
    }
}
