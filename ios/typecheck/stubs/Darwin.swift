// Darwin/POSIX 的最小替身。
//
// 说明：真 Darwin 模块里这些都是 C 声明（由 Clang importer 导入），
// 这里用 Swift 等价声明近似表达。sizeof 类的行为不影响类型检查。

public typealias socklen_t = UInt32
public typealias sa_family_t = UInt8
public typealias in_port_t = UInt16
public typealias in_addr_t = UInt32

public struct in_addr {
    public var s_addr: in_addr_t
    public init() { s_addr = 0 }
    public init(s_addr: in_addr_t) { self.s_addr = s_addr }
}

public struct sockaddr {
    public var sa_len: UInt8
    public var sa_family: sa_family_t
    public var sa_data: (CChar, CChar, CChar, CChar, CChar, CChar, CChar, CChar,
                          CChar, CChar, CChar, CChar, CChar, CChar)
    public init() {
        sa_len = 0; sa_family = 0
        sa_data = (0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    }
}

public struct sockaddr_in {
    public var sin_len: UInt8
    public var sin_family: sa_family_t
    public var sin_port: in_port_t
    public var sin_addr: in_addr
    public var sin_zero: (CChar, CChar, CChar, CChar, CChar, CChar, CChar, CChar)
    public init() {
        sin_len = 0; sin_family = 0; sin_port = 0; sin_addr = in_addr()
        sin_zero = (0, 0, 0, 0, 0, 0, 0, 0)
    }
}

public struct sockaddr_storage {
    public var ss_len: UInt8
    public var ss_family: sa_family_t
    public init() { ss_len = 0; ss_family = 0 }
}

public struct timeval {
    public var tv_sec: Int
    public var tv_usec: Int32
    public init() { tv_sec = 0; tv_usec = 0 }
    public init(tv_sec: Int, tv_usec: Int32) { self.tv_sec = tv_sec; self.tv_usec = tv_usec }
}

public struct timezone {
    public var tz_minuteswest: Int32
    public var tz_dsttime: Int32
    public init() { tz_minuteswest = 0; tz_dsttime = 0 }
}

public struct fd_set {
    public var storage: (Int32, Int32, Int32, Int32, Int32, Int32, Int32, Int32,
                         Int32, Int32, Int32, Int32, Int32, Int32, Int32, Int32,
                         Int32, Int32, Int32, Int32, Int32, Int32, Int32, Int32,
                         Int32, Int32, Int32, Int32, Int32, Int32, Int32, Int32)
    public init() {
        storage = (0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                   0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    }
}

public struct addrinfo {
    public var ai_flags: Int32
    public var ai_family: Int32
    public var ai_socktype: Int32
    public var ai_protocol: Int32
    public var ai_addrlen: socklen_t
    public var ai_canonname: UnsafeMutablePointer<CChar>!
    public var ai_addr: UnsafeMutablePointer<sockaddr>!
    public var ai_next: UnsafeMutablePointer<addrinfo>!
    public init() {
        ai_flags = 0; ai_family = 0; ai_socktype = 0; ai_protocol = 0; ai_addrlen = 0
        ai_canonname = nil; ai_addr = nil; ai_next = nil
    }
}

public typealias nfds_t = UInt32

public struct pollfd {
    public var fd: Int32
    public var events: Int16
    public var revents: Int16
    public init() { fd = -1; events = 0; revents = 0 }
    public init(fd: Int32, events: Int16, revents: Int16) { self.fd = fd; self.events = events; self.revents = revents }
}

// 数学函数（Darwin libm）
public func sqrt(_ x: Double) -> Double { 0 }
public func sqrtf(_ x: Float) -> Float { 0 }
public func pow(_ x: Double, _ y: Double) -> Double { 0 }
public func powf(_ x: Float, _ y: Float) -> Float { 0 }
public func fabs(_ x: Double) -> Double { 0 }
public func fabsf(_ x: Float) -> Float { 0 }
public func floor(_ x: Double) -> Double { 0 }
public func ceil(_ x: Double) -> Double { 0 }
public func round(_ x: Double) -> Double { 0 }
public func sin(_ x: Double) -> Double { 0 }
public func cos(_ x: Double) -> Double { 0 }
public func tan(_ x: Double) -> Double { 0 }
public func asin(_ x: Double) -> Double { 0 }
public func acos(_ x: Double) -> Double { 0 }
public func atan(_ x: Double) -> Double { 0 }
public func atan2(_ y: Double, _ x: Double) -> Double { 0 }
public func exp(_ x: Double) -> Double { 0 }
public func log(_ x: Double) -> Double { 0 }
public func log2(_ x: Double) -> Double { 0 }
public func log10(_ x: Double) -> Double { 0 }
public func fmod(_ x: Double, _ y: Double) -> Double { 0 }
public func fmin(_ x: Double, _ y: Double) -> Double { 0 }
public func fmax(_ x: Double, _ y: Double) -> Double { 0 }
public func hypot(_ x: Double, _ y: Double) -> Double { 0 }

public struct linger {
    public var l_onoff: Int32
    public var l_linger: Int32
    public init() { l_onoff = 0; l_linger = 0 }
}

// 常量（Darwin 上是宏，Swift 里是 Int32）
public let AF_UNSPEC: Int32 = 0
public let AF_UNIX: Int32 = 1
public let AF_INET: Int32 = 2
public let AF_INET6: Int32 = 30

public let SOCK_STREAM: Int32 = 1
public let SOCK_DGRAM: Int32 = 2
public let SOCK_RAW: Int32 = 3

public let SOL_SOCKET: Int32 = 0xffff
public let SO_DEBUG: Int32 = 0x0001
public let SO_REUSEADDR: Int32 = 0x0004
public let SO_KEEPALIVE: Int32 = 0x0008
public let SO_DONTROUTE: Int32 = 0x0010
public let SO_RCVTIMEO: Int32 = 0x1006
public let SO_SNDTIMEO: Int32 = 0x1005
public let SO_ERROR: Int32 = 0x1007
public let SO_NOSIGPIPE: Int32 = 0x1022
public let SO_LINGER: Int32 = 0x0080
public let SO_RCVBUF: Int32 = 0x1002
public let SO_SNDBUF: Int32 = 0x1001

public let IPPROTO_IP: Int32 = 0
public let IPPROTO_TCP: Int32 = 6
public let IPPROTO_UDP: Int32 = 17
public let TCP_NODELAY: Int32 = 0x01
public let TCP_KEEPALIVE: Int32 = 0x10
public let TCP_KEEPCNT: Int32 = 0x102
public let TCP_KEEPINTVL: Int32 = 0x101
public let TCP_MAXSEG: Int32 = 0x02

public let MSG_OOB: Int32 = 0x1
public let MSG_PEEK: Int32 = 0x2
public let MSG_DONTROUTE: Int32 = 0x4
public let MSG_NOSIGNAL: Int32 = 0x80000

public let SHUT_RD: Int32 = 0
public let SHUT_WR: Int32 = 1
public let SHUT_RDWR: Int32 = 2

public let O_RDONLY: Int32 = 0
public let O_WRONLY: Int32 = 1
public let O_RDWR: Int32 = 2
public let O_NONBLOCK: Int32 = 0x0004
public let O_CLOEXEC: Int32 = 0x1000000
public let F_GETFL: Int32 = 3
public let F_SETFL: Int32 = 4
public let F_GETFD: Int32 = 1
public let F_SETFD: Int32 = 2
public let FD_CLOEXEC: Int32 = 1

public let AI_PASSIVE: Int32 = 0x0001
public let AI_CANONNAME: Int32 = 0x0002
public let AI_NUMERICHOST: Int32 = 0x0004
public let AI_NUMERICSERV: Int32 = 0x1000

public let POLLIN: Int16 = 0x0001
public let POLLPRI: Int16 = 0x0002
public let POLLOUT: Int16 = 0x0004
public let POLLERR: Int16 = 0x0008
public let POLLHUP: Int16 = 0x0010
public let POLLNVAL: Int16 = 0x0020

public let INADDR_ANY: in_addr_t = 0
public let INADDR_NONE: in_addr_t = 0xffffffff

public let EOF: Int32 = -1
public let FD_SETSIZE: Int32 = 1024

// errno
public let EPERM: Int32 = 1
public let ENOENT: Int32 = 2
public let EINTR: Int32 = 4
public let EIO: Int32 = 5
public let EBADF: Int32 = 9
public let EAGAIN: Int32 = 35
public let EWOULDBLOCK: Int32 = 35
public let EINPROGRESS: Int32 = 36
public let EALREADY: Int32 = 37
public let ENOTSOCK: Int32 = 38
public let EPROTONOSUPPORT: Int32 = 43
public let EADDRINUSE: Int32 = 48
public let EADDRNOTAVAIL: Int32 = 49
public let ENETDOWN: Int32 = 50
public let ENETUNREACH: Int32 = 51
public let ECONNABORTED: Int32 = 53
public let ECONNRESET: Int32 = 54
public let ENOBUFS: Int32 = 55
public let EISCONN: Int32 = 56
public let ENOTCONN: Int32 = 57
public let ETIMEDOUT: Int32 = 60
public let ECONNREFUSED: Int32 = 61
public let EHOSTUNREACH: Int32 = 65
public let EPIPE: Int32 = 32
public let EOVERFLOW: Int32 = 84

public var errno: Int32 = 0

// MARK: - 函数

public func socket(_ domain: Int32, _ type: Int32, _ protocol: Int32) -> Int32 { -1 }
public func socket(_ domain: Int32, _ type: Int32, _ protocol: Int32, _ extra: Int32) -> Int32 { -1 }
public func close(_ fd: Int32) -> Int32 { -1 }
public func connect(_ socket: Int32, _ address: UnsafePointer<sockaddr>!, _ addressLen: socklen_t) -> Int32 { -1 }
public func bind(_ socket: Int32, _ address: UnsafePointer<sockaddr>!, _ addressLen: socklen_t) -> Int32 { -1 }
public func listen(_ socket: Int32, _ backlog: Int32) -> Int32 { -1 }
public func accept(_ socket: Int32, _ address: UnsafeMutablePointer<sockaddr>?, _ addressLen: UnsafeMutablePointer<socklen_t>?) -> Int32 { -1 }
public func shutdown(_ socket: Int32, _ how: Int32) -> Int32 { -1 }
public func send(_ socket: Int32, _ buf: UnsafeRawPointer?, _ len: Int, _ flags: Int32) -> Int { -1 }
public func sendto(_ socket: Int32, _ buf: UnsafeRawPointer?, _ len: Int, _ flags: Int32, _ destAddr: UnsafePointer<sockaddr>?, _ destLen: socklen_t) -> Int { -1 }
public func recv(_ socket: Int32, _ buf: UnsafeMutableRawPointer?, _ len: Int, _ flags: Int32) -> Int { -1 }
public func read(_ fd: Int32, _ buf: UnsafeMutableRawPointer?, _ nbyte: Int) -> Int { -1 }
public func write(_ fd: Int32, _ buf: UnsafeRawPointer?, _ nbyte: Int) -> Int { -1 }
public func readlink(_ path: UnsafePointer<CChar>, _ buf: UnsafeMutablePointer<CChar>, _ bufsize: Int) -> Int { -1 }
public func recvfrom(_ socket: Int32, _ buf: UnsafeMutableRawPointer?, _ len: Int, _ flags: Int32, _ fromAddr: UnsafeMutablePointer<sockaddr>?, _ fromLen: UnsafeMutablePointer<socklen_t>?) -> Int { -1 }
public func setsockopt(_ socket: Int32, _ level: Int32, _ optionName: Int32, _ optionValue: UnsafeRawPointer?, _ optionLen: socklen_t) -> Int32 { -1 }
public func getsockopt(_ socket: Int32, _ level: Int32, _ optionName: Int32, _ optionValue: UnsafeMutableRawPointer?, _ optionLen: UnsafeMutablePointer<socklen_t>?) -> Int32 { -1 }
public func select(_ nfds: Int32, _ readfds: UnsafeMutablePointer<fd_set>?, _ writefds: UnsafeMutablePointer<fd_set>?, _ exceptfds: UnsafeMutablePointer<fd_set>?, _ timeout: UnsafeMutablePointer<timeval>?) -> Int32 { -1 }
public func poll(_ fds: UnsafeMutablePointer<pollfd>?, _ nfds: nfds_t, _ timeout: Int32) -> Int32 { -1 }
public func fcntl(_ fd: Int32, _ cmd: Int32, _ value: Int32) -> Int32 { -1 }
public func fcntl(_ fd: Int32, _ cmd: Int32) -> Int32 { -1 }
public func ioctl(_ fd: Int32, _ request: UInt, _ value: UnsafeMutableRawPointer?) -> Int32 { -1 }
public func getaddrinfo(_ node: UnsafePointer<CChar>?, _ service: UnsafePointer<CChar>?, _ hints: UnsafePointer<addrinfo>?, _ res: UnsafeMutablePointer<UnsafeMutablePointer<addrinfo>?>?) -> Int32 { -1 }
public func freeaddrinfo(_ res: UnsafeMutablePointer<addrinfo>?) {}
public func gai_strerror(_ ecode: Int32) -> UnsafePointer<CChar> { fatalError() }
public func inet_pton(_ af: Int32, _ src: UnsafePointer<CChar>, _ dst: UnsafeMutableRawPointer) -> Int32 { -1 }
public func inet_ntop(_ af: Int32, _ src: UnsafeRawPointer, _ dst: UnsafeMutablePointer<CChar>, _ size: socklen_t) -> UnsafePointer<CChar>? { nil }
public func strerror(_ errnum: Int32) -> UnsafeMutablePointer<CChar>? { nil }
public func usleep(_ usec: UInt32) -> Int32 { 0 }
public func htons(_ x: UInt16) -> UInt16 { x }
public func ntohs(_ x: UInt16) -> UInt16 { x }
public func htonl(_ x: UInt32) -> UInt32 { x }
public func ntohl(_ x: UInt32) -> UInt32 { x }

public func arc4random() -> UInt32 { 0 }
public func arc4random_uniform(_ upperBound: UInt32) -> UInt32 { 0 }
public func getpid() -> Int32 { 0 }
public func setenv(_ name: UnsafePointer<CChar>!, _ value: UnsafePointer<CChar>!, _ overwrite: Int32) -> Int32 { 0 }
public func unsetenv(_ name: UnsafePointer<CChar>!) -> Int32 { 0 }
public func getenv(_ name: UnsafePointer<CChar>!) -> UnsafeMutablePointer<CChar>? { nil }
public func gettimeofday(_ tp: UnsafeMutablePointer<timeval>?, _ tzp: UnsafeMutableRawPointer?) -> Int32 { 0 }

// C 库
public func memcpy(_ dst: UnsafeMutableRawPointer!, _ src: UnsafeRawPointer!, _ n: Int) -> UnsafeMutableRawPointer! { dst }
public func memmove(_ dst: UnsafeMutableRawPointer!, _ src: UnsafeRawPointer!, _ n: Int) -> UnsafeMutableRawPointer! { dst }
public func memset(_ b: UnsafeMutableRawPointer!, _ c: Int32, _ n: Int) -> UnsafeMutableRawPointer! { b }
public func malloc(_ size: Int) -> UnsafeMutableRawPointer? { nil }
public func calloc(_ count: Int, _ size: Int) -> UnsafeMutableRawPointer? { nil }
public func realloc(_ ptr: UnsafeMutableRawPointer?, _ size: Int) -> UnsafeMutableRawPointer? { nil }
public func free(_ ptr: UnsafeMutableRawPointer?) {}
public func strlen(_ s: UnsafePointer<CChar>!) -> Int { 0 }
public func strcmp(_ a: UnsafePointer<CChar>!, _ b: UnsafePointer<CChar>!) -> Int32 { 0 }
public func memcmp(_ a: UnsafeRawPointer!, _ b: UnsafeRawPointer!, _ n: Int) -> Int32 { 0 }

public func withVaList<T>(_ args: CVaListPointer, _ body: (CVaListPointer) -> T) -> T { fatalError() }

// `Darwin.xxx` 限定访问（源码里确实这么写）
public enum Darwin {
    public static func close(_ fd: Int32) -> Int32 { -1 }
    public static func send(_ socket: Int32, _ buf: UnsafeRawPointer?, _ len: Int, _ flags: Int32) -> Int { -1 }
    public static func recv(_ socket: Int32, _ buf: UnsafeMutableRawPointer?, _ len: Int, _ flags: Int32) -> Int { -1 }
    public static func connect(_ socket: Int32, _ address: UnsafePointer<sockaddr>!, _ addressLen: socklen_t) -> Int32 { -1 }
    public static func accept(_ socket: Int32, _ address: UnsafeMutablePointer<sockaddr>?, _ addressLen: UnsafeMutablePointer<socklen_t>?) -> Int32 { -1 }
    public static func shutdown(_ socket: Int32, _ how: Int32) -> Int32 { -1 }
    public static func socket(_ domain: Int32, _ type: Int32, _ protocol: Int32) -> Int32 { -1 }
}

// MARK: - 网卡枚举

public struct ifaddrs {
    public var ifa_next: UnsafeMutablePointer<ifaddrs>?
    public var ifa_name: UnsafeMutablePointer<CChar>?
    public var ifa_flags: UInt32
    public var ifa_addr: UnsafeMutablePointer<sockaddr>?
    public var ifa_netmask: UnsafeMutablePointer<sockaddr>?
    public var ifa_dstaddr: UnsafeMutablePointer<sockaddr>?
    public var ifa_data: UnsafeMutableRawPointer?
    public init() {
        ifa_next = nil; ifa_name = nil; ifa_flags = 0
        ifa_addr = nil; ifa_netmask = nil; ifa_dstaddr = nil; ifa_data = nil
    }
}

public func getifaddrs(_ ifap: UnsafeMutablePointer<UnsafeMutablePointer<ifaddrs>?>?) -> Int32 { -1 }
public func freeifaddrs(_ ifa: UnsafeMutablePointer<ifaddrs>?) {}

public let IFF_UP: Int32 = 0x1
public let IFF_BROADCAST: Int32 = 0x2
public let IFF_DEBUG: Int32 = 0x4
public let IFF_LOOPBACK: Int32 = 0x8
public let IFF_POINTOPOINT: Int32 = 0x10
public let IFF_RUNNING: Int32 = 0x40
public let IFF_MULTICAST: Int32 = 0x8000

public let NI_MAXHOST: Int32 = 1025
public let NI_MAXSERV: Int32 = 32
public let NI_NUMERICHOST: Int32 = 0x2
public let NI_NUMERICSERV: Int32 = 0x8
public let NI_NAMEREQD: Int32 = 0x4

public func getnameinfo(_ sa: UnsafePointer<sockaddr>!, _ salen: socklen_t,
                        _ host: UnsafeMutablePointer<CChar>!, _ hostlen: socklen_t,
                        _ serv: UnsafeMutablePointer<CChar>!, _ servlen: socklen_t,
                        _ flags: Int32) -> Int32 { -1 }
