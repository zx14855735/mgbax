# Poll mgbax CI run status via GCM token (write to tmp file, do not echo token)
$in = "protocol=https`nhost=github.com`n`n"
$out = $in | git credential fill 2>$null
if (-not $out) { Write-Output "CRED_FAIL"; exit 1 }
$tok = ($out | Select-String -Pattern '^password=')
if (-not $tok) { Write-Output "NO_TOKEN"; exit 1 }
$tok = $tok.ToString().Substring(9)
$h = @{ Authorization = "Bearer $tok"; Accept = 'application/vnd.github+json' }
$runs = Invoke-RestMethod -Uri 'https://api.github.com/repos/zx14855735/mgbax/actions/runs?per_page=8' -Headers $h
foreach ($r in $runs.workflow_runs) {
    "{0,-16} #{1,-4} {2,-12} {3,-10} head={4}" -f $r.name, $r.run_number, $r.status, $r.conclusion, $r.head_sha.Substring(0,7)
}
