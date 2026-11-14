package com.bytedance.sdk.openadsdk.f;

import com.bytedance.sdk.component.y.pl;
import com.bytedance.sdk.component.y.q;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w implements q {
    private static int xj;
    private long hf = 0;
    private String kd;
    private boolean u;
    private long w;

    public w() {
        xj++;
        this.kd = "image_request_" + xj;
    }

    private String xj(String str, pl plVar) {
        com.bytedance.sdk.component.y.w.xj p;
        if (str == null) {
            return str;
        }
        switch (str) {
            case "success":
                return "成功";
            case "raw_cache":
                return "查询RAW内存缓存";
            case "image_type":
                return "判断图片类型：";
            case "disk_cache":
                return "查询文件缓存";
            case "decode":
                return "解码";
            case "failed":
                if (!(plVar instanceof com.bytedance.sdk.component.y.w.w) || (p = ((com.bytedance.sdk.component.y.w.w) plVar).p()) == null) {
                    return "失败";
                }
                Throwable w = p.w();
                StringBuilder sb = new StringBuilder("失败：code:");
                sb.append(p.xj());
                sb.append(", msg:");
                sb.append(p.hf());
                sb.append(", exception:");
                sb.append(w != null ? w.getMessage() : "null \r\n");
                return sb.toString();
            case "check_duplicate":
                return "检查重复请求";
            case "memory_cache":
                return "查询Bitmap内存缓存";
            case "net_request":
                return "请求网络";
            case "generate_key":
                return "生成KEY:" + plVar.getMemoryCacheKey();
            case "cache_policy":
                return "查询缓存策略";
            default:
                return str;
        }
    }

    @Override // com.bytedance.sdk.component.y.q
    public void onStepEnd(String str, pl plVar) {
        this.w += System.currentTimeMillis() - this.hf;
        xj(str, plVar);
    }

    @Override // com.bytedance.sdk.component.y.q
    public void onStepStart(String str, pl plVar) {
        if (!this.u) {
            plVar.getUrl();
            plVar.getWidth();
            plVar.getHeight();
            this.u = true;
        }
        this.hf = System.currentTimeMillis();
        xj(str, plVar);
    }
}
