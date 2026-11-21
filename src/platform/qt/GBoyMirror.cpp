/* Copyright (c) 2013-2021 Jeffrey Pfau
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
#include "GBoyMirror.h"

#include "GBoyLinkSession.h"

#include <QDateTime>
#include <QDebug>
#include <QDir>
#include <QFile>
#include <QFileInfo>
#include <QCryptographicHash>

#include <cstdio>
#include <utility>

using namespace QGBA;

namespace {

/** One mirror frame at 60 fps; the pump keeps SIO latency at one frame. */
constexpr long FRAME_INTERVAL_US = 16667;
/** How long to wait for the loopback link to come up before giving up. */
constexpr int LINK_WAIT_MS = 4000;

QString saveNameFor(const QString& romPath) {
	QString base = QFileInfo(romPath).completeBaseName();
	if (base.isEmpty()) {
		base = QStringLiteral("mirror");
	}
	return base + QStringLiteral(".sav");
}

/** ISYNC1: 收到的种子块 FNV-1a（诊断口径，非 native 核状态 hash）。 */
static quint64 isyncStateHash(const QByteArray& bytes) {
	quint64 h = 1469598103934665603ULL;
	for (char c : bytes) {
		h ^= static_cast<unsigned char>(c);
		h *= 1099511628211ULL;
	}
	return h;
}

/** ISYNC1: 具名宏 MGBAX_ISYNC_STATE_APPLY（默认 0）或同名环境变量=1 打开。
 *  与 Android 广播、iOS 进程环境同口径；载入本身无条件发生，门只管诊断。 */
static bool isyncStateApplyEnabled() {
	return MGBAX_ISYNC_STATE_APPLY != 0
	    || qEnvironmentVariableIntValue("MGBAX_ISYNC_STATE_APPLY") != 0;
}

/** GENTRIAD: 代次 hygiene 独立门（三端同名同值、默认关）；只管防伪日志。 */
static bool isyncSeedFrameBoundaryEnabled() {
	return MGBAX_ISYNC_SEED_FRAME_BOUNDARY != 0
	    || qEnvironmentVariableIntValue("MGBAX_ISYNC_SEED_FRAME_BOUNDARY") != 0;
}

/** 每实例唯一单调代次源（进程内），与 Android SEED_SET_GEN / iOS 静态计数器同义。 */
static std::atomic<qint64> s_nextSeedGen{0};
static qint64 nextSeedGen() {
	return s_nextSeedGen.fetch_add(1, std::memory_order_relaxed) + 1;
}

} // namespace

namespace QGBA {

/* ISYNC-EV: 具名总门 MGBAX_ISYNC_EVIDENCE + 子开关 MGBAX_ISYNC_EVIDENCE_A1
 * （三端同名同值、默认关，独立于 MGBAX_ISYNC_STATE_APPLY）。只读观测门。 */
bool isyncEvidenceA1Enabled() {
	const bool macroOn = MGBAX_ISYNC_EVIDENCE != 0 && MGBAX_ISYNC_EVIDENCE_A1 != 0;
	const bool envOn = qEnvironmentVariableIntValue("MGBAX_ISYNC_EVIDENCE") != 0
	                && qEnvironmentVariableIntValue("MGBAX_ISYNC_EVIDENCE_A1") != 0;
	return macroOn || envOn;
}

QByteArray isyncSeedSha256Hex(const QByteArray& seed) {
	return QCryptographicHash::hash(seed, QCryptographicHash::Sha256).toHex();
}

void isyncEvidenceLogSeedSend(const QByteArray& seed, const char* path) {
	if (seed.isEmpty() || path == nullptr || !isyncEvidenceA1Enabled()) {
		return;
	}
	qInfo().noquote() << QStringLiteral("[ISYNC-EV][A1-SEND] role=PC path=%1 bytes=%2 sha256=%3")
	                            .arg(QString::fromLatin1(path)).arg(seed.size())
	                            .arg(QString::fromLatin1(isyncSeedSha256Hex(seed)));
}

} // namespace QGBA

GBoyMirror::GBoyMirror(QObject* parent)
	: QThread(parent)
	, m_instanceGen(nextSeedGen())
{
}

void GBoyMirror::setCurrentGenReader(std::function<qint64()> reader) {
	std::lock_guard<std::mutex> locker(m_stateMutex);
	m_currentGenReader = std::move(reader);
}

qint64 GBoyMirror::currentGen() {
	std::function<qint64()> reader;
	{
		std::lock_guard<std::mutex> locker(m_stateMutex);
		reader = m_currentGenReader;
	}
	/* 未注入读取器时用 m_activeGen：start 后置 instanceGen、stopMirror 前置 -1，
	 * 使 teardown 窗口的残留 seed 被 stale 丢弃（PC 无跨线程重建，天然恒等）。 */
	return reader ? reader() : m_activeGen.load(std::memory_order_relaxed);
}

bool GBoyMirror::start(const QString& romPath, const QString& primarySavePath,
                       const QString& mirrorRoot, quint16 primaryPort, int primaryLocalKey,
                       GBoyLinkSession* session, int slot, int players, bool lockstep,
                       int navIdx, int navMenuAt, int navModeDowns,
                       const QByteArray& saveSnapshot, const QString& scriptDir,
                       QString* error) {
	if (m_running.load(std::memory_order_relaxed)) {
		if (error) {
			*error = QStringLiteral("镜像控制台已在运行");
		}
		return false;
	}
	if (romPath.isEmpty() || !QFileInfo::exists(romPath)) {
		if (error) {
			*error = QStringLiteral("镜像加载失败：ROM 不存在");
		}
		return false;
	}
	QDir root(mirrorRoot);
	if (!root.mkpath(QStringLiteral("."))) {
		if (error) {
			*error = QStringLiteral("无法创建镜像目录 %1").arg(mirrorRoot);
		}
		return false;
	}
	QString stateRoot = root.filePath(QStringLiteral("state"));
	QDir().mkpath(stateRoot);
	// Determinism: every mirror boots from the SAME byte-for-byte snapshot of
	// the local save. The old code called QFile::copy() per mirror: it fails
	// when the target already exists (so a stale save from the previous session
	// was silently reused), and re-reads a source that the visible core may
	// have rewritten between iterations. Four cores with different starting
	// progress never complete the SIO handshake (Android showed this too).
	QString saveTarget = root.filePath(saveNameFor(romPath));
	if (!saveSnapshot.isEmpty()) {
		QFile::remove(saveTarget);
		QFile out(saveTarget);
		if (!out.open(QIODevice::WriteOnly)
		    || out.write(saveSnapshot) != saveSnapshot.size()) {
			if (error) {
				*error = QStringLiteral("无法把存档快照写入镜像目录：")
				         + out.errorString();
			}
			return false;
		}
	} else {
		QFile saveSource(primarySavePath);
		if (!primarySavePath.isEmpty() && saveSource.exists()) {
			QFile::remove(saveTarget);
			if (!saveSource.copy(saveTarget)) {
				if (error) {
					*error = QStringLiteral("无法复制本机存档到镜像目录：")
					         + saveSource.errorString();
				}
				return false;
			}
		}
	}
	m_session = session;
	m_slot = slot;
	m_players = players;
	m_emu = mgbaMobileCreate(root.path().toUtf8().constData(),
	                         stateRoot.toUtf8().constData(), "pcmirror");
	if (!m_emu) {
		if (error) {
			*error = QStringLiteral("镜像控制台创建失败");
		}
		return false;
	}
	if (!mgbaMobileLoad(m_emu, romPath.toUtf8().constData())) {
		mgbaMobileDestroy(m_emu);
		m_emu = nullptr;
		if (error) {
			*error = QStringLiteral("镜像核心加载 ROM 失败: ") + romPath;
		}
		return false;
	}
	m_scriptDir = scriptDir;
	m_navIdx = navIdx;
	m_fallbackNavMenuAt = navMenuAt > 0 ? navMenuAt : 1500;
	m_fallbackNavModeDowns = navModeDowns >= 0 ? navModeDowns : 2;
	if (navIdx >= 0) {
		/* 与 Android GBoyConsoleSet.setBusGame() 对称：四个核从同一瞬间起跑
		 * 同一份 busgame 导航，navIdx 决定 4P 座位。但这里不再立即武装脚本——
		 * 立即武装会让镜像核各自比可见核早跑几百~上千帧（start() 里还隔着 3 次
		 * ROM 加载与 LINK_CONNECTED 等待），四核一进菜单子状态就分裂。改成
		 * 记下 pending，run() 里轮询 <scriptDir>/nav_at，CloudLink 在三个镜像核
		 * 都就绪后才写它，可见核也读同一文件武装：四核同一帧起跑，相位一致。
		 * 可见核（ScriptedControl）读完 nav_at 不删文件，镜像核随后也能读到。 */
		m_pendingNavIdx = navIdx;
	}
	// The primary hosts the bus (SioLinkHost::sioHostPlayers, pumped by the
	// core thread's finishFrame); the mirror joins it. path B keeps all four
	// cores in this process, so the bus is the in-process LocalBus keyed by
	// primaryLocalKey; the TCP branch only exists for A/B experiments.
	bool joined = false;
	int joinAttempts = 0;
	const qint64 joinT0 = QDateTime::currentMSecsSinceEpoch();
	for (int attempt = 0; attempt < 50 && !joined; ++attempt) {
		++joinAttempts;
		if (lockstep) {
			/* 已证明能 4 核进对战的路径：进程内 GBASIOLockstepCoordinator。
			 * 可见核由 CoreController::lanLinkHostLockstep 创建同一 key 的房间。 */
			joined = mgbaMobileLinkJoinLockstep(m_emu, primaryLocalKey, slot - 1);
		} else if (primaryLocalKey > 0) {
			/* 全局槽位 2/3/4 → 总线槽位 1/2/3（0 归可见核/主机）。 */
			joined = mgbaMobileLinkJoinLocalSlot(m_emu, primaryLocalKey, slot - 1);
		} else {
			joined = mgbaMobileLinkJoin(m_emu, "127.0.0.1", int(primaryPort), m_players);
		}
		if (!joined) {
			QThread::msleep(20);
		}
	}
	if (!joined) {
		mgbaMobileDestroy(m_emu);
		m_emu = nullptr;
		if (error) {
			*error = lockstep
			        ? QStringLiteral("镜像核心无法加入本机锁步房间 key=%1").arg(primaryLocalKey)
			        : primaryLocalKey > 0
			        ? QStringLiteral("镜像核心无法加入本机总线 key=%1").arg(primaryLocalKey)
			        : QStringLiteral("镜像核心无法连上环回端口 %1").arg(primaryPort);
		}
		return false;
	}
	const QByteArray busDesc = lockstep
	        ? QByteArray("lock:") + QByteArray::number(primaryLocalKey)
	        : primaryLocalKey > 0
	        ? QByteArray("local:") + QByteArray::number(primaryLocalKey)
	        : QByteArray("tcp:") + QByteArray::number(primaryPort);
	fprintf(stderr, "[GBoyMirror] join slot=%d bus=%s attempts=%d %lldms\n", slot,
	        busDesc.constData(), joinAttempts,
	        static_cast<long long>(QDateTime::currentMSecsSinceEpoch() - joinT0));
	// Wait until the loopback netLink session reports LINK_CONNECTED (2)
	// before the pump starts, so the first MULTI rounds of the game are not
	// dropped. The status text starts with the state number.
	{
		char status[256] = {0};
		const qint64 waitT0 = QDateTime::currentMSecsSinceEpoch();
		qint64 deadline = waitT0 + LINK_WAIT_MS;
		while (QDateTime::currentMSecsSinceEpoch() < deadline) {
			mgbaMobilePumpLink(m_emu);
			mgbaMobileLinkStatus(m_emu, status, sizeof(status));
			int state = QString::fromUtf8(status).section(' ', 0, 0).toInt();
			if (state == 2) {
				break;
			}
			QThread::msleep(20);
		}
		/* path B 四核握手的前提是三个镜像核都真的进了环回总线。start() 过去
		 * 在 4s 超时后**无条件继续**，于是「没连上」的镜像核静默地以 state=1
		 * 跑完整个回合，可见核看到的就是 st=0 / pc=0（PB13 现场：每个镜像核
		 * 恰好耗满 4s，最终一个 SIO 轮次都没有）。这行日志把超时现场钉下来。 */
		mgbaMobileLinkStatus(m_emu, status, sizeof(status));
		if (QString::fromUtf8(status).section(' ', 0, 0).toInt() != 2) {
			fprintf(stderr, "[GBoyMirror] !! link wait TIMEOUT slot=%d after %lldms: %s\n",
			        slot, static_cast<long long>(QDateTime::currentMSecsSinceEpoch() - waitT0),
			        status);
		}
	}
	m_running.store(true, std::memory_order_relaxed);
	/* GENTRIAD: 活动代次在本核起跑时生效（未注入读取器时的当前 gen 源）。 */
	m_activeGen.store(m_instanceGen, std::memory_order_relaxed);
	QThread::start();
	return true;
}

void GBoyMirror::stopMirror() {
	if (!m_running.exchange(false, std::memory_order_relaxed)) {
		return;
	}
	/* GENTRIAD: 先失效代次再 join/destroy（与 Android stopGBoyLink 同序）：
	 * teardown 窗口内残留 seed 在帧边界二次校验处 SEED_DROPPED_STALE，
	 * 不灌进即将销毁的旧核；join/destroy 顺序保持不变。 */
	m_activeGen.store(-1, std::memory_order_relaxed);
	wait(3000);
	if (m_emu) {
		mgbaMobileLinkClose(m_emu);
		mgbaMobileDestroy(m_emu);
		m_emu = nullptr;
	}
	m_session = nullptr;
}

void GBoyMirror::run() {
	/* 用微秒累计，倍速 4x 的 4.17ms 帧间隔不会被整数毫秒截成 4ms。 */
	qint64 nextFrame = QDateTime::currentMSecsSinceEpoch() * 1000;
	/* [mirror] 现场日志节流：可见核的 [diag] 看不到镜像核，四核握手卡住时
	 * 必须知道是哪一个镜像核停在 HANDSHAKE（PB12 现场只能看到可见核
	 * state=2/st=0）。120 帧 ≈ 2 秒，一次 240 秒的运行每核约 120 行。 */
	unsigned diagFrame = 0;
	while (m_running.load(std::memory_order_relaxed) && m_emu) {
		/* 云端 4P 闭环导航的同步闸门：脚本未武装前，本核只用网络按键（本地
		 * 4 人房间中镜像核的 slot 无远端输入，等效空操作），停在标题画面等待。
		 * nav_at 一旦被 CloudLink 写好，四核（可见核 + 3 镜像）在同一次轮询窗口
		 * 内全部武装，从帧 0 同相位起跑 busgame 导航。 */
		if (m_pendingNavIdx >= 0 && !m_scriptDir.isEmpty()) {
			QFile navAt(m_scriptDir + QStringLiteral("/nav_at"));
			if (navAt.exists() && navAt.open(QIODevice::ReadOnly)) {
				const QList<QByteArray> parts = navAt.readAll().trimmed().split(' ');
				navAt.close();
				int menuAt = m_fallbackNavMenuAt;
				int modeDowns = m_fallbackNavModeDowns;
				bool ok = false;
				const int v = parts.value(0).toInt(&ok);
				if (ok) {
					menuAt = v;
				}
				if (parts.size() > 1) {
					ok = false;
					const int d = parts.value(1).toInt(&ok);
					if (ok) {
						modeDowns = d;
					}
				}
				mgbaMobileBusGameStart(m_emu, m_pendingNavIdx, menuAt, modeDowns);
				qInfo().noquote() << QStringLiteral("[GBoyMirror] nav armed idx=%1 menuAt=%2 modeDowns=%3")
				                            .arg(m_pendingNavIdx).arg(menuAt).arg(modeDowns);
				m_pendingNavIdx = -1;
			}
		}
		GBoyLinkSession* session = m_session;
		/* 对端存档：只在帧边界载入，避免与正在执行的指令流抢。
		 * 官方 case 6 是「载入 → reset(false)」，但官方的 reset 是 libgboy 的
		 * native 软复位；我们的 mgbaMobileReset 走 GBAReset → GBAMemoryReset，
		 * 会 memset 清掉 EWRAM 256K + IWRAM 32K —— load 已经完整恢复了状态，
		 * 再 reset 等于把刚载入的存档抹掉（现象：握手成功却停在开机画面）。
		 * 因此 type 6 **只载入不复位**，复位只由 type 5 / requestReset() 触发。
		 * 载入结果按官方错误码（0 / -5 / 1）回调给 CloudLink，失败要断链。 */
		QByteArray incoming;
		std::function<void(int)> stateResult;
		qint64 pendingGen = -1;
		if (takePendingState(&incoming, &stateResult, &pendingGen)) {
			/* GENTRIAD: 代次 hygiene——只在独立门开时做 stale 校验。语义防伪，
			 * 不是内存安全守卫；不 bump gen 造里程碑，不补造 seed。stale 包
			 * 只丢弃并打日志，不 load、不打 loaded、不回回调造成功/失败。 */
			bool stale = false;
			if (isyncSeedFrameBoundaryEnabled()) {
				const qint64 cur = currentGen();
				if (cur != m_instanceGen || pendingGen != m_instanceGen) {
					qInfo().noquote() << QStringLiteral("[ISYNC] SEED_DROPPED_STALE gen=%1 current=%2 slot=%3 bytes=%4")
					                            .arg(pendingGen).arg(cur)
					                            .arg(m_slot).arg(incoming.size());
					stale = true;
				}
			}
			/* stale 只跳过本包的 load；下方 setKeys/pumpLink/runFrames 照常推进本帧。 */
			if (!stale) {
				int appliedCount = 0;
				int result = mgbaMobileLoadStateFromMemoryEx(m_emu, incoming.constData(),
				                                             size_t(incoming.size()));
				if (result == 0) {
					m_appliedStates.fetch_add(1, std::memory_order_relaxed);
					if (isyncSeedFrameBoundaryEnabled()) {
						/* applied_count 按 (seed hash, 代次 gen) 计；只认真 load==0。
						 * 同一 gen 同 hash 再次出现即 >1（双灌，fail-fast 可查）。 */
						const QString key = QStringLiteral("%1/%2")
						                        .arg(isyncStateHash(incoming), 0, 16)
						                        .arg(pendingGen);
						appliedCount = ++m_appliedByKey[key];
					}
					qInfo().noquote() << QStringLiteral("[GBoyMirror] applied peer state %1 bytes slot %2")
					                            .arg(incoming.size()).arg(m_slot);
					/* ISYNC-EV/A1-LAND: 真 load 成功后落地种子的 sha256+字节数+真槽，
					 * 供 C5 判 land[PC] ⊆ send[APP]。只读观测，不造 seed/party/信任位；
					 * 措辞避开 applied/loaded/ok 词表，防 driver 正则假阳性。 */
					if (isyncEvidenceA1Enabled()) {
						qInfo().noquote() << QStringLiteral("[ISYNC-EV][A1-LAND] role=PC slot=%1 bytes=%2 sha256=%3")
						                            .arg(m_slot).arg(incoming.size())
						                            .arg(QString::fromLatin1(isyncSeedSha256Hex(incoming)));
					}
					/* ISYNC1: 三端对齐的里程碑——只在真正 load 成功后打，Android/iOS
					 * 同口径。种子块 hash 供 E2E 核对两端收到的是否同一份真实存档。 */
					if (isyncStateApplyEnabled()) {
						QString loaded = QStringLiteral("[ISYNC] remote state loaded slot=%1 bytes=%2 hash=%3")
						                     .arg(m_slot).arg(incoming.size())
						                     .arg(isyncStateHash(incoming), 0, 16);
						if (isyncSeedFrameBoundaryEnabled()) {
							/* frame=na：PC 路径无 TYPE_STATE_FRAMED 帧号，不伪造帧号。 */
							loaded += QStringLiteral(" frame=na gen=%1 applied_count=%2")
							              .arg(pendingGen).arg(appliedCount);
						}
						qInfo().noquote() << loaded;
					}
				} else {
					qInfo().noquote() << QStringLiteral("[GBoyMirror] peer state rejected (%1 bytes, code %2)")
					                            .arg(incoming.size()).arg(result);
				}
				if (stateResult) {
					stateResult(result);
				}
			}
		}
		if (m_resetRequested.exchange(false, std::memory_order_relaxed)) {
			/* 官方 type 5：reset(false)。落在 frame boundary，不打断指令流。 */
			mgbaMobileReset(m_emu);
			qInfo().noquote() << QStringLiteral("[GBoyMirror] peer reset, slot %1").arg(m_slot);
		}
		int keys = session ? session->keysForSlot(m_slot) : 0;
		mgbaMobileSetKeys(m_emu, quint32(keys));
		mgbaMobilePumpLink(m_emu);
		mgbaMobileRunFrames(m_emu, 1);
		if (++diagFrame % 120 == 0) {
			mgbaMobileMirrorDiag(m_emu, m_navIdx, m_slot);
		}
		/* 官方 AaHO0E 的帧闸对所有本机核一致：可见核 4x 时镜像核也必须 4x，
		 * 否则 SIO 两端推进速度不同，很快卡死/花屏。 */
		const double speed = m_netSpeed.load(std::memory_order_relaxed);
		nextFrame += qint64(FRAME_INTERVAL_US / (speed > 0 ? speed : 1.0));
		const qint64 nowUs = QDateTime::currentMSecsSinceEpoch() * 1000;
		long sleep = long((nextFrame - nowUs) / 1000);
		if (sleep > 0) {
			QThread::msleep(unsigned(sleep));
		} else {
			// Fell behind: resync the pace instead of bursting frames.
			nextFrame = nowUs;
		}
	}
}

int GBoyMirror::applyRemoteState(const QByteArray& state, std::function<void(int)> result) {
	if (!m_emu || state.isEmpty()) {
		return 1;
	}
	/* 官方 type 6 的 -5 = 状态尺寸不符。但 mGBA 的 savestate 是**变长**的
	 * （分块压缩），同一 ROM、同一存档在不同运行时刻长度也不一样 —— 实测同一局
	 * 里出现过 45185 / 45244 / 46322 / 47309 四种长度。原先用
	 * 「对端长度 >= 本核 stateSize」做同步判定，等价于**必失败**：两端 state
	 * 长度永远对不上，type-6 全被判 -5，连接 30ms 内必断（path B 2P 实测：
	 * `TYPE_STATE rejected before queue (code -5)` → 「对端存档尺寸不符（错误码 3）」
	 * → 镜像核从未被灌进去 → pc 恒 0、intr 恒 0）。
	 * 现在只做基本合理性校验，成功与否交给镜像线程里真正的 load 返回值。 */
	const size_t kMaxStateBytes = 16u * 1024u * 1024u;
	if (state.isEmpty() || size_t(state.size()) > kMaxStateBytes) {
		return -5;
	}
	// 只入队：真正的 load 在镜像线程的帧边界执行（见 run()）。
	std::lock_guard<std::mutex> locker(m_stateMutex);
	m_pendingState = state;
	m_pendingResult = std::move(result);
	/* GENTRIAD: 入队瞬间打本实例 gen 戳（三端对称），帧边界消费时二次校验。 */
	m_pendingGen = m_instanceGen;
	m_hasPendingState = true;
	return 0;
}

void GBoyMirror::requestReset() {
	m_resetRequested.store(true, std::memory_order_relaxed);
}

void GBoyMirror::setNetSpeed(float speed) {
	m_netSpeed.store(speed > 0.f ? speed : 1.f, std::memory_order_relaxed);
}

bool GBoyMirror::takePendingState(QByteArray* out, std::function<void(int)>* result, qint64* outGen) {
	std::lock_guard<std::mutex> locker(m_stateMutex);
	if (!m_hasPendingState) {
		return false;
	}
	*out = m_pendingState;
	*result = std::move(m_pendingResult);
	*outGen = m_pendingGen;
	m_pendingResult = nullptr;
	m_pendingState.clear();
	m_pendingGen = -1;
	m_hasPendingState = false;
	return true;
}
