package io.mgba.android;

/**
 * 在 JVM 上直接跑 APK 里那份 RelayServer，验证「本机作中继」真的能用。
 * RelayServer / RemoteLink 只依赖 java.*，所以不需要模拟器。
 */
public final class RelayHarness {
    public static void main(String[] args) throws Exception {
        int port = args.length > 0 ? Integer.parseInt(args[0]) : 8766;
        RelayServer server = new RelayServer();
        boolean ok = server.start(port, text -> System.out.println("[relay] " + text));
        System.out.println("[relay] start=" + ok + " port=" + server.port() + " " + server.statusText());
        if (!ok) {
            System.exit(1);
        }
        long until = System.currentTimeMillis() + 180_000L;
        while (System.currentTimeMillis() < until) {
            Thread.sleep(1000);
        }
        server.stop();
    }
}
