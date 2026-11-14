#import "mgba_mobile.h"
#import "remote_link.h"
/* GBoyConsoleSet.swift 收尾时需要唤醒仍 park 在 SIO 事件上的核。 */
#import "link_lockstep.h"

/* mgba_mobile.h 只前向声明 mCoreChannelInfo（视频层枚举用），Swift 读不到
 * id/visibleName。这里补全定义，字段顺序/类型必须与
 * include/mgba/core/interface.h 的 struct mCoreChannelInfo 完全一致。 */
struct mCoreChannelInfo {
	size_t id;
	const char* internalName;
	const char* visibleName;
	const char* visibleType;
};
