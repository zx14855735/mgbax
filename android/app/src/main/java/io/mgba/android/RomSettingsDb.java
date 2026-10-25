/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package io.mgba.android;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Per-game overrides, keyed by the ROM's CRC32, in the spirit of Pizza Boy's
 * rom_settings database: one row per (game, setting). Values are strings; the
 * caller parses them. The special value {@link #DEFAULT} means "use the
 * global preference".
 */
public final class RomSettingsDb extends SQLiteOpenHelper {
    public static final String DEFAULT = "default";
    private static final String DB_NAME = "rom_settings.db";
    private static final int VERSION = 1;

    public RomSettingsDb(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE rom_setting("
                + "checksum INTEGER NOT NULL,"
                + "name TEXT NOT NULL,"
                + "value TEXT NOT NULL,"
                + "PRIMARY KEY(checksum,name))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public String get(long checksum, String name, String fallback) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query("rom_setting", new String[]{"value"},
                "checksum=? AND name=?", new String[]{String.valueOf(checksum), name},
                null, null, null);
        try {
            if (cursor.moveToFirst()) {
                return cursor.getString(0);
            }
        } finally {
            cursor.close();
        }
        return fallback;
    }

    public void put(long checksum, String name, String value) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues row = new ContentValues();
        row.put("checksum", checksum);
        row.put("name", name);
        row.put("value", value);
        db.insertWithOnConflict("rom_setting", null, row, SQLiteDatabase.CONFLICT_REPLACE);
    }

    /** Clears every override of one game. */
    public void clear(long checksum) {
        getWritableDatabase().delete("rom_setting", "checksum=?",
                new String[]{String.valueOf(checksum)});
    }
}
