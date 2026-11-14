package Dphsd2;

import ADYaiT.CtFAbx;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alliance.ssp.ad.activity.SAAllianceWebViewActivity;
import com.alliance.ssp.ad.bean.SAAllianceAdData;
import com.alliance.ssp.ad.manager.applist.bean.InitConfigBean;
import com.bykv.vk.component.ttvideo.player.C;
import com.czhj.sdk.common.Constants;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B3GDIM extends WebViewClient {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ SAAllianceWebViewActivity f2467A2egSU;

    public B3GDIM(SAAllianceWebViewActivity sAAllianceWebViewActivity) {
        this.f2467A2egSU = sAAllianceWebViewActivity;
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        WebResourceResponse webResourceResponse;
        String str;
        String str2;
        SAAllianceWebViewActivity sAAllianceWebViewActivity = this.f2467A2egSU;
        String str3 = sAAllianceWebViewActivity.f9693B2KMhB;
        if (str3 != null && !str3.isEmpty() && sAAllianceWebViewActivity.f9694B3GDIM == 0) {
            String str4 = sAAllianceWebViewActivity.f9693B2KMhB;
            try {
                OkHttpClient build = new OkHttpClient.Builder().followRedirects(false).protocols(Collections.singletonList(Protocol.HTTP_1_1)).build();
                Request.Builder url = new Request.Builder().url(webResourceRequest.getUrl().toString());
                for (Map.Entry<String, String> entry : webResourceRequest.getRequestHeaders().entrySet()) {
                    url.addHeader(entry.getKey(), entry.getValue());
                }
                if (str4 != null && !str4.isEmpty()) {
                    url.addHeader("X-Requested-With", str4);
                }
                Response execute = build.newCall(url.build()).execute();
                String header = execute.header("Content-Type");
                String str5 = "";
                if (header != null) {
                    String[] split = header.split(";");
                    String trim = split[0].trim();
                    if (split.length > 1 && split[1].contains("charset=")) {
                        str5 = split[1].split("=")[1].trim();
                    }
                    str = trim;
                    str2 = str5;
                } else {
                    str = "";
                    str2 = str;
                }
                HashMap hashMap = new HashMap();
                for (String str6 : execute.headers().names()) {
                    hashMap.put(str6, execute.header(str6));
                }
                webResourceResponse = new WebResourceResponse(str, str2, execute.code(), execute.message(), hashMap, execute.body().byteStream());
            } catch (Exception unused) {
                webResourceResponse = null;
            }
            if (webResourceResponse != null) {
                return webResourceResponse;
            }
        }
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String str2;
        Uri parse = Uri.parse(str);
        if (Constants.HTTP.equals(parse.getScheme()) || "https".equals(parse.getScheme())) {
            if (Constants.HTTP.equals(parse.getScheme()) && "https".equals(parse.getScheme())) {
                webView.loadUrl(str);
            }
            return false;
        }
        InitConfigBean initConfigBean = GGG1xW.A2egSU.f2987AZOQYO.f2991ADYaiT;
        List<String> dpLimit = initConfigBean == null ? null : initConfigBean.getDpLimit();
        SAAllianceWebViewActivity sAAllianceWebViewActivity = this.f2467A2egSU;
        if (dpLimit == null || str == null || dpLimit.isEmpty() || str.isEmpty()) {
            str2 = str;
            int i = GJee0v.AZOQYO.f3039AcNBzu;
        } else {
            for (String str3 : dpLimit) {
                if (str3 != null && !str3.isEmpty() && str.contains(str3)) {
                    EY4UKY.ADYaiT aDYaiT = new EY4UKY.ADYaiT();
                    SAAllianceAdData sAAllianceAdData = sAAllianceWebViewActivity.f9692B25kr6;
                    aDYaiT.ASJ6gh(2, 3, sAAllianceAdData, sAAllianceAdData.getCrequestid(), "", str, 0);
                    return true;
                }
            }
            str2 = str;
        }
        try {
            Intent parseUri = Intent.parseUri(str2, 1);
            parseUri.setFlags(C.ENCODING_PCM_MU_LAW);
            parseUri.addCategory("android.intent.category.BROWSABLE");
            parseUri.setComponent(null);
            parseUri.setSelector(null);
            if (parseUri.resolveActivity(sAAllianceWebViewActivity.getPackageManager()) != null) {
                sAAllianceWebViewActivity.startActivity(parseUri);
                int i2 = SAAllianceWebViewActivity.f9687BI9f7h;
                return true;
            }
        } catch (URISyntaxException e) {
            EY4UKY.ADYaiT aDYaiT2 = new EY4UKY.ADYaiT();
            StringBuilder AMqCpz = JrXYwF.A4TApA.AMqCpz("SAAllianceWebViewActivity 001: ");
            AMqCpz.append(e.getMessage());
            aDYaiT2.AmA8tU("004", AMqCpz.toString(), e);
        } catch (Exception e2) {
            e2.getMessage();
            int i3 = GJee0v.AZOQYO.f3039AcNBzu;
            CtFAbx.B4ZgIw(e2, JrXYwF.A4TApA.AMqCpz("SAAllianceWebViewActivity 005: "), new EY4UKY.ADYaiT(), "004", e2);
        }
        return true;
    }
}
