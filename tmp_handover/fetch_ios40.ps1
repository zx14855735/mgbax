# Download lockstep-runtime-log artifact from mgbax iOS run #40
$in = "protocol=https`nhost=github.com`n`n"
$out = $in | git credential fill 2>$null
$tok = ($out | Select-String -Pattern '^password=').ToString().Substring(9)
$h = @{ Authorization = "Bearer $tok"; Accept = 'application/vnd.github+json' }
$art = Invoke-RestMethod -Uri 'https://api.github.com/repos/zx14855735/mgbax/actions/runs/43594730607/artifacts' -Headers $h
foreach ($a in $art.artifacts) {
    "artifact: {0}  size={1}  id={2}" -f $a.name, $a.size_in_bytes, $a.id
}
$target = $art.artifacts | Where-Object { $_.name -like '*lockstep*' -or $_.name -like '*runtime*' } | Select-Object -First 1
if ($target) {
    Invoke-WebRequest -Uri $target.archive_download_url -Headers $h -OutFile 'D:\mgba-android-version\tmp_handover\ios40_runtime.zip' -MaximumRedirection 5
    Write-Output ("DOWNLOADED: " + $target.name)
} else {
    Write-Output "NO_RUNTIME_ARTIFACT"
}
