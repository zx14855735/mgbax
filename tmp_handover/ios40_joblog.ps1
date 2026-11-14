# Retry: job logs via job-id endpoint; extract #39 runtime artifact
$in = "protocol=https`nhost=github.com`n`n"
$out = $in | git credential fill 2>$null
$tok = ($out | Select-String -Pattern '^password=').ToString().Substring(9)
$h = @{ Authorization = "Bearer $tok"; Accept = 'application/vnd.github+json' }

$jobs = Invoke-RestMethod -Uri 'https://api.github.com/repos/zx14855735/mgbax/actions/runs/43594730607/jobs' -Headers $h
$build = $jobs.jobs | Where-Object { $_.name -eq 'build' } | Select-Object -First 1
Write-Output ("job id=" + $build.id)
try {
    Invoke-WebRequest -Uri ("https://api.github.com/repos/zx14855735/mgbax/actions/jobs/" + $build.id + "/logs") -Headers $h -OutFile 'D:\mgba-android-version\tmp_handover\ios40_build.log' -MaximumRedirection 5
    Write-Output "JOB_LOG_OK"
} catch {
    Write-Output ("JOB_LOG_FAIL: " + $_.Exception.Message)
}
if (Test-Path 'D:\mgba-android-version\tmp_handover\ios39_runtime.zip') {
    Expand-Archive -Path 'D:\mgba-android-version\tmp_handover\ios39_runtime.zip' -DestinationPath 'D:\mgba-android-version\tmp_handover\ios39_runtime' -Force
    Get-ChildItem 'D:\mgba-android-version\tmp_handover\ios39_runtime' | ForEach-Object {
        "===== ios39 " + $_.Name + " ====="
        Get-Content $_.FullName
    }
}
