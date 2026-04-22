param(
  [string]$RepoRoot = "."
)

$ErrorActionPreference = "Stop"

$repo = Resolve-Path $RepoRoot
Set-Location $repo

Write-Host "[docs] Lint OpenAPI"
npx --yes @redocly/cli@latest lint docs/openapi.yaml

Write-Host "[docs] Bundle OpenAPI JSON"
npx --yes @redocly/cli@latest bundle docs/openapi.yaml -o docs/openapi.json --ext json

Write-Host "[docs] Sync static assets"
New-Item -ItemType Directory -Force -Path "docs/site/static" | Out-Null
Copy-Item "docs/openapi.yaml" "docs/site/static/openapi.yaml" -Force
Copy-Item "docs/openapi.json" "docs/site/static/openapi.json" -Force

Write-Host "[docs] Build docs site"
Push-Location "docs/site"
npm install
npm run build
Pop-Location

Write-Host "[docs] Completed"
