package com.kwad.sdk.o;

import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import com.kwad.components.ad.reward.A2egSU;
import java.io.InputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class i extends Resources {
    private final Resources auh;

    public i(Resources resources, Resources resources2) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.auh = resources2;
    }

    private static boolean aD(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str.startsWith("ksad_") || !"com.kwad.dy.sdk".equals(str2);
    }

    private static boolean fC(int i) {
        StringBuilder sb = new StringBuilder("0x");
        sb.append(Integer.toHexString(i));
        return !sb.toString().startsWith("0x60");
    }

    @Override // android.content.res.Resources
    public final XmlResourceParser getAnimation(int i) {
        A2egSU.ADYaiT("KSDY/KSResource", i, new StringBuilder("getAnimation id: 0x#"));
        return fC(i) ? this.auh.getAnimation(i) : super.getAnimation(i);
    }

    @Override // android.content.res.Resources
    public final boolean getBoolean(int i) {
        A2egSU.ADYaiT("KSDY/KSResource", i, new StringBuilder("getBoolean id: #0x"));
        return fC(i) ? this.auh.getBoolean(i) : super.getBoolean(i);
    }

    @Override // android.content.res.Resources
    @Deprecated
    public final int getColor(int i) {
        A2egSU.ADYaiT("KSDY/KSResource", i, new StringBuilder("getColor id: #0x"));
        return fC(i) ? this.auh.getColor(i) : super.getColor(i);
    }

    @Override // android.content.res.Resources
    public final ColorStateList getColorStateList(int i, Resources.Theme theme) {
        try {
            com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getColorStateList: 0x#" + Integer.toHexString(i));
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.e("KSDY/KSResource", Log.getStackTraceString(e));
        }
        return fC(i) ? this.auh.getColorStateList(i, theme) : super.getColorStateList(i, theme);
    }

    @Override // android.content.res.Resources
    public final float getDimension(int i) {
        A2egSU.ADYaiT("KSDY/KSResource", i, new StringBuilder("getDimension id: #0x"));
        return fC(i) ? this.auh.getDimension(i) : super.getDimension(i);
    }

    @Override // android.content.res.Resources
    public final int getDimensionPixelOffset(int i) {
        A2egSU.ADYaiT("KSDY/KSResource", i, new StringBuilder("getDimensionPixelOffset id: #0x"));
        return fC(i) ? this.auh.getDimensionPixelOffset(i) : super.getDimensionPixelOffset(i);
    }

    @Override // android.content.res.Resources
    public final int getDimensionPixelSize(int i) {
        A2egSU.ADYaiT("KSDY/KSResource", i, new StringBuilder("getDimensionPixelSize id: #0x"));
        return fC(i) ? this.auh.getDimensionPixelSize(i) : super.getDimensionPixelSize(i);
    }

    @Override // android.content.res.Resources
    public final DisplayMetrics getDisplayMetrics() {
        return super.getDisplayMetrics();
    }

    @Override // android.content.res.Resources
    @Deprecated
    public final Drawable getDrawable(int i) {
        A2egSU.ADYaiT("KSDY/KSResource", i, new StringBuilder("getDrawable id: #0x"));
        return fC(i) ? this.auh.getDrawable(i) : super.getDrawable(i);
    }

    @Override // android.content.res.Resources
    @Deprecated
    public final Drawable getDrawableForDensity(int i, int i2) {
        A2egSU.ADYaiT("KSDY/KSResource", i, new StringBuilder("getDrawableForDensity id: #0x"));
        return fC(i) ? this.auh.getDrawableForDensity(i, i2) : super.getDrawableForDensity(i, i2);
    }

    @Override // android.content.res.Resources
    public final float getFloat(int i) {
        A2egSU.ADYaiT("KSDY/KSResource", i, new StringBuilder("getFloat id: #0x"));
        return fC(i) ? this.auh.getFloat(i) : super.getFloat(i);
    }

    @Override // android.content.res.Resources
    public final Typeface getFont(int i) {
        A2egSU.ADYaiT("KSDY/KSResource", i, new StringBuilder("getFont id: #0x"));
        return fC(i) ? this.auh.getFont(i) : super.getFont(i);
    }

    @Override // android.content.res.Resources
    public final float getFraction(int i, int i2, int i3) {
        A2egSU.ADYaiT("KSDY/KSResource", i, new StringBuilder("getFraction id: #0x"));
        return fC(i) ? this.auh.getFraction(i, i2, i3) : super.getFraction(i, i2, i3);
    }

    @Override // android.content.res.Resources
    public final int getIdentifier(String str, String str2, String str3) {
        com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getIdentifier id: 0x# name:" + str + " :defPackage" + str3);
        return aD(str, str3) ? this.auh.getIdentifier(str, str2, str3) : super.getIdentifier(str, str2, str3);
    }

    @Override // android.content.res.Resources
    public final int[] getIntArray(int i) {
        A2egSU.ADYaiT("KSDY/KSResource", i, new StringBuilder("getIntArray id: #0x"));
        return fC(i) ? this.auh.getIntArray(i) : super.getIntArray(i);
    }

    @Override // android.content.res.Resources
    public final int getInteger(int i) {
        A2egSU.ADYaiT("KSDY/KSResource", i, new StringBuilder("getInteger id: #0x"));
        return fC(i) ? this.auh.getInteger(i) : super.getInteger(i);
    }

    @Override // android.content.res.Resources
    public final XmlResourceParser getLayout(int i) {
        A2egSU.ADYaiT("KSDY/KSResource", i, new StringBuilder("getLayout id: 0x#"));
        return fC(i) ? this.auh.getLayout(i) : super.getLayout(i);
    }

    @Override // android.content.res.Resources
    @Deprecated
    public final Movie getMovie(int i) {
        A2egSU.ADYaiT("KSDY/KSResource", i, new StringBuilder("getMovie id: #0x"));
        return fC(i) ? this.auh.getMovie(i) : super.getMovie(i);
    }

    @Override // android.content.res.Resources
    public final String getQuantityString(int i, int i2) {
        A2egSU.ADYaiT("KSDY/KSResource", i, new StringBuilder("getQuantityString id: #0x"));
        return fC(i) ? this.auh.getQuantityString(i, i2) : super.getQuantityString(i, i2);
    }

    @Override // android.content.res.Resources
    public final CharSequence getQuantityText(int i, int i2) {
        A2egSU.ADYaiT("KSDY/KSResource", i, new StringBuilder("getQuantityText id: #0x"));
        return fC(i) ? this.auh.getQuantityText(i, i2) : super.getQuantityText(i, i2);
    }

    @Override // android.content.res.Resources
    public final String getResourceEntryName(int i) {
        A2egSU.ADYaiT("KSDY/KSResource", i, new StringBuilder("getResourceEntryName id: 0x#"));
        return fC(i) ? this.auh.getResourceEntryName(i) : super.getResourceEntryName(i);
    }

    @Override // android.content.res.Resources
    public final String getResourceName(int i) {
        A2egSU.ADYaiT("KSDY/KSResource", i, new StringBuilder("getResourceName id: 0x#"));
        return fC(i) ? this.auh.getResourceName(i) : super.getResourceName(i);
    }

    @Override // android.content.res.Resources
    public final String getResourcePackageName(int i) {
        A2egSU.ADYaiT("KSDY/KSResource", i, new StringBuilder("getResourcePackageName id: 0x#"));
        return fC(i) ? this.auh.getResourcePackageName(i) : super.getResourcePackageName(i);
    }

    @Override // android.content.res.Resources
    public final String getResourceTypeName(int i) {
        A2egSU.ADYaiT("KSDY/KSResource", i, new StringBuilder("getResourceTypeName id: 0x#"));
        return fC(i) ? this.auh.getResourceTypeName(i) : super.getResourceTypeName(i);
    }

    @Override // android.content.res.Resources
    public final String getString(int i) {
        A2egSU.ADYaiT("KSDY/KSResource", i, new StringBuilder("getString id: #0x"));
        return fC(i) ? this.auh.getString(i) : super.getString(i);
    }

    @Override // android.content.res.Resources
    public final String[] getStringArray(int i) {
        A2egSU.ADYaiT("KSDY/KSResource", i, new StringBuilder("getStringArray id: #0x"));
        return fC(i) ? this.auh.getStringArray(i) : super.getStringArray(i);
    }

    @Override // android.content.res.Resources
    public final CharSequence getText(int i) {
        A2egSU.ADYaiT("KSDY/KSResource", i, new StringBuilder("getText id: #0x"));
        return fC(i) ? this.auh.getText(i) : super.getText(i);
    }

    @Override // android.content.res.Resources
    public final CharSequence[] getTextArray(int i) {
        A2egSU.ADYaiT("KSDY/KSResource", i, new StringBuilder("getTextArray id: #0x"));
        return fC(i) ? this.auh.getTextArray(i) : super.getTextArray(i);
    }

    @Override // android.content.res.Resources
    public final void getValue(int i, TypedValue typedValue, boolean z) {
        A2egSU.ADYaiT("KSDY/KSResource", i, new StringBuilder("getValue id: 0x#"));
        if (fC(i)) {
            this.auh.getValue(i, typedValue, z);
        } else {
            super.getValue(i, typedValue, z);
        }
    }

    @Override // android.content.res.Resources
    public final void getValueForDensity(int i, int i2, TypedValue typedValue, boolean z) {
        A2egSU.ADYaiT("KSDY/KSResource", i, new StringBuilder("getValueForDensity id: 0x#"));
        if (fC(i)) {
            this.auh.getValueForDensity(i, i2, typedValue, z);
        } else {
            super.getValueForDensity(i, i2, typedValue, z);
        }
    }

    @Override // android.content.res.Resources
    public final XmlResourceParser getXml(int i) {
        A2egSU.ADYaiT("KSDY/KSResource", i, new StringBuilder("getXml id: 0x#"));
        return fC(i) ? this.auh.getXml(i) : super.getXml(i);
    }

    @Override // android.content.res.Resources
    public final TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return super.obtainAttributes(attributeSet, iArr);
    }

    @Override // android.content.res.Resources
    public final TypedArray obtainTypedArray(int i) {
        A2egSU.ADYaiT("KSDY/KSResource", i, new StringBuilder("obtainTypedArray id: #0x"));
        return fC(i) ? this.auh.obtainTypedArray(i) : super.obtainTypedArray(i);
    }

    @Override // android.content.res.Resources
    public final InputStream openRawResource(int i) {
        A2egSU.ADYaiT("KSDY/KSResource", i, new StringBuilder("openRawResource id: 0x#"));
        return fC(i) ? this.auh.openRawResource(i) : super.openRawResource(i);
    }

    @Override // android.content.res.Resources
    public final AssetFileDescriptor openRawResourceFd(int i) {
        A2egSU.ADYaiT("KSDY/KSResource", i, new StringBuilder("openRawResourceFd id: 0x#"));
        return fC(i) ? this.auh.openRawResourceFd(i) : super.openRawResourceFd(i);
    }

    @Override // android.content.res.Resources
    public final void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) {
        super.parseBundleExtra(str, attributeSet, bundle);
    }

    @Override // android.content.res.Resources
    public final void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) {
        super.parseBundleExtras(xmlResourceParser, bundle);
    }

    @Override // android.content.res.Resources
    public final void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
    }

    @Override // android.content.res.Resources
    public final ColorStateList getColorStateList(int i) {
        try {
            com.kwad.sdk.core.d.c.d("KSDY/KSResource", "getColorStateList: 0x#" + Integer.toHexString(i));
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.e("KSDY/KSResource", Log.getStackTraceString(e));
        }
        if (fC(i)) {
            return this.auh.getColorStateList(i);
        }
        return super.getColorStateList(i);
    }

    @Override // android.content.res.Resources
    public final int getColor(int i, Resources.Theme theme) {
        A2egSU.ADYaiT("KSDY/KSResource", i, new StringBuilder("getMovie id: #0x"));
        if (fC(i)) {
            return this.auh.getColor(i, theme);
        }
        return super.getColor(i, theme);
    }

    @Override // android.content.res.Resources
    public final Drawable getDrawable(int i, Resources.Theme theme) {
        A2egSU.ADYaiT("KSDY/KSResource", i, new StringBuilder("getDrawable id: #0x"));
        if (fC(i)) {
            return this.auh.getDrawable(i);
        }
        return super.getDrawable(i, theme);
    }

    @Override // android.content.res.Resources
    public final Drawable getDrawableForDensity(int i, int i2, Resources.Theme theme) {
        A2egSU.ADYaiT("KSDY/KSResource", i, new StringBuilder("getDrawable id: #0x"));
        if (fC(i)) {
            return this.auh.getDrawableForDensity(i, i2, theme);
        }
        return super.getDrawableForDensity(i, i2, theme);
    }

    @Override // android.content.res.Resources
    public final String getQuantityString(int i, int i2, Object... objArr) {
        A2egSU.ADYaiT("KSDY/KSResource", i, new StringBuilder("getQuantityString id: #0x"));
        if (fC(i)) {
            return this.auh.getQuantityString(i, i2, objArr);
        }
        return super.getQuantityString(i, i2, objArr);
    }

    @Override // android.content.res.Resources
    public final String getString(int i, Object... objArr) {
        A2egSU.ADYaiT("KSDY/KSResource", i, new StringBuilder("getString id: #0x"));
        if (fC(i)) {
            return this.auh.getString(i, objArr);
        }
        return super.getString(i, objArr);
    }

    @Override // android.content.res.Resources
    public final CharSequence getText(int i, CharSequence charSequence) {
        A2egSU.ADYaiT("KSDY/KSResource", i, new StringBuilder("getText id: #0x"));
        if (fC(i)) {
            return this.auh.getText(i, charSequence);
        }
        return super.getText(i, charSequence);
    }

    @Override // android.content.res.Resources
    public final void getValue(String str, TypedValue typedValue, boolean z) {
        int identifier = getIdentifier(str, "string", null);
        A2egSU.ADYaiT("KSDY/KSResource", identifier, new StringBuilder("getValue id: 0x#"));
        if (fC(identifier)) {
            this.auh.getValue(str, typedValue, z);
        } else {
            super.getValue(str, typedValue, z);
        }
    }

    @Override // android.content.res.Resources
    public final InputStream openRawResource(int i, TypedValue typedValue) {
        A2egSU.ADYaiT("KSDY/KSResource", i, new StringBuilder("openRawResource id: 0x#"));
        if (fC(i)) {
            return this.auh.openRawResource(i, typedValue);
        }
        return super.openRawResource(i, typedValue);
    }
}
