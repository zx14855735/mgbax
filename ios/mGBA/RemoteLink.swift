import Foundation

private func relayStatus(_ user: UnsafeMutableRawPointer?, _ text: UnsafePointer<CChar>?) {
    guard let user, let text else { return }
    let link = Unmanaged<RemoteLink>.fromOpaque(user).takeUnretainedValue()
    let value = String(cString: text)
    DispatchQueue.main.async { link.onStatus(value) }
}

private func relayRoom(_ user: UnsafeMutableRawPointer?, _ code: UnsafePointer<CChar>?, _ advertise: UnsafePointer<CChar>?) {
    guard let user, let code, let advertise else { return }
    let link = Unmanaged<RemoteLink>.fromOpaque(user).takeUnretainedValue()
    let room = String(cString: code)
    let relay = String(cString: advertise)
    DispatchQueue.main.async { link.onRoom(room, relay) }
}

private func relayHost(_ user: UnsafeMutableRawPointer?, _ port: Int32) -> Bool {
    guard let user else { return false }
    return Unmanaged<RemoteLink>.fromOpaque(user).takeUnretainedValue().hostLink(port)
}

private func relayJoin(_ user: UnsafeMutableRawPointer?, _ host: UnsafePointer<CChar>?, _ port: Int32) -> Bool {
    guard let user, let host else { return false }
    return Unmanaged<RemoteLink>.fromOpaque(user).takeUnretainedValue().joinLink(String(cString: host), port)
}

private func relayClose(_ user: UnsafeMutableRawPointer?) {
    guard let user else { return }
    Unmanaged<RemoteLink>.fromOpaque(user).takeUnretainedValue().closeLink()
}

final class RemoteLink {
    var onStatus: (String) -> Void = { _ in }
    var onRoom: (String, String) -> Void = { _, _ in }
    var hostLink: (Int32) -> Bool = { _ in false }
    var joinLink: (String, Int32) -> Bool = { _, _ in false }
    var closeLink: () -> Void = {}
    private var relay: OpaquePointer?

    init() {
        let user = Unmanaged.passUnretained(self).toOpaque()
        var hooks = MobileRelayHooks()
        hooks.user = user
        hooks.onStatus = relayStatus
        hooks.onRoom = relayRoom
        hooks.hostLink = relayHost
        hooks.joinLink = relayJoin
        hooks.closeLink = relayClose
        relay = mobileRelayCreate(hooks)
    }

    func create(relayField: String, localIp: String) {
        mobileRelayCreateRoom(relay, relayField, localIp)
    }

    func join(relayField: String, code: String) {
        mobileRelayJoinRoom(relay, relayField, code)
    }

    func close() {
        mobileRelayClose(relay)
    }

    deinit {
        mobileRelayDestroy(relay)
    }
}
