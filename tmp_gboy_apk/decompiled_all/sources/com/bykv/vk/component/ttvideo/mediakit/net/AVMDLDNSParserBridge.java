package com.bykv.vk.component.ttvideo.mediakit.net;

import android.text.TextUtils;
import java.util.Locale;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AVMDLDNSParserBridge implements AVMDLDNSParserListener {
    private static final String TAG = "AVMDLDNSParserBridge";
    private static boolean v2Usable = true;
    public String host;
    String ipList = null;
    boolean isFinish = false;
    private Lock lock = new ReentrantLock();
    private long handle = 0;

    private static native void _notifyParserResult(long j, String str, String str2, long j2, String str3);

    private static native void _notifyParserResultV2(long j, String str, String str2, long j2, String str3, int i);

    /* JADX WARN: Removed duplicated region for block: B:22:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int parserResult(long r12, java.lang.String r14, int r15) {
        /*
            r11 = this;
            r8 = 0
            r9 = 1
            boolean r0 = android.text.TextUtils.isEmpty(r14)
            if (r0 == 0) goto La
            r12 = -1
            return r12
        La:
            java.util.concurrent.locks.Lock r0 = r11.lock
            r0.lock()
            r11.handle = r12
            r12 = 0
            r11.host = r14     // Catch: java.lang.Throwable -> L59 java.lang.UnsatisfiedLinkError -> L6c
            com.bykv.vk.component.ttvideo.mediakit.net.IPCache r13 = com.bykv.vk.component.ttvideo.mediakit.net.IPCache.getInstance()     // Catch: java.lang.Throwable -> L59 java.lang.UnsatisfiedLinkError -> L6c
            com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSInfo r13 = r13.get(r14)     // Catch: java.lang.Throwable -> L59 java.lang.UnsatisfiedLinkError -> L6c
            if (r13 == 0) goto L70
            java.lang.String r0 = r13.mIpList     // Catch: java.lang.Throwable -> L59 java.lang.UnsatisfiedLinkError -> L6c
            r11.ipList = r0     // Catch: java.lang.Throwable -> L59 java.lang.UnsatisfiedLinkError -> L6c
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L59 java.lang.UnsatisfiedLinkError -> L6c
            java.lang.String r3 = "get result from cache expiredT:%d curT:%d "
            long r4 = r13.mExpiredTime     // Catch: java.lang.Throwable -> L59 java.lang.UnsatisfiedLinkError -> L6c
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch: java.lang.Throwable -> L59 java.lang.UnsatisfiedLinkError -> L6c
            java.lang.Long r5 = java.lang.Long.valueOf(r0)     // Catch: java.lang.Throwable -> L59 java.lang.UnsatisfiedLinkError -> L6c
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch: java.lang.Throwable -> L59 java.lang.UnsatisfiedLinkError -> L6c
            r6[r8] = r4     // Catch: java.lang.Throwable -> L59 java.lang.UnsatisfiedLinkError -> L6c
            r6[r9] = r5     // Catch: java.lang.Throwable -> L59 java.lang.UnsatisfiedLinkError -> L6c
            java.lang.String.format(r3, r6)     // Catch: java.lang.Throwable -> L59 java.lang.UnsatisfiedLinkError -> L6c
            long r4 = r13.mExpiredTime     // Catch: java.lang.Throwable -> L59 java.lang.UnsatisfiedLinkError -> L6c
            int r3 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r3 > 0) goto L44
            r10 = 1
            goto L45
        L44:
            r10 = 0
        L45:
            long r0 = r11.handle     // Catch: java.lang.Throwable -> L59 java.lang.UnsatisfiedLinkError -> L5c
            r6 = 0
            int r3 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r3 == 0) goto L6a
            if (r15 != r9) goto L5f
            com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSParserBridge.v2Usable = r8     // Catch: java.lang.Throwable -> L59 java.lang.UnsatisfiedLinkError -> L5c
            java.lang.String r3 = r11.ipList     // Catch: java.lang.Throwable -> L59 java.lang.UnsatisfiedLinkError -> L5c
            r6 = 0
            r2 = r14
            _notifyParserResult(r0, r2, r3, r4, r6)     // Catch: java.lang.Throwable -> L59 java.lang.UnsatisfiedLinkError -> L5c
            goto L6a
        L59:
            r0 = move-exception
            r12 = r0
            goto Laa
        L5c:
            r0 = move-exception
            r13 = r0
            goto L79
        L5f:
            com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSParserBridge.v2Usable = r9     // Catch: java.lang.Throwable -> L59 java.lang.UnsatisfiedLinkError -> L5c
            java.lang.String r3 = r11.ipList     // Catch: java.lang.Throwable -> L59 java.lang.UnsatisfiedLinkError -> L5c
            int r7 = r13.mType     // Catch: java.lang.Throwable -> L59 java.lang.UnsatisfiedLinkError -> L5c
            r6 = 0
            r2 = r14
            _notifyParserResultV2(r0, r2, r3, r4, r6, r7)     // Catch: java.lang.Throwable -> L59 java.lang.UnsatisfiedLinkError -> L5c
        L6a:
            r13 = 1
            goto L73
        L6c:
            r0 = move-exception
            r13 = r0
            r10 = 1
            goto L79
        L70:
            r13 = 0
            r12 = r11
            r10 = 1
        L73:
            java.util.concurrent.locks.Lock r0 = r11.lock
            r0.unlock()
            goto L8e
        L79:
            java.lang.String r0 = "AVMDLDNSParserBridge"
            java.lang.String r13 = r13.toString()     // Catch: java.lang.Throwable -> L59
            com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLLog.e(r0, r13)     // Catch: java.lang.Throwable -> L59
            boolean r13 = com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSParserBridge.v2Usable     // Catch: java.lang.Throwable -> L59
            if (r13 == 0) goto L88
            com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSParserBridge.v2Usable = r8     // Catch: java.lang.Throwable -> L59
        L88:
            java.util.concurrent.locks.Lock r13 = r11.lock
            r13.unlock()
            r13 = 0
        L8e:
            if (r10 == 0) goto La0
            java.lang.String r0 = "call add host to parser listener:%s"
            java.lang.Object[] r1 = new java.lang.Object[r9]
            r1[r8] = r12
            java.lang.String.format(r0, r1)
            com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSParser r0 = com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSParser.getInstance()
            r0.addHost(r14, r12)
        La0:
            java.lang.String r0 = "****call start end, listener:%s"
            java.lang.Object[] r1 = new java.lang.Object[r9]
            r1[r8] = r12
            java.lang.String.format(r0, r1)
            return r13
        Laa:
            java.util.concurrent.locks.Lock r13 = r11.lock
            r13.unlock()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSParserBridge.parserResult(long, java.lang.String, int):int");
    }

    public String getBackUp(String str) {
        AVMDLDNSInfo backUpIp;
        if (AVMDLDNSParser.getIntValue(5) != 1 || (backUpIp = IPCache.getInstance().getBackUpIp(str)) == null) {
            return null;
        }
        return backUpIp.mIpList;
    }

    public String getResult() {
        this.lock.lock();
        try {
            return this.ipList;
        } finally {
            this.lock.unlock();
        }
    }

    public boolean isFinish() {
        return this.isFinish;
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSParserListener
    public void onCompletion(int i, String str, String str2, long j, String str3, int i2) {
        if (!this.isFinish && v2Usable) {
            parserResult(i, str, str2, j, str3, i2, 2);
        }
        if (this.isFinish) {
            return;
        }
        parserResult(i, str, str2, j, str3, i2, 1);
    }

    public void release() {
        String.format("----start release:%s", this);
        this.lock.lock();
        try {
            this.handle = 0L;
            this.lock.unlock();
            AVMDLDNSParser.getInstance().removeHost(this.host, this);
            String.format("****end call release:%s", this);
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    public int start(long j, String str) {
        int parserResult = v2Usable ? parserResult(j, str, 2) : 0;
        return parserResult <= 0 ? parserResult(j, str, 1) : parserResult;
    }

    private void parserResult(int i, String str, String str2, long j, String str3, int i2, int i3) {
        String str4;
        long j2;
        int i4;
        AVMDLDNSInfo backUpIp;
        this.lock.lock();
        try {
            try {
                if (!this.isFinish) {
                    Locale locale = Locale.ENGLISH;
                    TextUtils.isEmpty(str2);
                    if (TextUtils.isEmpty(str2) && AVMDLDNSParser.getIntValue(5) == 1 && (backUpIp = IPCache.getInstance().getBackUpIp(str)) != null) {
                        str4 = backUpIp.mIpList;
                        i4 = backUpIp.mType;
                        j2 = 0;
                    } else {
                        str4 = str2;
                        j2 = j;
                        i4 = i2;
                    }
                    this.ipList = str4;
                    this.isFinish = true;
                    long j3 = this.handle;
                    if (j3 != 0) {
                        if (i3 == 2) {
                            v2Usable = true;
                            _notifyParserResultV2(j3, str, str4, j2, str3, i4);
                        } else {
                            v2Usable = false;
                            _notifyParserResult(j3, str, str4, j2, str3);
                        }
                    }
                } else {
                    Locale locale2 = Locale.ENGLISH;
                }
            } catch (UnsatisfiedLinkError unused) {
                if (v2Usable) {
                    v2Usable = false;
                }
                this.isFinish = false;
            }
            this.lock.unlock();
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }
}
