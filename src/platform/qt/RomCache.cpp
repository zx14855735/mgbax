/* Copyright (c) 2026 mGBA-Android contributors
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#include "RomCache.h"
#include <QRunnable>   // P4 P0-A: CopyTask : public QRunnable 需完整定义

#include <QCryptographicHash>
#include <QDateTime>
#include <QDir>
#include <QFile>
#include <QFileInfo>
#include <QHash>
#include <QJsonArray>
#include <QJsonDocument>
#include <QJsonObject>
#include <QJsonParseError>
#include <QMutex>
#include <QMutexLocker>
#include <QObject>
#include <QPointer>
#include <QSettings>
#include <QStandardPaths>
#include <QThreadPool>

#include <algorithm>
#include <functional>
#include <utility>

namespace QGBA {

const qint64 RomCache::MAX_BYTES         = 500LL * 1024 * 1024;
const int    RomCache::MAX_ENTRIES       = 20;
const qint64 RomCache::WATERMARK_BYTES   = static_cast<qint64>(MAX_BYTES * 0.8);
const int    RomCache::WATERMARK_ENTRIES = static_cast<int>(MAX_ENTRIES * 0.8);

QMutex& RomCache::writeMutex() {
	static QMutex m;
	return m;
}

QMutex& RomCache::copyMapMutex() {
	static QMutex m;
	return m;
}

QMutex& RomCache::copyMutexFor(const QString& romId) {
	static QHash<QString, QMutex*> table;
	QMutexLocker l(&copyMapMutex()); // 与 writeMutex 完全分离，杜绝锁序歧义
	QHash<QString, QMutex*>::iterator it = table.find(romId);
	if (it == table.end()) {
		it = table.insert(romId, new QMutex); // 只增不删，上限几十条
	}
	return **it;
}

QString RomCache::manifestPath() {
	const QString base = QStandardPaths::writableLocation(QStandardPaths::AppDataLocation);
	if (base.isEmpty()) {
		return QString();
	}
	if (!QDir().mkpath(base) && !QDir(base).isReadable()) {
		return QString();
	}
	return QDir::cleanPath(base) + QLatin1String("/romcache.ini");
}

QString RomCache::cacheDir() {
	const QString base = QStandardPaths::writableLocation(QStandardPaths::AppDataLocation);
	if (base.isEmpty()) {
		return QString();
	}
	const QString dir = QDir::cleanPath(base) + QLatin1String("/rom_cache");
	if (!QDir().mkpath(dir) && !QDir(dir).isReadable()) {
		return QString();
	}
	return dir;
}

bool RomCache::isInsideCacheDir(const QString& path) {
	const QString base = QStandardPaths::writableLocation(QStandardPaths::AppDataLocation);
	if (base.isEmpty() || path.isEmpty()) {
		return false;
	}
	const QString prefix = QDir::cleanPath(base) + QLatin1String("/rom_cache/");
	const QString clean = QDir::cleanPath(QDir::fromNativeSeparators(path));
#ifdef Q_OS_WIN
	return clean.startsWith(prefix, Qt::CaseInsensitive); // 盘符大小写不敏感
#else
	return clean.startsWith(prefix, Qt::CaseSensitive);
#endif
}

QString RomCache::fileNameFor(const QString& romId) {
	const QString id = romId.startsWith(QLatin1String("md5:")) ? romId.mid(4) : romId;
	QString out;
	out.reserve(id.size() + 4);
	for (int i = 0; i < id.size(); ++i) {
		const QChar c = id.at(i);
		const bool ok = (c >= QLatin1Char('a') && c <= QLatin1Char('z'))
		             || (c >= QLatin1Char('A') && c <= QLatin1Char('Z'))
		             || (c >= QLatin1Char('0') && c <= QLatin1Char('9'))
		             || c == QLatin1Char('_') || c == QLatin1Char('-') || c == QLatin1Char('.');
		out.append(ok ? c : QLatin1Char('_'));
	}
	return out + QLatin1String(".gba");
}

QString RomCache::md5OfFile(const QString& path) {
	QFile f(path);
	if (!f.open(QIODevice::ReadOnly)) {
		return QString(); // 不伪造
	}
	QCryptographicHash h(QCryptographicHash::Md5);
	char buf[65536];
	qint64 n = 0;
	while ((n = f.read(buf, sizeof(buf))) > 0) {
		h.addData(buf, int(n));
	}
	if (n < 0) {
		return QString(); // 读取错误 → 降级
	}
	return QString::fromLatin1(h.result().toHex());
}

QString RomCache::stableSharedSaveDir(const QString& preferred) {
	if (!preferred.isEmpty() && !isInsideCacheDir(preferred)) {
		return QDir::cleanPath(QDir::fromNativeSeparators(preferred));
	}
	QString base = QStandardPaths::writableLocation(QStandardPaths::AppDataLocation);
	if (base.isEmpty()) {
		base = QDir::homePath() + QLatin1String("/.mgba"); // 最后回退
	}
	const QString dir = QDir::cleanPath(base) + QLatin1String("/saves");
	QDir().mkpath(dir); // 失败也不崩；真正加载时 VDirCreate 还会再试
	return dir;
}

// 调用方持 writeMutex。逐条自愈：路径不在缓存目录内/文件缺失/size 不符 → 剔除并回写；
// 清单 schema 不符或 JSON 损坏 → 清 entries。对齐 Android loadLocked :120-159。
QList<RomCache::Entry> RomCache::loadLocked(bool* dirty) {
	QList<Entry> out;
	const QString mp = manifestPath();
	if (mp.isEmpty()) {
		return out;
	}
	QSettings s(mp, QSettings::IniFormat);
	const QString raw = s.value(QLatin1String("entries")).toString();
	if (raw.isEmpty()) {
		if (dirty) *dirty = false;
		return out;
	}

	QJsonParseError pe;
	const QJsonDocument doc = QJsonDocument::fromJson(raw.toUtf8(), &pe);
	if (pe.error != QJsonParseError::NoError || !doc.isArray()
	    || s.value(QLatin1String("schema")).toInt() != 1) {
		s.remove(QLatin1String("entries"));
		s.sync();
		if (dirty) *dirty = true;
		return out;
	}

	bool bad = false;
	for (const QJsonValue& v : doc.array()) {
		if (!v.isObject()) { bad = true; continue; }
		const QJsonObject o = v.toObject();
		Entry e;
		e.romId        = o.value(QLatin1String("romId")).toString();
		e.path         = o.value(QLatin1String("path")).toString();
		e.origin       = o.value(QLatin1String("origin")).toString();
		e.size         = static_cast<qint64>(o.value(QLatin1String("size")).toDouble());
		e.lastAccessMs = static_cast<qint64>(o.value(QLatin1String("last_access_ms")).toDouble());
		if (e.romId.isEmpty() || e.path.isEmpty() || !isInsideCacheDir(e.path) || e.size < 0) {
			bad = true;
			continue;
		}
		const QFileInfo fi(e.path);
		if (!fi.isFile() || fi.size() != e.size) { // 自愈：缺失/尺寸不符
			bad = true;
			continue;
		}
		out.append(e);
	}
	if (bad) {
		saveLocked(out); // 坏条目已剔除，回写净化后的清单
	}
	if (dirty) *dirty = bad;
	return out;
}

// 调用方持 writeMutex。JSON 以 QString(UTF-8) 写入 INI，避免 QByteArray 在非 ASCII 路径下的编码坑。
void RomCache::saveLocked(const QList<Entry>& entries) {
	const QString mp = manifestPath();
	if (mp.isEmpty()) {
		return;
	}
	QJsonArray arr;
	for (const Entry& e : entries) {
		QJsonObject o;
		o.insert(QLatin1String("romId"), e.romId);
		o.insert(QLatin1String("path"), e.path);
		o.insert(QLatin1String("origin"), e.origin);
		o.insert(QLatin1String("size"), static_cast<double>(e.size));
		o.insert(QLatin1String("last_access_ms"), static_cast<double>(e.lastAccessMs));
		arr.append(o);
	}
	QSettings s(mp, QSettings::IniFormat);
	s.setValue(QLatin1String("schema"), 1);
	s.setValue(QLatin1String("entries"),
	           QString::fromUtf8(QJsonDocument(arr).toJson(QJsonDocument::Compact)));
	s.sync(); // 小文件，每次落盘换取崩不丢（与 Android apply() 取舍不同，语义等价）
}

void RomCache::putEntryLocked(const Entry& entry) {
	QList<Entry> es = loadLocked(); // 内含自愈
	bool found = false;
	for (Entry& e : es) {
		if (e.romId == entry.romId) { e = entry; found = true; break; }
	}
	if (!found) {
		es.append(entry);
	}
	saveLocked(es);
}

QString RomCache::getCachedPath(const QString& romId) {
	QMutexLocker l(&writeMutex());
	for (const Entry& e : loadLocked()) { // 内含自愈
		if (e.romId == romId) {
			return e.path;
		}
	}
	return QString();
}

QString RomCache::cachedPathForOrigin(const QString& originPath) {
	if (originPath.isEmpty()) {
		return QString();
	}
	QMutexLocker l(&writeMutex());
	for (const Entry& e : loadLocked()) {
		if (!e.origin.isEmpty() && e.origin == originPath) {
			return e.path;
		}
	}
	return QString();
}

void RomCache::touch(const QString& romId) {
	QMutexLocker l(&writeMutex());
	QList<Entry> es = loadLocked();
	for (Entry& e : es) {
		if (e.romId == romId) {
			e.lastAccessMs = QDateTime::currentMSecsSinceEpoch();
			saveLocked(es);
			return;
		}
	}
	// 条目不存在 → no-op，绝不新增（对齐 Android touch :209-222）
}

qint64 RomCache::cachedSize() {
	QMutexLocker l(&writeMutex());
	qint64 total = 0;
	for (const Entry& e : loadLocked()) {
		const QFileInfo fi(e.path);
		if (fi.isFile()) {
			total += fi.size(); // 按实际文件长度累加（对齐 Android cachedSize :224-235）
		}
	}
	return total;
}

int RomCache::cachedCount() {
	QMutexLocker l(&writeMutex());
	return loadLocked().size();
}

bool RomCache::isCachePath(const QString& path) {
	return isInsideCacheDir(path); // 纯判定，不创建目录
}

QString RomCache::romIdFromCachePath(const QString& path) {
	const QString name = QFileInfo(QDir::fromNativeSeparators(path)).fileName(); // <hex>.gba
	if (!name.endsWith(QLatin1String(".gba"))) {
		return QString();
	}
	const QString hex = name.left(name.size() - 4);
	if (hex.isEmpty()) {
		return QString();
	}
	return QStringLiteral("md5:") + hex;
}

void RomCache::clearAll(const QString& protectedRomId) {
	QMutexLocker l(&writeMutex());

	// 一次 loadLocked 同时取出「保护路径」与「保留条目」，
	// 避免在持 writeMutex 时调用 getCachedPath()/loadLocked() 造成重入死锁。
	const QList<Entry> es = loadLocked();
	QString keepPath;
	QList<Entry> keep;
	if (!protectedRomId.isEmpty()) {
		for (const Entry& e : es) {
			if (e.romId == protectedRomId) { keepPath = e.path; keep.append(e); }
		}
	}

	const QString dir = cacheDir();
	if (!dir.isEmpty()) {
		const QFileInfoList files = QDir(dir).entryInfoList(QDir::Files);
		for (const QFileInfo& fi : files) {
			const QString n = fi.fileName();
			// 白名单：只删缓存副本，绝不删可能存在的 .sav/.ss0..9（防误删存档）
			if (!n.endsWith(QLatin1String(".gba")) && !n.endsWith(QLatin1String(".part"))) {
				continue;
			}
			if (!keepPath.isEmpty()
			    && QDir::cleanPath(fi.absoluteFilePath()) == QDir::cleanPath(keepPath)) {
				continue; // 当前正在玩的缓存 ROM 不删
			}
			QFile::remove(fi.absoluteFilePath()); // 被 core 占用时可能失败：仅忽略，绝不崩
		}
	}

	const QString mp = manifestPath();
	if (mp.isEmpty()) {
		return;
	}
	if (protectedRomId.isEmpty()) {
		QSettings s(mp, QSettings::IniFormat);
		s.remove(QLatin1String("entries"));
		s.sync();
	} else {
		saveLocked(keep);
	}
}

void RomCache::pruneIfNeeded(const QString& protectedRomId) {
	QMutexLocker l(&writeMutex());
	QList<Entry> es = loadLocked();
	if (es.isEmpty()) {
		return;
	}
	qint64 total = 0;
	for (const Entry& e : es) total += e.size;
	int count = es.size();
	const bool sizeOver  = total > MAX_BYTES;
	const bool countOver = count > MAX_ENTRIES;
	if (!sizeOver && !countOver) {
		return; // 未越线
	}

	std::sort(es.begin(), es.end(), [](const Entry& a, const Entry& b) {
		return a.lastAccessMs < b.lastAccessMs; // 最旧在前
	});
	QList<Entry> keep;
	for (const Entry& e : es) {
		const bool need = (sizeOver  && total > WATERMARK_BYTES)
		               || (countOver && count > WATERMARK_ENTRIES);
		if (!need) { keep.append(e); continue; }               // 已降到 80% 水位即停（防抖动）
		if (!protectedRomId.isEmpty() && e.romId == protectedRomId) {
			keep.append(e); continue;                            // 当前加载 ROM 永不删
		}
		QFile::remove(e.path); // 失败仅忽略
		total -= e.size;
		--count;
	}
	saveLocked(keep);
}

QString RomCache::ensureCached(const QString& romId, const QString& sourcePath,
                               const QString& originPath) {
	if (romId.isEmpty() || sourcePath.isEmpty()) {
		return QString();
	}

	// 1) 命中 → touch 返回（getCachedPath 内含自愈）
	QString hit = getCachedPath(romId);
	if (!hit.isEmpty()) { touch(romId); return hit; }

	const QFileInfo src(sourcePath);
	if (!src.isFile() || !src.isReadable() || src.size() <= 0) {
		return QString();
	}
	const qint64 srcSize = src.size();

	QMutexLocker copyLock(&copyMutexFor(romId)); // 锁序：copyMutex → writeMutex（无反向路径）
	hit = getCachedPath(romId);                   // 双重检查：等锁期间可能已被别的线程缓存
	if (!hit.isEmpty()) { touch(romId); return hit; }

	const QString dir = cacheDir();
	if (dir.isEmpty()) {
		return QString();
	}
	const QString name = fileNameFor(romId);
	const QString tmp  = dir + QLatin1Char('/') + name + QLatin1String(".part");
	const QString dest = dir + QLatin1Char('/') + name;

	QFile in(sourcePath);
	QFile out(tmp);
	if (!in.open(QIODevice::ReadOnly)
	    || !out.open(QIODevice::WriteOnly | QIODevice::Truncate)) {
		QFile::remove(tmp);
		return QString();
	}
	char buf[65536];
	qint64 n = 0;
	qint64 written = 0;
	while ((n = in.read(buf, sizeof(buf))) > 0) {
		if (out.write(buf, n) != n) {
			out.close();
			QFile::remove(tmp);
			return QString();
		}
		written += n;
	}
	out.close();
	in.close();
	if (n < 0 || written != srcSize || QFileInfo(tmp).size() != srcSize) {
		QFile::remove(tmp); // 尺寸不符/读错 → 不写清单，诚实降级
		return QString();
	}

	// 原子落盘：Windows 下 rename 到已存在目标会失败 → 先删目标再 rename
	if (QFile::exists(dest) && !QFile::remove(dest)) { QFile::remove(tmp); return QString(); }
	if (!QFile::rename(tmp, dest))                    { QFile::remove(tmp); return QString(); }

	Entry e;
	e.romId        = romId;
	e.path         = dest;
	e.origin       = originPath.isEmpty() ? QDir::cleanPath(src.absoluteFilePath()) : originPath;
	e.size         = srcSize;
	e.lastAccessMs = QDateTime::currentMSecsSinceEpoch();
	{
		QMutexLocker l(&writeMutex());
		putEntryLocked(e);
	} // 必须先离开 writeMutex 作用域：pruneIfNeeded 内部自锁，持锁调用会死锁
	pruneIfNeeded(romId); // 清理时保护当前 ROM
	return dest;
}

// 信号中转器：避免 QMetaObject::invokeMethod(functor) 的 Qt 5.10+ 依赖，
// 只用 Qt 5.0+ 就有的「成员指针 connect + 上下文对象 + QueuedConnection」。
class RomCacheResultRelay : public QObject {
Q_OBJECT
public:
	explicit RomCacheResultRelay(QObject* parent = nullptr) : QObject(parent) {}
signals:
	void finished(const QString& path);
};

class CopyTask : public QRunnable {
public:
	CopyTask(const QPointer<RomCacheResultRelay>& relay, QString src, QString origin)
	    : m_relay(relay), m_src(std::move(src)), m_origin(std::move(origin)) {}

	void run() override {
		const QString md5 = RomCache::md5OfFile(m_src);
		const QString result = md5.isEmpty() ? QString()
		    : RomCache::ensureCached(QLatin1String("md5:") + md5, m_src, m_origin);
		if (m_relay) { // context 可能已销毁，QPointer 自动置空
			emit m_relay->finished(result); // 队列连接：自动切回 context 所在线程
			m_relay->deleteLater();
		}
	}

private:
	QPointer<RomCacheResultRelay> m_relay;
	QString m_src;
	QString m_origin;
};

void RomCache::ensureCachedByPathAsync(QObject* context, const QString& sourcePath,
                                       std::function<void(const QString&)> callback) {
	QPointer<RomCacheResultRelay> relay;
	if (context) {
		RomCacheResultRelay* r = new RomCacheResultRelay(context); // parent=context，异常路径也不泄漏
		relay = r;
		const std::function<void(const QString&)> cb = callback;
		QObject::connect(r, &RomCacheResultRelay::finished, context,
		                 [cb](const QString& p) { if (cb) cb(p); }, Qt::QueuedConnection);
	}
	QThreadPool::globalInstance()->start(new CopyTask(relay, sourcePath, sourcePath));
}

} // namespace QGBA

// RomCacheResultRelay 带 Q_OBJECT 且定义在 .cpp：AUTOMOC 生成本文件，须手动包含
// （与 src/platform/qt/CoreManager.cpp:26 的既有范式一致）。
/* S2 编译前置修复：AUTOMOC 对「Q_OBJECT 类定义在 .cpp 内」期望 <basename>.moc 格式。
 * 原 moc_RomCache.cpp 是头文件类范式（如 CoreManager.cpp），对本文件不适用。 */
#include "RomCache.moc"
