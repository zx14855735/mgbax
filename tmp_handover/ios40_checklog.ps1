# Download the failed "Lockstep runtime check" step log of iOS run #40,
# and the runtime log artifact of green run #39 for comparison.
$in = "protocol=https`nhost=github.com`n`n"
$out = $in | git credential fill 2>$null
$tok = ($out | Select-String -Pattern '^password=').ToString().Substring(9)
$h = @{ Authorization = "Bearer $tok"; Accept = 'application/vnd.github+json' }

$jobs = Invoke-RestMethod -Uri 'https://api.github.com/repos/zx14855735/mgbax/actions/runs/43594730607/jobs' -Headers $h
$build = $jobs.jobs | Where-Object { $_.name -eq 'build' } | Select-Object -First 1
Invoke-WebRequest -Uri $build.logs_url -Headers $h -OutFile 'D:\mgba-android-version\tmp_handover\ios40_build.zip' -MaximumRedirection 5
Write-Output "JOB_LOG_DOWNLOADED"

$art = Invoke-RestMethod -Uri 'https://api.github.com/repos/zx14855735/mgbax/actions/runs/43563200229/artifacts' -Headers $h
$target = $art.artifacts | Where-Object { $_.name -eq 'lockstep-runtime-log' } | Select-Object -First 1
if ($target) {
    Invoke-WebRequest -Uri $target.archive_download_url -Headers $h -OutFile 'D:\mgba-android-version\tmp_handover\ios39_runtime.zip' -MaximumRedirection 5
    Write-Output "IOS39_ART_DOWNLOADED"
} else {
    Write-Output "NO_IOS39_ARTIFACT"
}
