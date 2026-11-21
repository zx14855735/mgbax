# 2P cloud netplay · CI self-check RESULT

- timestamp: 20261119-144316
- run dir: tests/2p-cloud/ci-run-20261119-144316
- mode: full

> **These are LOCAL gates, NOT cross-device 2P cloud E2E.**
> A green table below only means the frame layer / decision functions /
> JVM self-tests / Swift syntax are intact. It proves NO product acceptance
> and NO cross-device E2E (XD-1..XD-8 all still need two accounts, two game
> uuids and two real devices). See tests/2p-cloud/AC1-AC6-验收矩阵.md §0-D.

| gate | exit_code | ok_count | FAIL_count | verdict |
| --- | --- | --- | --- | --- |
| swift_parse_netplay | 0 | 5 | 0 | PASS |

## Summary

- PASS: 1
- FAIL: 0
- SKIPPED-LOCK: 0
- total gates: 1
- OVERALL: PASS

**LOCAL gates only — NOT cross-device 2P cloud E2E.**
See tests/2p-cloud/AC1-AC6-验收矩阵.md §0-D (XD-1..XD-8) and
tests/2p-cloud/CI-联机自检.md §4 for what these gates do NOT cover.
