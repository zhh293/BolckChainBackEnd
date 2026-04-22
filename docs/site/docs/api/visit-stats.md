---
sidebar_position: 10
---

# 璁块棶缁熻鎺ュ彛

## 鎺ュ彛鍒楄〃

- `GET /visit-stats/overview`
- `GET /visit-stats/trend?days=30`
- `GET /visit-stats/devices?startDate=2026-04-01&endDate=2026-04-17`
- `GET /visit-stats/browsers`
- `GET /visit-stats/traffic-sources`
- `GET /visit-stats/top-pages?limit=10`
- `GET /visit-stats/performance`
- `GET /visit-stats/realtime`

## 鍙傛暟瑙勫垯

- `days`: 1-365
- `limit`: 1-100
- `startDate/endDate`: `yyyy-MM-dd`

## 澶辫触鍝嶅簲绀轰緥

```json
{
  "error": "澶╂暟蹇呴』鍦?-365涔嬮棿"
}
```

```json
{
  "error": "鑾峰彇璁块棶瓒嬪娍缁熻澶辫触"
}
```


