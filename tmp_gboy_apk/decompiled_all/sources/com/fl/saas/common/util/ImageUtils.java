package com.fl.saas.common.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.net.ThreadPoolManager;
import com.sigmob.sdk.base.views.r;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ImageUtils {
    public static BitmapDrawable bitmapDrawableToRoundCorner(BitmapDrawable bitmapDrawable, int i) {
        return new BitmapDrawable(bitmapToRoundCorner(bitmapDrawable.getBitmap(), i));
    }

    public static byte[] bitmapToByteArray(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static Drawable bitmapToDrawable(Resources resources, Bitmap bitmap) {
        return new BitmapDrawable(resources, bitmap);
    }

    public static InputStream bitmapToInputStream(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }

    public static Bitmap bitmapToRoundCorner(Bitmap bitmap, int i) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        float f = i;
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return createBitmap;
    }

    public static Bitmap byteArrayToBitmap(byte[] bArr) {
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
    }

    public static Drawable byteArrayToDrawable(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inSampleSize = 2;
        return new BitmapDrawable(BitmapFactory.decodeStream(byteArrayInputStream, null, options));
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int i, int i2) {
        float f;
        float f2;
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        if (i3 <= i2 && i4 <= i) {
            return 1;
        }
        if (i4 > i3) {
            f = i3;
            f2 = i2;
        } else {
            f = i4;
            f2 = i;
        }
        return Math.round(f / f2);
    }

    public static Bitmap compressImage(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 80;
        bitmap.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
        while (byteArrayOutputStream.toByteArray().length / 1024 > 100) {
            byteArrayOutputStream.reset();
            bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
            i -= 10;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        byteArrayOutputStream.toByteArray();
        return BitmapFactory.decodeStream(byteArrayInputStream, null, null);
    }

    private static int computeInitialSampleSize(BitmapFactory.Options options, int i, int i2) {
        int min;
        double d = options.outWidth;
        double d2 = options.outHeight;
        int ceil = i2 == -1 ? 1 : (int) Math.ceil(Math.sqrt((d * d2) / i2));
        if (i == -1) {
            min = r.b.d;
        } else {
            double d3 = i;
            min = (int) Math.min(Math.floor(d / d3), Math.floor(d2 / d3));
        }
        if (min >= ceil) {
            if (i2 == -1 && i == -1) {
                return 1;
            }
            if (i != -1) {
                return min;
            }
        }
        return ceil;
    }

    public static int computeSampleSize(BitmapFactory.Options options, int i, int i2) {
        int computeInitialSampleSize = computeInitialSampleSize(options, i, i2);
        if (computeInitialSampleSize > 8) {
            return ((computeInitialSampleSize + 7) / 8) * 8;
        }
        int i3 = 1;
        while (i3 < computeInitialSampleSize) {
            i3 <<= 1;
        }
        return i3;
    }

    public static Bitmap convertMipmapToBitmap(Context context, int i) {
        return BitmapFactory.decodeResource(context.getResources(), i);
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public static byte[] drawableToByteArray(Drawable drawable) {
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static InputStream drawableToInputStream(Drawable drawable) {
        return bitmapToInputStream(drawableToBitmap(drawable));
    }

    public static Drawable drawableToRoundCorner(Drawable drawable, int i) {
        return bitmapToDrawable(bitmapToRoundCorner(drawableToBitmap(drawable), i));
    }

    public static Drawable filtToDrawable(String str) {
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(new File(str));
            try {
                Drawable createFromStream = Drawable.createFromStream(fileInputStream2, null);
                fileInputStream2.close();
                return createFromStream;
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                fileInputStream.close();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static Bitmap getAssetsBitmap(Context context, String str) {
        InputStream inputStream;
        try {
            inputStream = context.getAssets().open(str);
        } catch (IOException e) {
            e.printStackTrace();
            inputStream = null;
        }
        return BitmapFactory.decodeStream(inputStream);
    }

    private static BitmapFactory.Options getBitmapOption(int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPurgeable = true;
        options.inSampleSize = i;
        return options;
    }

    public static Bitmap getResourceBitmap(Context context, int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inPurgeable = true;
        options.inInputShareable = true;
        return BitmapFactory.decodeStream(context.getResources().openRawResource(i), null, options);
    }

    public static Drawable getResourceDrawable(Context context, int i) {
        return context.getResources().getDrawable(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Bitmap getimage(java.lang.String r8) {
        /*
            android.graphics.BitmapFactory$Options r0 = new android.graphics.BitmapFactory$Options
            r0.<init>()
            r1 = 1
            r0.inJustDecodeBounds = r1
            android.graphics.BitmapFactory.decodeFile(r8, r0)
            r2 = 0
            r0.inJustDecodeBounds = r2
            int r3 = r0.outWidth
            int r4 = r0.outHeight
            if (r3 <= r4) goto L1e
            float r5 = (float) r3
            r6 = 1149698048(0x44870000, float:1080.0)
            int r7 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r7 <= 0) goto L1e
            float r5 = r5 / r6
            int r2 = (int) r5
            goto L29
        L1e:
            if (r3 >= r4) goto L29
            float r3 = (float) r4
            r4 = 1156579328(0x44f00000, float:1920.0)
            int r5 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r5 <= 0) goto L29
            float r3 = r3 / r4
            int r2 = (int) r3
        L29:
            if (r2 > 0) goto L2c
            goto L2d
        L2c:
            r1 = r2
        L2d:
            r0.inSampleSize = r1
            android.graphics.Bitmap r8 = android.graphics.BitmapFactory.decodeFile(r8, r0)
            android.graphics.Bitmap r8 = compressImage(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fl.saas.common.util.ImageUtils.getimage(java.lang.String):android.graphics.Bitmap");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setBlurImage$1(Drawable drawable, ImageView imageView) {
        DeviceUtil.postUI(new AMqCpz(imageView, rsBlur(imageView.getContext(), Boolean.TRUE, ((BitmapDrawable) drawable).getBitmap(), 200)));
    }

    public static Bitmap rsBlur(Context context, Boolean bool, Bitmap bitmap, int i) {
        try {
            int max = Math.max(1, i);
            if (bool.booleanValue()) {
                bitmap = bitmap.copy(Bitmap.Config.ARGB_8888, true);
            }
            RenderScript create = RenderScript.create(context);
            Allocation createFromBitmap = Allocation.createFromBitmap(create, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
            Allocation createTyped = Allocation.createTyped(create, createFromBitmap.getType());
            ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
            int i2 = max / 25;
            int i3 = max % 25;
            for (int i4 = 0; i4 < i2; i4++) {
                create2.setInput(createFromBitmap);
                create2.setRadius(25.0f);
                create2.forEach(createTyped);
                createFromBitmap.copyFrom(createTyped);
            }
            if (i3 > 0) {
                create2.setInput(createFromBitmap);
                create2.setRadius(i3);
                create2.forEach(createTyped);
            }
            createTyped.copyTo(bitmap);
            create.destroy();
            return bitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean saveBitmap2file(Bitmap bitmap, String str) {
        FileOutputStream fileOutputStream;
        Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
        try {
            fileOutputStream = new FileOutputStream("/sdcard/" + str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            fileOutputStream = null;
        }
        return bitmap.compress(compressFormat, 100, fileOutputStream);
    }

    public static Bitmap scaleBitmap(Bitmap bitmap, float f) {
        if (bitmap == null) {
            throw new IllegalArgumentException("bitmap 为null");
        }
        if (f == 0.0f) {
            f = 1.0f;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(f, f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static Bitmap scaleBitmapMaxSize(Bitmap bitmap, float f) {
        return scaleBitmapMaxSize(bitmap, f, f);
    }

    public static Bitmap scaledBitmap(Bitmap bitmap, int i) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width == height) {
            height = i;
        } else if (height > width) {
            height = (height * i) / width;
        } else {
            if (height < width) {
                width = (width * i) / height;
                height = i;
            }
            i = width;
        }
        return Bitmap.createScaledBitmap(bitmap, i, height, true);
    }

    public static Drawable scaledDrawable(Drawable drawable, int i, int i2) {
        return bitmapToDrawable(scaledBitmap(drawableToBitmap(drawable), i, i2));
    }

    public static void setBlurImage(ImageView imageView, Drawable drawable) {
        if (imageView != null && (drawable instanceof BitmapDrawable)) {
            ThreadPoolManager.getInstance().addTask(new AMqCpz((BitmapDrawable) drawable, imageView));
        }
    }

    public static void setCenterCropBackground(View view, Bitmap bitmap) {
        float width;
        int width2;
        if (bitmap == null || view == null || bitmap.getHeight() == 0 || bitmap.getWidth() == 0) {
            return;
        }
        if (bitmap.getWidth() / bitmap.getHeight() > view.getWidth() / view.getHeight()) {
            width = view.getHeight();
            width2 = bitmap.getHeight();
        } else {
            width = view.getWidth();
            width2 = bitmap.getWidth();
        }
        float f = width / width2;
        Matrix matrix = new Matrix();
        matrix.postScale(f, f);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        Bitmap createBitmap2 = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        new Canvas(createBitmap2).drawBitmap(createBitmap, (view.getWidth() - createBitmap.getWidth()) / 2.0f, (view.getHeight() - createBitmap.getHeight()) / 2.0f, (Paint) null);
        view.setBackground(new BitmapDrawable(view.getResources(), createBitmap2));
    }

    public static Bitmap textToAdLogo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Paint paint = new Paint(1);
        paint.setTextSize(DeviceUtil.dip2px(12.0f));
        paint.setColor(-1);
        float measureText = paint.measureText(str);
        float descent = paint.descent() - paint.ascent();
        int dip2px = DeviceUtil.dip2px(2.0f) * 3;
        int round = Math.round((r4 * 2) + descent);
        int round2 = Math.round(measureText + (r4 * 6));
        Bitmap createBitmap = Bitmap.createBitmap(round2, round, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint2 = new Paint();
        paint2.setColor(Color.parseColor("#70000000"));
        float f = round;
        canvas.drawRect(0.0f, 0.0f, round2, f, paint2);
        canvas.drawText(str, dip2px, ((f - descent) / 2.0f) - paint.ascent(), paint);
        return createBitmap;
    }

    public static Drawable bitmapToDrawable(Resources resources, Bitmap bitmap, int i, int i2) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(resources, bitmap);
        bitmapDrawable.setBounds(0, 0, i, i2);
        return bitmapDrawable;
    }

    public static Bitmap scaleBitmapMaxSize(Bitmap bitmap, float f, float f2) {
        if (bitmap == null) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        float f3 = width;
        float height = bitmap.getHeight();
        float min = Math.min(Math.min(1.0f, f2 / height), Math.min(1.0f, f / f3));
        return Bitmap.createScaledBitmap(bitmap, Math.round(f3 * min), Math.round(height * min), true);
    }

    public static Bitmap scaledBitmap(Bitmap bitmap, int i, int i2) {
        return Bitmap.createScaledBitmap(bitmap, i, i2, true);
    }

    public static Drawable bitmapToDrawable(Bitmap bitmap) {
        return new BitmapDrawable(bitmap);
    }

    public static Drawable scaledBitmap(Drawable drawable, float f) {
        return bitmapToDrawable(scaleBitmap(drawableToBitmap(drawable), f));
    }
}
