---
sidebar_position: 3
---

# 椤圭洰绠＄悊鎺ュ彛

椤圭洰绠＄悊鎺ュ彛鎻愪緵椤圭洰淇℃伅鐨勫鍒犳敼鏌ュ姛鑳姐€?
## 鎺ュ彛鍒楄〃

### 1. 鑾峰彇鎵€鏈夐」鐩?
**接口**: `GET /projects`

**鍔熻兘鎻忚堪**: 鍒嗛〉鑾峰彇鎵€鏈夐」鐩?
**鏉冮檺瑕佹眰**: 鏃?
**鏌ヨ鍙傛暟**:

| 鍙傛暟鍚?| 绫诲瀷 | 蹇呭～ | 榛樿鍊?| 璇存槑 |
|--------|------|------|--------|------|
| page | integer | 鍚?| 0 | 椤电爜 |
| size | integer | 鍚?| 20 | 姣忛〉澶у皬 |
| pageSize | integer | 鍚?| - | 姣忛〉澶у皬锛堜紭鍏堜娇鐢級 |
| sortBy | string | 鍚?| id | 鎺掑簭瀛楁 |
| sortDirection | string | 鍚?| DESC | 鎺掑簭鏂瑰悜锛圓SC/DESC锛?|
| keyword | string | 鍚?| - | 鎼滅储鍏抽敭璇?|
| status | string | 鍚?| - | 椤圭洰鐘舵€?|
| category | string | 鍚?| - | 椤圭洰鍒嗙被 |

**璇锋眰绀轰緥**:

```bash
GET /projects?page=0&size=20&sortBy=createdAt&sortDirection=DESC
```

**鎴愬姛鍝嶅簲**:

| 鐘舵€佺爜 | 鏁版嵁缁撴瀯 | 璇存槑 |
|--------|----------|------|
| 200 | `Page<ProjectDto>` | 椤圭洰鍒楄〃 |

**鍝嶅簲绀轰緥**:

```json
{
  "content": [
    {
      "id": 1,
      "name": "鍖哄潡閾句緵搴旈摼椤圭洰",
      "description": "鍩轰簬鍖哄潡閾炬妧鏈殑渚涘簲閾剧鐞嗙郴缁?,
      "category": "BLOCKCHAIN",
      "status": "IN_PROGRESS",
      "startDate": "2024-01-01",
      "endDate": "2024-12-31",
      "budget": 100000,
      "progress": 50,
      "members": ["寮犱笁", "鏉庡洓"],
      "attachments": ["https://example.com/file1.pdf"],
      "isPublic": true,
      "isFeatured": false,
      "displayOrder": 1,
      "createdAt": "2024-01-01T00:00:00",
      "updatedAt": "2024-01-15T00:00:00"
    }
  ],
  "pageable": {
    "pageNumber": 0,
    "pageSize": 20,
    "sort": {
      "sorted": true,
      "unsorted": false,
      "empty": false
    }
  },
  "totalElements": 1,
  "totalPages": 1,
  "size": 20,
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

### 2. 鍒涘缓椤圭洰

**接口**: `POST /projects`

**鍔熻兘鎻忚堪**: 鍒涘缓鏂伴」鐩紙闅愯棌鍏ュ彛璁块棶锛?
**鏉冮檺瑕佹眰**: 闇€瑕佺櫥褰?
**璇锋眰浣?*:

| 瀛楁鍚?| 绫诲瀷 | 蹇呭～ | 榛樿鍊?| 鍙栧€艰寖鍥?| 涓氬姟瑙勫垯 |
|--------|------|------|--------|----------|----------|
| name | string | 鏄?| 鏃?| - | 椤圭洰鍚嶇О |
| description | string | 鍚?| 鏃?| - | 椤圭洰鎻忚堪 |
| category | string | 鍚?| - | BLOCKCHAIN/SMART_CONTRACT/REAL_ESTATE/FOOD_SAFETY/INTELLECTUAL_PROPERTY | 椤圭洰鍒嗙被 |
| status | string | 鍚?| PLANNING | PLANNING/IN_PROGRESS/COMPLETED/CANCELLED/ON_HOLD/ONGOING | 椤圭洰鐘舵€?|
| startDate | string | 鍚?| 鏃?| YYYY-MM-DD | 寮€濮嬫棩鏈?|
| endDate | string | 鍚?| 鏃?| YYYY-MM-DD | 缁撴潫鏃ユ湡 |
| budget | integer | 鍚?| 0 | - | 椤圭洰棰勭畻 |
| progress | integer | 鍚?| 0 | 0-100 | 椤圭洰杩涘害 |
| members | array | 鍚?| [] | - | 椤圭洰鎴愬憳 |
| attachments | array | 鍚?| [] | - | 椤圭洰闄勪欢 |
| isPublic | boolean | 鍚?| false | - | 鏄惁鍏紑 |
| isFeatured | boolean | 鍚?| false | - | 鏄惁鐗硅壊 |
| displayOrder | integer | 鍚?| 0 | - | 鏄剧ず椤哄簭 |

**璇锋眰绀轰緥**:

```json
{
  "name": "鍖哄潡閾句緵搴旈摼椤圭洰",
  "description": "鍩轰簬鍖哄潡閾炬妧鏈殑渚涘簲閾剧鐞嗙郴缁?,
  "category": "BLOCKCHAIN",
  "status": "PLANNING",
  "startDate": "2024-01-01",
  "endDate": "2024-12-31",
  "budget": 100000,
  "progress": 0,
  "members": ["寮犱笁", "鏉庡洓"],
  "isPublic": true
}
```

**鎴愬姛鍝嶅簲**:

| 鐘舵€佺爜 | 鏁版嵁缁撴瀯 | 璇存槑 |
|--------|----------|------|
| 200 | ProjectDto | 鍒涘缓鐨勯」鐩俊鎭?|

---

### 3. 鑾峰彇鍏紑椤圭洰

**接口**: `GET /projects/public`

**鍔熻兘鎻忚堪**: 鑾峰彇鎵€鏈夊叕寮€鐨勯」鐩?
**鏉冮檺瑕佹眰**: 鏃?
**鎴愬姛鍝嶅簲**:

| 鐘舵€佺爜 | 鏁版嵁缁撴瀯 | 璇存槑 |
|--------|----------|------|
| 200 | `array<ProjectDto>` | 鍏紑椤圭洰鍒楄〃 |

---

### 4. 鑾峰彇鐗硅壊椤圭洰

**接口**: `GET /projects/featured`

**鍔熻兘鎻忚堪**: 鑾峰彇鐗硅壊椤圭洰

**鏉冮檺瑕佹眰**: 鏃?
**鎴愬姛鍝嶅簲**:

| 鐘舵€佺爜 | 鏁版嵁缁撴瀯 | 璇存槑 |
|--------|----------|------|
| 200 | `array<ProjectDto>` | 鐗硅壊椤圭洰鍒楄〃 |

---

### 5. 鑾峰彇杩涜涓殑椤圭洰

**接口**: `GET /projects/ongoing`

**鍔熻兘鎻忚堪**: 鑾峰彇杩涜涓殑椤圭洰

**鏉冮檺瑕佹眰**: 鏃?
**鎴愬姛鍝嶅簲**:

| 鐘舵€佺爜 | 鏁版嵁缁撴瀯 | 璇存槑 |
|--------|----------|------|
| 200 | `array<ProjectDto>` | 杩涜涓」鐩垪琛?|

---

### 6. 鑾峰彇宸插畬鎴愮殑椤圭洰

**接口**: `GET /projects/completed`

**鍔熻兘鎻忚堪**: 鑾峰彇宸插畬鎴愮殑椤圭洰

**鏉冮檺瑕佹眰**: 鏃?
**鎴愬姛鍝嶅簲**:

| 鐘舵€佺爜 | 鏁版嵁缁撴瀯 | 璇存槑 |
|--------|----------|------|
| 200 | `array<ProjectDto>` | 宸插畬鎴愰」鐩垪琛?|

---

### 7. 鏍规嵁ID鑾峰彇椤圭洰

**接口**: `GET /projects/{id}`

**鍔熻兘鎻忚堪**: 鏍规嵁ID鑾峰彇椤圭洰璇︾粏淇℃伅

**鏉冮檺瑕佹眰**: 鏃?
**璺緞鍙傛暟**:

| 鍙傛暟鍚?| 绫诲瀷 | 蹇呭～ | 璇存槑 |
|--------|------|------|------|
| id | integer | 鏄?| 椤圭洰ID |

**鎴愬姛鍝嶅簲**:

| 鐘舵€佺爜 | 鏁版嵁缁撴瀯 | 璇存槑 |
|--------|----------|------|
| 200 | ProjectDto | 椤圭洰璇︾粏淇℃伅 |

---

### 8. 鏇存柊椤圭洰

**接口**: `PUT /projects/{id}`

**鍔熻兘鎻忚堪**: 鏇存柊椤圭洰淇℃伅锛堥殣钘忓叆鍙ｈ闂級

**鏉冮檺瑕佹眰**: 闇€瑕佺櫥褰?
**璺緞鍙傛暟**:

| 鍙傛暟鍚?| 绫诲瀷 | 蹇呭～ | 璇存槑 |
|--------|------|------|------|
| id | integer | 鏄?| 椤圭洰ID |

**璇锋眰浣?*: 鍚屽垱寤洪」鐩?
**鎴愬姛鍝嶅簲**:

| 鐘舵€佺爜 | 鏁版嵁缁撴瀯 | 璇存槑 |
|--------|----------|------|
| 200 | ProjectDto | 鏇存柊鍚庣殑椤圭洰淇℃伅 |

---

### 9. 鍒犻櫎椤圭洰

**接口**: `DELETE /projects/{id}`

**鍔熻兘鎻忚堪**: 鍒犻櫎椤圭洰锛堥殣钘忓叆鍙ｈ闂級

**鏉冮檺瑕佹眰**: 闇€瑕佺櫥褰?
**璺緞鍙傛暟**:

| 鍙傛暟鍚?| 绫诲瀷 | 蹇呭～ | 璇存槑 |
|--------|------|------|------|
| id | integer | 鏄?| 椤圭洰ID |

**鎴愬姛鍝嶅簲**:

| 鐘舵€佺爜 | 璇存槑 |
|--------|------|
| 200 | 鍒犻櫎鎴愬姛 |

---

### 10. 鏇存柊椤圭洰鐘舵€?
**接口**: `PATCH /projects/{id}/status`

**鍔熻兘鎻忚堪**: 鏇存柊椤圭洰鐘舵€侊紙闅愯棌鍏ュ彛璁块棶锛?
**鏉冮檺瑕佹眰**: 闇€瑕佺櫥褰?
**璺緞鍙傛暟**:

| 鍙傛暟鍚?| 绫诲瀷 | 蹇呭～ | 璇存槑 |
|--------|------|------|------|
| id | integer | 鏄?| 椤圭洰ID |

**鏌ヨ鍙傛暟**:

| 鍙傛暟鍚?| 绫诲瀷 | 蹇呭～ | 璇存槑 |
|--------|------|------|------|
| status | string | 鏄?| 椤圭洰鐘舵€侊紙PLANNING/IN_PROGRESS/COMPLETED/CANCELLED/ON_HOLD/ONGOING锛?|

**鎴愬姛鍝嶅簲**:

| 鐘舵€佺爜 | 鏁版嵁缁撴瀯 | 璇存槑 |
|--------|----------|------|
| 200 | ProjectDto | 鏇存柊鍚庣殑椤圭洰淇℃伅 |

---

### 11. 鏇存柊椤圭洰杩涘害

**接口**: `PATCH /projects/{id}/progress`

**鍔熻兘鎻忚堪**: 鏇存柊椤圭洰杩涘害锛堥殣钘忓叆鍙ｈ闂級

**鏉冮檺瑕佹眰**: 闇€瑕佺櫥褰?
**璺緞鍙傛暟**:

| 鍙傛暟鍚?| 绫诲瀷 | 蹇呭～ | 璇存槑 |
|--------|------|------|------|
| id | integer | 鏄?| 椤圭洰ID |

**鏌ヨ鍙傛暟**:

| 鍙傛暟鍚?| 绫诲瀷 | 蹇呭～ | 璇存槑 |
|--------|------|------|------|
| progress | integer | 鏄?| 椤圭洰杩涘害锛?-100锛?|

**鎴愬姛鍝嶅簲**:

| 鐘舵€佺爜 | 鏁版嵁缁撴瀯 | 璇存槑 |
|--------|----------|------|
| 200 | ProjectDto | 鏇存柊鍚庣殑椤圭洰淇℃伅 |

---

### 12. 鏇存柊椤圭洰鏄剧ず椤哄簭

**接口**: `PATCH /projects/{id}/display-order`

**鍔熻兘鎻忚堪**: 鏇存柊椤圭洰鏄剧ず椤哄簭锛堥殣钘忓叆鍙ｈ闂級

**鏉冮檺瑕佹眰**: 闇€瑕佺櫥褰?
**璺緞鍙傛暟**:

| 鍙傛暟鍚?| 绫诲瀷 | 蹇呭～ | 璇存槑 |
|--------|------|------|------|
| id | integer | 鏄?| 椤圭洰ID |

**鏌ヨ鍙傛暟**:

| 鍙傛暟鍚?| 绫诲瀷 | 蹇呭～ | 璇存槑 |
|--------|------|------|------|
| displayOrder | integer | 鏄?| 鏄剧ず椤哄簭 |

**鎴愬姛鍝嶅簲**:

| 鐘舵€佺爜 | 璇存槑 |
|--------|------|
| 200 | 鏇存柊鎴愬姛 |

---

## 鏁版嵁缁撴瀯

### ProjectDto

| 瀛楁鍚?| 绫诲瀷 | 璇存槑 |
|--------|------|------|
| id | integer | 椤圭洰ID |
| name | string | 椤圭洰鍚嶇О |
| description | string | 椤圭洰鎻忚堪 |
| category | string | 椤圭洰鍒嗙被 |
| status | string | 椤圭洰鐘舵€?|
| startDate | string | 寮€濮嬫棩鏈?|
| endDate | string | 缁撴潫鏃ユ湡 |
| budget | integer | 椤圭洰棰勭畻 |
| progress | integer | 椤圭洰杩涘害锛?-100锛?|
| members | array | 椤圭洰鎴愬憳 |
| attachments | array | 椤圭洰闄勪欢 |
| isPublic | boolean | 鏄惁鍏紑 |
| isFeatured | boolean | 鏄惁鐗硅壊 |
| displayOrder | integer | 鏄剧ず椤哄簭 |
| createdAt | string | 鍒涘缓鏃堕棿 |
| updatedAt | string | 鏇存柊鏃堕棿 |

