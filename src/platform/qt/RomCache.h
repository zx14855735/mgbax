/* Copyright (c) 2026 mGBA-Android contributors
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#pragma once

#include <QList>
#include <QString>
#include <functional>

class QMutex;
class QObject;

namespace QGBA {

/**
 * 本地 ROM 副本缓存（需求④ PC 对称版）。
 *
 * 对齐 Android io.mgba.android.RomCache：
 *  - 身份 romId = "md5:<32hex>"，缓存文件名 "<32hex>.gba"；
 *  - 目录 QStandardPaths::AppDataLocation/rom_cache（私有、避开库扫描根）；
 *  - 清单独立 AppDataLocation/romcache.ini，key "entries"（JSON 数组）；
 *  - 500MB / 20 条上限，80% 水位（400MB / 16）按 last_access_ms 升序 LRU；
 *  - .part → rename 原子落盘；缺失/size 不符/坏清单自愈；
 *  - clearAll 只删 .gba/.part，绝不删 .sav/.ssN；
 *  - 缓存路径绝不写入 MRU/同步配置。
 *
 * PC 扩展：清单条目多 origin（原始绝对路径），cachedPathForOrigin() 支撑
 * 「MRU 原路径失效 → 查缓存 → 可点」；缓存路径本身不写 MRU（等价 Android 不写 paths）。
 *
 * 诚实纪律：任何 I/O 失败、尺寸不符、清单损坏一律返回空串或自愈，绝不伪造命中。
 * 同步接口含文件 I/O，禁止在 emu 循环线程调用；后台入缓存走 ensureCachedByPathAsync。
 */
class RomCache {
public:
	struct Entry {
		QString romId;        // md5:<32hex>
		QString path;         // 缓存副本绝对路径（位于 rom_cache 内）
		QString origin;       // 原始 ROM 绝对路径（PC 扩展，MRU 失效回落）
		qint64  size = 0;
		qint64  lastAccessMs = 0;
	};

	static const qint64 MAX_BYTES;          // 500LL * 1024 * 1024
	static const int    MAX_ENTRIES;        // 20
	static const qint64 WATERMARK_BYTES;    // MAX_BYTES * 0.8  = 400MB
	static const int    WATERMARK_ENTRIES;  // MAX_ENTRIES * 0.8 = 16

	// —— 同步接口：含文件 I/O，禁止在 emu 循环线程调用 ——
	static QString ensureCached(const QString& romId, const QString& sourcePath,
	                            const QString& originPath = QString());
	static QString getCachedPath(const QString& romId);
	static QString cachedPathForOrigin(const QString& originPath);
	static void    touch(const QString& romId);
	static void    clearAll(const QString& protectedRomId = QString());
	static qint64  cachedSize();
	static int     cachedCount();
	static void    pruneIfNeeded(const QString& protectedRomId = QString());
	static bool    isCachePath(const QString& path);
	static QString romIdFromCachePath(const QString& path);
	static QString md5OfFile(const QString& path);

	/**
	 * 稳定共享存档目录（绝不在 rom_cache 内）。
	 * preferred 非空且不在缓存目录内时原样采用（如用户显式 savegamePath），
	 * 否则回退 AppDataLocation/saves。供 CoreManager/CoreController 做 fromCache 旁路。
	 */
	static QString stableSharedSaveDir(const QString& preferred = QString());

	// —— 异步：worker 算 MD5 + 复制，结果经 context 所在线程回调；空串 = 失败/降级 ——
	static void ensureCachedByPathAsync(QObject* context, const QString& sourcePath,
	                                    std::function<void(const QString&)> callback);

private:
	RomCache() = delete;
	static QString manifestPath();
	static QString cacheDir();
	static bool    isInsideCacheDir(const QString& path); // 纯判定，不创建目录、不加锁
	static QString fileNameFor(const QString& romId);
	static QList<Entry> loadLocked(bool* dirty = nullptr); // 调用方持 writeMutex
	static void saveLocked(const QList<Entry>& entries);   // 调用方持 writeMutex
	static void putEntryLocked(const Entry& entry);        // 调用方持 writeMutex
	static QMutex& writeMutex();                           // 函数内 static，避免初始化顺序问题
	static QMutex& copyMapMutex();                         // 只保护 copyMutexTable
	static QMutex& copyMutexFor(const QString& romId);     // 按 romId 的复制锁
};

} // namespace QGBA
