package com.bytedance.sdk.openadsdk.core.wo.xj;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.ITTProvider;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u {

    public static class hf extends com.bytedance.sdk.openadsdk.core.wo.u implements xj {
        private xj xj;

        public hf(xj xjVar) {
            this.xj = xjVar;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.bytedance.sdk.openadsdk.core.wo.u
        public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
            T t = (T) 0;
            switch (i) {
                case -7999907:
                    return this.xj != null ? (T) Integer.valueOf(update((Uri) pluginValueSet.objectValue(-7999921, Uri.class), (ContentValues) pluginValueSet.objectValue(-7999922, ContentValues.class), pluginValueSet.stringValue(-7999923, null), (String[]) pluginValueSet.objectValue(-7999924, String[].class))) : t;
                case -7999906:
                    return this.xj != null ? (T) Integer.valueOf(delete((Uri) pluginValueSet.objectValue(-7999921, Uri.class), pluginValueSet.stringValue(-7999923, null), (String[]) pluginValueSet.objectValue(-7999924, String[].class))) : t;
                case -7999905:
                    if (this.xj != null) {
                        return (T) insert((Uri) pluginValueSet.objectValue(-7999921, Uri.class), (ContentValues) pluginValueSet.objectValue(-7999922, ContentValues.class));
                    }
                    return null;
                case -7999904:
                    if (this.xj != null) {
                        return (T) query((Uri) pluginValueSet.objectValue(-7999921, Uri.class), (String[]) pluginValueSet.objectValue(-7999922, String[].class), pluginValueSet.stringValue(-7999923, null), (String[]) pluginValueSet.objectValue(-7999924, String[].class), pluginValueSet.stringValue(-7999925, null));
                    }
                    return null;
                case -7999903:
                    if (this.xj != null) {
                        return (T) getType((Uri) pluginValueSet.objectValue(-7999921, Uri.class));
                    }
                    return null;
                case -7999902:
                    init();
                    return null;
                case -7999901:
                    return (T) getTableName();
                case -7999900:
                    if (this.xj != null) {
                        injectContext((Context) pluginValueSet.objectValue(-7999920, Context.class));
                    }
                    return null;
                default:
                    return null;
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
        public int delete(Uri uri, String str, String[] strArr) {
            xj xjVar = this.xj;
            if (xjVar != null) {
                return xjVar.delete(uri, str, strArr);
            }
            return 0;
        }

        @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
        public String getTableName() {
            xj xjVar = this.xj;
            if (xjVar != null) {
                return xjVar.getTableName();
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
        public String getType(Uri uri) {
            xj xjVar = this.xj;
            if (xjVar != null) {
                return xjVar.getType(uri);
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
        public void init() {
            xj xjVar = this.xj;
            if (xjVar != null) {
                xjVar.init();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
        public void injectContext(Context context) {
            xj xjVar = this.xj;
            if (xjVar != null) {
                xjVar.injectContext(context);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
        public Uri insert(Uri uri, ContentValues contentValues) {
            xj xjVar = this.xj;
            if (xjVar != null) {
                return xjVar.insert(uri, contentValues);
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
        public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
            xj xjVar = this.xj;
            if (xjVar != null) {
                return xjVar.query(uri, strArr, str, strArr2, str2);
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
        public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
            xj xjVar = this.xj;
            if (xjVar != null) {
                return xjVar.update(uri, contentValues, str, strArr);
            }
            return 0;
        }
    }

    public static class w implements ITTProvider, xj {
        private xj xj;

        public w(xj xjVar) {
            this.xj = xjVar;
        }

        @Override // com.bytedance.sdk.openadsdk.ITTProvider
        public int delete(Uri uri, String str, String[] strArr) {
            xj xjVar = this.xj;
            if (xjVar != null) {
                return xjVar.delete(uri, str, strArr);
            }
            return 0;
        }

        @Override // com.bytedance.sdk.openadsdk.ITTProvider
        public String getTableName() {
            xj xjVar = this.xj;
            if (xjVar != null) {
                return xjVar.getTableName();
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.ITTProvider
        public String getType(Uri uri) {
            xj xjVar = this.xj;
            if (xjVar != null) {
                return xjVar.getType(uri);
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.ITTProvider
        public void init() {
            xj xjVar = this.xj;
            if (xjVar != null) {
                xjVar.init();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.ITTProvider
        public void injectContext(Context context) {
            xj xjVar = this.xj;
            if (xjVar != null) {
                xjVar.injectContext(context);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.ITTProvider
        public Uri insert(Uri uri, ContentValues contentValues) {
            xj xjVar = this.xj;
            if (xjVar != null) {
                return xjVar.insert(uri, contentValues);
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.ITTProvider
        public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
            xj xjVar = this.xj;
            if (xjVar != null) {
                return xjVar.query(uri, strArr, str, strArr2, str2);
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.ITTProvider
        public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
            xj xjVar = this.xj;
            if (xjVar != null) {
                return xjVar.update(uri, contentValues, str, strArr);
            }
            return 0;
        }
    }

    public interface xj {
        int delete(Uri uri, String str, String[] strArr);

        String getTableName();

        String getType(Uri uri);

        void init();

        void injectContext(Context context);

        Uri insert(Uri uri, ContentValues contentValues);

        Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2);

        int update(Uri uri, ContentValues contentValues, String str, String[] strArr);
    }

    public static Object xj(xj xjVar, Class cls, Bundle bundle) {
        if (xj(bundle)) {
            return new hf(xjVar);
        }
        if (xj(cls)) {
            return new w(xjVar);
        }
        return null;
    }

    public static boolean xj(Class cls, Bundle bundle) {
        if (cls == null) {
            return false;
        }
        return xj(cls) || xj(bundle);
    }

    private static boolean xj(Class cls) {
        return cls != null && "com.bytedance.sdk.openadsdk.ITTProvider".equals(cls.getName());
    }

    private static boolean xj(Bundle bundle) {
        return bundle != null && bundle.getBoolean("proto2_ittprovider");
    }
}
