package com.bytedance.msdk.w.xj;

import ADYaiT.BpkvW3;
import P8ccfD.AaHO0E;
import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.u.xj.c.tf;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.zg.w.hf.pl;
import com.fl.saas.videocache.ProxyCacheUtils;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class c extends u {
    private com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj p;

    /* renamed from: pl, reason: collision with root package name */
    private com.bytedance.msdk.w.w.hf.xj.w f10166pl;

    public c(com.bytedance.msdk.w.y.hf.xj xjVar, com.bytedance.msdk.w.w.hf.xj.w wVar) {
        super(xjVar);
        this.f10166pl = wVar;
    }

    private void hf(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, tf tfVar, List<View> list4) {
        if (((u) this).d != null) {
            ((u) this).d.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(8159).xj(Void.class).xj(20033, activity).xj(8067, viewGroup).xj(8068, list).xj(8069, list2).xj(8070, list3).xj(8071, tf.xj(tfVar)).xj(8053, list4).hf());
        }
    }

    @Override // com.bytedance.msdk.hf.w
    public int ah() {
        Object apply;
        if (((u) this).d == null) {
            return super.lx();
        }
        apply = ((u) this).d.apply(A2egSU.ARc23Z(8162, Integer.class));
        if (apply instanceof Integer) {
            return ((Integer) apply).intValue();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.hf.w
    public double bh() {
        Object apply;
        if (((u) this).d == null) {
            return super.bh();
        }
        apply = ((u) this).d.apply(A2egSU.ARc23Z(8268, Double.class));
        if (apply instanceof Double) {
            return ((Double) apply).doubleValue();
        }
        return 0.0d;
    }

    @Override // com.bytedance.msdk.hf.w
    public String c() {
        Object apply;
        if (((u) this).d == null) {
            return super.c();
        }
        apply = ((u) this).d.apply(A2egSU.ARc23Z(8163, String.class));
        return apply instanceof String ? apply.toString() : "";
    }

    @Override // com.bytedance.msdk.hf.w
    public View d() {
        Object apply;
        if (((u) this).d == null) {
            return super.d();
        }
        apply = ((u) this).d.apply(A2egSU.ARc23Z(6081, View.class));
        if (apply instanceof View) {
            return (View) apply;
        }
        return null;
    }

    @Override // com.bytedance.msdk.hf.w
    public com.bytedance.msdk.api.u.xj.c.kd f() {
        Object apply;
        if (((u) this).d == null) {
            return null;
        }
        apply = ((u) this).d.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(8320).xj(AaHO0E.ARc23Z()).hf());
        if (BpkvW3.BmvVmW(apply)) {
            return com.bytedance.msdk.core.xj.xj.xj(AaHO0E.AYUAbz(apply));
        }
        return null;
    }

    @Override // com.bytedance.msdk.hf.w
    public Bitmap ho() {
        Object apply;
        if (TextUtils.equals(gh(), "gdt") && com.bytedance.msdk.core.xj.xj.kd.xj("gdt")) {
            return jk.u(com.bytedance.msdk.core.hf.getContext(), "tt_adapter_gdt_logo");
        }
        if (TextUtils.equals(gh(), "ks") && com.bytedance.msdk.core.xj.xj.kd.xj("ks")) {
            return jk.u(com.bytedance.msdk.core.hf.getContext(), "tt_adapter_ks_logo");
        }
        if (TextUtils.equals(gh(), "baidu") && com.bytedance.msdk.core.xj.xj.kd.xj("baidu")) {
            return jk.u(com.bytedance.msdk.core.hf.getContext(), "tt_adapter_baidu_logo");
        }
        if (((u) this).d == null) {
            return super.ho();
        }
        apply = ((u) this).d.apply(A2egSU.ARc23Z(8267, Bitmap.class));
        if (apply instanceof Bitmap) {
            return (Bitmap) apply;
        }
        return null;
    }

    @Override // com.bytedance.msdk.hf.w
    public String ir() {
        Object apply;
        if (((u) this).d == null) {
            return super.ir();
        }
        apply = ((u) this).d.apply(A2egSU.ARc23Z(8147, String.class));
        if (apply instanceof String) {
            return apply.toString();
        }
        return null;
    }

    @Override // com.bytedance.msdk.hf.w
    public boolean jk() {
        Object apply;
        try {
            if (((u) this).d != null) {
                apply = ((u) this).d.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(8135).xj(Boolean.class).hf());
                if (apply instanceof Boolean) {
                    return ((Boolean) apply).booleanValue();
                }
                return false;
            }
        } catch (Exception unused) {
        }
        return super.jk();
    }

    @Override // com.bytedance.msdk.hf.w
    public int lx() {
        Object apply;
        if (((u) this).d == null) {
            return super.lx();
        }
        apply = ((u) this).d.apply(A2egSU.ARc23Z(8161, Integer.class));
        if (apply instanceof Integer) {
            return ((Integer) apply).intValue();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.hf.w
    public void p() {
        super.p();
        if (((u) this).d != null) {
            ((u) this).d.apply(A2egSU.ARc23Z(6083, Void.class));
        }
    }

    @Override // com.bytedance.msdk.hf.w
    public View tf() {
        Object apply;
        if (((u) this).d == null) {
            return super.tf();
        }
        apply = ((u) this).d.apply(A2egSU.ARc23Z(6164, View.class));
        if (apply instanceof View) {
            return (View) apply;
        }
        return null;
    }

    @Override // com.bytedance.msdk.hf.w
    public int u() {
        Object apply;
        if (((u) this).d == null) {
            return super.u();
        }
        apply = ((u) this).d.apply(A2egSU.ARc23Z(8193, Integer.class));
        if (apply instanceof Integer) {
            return ((Integer) apply).intValue();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.hf.w
    public pl vh() {
        Object apply;
        if (((u) this).d != null) {
            apply = ((u) this).d.apply(A2egSU.ARc23Z(8269, Map.class));
            if (apply instanceof Map) {
                Map map = (Map) apply;
                Object obj = map.get("imgUrl");
                final Object obj2 = map.get(MediaFormat.KEY_WIDTH);
                final Object obj3 = map.get(MediaFormat.KEY_HEIGHT);
                final Object obj4 = map.get("valid");
                final Object obj5 = map.get(MediationConstant.EXTRA_DURATION);
                if (obj instanceof String) {
                    final String str = (String) obj;
                    if (!TextUtils.isEmpty(str)) {
                        return new pl() { // from class: com.bytedance.msdk.w.xj.c.1
                            @Override // com.bytedance.sdk.openadsdk.zg.w.hf.pl
                            public int hf() {
                                Object obj6 = obj2;
                                if (obj6 instanceof Integer) {
                                    return ((Integer) obj6).intValue();
                                }
                                return 0;
                            }

                            @Override // com.bytedance.sdk.openadsdk.zg.w.hf.pl
                            public boolean kd() {
                                Object obj6 = obj4;
                                return (obj6 instanceof Boolean) && ((Boolean) obj6).booleanValue();
                            }

                            @Override // com.bytedance.sdk.openadsdk.zg.w.hf.pl
                            public double u() {
                                Object obj6 = obj5;
                                if (obj6 instanceof Double) {
                                    return ((Double) obj6).doubleValue();
                                }
                                return 0.0d;
                            }

                            @Override // com.bytedance.sdk.openadsdk.zg.w.hf.pl
                            public String w() {
                                return str;
                            }

                            @Override // com.bytedance.sdk.openadsdk.zg.w.hf.pl
                            public int xj() {
                                Object obj6 = obj3;
                                if (obj6 instanceof Integer) {
                                    return ((Integer) obj6).intValue();
                                }
                                return 0;
                            }
                        };
                    }
                }
            }
        }
        return super.vh();
    }

    @Override // com.bytedance.msdk.hf.w
    public void w() {
        if (((u) this).d != null) {
            ((u) this).d.apply(A2egSU.ARc23Z(6093, Void.class));
        }
    }

    @Override // com.bytedance.msdk.w.xj.u
    public <T> T xj(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        com.bytedance.msdk.api.u.xj.w.xj xjVar;
        com.bytedance.msdk.api.u.xj.w.xj xjVar2;
        if (i == 8130) {
            if (ci() == 5) {
                if (tj() == 5) {
                    com.bytedance.msdk.api.u.xj.w.xj xjVar3 = this.y;
                    if (xjVar3 != null) {
                        xjVar3.xj(null);
                    }
                } else {
                    com.bytedance.msdk.api.u.xj.c.hf hfVar = this.xj;
                    if (hfVar != null) {
                        hfVar.xj(null);
                    }
                }
            } else if (ci() == 9 && (xjVar2 = this.y) != null) {
                xjVar2.xj(null);
            }
        } else if (i == 8113) {
            if (ci() == 5) {
                if (tj() == 5) {
                    com.bytedance.msdk.api.u.xj.w.xj xjVar4 = this.y;
                    if (xjVar4 != null) {
                        xjVar4.xj();
                    }
                } else {
                    com.bytedance.msdk.api.u.xj.c.hf hfVar2 = this.xj;
                    if (hfVar2 != null) {
                        hfVar2.xj();
                    }
                }
            } else if (ci() == 9 && (xjVar = this.y) != null) {
                xjVar.xj();
            }
        } else if (i == 8131) {
            if (this.f10166pl != null) {
                this.f10166pl.xj(this, pluginValueSet.stringValue(8036));
            }
        } else if (i == 8132) {
            com.bytedance.msdk.w.y.hf.xj xjVar5 = ((u) this).tf;
            if (xjVar5 != null) {
                com.bytedance.msdk.core.hf.xj.xj(xjVar5.hf());
            }
            if (this.p != null) {
                this.p.xj(pluginValueSet.intValue(8038), pluginValueSet.stringValue(8039), false);
            }
        } else if (i == 8133) {
            float floatValue = pluginValueSet.floatValue(8040);
            float floatValue2 = pluginValueSet.floatValue(8041);
            if (ci() == 5) {
                if (tj() == 5) {
                    com.bytedance.msdk.api.u.xj.w.xj xjVar6 = this.y;
                    if (xjVar6 instanceof com.bytedance.msdk.api.u.xj.w.u) {
                        ((com.bytedance.msdk.api.u.xj.w.u) xjVar6).xj(floatValue, floatValue2);
                    }
                } else {
                    com.bytedance.msdk.api.u.xj.c.hf hfVar3 = this.xj;
                    if (hfVar3 instanceof com.bytedance.msdk.api.u.xj.c.y) {
                        ((com.bytedance.msdk.api.u.xj.c.y) hfVar3).xj(floatValue, floatValue2);
                    }
                }
            } else if (ci() == 9) {
                com.bytedance.msdk.api.u.xj.w.xj xjVar7 = this.y;
                if (xjVar7 instanceof com.bytedance.msdk.api.u.xj.w.u) {
                    ((com.bytedance.msdk.api.u.xj.w.u) xjVar7).xj(floatValue, floatValue2);
                }
            }
        } else if (i == 8134) {
            int intValue = pluginValueSet.intValue(8014);
            String stringValue = pluginValueSet.stringValue(8015);
            View view = (View) pluginValueSet.objectValue(8042, View.class);
            if (ci() == 5) {
                if (tj() == 5) {
                    com.bytedance.msdk.api.u.xj.w.xj xjVar8 = this.y;
                    if (xjVar8 instanceof com.bytedance.msdk.api.u.xj.w.u) {
                        ((com.bytedance.msdk.api.u.xj.w.u) xjVar8).xj(view, stringValue, intValue);
                    }
                } else {
                    com.bytedance.msdk.api.u.xj.c.hf hfVar4 = this.xj;
                    if (hfVar4 instanceof com.bytedance.msdk.api.u.xj.c.y) {
                        ((com.bytedance.msdk.api.u.xj.c.y) hfVar4).xj(view, stringValue, intValue);
                    }
                }
            } else if (ci() == 9) {
                com.bytedance.msdk.api.u.xj.w.xj xjVar9 = this.y;
                if (xjVar9 instanceof com.bytedance.msdk.api.u.xj.w.u) {
                    ((com.bytedance.msdk.api.u.xj.w.u) xjVar9).xj(view, stringValue, intValue);
                }
            }
        } else if (i == 8140) {
            String stringValue2 = pluginValueSet.stringValue(8045);
            String stringValue3 = pluginValueSet.stringValue(8046);
            int intValue2 = pluginValueSet.intValue(8047);
            String stringValue4 = pluginValueSet.stringValue(8048);
            String stringValue5 = pluginValueSet.stringValue(8049);
            String stringValue6 = pluginValueSet.stringValue(8050);
            int intValue3 = pluginValueSet.intValue(8051);
            int intValue4 = pluginValueSet.intValue(8052);
            List<String> list = (List) pluginValueSet.objectValue(8053, List.class);
            String stringValue7 = pluginValueSet.stringValue(8054);
            boolean booleanValue = pluginValueSet.booleanValue(8055);
            String stringValue8 = pluginValueSet.stringValue(8056);
            String stringValue9 = pluginValueSet.stringValue(8057);
            Object objectValue = pluginValueSet.objectValue(8036, Object.class);
            String stringValue10 = pluginValueSet.stringValue(8058);
            double doubleValue = pluginValueSet.doubleValue(8016);
            boolean booleanValue2 = pluginValueSet.booleanValue(8033);
            int intValue5 = pluginValueSet.intValue(8060);
            String stringValue11 = pluginValueSet.stringValue(8061);
            String stringValue12 = pluginValueSet.stringValue(8061);
            long longValue = pluginValueSet.longValue(8078);
            String stringValue13 = pluginValueSet.stringValue(8079);
            Map<String, String> map = (Map) pluginValueSet.objectValue(8427, Map.class);
            String stringValue14 = pluginValueSet.stringValue(8080);
            String stringValue15 = pluginValueSet.stringValue(8081);
            double doubleValue2 = pluginValueSet.doubleValue(8082);
            int intValue6 = pluginValueSet.intValue(8059);
            String stringValue16 = pluginValueSet.stringValue(8551);
            String stringValue17 = pluginValueSet.stringValue(8559);
            int intValue7 = pluginValueSet.intValue(8553);
            j(stringValue2);
            en(stringValue3);
            jk(intValue2);
            x(stringValue4);
            l(stringValue5);
            ai(stringValue6);
            v(intValue3);
            yo(intValue4);
            xj(list);
            z(stringValue7);
            f(booleanValue);
            ht(stringValue8);
            ra(stringValue9);
            if (TextUtils.equals(lw(), "baidu")) {
                xj(MediationConstant.BAIDU_DISLIKE_INFO, objectValue);
            }
            am(stringValue10);
            xj(doubleValue);
            c(booleanValue2);
            p(intValue5);
            q(stringValue11);
            pz(stringValue12);
            hf(longValue);
            dk(stringValue13);
            kd(map);
            et(stringValue14);
            io(stringValue15);
            u(doubleValue2);
            pl(intValue6);
            pl(stringValue16);
            tf(stringValue17);
            hf(intValue7);
        } else {
            if (i == 8143) {
                return (T) Double.valueOf(da());
            }
            if (i == 8145) {
                com.bytedance.msdk.api.u.xj.c.f fVar = this.hf;
                if (fVar != null) {
                    fVar.hf();
                }
            } else if (i == 8146) {
                com.bytedance.msdk.api.u.xj.c.f fVar2 = this.hf;
                if (fVar2 != null) {
                    fVar2.w();
                }
            } else if (i == 8118) {
                com.bytedance.msdk.api.u.xj.c.f fVar3 = this.hf;
                if (fVar3 != null) {
                    fVar3.kd();
                }
            } else if (i == 8117) {
                int intValue8 = pluginValueSet.intValue(8014);
                String stringValue18 = pluginValueSet.stringValue(8015);
                com.bytedance.msdk.api.u.xj.c.f fVar4 = this.hf;
                if (fVar4 != null) {
                    fVar4.xj(new com.bytedance.msdk.api.xj(intValue8, stringValue18));
                }
            } else if (i == 8150) {
                com.bytedance.msdk.api.u.xj.c.f fVar5 = this.hf;
                if (fVar5 != null) {
                    fVar5.u();
                }
            } else if (i == 1025) {
                if (this.hf != null) {
                    this.hf.xj(pluginValueSet.longValue(8072), pluginValueSet.longValue(8073));
                }
            } else if (i == 8152) {
                com.bytedance.msdk.api.u.xj.hf hfVar5 = this.w;
                if (hfVar5 != null) {
                    hfVar5.xj();
                }
            } else if (i == 8153) {
                com.bytedance.msdk.api.u.xj.hf hfVar6 = this.w;
                if (hfVar6 != null) {
                    hfVar6.hf();
                }
            } else if (i == 8187) {
                if (this.w != null) {
                    this.w.xj(pluginValueSet.longValue(8062), pluginValueSet.longValue(8063), pluginValueSet.intValue(8064), pluginValueSet.intValue(8065), "", "");
                }
            } else if (i == 8155) {
                if (this.w != null) {
                    this.w.xj(pluginValueSet.longValue(8062), pluginValueSet.stringValue(8066), pluginValueSet.stringValue(8056));
                }
            } else if (i == 8156) {
                if (this.w != null) {
                    this.w.xj(pluginValueSet.stringValue(8066), pluginValueSet.stringValue(8056));
                }
            } else if (i == 8157) {
                if (this.w != null) {
                    this.w.hf(pluginValueSet.longValue(8062), pluginValueSet.longValue(8063), pluginValueSet.stringValue(8066), pluginValueSet.stringValue(8056));
                }
            } else if (i == 8158) {
                if (this.w != null) {
                    this.w.xj(pluginValueSet.longValue(8062), pluginValueSet.longValue(8063), pluginValueSet.stringValue(8066), pluginValueSet.stringValue(8056));
                }
            } else {
                if (i == 8160) {
                    return (T) Boolean.valueOf(a());
                }
                if (i == 6069) {
                    return (T) Integer.valueOf(ss());
                }
                if (i == 8185) {
                    com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj xjVar10 = this.p;
                    if (xjVar10 != null) {
                        xjVar10.xj();
                    }
                } else if (i == 8184) {
                    com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj xjVar11 = this.p;
                    if (xjVar11 != null) {
                        xjVar11.hf();
                    }
                } else {
                    if (i == 8196) {
                        return (T) Boolean.valueOf(gy());
                    }
                    if (i == 8197) {
                        com.bytedance.msdk.api.u.xj.u uVar = this.u;
                        if (uVar != null) {
                            uVar.xj();
                        }
                    } else if (i == 8227) {
                        if (pluginValueSet != null) {
                            u((Map<String, Object>) pluginValueSet.objectValue(8075, Map.class));
                        }
                    } else if (i == 6107 && this.kd != null) {
                        this.kd.xj(pluginValueSet.intValue(20055));
                    }
                }
            }
        }
        return (T) com.bytedance.msdk.core.zg.xj.xj(cls);
    }

    @Override // com.bytedance.msdk.hf.w
    public Integer y() {
        return com.bytedance.msdk.core.xj.xj.kd.xj(gh(), ((u) this).d);
    }

    @Override // com.bytedance.msdk.hf.w
    public void hf() {
        if (((u) this).d != null) {
            ((u) this).d.apply(A2egSU.ARc23Z(ProxyCacheUtils.DEFAULT_BUFFER_SIZE, Void.class));
        }
    }

    @Override // com.bytedance.msdk.hf.w
    public void xj(Activity activity, com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj xjVar) {
        this.p = xjVar;
        if (((u) this).d != null) {
            ((u) this).d.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(6085).xj(Void.class).xj(20033, activity).hf());
        }
    }

    @Override // com.bytedance.msdk.hf.w
    public void xj(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, tf tfVar, List<View> list4) {
        super.xj(activity, viewGroup, list, list2, list3, tfVar, list4);
        hf(activity, viewGroup, list, list2, list3, tfVar, list4);
    }

    @Override // com.bytedance.msdk.hf.w
    public void xj() {
        if (((u) this).d != null) {
            ((u) this).d.apply(A2egSU.ARc23Z(8191, Void.class));
        }
    }
}
