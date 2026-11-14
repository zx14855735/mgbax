package com.bytedance.sdk.component.widget.web;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.sdk.component.g.hf;
import com.bytedance.sdk.component.g.w;
import com.bytedance.sdk.component.utils.f;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class BizWebView extends MultiWebview implements w {
    public BizWebView(Context context) {
        super(context);
    }

    private void hf(Runnable runnable) {
        f.hf().post(runnable);
    }

    @Override // com.bytedance.sdk.component.widget.web.MultiWebview
    public void G_() {
        super.G_();
    }

    @Override // com.bytedance.sdk.component.g.w
    public void addJavascriptInterface(final Object obj, final String str) {
        if (this.hf != null) {
            this.hf.addJavascriptInterface(obj, str);
        } else if (this.xj.get() < 3) {
            hf(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.3
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hf != null) {
                        BizWebView.this.hf.addJavascriptInterface(obj, str);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.g.w
    public boolean canGoBack() {
        if (this.hf != null) {
            if (this.hf.canGoBack()) {
                return true;
            }
            if (getWebViewCount() > 1 && xj() != null) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.g.w
    public void clearCache(boolean z) {
        if (this.hf != null) {
            this.hf.clearCache(z);
        }
    }

    @Override // com.bytedance.sdk.component.g.w
    public void clearHistory() {
        if (this.hf != null) {
            this.hf.clearHistory();
        }
    }

    @Override // com.bytedance.sdk.component.g.w
    public void clearView() {
        if (this.hf != null) {
            this.hf.clearView();
        }
    }

    @Override // android.view.View, com.bytedance.sdk.component.g.w
    public void computeScroll() {
        if (this.hf != null) {
            this.hf.computeScroll();
            return;
        }
        AtomicInteger atomicInteger = this.xj;
        if (atomicInteger == null || atomicInteger.get() >= 3) {
            return;
        }
        post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.28
            @Override // java.lang.Runnable
            public void run() {
                if (BizWebView.this.hf != null) {
                    BizWebView.this.hf.computeScroll();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.widget.web.MultiWebview, com.bytedance.sdk.component.g.w
    public void destroy() {
        super.destroy();
    }

    @Override // com.bytedance.sdk.component.g.w
    public void evaluateJavascript(final String str, final ValueCallback<String> valueCallback) {
        if (this.hf != null) {
            this.hf.evaluateJavascript(str, valueCallback);
        } else if (this.xj.get() < 3) {
            hf(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.7
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hf != null) {
                        BizWebView.this.hf.evaluateJavascript(str, valueCallback);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.g.w
    public int getContentHeight() {
        if (this.hf != null) {
            return this.hf.getContentHeight();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.component.g.w
    public int getProgress() {
        if (this.hf != null) {
            return this.hf.getProgress();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.component.g.w
    public String getUrl() {
        return this.hf != null ? this.hf.getUrl() : "";
    }

    @Override // com.bytedance.sdk.component.g.w
    public String getUserAgentString() {
        return this.hf != null ? this.hf.getUserAgentString() : "";
    }

    @Override // com.bytedance.sdk.component.g.w
    public View getView() {
        return this;
    }

    @Override // com.bytedance.sdk.component.g.w
    public WebView getWebView() {
        if (this.hf != null) {
            return this.hf.getWebView();
        }
        if (kd()) {
            return null;
        }
        long j = 500;
        while (this.xj.get() < 3 && j > 0) {
            try {
                Thread.sleep(10L);
                j -= 10;
            } catch (Exception unused) {
            }
        }
        if (this.hf != null) {
            return this.hf.getWebView();
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.g.w
    public void goBack() {
        if (this.hf != null) {
            this.hf.goBack();
        }
    }

    @Override // com.bytedance.sdk.component.g.w
    public void loadUrl(final String str) {
        if (this.hf != null) {
            this.hf.loadUrl(str);
        } else if (this.xj.get() < 3) {
            hf(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.22
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hf != null) {
                        BizWebView.this.hf.loadUrl(str);
                    }
                }
            });
        }
    }

    public void onPause() {
        if (this.hf != null) {
            this.hf.onPause();
        }
    }

    @Override // com.bytedance.sdk.component.g.w
    public void onResume() {
        if (this.hf != null) {
            this.hf.onResume();
        }
    }

    @Override // com.bytedance.sdk.component.g.w
    public void pauseTimers() {
        if (this.hf != null) {
            this.hf.pauseTimers();
        }
    }

    @Override // com.bytedance.sdk.component.g.w
    public void removeJavascriptInterface(String str) {
        w wVar = this.hf;
        if (wVar != null) {
            wVar.removeJavascriptInterface(str);
        }
    }

    @Override // com.bytedance.sdk.component.g.w
    public void resumeTimers() {
        if (this.hf != null) {
            this.hf.resumeTimers();
        }
    }

    @Override // com.bytedance.sdk.component.g.w
    public void setAllowFileAccess(final boolean z) {
        if (this.hf != null) {
            this.hf.setAllowFileAccess(z);
        } else if (this.xj.get() < 3) {
            hf(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.20
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hf != null) {
                        BizWebView.this.hf.setAllowFileAccess(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.g.w
    public void setAllowFileAccessFromFileURLs(final boolean z) {
        if (this.hf != null) {
            this.hf.setAllowFileAccessFromFileURLs(z);
        } else if (this.xj.get() < 3) {
            hf(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.23
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hf != null) {
                        BizWebView.this.hf.setAllowFileAccessFromFileURLs(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.g.w
    public void setAllowUniversalAccessFromFileURLs(final boolean z) {
        if (this.hf != null) {
            this.hf.setAllowUniversalAccessFromFileURLs(z);
        } else if (this.xj.get() < 3) {
            hf(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.24
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hf != null) {
                        BizWebView.this.hf.setAllowFileAccessFromFileURLs(z);
                    }
                }
            });
        }
    }

    @Override // android.view.View, com.bytedance.sdk.component.g.w
    public void setAlpha(final float f) {
        super.setAlpha(f);
        if (this.hf != null) {
            this.hf.setAlpha(f);
            return;
        }
        AtomicInteger atomicInteger = this.xj;
        if (atomicInteger == null || atomicInteger.get() >= 3) {
            return;
        }
        post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.32
            @Override // java.lang.Runnable
            public void run() {
                if (BizWebView.this.hf != null) {
                    BizWebView.this.hf.setAlpha(f);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.g.w
    public void setAppCacheEnabled(final boolean z) {
        if (this.hf != null) {
            this.hf.setAppCacheEnabled(z);
        } else if (this.xj.get() < 3) {
            hf(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.8
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hf != null) {
                        BizWebView.this.hf.setAppCacheEnabled(z);
                    }
                }
            });
        }
    }

    @Override // android.view.View, com.bytedance.sdk.component.g.w
    public void setBackgroundColor(final int i) {
        super.setBackgroundColor(i);
        if (this.hf != null) {
            this.hf.setBackgroundColor(i);
            return;
        }
        AtomicInteger atomicInteger = this.xj;
        if (atomicInteger == null || atomicInteger.get() >= 3) {
            return;
        }
        post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.27
            @Override // java.lang.Runnable
            public void run() {
                if (BizWebView.this.hf != null) {
                    BizWebView.this.hf.setBackgroundColor(i);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.g.w
    public void setBlockNetworkImage(final boolean z) {
        if (this.hf != null) {
            this.hf.setBlockNetworkImage(z);
        } else if (this.xj.get() < 3) {
            hf(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.21
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hf != null) {
                        BizWebView.this.hf.setBlockNetworkImage(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.g.w
    public void setBuiltInZoomControls(final boolean z) {
        if (this.hf != null) {
            this.hf.setBuiltInZoomControls(z);
        } else if (this.xj.get() < 3) {
            hf(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.13
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hf != null) {
                        BizWebView.this.hf.setBuiltInZoomControls(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.g.w
    public void setCacheMode(final int i) {
        if (this.hf != null) {
            this.hf.setCacheMode(i);
        } else if (this.xj.get() < 3) {
            hf(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hf != null) {
                        BizWebView.this.hf.setCacheMode(i);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.g.w
    public void setDatabaseEnabled(final boolean z) {
        if (this.hf != null) {
            this.hf.setDatabaseEnabled(z);
        } else if (this.xj.get() < 3) {
            hf(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.19
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hf != null) {
                        BizWebView.this.hf.setDatabaseEnabled(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.g.w
    public void setDefaultFontSize(final int i) {
        if (this.hf != null) {
            this.hf.setDefaultFontSize(i);
        } else if (this.xj.get() < 3) {
            hf(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.17
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hf != null) {
                        BizWebView.this.hf.setDefaultFontSize(i);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.g.w
    public void setDefaultTextEncodingName(final String str) {
        if (this.hf != null) {
            this.hf.setDefaultTextEncodingName(str);
        } else if (this.xj.get() < 3) {
            hf(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.16
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hf != null) {
                        BizWebView.this.hf.setDefaultTextEncodingName(str);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.g.w
    public void setDisplayZoomControls(final boolean z) {
        if (this.hf != null) {
            this.hf.setDisplayZoomControls(z);
        } else if (this.xj.get() < 3) {
            hf(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.5
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hf != null) {
                        BizWebView.this.hf.setDisplayZoomControls(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.g.w
    public void setDomStorageEnabled(final boolean z) {
        if (this.hf != null) {
            this.hf.setDomStorageEnabled(z);
        } else if (this.xj.get() < 3) {
            hf(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.12
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hf != null) {
                        BizWebView.this.hf.setDomStorageEnabled(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.g.w
    public void setDownloadListener(final DownloadListener downloadListener) {
        if (this.hf != null) {
            this.hf.setDownloadListener(downloadListener);
        } else if (this.xj.get() < 3) {
            hf(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.37
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hf != null) {
                        BizWebView.this.hf.setDownloadListener(downloadListener);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.g.w
    public void setJavaScriptCanOpenWindowsAutomatically(final boolean z) {
        if (this.hf != null) {
            this.hf.setJavaScriptCanOpenWindowsAutomatically(z);
        } else if (this.xj.get() < 3) {
            hf(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.11
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hf != null) {
                        BizWebView.this.hf.setJavaScriptCanOpenWindowsAutomatically(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.g.w
    public void setJavaScriptEnabled(final boolean z) {
        if (this.hf != null) {
            this.hf.setJavaScriptEnabled(z);
        } else if (this.xj.get() < 3) {
            hf(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hf != null) {
                        BizWebView.this.hf.setJavaScriptEnabled(z);
                    }
                }
            });
        }
    }

    @Override // android.view.View, com.bytedance.sdk.component.g.w
    public void setLayerType(final int i, final Paint paint) {
        if (this.hf != null) {
            this.hf.setLayerType(i, paint);
            return;
        }
        AtomicInteger atomicInteger = this.xj;
        if (atomicInteger == null || atomicInteger.get() >= 3) {
            return;
        }
        post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.29
            @Override // java.lang.Runnable
            public void run() {
                if (BizWebView.this.hf != null) {
                    BizWebView.this.hf.setLayerType(i, paint);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.g.w
    public void setLayoutAlgorithm(final WebSettings.LayoutAlgorithm layoutAlgorithm) {
        if (this.hf != null) {
            this.hf.setLayoutAlgorithm(layoutAlgorithm);
        } else if (this.xj.get() < 3) {
            hf(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.14
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hf != null) {
                        BizWebView.this.hf.setLayoutAlgorithm(layoutAlgorithm);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.g.w
    public void setLoadWithOverviewMode(final boolean z) {
        if (this.hf != null) {
            this.hf.setLoadWithOverviewMode(z);
        } else if (this.xj.get() < 3) {
            hf(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.15
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hf != null) {
                        BizWebView.this.hf.setLoadWithOverviewMode(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.g.w
    public void setMediaPlaybackRequiresUserGesture(final boolean z) {
        if (this.hf != null) {
            this.hf.setMediaPlaybackRequiresUserGesture(z);
        } else if (this.xj.get() < 3) {
            hf(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.26
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hf != null) {
                        BizWebView.this.hf.setMediaPlaybackRequiresUserGesture(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.g.w
    public void setMixedContentMode(final int i) {
        if (this.hf != null) {
            this.hf.setMixedContentMode(i);
        } else if (this.xj.get() < 3) {
            hf(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.18
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hf != null) {
                        BizWebView.this.hf.setMixedContentMode(i);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.g.w
    public void setNetworkAvailable(final boolean z) {
        if (this.hf != null) {
            this.hf.setNetworkAvailable(z);
            return;
        }
        AtomicInteger atomicInteger = this.xj;
        if (atomicInteger == null || atomicInteger.get() >= 3) {
            return;
        }
        hf(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.1
            @Override // java.lang.Runnable
            public void run() {
                if (BizWebView.this.hf != null) {
                    BizWebView.this.hf.setNetworkAvailable(z);
                }
            }
        });
    }

    @Override // android.view.View, com.bytedance.sdk.component.g.w
    public void setOnScrollChangeListener(final View.OnScrollChangeListener onScrollChangeListener) {
        if (this.hf != null) {
            this.hf.setOnScrollChangeListener(onScrollChangeListener);
            return;
        }
        AtomicInteger atomicInteger = this.xj;
        if (atomicInteger == null || atomicInteger.get() >= 3) {
            return;
        }
        post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.33
            @Override // java.lang.Runnable
            public void run() {
                if (BizWebView.this.hf != null) {
                    BizWebView.this.hf.setOnScrollChangeListener(onScrollChangeListener);
                }
            }
        });
    }

    @Override // android.view.View, com.bytedance.sdk.component.g.w
    public void setOverScrollMode(final int i) {
        super.setOverScrollMode(i);
        if (this.hf != null) {
            this.hf.setOverScrollMode(i);
            return;
        }
        AtomicInteger atomicInteger = this.xj;
        if (atomicInteger == null || atomicInteger.get() >= 3) {
            return;
        }
        post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.30
            @Override // java.lang.Runnable
            public void run() {
                if (BizWebView.this.hf != null) {
                    BizWebView.this.hf.setOverScrollMode(i);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.g.w
    public void setSavePassword(final boolean z) {
        if (this.hf != null) {
            this.hf.setSavePassword(z);
        } else if (this.xj.get() < 3) {
            hf(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.25
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hf != null) {
                        BizWebView.this.hf.setSavePassword(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.g.w
    public void setSupportZoom(final boolean z) {
        if (this.hf != null) {
            this.hf.setSupportZoom(z);
        } else if (this.xj.get() < 3) {
            hf(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.9
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hf != null) {
                        BizWebView.this.hf.setSupportZoom(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.g.hf
    public void setTouchEventListener(final hf.xj xjVar) {
        if (this.hf != null) {
            this.hf.setTouchEventListener(xjVar);
            return;
        }
        AtomicInteger atomicInteger = this.xj;
        if (atomicInteger == null || atomicInteger.get() >= 3) {
            return;
        }
        post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.34
            @Override // java.lang.Runnable
            public void run() {
                if (BizWebView.this.hf != null) {
                    BizWebView.this.hf.setTouchEventListener(xjVar);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.g.w
    public void setUseWideViewPort(final boolean z) {
        if (this.hf != null) {
            this.hf.setUseWideViewPort(z);
        } else if (this.xj.get() < 3) {
            hf(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.10
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hf != null) {
                        BizWebView.this.hf.setUseWideViewPort(z);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.g.w
    public void setUserAgentString(final String str) {
        if (this.hf != null) {
            this.hf.setUserAgentString(str);
        } else if (this.xj.get() < 3) {
            hf(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.35
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hf != null) {
                        BizWebView.this.hf.setUserAgentString(str);
                    }
                }
            });
        }
    }

    @Override // android.view.View, com.bytedance.sdk.component.g.w
    public void setVisibility(final int i) {
        super.setVisibility(i);
        if (this.hf != null) {
            this.hf.setVisibility(i);
            return;
        }
        AtomicInteger atomicInteger = this.xj;
        if (atomicInteger == null || atomicInteger.get() >= 3) {
            return;
        }
        post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.31
            @Override // java.lang.Runnable
            public void run() {
                if (BizWebView.this.hf != null) {
                    BizWebView.this.hf.setVisibility(i);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.g.w
    public void setWebChromeClient(final WebChromeClient webChromeClient) {
        if (this.hf != null) {
            this.hf.setWebChromeClient(webChromeClient);
        } else if (this.xj.get() < 3) {
            hf(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.2
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hf != null) {
                        BizWebView.this.hf.setWebChromeClient(webChromeClient);
                    }
                }
            });
        }
    }

    public void setWebViewClient(final WebViewClient webViewClient) {
        if (this.hf != null) {
            this.hf.setWebViewClient(webViewClient);
        } else if (this.xj.get() < 3) {
            hf(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.BizWebView.36
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.hf != null) {
                        BizWebView.this.hf.setWebViewClient(webViewClient);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.g.w
    public void xj(String str, String str2, Object obj) {
        if (this.hf != null) {
            this.hf.xj(str, str2, obj);
        }
    }
}
