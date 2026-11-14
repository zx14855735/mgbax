package com.game.boy.activity;

import ADYaiT.DUi7mC;
import AaHO0E.CmUvjW;
import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Xml;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.game.boy.emu.gba.Console;
import com.game.boy.emu.gba.Link;
import com.google.android.material.appbar.MaterialToolbar;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class CheatsActivity extends A5SV6n {

    /* renamed from: B25kr6, reason: collision with root package name */
    public final DUi7mC f10953B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public ArrayAdapter f10954B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public boolean f10955B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public ListView f10956B4ZgIw;

    public CheatsActivity() {
        if (Link.f11099A5SV6n == null) {
            Link.f11099A5SV6n = new Link();
        }
        this.f10953B25kr6 = Link.f11099A5SV6n.f11100A2egSU.AMqCpz;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            KpHwm4.ASJ6gh aSJ6gh = new KpHwm4.ASJ6gh();
            aSJ6gh.f4290A4TApA = intent.getStringExtra("cheatName");
            aSJ6gh.f4291A5SV6n = intent.getStringExtra("cheatType");
            aSJ6gh.f4292ADYaiT = intent.getStringArrayExtra("cheatCode");
            DUi7mC dUi7mC = this.f10953B25kr6;
            if (i == 2) {
                KpHwm4.ASJ6gh aSJ6gh2 = (KpHwm4.ASJ6gh) ((ArrayList) dUi7mC.f240AmA8tU).get(intent.getIntExtra("cheatIndex", 0));
                aSJ6gh2.f4290A4TApA = aSJ6gh.f4290A4TApA;
                if (!aSJ6gh2.equals(aSJ6gh)) {
                    aSJ6gh2.f4291A5SV6n = aSJ6gh.f4291A5SV6n;
                    aSJ6gh2.f4292ADYaiT = aSJ6gh.f4292ADYaiT;
                    Iterator it = ((ArrayList) dUi7mC.f239AlLFFp).iterator();
                    while (it.hasNext()) {
                        dUi7mC.AaHO0E((Console) it.next());
                    }
                }
            } else {
                aSJ6gh.f4289A2egSU = true;
                ((ArrayList) dUi7mC.f240AmA8tU).add(aSJ6gh);
                Iterator it2 = ((ArrayList) dUi7mC.f239AlLFFp).iterator();
                int i3 = 0;
                while (it2.hasNext()) {
                    Console console = (Console) it2.next();
                    int i4 = 0;
                    int i5 = 0;
                    while (true) {
                        String[] strArr = aSJ6gh.f4292ADYaiT;
                        if (i4 < strArr.length) {
                            i5 |= console.addCheat(strArr[i4], aSJ6gh.f4291A5SV6n, aSJ6gh.f4289A2egSU);
                            i4++;
                        }
                    }
                    i3 |= i5;
                }
                if ((i3 & 1) != 0) {
                    OOnEhG.A4TApA a4TApA = new OOnEhG.A4TApA(this);
                    a4TApA.B2KMhB(R.string.dialog_alert_title);
                    a4TApA.AYUAbz();
                    a4TApA.AZOQYO(2131886179);
                    a4TApA.AmA8tU(R.string.ok, null);
                    a4TApA.AMqCpz();
                }
            }
            this.f10954B2KMhB.notifyDataSetChanged();
            this.f10955B3GDIM = true;
            if (i == 1) {
                this.f10956B4ZgIw.setItemChecked(this.f10954B2KMhB.getCount() - 1, true);
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity
    public final boolean onContextItemSelected(MenuItem menuItem) {
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) menuItem.getMenuInfo();
        int itemId = menuItem.getItemId();
        if (itemId == 2131296618) {
            KpHwm4.ASJ6gh aSJ6gh = (KpHwm4.ASJ6gh) this.f10954B2KMhB.getItem(adapterContextMenuInfo.position);
            startActivityForResult(new Intent(this, (Class<?>) EditCheatActivity.class).putExtra("cheatIndex", adapterContextMenuInfo.position).putExtra("cheatType", aSJ6gh.f4291A5SV6n).putExtra("cheatName", aSJ6gh.f4290A4TApA).putExtra("cheatCode", aSJ6gh.f4292ADYaiT), 2);
            return true;
        }
        if (itemId != 2131296568) {
            return super.onContextItemSelected(menuItem);
        }
        int i = adapterContextMenuInfo.position;
        DUi7mC dUi7mC = this.f10953B25kr6;
        ((ArrayList) dUi7mC.f240AmA8tU).remove(i);
        Iterator it = ((ArrayList) dUi7mC.f239AlLFFp).iterator();
        while (it.hasNext()) {
            dUi7mC.AaHO0E((Console) it.next());
        }
        this.f10954B2KMhB.notifyDataSetChanged();
        this.f10955B3GDIM = true;
        int count = this.f10954B2KMhB.getCount();
        for (int i2 = 0; i2 < count; i2++) {
            this.f10956B4ZgIw.setItemChecked(i2, ((KpHwm4.ASJ6gh) this.f10954B2KMhB.getItem(i2)).f4289A2egSU);
        }
        return true;
    }

    @Override // com.game.boy.activity.A5SV6n, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.AmA8tU, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131492917);
        MaterialToolbar materialToolbar = (MaterialToolbar) findViewById(2131298113);
        setSupportActionBar(materialToolbar);
        getSupportActionBar().AmA8tU();
        getSupportActionBar().AlLFFp(true);
        materialToolbar.setNavigationIcon(2131230963);
        materialToolbar.setNavigationOnClickListener(new ADYaiT.A5SV6n(17, this));
        ListView listView = (ListView) findViewById(R.id.list);
        this.f10956B4ZgIw = listView;
        listView.setEmptyView(findViewById(2131296624));
        this.f10956B4ZgIw.setOnCreateContextMenuListener(this);
        this.f10956B4ZgIw.setItemsCanFocus(false);
        this.f10956B4ZgIw.setChoiceMode(2);
        this.f10956B4ZgIw.setOnItemClickListener(new CmUvjW(4, this));
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.simple_list_item_multiple_choice, this.f10953B25kr6.AZOQYO());
        this.f10954B2KMhB = arrayAdapter;
        this.f10956B4ZgIw.setAdapter((ListAdapter) arrayAdapter);
        int count = this.f10954B2KMhB.getCount();
        for (int i = 0; i < count; i++) {
            this.f10956B4ZgIw.setItemChecked(i, ((KpHwm4.ASJ6gh) this.f10954B2KMhB.getItem(i)).f4289A2egSU);
        }
        if (bundle != null || PreferenceManager.getDefaultSharedPreferences(this).getBoolean("enableCheats", true)) {
            return;
        }
        OOnEhG.A4TApA a4TApA = new OOnEhG.A4TApA(this);
        a4TApA.B2KMhB(R.string.dialog_alert_title);
        a4TApA.AZOQYO(2131886178);
        a4TApA.AmA8tU(R.string.yes, new DRlcZ9.ASJ6gh(9, this));
        a4TApA.AaHO0E(R.string.no, null);
        a4TApA.AMqCpz();
    }

    @Override // android.app.Activity, android.view.View.OnCreateContextMenuListener
    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        getMenuInflater().inflate(2131623937, contextMenu);
    }

    @Override // android.app.Activity
    public final boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(2131623936, menu);
        return true;
    }

    public void onNewCheat(View view) {
        startActivityForResult(new Intent(this, (Class<?>) EditCheatActivity.class), 1);
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 2131297614) {
            return super.onOptionsItemSelected(menuItem);
        }
        onNewCheat(null);
        return true;
    }

    @Override // ADYaiT.B2KMhB, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        if (this.f10955B3GDIM) {
            DUi7mC dUi7mC = this.f10953B25kr6;
            File file = (File) dUi7mC.f241AzWtSf;
            ArrayList<KpHwm4.ASJ6gh> arrayList = (ArrayList) dUi7mC.f240AmA8tU;
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                if (arrayList.isEmpty()) {
                    file.delete();
                } else {
                    XmlSerializer newSerializer = Xml.newSerializer();
                    newSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
                    newSerializer.setOutput(bufferedOutputStream, "UTF-8");
                    newSerializer.startDocument(null, null);
                    newSerializer.startTag(null, "cheats");
                    for (KpHwm4.ASJ6gh aSJ6gh : arrayList) {
                        newSerializer.startTag(null, "cheat");
                        newSerializer.attribute(null, PointParamKey.TYPE, aSJ6gh.f4291A5SV6n);
                        String str = aSJ6gh.f4290A4TApA;
                        if (str != null && !str.isEmpty()) {
                            newSerializer.attribute(null, "name", aSJ6gh.f4290A4TApA);
                        }
                        if (!aSJ6gh.f4289A2egSU) {
                            newSerializer.attribute(null, "enabled", "false");
                        }
                        for (String str2 : aSJ6gh.f4292ADYaiT) {
                            newSerializer.startTag(null, PluginConstants.KEY_ERROR_CODE).text(str2).endTag(null, PluginConstants.KEY_ERROR_CODE);
                        }
                        newSerializer.endTag(null, "cheat");
                    }
                    newSerializer.endTag(null, "cheats");
                    newSerializer.endDocument();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.f10955B3GDIM = false;
        }
    }
}
