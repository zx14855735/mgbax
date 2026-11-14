package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaea;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.mobads.sdk.api.PrerollVideoResponse;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.sigmob.sdk.base.blurkit.d;
import io.dcloud.base.R;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aaaaaaaa extends AlertDialog implements View.OnClickListener {
    public aaaaaaa0 aaaaaaa0;
    private Context aaaaaaaa;
    private ViewGroup aaaaaaac;
    private String aaaaaaae;
    private List aaaaaaan;
    private View aaaaaaao;
    private View aaaaaaau;
    private String aaaaaaav;
    private float aaaaaaea;
    private int aaaaaaeo;
    private boolean aaaaaeaa;
    private boolean aaaaeaaa;
    private boolean aaaeaaaa;
    private boolean aeaaaaaa;
    private boolean aoaaaaaa;
    private int eaaaaaaa;

    public interface aaaaaaa0 {
        void aaaaaaa0(int i);

        void aaaaaaaa(int i, TextView textView, String str);

        void aaaaaaaa(TextView textView);

        boolean aaaaaaaa(int i);
    }

    /* renamed from: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaea.aaaaaaaa$aaaaaaaa, reason: collision with other inner class name */
    public class DialogInterfaceOnCancelListenerC0524aaaaaaaa implements DialogInterface.OnCancelListener {
        public DialogInterfaceOnCancelListenerC0524aaaaaaaa() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            aaaaaaaa.this.aaaaaaaa(-1);
            aaaaaaa0 aaaaaaa0Var = aaaaaaaa.this.aaaaaaa0;
            if (aaaaaaa0Var != null) {
                aaaaaaa0Var.aaaaaaa0(-1);
            }
            aaaaaaaa.this.aaaaaeaa = false;
        }
    }

    public class aaaaaaao {
        public String aaaaaaa0;
        public String aaaaaaaa;
        public String aaaaaaao;

        public aaaaaaao(String str, String str2, String str3) {
            if (str2 == null) {
                this.aaaaaaa0 = PrerollVideoResponse.NORMAL;
            } else {
                this.aaaaaaa0 = str2;
            }
            this.aaaaaaaa = str;
            this.aaaaaaao = str3;
        }
    }

    public aaaaaaaa(Context context) {
        super(context);
        this.aaaaaaae = "";
        this.aaaaaaav = "";
        this.aaaaaaeo = d.f13043a;
        this.aaaaeaaa = true;
        this.aaaaaeaa = true;
        this.aaaaaaea = 16.0f;
        this.eaaaaaaa = 0;
        this.aeaaaaaa = true;
        this.aoaaaaaa = false;
        aaaaaaaa(context);
    }

    private Animation aaaaaaa0() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        return alphaAnimation;
    }

    private Animation aaaaaaac() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(300L);
        return translateAnimation;
    }

    private Drawable aaaaaaae() {
        return this.aaaaaaaa.getResources().getDrawable(R.drawable.dcloud_ad_slt_as_ios7_other_bt_middle);
    }

    private View aaaaaaan() {
        FrameLayout frameLayout = new FrameLayout(this.aaaaaaaa);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 80;
        frameLayout.setLayoutParams(layoutParams);
        View view = new View(this.aaaaaaaa);
        this.aaaaaaau = view;
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        if (this.aoaaaaaa) {
            this.aaaaaaau.setBackgroundColor(Color.argb(MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_DECLARE_LENGTH, 0, 0, 0));
        }
        this.aaaaaaau.setId(10);
        this.aaaaaaau.setOnClickListener(this);
        this.aaaaaaac = new RelativeLayout(this.aaaaaaaa);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 80;
        this.aaaaaaac.setLayoutParams(layoutParams2);
        frameLayout.addView(this.aaaaaaau);
        frameLayout.addView(this.aaaaaaac);
        return frameLayout;
    }

    private void aaaaaaao() {
        int intrinsicHeight = aaaaaaae().getIntrinsicHeight();
        boolean isEmpty = TextUtils.isEmpty(this.aaaaaaae);
        boolean z = !isEmpty;
        boolean z2 = !TextUtils.isEmpty(this.aaaaaaav);
        String str = this.aaaaaaav;
        if (str != null && TextUtils.isEmpty(str)) {
            this.aaaaaaav = getContext().getResources().getString(android.R.string.cancel);
            z2 = true;
        }
        if (z2) {
            TextView textView = new TextView(this.aaaaaaaa);
            textView.setGravity(17);
            textView.getPaint().setFakeBoldText(true);
            textView.setTextSize(2, this.aaaaaaea);
            textView.setId(100);
            textView.setBackground(this.aaaaaaaa.getResources().getDrawable(R.drawable.dcloud_ad_slt_as_ios7_other_bt_middle));
            textView.setText(this.aaaaaaav);
            textView.setTextColor(this.aaaaaaeo);
            textView.setOnClickListener(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, aaaaaaa0(50));
            layoutParams.addRule(12);
            layoutParams.topMargin = aaaaaaa0(this.eaaaaaaa);
            this.aaaaaaac.addView(textView, layoutParams);
            aaaaaaa0 aaaaaaa0Var = this.aaaaaaa0;
            if (aaaaaaa0Var != null) {
                aaaaaaa0Var.aaaaaaaa(textView);
            }
        }
        LinearLayout linearLayout = new LinearLayout(this.aaaaaaaa);
        ScrollView scrollView = new ScrollView(this.aaaaaaaa);
        linearLayout.setOrientation(1);
        scrollView.setId(300);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        if (isEmpty) {
            intrinsicHeight = 0;
        }
        linearLayout.setPadding(0, intrinsicHeight, 0, 0);
        scrollView.addView(linearLayout, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        if (z2) {
            layoutParams3.addRule(2, 100);
        } else {
            layoutParams3.addRule(12);
        }
        this.aaaaaaac.addView(scrollView, layoutParams3);
        if (!isEmpty) {
            TextView textView2 = new TextView(this.aaaaaaaa);
            textView2.setGravity(17);
            textView2.setId(200);
            textView2.setOnClickListener(this);
            textView2.setBackgroundDrawable(aaaaaaae());
            textView2.setText(this.aaaaaaae);
            textView2.setTextColor(Color.parseColor("#8C8C8C"));
            textView2.setTextSize(2, this.aaaaaaea);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams4.topMargin = 0;
            layoutParams4.addRule(6, 300);
            this.aaaaaaac.addView(textView2, layoutParams4);
        }
        List list = this.aaaaaaan;
        if (list != null && list.size() > 0) {
            for (int i = 0; i < this.aaaaaaan.size(); i++) {
                TextView textView3 = new TextView(this.aaaaaaaa);
                textView3.setGravity(17);
                textView3.setId(i + 101);
                textView3.setOnClickListener(this);
                textView3.setBackgroundDrawable(aaaaaaaa(this.aaaaaaan.size(), i, z));
                textView3.setText(((aaaaaaao) this.aaaaaaan.get(i)).aaaaaaaa);
                textView3.setTextColor(Color.parseColor("#000000"));
                textView3.setTextSize(2, this.aaaaaaea);
                if (i > 0) {
                    LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, aaaaaaa0(50));
                    layoutParams5.topMargin = 0;
                    linearLayout.addView(textView3, layoutParams5);
                } else {
                    linearLayout.addView(textView3, new LinearLayout.LayoutParams(-1, aaaaaaa0(50)));
                }
                aaaaaaa0 aaaaaaa0Var2 = this.aaaaaaa0;
                if (aaaaaaa0Var2 != null) {
                    aaaaaaa0Var2.aaaaaaaa(i, textView3, ((aaaaaaao) this.aaaaaaan.get(i)).aaaaaaaa);
                }
            }
        }
        int aaaaaaa02 = aaaaaaa0(this.eaaaaaaa);
        this.aaaaaaac.setBackgroundDrawable(new ColorDrawable(0));
        if (this.aoaaaaaa) {
            this.aaaaaaac.setPadding(aaaaaaa02, aaaaaaa02, aaaaaaa02, aaaaaaa02);
        } else {
            this.aaaaaaac.setPadding(0, aaaaaaa02, 0, aaaaaaa02);
        }
    }

    private Animation aaaaaaau() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        translateAnimation.setDuration(300L);
        translateAnimation.setFillAfter(true);
        return translateAnimation;
    }

    public void aaaaaaav() {
        View currentFocus;
        InputMethodManager inputMethodManager = (InputMethodManager) this.aaaaaaaa.getSystemService("input_method");
        if (inputMethodManager.isActive() && (currentFocus = ((Activity) this.aaaaaaaa).getCurrentFocus()) != null) {
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
        this.aaaaaaao = aaaaaaan();
        this.aaaaaaau.startAnimation(aaaaaaaa());
        this.aaaaaaac.startAnimation(aaaaaaac());
    }

    public void aaaaaaeo() {
        if (this.aaaaeaaa) {
            aaaaaaao();
            show();
            getWindow().setContentView(this.aaaaaaao);
            this.aaaaeaaa = false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view.getId() != 10 || this.aaaeaaaa) && view.getId() != 200) {
            if (view.getId() == 10) {
                aaaaaaaa(-1);
                aaaaaaa0 aaaaaaa0Var = this.aaaaaaa0;
                if (aaaaaaa0Var != null) {
                    aaaaaaa0Var.aaaaaaa0(-1);
                }
                this.aaaaaeaa = false;
                return;
            }
            int id = view.getId() - 100;
            aaaaaaaa(id);
            aaaaaaa0 aaaaaaa0Var2 = this.aaaaaaa0;
            if (aaaaaaa0Var2 != null) {
                aaaaaaa0Var2.aaaaaaa0(id);
            }
            this.aaaaaeaa = false;
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.gravity = 80;
        attributes.width = -1;
        attributes.height = -2;
        View decorView = getWindow().getDecorView();
        int i = this.eaaaaaaa;
        decorView.setPadding(i, 0, i, 0);
        getWindow().setAttributes(attributes);
    }

    public void aaaaaaaa(Context context) {
        this.aaaaaaaa = context;
        this.eaaaaaaa = 10;
        aaaaaaav();
        getWindow().setGravity(80);
        ColorDrawable colorDrawable = new ColorDrawable(0);
        colorDrawable.setAlpha(0);
        getWindow().setBackgroundDrawable(colorDrawable);
        setOnCancelListener(new DialogInterfaceOnCancelListenerC0524aaaaaaaa());
    }

    private int aaaaaaa0(int i) {
        return (int) TypedValue.applyDimension(1, i, this.aaaaaaaa.getResources().getDisplayMetrics());
    }

    private Animation aaaaaaaa() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(300L);
        return alphaAnimation;
    }

    public aaaaaaaa(Context context, int i) {
        super(context, i);
        this.aaaaaaae = "";
        this.aaaaaaav = "";
        this.aaaaaaeo = d.f13043a;
        this.aaaaeaaa = true;
        this.aaaaaeaa = true;
        this.aaaaaaea = 16.0f;
        this.eaaaaaaa = 0;
        this.aeaaaaaa = true;
        this.aoaaaaaa = true;
        aaaaaaaa(context);
    }

    private Drawable aaaaaaaa(int i, int i2, boolean z) {
        return this.aaaaaaaa.getResources().getDrawable(R.drawable.dcloud_ad_slt_as_ios7_other_bt_middle);
    }

    public void aaaaaaaa(int i) {
        if (this.aaaaeaaa || aaaaaaao(i)) {
            return;
        }
        dismiss();
        this.aaaaeaaa = true;
        List list = this.aaaaaaan;
        if (list != null) {
            list.clear();
        }
    }

    public aaaaaaaa aaaaaaaa(String str) {
        this.aaaaaaav = str;
        return this;
    }

    public aaaaaaaa aaaaaaaa(boolean z) {
        this.aaaeaaaa = z;
        return this;
    }

    public aaaaaaaa aaaaaaaa(JSONArray jSONArray) {
        this.aaaaaaan = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject != null) {
                    this.aaaaaaan.add(new aaaaaaao(jSONObject.optString("title"), jSONObject.optString("style"), jSONObject.optString("color")));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public aaaaaaaa aaaaaaaa(aaaaaaa0 aaaaaaa0Var) {
        this.aaaaaaa0 = aaaaaaa0Var;
        return this;
    }

    private boolean aaaaaaao(int i) {
        aaaaaaa0 aaaaaaa0Var = this.aaaaaaa0;
        if (aaaaaaa0Var == null) {
            return false;
        }
        boolean aaaaaaaa = aaaaaaa0Var.aaaaaaaa(i);
        if (!aaaaaaaa) {
            this.aaaaaaac.startAnimation(aaaaaaau());
            this.aaaaaaau.startAnimation(aaaaaaa0());
        }
        return aaaaaaaa;
    }
}
