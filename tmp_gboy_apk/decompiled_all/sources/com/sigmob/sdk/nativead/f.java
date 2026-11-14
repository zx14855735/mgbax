package com.sigmob.sdk.nativead;

import android.os.Bundle;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.volley.toolbox.DownloadItem;
import com.czhj.volley.toolbox.FileDownloadRequest;
import com.czhj.volley.toolbox.FileDownloader;
import com.sigmob.sdk.base.BaseAdActivity;
import com.sigmob.sdk.base.common.AdActivity;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class f extends com.sigmob.sdk.base.common.y {
    private NativeAdBroadcastReceiver c;

    public f(com.sigmob.sdk.base.common.p pVar) {
        super(pVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a() {
        File adPrivacyTemplateFile = this.b.getAdPrivacyTemplateFile();
        if (adPrivacyTemplateFile == null || adPrivacyTemplateFile.exists()) {
            return;
        }
        DownloadItem downloadItem = new DownloadItem();
        downloadItem.url = this.b.getadPrivacy().privacy_template_url;
        downloadItem.filePath = adPrivacyTemplateFile.getAbsolutePath();
        downloadItem.type = DownloadItem.FileType.OTHER;
        FileDownloader a2 = com.sigmob.sdk.base.common.s.a();
        if (a2 == null) {
            return;
        }
        a2.add(downloadItem, new FileDownloadRequest.FileDownloadListener() { // from class: com.sigmob.sdk.nativead.f.1
            @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
            public void downloadProgress(DownloadItem downloadItem2, long j, long j2) {
            }

            @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
            public void onCancel(DownloadItem downloadItem2) {
            }

            @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
            public void onErrorResponse(DownloadItem downloadItem2) {
            }

            @Override // com.czhj.volley.toolbox.FileDownloadRequest.FileDownloadListener
            public void onSuccess(DownloadItem downloadItem2) {
            }
        });
    }

    @Override // com.sigmob.sdk.base.common.y
    public void b(BaseAdUnit baseAdUnit) {
        NativeAdBroadcastReceiver nativeAdBroadcastReceiver = this.c;
        if (nativeAdBroadcastReceiver != null) {
            nativeAdBroadcastReceiver.b(nativeAdBroadcastReceiver);
            this.c = null;
        }
        super.b(baseAdUnit);
    }

    @Override // com.sigmob.sdk.base.common.y
    public void a(com.sigmob.sdk.base.common.p pVar) {
        ThreadPoolFactory.getFixIOExecutor().submit(new ARc23Z(6, this));
    }

    @Override // com.sigmob.sdk.base.common.y
    public void a(BaseAdUnit baseAdUnit, Bundle bundle) {
        super.a(baseAdUnit, bundle);
        if (this.c == null) {
            com.sigmob.sdk.base.common.p pVar = this.f13165a;
            if (pVar instanceof g) {
                NativeAdBroadcastReceiver nativeAdBroadcastReceiver = new NativeAdBroadcastReceiver((g) pVar, baseAdUnit.getUuid());
                this.c = nativeAdBroadcastReceiver;
                nativeAdBroadcastReceiver.a(nativeAdBroadcastReceiver);
            }
        }
        BaseAdActivity.a(com.sigmob.sdk.b.e(), AdActivity.class, baseAdUnit.getUuid(), bundle, BaseAdActivity.e);
    }

    @Override // com.sigmob.sdk.base.common.y
    public boolean a(BaseAdUnit baseAdUnit) {
        if (baseAdUnit.getMaterial() == null) {
            return false;
        }
        return a(baseAdUnit.getMaterial());
    }

    private static boolean a(MaterialMeta materialMeta) {
        return true;
    }
}
