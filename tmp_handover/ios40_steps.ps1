# Find which job/step failed in mgbax iOS run #40
$in = "protocol=https`nhost=github.com`n`n"
$out = $in | git credential fill 2>$null
$tok = ($out | Select-String -Pattern '^password=').ToString().Substring(9)
$h = @{ Authorization = "Bearer $tok"; Accept = 'application/vnd.github+json' }
$runs = Invoke-RestMethod -Uri 'https://api.github.com/repos/zx14855735/mgbax/actions/runs?per_page=10' -Headers $h
$run = $runs.workflow_runs | Where-Object { $_.name -like 'iOS*' -and $_.run_number -eq 40 } | Select-Object -First 1
if (-not $run) { Write-Output "RUN_NOT_FOUND"; exit 1 }
Write-Output ("run id=" + $run.id + " head=" + $run.head_sha.Substring(0,7))
$jobs = Invoke-RestMethod -Uri $run.jobs_url -Headers $h
foreach ($j in $jobs.jobs) {
    "JOB: {0}  {1}/{2}" -f $j.name, $j.status, $j.conclusion
    foreach ($s in $j.steps) {
        "  step: {0,-50} {1}/{2}" -f $s.name, $s.status, $s.conclusion
    }
}
