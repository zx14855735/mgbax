package MS6BTZ;

import L2suez.B2KMhB;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.preference.Preference;
import com.game.boy.MyApp;
import com.game.boy.activity.WebViewActivity;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class A2egSU extends AlLFFp {
    @Override // DRlcZ9.B4ZgIw, DRlcZ9.BJ7GGh
    public final boolean A5SV6n(Preference preference) {
        String str = preference.f9088BI9f7h;
        if ("checkUpdate".equals(str)) {
            MyApp.A2egSU("正在检查更新中...");
            B2KMhB.A2egSU(requireActivity(), true, null);
            return true;
        }
        if ("contactEmail".equals(str)) {
            Intent intent = new Intent("android.intent.action.SENDTO");
            intent.setData(Uri.parse("mailto:support@gboy.top"));
            intent.putExtra("android.intent.extra.SUBJECT", "用户反馈");
            if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                startActivity(intent);
                return true;
            }
            MyApp.A2egSU("未检测到邮件客户端");
            return true;
        }
        if ("userAgreement".equals(str)) {
            B2KMhB("https://gboy.top/agreement.html", "用户协议");
            return true;
        }
        if ("privacyPolicy".equals(str)) {
            B2KMhB("https://gboy.top/privacy.html", "隐私政策");
            return true;
        }
        if ("disclaimer".equals(str)) {
            B2KMhB("https://gboy.top/disclaimer.html", "免责声明");
            return true;
        }
        if (!"feedback".equals(str)) {
            return super.A5SV6n(preference);
        }
        B2KMhB("https://gboy.top/", "GBoy官方网站");
        return true;
    }

    @Override // MS6BTZ.AlLFFp
    public final int B25kr6() {
        return 2132082707;
    }

    public final void B2KMhB(String str, String str2) {
        Intent intent = new Intent(getContext(), (Class<?>) WebViewActivity.class);
        intent.putExtra("extra_url", str);
        intent.putExtra("extra_title", str2);
        startActivity(intent);
    }

    @Override // DRlcZ9.B4ZgIw, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        AZkASS("checkUpdate").BNL6CD("版本: 26.10.18");
    }
}
