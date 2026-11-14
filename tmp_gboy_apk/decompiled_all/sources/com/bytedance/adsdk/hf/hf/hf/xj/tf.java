package com.bytedance.adsdk.hf.hf.hf.xj;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class tf implements com.bytedance.adsdk.hf.hf.hf.xj {
    private String hf;
    private com.bytedance.adsdk.hf.hf.xj.xj w;
    private com.bytedance.adsdk.hf.hf.hf.xj[] xj;

    public tf(String str) {
        this.hf = str;
    }

    @Override // com.bytedance.adsdk.hf.hf.hf.xj
    public String hf() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.hf);
        sb.append("(");
        com.bytedance.adsdk.hf.hf.hf.xj[] xjVarArr = this.xj;
        if (xjVarArr != null && xjVarArr.length > 0) {
            int i = 0;
            while (true) {
                com.bytedance.adsdk.hf.hf.hf.xj[] xjVarArr2 = this.xj;
                if (i >= xjVarArr2.length) {
                    break;
                }
                sb.append(xjVarArr2[i].hf());
                sb.append(",");
                i++;
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public void xj(com.bytedance.adsdk.hf.hf.hf.xj[] xjVarArr) {
        this.xj = xjVarArr;
    }

    @Override // com.bytedance.adsdk.hf.hf.hf.xj
    public Object xj(Map<String, JSONObject> map) {
        com.bytedance.adsdk.hf.hf.xj.xj xjVar = new com.bytedance.adsdk.hf.hf.xj.xj();
        this.w = xjVar;
        xjVar.xj(this.hf);
        Object[] objArr = new Object[this.xj.length];
        int i = 0;
        while (true) {
            com.bytedance.adsdk.hf.hf.hf.xj[] xjVarArr = this.xj;
            if (i >= xjVarArr.length) {
                this.w.xj(objArr);
                return com.bytedance.adsdk.hf.p.xj(this.hf).xj(map.get("default_key"), objArr);
            }
            com.bytedance.adsdk.hf.hf.hf.xj xjVar2 = xjVarArr[i];
            if (xjVar2 != null) {
                objArr[i] = xjVar2.xj(map);
            }
            i++;
        }
    }

    @Override // com.bytedance.adsdk.hf.hf.hf.xj
    public com.bytedance.adsdk.hf.hf.u.kd xj() {
        return com.bytedance.adsdk.hf.hf.u.hf.METHOD;
    }
}
