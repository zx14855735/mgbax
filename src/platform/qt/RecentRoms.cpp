/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#include "RecentRoms.h"

#include <mgba-util/crc32.h>   // extern "C"；crc32()/doCrc32()/fileCrc32()。Qt 层先例：GBOverride.cpp:10,22

#include <QCryptographicHash>
#include <QDateTime>
#include <QFile>
#include <QFileInfo>
#include <QHash>
#include <QJsonArray>
#include <QJsonDocument>
#include <QJsonObject>
#include <QJsonParseError>
#include <QJsonValue>
#include <QMutexLocker>
#include <QSettings>
#include <QUuid>

#include <algorithm>
#include <cstdint>

namespace QGBA {
namespace {

// 主锁：串行化「读表-改表-写表」。QMutex 非递归——持锁期间禁止调用任何会再取 gLock() 的函数。
QMutex& gLock() { static QMutex m; return m; }
// 设备 id 首启竞态锁（与 gLock 不同，二者无嵌套环：deviceId() 永不取 gLock）。
QMutex& gDevIdLock() { static QMutex m; return m; }

QHash<QString, QString>& md5Cache() { static QHash<QString, QString> c; return c; }
QHash<QString, qint64>& crcCache()  { static QHash<QString, qint64> c;  return c; }

// 与 Android RecentRoms.java:166,193 / iOS 的 64KB 分块对称。
constexpr int kHashChunk = 64 * 1024;

// 存储「工厂」：每次取一个绑定当前线程的全新栈上 QSettings，不共享静态引用
// （与 Android prefs(ctx) 每次取新 handle 同构，对齐 R2C libSettings() 意图）。
// 关键纠偏：本仓库 src/platform/qt/CMakeLists.txt:1 = CMAKE_CXX_STANDARD 14，且 Qt6
// qsettings.h:184 对 QSettings 施加 Q_DISABLE_COPY（类内无移动构造）——C++14 下
// 「按值返回 QSettings」会因拷贝构造被删而编译失败（R2C:267-269 / S11 §3.2 的按值
// 返回原型在本工程不可编译）。故改以「就地构造」替代按值返回，语义等价且 C++14 可编译。
// 具名实例用同一对常量直接构造。
constexpr const char* kSettingsOrg = "mGBAx";
constexpr const char* kSettingsApp = "sync";
#define MGBAX_SYNC_SETTINGS() QSettings(QString::fromLatin1(kSettingsOrg), QString::fromLatin1(kSettingsApp))

} // namespace

QMutex& RecentRoms::lock() { return gLock(); }

QString RecentRoms::normalizePath(const QString& p) {
    return QFileInfo(p).absoluteFilePath();
}

QString RecentRoms::deviceId() {
    QMutexLocker locker(&gDevIdLock());
    QSettings s(QString::fromLatin1(kSettingsOrg), QString::fromLatin1(kSettingsApp));
    const QString id = s.value(QLatin1String(KEY_DEVICE_ID)).toString().trimmed();
    if (!id.isEmpty()) {
        return id;                                  // 只读：不重算、不覆盖
    }
    // QUuid::WithoutBraces 只去 {}，仍留 4 个连字符 → 必须 remove('-') 且 toLower()
    // 才符合 C1 §1.7 的 pc- + 32 位小写 hex（与 Android and- 小写同构）。
    const QString fresh = QStringLiteral("pc-")
                        + QUuid::createUuid().toString(QUuid::WithoutBraces)
                           .remove(QLatin1Char('-'))
                           .toLower();
    s.setValue(QLatin1String(KEY_DEVICE_ID), fresh);
    s.sync();                                       // 立即落盘，防进程退出丢失
    return fresh;
}

qint64 RecentRoms::crc32Of(const QString& path) {
    if (path.isEmpty()) return -1;
    QFileInfo fi(path);
    if (!fi.isFile() || !fi.isReadable()) return -1;
    const QString key = fi.absoluteFilePath() + QLatin1Char('|') + QString::number(fi.size());
    {
        QMutexLocker g(&gLock());
        const auto it = crcCache().constFind(key);
        if (it != crcCache().constEnd()) return it.value();
    }
    QFile f(path);
    if (!f.open(QIODevice::ReadOnly)) return -1;
    QByteArray buf;
    buf.resize(kHashChunk);
    uint32_t crc = 0;                               // 初值 0：crc32.c:104-113 内部 ~crc 开/收
    qint64 n = 0;
    while ((n = f.read(buf.data(), buf.size())) > 0) {
        // 滚动累加：把上一块返回值传回；切勿改成 doCrc32(buf,n)（每块重置，结果错）。
        crc = crc32(crc, reinterpret_cast<const unsigned char*>(buf.constData()), static_cast<size_t>(n));
    }
    if (n < 0) return -1;                           // 读错误，绝不返回部分值当成功
    const qint64 out = static_cast<qint64>(crc);
    {
        QMutexLocker g(&gLock());
        crcCache().insert(key, out);
    }
    return out;
}

QString RecentRoms::md5Of(const QString& path) {
    if (path.isEmpty()) return QString();
    QFileInfo fi(path);
    if (!fi.isFile() || !fi.isReadable()) return QString();
    // 缓存键含 size + crc32。注意 crc32Of(path) 在下面取 gLock 之前调用，
    // 二者锁区顺序执行、不嵌套（避免 gLock 自锁）。
    const QString key = fi.absoluteFilePath() + QLatin1Char('|')
                      + QString::number(fi.size()) + QLatin1Char('|')
                      + QString::number(crc32Of(path));
    {
        QMutexLocker g(&gLock());
        const auto it = md5Cache().constFind(key);
        if (it != md5Cache().constEnd()) return it.value();
    }
    QFile f(path);
    if (!f.open(QIODevice::ReadOnly)) return QString();
    QCryptographicHash h(QCryptographicHash::Md5);  // Qt5/Qt6 同名枚举
    QByteArray buf;
    buf.resize(kHashChunk);
    qint64 n = 0;
    while ((n = f.read(buf.data(), buf.size())) > 0) {
        h.addData(buf.constData(), static_cast<int>(n));
    }
    const QString out = QString::fromLatin1(h.result().toHex());
    {
        QMutexLocker g(&gLock());
        md5Cache().insert(key, out);
    }
    return out;
}

RecentRoms::Entry RecentRoms::Entry::fromJson(const QJsonObject& o) {
    Entry e;
    e.romId = o.value(QLatin1String("rom_id")).toString();
    if (e.romId.isEmpty()) return Entry();          // 调用方以 romId 空判无效跳过（等价 Android null）
    e.idAlgo = o.value(QLatin1String("id_algo")).toString(QStringLiteral("md5"));
    e.tentative = o.value(QLatin1String("tentative")).toBool(false);
    // QJsonValue 内部以 double 承载数字；toDouble() 为 Qt5/Qt6 通用 API，
    // epoch-ms(约 1.7e12) 与文件大小在 53 位内精确，转 qint64 无误差。
    e.size = static_cast<qint64>(o.value(QLatin1String("size")).toDouble(0.0));
    e.crc32 = static_cast<qint64>(o.value(QLatin1String("crc32")).toDouble(-1.0));
    e.displayName = o.value(QLatin1String("display_name")).toString();
    e.lastOpenedMs = static_cast<qint64>(o.value(QLatin1String("last_opened_ms")).toDouble(0.0));
    e.lastDeviceId = o.value(QLatin1String("last_device_id")).toString();
    e.version = o.value(QLatin1String("version")).toInt(1);
    e.openCount = o.value(QLatin1String("open_count")).toInt(0);
    const QJsonObject ps = o.value(QLatin1String("paths")).toObject();
    for (auto it = ps.constBegin(); it != ps.constEnd(); ++it) {
        const QString v = it.value().toString();
        if (!v.isEmpty()) e.paths.insert(it.key(), v);
    }
    const QJsonObject sy = o.value(QLatin1String("sync")).toObject();
    e.syncOrigin = sy.value(QLatin1String("origin_device")).toString();
    e.syncUpdatedAt = static_cast<qint64>(sy.value(QLatin1String("updated_at")).toDouble(0.0));
    e.syncRev = sy.value(QLatin1String("rev")).toInt(0);
    e.syncOp = sy.value(QLatin1String("op")).toString(QStringLiteral("upsert"));
    return e;
}

QJsonObject RecentRoms::Entry::toJson() const {
    QJsonObject o;
    o[QLatin1String("rom_id")] = romId;
    o[QLatin1String("id_algo")] = idAlgo.isEmpty() ? QStringLiteral("md5") : idAlgo;
    o[QLatin1String("tentative")] = tentative;
    o[QLatin1String("size")] = size;
    o[QLatin1String("crc32")] = crc32;
    o[QLatin1String("display_name")] = displayName;
    QJsonObject ps;
    for (auto it = paths.constBegin(); it != paths.constEnd(); ++it) ps[it.key()] = it.value();
    o[QLatin1String("paths")] = ps;
    o[QLatin1String("last_opened_ms")] = lastOpenedMs;
    o[QLatin1String("last_device_id")] = lastDeviceId;
    o[QLatin1String("version")] = version;
    o[QLatin1String("open_count")] = openCount;
    QJsonObject sy;
    sy[QLatin1String("origin_device")] = !syncOrigin.isEmpty() ? syncOrigin
                                        : lastDeviceId;          // 对齐 Android:132
    sy[QLatin1String("updated_at")] = syncUpdatedAt > 0 ? syncUpdatedAt : lastOpenedMs;
    sy[QLatin1String("rev")] = syncRev;
    sy[QLatin1String("op")] = syncOp.isEmpty() ? QStringLiteral("upsert") : syncOp;
    o[QLatin1String("sync")] = sy;
    return o;
}

// ── 加锁版公开 API：只加锁一次，随后只调 *Locked 内部版 ───────────────

QVector<RecentRoms::Entry> RecentRoms::readAllLocked() {
    QVector<Entry> out;
    const QByteArray raw = MGBAX_SYNC_SETTINGS().value(QLatin1String(KEY_RECENT)).toByteArray();
    if (raw.isEmpty()) return out;
    QJsonParseError err{};
    const QJsonDocument doc = QJsonDocument::fromJson(raw, &err);
    if (err.error != QJsonParseError::NoError || !doc.isObject()) return out; // 保留原串，不覆写
    const QJsonArray arr = doc.object().value(QLatin1String("items")).toArray();
    for (const QJsonValue& v : arr) {
        const Entry e = Entry::fromJson(v.toObject());
        if (!e.romId.isEmpty()) out.append(e);      // 单条坏跳过，不影响整表
    }
    std::sort(out.begin(), out.end(), [](const Entry& a, const Entry& b) {
        return a.lastOpenedMs > b.lastOpenedMs;
    });
    return out;
}

void RecentRoms::writeAllLocked(const QVector<Entry>& items) {
    QVector<Entry> keep = items;
    if (keep.size() > CAPACITY) keep.resize(CAPACITY);
    QJsonObject doc;
    doc[QLatin1String("schema")] = SCHEMA;
    doc[QLatin1String("device_id")] = deviceId();    // 取 gDevIdLock，不取 gLock：无自锁
    doc[QLatin1String("updated_at")] = QDateTime::currentMSecsSinceEpoch();
    QJsonArray arr;
    for (const Entry& e : keep) arr.append(e.toJson());
    doc[QLatin1String("items")] = arr;
    QSettings s(QString::fromLatin1(kSettingsOrg), QString::fromLatin1(kSettingsApp));
    s.setValue(QLatin1String(KEY_RECENT), QJsonDocument(doc).toJson(QJsonDocument::Compact));
    s.sync();                                       // 与 WebDavView 同文件，落盘同步
}

QVector<RecentRoms::Entry> RecentRoms::list() {
    QMutexLocker g(&gLock());
    return readAllLocked();
}

void RecentRoms::writeAll(const QVector<Entry>& items) {
    QMutexLocker g(&gLock());
    writeAllLocked(items);
}

void RecentRoms::record(const QString& path) {
    if (path.isEmpty()) return;
    QFileInfo fi(path);
    if (!fi.isFile() || !fi.isReadable()) return;    // 不可读→不记，绝不伪造（压缩包伪路径在此排除）

    // ① 重 I/O 在取 gLock 之前完成（crc32Of/md5Of 内部会取 gLock）。
    const qint64 size = fi.size();
    const qint64 crc = crc32Of(path);
    const QString md5 = md5Of(path);
    const QString abs = normalizePath(path);
    const QString display = fi.fileName();
    const QString dev = deviceId();

    // ② 取锁后只做纯内存 + QSettings，全程不再调用取 gLock 的函数。
    QMutexLocker g(&gLock());
    const QByteArray raw = MGBAX_SYNC_SETTINGS().value(QLatin1String(KEY_RECENT)).toByteArray();
    if (!raw.isEmpty()) {                            // 已有数据但 JSON 损坏→保留原串、跳过写入
        QJsonParseError err{};
        const QJsonDocument d = QJsonDocument::fromJson(raw, &err);
        if (d.isNull() || err.error != QJsonParseError::NoError) return;
    }
    QVector<Entry> items = readAllLocked();          // 已倒序
    const QString romId = md5.isEmpty() ? QString::fromLatin1(ID_PATH) + abs
                                        : QString::fromLatin1(ID_MD5) + md5;
    const bool tentative = md5.isEmpty();
    Entry* target = nullptr;
    for (Entry& e : items) {
        const bool sameId = (e.romId == romId);      // 主键 rom_id 去重
        const bool quickSame = !tentative && e.size == size && e.crc32 == crc
                            && e.paths.value(dev) == abs; // size+crc32 次级快筛
        if (sameId || quickSame) { target = &e; break; }
    }
    if (!target) { items.append(Entry()); target = &items.last(); }
    const qint64 now = QDateTime::currentMSecsSinceEpoch();
    target->romId = romId;
    target->idAlgo = tentative ? QStringLiteral("path") : QStringLiteral("md5");
    target->tentative = tentative;
    target->size = size;
    target->crc32 = crc;
    target->displayName = display;
    target->paths[dev] = abs;                        // 按 device_id 覆盖，保留他端路径（并集）
    target->lastOpenedMs = now;
    target->lastDeviceId = dev;
    target->version += 1;
    target->openCount += 1;
    target->syncOrigin = dev;
    target->syncUpdatedAt = now;
    target->syncRev += 1;
    target->syncOp = QStringLiteral("upsert");
    std::sort(items.begin(), items.end(), [](const Entry& a, const Entry& b) {
        return a.lastOpenedMs > b.lastOpenedMs;
    });
    writeAllLocked(items);                           // 不重复加锁
}

void RecentRoms::touchById(const QString& romId) {
    if (romId.isEmpty()) return;
    QMutexLocker g(&gLock());
    QVector<Entry> items = readAllLocked();
    const qint64 now = QDateTime::currentMSecsSinceEpoch();
    for (Entry& e : items) {
        if (e.romId == romId) {
            e.lastOpenedMs = now;                    // 只更新时间/排序，绝不改 paths
            e.syncUpdatedAt = now;
            e.syncRev += 1;
            e.syncOrigin = deviceId();
            e.syncOp = QStringLiteral("upsert");
            std::sort(items.begin(), items.end(), [](const Entry& a, const Entry& b) {
                return a.lastOpenedMs > b.lastOpenedMs;
            });
            writeAllLocked(items);
            return;
        }
    }
}

bool RecentRoms::verified(const QString& path, const Entry& e) {
    QFileInfo fi(path);
    if (!fi.isFile() || !fi.isReadable()) return false;
    if (e.size > 0 && fi.size() != e.size) return false;
    const qint64 c = crc32Of(path);
    if (e.crc32 >= 0 && c != e.crc32) return false;
    if (e.tentative) return true;                    // path: 占位以存在 + size/crc 为准
    const QString m = md5Of(path);
    return !m.isEmpty() && (QString::fromLatin1(ID_MD5) + m == e.romId);
}

void RecentRoms::bindPath(const Entry& e, const QString& path) {
    QMutexLocker g(&gLock());
    QVector<Entry> items = readAllLocked();
    const QString dev = deviceId();
    for (Entry& it : items) {
        if (it.romId == e.romId) {
            it.paths[dev] = normalizePath(path);     // 不动打开时间
            writeAllLocked(items);
            return;
        }
    }
}

QString RecentRoms::resolve(const Entry& e, const QStringList& candidates) {
    if (e.romId.isEmpty()) return QString();
    // 本函数自身不持 gLock：verified() 经 crc32Of/md5Of 取锁，bindPath() 内部取锁。
    const QString dev = deviceId();
    const QString own = e.paths.value(dev);
    if (!own.isEmpty() && verified(own, e)) return own;
    for (auto it = e.paths.constBegin(); it != e.paths.constEnd(); ++it) {
        if (it.key() == dev || it.value().isEmpty()) continue;
        if (verified(it.value(), e)) { bindPath(e, it.value()); return it.value(); }
    }
    for (const QString& c : candidates) {            // 父会话可传本地库扫描结果
        if (verified(c, e)) { bindPath(e, c); return c; }
    }
    return QString(); // 本端未找到 / 哈希未证实 → 不打开、不写猜测路径，UI 标灰
}

void RecentRoms::migrateLegacyMru(const QStringList& legacyPaths) {
    // ① 不持锁：文件 I/O（crc32Of/md5Of 内部取 gLock）。S3:475-515 骨架在持锁循环内
    //    调哈希会自锁死——此处两阶段拆分修正，诚实标注为本文新增纠偏。
    if (MGBAX_SYNC_SETTINGS().value(QLatin1String(KEY_MIGRATED)).toBool()) return;
    QVector<Entry> pending;
    const QString dev = deviceId();
    const qint64 now = QDateTime::currentMSecsSinceEpoch();
    for (int i = 0; i < legacyPaths.size() && i < 10; ++i) { // 旧 mru 最多 10 条
        const QString p = legacyPaths.at(i);
        QFileInfo fi(p);
        if (!fi.isFile() || !fi.isReadable()) continue;      // 不可读→不制造条目
        const qint64 size = fi.size();
        const qint64 crc = crc32Of(p);
        const QString md5 = md5Of(p);
        const QString abs = normalizePath(p);
        Entry e;
        e.romId = md5.isEmpty() ? QString::fromLatin1(ID_PATH) + abs
                                : QString::fromLatin1(ID_MD5) + md5;
        e.idAlgo = md5.isEmpty() ? QStringLiteral("path") : QStringLiteral("md5");
        e.tentative = md5.isEmpty();
        e.size = size;
        e.crc32 = crc;
        e.displayName = fi.fileName();
        e.paths[dev] = abs;
        e.lastOpenedMs = now - i;                   // 保序：索引 0 最新（仅毫秒内排序用）
        e.lastDeviceId = dev;
        e.version = 1;
        e.openCount = 1;
        e.syncOrigin = dev;
        e.syncUpdatedAt = now - i;
        e.syncRev = 1;
        e.syncOp = QStringLiteral("upsert");
        pending.append(e);
    }

    // ② 取锁：只做去重合并 + 写回，持锁期间不调用任何取 gLock 的哈希函数。
    QMutexLocker g(&gLock());
    QSettings s(QString::fromLatin1(kSettingsOrg), QString::fromLatin1(kSettingsApp));
    if (s.value(QLatin1String(KEY_MIGRATED)).toBool()) return; // 双重检查：防首启竞态重复迁移
    QVector<Entry> items = readAllLocked();
    for (const Entry& e : pending) {
        bool exists = false;
        for (const Entry& cur : items) {
            if (cur.romId == e.romId) { exists = true; break; } // 按 rom_id 去重
        }
        if (!exists) items.append(e);
    }
    std::sort(items.begin(), items.end(), [](const Entry& a, const Entry& b) {
        return a.lastOpenedMs > b.lastOpenedMs;
    });
    writeAllLocked(items);
    s.setValue(QLatin1String(KEY_MIGRATED), true);
    s.sync();
    // 旧 mru 组保留只读，不删（ConfigController.cpp:372-386 仍写 10 条）。
}

void RecentRoms::clear() {
    QMutexLocker g(&gLock());
    QSettings s(QString::fromLatin1(kSettingsOrg), QString::fromLatin1(kSettingsApp));
    s.remove(QLatin1String(KEY_RECENT));
    s.sync();
    // 不动 lastRom / rom_favs / 旧 mru 组（向后兼容）。
}

} // namespace QGBA
