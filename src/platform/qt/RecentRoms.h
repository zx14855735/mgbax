/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
/* PC 端「最近打开 ROM」列表。三端 schema 见 .zcode-tmp/SY2.md §2.2 /
 * C1_CONTRACT.md §1.3；与 android/app/src/main/java/io/mgba/android/RecentRoms.java
 * 逐字段对称。纯增量：不删除旧 QSettings "mru" 组，不动 lastRom / rom_favs。
 *
 * 注意：本类的 QSettings 键是设备私有本地存储（Windows HKCU\Software\mGBAx\sync，
 * Linux ~/.config/mGBAx/sync.conf，依 Qt 默认）；跨端传播由 WebDavSync/ManifestSync
 * 消费 list()/toJson() 写入 manifest 的 "recent_roms" 对象，本类不直接读写 manifest。
 */
#pragma once

#include <QMap>
#include <QMutex>
#include <QString>
#include <QStringList>
#include <QVector>

class QJsonObject;

namespace QGBA {

class RecentRoms {
public:
    /** 字段与 Android/C1 契约一一对应；JSON 键名见 .cpp 的 fromJson()/toJson()。 */
    struct Entry {
        QString romId;                          // rom_id        主键 md5:<32hex> / path:<abs>
        QString idAlgo;                         // id_algo       md5 / path
        bool tentative = false;                 // tentative     md5 算不出时 true
        qint64 size = 0;                        // size          次级校验
        qint64 crc32 = -1;                      // crc32         真 IEEE CRC-32，-1 未知
        QString displayName;                    // display_name  basename
        QMap<QString, QString> paths;           // paths         device_id -> 绝对路径
        qint64 lastOpenedMs = 0;                // last_opened_ms
        QString lastDeviceId;                   // last_device_id
        int version = 0;                        // version       每次 upsert +1
        int openCount = 0;                      // open_count    仅统计
        QString syncOrigin;                     // sync.origin_device
        qint64 syncUpdatedAt = 0;               // sync.updated_at
        int syncRev = 0;                        // sync.rev
        QString syncOp;                         // sync.op       upsert / delete(预留)

        static Entry fromJson(const QJsonObject& o);
        QJsonObject toJson() const;
    };

    static constexpr int CAPACITY = 20;                    // 统一 20（旧 mru 10 保留只读）
    static constexpr int SCHEMA = 1;
    static constexpr const char* KEY_RECENT = "recentRoms";          // 本地 QSettings 键（设备私有）
    static constexpr const char* KEY_DEVICE_ID = "mgbax_device_id";  // C1 §1.7 私有键
    static constexpr const char* KEY_MIGRATED = "recentRomsMigrated";
    static constexpr const char* ID_MD5 = "md5:";
    static constexpr const char* ID_PATH = "path:";

    static QString deviceId();                  // pc-<32hex 小写>，生成一次持久化、只读不重算
    static QVector<Entry> list();               // 倒序，损坏→空表（不覆写原串）
    static void writeAll(const QVector<Entry>& items);      // 截断 20 + schema envelope（同步导入后可调）
    static void record(const QString& path);                // 加载成功后调用（内部含 I/O）
    static void touchById(const QString& romId);            // 缓存副本打开：只更新时间/排序，不改 paths
    static void bindPath(const Entry& e, const QString& path); // 哈希证实后写回 paths[本端]
    static void clear();                                    // 只清 KEY_RECENT，不动旧 mru/lastRom
    static QString resolve(const Entry& e,
                           const QStringList& candidates = QStringList()); // 未证实返回空，UI 标灰
    static void migrateLegacyMru(const QStringList& legacyPaths); // 入参 = m_config->getMRU(ROM)

    static QString md5Of(const QString& path);  // 全文件流式 MD5，失败返回空 QString
    static qint64 crc32Of(const QString& path); // 真 IEEE CRC-32（mgba-util），失败 -1

private:
    static QMutex& lock();                                   // 读-改-写串行化（非递归）
    static QVector<Entry> readAllLocked();                   // 调用者已持 lock()，内部绝不再加锁
    static void writeAllLocked(const QVector<Entry>& items);// 调用者已持 lock()，内部绝不再加锁
    static bool verified(const QString& path, const Entry& e);
    static QString normalizePath(const QString& path);

    RecentRoms() = delete;
};

} // namespace QGBA
