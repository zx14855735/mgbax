package com.fl.saas.common.util;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.android.general.media.gif.FrameSequence;
import com.android.general.media.gif.FrameSequenceDrawable;
import com.fl.saas.common.rest.AdHttpUtils;
import com.fl.saas.common.util.ImageLoader;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.config.exception.ErrorCodeConstant;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.http.HttpCallbackBytesListener;
import com.fl.saas.config.utils.DeviceUtil;
import java.util.Arrays;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ImageLoader {

    /* renamed from: com.fl.saas.common.util.ImageLoader$1, reason: invalid class name */
    public class AnonymousClass1 implements HttpCallbackBytesListener {
        final /* synthetic */ Consumer val$load;
        final /* synthetic */ AmA8tU.A2egSU val$mapper;
        final /* synthetic */ Consumer val$onFail;

        public AnonymousClass1(Consumer consumer, AmA8tU.A2egSU a2egSU, Consumer consumer2) {
            this.val$onFail = consumer;
            this.val$mapper = a2egSU;
            this.val$load = consumer2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onError$3(Consumer consumer, Exception exc) {
            consumer.accept(YdError.create(ErrorCodeConstant.RENDER_ERROR, "NetWork Exception:" + exc.getMessage()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onSuccess$0(Consumer consumer) {
            consumer.accept(new YdError(ErrorCodeConstant.RENDER_ERROR, "response is null"));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onSuccess$1(Object obj, Consumer consumer, Consumer consumer2) {
            if (obj != null) {
                consumer.accept(obj);
            } else if (consumer2 != null) {
                consumer2.accept(YdError.create(ErrorCodeConstant.RENDER_ERROR, "img load is null"));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onSuccess$2(Consumer consumer, Exception exc) {
            consumer.accept(YdError.create(ErrorCodeConstant.RENDER_ERROR, "img load Exception:" + exc.getMessage()));
        }

        @Override // com.fl.saas.config.http.HttpCallbackBytesListener
        public void onError(Exception exc) {
            Consumer consumer = this.val$onFail;
            if (consumer != null) {
                DeviceUtil.postUI(new ADYaiT(consumer, exc, 1));
            }
        }

        @Override // com.fl.saas.config.http.HttpCallbackBytesListener
        public void onSuccess(byte[] bArr) {
            try {
                if (bArr == null) {
                    final Consumer consumer = this.val$onFail;
                    if (consumer != null) {
                        DeviceUtil.postUI(new Runnable() { // from class: com.fl.saas.common.util.A4TApA
                            @Override // java.lang.Runnable
                            public final void run() {
                                ImageLoader.AnonymousClass1.lambda$onSuccess$0(Consumer.this);
                            }
                        });
                        return;
                    }
                    return;
                }
                final Object apply = this.val$mapper.apply(bArr);
                final Consumer consumer2 = this.val$load;
                final Consumer consumer3 = this.val$onFail;
                DeviceUtil.postUI(new Runnable() { // from class: com.fl.saas.common.util.A5SV6n
                    @Override // java.lang.Runnable
                    public final void run() {
                        ImageLoader.AnonymousClass1.lambda$onSuccess$1(apply, consumer2, consumer3);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                Consumer consumer4 = this.val$onFail;
                if (consumer4 != null) {
                    DeviceUtil.postUI(new ADYaiT(consumer4, e, 0));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Drawable lambda$loadImageDrawable$0(byte[] bArr) {
        if (!"gif".equals(FileTypeUtils.getFileType(Arrays.copyOfRange(bArr, 0, Math.min(bArr.length, 10))))) {
            return ImageUtils.byteArrayToDrawable(bArr);
        }
        try {
            FrameSequenceDrawable frameSequenceDrawable = new FrameSequenceDrawable(FrameSequence.decodeByteArray(bArr));
            frameSequenceDrawable.setLoopBehavior(2);
            return frameSequenceDrawable;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static void loadImage(String str, final ImageView imageView) {
        if (TextUtils.isEmpty(str) || imageView == null) {
            return;
        }
        loadImageBitmap(str, new Consumer() { // from class: com.fl.saas.common.util.A2egSU
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                imageView.setImageBitmap((Bitmap) obj);
            }
        });
    }

    public static void loadImageBitmap(String str, Consumer<Bitmap> consumer) {
        loadImageBitmap(str, consumer, null);
    }

    private static <T> void loadImageBytes(String str, Consumer<T> consumer, Consumer<YdError> consumer2, AmA8tU.A2egSU a2egSU) {
        if (!TextUtils.isEmpty(str)) {
            AdHttpUtils.getInstance().doGet(str, new AnonymousClass1(consumer2, a2egSU, consumer));
        } else if (consumer2 != null) {
            consumer2.accept(YdError.create(ErrorCodeConstant.RENDER_ERROR, "imgUrl is empty"));
        }
    }

    public static void loadImageDrawable(String str, Consumer<Drawable> consumer) {
        loadImageDrawable(str, consumer, null);
    }

    public static void loadImageBitmap(String str, Consumer<Bitmap> consumer, Consumer<YdError> consumer2) {
        loadImageBytes(str, consumer, consumer2, new com.fl.saas.base.manager.loader.ADYaiT(8));
    }

    public static void loadImageDrawable(String str, Consumer<Drawable> consumer, Consumer<YdError> consumer2) {
        loadImageBytes(str, consumer, consumer2, new com.fl.saas.base.manager.loader.ADYaiT(9));
    }
}
