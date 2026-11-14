# Download artifacts (lockstep-runtime-log incl. thread-sample) from iOS run #41
$in = "protocol=https`nhost=github.com`n`n"
$out = $in | git credential fill 2>$null
$tok = ($out | Select-String -Pattern '^password=').ToString().Substring(9)
$h = @{ Authorization = "Bearer $tok"; Accept = 'application/vnd.github+json' }
$runs = Invoke-RestMethod -Uri 'https://api.github.com/repos/zx14855735/mgbax/actions/runs?per_page=10' -Headers $h
$run = $runs.workflow_runs | Where-Object { $_.name -like 'iOS*' -and $_.run_number -eq 41 } | Select-Object -First 1
Write-Output ("run id=" + $run.id)
$art = Invoke-RestMethod -Uri ('https://api.github.com/repos/zx14855735/mgbax/actions/runs/' + $run.id + '/artifacts') -Headers $h
$art.artifacts | ForEach-Object { "artifact: {0}  size={1}" -f $_.name, $_.size_in_bytes }
$target = $art.artifacts | Where-Object { $_.name -eq 'lockstep-runtime-log' } | Select-Object -First 1
if ($target) {
    Invoke-WebRequest -Uri $target.archive_download_url -Headers $h -OutFile 'D:\mgba-android-version\tmp_handover\ios41_runtime.zip' -MaximumRedirection 5
    Expand-Archive -Path 'D:\mgba-android-version\tmp_handover\ios41_runtime.zip' -DestinationPath 'D:\mgba-android-version\tmp_handover\ios41_runtime' -Force
    Write-Output 'EXTRACTED'
}
