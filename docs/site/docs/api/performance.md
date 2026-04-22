---
sidebar_position: 9
---

# 鎬ц兘鐩戞帶鎺ュ彛

## 鎺ュ彛鍒楄〃

- `GET /performance/stats` 绯荤粺鎬ц兘姒傝
- `GET /performance/metrics/api` API 鎸囨爣
- `GET /performance/metrics/database` 鏁版嵁搴撴寚鏍?
- `GET /performance/metrics/system` 绯荤粺璧勬簮鎸囨爣
- `GET /performance/metrics/all` 鍏ㄩ噺鎸囨爣

## 鍝嶅簲鍖呰

缁熶竴杩斿洖 `Result<Map<String,Object>>`锛?

```json
{
  "code": 200,
  "message": "鎿嶄綔鎴愬姛",
  "data": {
    "apiRequestCount": 12345,
    "apiRequestDuration": 36.2
  },
  "timestamp": 1770000000000
}
```

## 寮傚父鍦烘櫙

- 鎸囨爣涓嶅瓨鍦ㄦ垨閲囬泦鍣ㄥ垵濮嬪寲澶辫触鏃讹紝`message` 鍖呭惈澶辫触鍘熷洜銆?


