package com.bytedance.sdk.openadsdk.core.pl.xj;

import IzHBwY.ASJ6gh;
import J3FDQU.A2egSU;
import P8ccfD.AaHO0E;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.core.ai;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.model.DownloadShortInfo;
import java.util.function.Function;
import java.util.function.LongSupplier;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class w extends com.bytedance.sdk.openadsdk.core.wo.u implements DownloadStatusChangeListener, LongSupplier {
    private int mCurrentPercent;

    private void setCurrentPercent(int i) {
        this.mCurrentPercent = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.u
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (pluginValueSet != null) {
            if (!com.bytedance.sdk.openadsdk.zg.w.u.xj(ai.w)) {
                pluginValueSet = A2egSU.ADYaiT((SparseArray) pluginValueSet.objectValue(-99999979, SparseArray.class));
            }
            switch (i) {
                case 223600:
                    onIdle();
                    break;
                case 223601:
                    ASJ6gh ADYaiT2 = A2egSU.ADYaiT((SparseArray) pluginValueSet.objectValue(-999902, SparseArray.class));
                    onDownloadStart(AaHO0E.AYUAbz(ADYaiT2.objectValue(223201, AaHO0E.ARc23Z())), AaHO0E.AYUAbz(ADYaiT2.objectValue(223203, AaHO0E.ARc23Z())));
                    break;
                case 223602:
                    ASJ6gh ADYaiT3 = A2egSU.ADYaiT((SparseArray) pluginValueSet.objectValue(-999902, SparseArray.class));
                    onDownloadActive(AaHO0E.AYUAbz(ADYaiT3.objectValue(223607, AaHO0E.ARc23Z())), ((Integer) ADYaiT3.objectValue(223608, Integer.class)).intValue());
                    break;
                case 223603:
                    ASJ6gh ADYaiT4 = A2egSU.ADYaiT((SparseArray) pluginValueSet.objectValue(-999902, SparseArray.class));
                    onDownloadPaused(AaHO0E.AYUAbz(ADYaiT4.objectValue(223607, AaHO0E.ARc23Z())), ((Integer) ADYaiT4.objectValue(223608, Integer.class)).intValue());
                    break;
                case 223604:
                    onDownloadFailed(AaHO0E.AYUAbz(A2egSU.ADYaiT((SparseArray) pluginValueSet.objectValue(-999902, SparseArray.class)).objectValue(223607, AaHO0E.ARc23Z())));
                    break;
                case 223605:
                    onInstalled(AaHO0E.AYUAbz(A2egSU.ADYaiT((SparseArray) pluginValueSet.objectValue(-999902, SparseArray.class)).objectValue(223607, AaHO0E.ARc23Z())));
                    break;
                case 223606:
                    onDownloadFinished(AaHO0E.AYUAbz(A2egSU.ADYaiT((SparseArray) pluginValueSet.objectValue(-999902, SparseArray.class)).objectValue(223607, AaHO0E.ARc23Z())));
                    break;
            }
        }
        return null;
    }

    @Override // java.util.function.LongSupplier
    public long getAsLong() {
        return -99999981L;
    }

    public int getCurrentPercent() {
        return this.mCurrentPercent;
    }

    public abstract void onDownloadActive(long j, long j2, String str);

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadActive(DownloadShortInfo downloadShortInfo, int i) {
        if (downloadShortInfo == null) {
            return;
        }
        setCurrentPercent(i);
        onDownloadActive(downloadShortInfo.totalBytes, downloadShortInfo.currentBytes, downloadShortInfo.fileName);
    }

    public abstract void onDownloadFailed(long j, long j2, String str);

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadFailed(DownloadShortInfo downloadShortInfo) {
        if (downloadShortInfo == null) {
            return;
        }
        onDownloadFailed(downloadShortInfo.totalBytes, downloadShortInfo.currentBytes, downloadShortInfo.fileName);
    }

    public abstract void onDownloadFinished(long j, long j2, String str);

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadFinished(DownloadShortInfo downloadShortInfo) {
        if (downloadShortInfo == null) {
            return;
        }
        onDownloadFinished(downloadShortInfo.totalBytes, downloadShortInfo.currentBytes, downloadShortInfo.fileName);
    }

    public abstract void onDownloadPaused(long j, long j2, String str);

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadPaused(DownloadShortInfo downloadShortInfo, int i) {
        if (downloadShortInfo == null) {
            return;
        }
        setCurrentPercent(i);
        onDownloadPaused(downloadShortInfo.totalBytes, downloadShortInfo.currentBytes, downloadShortInfo.fileName);
    }

    public abstract void onDownloadStart();

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadStart(DownloadModel downloadModel, DownloadController downloadController) {
        if (downloadModel == null) {
            return;
        }
        setCurrentPercent(0);
        onDownloadStart();
    }

    public abstract void onInstalled(long j, long j2, String str);

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onInstalled(DownloadShortInfo downloadShortInfo) {
        if (downloadShortInfo == null) {
            return;
        }
        setCurrentPercent(100);
        String str = downloadShortInfo.fileName;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        onInstalled(downloadShortInfo.totalBytes, downloadShortInfo.currentBytes, str);
    }

    private void onDownloadFailed(Function<SparseArray<Object>, Object> function) {
        PluginValueSet hf;
        if (function == null || (hf = com.bytedance.sdk.openadsdk.zg.w.hf(function)) == null) {
            return;
        }
        onDownloadFailed(hf.longValue(223704), hf.longValue(223705), hf.stringValue(223706));
    }

    private void onDownloadFinished(Function<SparseArray<Object>, Object> function) {
        PluginValueSet hf;
        if (function == null || (hf = com.bytedance.sdk.openadsdk.zg.w.hf(function)) == null) {
            return;
        }
        onDownloadFinished(hf.longValue(223704), hf.longValue(223705), hf.stringValue(223706));
    }

    private void onDownloadActive(Function<SparseArray<Object>, Object> function, int i) {
        PluginValueSet hf;
        if (function == null || (hf = com.bytedance.sdk.openadsdk.zg.w.hf(function)) == null) {
            return;
        }
        onDownloadActive(hf.longValue(223704), hf.longValue(223705), hf.stringValue(223706));
    }

    private void onDownloadPaused(Function<SparseArray<Object>, Object> function, int i) {
        PluginValueSet hf;
        if (function == null || (hf = com.bytedance.sdk.openadsdk.zg.w.hf(function)) == null) {
            return;
        }
        onDownloadPaused(hf.longValue(223704), hf.longValue(223705), hf.stringValue(223706));
    }

    private void onDownloadStart(Function<SparseArray<Object>, Object> function, Function<SparseArray<Object>, Object> function2) {
        if (function == null || com.bytedance.sdk.openadsdk.zg.w.hf(function) == null) {
            return;
        }
        onDownloadStart();
    }

    private void onInstalled(Function<SparseArray<Object>, Object> function) {
        PluginValueSet hf;
        if (function == null || (hf = com.bytedance.sdk.openadsdk.zg.w.hf(function)) == null) {
            return;
        }
        long longValue = hf.longValue(223704);
        long longValue2 = hf.longValue(223705);
        String stringValue = hf.stringValue(223706);
        if (stringValue == null) {
            stringValue = "";
        }
        onInstalled(longValue, longValue2, stringValue);
    }
}
