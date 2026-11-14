package com.kwad.sdk.crash.model.message;

import B4ZgIw.AYUAbz;
import android.text.TextUtils;
import com.kwad.sdk.core.b;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.aa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class MemoryInfo implements b, Serializable {
    private static final long serialVersionUID = -4944913077323984734L;
    public int mAvailableMB;
    public int mFdCount;
    public int mJavaHeapLimitMB;
    public int mJavaHeapMB;
    public int mPssMB;
    public int mRssMB;
    public int mThreadsCount;
    public int mTotalMB;
    public int mVssMB;
    public List<String> mFds = new ArrayList();
    public List<ThreadInfo> mJavaThreads = new ArrayList();
    public List<ThreadInfo> mNativeThreads = new ArrayList();
    public List<ThreadInfo> mAllThreads = new ArrayList();

    public MemoryInfo() {
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.mTotalMB = jSONObject.optInt("mTotalMB");
        this.mAvailableMB = jSONObject.optInt("mAvailableMB");
        this.mJavaHeapLimitMB = jSONObject.optInt("mJavaHeapLimitMB");
        this.mJavaHeapMB = jSONObject.optInt("mJavaHeapMB");
        this.mVssMB = jSONObject.optInt("mVssMB");
        this.mRssMB = jSONObject.optInt("mRssMB");
        this.mPssMB = jSONObject.optInt("mPssMB");
        this.mThreadsCount = jSONObject.optInt("mThreadsCount");
        this.mFdCount = jSONObject.optInt("mFdCount");
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("mFds");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    String optString = optJSONArray.optString(i);
                    if (optString != null && !optString.isEmpty()) {
                        this.mFds.add(optString);
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("mJavaThreads");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    JSONObject optJSONObject = optJSONArray2.optJSONObject(i2);
                    if (optJSONObject != null) {
                        ThreadInfo threadInfo = new ThreadInfo();
                        threadInfo.parseJson(optJSONObject);
                        this.mJavaThreads.add(threadInfo);
                    }
                }
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("mNativeThreads");
            if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                    JSONObject optJSONObject2 = optJSONArray3.optJSONObject(i3);
                    if (optJSONObject2 != null) {
                        ThreadInfo threadInfo2 = new ThreadInfo();
                        threadInfo2.parseJson(optJSONObject2);
                        this.mNativeThreads.add(threadInfo2);
                    }
                }
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray("mAllThreads");
            if (optJSONArray4 == null || optJSONArray4.length() <= 0) {
                return;
            }
            for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                JSONObject optJSONObject3 = optJSONArray4.optJSONObject(i4);
                if (optJSONObject3 != null) {
                    ThreadInfo threadInfo3 = new ThreadInfo();
                    threadInfo3.parseJson(optJSONObject3);
                    this.mAllThreads.add(threadInfo3);
                }
            }
        } catch (Exception e) {
            c.printStackTraceOnly(e);
        }
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, "mTotalMB", this.mTotalMB);
        aa.putValue(jSONObject, "mAvailableMB", this.mAvailableMB);
        aa.putValue(jSONObject, "mJavaHeapLimitMB", this.mJavaHeapLimitMB);
        aa.putValue(jSONObject, "mJavaHeapMB", this.mJavaHeapMB);
        aa.putValue(jSONObject, "mVssMB", this.mVssMB);
        aa.putValue(jSONObject, "mRssMB", this.mRssMB);
        aa.putValue(jSONObject, "mPssMB", this.mPssMB);
        aa.putValue(jSONObject, "mThreadsCount", this.mThreadsCount);
        aa.putValue(jSONObject, "mFdCount", this.mFdCount);
        aa.putValue(jSONObject, "mFds", this.mFds);
        aa.putValue(jSONObject, "mJavaThreads", this.mJavaThreads);
        aa.putValue(jSONObject, "mNativeThreads", this.mNativeThreads);
        aa.putValue(jSONObject, "mAllThreads", this.mAllThreads);
        return jSONObject;
    }

    public String toString() {
        StringBuilder A4TApA2 = AYUAbz.A4TApA("\t总RAM容量: ");
        A4TApA2.append(this.mTotalMB);
        A4TApA2.append(" (MB)\n\t剩余RAM容量: ");
        A4TApA2.append(this.mAvailableMB);
        A4TApA2.append(" (MB)\n\t本进程Java堆上限: ");
        A4TApA2.append(this.mJavaHeapLimitMB);
        A4TApA2.append(" (MB)\n\t本进程Java堆已使用: ");
        A4TApA2.append(this.mJavaHeapMB);
        A4TApA2.append(" (MB)\n\t虚拟地址空间已使用Vss: ");
        A4TApA2.append(this.mVssMB);
        A4TApA2.append(" (MB)\n\t实际空间使用量(包含共享库) Rss: ");
        A4TApA2.append(this.mRssMB);
        A4TApA2.append(" (MB)\n\t实际空间使用量(共享库已经均摊)(高内存杀进程的依据）Pss: ");
        A4TApA2.append(this.mPssMB);
        A4TApA2.append(" (MB)\n\t打开文件描述符数: ");
        A4TApA2.append(this.mFdCount);
        A4TApA2.append("\n");
        if (this.mFds.size() > 0) {
            A4TApA2.append("\t文件描述符详情: \n");
            for (String str : this.mFds) {
                A4TApA2.append("\t");
                A4TApA2.append(str);
                A4TApA2.append("\n");
            }
        }
        A4TApA2.append("\t正在运行线程数: ");
        A4TApA2.append(this.mThreadsCount);
        A4TApA2.append("\tJava: ");
        A4TApA2.append(this.mJavaThreads.size());
        A4TApA2.append("\tNative: ");
        A4TApA2.append(this.mThreadsCount - this.mJavaThreads.size());
        A4TApA2.append("\n\n");
        if (this.mAllThreads.size() > 0) {
            A4TApA2.append("\t全部线程名: \n");
            for (ThreadInfo threadInfo : this.mAllThreads) {
                A4TApA2.append("\t");
                A4TApA2.append(threadInfo.mName);
                A4TApA2.append("\n");
            }
        }
        if (this.mJavaThreads.size() > 0) {
            A4TApA2.append("Java线程堆栈: \n");
            for (ThreadInfo threadInfo2 : this.mJavaThreads) {
                A4TApA2.append(threadInfo2.mName);
                A4TApA2.append("\n");
                A4TApA2.append(threadInfo2.mTrace.replace("#", "\n"));
                A4TApA2.append("\n");
            }
        }
        if (this.mNativeThreads.size() > 0) {
            A4TApA2.append("\tNative线程堆栈: \n");
            for (ThreadInfo threadInfo3 : this.mNativeThreads) {
                A4TApA2.append("\t");
                A4TApA2.append(threadInfo3.mName);
                A4TApA2.append("\t(tid=");
                A4TApA2.append(threadInfo3.mTid);
                A4TApA2.append(", index=");
                A4TApA2.append(threadInfo3.mIndex);
                A4TApA2.append("):\n");
                A4TApA2.append(threadInfo3.mTrace);
            }
        }
        return A4TApA2.substring(0);
    }

    public MemoryInfo(String str) {
        try {
            if (TextUtils.isEmpty(str) || "Unknown".equals(str)) {
                return;
            }
            parseJson(new JSONObject(str));
        } catch (JSONException e) {
            c.printStackTraceOnly(e);
        }
    }
}
