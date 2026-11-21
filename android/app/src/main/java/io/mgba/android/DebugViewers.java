/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package io.mgba.android;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.InputType;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Debug toolkit ported from 悠GBA模拟器: a live memory viewer with cheat
 * search (start → refine → edit) plus the GBA PPU viewers — background
 * layers, sprites (OAM) and palettes. Memory goes through the core bus, so
 * GB games work in the viewer too; the PPU viewers are GBA-only.
 */
final class DebugViewers {
    private DebugViewers() {
    }

    private static final int MAX_HITS = 20000;

    // GBA 硬件固定内存映射基址（不随 ROM 重建平移）。所有 bus 读取/写入
    // 一律走这些具名常量，禁止在读取点写裸地址。
    private static final int EWRAM_BASE = 0x02000000;
    private static final int IWRAM_BASE = 0x03000000;
    private static final int IO_BASE    = 0x04000000;
    private static final int PAL_BASE   = 0x05000000;
    private static final int VRAM_BASE  = 0x06000000;
    private static final int OAM_BASE   = 0x07000000;
    private static final int ROM_BASE   = 0x08000000;

    // IO 寄存器 / 显存子区基址
    private static final int IO_REG_BG0CNT  = IO_BASE + 0x08;
    private static final int IO_REG_BG0HOFS = IO_BASE + 0x10;
    private static final int IO_REG_BG0VOFS = IO_BASE + 0x12;
    private static final int PAL_OBJ_BASE  = PAL_BASE + 0x400;
    private static final int VRAM_OBJ_BASE = VRAM_BASE + 0x10000;

    // frameDump 的历史遗留地址（字面量少两个 0）。保持原值，不改变行为。
    private static final int LEGACY_DISPSTAT_ADDR = 0x040004;
    private static final int LEGACY_VCOUNT_ADDR   = 0x040006;

    // == Region tables =====================================================

    private static final class Region {
        final String name;
        final int address;
        final int size;

        Region(String name, int address, int size) {
            this.name = name;
            this.address = address;
            this.size = size;
        }
    }

    private static final Region[] GBA_REGIONS = {
            new Region("IWRAM", IWRAM_BASE, 0x8000),
            new Region("EWRAM", EWRAM_BASE, 0x40000),
            new Region("PAL", PAL_BASE, 0x400),
            new Region("VRAM", VRAM_BASE, 0x18000),
            new Region("OAM", OAM_BASE, 0x400),
            new Region("IO", IO_BASE, 0x400),
            new Region("ROM", ROM_BASE, 0x2000000),
    };

    private static final Region[] GB_REGIONS = {
            new Region("WRAM0", 0xC000, 0x1000),
            new Region("WRAMX", 0xD000, 0x1000),
            new Region("VRAM", 0x8000, 0x2000),
            new Region("OAM", 0xFE00, 0xA0),
            new Region("HRAM", 0xFF80, 0x7F),
    };

    private static Region[] regions(MgbaCore core) {
        return core != null && core.width() == 240 ? GBA_REGIONS : GB_REGIONS;
    }

    /** RAM regions the cheat search sweeps. */
    private static Region[] searchRegions(MgbaCore core) {
        Region[] all = regions(core);
        List<Region> out = new ArrayList<>();
        for (Region region : all) {
            String name = region.name;
            if (name.startsWith("IWRAM") || name.startsWith("EWRAM")
                    || name.startsWith("WRAM") || name.startsWith("HRAM")) {
                out.add(region);
            }
        }
        return out.toArray(new Region[0]);
    }

    // == Hub ===============================================================

    /** Entry dialog listing the tools; mirrors the APK's debug menu. */
    static void showHub(EmulatorActivity activity, MgbaCore core) {
        if (core == null || !core.isLoaded()) {
            Toast.makeText(activity, activity.getString(R.string.no_rom), Toast.LENGTH_SHORT).show();
            return;
        }
        boolean gba = core.width() == 240;
        String[] items = {
                activity.getString(R.string.memory_view),
                activity.getString(R.string.watch_view),
                activity.getString(R.string.bg_view),
                activity.getString(R.string.map_view),
                activity.getString(R.string.oam_view),
                activity.getString(R.string.palette_view),
                activity.getString(R.string.tile_view),
                activity.getString(R.string.io_view),
                activity.getString(R.string.frame_view),
        };
        new AlertDialog.Builder(activity)
                .setTitle(R.string.debug_tools)
                .setItems(items, (dialog, which) -> {
                    if (which == 0) {
                        showMemory(activity, core);
                    } else if (which == 1) {
                        showWatch(activity, core);
                    } else if (!gba) {
                        Toast.makeText(activity, activity.getString(R.string.debug_gba_only), Toast.LENGTH_SHORT).show();
                    } else if (which == 2) {
                        showBg(activity, core);
                    } else if (which == 3) {
                        showMap(activity, core);
                    } else if (which == 4) {
                        showOam(activity, core);
                    } else if (which == 5) {
                        showPalette(activity, core);
                    } else if (which == 6) {
                        showTiles(activity, core);
                    } else if (which == 7) {
                        showIo(activity, core);
                    } else {
                        showFrame(activity, core);
                    }
                })
                .show();
    }

    // == Memory viewer =====================================================

    /** One surviving candidate of the cheat search. */
    private static final class Hit {
        final int address;
        int last;

        Hit(int address, int last) {
            this.address = address;
            this.last = last;
        }
    }

    /** Search ops for the refine stage; the first pass is always ==. */
    private static final int OP_EQ = 0;
    private static final int OP_NEQ = 1;
    private static final int OP_LT = 2;
    private static final int OP_GT = 3;
    private static final int OP_CHANGED = 4;
    private static final int OP_UNCHANGED = 5;
    private static final int OP_INC = 6;
    private static final int OP_DEC = 7;
    private static final String[] OP_LABELS = {"=", "≠", "<", ">", "变了", "没变", "增大", "减小"};

    static void showMemory(EmulatorActivity activity, MgbaCore core) {
        Region[] allRegions = regions(core);
        ScrollView scroll = new ScrollView(activity);
        LinearLayout box = column(activity);
        scroll.addView(box);

        // -- hex dump (declared first: the region chips re-target it) --
        final MemoryHexView hexView = new MemoryHexView(activity, core);
        hexView.setRegion(allRegions[1]);

        // -- region chip row --
        final Region[] current = {allRegions[1]};
        LinearLayout chips = row(activity);
        final TextView[] chipViews = new TextView[allRegions.length];
        for (int i = 0; i < allRegions.length; i++) {
            final Region region = allRegions[i];
            TextView chip = chip(activity, region.name);
            chip.setOnClickListener(v -> {
                current[0] = region;
                for (TextView other : chipViews) {
                    other.setTextColor(0xFF9CCC9C);
                }
                chip.setTextColor(0xFFFFF176);
                hexView.setRegion(region);
            });
            chips.addView(chip);
            chipViews[i] = chip;
        }
        chipViews[1].setTextColor(0xFFFFF176);

        // -- search panel --
        LinearLayout searchBox = column(activity);
        searchBox.setBackgroundColor(0xFF12281A);
        final int[] width = {16};
        final int[] op = {OP_EQ};
        LinearLayout widthRow = row(activity);
        widthRow.addView(label(activity, R.string.search_width));
        final TextView[] widthChips = new TextView[3];
        for (int i = 0; i < 3; i++) {
            final int w = 8 << i;
            TextView chip = chip(activity, String.valueOf(w));
            chip.setOnClickListener(v -> {
                width[0] = w;
                for (TextView other : widthChips) {
                    other.setTextColor(0xFF9CCC9C);
                }
                chip.setTextColor(0xFFFFF176);
            });
            widthRow.addView(chip);
            widthChips[i] = chip;
        }
        widthChips[1].setTextColor(0xFFFFF176);

        EditText valueInput = input(activity);
        valueInput.setHint(activity.getString(R.string.search_value_hint));
        LinearLayout opRow = row(activity);
        final TextView[] opChips = new TextView[OP_LABELS.length];
        for (int i = 0; i < OP_LABELS.length; i++) {
            final int o = i;
            TextView chip = chip(activity, OP_LABELS[i]);
            chip.setOnClickListener(v -> {
                op[0] = o;
                for (TextView other : opChips) {
                    other.setTextColor(0xFF9CCC9C);
                }
                chip.setTextColor(0xFFFFF176);
            });
            opRow.addView(chip);
            opChips[i] = chip;
        }
        opChips[0].setTextColor(0xFFFFF176);

        LinearLayout hitRow = row(activity);
        TextView hitLabel = label(activity, R.string.search_hits);
        hitLabel.setTextColor(0xFFFFF176);
        Button resetHit = smallButton(activity, R.string.search_reset);
        hitRow.addView(hitLabel, rowWeight());
        hitRow.addView(resetHit);
        LinearLayout resultList = column(activity);
        ScrollView resultScroll = new ScrollView(activity);
        resultScroll.addView(resultList);

        final List<Hit> hits = new ArrayList<>();
        View[] refresh = new View[1];

        // Applies one op to the current hit list. First pass builds the list
        // from an exact match; later passes compare against each hit's last
        // value and refresh it.
        Runnable[] doSearch = new Runnable[1];
        doSearch[0] = () -> {
            long parsed = parseNumber(valueInput.getText().toString());
            boolean needsValue = op[0] == OP_EQ || op[0] == OP_NEQ || op[0] == OP_LT || op[0] == OP_GT;
            if (needsValue && parsed == Long.MIN_VALUE) {
                Toast.makeText(activity, activity.getString(R.string.input_data_invalid), Toast.LENGTH_SHORT).show();
                return;
            }
            Region[] regions = searchRegions(core);
            int mask = width[0] == 8 ? 0xFF : width[0] == 16 ? 0xFFFF : -1;
            long value = parsed & mask;
            List<Hit> next = new ArrayList<>();
            byte[][] blocks = new byte[regions.length][];
            for (int r = 0; r < regions.length; r++) {
                blocks[r] = core.busReadBlock(regions[r].address, regions[r].size);
            }
            if (hits.isEmpty()) {
                if (op[0] != OP_EQ) {
                    Toast.makeText(activity, activity.getString(R.string.search_first_eq), Toast.LENGTH_SHORT).show();
                    return;
                }
                for (int r = 0; r < regions.length && next.size() < MAX_HITS; r++) {
                    Region region = regions[r];
                    byte[] data = blocks[r];
                    for (int off = 0; off + (width[0] >> 3) <= data.length && next.size() < MAX_HITS; off++) {
                        int v = readWidth(data, off, width[0]);
                        if (v == value) {
                            next.add(new Hit(region.address + off, v));
                        }
                    }
                }
            } else {
                for (Hit hit : hits) {
                    int v = -1;
                    for (int r = 0; r < regions.length; r++) {
                        if (hit.address >= regions[r].address
                                && hit.address + (width[0] >> 3) <= regions[r].address + regions[r].size) {
                            v = readWidth(blocks[r], hit.address - regions[r].address, width[0]);
                            break;
                        }
                    }
                    if (v < 0) {
                        continue;
                    }
                    int prev = hit.last & mask;
                    int cur = v & mask;
                    boolean keep;
                    switch (op[0]) {
                        case OP_EQ: keep = cur == value; break;
                        case OP_NEQ: keep = cur != value; break;
                        case OP_LT: keep = cur < value; break;
                        case OP_GT: keep = cur > value; break;
                        case OP_CHANGED: keep = cur != prev; break;
                        case OP_UNCHANGED: keep = cur == prev; break;
                        case OP_INC: keep = cur > prev; break;
                        default: keep = cur < prev; break;
                    }
                    if (keep) {
                        hit.last = cur;
                        next.add(hit);
                    }
                }
            }
            hits.clear();
            hits.addAll(next);
            resultList.removeAllViews();
            hitLabel.setText(activity.getString(R.string.search_hits_n, hits.size()));
            int shown = Math.min(hits.size(), 400);
            for (int i = 0; i < shown; i++) {
                Hit hit = hits.get(i);
                TextView entry = chip(activity, String.format(Locale.US, "%08X = %d (0x%X)",
                        hit.address, hit.last, hit.last));
                entry.setGravity(Gravity.START | Gravity.CENTER_VERTICAL);
                entry.setOnClickListener(v -> editValue(activity, core, hit.address, width[0]));
                resultList.addView(entry);
            }
            if (hits.size() > shown) {
                resultList.addView(label(activity, R.string.search_more));
            }
            Toast.makeText(activity, activity.getString(R.string.search_hits_n, hits.size()), Toast.LENGTH_SHORT).show();
        };
        resetHit.setOnClickListener(v -> {
            hits.clear();
            resultList.removeAllViews();
            hitLabel.setText(activity.getString(R.string.search_hits));
        });

        Button searchButton = smallButton(activity, R.string.search);
        searchButton.setOnClickListener(v -> doSearch[0].run());
        refresh[0] = hexView;

        box.addView(chips);
        box.addView(hexView);
        box.addView(label(activity, R.string.memory_tap_edit));
        box.addView(searchBox);
        searchBox.addView(widthRow);
        searchBox.addView(valueInput);
        searchBox.addView(opRow);
        searchBox.addView(searchButton);
        searchBox.addView(hitRow);
        searchBox.addView(resultScroll, new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, dp(activity, 200)));

        new AlertDialog.Builder(activity)
                .setTitle(R.string.memory_view)
                .setView(scroll)
                .setPositiveButton(R.string.close, null)
                .show();
    }

    private static int readWidth(byte[] data, int off, int width) {
        if (width == 8) {
            return data[off] & 0xFF;
        }
        if (width == 16) {
            return (data[off] & 0xFF) | ((data[off + 1] & 0xFF) << 8);
        }
        return (data[off] & 0xFF) | ((data[off + 1] & 0xFF) << 8)
                | ((data[off + 2] & 0xFF) << 16) | ((data[off + 3] & 0xFF) << 24);
    }

    /** Parses "123" or "0x1F" hex input; MIN_VALUE when invalid. */
    private static long parseNumber(String text) {
        try {
            String trim = text.trim();
            if (trim.isEmpty()) {
                return Long.MIN_VALUE;
            }
            if (trim.startsWith("0x") || trim.startsWith("0X")) {
                return Long.parseLong(trim.substring(2), 16);
            }
            return Long.parseLong(trim);
        } catch (NumberFormatException e) {
            return Long.MIN_VALUE;
        }
    }

    /** Edits one value at address with the chosen width; accepts dec or 0x hex. */
    private static void editValue(EmulatorActivity activity, MgbaCore core, int address, int width) {
        EditText input = input(activity);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        input.setHint(activity.getString(R.string.edit_value_hint, width));
        new AlertDialog.Builder(activity)
                .setTitle(activity.getString(R.string.edit_value_title, address))
                .setView(input)
                .setPositiveButton(R.string.save, (d, w) -> {
                    long parsed = parseNumber(input.getText().toString());
                    if (parsed == Long.MIN_VALUE) {
                        Toast.makeText(activity, activity.getString(R.string.input_data_invalid), Toast.LENGTH_SHORT).show();
                        return;
                    }
                    int mask = width == 8 ? 0xFF : width == 16 ? 0xFFFF : 0xFFFFFFFF;
                    core.busWrite(width, address, (int) (parsed & mask));
                    Toast.makeText(activity, activity.getString(R.string.memory_written), Toast.LENGTH_SHORT).show();
                })
                .setNegativeButton(android.R.string.cancel, null)
                .show();
    }

    /** Scrolling hex+ASCII dump of one region; tap a byte to edit it. */
    private static final class MemoryHexView extends View {
        private static final int BYTES_PER_ROW = 16;
        private final Paint text = new Paint(Paint.ANTI_ALIAS_FLAG);
        private final MgbaCore core;
        private Region region;
        private byte[] data = new byte[0];
        private float rowH;
        private float addrW;
        private float byteW;

        MemoryHexView(Context context, MgbaCore core) {
            super(context);
            this.core = core;
            text.setTypeface(Typeface.MONOSPACE);
            text.setTextSize(dp(context, 11));
            text.setColor(0xFFD6E8D6);
            rowH = dp(context, 15);
            addrW = dp(context, 72);
            byteW = dp(context, 19);
        }

        void setRegion(Region region) {
            this.region = region;
            refresh();
        }

        void refresh() {
            if (region == null || core == null) {
                return;
            }
            int bytes = Math.min(region.size, 0x10000);
            data = core.busReadBlock(region.address, bytes);
            int rows = Math.max(1, (int) Math.ceil(data.length / (float) BYTES_PER_ROW));
            setMinimumHeight((int) (rows * rowH));
            requestLayout();
            invalidate();
        }

        @Override
        protected void onMeasure(int widthSpec, int heightSpec) {
            int rows = Math.max(1, (int) Math.ceil(data.length / (float) BYTES_PER_ROW));
            setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), widthSpec),
                    (int) (rows * rowH) + dp(getContext(), 8));
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawColor(0xFF0A140A);
            float left = dp(getContext(), 6);
            for (int row = 0; row * BYTES_PER_ROW < data.length; row++) {
                float y = row * rowH + rowH - dp(getContext(), 3);
                int base = row * BYTES_PER_ROW;
                canvas.drawText(String.format(Locale.US, "%08X", region.address + base), left, y, text);
                StringBuilder ascii = new StringBuilder();
                for (int col = 0; col < BYTES_PER_ROW && base + col < data.length; col++) {
                    int b = data[base + col] & 0xFF;
                    canvas.drawText(String.format(Locale.US, "%02X", b),
                            left + addrW + col * byteW, y, text);
                    ascii.append(b >= 0x20 && b < 0x7F ? (char) b : '.');
                }
                canvas.drawText(ascii.toString(), left + addrW + BYTES_PER_ROW * byteW + dp(getContext(), 8), y, text);
            }
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            if (event.getActionMasked() == MotionEvent.ACTION_UP && region != null && data.length > 0) {
                int row = (int) (event.getY() / rowH);
                int col = (int) ((event.getX() - dp(getContext(), 6) - addrW) / byteW);
                if (row >= 0 && col >= 0 && col < BYTES_PER_ROW && row * BYTES_PER_ROW + col < data.length) {
                    Context context = getContext();
                    if (context instanceof EmulatorActivity) {
                        editValue((EmulatorActivity) context, core,
                                region.address + row * BYTES_PER_ROW + col, 8);
                    }
                    return true;
                }
            }
            return super.onTouchEvent(event);
        }
    }

    // == BG layer viewer ===================================================

    static void showBg(EmulatorActivity activity, MgbaCore core) {
        int dispcnt = core.busRead(16, IO_BASE);
        int mode = dispcnt & 7;
        LinearLayout box = column(activity);
        LinearLayout tabs = row(activity);
        final ImageView2[] holder = new ImageView2[1];
        final TextView info = label(activity, 0);
        info.setTextColor(0xFFD6E8D6);

        boolean[] exists = new boolean[4];
        if (mode == 0) {
            // Mode 0: four text layers.
            exists[0] = exists[1] = exists[2] = exists[3] = true;
        } else if (mode == 1) {
            exists[0] = exists[1] = true;
            exists[2] = true;
        } else if (mode == 2) {
            exists[2] = true;
        }

        for (int bg = 0; bg < 4; bg++) {
            final int bgIndex = bg;
            Button button = smallButton(activity, 0);
            button.setText("BG" + bg);
            button.setEnabled(exists[bg]);
            button.setOnClickListener(v -> {
                Bitmap bitmap = renderBg(core, bgIndex, info, activity);
                if (bitmap != null && holder[0] != null) {
                    holder[0].set(bitmap);
                }
            });
            tabs.addView(button);
        }
        Button export = smallButton(activity, R.string.export);
        export.setOnClickListener(v -> {
            if (holder[0] != null && holder[0].bitmap != null) {
                exportImage(activity, holder[0].bitmap, "bg");
            }
        });
        tabs.addView(export);

        HorizontalScrollView hScroll = new HorizontalScrollView(activity);
        ScrollView vScroll = new ScrollView(activity);
        ImageView2 image = new ImageView2(activity);
        holder[0] = image;
        vScroll.addView(box);
        box.addView(tabs);
        box.addView(info);
        hScroll.addView(image);
        box.addView(hScroll, new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, dp(activity, 260)));
        // Paint the first enabled layer immediately.
        for (int bg = 0; bg < 4; bg++) {
            if (exists[bg]) {
                Bitmap bitmap = renderBg(core, bg, info, activity);
                if (bitmap != null) {
                    image.set(bitmap);
                }
                break;
            }
        }
        new AlertDialog.Builder(activity)
                .setTitle(activity.getString(R.string.bg_view) + " (mode " + mode + ")")
                .setView(vScroll)
                .setPositiveButton(R.string.close, null)
                .show();
    }

    /**
     * Renders one background layer from VRAM: text layers from their tilemap,
     * affine layers from the byte map, and the bitmap modes directly.
     */
    private static Bitmap renderBg(MgbaCore core, int bg, TextView info, EmulatorActivity activity) {
        int dispcnt = core.busRead(16, IO_BASE);
        int mode = dispcnt & 7;
        int cnt = core.busRead(16, IO_REG_BG0CNT + bg * 2);
        Bitmap bitmap = null;
        try {
            if (mode == 3) {
                bitmap = bitmapMode(core, VRAM_BASE, 240, 160, 16);
                info.setText(activity.getString(R.string.bg_info_mode3));
                return bitmap;
            }
            if (mode == 4) {
                int frame = (dispcnt & 0x10) != 0 ? 0xA000 : 0;
                bitmap = bitmapMode(core, VRAM_BASE + frame, 240, 160, 8);
                info.setText(activity.getString(R.string.bg_info_mode4));
                return bitmap;
            }
            if (mode == 5) {
                bitmap = bitmapMode(core, VRAM_BASE, 160, 128, 16);
                info.setText(activity.getString(R.string.bg_info_mode5));
                return bitmap;
            }
            boolean affine = bg >= 2 && (mode == 2 || (mode == 1 && bg == 2));
            int priority = cnt & 3;
            int charBase = ((cnt >> 2) & (affine ? 7 : 3)) * (affine ? 0x8000 : 0x4000);
            boolean pal256 = !affine && (cnt & 0x80) != 0;
            int screenBase = ((cnt >> 8) & 31) * 0x800;
            int size = (cnt >> 14) & 3;
            int mapBase = VRAM_BASE + screenBase;
            int tilesBase = VRAM_BASE + charBase;
            int wTiles;
            int hTiles;
            if (affine) {
                wTiles = 16 << size;
                hTiles = wTiles;
            } else {
                wTiles = (size & 1) != 0 ? 64 : 32;
                hTiles = (size & 2) != 0 ? 64 : 32;
            }
            int pixelW = wTiles * 8;
            int pixelH = hTiles * 8;
            if (pixelW > 1024 || pixelH > 1024) {
                return null;
            }
            int bpp = affine || pal256 ? 8 : 4;
            bitmap = Bitmap.createBitmap(pixelW, pixelH, Bitmap.Config.ARGB_8888);
            int[] pixels = new int[pixelW * pixelH];
            byte[] map = core.busReadBlock(mapBase, affine ? wTiles * hTiles : wTiles * hTiles * 2);
            for (int ty = 0; ty < hTiles; ty++) {
                for (int tx = 0; tx < wTiles; tx++) {
                    int tile;
                    int palette = 0;
                    boolean hflip = false;
                    boolean vflip = false;
                    if (affine) {
                        tile = map[ty * wTiles + tx] & 0xFF;
                    } else {
                        int entry = map[(ty * wTiles + tx) * 2] & 0xFF
                                | (map[(ty * wTiles + tx) * 2 + 1] & 0xFF) << 8;
                        tile = entry & 0x3FF;
                        hflip = (entry & 0x400) != 0;
                        vflip = (entry & 0x800) != 0;
                        palette = (entry >> 12) & 15;
                    }
                    drawTile(core, pixels, pixelW, tilesBase + tile * (bpp == 4 ? 32 : 64),
                            tx * 8, ty * 8, bpp, palette, hflip, vflip);
                }
            }
            bitmap.setPixels(pixels, 0, pixelW, 0, 0, pixelW, pixelH);
            info.setText(activity.getString(R.string.bg_info,
                    pixelW + "x" + pixelH, priority, charBase, screenBase));
            return bitmap;
        } catch (Exception e) {
            if (bitmap != null) {
                bitmap.recycle();
            }
            return null;
        }
    }

    private static Bitmap bitmapMode(MgbaCore core, int base, int w, int h, int bpp) {
        Bitmap bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        int[] pixels = new int[w * h];
        byte[] data = core.busReadBlock(base, w * h * (bpp == 8 ? 1 : 2));
        for (int i = 0; i < w * h && (i * (bpp == 8 ? 1 : 2) + (bpp == 8 ? 1 : 2)) <= data.length; i++) {
            int rgb;
            if (bpp == 8) {
                rgb = paletteColor(core, data[i] & 0xFF);
            } else {
                rgb = bgr15(data[i * 2] & 0xFF | (data[i * 2 + 1] & 0xFF) << 8);
            }
            pixels[i] = rgb == 0 ? 0xFF000000 : rgb;
        }
        bitmap.setPixels(pixels, 0, w, 0, 0, w, h);
        return bitmap;
    }

    /** Blits one 8x8 tile from VRAM into the pixel buffer, honoring flips. */
    private static void drawTile(MgbaCore core, int[] out, int outW, int vramAddr,
                                 int dstX, int dstY, int bpp, int palette, boolean hflip, boolean vflip) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                int sx = hflip ? 7 - col : col;
                int sy = vflip ? 7 - row : row;
                int color;
                if (bpp == 4) {
                    int addr = vramAddr + sy * 4 + (sx >> 1);
                    int b = core.busRead(8, addr);
                    int index = (sx & 1) != 0 ? (b >> 4) : (b & 0xF);
                    color = index == 0 ? 0 : paletteColor(core, palette * 16 + index);
                } else {
                    int index = core.busRead(8, vramAddr + sy * 8 + sx);
                    color = index == 0 ? 0 : paletteColor(core, index);
                }
                int px = dstX + col;
                int py = dstY + row;
                if (px < outW && py * outW + px < out.length) {
                    out[py * outW + px] = color == 0 ? 0xFF101010 : color;
                }
            }
        }
    }

    private static int paletteColor(MgbaCore core, int index) {
        return bgr15(core.busRead(16, PAL_BASE + index * 2));
    }

    private static int bgr15(int value) {
        int r = (value & 31) << 3;
        int g = ((value >> 5) & 31) << 3;
        int b = ((value >> 10) & 31) << 3;
        return 0xFF000000 | (r | (r >> 5)) << 16 | (g | (g >> 5)) << 8 | (b | (b >> 5));
    }

    // == OAM viewer ========================================================

    static void showOam(EmulatorActivity activity, MgbaCore core) {
        ScrollView scroll = new ScrollView(activity);
        LinearLayout box = column(activity);
        LinearLayout grid = new LinearLayout(activity);
        grid.setOrientation(LinearLayout.VERTICAL);
        byte[] oam = core.busReadBlock(OAM_BASE, 0x400);
        int shown = 0;
        LinearLayout rowLayout = null;
        for (int i = 0; i < 128; i++) {
            int attr0 = oam[i * 8] & 0xFF | (oam[i * 8 + 1] & 0xFF) << 8;
            int attr1 = oam[i * 8 + 2] & 0xFF | (oam[i * 8 + 3] & 0xFF) << 8;
            int attr2 = oam[i * 8 + 4] & 0xFF | (oam[i * 8 + 5] & 0xFF) << 8;
            if (((attr0 >> 10) & 3) == 2) {
                continue; // hidden sprite
            }
            if (shown % 8 == 0) {
                rowLayout = row(activity);
                grid.addView(rowLayout);
            }
            shown++;
            Bitmap thumb = renderSprite(core, attr0, attr1, attr2, i);
            ImageView2 image = new ImageView2(activity);
            image.set(thumb);
            final int index = i;
            final int f0 = attr0;
            final int f1 = attr1;
            final int f2 = attr2;
            image.setOnClickListener(v -> spriteInfo(activity, core, index, f0, f1, f2));
            rowLayout.addView(image);
        }
        if (shown == 0) {
            box.addView(label(activity, R.string.oam_empty));
        }
        Button export = smallButton(activity, R.string.export);
        export.setOnClickListener(v -> {
            Bitmap sheet = oamSheet(core);
            if (sheet != null) {
                exportImage(activity, sheet, "oam");
            }
        });
        box.addView(export);
        box.addView(grid);
        scroll.addView(box);
        new AlertDialog.Builder(activity)
                .setTitle(activity.getString(R.string.oam_view) + " (" + shown + ")")
                .setView(scroll)
                .setPositiveButton(R.string.close, null)
                .show();
    }

    private static int[] spriteDims(int attr0, int attr1) {
        int shape = (attr0 >> 14) & 3;
        int size = (attr1 >> 14) & 3;
        int[] square = {8, 16, 32, 64};
        int[] wideW = {16, 32, 32, 64};
        int[] wideH = {8, 8, 16, 32};
        if (shape == 0) {
            return new int[]{square[size], square[size]};
        }
        if (shape == 1) {
            return new int[]{wideW[size], wideH[size]};
        }
        return new int[]{wideH[size], wideW[size]};
    }

    /** Renders one sprite from VRAM/OAM into a bitmap (transparent where empty). */
    private static Bitmap renderSprite(MgbaCore core, int attr0, int attr1, int attr2, int index) {
        int[] dims = spriteDims(attr0, attr1);
        int w = dims[0];
        int h = dims[1];
        boolean pal256 = (attr0 & 0x2000) != 0;
        boolean hflip = (attr1 & 0x1000) != 0;
        boolean vflip = (attr1 & 0x2000) != 0;
        int tile = attr2 & 0x3FF;
        int palette = (attr2 >> 12) & 15;
        Bitmap bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        int[] pixels = new int[w * h];
        int tilesPerRow = Math.max(1, w / 8);
        for (int py = 0; py < h; py++) {
            for (int px = 0; px < w; px++) {
                int sx = hflip ? w - 1 - px : px;
                int sy = vflip ? h - 1 - py : py;
                int tileCol = sx / 8;
                int tileRow = sy / 8;
                int tileIndex = tile;
                if (pal256) {
                    tileIndex += tileRow * tilesPerRow + tileCol;
                } else {
                    tileIndex += tileRow * 32 + tileCol;
                }
                int color;
                if (pal256) {
                    int b = core.busRead(8, VRAM_OBJ_BASE + tileIndex * 64 + (sy % 8) * 8 + sx % 8);
                    color = b == 0 ? 0 : paletteColor(core, b);
                } else {
                    int addr = VRAM_OBJ_BASE + tileIndex * 32 + (sy % 8) * 4 + ((sx % 8) >> 1);
                    int b = core.busRead(8, addr);
                    int nib = (sx & 1) != 0 ? (b >> 4) : (b & 0xF);
                    color = nib == 0 ? 0 : paletteColor(core, palette * 16 + nib);
                }
                pixels[py * w + px] = color == 0 ? 0x00000000 : color;
            }
        }
        bitmap.setPixels(pixels, 0, w, 0, 0, w, h);
        return bitmap;
    }

    private static void spriteInfo(EmulatorActivity activity, MgbaCore core, int index,
                                   int attr0, int attr1, int attr2) {
        int[] dims = spriteDims(attr0, attr1);
        String message = activity.getString(R.string.oam_info,
                index, attr0 & 0xFF, attr1 & 0x1FF, dims[0] + "x" + dims[1],
                attr2 & 0x3FF, (attr2 >> 12) & 15,
                ((attr1 & 0x1000) != 0 ? "H" : "") + ((attr1 & 0x2000) != 0 ? "V" : ""),
                (attr2 >> 10) & 3);
        new AlertDialog.Builder(activity)
                .setTitle(activity.getString(R.string.oam_n, index))
                .setMessage(message)
                .setPositiveButton(R.string.close, null)
                .show();
    }

    /** Contact sheet of all visible sprites for export. */
    private static Bitmap oamSheet(MgbaCore core) {
        byte[] oam = core.busReadBlock(OAM_BASE, 0x400);
        int cell = 64;
        Bitmap sheet = Bitmap.createBitmap(cell * 8, cell * 16, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(sheet);
        canvas.drawColor(0xFF303030);
        Paint paint = new Paint();
        for (int i = 0; i < 128; i++) {
            int attr0 = oam[i * 8] & 0xFF | (oam[i * 8 + 1] & 0xFF) << 8;
            int attr1 = oam[i * 8 + 2] & 0xFF | (oam[i * 8 + 3] & 0xFF) << 8;
            int attr2 = oam[i * 8 + 4] & 0xFF | (oam[i * 8 + 5] & 0xFF) << 8;
            if (((attr0 >> 10) & 3) == 2) {
                continue;
            }
            Bitmap sprite = renderSprite(core, attr0, attr1, attr2, i);
            float x = (i % 8) * cell + (cell - sprite.getWidth()) / 2f;
            float y = (i / 8) * cell + (cell - sprite.getHeight()) / 2f;
            canvas.drawBitmap(sprite, x, y, paint);
            sprite.recycle();
        }
        return sheet;
    }

    // == Palette viewer ====================================================

    static void showPalette(EmulatorActivity activity, MgbaCore core) {
        ScrollView scroll = new ScrollView(activity);
        LinearLayout box = column(activity);
        LinearLayout grid = rowGrid(activity, core, PAL_BASE, activity.getString(R.string.bg_palette));
        LinearLayout grid2 = rowGrid(activity, core, PAL_OBJ_BASE, activity.getString(R.string.obj_palette));
        Button export = smallButton(activity, R.string.export);
        export.setOnClickListener(v -> exportImage(activity, paletteSheet(core), "palette"));
        box.addView(label(activity, R.string.bg_palette));
        box.addView(grid);
        box.addView(label(activity, R.string.obj_palette));
        box.addView(grid2);
        box.addView(export);
        scroll.addView(box);
        new AlertDialog.Builder(activity)
                .setTitle(R.string.palette_view)
                .setView(scroll)
                .setPositiveButton(R.string.close, null)
                .show();
    }

    /** 16x16 swatch grid of one 256-entry palette bank. */
    private static LinearLayout rowGrid(EmulatorActivity activity, MgbaCore core, int base, String title) {
        LinearLayout grid = new LinearLayout(activity);
        grid.setOrientation(LinearLayout.VERTICAL);
        byte[] data = core.busReadBlock(base, 512);
        for (int row = 0; row < 16; row++) {
            LinearLayout line = row(activity);
            for (int col = 0; col < 16; col++) {
                final int index = row * 16 + col;
                int value = data[index * 2] & 0xFF | (data[index * 2 + 1] & 0xFF) << 8;
                TextView swatch = new TextView(activity);
                swatch.setBackgroundColor(value == 0 ? 0xFF000000 : bgr15(value));
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(dp(activity, 22), dp(activity, 22));
                params.setMargins(1, 1, 1, 1);
                swatch.setLayoutParams(params);
                swatch.setGravity(Gravity.CENTER);
                swatch.setTextSize(8);
                swatch.setTextColor(0xFFAAAAAA);
                swatch.setText(String.valueOf(index));
                swatch.setOnClickListener(v -> {
                    int rgb = bgr15(value);
                    new AlertDialog.Builder(activity)
                            .setTitle(title + " #" + index)
                            .setMessage(activity.getString(R.string.palette_info, index,
                                    (rgb >> 16) & 0xFF, (rgb >> 8) & 0xFF, rgb & 0xFF,
                                    String.format(Locale.US, "0x%08X", base + index * 2)))
                            .setPositiveButton(R.string.close, null)
                            .show();
                });
                line.addView(swatch);
            }
            grid.addView(line);
        }
        return grid;
    }

    private static Bitmap paletteSheet(MgbaCore core) {
        Bitmap sheet = Bitmap.createBitmap(16 * 24, 32 * 24 + 16, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(sheet);
        canvas.drawColor(0xFF202020);
        Paint paint = new Paint();
        byte[] data = core.busReadBlock(PAL_BASE, 512);
        for (int bank = 0; bank < 2; bank++) {
            for (int i = 0; i < 256; i++) {
                int value = data[(bank * 256 + i) * 2] & 0xFF | (data[(bank * 256 + i) * 2 + 1] & 0xFF) << 8;
                paint.setColor(value == 0 ? 0xFF000000 : bgr15(value));
                int x = (i % 16) * 24;
                int y = bank * (16 * 24 + 16) + (i / 16) * 24;
                canvas.drawRect(x + 1, y + 1, x + 23, y + 23, paint);
            }
        }
        return sheet;
    }

    // == Memory watch (stand-in for PC's memory access log) =================

    private static final int WATCH_MAX_ROWS = 200;
    private static final int WATCH_INTERVAL_MS = 500;

    /**
     * Polls one RAM region twice a second and lists the bytes that changed
     * since the previous poll. PC's memory-access log taps the core; this
     * needs no core change and answers the same practical question ("who keeps
     * writing here") for cheats and save-type hunting.
     */
    static void showWatch(EmulatorActivity activity, MgbaCore core) {
        LinearLayout box = column(activity);
        final Region[] current = {searchRegions(core)[0]};
        final TextView out = new TextView(activity);
        out.setTypeface(Typeface.MONOSPACE);
        out.setTextSize(12);
        out.setTextColor(0xFFD6E8D6);
        out.setTextIsSelectable(true);
        out.setText(activity.getString(R.string.watch_hint));
        final Button toggle = smallButton(activity, R.string.watch_start);
        LinearLayout chips = row(activity);
        final Button[] chipViews = new Button[searchRegions(core).length];
        final Handler handler = new Handler(Looper.getMainLooper());
        final boolean[] running = {false};
        final byte[][] baseline = new byte[1][];
        final Runnable[] tick = new Runnable[1];
        Region[] regions = searchRegions(core);
        for (int i = 0; i < regions.length; i++) {
            final Region region = regions[i];
            final int index = i;
            Button chip = smallButton(activity, 0);
            chip.setText(region.name);
            chip.setOnClickListener(v -> {
                current[0] = region;
                baseline[0] = null;
                out.setText(activity.getString(R.string.watch_hint));
                for (int k = 0; k < chipViews.length; k++) {
                    chipViews[k].setAlpha(k == index ? 1f : 0.5f);
                }
            });
            chipViews[i] = chip;
            chips.addView(chip);
        }
        chipViews[0].setAlpha(1f);
        for (int i = 1; i < chipViews.length; i++) {
            chipViews[i].setAlpha(0.5f);
        }
        tick[0] = () -> {
            if (!running[0]) {
                return;
            }
            Region region = current[0];
            byte[] now = core.busReadBlock(region.address, region.size);
            byte[] before = baseline[0];
            if (before == null || before.length != now.length) {
                baseline[0] = now;
                handler.postDelayed(tick[0], WATCH_INTERVAL_MS);
                return;
            }
            int changed = 0;
            for (int i = 0; i < now.length; i++) {
                if (now[i] != before[i]) {
                    changed++;
                }
            }
            StringBuilder text = new StringBuilder();
            if (changed == 0) {
                text.append(activity.getString(R.string.watch_none));
            } else {
                text.append(activity.getString(R.string.watch_changed_n, changed, region.name))
                        .append('\n');
                int shown = 0;
                for (int i = 0; i < now.length && shown < WATCH_MAX_ROWS; i++) {
                    if (now[i] != before[i]) {
                        text.append(String.format(Locale.US, "%08X  %02X → %02X\n",
                                region.address + i, before[i] & 0xFF, now[i] & 0xFF));
                        shown++;
                    }
                }
            }
            out.setText(text.toString());
            baseline[0] = now;
            handler.postDelayed(tick[0], WATCH_INTERVAL_MS);
        };
        toggle.setOnClickListener(v -> {
            running[0] = !running[0];
            toggle.setText(running[0] ? R.string.watch_stop : R.string.watch_start);
            handler.removeCallbacks(tick[0]);
            baseline[0] = null;
            if (running[0]) {
                handler.post(tick[0]);
            }
        });
        box.addView(chips);
        box.addView(toggle);
        box.addView(out);
        ScrollView scroll = new ScrollView(activity);
        scroll.addView(box);
        AlertDialog dialog = new AlertDialog.Builder(activity)
                .setTitle(R.string.watch_view)
                .setView(scroll)
                .setPositiveButton(R.string.close, null)
                .create();
        dialog.setOnDismissListener(d -> {
            running[0] = false;
            handler.removeCallbacks(tick[0]);
        });
        dialog.show();
    }

    // == Tile sheet viewer =================================================

    private static final int TILE_SHEET_COLS = 32;
    private static final int TILE_SHEET_ROWS = 32;
    private static final int TILE_SHEET_COUNT = TILE_SHEET_COLS * TILE_SHEET_ROWS;

    /**
     * The whole char area as a 32x32 tile sheet, the mobile stand-in for PC's
     * tile/map viewer. 4bpp honours a palette bank selector, 8bpp reads the
     * full 256-entry palette. Exports the sheet like the other viewers.
     */
    static void showTiles(EmulatorActivity activity, MgbaCore core) {
        LinearLayout box = column(activity);
        final int[] state = {4, 0};     // bits per pixel, palette bank (4bpp)
        final ImageView2 image = new ImageView2(activity);
        final TextView info = label(activity, 0);
        info.setTextColor(0xFFD6E8D6);
        LinearLayout tabs = row(activity);
        final Button bpp4 = smallButton(activity, R.string.tile_4bpp);
        final Button bpp8 = smallButton(activity, R.string.tile_8bpp);
        Button bankDown = smallButton(activity, 0);
        bankDown.setText("−");
        Button bankUp = smallButton(activity, 0);
        bankUp.setText("＋");
        Button export = smallButton(activity, R.string.export);
        final Bitmap[] current = new Bitmap[1];
        Runnable render = () -> {
            Bitmap sheet = tileSheet(core, state[0], state[1]);
            image.set(sheet);
            current[0] = sheet;
            bpp4.setEnabled(state[0] != 4);
            bpp8.setEnabled(state[0] != 8);
            bankDown.setEnabled(state[0] == 4 && state[1] > 0);
            bankUp.setEnabled(state[0] == 4 && state[1] < 15);
            String text = activity.getString(R.string.tile_info, state[0], TILE_SHEET_COUNT,
                    sheet.getWidth(), sheet.getHeight());
            if (state[0] == 4) {
                text = text + " · " + activity.getString(R.string.tile_bank, state[1]);
            }
            info.setText(text);
        };
        bpp4.setOnClickListener(v -> {
            state[0] = 4;
            render.run();
        });
        bpp8.setOnClickListener(v -> {
            state[0] = 8;
            render.run();
        });
        bankDown.setOnClickListener(v -> {
            if (state[1] > 0) {
                state[1]--;
                render.run();
            }
        });
        bankUp.setOnClickListener(v -> {
            if (state[1] < 15) {
                state[1]++;
                render.run();
            }
        });
        export.setOnClickListener(v -> {
            if (current[0] != null) {
                exportImage(activity, current[0], "tiles");
            }
        });
        tabs.addView(bpp4);
        tabs.addView(bpp8);
        tabs.addView(bankDown);
        tabs.addView(bankUp);
        tabs.addView(export);
        HorizontalScrollView hScroll = new HorizontalScrollView(activity);
        hScroll.addView(image);
        box.addView(tabs);
        box.addView(info);
        box.addView(hScroll, new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, dp(activity, 260)));
        render.run();
        ScrollView scroll = new ScrollView(activity);
        scroll.addView(box);
        new AlertDialog.Builder(activity)
                .setTitle(R.string.tile_view)
                .setView(scroll)
                .setPositiveButton(R.string.close, null)
                .show();
    }

    /** Decodes one tile sheet out of a single VRAM dump (no per-pixel bus reads). */
    private static Bitmap tileSheet(MgbaCore core, int bpp, int paletteBank) {
        int width = TILE_SHEET_COLS * 8;
        int height = TILE_SHEET_ROWS * 8;
        Bitmap sheet = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        int[] pixels = new int[width * height];
        byte[] vram = core.busReadBlock(VRAM_BASE, 0x18000);
        byte[] pal = core.busReadBlock(PAL_BASE, 512);
        int stride = bpp == 4 ? 32 : 64;
        for (int tile = 0; tile < TILE_SHEET_COUNT; tile++) {
            int tileAddr = tile * stride;
            int baseX = (tile % TILE_SHEET_COLS) * 8;
            int baseY = (tile / TILE_SHEET_COLS) * 8;
            for (int row = 0; row < 8; row++) {
                for (int col = 0; col < 8; col++) {
                    int index;
                    if (bpp == 4) {
                        int addr = tileAddr + row * 4 + (col >> 1);
                        if (addr >= vram.length) {
                            index = 0;
                        } else {
                            int value = vram[addr] & 0xFF;
                            index = ((col & 1) != 0 ? (value >> 4) : (value & 0xF))
                                    + paletteBank * 16;
                        }
                    } else {
                        int addr = tileAddr + row * 8 + col;
                        index = addr < vram.length ? vram[addr] & 0xFF : 0;
                    }
                    int entry = index * 2;
                    int colour = 0;
                    if (entry + 1 < pal.length) {
                        int bgr = (pal[entry] & 0xFF) | (pal[entry + 1] & 0xFF) << 8;
                        colour = bgr == 0 ? 0 : bgr15(bgr);
                    }
                    pixels[(baseY + row) * width + baseX + col] =
                            colour == 0 ? 0xFF101010 : colour;
                }
            }
        }
        sheet.setPixels(pixels, 0, width, 0, 0, width, height);
        return sheet;
    }

    // == I/O register viewer ===============================================

    private static final class IoReg {
        final String name;
        final int offset;
        final int bits;

        IoReg(String name, int offset, int bits) {
            this.name = name;
            this.offset = offset;
            this.bits = bits;
        }
    }

    private static final IoReg[] GBA_IO = {
            new IoReg("DISPCNT", 0x000, 16), new IoReg("DISPSTAT", 0x004, 16),
            new IoReg("VCOUNT", 0x006, 16),
            new IoReg("BG0CNT", 0x008, 16), new IoReg("BG1CNT", 0x00A, 16),
            new IoReg("BG2CNT", 0x00C, 16), new IoReg("BG3CNT", 0x00E, 16),
            new IoReg("BG0HOFS", 0x010, 16), new IoReg("BG0VOFS", 0x012, 16),
            new IoReg("BG1HOFS", 0x014, 16), new IoReg("BG1VOFS", 0x016, 16),
            new IoReg("BG2HOFS", 0x018, 16), new IoReg("BG2VOFS", 0x01A, 16),
            new IoReg("BG3HOFS", 0x01C, 16), new IoReg("BG3VOFS", 0x01E, 16),
            new IoReg("BG2PA", 0x020, 16), new IoReg("BG2PB", 0x022, 16),
            new IoReg("BG2PC", 0x024, 16), new IoReg("BG2PD", 0x026, 16),
            new IoReg("BG3PA", 0x030, 16), new IoReg("BG3PB", 0x032, 16),
            new IoReg("BG3PC", 0x034, 16), new IoReg("BG3PD", 0x036, 16),
            new IoReg("WIN0H", 0x040, 16), new IoReg("WIN1H", 0x042, 16),
            new IoReg("WIN0V", 0x044, 16), new IoReg("WIN1V", 0x046, 16),
            new IoReg("WININ", 0x048, 16), new IoReg("WINOUT", 0x04A, 16),
            new IoReg("MOSAIC", 0x04C, 16),
            new IoReg("BLDCNT", 0x050, 16), new IoReg("BLDALPHA", 0x052, 16),
            new IoReg("BLDY", 0x054, 16),
            new IoReg("SOUNDBIAS", 0x088, 16),
            new IoReg("DMA0SAD", 0x0B0, 32), new IoReg("DMA0DAD", 0x0B4, 32),
            new IoReg("DMA0CNT", 0x0B8, 32),
            new IoReg("DMA1SAD", 0x0BC, 32), new IoReg("DMA1DAD", 0x0C0, 32),
            new IoReg("DMA1CNT", 0x0C4, 32),
            new IoReg("DMA2SAD", 0x0C8, 32), new IoReg("DMA2DAD", 0x0CC, 32),
            new IoReg("DMA2CNT", 0x0D0, 32),
            new IoReg("DMA3SAD", 0x0D4, 32), new IoReg("DMA3DAD", 0x0D8, 32),
            new IoReg("DMA3CNT", 0x0DC, 32),
            new IoReg("KEYINPUT", 0x130, 16), new IoReg("KEYCNT", 0x132, 16),
            new IoReg("IE", 0x200, 16), new IoReg("IF", 0x202, 16),
            new IoReg("IME", 0x208, 16),
    };

    /** Named I/O dump with a manual refresh, the mobile stand-in for PC's ioViewer. */
    static void showIo(EmulatorActivity activity, MgbaCore core) {
        LinearLayout box = column(activity);
        final TextView values = new TextView(activity);
        values.setTypeface(Typeface.MONOSPACE);
        values.setTextSize(12);
        values.setTextColor(0xFFE0E0E0);
        values.setTextIsSelectable(true);
        Button refresh = smallButton(activity, R.string.io_refresh);
        refresh.setOnClickListener(v -> values.setText(ioDump(core)));
        values.setText(ioDump(core));
        box.addView(label(activity, R.string.io_info));
        box.addView(refresh);
        box.addView(values);
        ScrollView scroll = new ScrollView(activity);
        scroll.addView(box);
        new AlertDialog.Builder(activity)
                .setTitle(R.string.io_view)
                .setView(scroll)
                .setPositiveButton(R.string.close, null)
                .show();
    }

    private static String ioDump(MgbaCore core) {
        byte[] io = core.busReadBlock(IO_BASE, 0x400);
        StringBuilder out = new StringBuilder();
        for (IoReg reg : GBA_IO) {
            if (reg.offset + reg.bits / 8 > io.length) {
                continue;
            }
            long value;
            if (reg.bits == 32) {
                value = (io[reg.offset] & 0xFFL)
                        | (io[reg.offset + 1] & 0xFFL) << 8
                        | (io[reg.offset + 2] & 0xFFL) << 16
                        | (io[reg.offset + 3] & 0xFFL) << 24;
                out.append(String.format(Locale.US, "%-10s %03X  %08X",
                        reg.name, reg.offset, value));
            } else {
                value = (io[reg.offset] & 0xFFL) | (io[reg.offset + 1] & 0xFFL) << 8;
                out.append(String.format(Locale.US, "%-10s %03X  %04X",
                        reg.name, reg.offset, value));
            }
            out.append("  (").append(value).append(")\n");
        }
        return out.toString();
    }

    // == Map (tilemap) viewer ==============================================

    /**
     * Whole background tilemap with an 8x8 grid, PC's mapWindow. Only text
     * layers have a tilemap; bitmap modes are reported instead of faked.
     */
    static void showMap(EmulatorActivity activity, MgbaCore core) {
        int dispcnt = core.busRead(16, IO_BASE);
        int mode = dispcnt & 7;
        LinearLayout box = column(activity);
        final TextView info = label(activity, 0);
        info.setTextColor(0xFFD6E8D6);
        if (mode >= 3) {
            info.setText(activity.getString(R.string.map_bitmap_mode, mode));
            box.addView(info);
            ScrollView only = new ScrollView(activity);
            only.addView(box);
            new AlertDialog.Builder(activity)
                    .setTitle(R.string.map_view)
                    .setView(only)
                    .setPositiveButton(R.string.close, null)
                    .show();
            return;
        }
        final ImageView2 image = new ImageView2(activity);
        final int[] selected = {0};
        LinearLayout tabs = row(activity);
        for (int bg = 0; bg < 4; bg++) {
            final int index = bg;
            Button button = smallButton(activity, 0);
            button.setText("BG" + bg);
            button.setOnClickListener(v -> {
                selected[0] = index;
                image.set(mapBitmap(core, index, info, activity));
            });
            tabs.addView(button);
        }
        Button export = smallButton(activity, R.string.export);
        export.setOnClickListener(v -> {
            if (image.bitmap != null) {
                exportImage(activity, image.bitmap, "map");
            }
        });
        tabs.addView(export);
        HorizontalScrollView hScroll = new HorizontalScrollView(activity);
        hScroll.addView(image);
        box.addView(tabs);
        box.addView(info);
        box.addView(hScroll, new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, dp(activity, 260)));
        image.set(mapBitmap(core, 0, info, activity));
        ScrollView scroll = new ScrollView(activity);
        scroll.addView(box);
        new AlertDialog.Builder(activity)
                .setTitle(R.string.map_view)
                .setView(scroll)
                .setPositiveButton(R.string.close, null)
                .show();
    }

    /** Renders one text layer's tilemap at 8x8 per tile with a 1px grid. */
    private static Bitmap mapBitmap(MgbaCore core, int bg, TextView info, EmulatorActivity activity) {
        int cnt = core.busRead(16, IO_REG_BG0CNT + bg * 2);
        int priority = cnt & 3;
        int charBase = ((cnt >> 2) & 3) * 0x4000;
        boolean pal256 = (cnt & 0x80) != 0;
        int screenBase = ((cnt >> 8) & 31) * 0x800;
        int size = (cnt >> 14) & 3;
        int wTiles = (size & 1) != 0 ? 64 : 32;
        int hTiles = (size & 2) != 0 ? 64 : 32;
        int width = wTiles * 8;
        int height = hTiles * 8;
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        int[] pixels = new int[width * height];
        byte[] vram = core.busReadBlock(VRAM_BASE, 0x18000);
        byte[] pal = core.busReadBlock(PAL_BASE, 512);
        byte[] map = core.busReadBlock(VRAM_BASE + screenBase, wTiles * hTiles * 2);
        int bpp = pal256 ? 8 : 4;
        for (int ty = 0; ty < hTiles; ty++) {
            for (int tx = 0; tx < wTiles; tx++) {
                int entryIndex = (ty * wTiles + tx) * 2;
                if (entryIndex + 1 >= map.length) {
                    continue;
                }
                int entry = (map[entryIndex] & 0xFF) | (map[entryIndex + 1] & 0xFF) << 8;
                int tile = entry & 0x3FF;
                int palette = (entry >> 12) & 15;
                int tileAddr = charBase + tile * (bpp == 4 ? 32 : 64);
                int baseX = tx * 8;
                int baseY = ty * 8;
                for (int row = 0; row < 8; row++) {
                    for (int col = 0; col < 8; col++) {
                        int index;
                        if (bpp == 4) {
                            int addr = tileAddr + row * 4 + (col >> 1);
                            if (addr >= vram.length) {
                                index = 0;
                            } else {
                                int value = vram[addr] & 0xFF;
                                index = ((col & 1) != 0 ? (value >> 4) : (value & 0xF))
                                        + palette * 16;
                            }
                        } else {
                            int addr = tileAddr + row * 8 + col;
                            index = addr < vram.length ? vram[addr] & 0xFF : 0;
                        }
                        int colour = 0;
                        int off = index * 2;
                        if (off + 1 < pal.length) {
                            int bgr = (pal[off] & 0xFF) | (pal[off + 1] & 0xFF) << 8;
                            colour = bgr == 0 ? 0 : bgr15(bgr);
                        }
                        int px = baseX + col;
                        int py = baseY + row;
                        boolean grid = col == 0 || row == 0;
                        pixels[py * width + px] = grid ? 0xFF404040
                                : colour == 0 ? 0xFF101010 : colour;
                    }
                }
            }
        }
        bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
        info.setText(activity.getString(R.string.map_info, bg, width + "×" + height,
                priority, charBase, screenBase, bpp));
        return bitmap;
    }

    // == Frame inspector ===================================================

    /**
     * Decoded DISPCNT / DISPSTAT / per-layer state for the frame on screen,
     * PC's frameWindow in read-only form. 「帧进」steps one frame and re-reads.
     */
    static void showFrame(EmulatorActivity activity, MgbaCore core) {
        LinearLayout box = column(activity);
        final TextView out = new TextView(activity);
        out.setTypeface(Typeface.MONOSPACE);
        out.setTextSize(12);
        out.setTextColor(0xFFE0E0E0);
        out.setTextIsSelectable(true);
        LinearLayout tabs = row(activity);
        Button refresh = smallButton(activity, R.string.io_refresh);
        refresh.setOnClickListener(v -> out.setText(frameDump(core, activity)));
        Button step = smallButton(activity, R.string.frame_step);
        step.setOnClickListener(v -> {
            activity.stepOneFrame();
            out.postDelayed(() -> out.setText(frameDump(core, activity)), 120);
        });
        tabs.addView(refresh);
        tabs.addView(step);
        out.setText(frameDump(core, activity));
        box.addView(tabs);
        box.addView(out);
        ScrollView scroll = new ScrollView(activity);
        scroll.addView(box);
        new AlertDialog.Builder(activity)
                .setTitle(R.string.frame_view)
                .setView(scroll)
                .setPositiveButton(R.string.close, null)
                .show();
    }

    private static String frameDump(MgbaCore core, EmulatorActivity activity) {
        int dispcnt = core.busRead(16, IO_BASE);
        int dispstat = core.busRead(16, LEGACY_DISPSTAT_ADDR);
        int vcount = core.busRead(16, LEGACY_VCOUNT_ADDR);
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.US, "DISPCNT %04X  mode=%d  blank=%s  obj1d=%s  forcedBlank=%s\n",
                dispcnt, dispcnt & 7,
                (dispcnt & 0x80) != 0 ? "on" : "off",
                (dispcnt & 0x40) != 0 ? "1D" : "2D",
                (dispcnt & 0x80) != 0 ? "yes" : "no"));
        sb.append(String.format(Locale.US, "DISPSTAT %04X  vblank=%s hblank=%s vmatch=%s\n",
                dispstat,
                (dispstat & 1) != 0 ? "1" : "0",
                (dispstat & 2) != 0 ? "1" : "0",
                (dispstat & 4) != 0 ? "1" : "0"));
        sb.append(String.format(Locale.US, "VCOUNT %d\n", vcount & 0xFF));
        sb.append("layers:");
        for (int bg = 0; bg < 4; bg++) {
            if ((dispcnt & (0x100 << bg)) != 0) {
                sb.append(" BG").append(bg);
            }
        }
        if ((dispcnt & 0x1000) != 0) {
            sb.append(" OBJ");
        }
        if ((dispcnt & 0x2000) != 0) {
            sb.append(" WIN0");
        }
        if ((dispcnt & 0x4000) != 0) {
            sb.append(" WIN1");
        }
        if ((dispcnt & 0x8000) != 0) {
            sb.append(" OBJWIN");
        }
        sb.append('\n');
        for (int bg = 0; bg < 4; bg++) {
            int cnt = core.busRead(16, IO_REG_BG0CNT + bg * 2);
            int hofs = core.busRead(16, IO_REG_BG0HOFS + bg * 4) & 0x1FF;
            int vofs = core.busRead(16, IO_REG_BG0VOFS + bg * 4) & 0x1FF;
            int size = (cnt >> 14) & 3;
            int wTiles = (size & 1) != 0 ? 64 : 32;
            int hTiles = (size & 2) != 0 ? 64 : 32;
            sb.append(String.format(Locale.US,
                    "BG%d %s pin=%d map=%03X char=%04X %dx%d %s scroll=%d,%d\n",
                    bg,
                    (dispcnt & (0x100 << bg)) != 0 ? "on " : "off",
                    cnt & 3,
                    ((cnt >> 8) & 31) * 0x800,
                    ((cnt >> 2) & 3) * 0x4000,
                    wTiles * 8, hTiles * 8,
                    (cnt & 0x80) != 0 ? "256c" : "16c ",
                    hofs, vofs));
        }
        byte[] oam = core.busReadBlock(OAM_BASE, 0x400);
        int visible = 0;
        int affine = 0;
        for (int i = 0; i < 128; i++) {
            int attr0 = (oam[i * 8] & 0xFF) | (oam[i * 8 + 1] & 0xFF) << 8;
            boolean disabled = (attr0 & 0x0200) != 0;
            int y = attr0 & 0xFF;
            if (!disabled && y < 160) {
                visible++;
            }
            if ((attr0 & 0x0100) != 0) {
                affine++;
            }
        }
        sb.append(activity.getString(R.string.frame_oam, visible, affine));
        return sb.toString();
    }

    // == Export ============================================================

    /** Saves a viewer render to Pictures/mGBAx like the screenshots. */
    private static void exportImage(EmulatorActivity activity, Bitmap bitmap, String kind) {
        String stamp = android.text.format.DateFormat.format("yyyyMMdd-HHmmss", System.currentTimeMillis()).toString();
        String title = "mGBAx-" + kind + "-" + stamp + ".png";
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                ContentValues values = new ContentValues();
                values.put(MediaStore.Images.Media.DISPLAY_NAME, title);
                values.put(MediaStore.Images.Media.MIME_TYPE, "image/png");
                values.put(MediaStore.Images.Media.RELATIVE_PATH, Environment.DIRECTORY_PICTURES + "/mGBAx");
                android.net.Uri uri = activity.getContentResolver()
                        .insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
                if (uri != null) {
                    try (OutputStream out = activity.getContentResolver().openOutputStream(uri)) {
                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
                    }
                }
            } else {
                File dir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "mGBAx");
                dir.mkdirs();
                try (OutputStream out = new FileOutputStream(new File(dir, title))) {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
                }
            }
            Toast.makeText(activity, activity.getString(R.string.image_export_, "Pictures/mGBAx/" + title),
                    Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(activity, activity.getString(R.string.screenshot_failed), Toast.LENGTH_SHORT).show();
        }
    }

    // == Small programmatic widgets ========================================

    private static LinearLayout column(Context context) {
        LinearLayout box = new LinearLayout(context);
        box.setOrientation(LinearLayout.VERTICAL);
        int pad = dp(context, 12);
        box.setPadding(pad, pad, pad, pad);
        return box;
    }

    private static LinearLayout row(Context context) {
        LinearLayout box = new LinearLayout(context);
        box.setOrientation(LinearLayout.HORIZONTAL);
        box.setGravity(Gravity.CENTER_VERTICAL);
        return box;
    }

    private static LinearLayout.LayoutParams rowWeight() {
        return new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f);
    }

    private static TextView label(Context context, int res) {
        TextView view = new TextView(context);
        if (res != 0) {
            view.setText(res);
        }
        view.setTextColor(0xFFE0E0E0);
        view.setTextSize(13);
        view.setPadding(0, dp(context, 6), 0, dp(context, 2));
        return view;
    }

    private static TextView chip(Context context, String text) {
        TextView view = new TextView(context);
        view.setText(text);
        view.setTextColor(0xFF9CCC9C);
        view.setTextSize(13);
        view.setTypeface(Typeface.MONOSPACE);
        int pad = dp(context, 8);
        view.setPadding(pad, dp(context, 4), pad, dp(context, 4));
        return view;
    }

    private static EditText input(Context context) {
        EditText view = new EditText(context);
        view.setTextColor(0xFFE0E0E0);
        view.setSingleLine();
        return view;
    }

    private static Button smallButton(Context context, int res) {
        Button view = new Button(context);
        if (res != 0) {
            view.setText(res);
        }
        view.setTextSize(12);
        return view;
    }

    private static int dp(Context context, int value) {
        return (int) (value * context.getResources().getDisplayMetrics().density + 0.5f);
    }

    /** Plain ImageView wrapper holding one bitmap; sizes itself to the image. */
    private static final class ImageView2 extends View {
        Bitmap bitmap;

        ImageView2(Context context) {
            super(context);
        }

        void set(Bitmap value) {
            if (bitmap != null && bitmap != value) {
                bitmap.recycle();
            }
            bitmap = value;
            requestLayout();
            invalidate();
        }

        @Override
        protected void onMeasure(int widthSpec, int heightSpec) {
            if (bitmap == null) {
                setMeasuredDimension(dp(getContext(), 120), dp(getContext(), 80));
                return;
            }
            setMeasuredDimension(bitmap.getWidth(), bitmap.getHeight());
        }

        @Override
        protected void onDraw(Canvas canvas) {
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, 0, 0, null);
            }
        }

        @Override
        protected void onDetachedFromWindow() {
            if (bitmap != null) {
                bitmap.recycle();
                bitmap = null;
            }
            super.onDetachedFromWindow();
        }
    }
}
