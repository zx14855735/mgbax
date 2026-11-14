# Download #41 build job log
$in = "protocol=https`nhost=github.com`n`n"
$out = $in | git credential fill 2>$null
$tok = ($out | Select-String -Pattern '^password=').ToString().Substring(9)
$h = @{ Authorization = "Bearer $tok"; Accept = 'application/vnd.github+json' }
$jobs = Invoke-RestMethod -Uri 'https://api.github.com/repos/zx14855735/mgbax/actions/runs/43596566231/jobs' -Headers $h
$build = $jobs.jobs | Where-Object { $_.name -eq 'build' } | Select-Object -First 1
Write-Output ("job id=" + $build.id + " conclusion=" + $build.conclusion)
Invoke-WebRequest -Uri ("https://api.github.com/repos/zx14855735/mgbax/actions/jobs/" + $build.id + "/logs") -Headers $h -OutFile 'D:\mgba-android-version\tmp_handover\ios41_build.log' -MaximumRedirection 5
Write-Output "JOB_LOG_OK"
