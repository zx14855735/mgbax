# 2P cloud netplay · CI self-check RESULT

- timestamp: 20261120-033021
- run dir: tests/2p-cloud/ci-run-20261120-033021
- mode: full

> **These are LOCAL gates, NOT cross-device 2P cloud E2E.**
> A green table below only means the frame layer / decision functions /
> JVM self-tests / Swift syntax are intact. It proves NO product acceptance
> and NO cross-device E2E (XD-1..XD-8 all still need two accounts, two game
> uuids and two real devices). See tests/2p-cloud/AC1-AC6-验收矩阵.md §0-D.

| gate | exit_code | ok_count | FAIL_count | verdict |
| --- | --- | --- | --- | --- |
| ninja_test_gboylink | 0 | 1 | 0 | PASS |
| test_gboylink_frames | 0 | 0 | 0 | PASS |
| test_gboylink_buslocal | 0 | 0 | 0 | PASS |
| test_gboylink_product_lockstep | 0 | 0 | 0 | PASS |
| test_gboylink_c0 | 0 | 45 | 0 | PASS |
| test_gboylink_gatetest | 0 | 85 | 0 | PASS |
| test_gboylink_fastgate | 0 | 70 | 0 | PASS |
| test_gboylink_direct_order | 0 | 0 | 0 | PASS |
| ninja_mgba_mobile_test | 0 | 1 | 0 | PASS |
| mgba_mobile_test_bus | 0 | 0 | 0 | PASS |
