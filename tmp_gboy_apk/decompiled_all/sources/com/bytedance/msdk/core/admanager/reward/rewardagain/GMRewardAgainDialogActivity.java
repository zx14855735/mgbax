package com.bytedance.msdk.core.admanager.reward.rewardagain;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.jk;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class GMRewardAgainDialogActivity extends Activity {
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(jk.c(this, "reward_again_dialog"));
        ImageView imageView = (ImageView) findViewById(jk.y(this, "ra_pic"));
        TextView textView = (TextView) findViewById(jk.y(this, "ra_title"));
        TextView textView2 = (TextView) findViewById(jk.y(this, "ra_btn_ok"));
        TextView textView3 = (TextView) findViewById(jk.y(this, "ra_btn_cancel"));
        hf hfVar = w.w().xj;
        if (hfVar != null) {
            textView.setText(hfVar.hf());
            textView2.setText(hfVar.u());
            textView3.setText(hfVar.kd());
            if (!TextUtils.isEmpty(hfVar.w())) {
                new com.bytedance.msdk.xj.kd.hf(imageView).xj((Object[]) new String[]{hfVar.w()});
            }
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.msdk.core.admanager.reward.rewardagain.GMRewardAgainDialogActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GMRewardAgainDialogActivity.this.finish();
                Runnable runnable = w.w().hf;
                if (runnable != null) {
                    runnable.run();
                }
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.msdk.core.admanager.reward.rewardagain.GMRewardAgainDialogActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GMRewardAgainDialogActivity.this.finish();
                Runnable runnable = w.w().w;
                if (runnable != null) {
                    runnable.run();
                }
            }
        });
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
