package com.octopus.ad.internal.utilities;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class DownloadFactory {
    private static final int BUFFER_SIZE = 8192;
    private static final String TAG = "download";

    public interface Download {
        void cancel();

        void destroy();

        void pause();

        void register(DownloadDelegate downloadDelegate);

        void resume();

        void start(Request request);
    }

    public interface DownloadCode {
        public static final int CHECK_ERROR = 4;
        public static final int NET_ERROR = 2;
        public static final int NO_SPACE = 3;
        public static final int UNKNOWN_ERROR = 5;
        public static final int USER_CANCEL = 1;
        public static final int USER_PAUSE = 6;
    }

    public interface DownloadDelegate {
        boolean onCheck(File file);

        void onFail(int i);

        void onProgress(long j, long j2);

        void onSuccess(File file);
    }

    public static final class DownloadImpl implements Download, Runnable {
        private DownloadDelegate mDelegate;
        private HandlerThread mHandlerThread;
        private Handler mMainHandler = new Handler(Looper.getMainLooper());
        private Request mRequest;
        private Handler mThreadHandler;

        public DownloadImpl() {
            HandlerThread handlerThread = new HandlerThread(DownloadFactory.TAG);
            this.mHandlerThread = handlerThread;
            handlerThread.start();
            this.mThreadHandler = new Handler(this.mHandlerThread.getLooper());
        }

        private boolean onCheck(File file) {
            DownloadDelegate downloadDelegate = this.mDelegate;
            return downloadDelegate != null && downloadDelegate.onCheck(file);
        }

        private void onFail(final int i) {
            this.mMainHandler.post(new Runnable() { // from class: com.octopus.ad.internal.utilities.DownloadFactory.DownloadImpl.3
                @Override // java.lang.Runnable
                public void run() {
                    if (DownloadImpl.this.mDelegate != null) {
                        DownloadImpl.this.mDelegate.onFail(i);
                    }
                }
            });
        }

        private void onProgress(final long j, final long j2) {
            this.mMainHandler.post(new Runnable() { // from class: com.octopus.ad.internal.utilities.DownloadFactory.DownloadImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    if (DownloadImpl.this.mDelegate != null) {
                        DownloadImpl.this.mDelegate.onProgress(j, j2);
                    }
                }
            });
        }

        private void onSuccess(final File file) {
            this.mMainHandler.post(new Runnable() { // from class: com.octopus.ad.internal.utilities.DownloadFactory.DownloadImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    if (DownloadImpl.this.mDelegate != null) {
                        DownloadImpl.this.mDelegate.onSuccess(file);
                    }
                }
            });
        }

        @Override // com.octopus.ad.internal.utilities.DownloadFactory.Download
        public void cancel() {
            Request request = this.mRequest;
            if (request != null) {
                request.mUserCancel = true;
            }
        }

        @Override // com.octopus.ad.internal.utilities.DownloadFactory.Download
        public void destroy() {
            HandlerThread handlerThread = this.mHandlerThread;
            if (handlerThread != null) {
                handlerThread.quit();
            }
            this.mThreadHandler = null;
            this.mHandlerThread = null;
            this.mDelegate = null;
        }

        @Override // com.octopus.ad.internal.utilities.DownloadFactory.Download
        public void pause() {
            Request request = this.mRequest;
            if (request != null) {
                request.mUserPause = true;
            }
        }

        @Override // com.octopus.ad.internal.utilities.DownloadFactory.Download
        public void register(DownloadDelegate downloadDelegate) {
            this.mDelegate = downloadDelegate;
        }

        @Override // com.octopus.ad.internal.utilities.DownloadFactory.Download
        public void resume() {
            Request request = this.mRequest;
            if (request == null) {
                return;
            }
            if (!request.mUserPause) {
                start(new Request(this.mRequest));
                return;
            }
            this.mRequest.mUserPause = false;
            Handler handler = this.mThreadHandler;
            if (handler != null) {
                handler.post(this);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x015f, code lost:
        
            if (r0 == null) goto L42;
         */
        /* JADX WARN: Removed duplicated region for block: B:117:0x01b9  */
        /* JADX WARN: Removed duplicated region for block: B:119:? A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:120:0x01b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:124:0x01ab A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:128:0x01a0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 445
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.octopus.ad.internal.utilities.DownloadFactory.DownloadImpl.run():void");
        }

        @Override // com.octopus.ad.internal.utilities.DownloadFactory.Download
        public void start(Request request) {
            if (request.mDownloading) {
                throw new IllegalArgumentException("Invalid request,it's downloading");
            }
            Request request2 = this.mRequest;
            if (request2 != null && !request.equals(request2)) {
                this.mRequest.mUserCancel = true;
            }
            this.mRequest = request;
            request.reset();
            Handler handler = this.mThreadHandler;
            if (handler != null) {
                handler.post(this);
            }
        }
    }

    public static Download create() {
        return new DownloadImpl();
    }

    public static final class Request {
        public volatile boolean mDownloading;
        private String mName;
        private String mPath;
        private volatile long mPosition;
        private volatile long mTotal;
        private String mUrl;
        public volatile boolean mUserCancel;
        public volatile boolean mUserPause;

        public Request(String str, String str2, String str3) {
            this.mUrl = str;
            this.mPath = str2;
            this.mName = str3;
            reset();
        }

        public static /* synthetic */ long access$314(Request request, long j) {
            long j2 = request.mPosition + j;
            request.mPosition = j2;
            return j2;
        }

        public void reset() {
            this.mTotal = 0L;
            this.mPosition = 0L;
            this.mUserCancel = false;
            this.mUserPause = false;
            this.mDownloading = false;
        }

        public Request(Request request) {
            this.mUrl = request.mUrl;
            this.mPath = request.mPath;
            this.mName = request.mName;
            reset();
        }
    }
}
