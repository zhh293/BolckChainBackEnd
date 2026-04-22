---
sidebar_position: 5
---

# 渚嬩細绠＄悊鎺ュ彛

渚嬩細绠＄悊鎺ュ彛鎻愪緵瀹為獙瀹や緥浼氫俊鎭殑绠＄悊鍔熻兘銆?
## 鎺ュ彛鍒楄〃

### 1. 鑾峰彇鎵€鏈変緥浼?
**接口**: `GET /meetings`

**鍔熻兘鎻忚堪**: 鍒嗛〉鑾峰彇鎵€鏈変緥浼?
**鏉冮檺瑕佹眰**: 鏃?
**鏌ヨ鍙傛暟**:

| 鍙傛暟鍚?| 绫诲瀷 | 蹇呭～ | 榛樿鍊?| 璇存槑 |
|--------|------|------|--------|------|
| page | integer | 鍚?| 0 | 椤电爜 |
| size | integer | 鍚?| 10 | 姣忛〉澶у皬 |
| sortBy | string | 鍚?| meetingTime | 鎺掑簭瀛楁 |
| sortDirection | string | 鍚?| DESC | 鎺掑簭鏂瑰悜锛圓SC/DESC锛?|

**璇锋眰绀轰緥**:

```bash
GET /meetings?page=0&size=10&sortBy=meetingTime&sortDirection=DESC
```

**鎴愬姛鍝嶅簲**:

| 鐘舵€佺爜 | 鏁版嵁缁撴瀯 | 璇存槑 |
|--------|----------|------|
| 200 | `Page<MeetingDto>` | 渚嬩細鍒楄〃 |

**鍝嶅簲绀轰緥**:

```json
{
  "content": [
    {
      "id": 1,
      "title": "鍖哄潡閾炬妧鏈爺璁ㄤ細",
      "description": "璁ㄨ鍖哄潡閾炬妧鏈彂灞曡秼鍔?,
      "type": "SEMINAR",
      "status": "SCHEDULED",
      "meetingDate": "2024-01-15T14:00:00",
      "location": "浼氳瀹",
      "attendees": ["寮犱笁", "鏉庡洓"],
      "minutes": "浼氳绾鍐呭...",
      "attachments": ["https://example.com/file1.pdf"],
      "displayOrder": 1,
      "createdAt": "2024-01-01T00:00:00",
      "updatedAt": "2024-01-01T00:00:00"
    }
  ],
  "pageable": {
    "pageNumber": 0,
    "pageSize": 10,
    "sort": {
      "sorted": true,
      "unsorted": false,
      "empty": false
    }
  },
  "totalElements": 1,
  "totalPages": 1,
  "size": 10,
  "number": 0,
  "sort": {
    "sorted": true,
    "unsorted": false,
    "empty": false
  },
  "first": true,
  "last": true,
  "numberOfElements": 1,
  "empty": false
}
```

---

### 2. 鍒涘缓渚嬩細

**接口**: `POST /meetings`

**鍔熻兘鎻忚堪**: 鍒涘缓鏂扮殑渚嬩細锛堥殣钘忓叆鍙ｈ闂級

**鏉冮檺瑕佹眰**: 闇€瑕佺櫥褰?
**璇锋眰浣?*:

| 瀛楁鍚?| 绫诲瀷 | 蹇呭～ | 榛樿鍊?| 鍙栧€艰寖鍥?| 涓氬姟瑙勫垯 |
|--------|------|------|--------|----------|----------|
| title | string | 鏄?| 鏃?| - | 渚嬩細鏍囬 |
| description | string | 鍚?| 鏃?| - | 渚嬩細鎻忚堪 |
| type | string | 鍚?| - | SEMINAR/PROGRESS_REPORT/TEAM_MEETING | 渚嬩細绫诲瀷 |
| status | string | 鍚?| SCHEDULED | SCHEDULED/COMPLETED/CANCELLED | 渚嬩細鐘舵€?|
| meetingDate | string | 鍚?| 鏃?| YYYY-MM-DD HH:mm:ss | 渚嬩細鏃ユ湡 |
| location | string | 鍚?| 鏃?| - | 渚嬩細鍦扮偣 |
| attendees | array | 鍚?| [] | - | 鍙備細浜哄憳 |
| minutes | string | 鍚?| 鏃?| - | 浼氳绾 |
| attachments | array | 鍚?| [] | - | 闄勪欢 |
| displayOrder | integer | 鍚?| 0 | - | 鏄剧ず椤哄簭 |

**璇锋眰绀轰緥**:

```json
{
  "title": "鍖哄潡閾炬妧鏈爺璁ㄤ細",
  "description": "璁ㄨ鍖哄潡閾炬妧鏈彂灞曡秼鍔?,
  "type": "SEMINAR",
  "status": "SCHEDULED",
  "meetingDate": "2024-01-15T14:00:00",
  "location": "浼氳瀹",
  "attendees": ["寮犱笁", "鏉庡洓"]
}
```

**鎴愬姛鍝嶅簲**:

| 鐘舵€佺爜 | 鏁版嵁缁撴瀯 | 璇存槑 |
|--------|----------|------|
| 200 | MeetingDto | 鍒涘缓鐨勪緥浼氫俊鎭?|

---

### 3. 鑾峰彇宸插畬鎴愮殑渚嬩細

**接口**: `GET /meetings/completed`

**鍔熻兘鎻忚堪**: 鑾峰彇鎵€鏈夊凡瀹屾垚鐨勪緥浼?
**鏉冮檺瑕佹眰**: 鏃?
**鎴愬姛鍝嶅簲**:

| 鐘舵€佺爜 | 鏁版嵁缁撴瀯 | 璇存槑 |
|--------|----------|------|
| 200 | `array<MeetingDto>` | 宸插畬鎴愪緥浼氬垪琛?|

---

### 4. 鑾峰彇鍗冲皢涓捐鐨勪緥浼?
**接口**: `GET /meetings/upcoming`

**鍔熻兘鎻忚堪**: 鑾峰彇鍗冲皢涓捐鐨勪緥浼?
**鏉冮檺瑕佹眰**: 鏃?
**鎴愬姛鍝嶅簲**:

| 鐘舵€佺爜 | 鏁版嵁缁撴瀯 | 璇存槑 |
|--------|----------|------|
| 200 | `array<MeetingDto>` | 鍗冲皢涓捐鐨勪緥浼氬垪琛?|

---

### 5. 鏍规嵁ID鑾峰彇渚嬩細

**接口**: `GET /meetings/{id}`

**鍔熻兘鎻忚堪**: 鏍规嵁ID鑾峰彇渚嬩細璇︾粏淇℃伅

**鏉冮檺瑕佹眰**: 鏃?
**璺緞鍙傛暟**:

| 鍙傛暟鍚?| 绫诲瀷 | 蹇呭～ | 璇存槑 |
|--------|------|------|------|
| id | integer | 鏄?| 渚嬩細ID |

**鎴愬姛鍝嶅簲**:

| 鐘舵€佺爜 | 鏁版嵁缁撴瀯 | 璇存槑 |
|--------|----------|------|
| 200 | MeetingDto | 渚嬩細璇︾粏淇℃伅 |

---

### 6. 鏇存柊渚嬩細

**接口**: `PUT /meetings/{id}`

**鍔熻兘鎻忚堪**: 鏇存柊渚嬩細锛堥殣钘忓叆鍙ｈ闂級

**鏉冮檺瑕佹眰**: 闇€瑕佺櫥褰?
**璺緞鍙傛暟**:

| 鍙傛暟鍚?| 绫诲瀷 | 蹇呭～ | 璇存槑 |
|--------|------|------|------|
| id | integer | 鏄?| 渚嬩細ID |

**璇锋眰浣?*: 鍚屽垱寤轰緥浼?
**鎴愬姛鍝嶅簲**:

| 鐘舵€佺爜 | 鏁版嵁缁撴瀯 | 璇存槑 |
|--------|----------|------|
| 200 | MeetingDto | 鏇存柊鍚庣殑渚嬩細淇℃伅 |

---

### 7. 鍒犻櫎渚嬩細

**接口**: `DELETE /meetings/{id}`

**鍔熻兘鎻忚堪**: 鍒犻櫎渚嬩細锛堥殣钘忓叆鍙ｈ闂級

**鏉冮檺瑕佹眰**: 闇€瑕佺櫥褰?
**璺緞鍙傛暟**:

| 鍙傛暟鍚?| 绫诲瀷 | 蹇呭～ | 璇存槑 |
|--------|------|------|------|
| id | integer | 鏄?| 渚嬩細ID |

**鎴愬姛鍝嶅簲**:

| 鐘舵€佺爜 | 璇存槑 |
|--------|------|
| 200 | 鍒犻櫎鎴愬姛 |

---

### 8. 鏇存柊渚嬩細鐘舵€?
**接口**: `PATCH /meetings/{id}/status`

**鍔熻兘鎻忚堪**: 鏇存柊渚嬩細鐘舵€侊紙闅愯棌鍏ュ彛璁块棶锛?
**鏉冮檺瑕佹眰**: 闇€瑕佺櫥褰?
**璺緞鍙傛暟**:

| 鍙傛暟鍚?| 绫诲瀷 | 蹇呭～ | 璇存槑 |
|--------|------|------|------|
| id | integer | 鏄?| 渚嬩細ID |

**鏌ヨ鍙傛暟**:

| 鍙傛暟鍚?| 绫诲瀷 | 蹇呭～ | 璇存槑 |
|--------|------|------|------|
| status | string | 鏄?| 渚嬩細鐘舵€侊紙SCHEDULED/COMPLETED/CANCELLED锛?|

**鎴愬姛鍝嶅簲**:

| 鐘舵€佺爜 | 鏁版嵁缁撴瀯 | 璇存槑 |
|--------|----------|------|
| 200 | MeetingDto | 鏇存柊鍚庣殑渚嬩細淇℃伅 |

---

### 9. 鏇存柊渚嬩細鏄剧ず椤哄簭

**接口**: `PATCH /meetings/{id}/display-order`

**鍔熻兘鎻忚堪**: 鏇存柊渚嬩細鏄剧ず椤哄簭锛堥殣钘忓叆鍙ｈ闂級

**鏉冮檺瑕佹眰**: 闇€瑕佺櫥褰?
**璺緞鍙傛暟**:

| 鍙傛暟鍚?| 绫诲瀷 | 蹇呭～ | 璇存槑 |
|--------|------|------|------|
| id | integer | 鏄?| 渚嬩細ID |

**鏌ヨ鍙傛暟**:

| 鍙傛暟鍚?| 绫诲瀷 | 蹇呭～ | 璇存槑 |
|--------|------|------|------|
| displayOrder | integer | 鏄?| 鏄剧ず椤哄簭 |

**鎴愬姛鍝嶅簲**:

| 鐘舵€佺爜 | 璇存槑 |
|--------|------|
| 200 | 鏇存柊鎴愬姛 |

---

### 10. 鑾峰彇渚嬩細缁熻

**接口**: `GET /meetings/statistics`

**鍔熻兘鎻忚堪**: 鑾峰彇渚嬩細缁熻淇℃伅

**鏉冮檺瑕佹眰**: 鏃?
**鎴愬姛鍝嶅簲**:

| 鐘舵€佺爜 | 鏁版嵁缁撴瀯 | 璇存槑 |
|--------|----------|------|
| 200 | `Map<String, Object>` | 缁熻淇℃伅 |

---

## 鏁版嵁缁撴瀯

### MeetingDto

| 瀛楁鍚?| 绫诲瀷 | 璇存槑 |
|--------|------|------|
| id | integer | 渚嬩細ID |
| title | string | 渚嬩細鏍囬 |
| description | string | 渚嬩細鎻忚堪 |
| type | string | 渚嬩細绫诲瀷锛圫EMINAR/PROGRESS_REPORT/TEAM_MEETING锛?|
| status | string | 渚嬩細鐘舵€侊紙SCHEDULED/COMPLETED/CANCELLED锛?|
| meetingDate | string | 渚嬩細鏃ユ湡 |
| location | string | 渚嬩細鍦扮偣 |
| attendees | array | 鍙備細浜哄憳 |
| minutes | string | 浼氳绾 |
| attachments | array | 闄勪欢 |
| displayOrder | integer | 鏄剧ず椤哄簭 |
| createdAt | string | 鍒涘缓鏃堕棿 |
| updatedAt | string | 鏇存柊鏃堕棿 |

