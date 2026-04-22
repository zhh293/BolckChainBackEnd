---
sidebar_position: 2
---

# 瀹為獙瀹ゆ垚鍛樼鐞嗘帴鍙?
瀹為獙瀹ゆ垚鍛樼鐞嗘帴鍙ｆ彁渚涙垚鍛樹俊鎭殑澧炲垹鏀规煡鍔熻兘銆?
## 鎺ュ彛鍒楄〃

### 1. 鑾峰彇鎵€鏈夋垚鍛?
**接口**: `GET /members`

**鍔熻兘鎻忚堪**: 鍒嗛〉鑾峰彇鎵€鏈夊疄楠屽鎴愬憳

**鏉冮檺瑕佹眰**: 鏃?
**鏌ヨ鍙傛暟**:

| 鍙傛暟鍚?| 绫诲瀷 | 蹇呭～ | 榛樿鍊?| 璇存槑 |
|--------|------|------|--------|------|
| page | integer | 鍚?| 0 | 椤电爜 |
| size | integer | 鍚?| 20 | 姣忛〉澶у皬 |
| sortBy | string | 鍚?| id | 鎺掑簭瀛楁 |
| sortDirection | string | 鍚?| DESC | 鎺掑簭鏂瑰悜锛圓SC/DESC锛?|

**璇锋眰绀轰緥**:

```bash
GET /members?page=0&size=20&sortBy=id&sortDirection=DESC
```

**鎴愬姛鍝嶅簲**:

| 鐘舵€佺爜 | 鏁版嵁缁撴瀯 | 璇存槑 |
|--------|----------|------|
| 200 | `Page<MemberDto>` | 鎴愬憳鍒楄〃 |

**鍝嶅簲绀轰緥**:

```json
{
  "content": [
    {
      "id": 1,
      "name": "寮犱笁",
      "studentId": "20240001",
      "role": "STUDENT",
      "grade": "2024",
      "email": "zhangsan@example.com",
      "phone": "13800138000",
      "avatar": "https://example.com/avatar1.jpg",
      "bio": "鍖哄潡閾剧爺绌舵柟鍚?,
      "status": "ACTIVE",
      "displayOrder": 1,
      "createdAt": "2024-01-01T00:00:00",
      "updatedAt": "2024-01-01T00:00:00"
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

### 2. 鍒涘缓鎴愬憳

**接口**: `POST /members`

**鍔熻兘鎻忚堪**: 鍒涘缓鏂扮殑瀹為獙瀹ゆ垚鍛橈紙闅愯棌鍏ュ彛璁块棶锛?
**鏉冮檺瑕佹眰**: 闇€瑕佺櫥褰?
**璇锋眰浣?*:

| 瀛楁鍚?| 绫诲瀷 | 蹇呭～ | 榛樿鍊?| 鍙栧€艰寖鍥?| 涓氬姟瑙勫垯 |
|--------|------|------|--------|----------|----------|
| name | string | 鏄?| 鏃?| - | 鎴愬憳濮撳悕 |
| studentId | string | 鍚?| 鏃?| - | 瀛﹀彿 |
| role | string | 鍚?| STUDENT | STUDENT/TEACHER/POSTDOCTOR | 瑙掕壊 |
| grade | string | 鍚?| 鏃?| - | 骞寸骇 |
| email | string | 鍚?| 鏃?| - | 閭 |
| phone | string | 鍚?| 鏃?| - | 鐢佃瘽 |
| avatar | string | 鍚?| 鏃?| - | 澶村儚URL |
| bio | string | 鍚?| 鏃?| - | 涓汉绠€浠?|
| status | string | 鍚?| ACTIVE | ACTIVE/INACTIVE/GRADUATED | 鐘舵€?|
| displayOrder | integer | 鍚?| 0 | - | 鏄剧ず椤哄簭 |

**璇锋眰绀轰緥**:

```json
{
  "name": "鏉庡洓",
  "studentId": "20240002",
  "role": "STUDENT",
  "grade": "2024",
  "email": "lisi@example.com",
  "phone": "13900139000",
  "bio": "鏅鸿兘鍚堢害鐮旂┒鏂瑰悜",
  "status": "ACTIVE"
}
```

**鎴愬姛鍝嶅簲**:

| 鐘舵€佺爜 | 鏁版嵁缁撴瀯 | 璇存槑 |
|--------|----------|------|
| 200 | MemberDto | 鍒涘缓鐨勬垚鍛樹俊鎭?|

---

### 3. 鑾峰彇娲昏穬鎴愬憳

**接口**: `GET /members/active`

**鍔熻兘鎻忚堪**: 鑾峰彇鎵€鏈夋椿璺冪殑瀹為獙瀹ゆ垚鍛?
**鏉冮檺瑕佹眰**: 鏃?
**鎴愬姛鍝嶅簲**:

| 鐘舵€佺爜 | 鏁版嵁缁撴瀯 | 璇存槑 |
|--------|----------|------|
| 200 | `array<MemberDto>` | 娲昏穬鎴愬憳鍒楄〃 |

---

### 4. 鑾峰彇鐗硅壊鎴愬憳

**接口**: `GET /members/featured`

**鍔熻兘鎻忚堪**: 鑾峰彇鐗硅壊瀹為獙瀹ゆ垚鍛?
**鏉冮檺瑕佹眰**: 鏃?
**鎴愬姛鍝嶅簲**:

| 鐘舵€佺爜 | 鏁版嵁缁撴瀯 | 璇存槑 |
|--------|----------|------|
| 200 | `array<MemberDto>` | 鐗硅壊鎴愬憳鍒楄〃 |

---

### 5. 鏍规嵁ID鑾峰彇鎴愬憳

**接口**: `GET /members/{id}`

**鍔熻兘鎻忚堪**: 鏍规嵁ID鑾峰彇瀹為獙瀹ゆ垚鍛樿缁嗕俊鎭?
**鏉冮檺瑕佹眰**: 鏃?
**璺緞鍙傛暟**:

| 鍙傛暟鍚?| 绫诲瀷 | 蹇呭～ | 璇存槑 |
|--------|------|------|------|
| id | integer | 鏄?| 鎴愬憳ID |

**鎴愬姛鍝嶅簲**:

| 鐘舵€佺爜 | 鏁版嵁缁撴瀯 | 璇存槑 |
|--------|----------|------|
| 200 | MemberDto | 鎴愬憳璇︾粏淇℃伅 |

---

### 6. 鏇存柊鎴愬憳

**接口**: `PUT /members/{id}`

**鍔熻兘鎻忚堪**: 鏇存柊瀹為獙瀹ゆ垚鍛樹俊鎭紙闅愯棌鍏ュ彛璁块棶锛?
**鏉冮檺瑕佹眰**: 闇€瑕佺櫥褰?
**璺緞鍙傛暟**:

| 鍙傛暟鍚?| 绫诲瀷 | 蹇呭～ | 璇存槑 |
|--------|------|------|------|
| id | integer | 鏄?| 鎴愬憳ID |

**璇锋眰浣?*: 鍚屽垱寤烘垚鍛?
**鎴愬姛鍝嶅簲**:

| 鐘舵€佺爜 | 鏁版嵁缁撴瀯 | 璇存槑 |
|--------|----------|------|
| 200 | MemberDto | 鏇存柊鍚庣殑鎴愬憳淇℃伅 |

---

### 7. 鍒犻櫎鎴愬憳

**接口**: `DELETE /members/{id}`

**鍔熻兘鎻忚堪**: 鍒犻櫎瀹為獙瀹ゆ垚鍛橈紙闅愯棌鍏ュ彛璁块棶锛?
**鏉冮檺瑕佹眰**: 闇€瑕佺櫥褰?
**璺緞鍙傛暟**:

| 鍙傛暟鍚?| 绫诲瀷 | 蹇呭～ | 璇存槑 |
|--------|------|------|------|
| id | integer | 鏄?| 鎴愬憳ID |

**鎴愬姛鍝嶅簲**:

| 鐘舵€佺爜 | 璇存槑 |
|--------|------|
| 200 | 鍒犻櫎鎴愬姛 |

---

### 8. 鏇存柊鎴愬憳鐘舵€?
**接口**: `PATCH /members/{id}/status`

**鍔熻兘鎻忚堪**: 鏇存柊瀹為獙瀹ゆ垚鍛樼姸鎬侊紙闅愯棌鍏ュ彛璁块棶锛?
**鏉冮檺瑕佹眰**: 闇€瑕佺櫥褰?
**璺緞鍙傛暟**:

| 鍙傛暟鍚?| 绫诲瀷 | 蹇呭～ | 璇存槑 |
|--------|------|------|------|
| id | integer | 鏄?| 鎴愬憳ID |

**鏌ヨ鍙傛暟**:

| 鍙傛暟鍚?| 绫诲瀷 | 蹇呭～ | 璇存槑 |
|--------|------|------|------|
| status | string | 鏄?| 鎴愬憳鐘舵€侊紙ACTIVE/INACTIVE/GRADUATED锛?|

**鎴愬姛鍝嶅簲**:

| 鐘舵€佺爜 | 鏁版嵁缁撴瀯 | 璇存槑 |
|--------|----------|------|
| 200 | MemberDto | 鏇存柊鍚庣殑鎴愬憳淇℃伅 |

---

### 9. 鏇存柊鎴愬憳鏄剧ず椤哄簭

**接口**: `PATCH /members/{id}/display-order`

**鍔熻兘鎻忚堪**: 鏇存柊瀹為獙瀹ゆ垚鍛樻樉绀洪『搴忥紙闅愯棌鍏ュ彛璁块棶锛?
**鏉冮檺瑕佹眰**: 闇€瑕佺櫥褰?
**璺緞鍙傛暟**:

| 鍙傛暟鍚?| 绫诲瀷 | 蹇呭～ | 璇存槑 |
|--------|------|------|------|
| id | integer | 鏄?| 鎴愬憳ID |

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

### MemberDto

| 瀛楁鍚?| 绫诲瀷 | 璇存槑 |
|--------|------|------|
| id | integer | 鎴愬憳ID |
| name | string | 鎴愬憳濮撳悕 |
| studentId | string | 瀛﹀彿 |
| role | string | 瑙掕壊锛圫TUDENT/TEACHER/POSTDOCTOR锛?|
| grade | string | 骞寸骇 |
| email | string | 閭 |
| phone | string | 鐢佃瘽 |
| avatar | string | 澶村儚URL |
| bio | string | 涓汉绠€浠?|
| status | string | 鐘舵€侊紙ACTIVE/INACTIVE/GRADUATED锛?|
| displayOrder | integer | 鏄剧ず椤哄簭 |
| createdAt | string | 鍒涘缓鏃堕棿 |
| updatedAt | string | 鏇存柊鏃堕棿 |

