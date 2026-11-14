package com.octopus.ad.internal.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.octopus.ad.R;
import com.octopus.ad.internal.k;
import com.octopus.ad.internal.utilities.ImageManager;
import com.octopus.ad.utils.b.f;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class EndingPageActivity extends Activity {
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Map map;
        super.onCreate(bundle);
        setContentView(R.layout.oct_activity_ending_page);
        try {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            getWindow().setAttributes(attributes);
            Bundle bundleExtra = getIntent().getBundleExtra("bundleData");
            if (bundleExtra == null || (map = (Map) bundleExtra.getSerializable("mapData")) == null) {
                return;
            }
            String str = (String) map.get("icon");
            String str2 = (String) map.get("title");
            String str3 = (String) map.get("description");
            ImageView imageView = (ImageView) findViewById(R.id.ad_close);
            ImageView imageView2 = (ImageView) findViewById(R.id.iv_app_icon);
            ImageView imageView3 = (ImageView) findViewById(R.id.iv_click);
            TextView textView = (TextView) findViewById(R.id.ad_feedback);
            TextView textView2 = (TextView) findViewById(R.id.tv_ad_title);
            TextView textView3 = (TextView) findViewById(R.id.tv_ad_description);
            TextView textView4 = (TextView) findViewById(R.id.tv_button);
            ImageManager.with(this).load(str).into(imageView2);
            textView2.setText(str2);
            textView3.setText(str3);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(300L);
            alphaAnimation.setRepeatCount(-1);
            alphaAnimation.setRepeatMode(2);
            imageView3.startAnimation(alphaAnimation);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.octopus.ad.internal.activity.EndingPageActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.a().a("feedBackClick");
                }
            });
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.octopus.ad.internal.activity.EndingPageActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EndingPageActivity.this.finish();
                }
            });
            textView4.setOnClickListener(new View.OnClickListener() { // from class: com.octopus.ad.internal.activity.EndingPageActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.a().a("adClick");
                }
            });
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }
}
