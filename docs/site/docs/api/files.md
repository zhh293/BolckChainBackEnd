---
sidebar_position: 6
---

# 鏂囦欢绠＄悊鎺ュ彛

鏂囦欢绠＄悊鎺ュ彛鎻愪緵鏂囦欢鐨勪笂浼犱笅杞藉姛鑳姐€?
## 鎺ュ彛鍒楄〃

### 1. 涓婁紶鏂囦欢

**接口**: `POST /files/upload`

**鍔熻兘鎻忚堪**: 涓婁紶鏂囦欢鍒版湇鍔″櫒锛堥殣钘忓叆鍙ｈ闂級

**鏉冮檺瑕佹眰**: 闇€瑕佺櫥褰?
**璇锋眰澶?*:

| 瀛楁鍚?| 绫诲瀷 | 蹇呭～ | 榛樿鍊?| 璇存槑 |
|--------|------|------|--------|------|
| Content-Type | string | 鏄?| multipart/form-data | 璇锋眰浣撶被鍨?|

**璇锋眰浣?*:

| 瀛楁鍚?| 绫诲瀷 | 蹇呭～ | 榛樿鍊?| 鍙栧€艰寖鍥?| 涓氬姟瑙勫垯 |
|--------|------|------|--------|----------|----------|
| file | file | 鏄?| 鏃?| - | 涓婁紶鐨勬枃浠?|
| category | string | 鍚?| 鏃?| - | 鏂囦欢鍒嗙被 |
| description | string | 鍚?| 鏃?| - | 鏂囦欢鎻忚堪 |

**璇锋眰绀轰緥**:

```bash
curl -X POST http://localhost:8080/api/files/upload \
  -F "file=@document.pdf" \
  -F "category=鏂囨。" \
  -F "description=椤圭洰鏂囨。"
```

**鎴愬姛鍝嶅簲**:

| 鐘舵€佺爜 | 鏁版嵁缁撴瀯 | 璇存槑 |
|--------|----------|------|
| 200 | FileUploadDto | 鏂囦欢淇℃伅 |

**鍝嶅簲绀轰緥**:

```json
{
  "id": 1,
  "fileName": "document.pdf",
  "originalFileName": "document.pdf",
  "fileSize": 1024000,
  "contentType": "application/pdf",
  "category": "鏂囨。",
  "description": "椤圭洰鏂囨。",
  "filePath": "/uploads/2024/01/document.pdf",
  "uploadedBy": "admin",
  "downloadCount": 0,
  "createdAt": "2024-01-01T00:00:00"
}
```

---

### 2. 涓嬭浇鏂囦欢

**接口**: `GET /files/download/{fileName}`

**鍔熻兘鎻忚堪**: 浠庢湇鍔″櫒涓嬭浇鏂囦欢

**鏉冮檺瑕佹眰**: 鏃?
**璺緞鍙傛暟**:

| 鍙傛暟鍚?| 绫诲瀷 | 蹇呭～ | 璇存槑 |
|--------|------|------|------|
| fileName | string | 鏄?| 鏂囦欢鍚?|

**璇锋眰绀轰緥**:

```bash
curl -X GET http://localhost:8080/api/files/download/document.pdf \
  -o document.pdf
```

**鎴愬姛鍝嶅簲**:

| 鐘舵€佺爜 | 鏁版嵁缁撴瀯 | 璇存槑 |
|--------|----------|------|
| 200 | binary | 鏂囦欢鍐呭 |

---

### 3. 鑾峰彇鎵€鏈夋枃浠?
**接口**: `GET /files`

**鍔熻兘鎻忚堪**: 鍒嗛〉鑾峰彇鎵€鏈変笂浼犵殑鏂囦欢

**鏉冮檺瑕佹眰**: 鏃?
**鏌ヨ鍙傛暟**:

| 鍙傛暟鍚?| 绫诲瀷 | 蹇呭～ | 榛樿鍊?| 璇存槑 |
|--------|------|------|--------|------|
| page | integer | 鍚?| 0 | 椤电爜 |
| size | integer | 鍚?| 10 | 姣忛〉澶у皬 |
| sortBy | string | 鍚?| uploadedAt | 鎺掑簭瀛楁 |
| sortDirection | string | 鍚?| DESC | 鎺掑簭鏂瑰悜锛圓SC/DESC锛?|

**璇锋眰绀轰緥**:

```bash
GET /files?page=0&size=10&sortBy=uploadedAt&sortDirection=DESC
```

**鎴愬姛鍝嶅簲**:

| 鐘舵€佺爜 | 鏁版嵁缁撴瀯 | 璇存槑 |
|--------|----------|------|
| 200 | `Page<FileUploadDto>` | 鏂囦欢鍒楄〃 |

**鍝嶅簲绀轰緥**:

```json
{
  "content": [
    {
      "id": 1,
      "fileName": "document.pdf",
      "originalFileName": "document.pdf",
      "fileSize": 1024000,
      "contentType": "application/pdf",
      "category": "鏂囨。",
      "description": "椤圭洰鏂囨。",
      "filePath": "/uploads/2024/01/document.pdf",
      "uploadedBy": "admin",
      "downloadCount": 10,
      "createdAt": "2024-01-01T00:00:00"
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

### 4. 鑾峰彇鏂囦欢淇℃伅

**接口**: `GET /files/{id}`

**鍔熻兘鎻忚堪**: 鏍规嵁ID鑾峰彇鏂囦欢璇︾粏淇℃伅

**鏉冮檺瑕佹眰**: 鏃?
**璺緞鍙傛暟**:

| 鍙傛暟鍚?| 绫诲瀷 | 蹇呭～ | 璇存槑 |
|--------|------|------|------|
| id | integer | 鏄?| 鏂囦欢ID |

**鎴愬姛鍝嶅簲**:

| 鐘舵€佺爜 | 鏁版嵁缁撴瀯 | 璇存槑 |
|--------|----------|------|
| 200 | `Result<FileUploadDto>` | 鏂囦欢淇℃伅 |

**鍝嶅簲绀轰緥**:

```json
{
  "code": 200,
  "message": "鎴愬姛",
  "data": {
    "id": 1,
    "fileName": "document.pdf",
    "originalFileName": "document.pdf",
    "fileSize": 1024000,
    "contentType": "application/pdf",
    "category": "鏂囨。",
    "description": "椤圭洰鏂囨。",
    "filePath": "/uploads/2024/01/document.pdf",
    "uploadedBy": "admin",
    "downloadCount": 10,
    "createdAt": "2024-01-01T00:00:00"
  }
}
```

**澶辫触鍝嶅簲**:

| 鐘舵€佺爜 | 閿欒鐮?| 閿欒淇℃伅 | 瑙﹀彂鍦烘櫙 |
|--------|--------|----------|----------|
| 400 | 400 | 鏂囦欢涓嶅瓨鍦?| 鏂囦欢ID涓嶅瓨鍦?|

**閿欒鍝嶅簲绀轰緥**:

```json
{
  "message": "鏂囦欢涓嶅瓨鍦?
}
```

---

### 5. 鏇存柊鏂囦欢淇℃伅

**接口**: `PUT /files/{id}`

**鍔熻兘鎻忚堪**: 鏇存柊鏂囦欢鎻忚堪鍜屽垎绫讳俊鎭紙闅愯棌鍏ュ彛璁块棶锛?
**鏉冮檺瑕佹眰**: 闇€瑕佺櫥褰?
**璺緞鍙傛暟**:

| 鍙傛暟鍚?| 绫诲瀷 | 蹇呭～ | 璇存槑 |
|--------|------|------|------|
| id | integer | 鏄?| 鏂囦欢ID |

**璇锋眰浣?*:

| 瀛楁鍚?| 绫诲瀷 | 蹇呭～ | 榛樿鍊?| 鍙栧€艰寖鍥?| 涓氬姟瑙勫垯 |
|--------|------|------|--------|----------|----------|
| description | string | 鍚?| 鏃?| - | 鏂囦欢鎻忚堪 |
| category | string | 鍚?| 鏃?| - | 鏂囦欢鍒嗙被 |

**璇锋眰绀轰緥**:

```bash
curl -X PUT "http://localhost:8080/api/files/1" \
  -H "Content-Type: application/x-www-form-urlencoded" \
  -d "description=鏇存柊鍚庣殑鎻忚堪&category=鏇存柊鍚庣殑鍒嗙被"
```

**鎴愬姛鍝嶅簲**:

| 鐘舵€佺爜 | 鏁版嵁缁撴瀯 | 璇存槑 |
|--------|----------|------|
| 200 | FileUploadDto | 鏇存柊鍚庣殑鏂囦欢淇℃伅 |

---

### 6. 鍒犻櫎鏂囦欢

**接口**: `DELETE /files/{id}`

**鍔熻兘鎻忚堪**: 鍒犻櫎鏂囦欢锛堥殣钘忓叆鍙ｈ闂級

**鏉冮檺瑕佹眰**: 闇€瑕佺櫥褰?
**璺緞鍙傛暟**:

| 鍙傛暟鍚?| 绫诲瀷 | 蹇呭～ | 璇存槑 |
|--------|------|------|------|
| id | integer | 鏄?| 鏂囦欢ID |

**鎴愬姛鍝嶅簲**:

| 鐘舵€佺爜 | 璇存槑 |
|--------|------|
| 200 | 鍒犻櫎鎴愬姛 |

---

### 7. 鑾峰彇鏂囦欢缁熻

**接口**: `GET /files/statistics`

**鍔熻兘鎻忚堪**: 鑾峰彇鏂囦欢涓婁紶鍜屼笅杞界粺璁′俊鎭紙闅愯棌鍏ュ彛璁块棶锛?
**鏉冮檺瑕佹眰**: 闇€瑕佺櫥褰?
**鎴愬姛鍝嶅簲**:

| 鐘舵€佺爜 | 鏁版嵁缁撴瀯 | 璇存槑 |
|--------|----------|------|
| 200 | `Map<String, Object>` | 缁熻淇℃伅 |

---

## 鏁版嵁缁撴瀯

### FileUploadDto

| 瀛楁鍚?| 绫诲瀷 | 璇存槑 |
|--------|------|------|
| id | integer | 鏂囦欢ID |
| fileName | string | 鏂囦欢鍚?|
| originalFileName | string | 鍘熷鏂囦欢鍚?|
| fileSize | integer | 鏂囦欢澶у皬锛堝瓧鑺傦級 |
| contentType | string | 鍐呭绫诲瀷 |
| category | string | 鍒嗙被 |
| description | string | 鎻忚堪 |
| filePath | string | 鏂囦欢璺緞 |
| uploadedBy | string | 涓婁紶鑰?|
| downloadCount | integer | 涓嬭浇娆℃暟 |
| createdAt | string | 鍒涘缓鏃堕棿 |

---

## 娉ㄦ剰浜嬮」

1. **鏂囦欢澶у皬闄愬埗**: 鍗曚釜鏂囦欢鏈€澶ф敮鎸?0MB
2. **鏂囦欢绫诲瀷**: 鏀寔甯歌鐨勬枃妗ｃ€佸浘鐗囥€佸帇缂╁寘绛夋牸寮?3. **鏂囦欢鍛藉悕**: 涓婁紶鐨勬枃浠朵細鑷姩閲嶅懡鍚嶏紝閬垮厤鍐茬獊
4. **鏂囦欢瀛樺偍**: 鏂囦欢瀛樺偍鍦ㄦ湇鍔″櫒鐨勬寚瀹氱洰褰曚腑
5. **涓嬭浇缁熻**: 姣忔涓嬭浇閮戒細澧炲姞涓嬭浇璁℃暟
6. **鏉冮檺鎺у埗**: 涓婁紶銆佹洿鏂般€佸垹闄ゆ枃浠堕渶瑕佺鐞嗗憳鏉冮檺

