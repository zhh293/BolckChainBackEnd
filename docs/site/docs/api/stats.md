---
sidebar_position: 7
---

# 鏁版嵁缁熻鎺ュ彛

鏁版嵁缁熻鎺ュ彛鎻愪緵绯荤粺鏁版嵁鐨勭粺璁″垎鏋愬姛鑳姐€?
## 鎺ュ彛鍒楄〃

### 1. 绯荤粺姒傝缁熻

**接口**: `GET /stats/overview`

**鍔熻兘鎻忚堪**: 鑾峰彇绯荤粺鐨勬暣浣撶粺璁℃暟鎹?
**鏉冮檺瑕佹眰**: 鏃?
**鎴愬姛鍝嶅簲**:

| 鐘舵€佺爜 | 鏁版嵁缁撴瀯 | 璇存槑 |
|--------|----------|------|
| 200 | `Map<String, Object>` | 绯荤粺姒傝缁熻 |

**鍝嶅簲绀轰緥**:

```json
{
  "code": 200,
  "message": "鎴愬姛",
  "data": {
    "totalMembers": 50,
    "totalProjects": 20,
    "totalPosts": 100,
    "totalMeetings": 30,
    "totalFiles": 15,
    "activeMembers": 45,
    "ongoingProjects": 15,
    "publishedPosts": 80,
    "upcomingMeetings": 5
  }
}
```

---

### 2. 鐢ㄦ埛缁熻

**接口**: `GET /stats/users`

**鍔熻兘鎻忚堪**: 鑾峰彇鐢ㄦ埛鐩稿叧鐨勭粺璁℃暟鎹?
**鏉冮檺瑕佹眰**: 鏃?
**鎴愬姛鍝嶅簲**:

| 鐘舵€佺爜 | 鏁版嵁缁撴瀯 | 璇存槑 |
|--------|----------|------|
| 200 | `Map<String, Object>` | 鐢ㄦ埛缁熻 |

**鍝嶅簲绀轰緥**:

```json
{
  "code": 200,
  "message": "鎴愬姛",
  "data": {
    "totalMembers": 50,
    "activeMembers": 45,
    "inactiveMembers": 3,
    "graduatedMembers": 2,
    "students": 40,
    "teachers": 8,
    "postdoctors": 2,
    "newMembersThisMonth": 5,
    "newMembersThisYear": 20
  }
}
```

---

### 3. 鍐呭缁熻

**接口**: `GET /stats/content`

**鍔熻兘鎻忚堪**: 鑾峰彇鍐呭鐩稿叧鐨勭粺璁℃暟鎹紙鍗氬銆侀」鐩€佹垚鍛樸€佷緥浼氾級

**鏉冮檺瑕佹眰**: 鏃?
**鎴愬姛鍝嶅簲**:

| 鐘舵€佺爜 | 鏁版嵁缁撴瀯 | 璇存槑 |
|--------|----------|------|
| 200 | `Map<String, Object>` | 鍐呭缁熻 |

**鍝嶅簲绀轰緥**:

```json
{
  "code": 200,
  "message": "鎴愬姛",
  "data": {
    "posts": {
      "total": 100,
      "published": 80,
      "draft": 15,
      "archived": 5,
      "totalViews": 50000,
      "totalLikes": 2000,
      "totalComments": 500
    },
    "projects": {
      "total": 20,
      "ongoing": 15,
      "completed": 3,
      "planning": 2,
      "cancelled": 0,
      "onHold": 0,
      "totalBudget": 2000000,
      "averageProgress": 60
    },
    "meetings": {
      "total": 30,
      "scheduled": 5,
      "completed": 25,
      "cancelled": 0,
      "thisMonth": 5,
      "thisYear": 30
    }
  }
}
```

---

### 4. 瓒嬪娍缁熻

**接口**: `GET /stats/trends`

**鍔熻兘鎻忚堪**: 鑾峰彇鎸囧畾鏃堕棿鑼冨洿鍐呯殑瓒嬪娍鏁版嵁

**鏉冮檺瑕佹眰**: 鏃?
**鏌ヨ鍙傛暟**:

| 鍙傛暟鍚?| 绫诲瀷 | 蹇呭～ | 榛樿鍊?| 璇存槑 |
|--------|------|------|--------|------|
| days | integer | 鍚?| 30 | 缁熻澶╂暟锛堟渶灏?锛?|

**璇锋眰绀轰緥**:

```bash
GET /stats/trends?days=30
```

**鎴愬姛鍝嶅簲**:

| 鐘舵€佺爜 | 鏁版嵁缁撴瀯 | 璇存槑 |
|--------|----------|------|
| 200 | `Map<String, Object>` | 瓒嬪娍缁熻 |

**鍝嶅簲绀轰緥**:

```json
{
  "code": 200,
  "message": "鎴愬姛",
  "data": {
    "dailyStats": [
      {
        "date": "2024-01-01",
        "views": 100,
        "likes": 20,
        "comments": 5,
        "newMembers": 1,
        "newPosts": 2
      }
    ],
    "trends": {
      "views": "+15%",
      "likes": "+20%",
      "comments": "+10%",
      "newMembers": "+5%",
      "newPosts": "+25%"
    }
  }
}
```

---

### 5. 娲昏穬搴︾粺璁?
**接口**: `GET /stats/activity`

**鍔熻兘鎻忚堪**: 鑾峰彇鐢ㄦ埛娲昏穬搴︾粺璁℃暟鎹?
**鏉冮檺瑕佹眰**: 鏃?
**鎴愬姛鍝嶅簲**:

| 鐘舵€佺爜 | 鏁版嵁缁撴瀯 | 璇存槑 |
|--------|----------|------|
| 200 | `Map<String, Object>` | 娲昏穬搴︾粺璁?|

**鍝嶅簲绀轰緥**:

```json
{
  "code": 200,
  "message": "鎴愬姛",
  "data": {
    "dailyActiveUsers": 20,
    "weeklyActiveUsers": 35,
    "monthlyActiveUsers": 45,
    "averageSessionDuration": 1800,
    "mostActiveTime": "14:00-16:00",
    "mostActiveDay": "Wednesday",
    "activityByDay": [
      {
        "day": "Monday",
        "count": 15
      },
      {
        "day": "Tuesday",
        "count": 18
      },
      {
        "day": "Wednesday",
        "count": 20
      }
    ]
  }
}
```

---

### 6. 鍒嗙被缁熻

**接口**: `GET /stats/categories`

**鍔熻兘鎻忚堪**: 鑾峰彇鍐呭鎸夊垎绫荤殑缁熻鏁版嵁

**鏉冮檺瑕佹眰**: 鏃?
**鎴愬姛鍝嶅簲**:

| 鐘舵€佺爜 | 鏁版嵁缁撴瀯 | 璇存槑 |
|--------|----------|------|
| 200 | `Map<String, Object>` | 鍒嗙被缁熻 |

**鍝嶅簲绀轰緥**:

```json
{
  "code": 200,
  "message": "鎴愬姛",
  "data": {
    "projects": {
      "BLOCKCHAIN": 8,
      "SMART_CONTRACT": 5,
      "REAL_ESTATE": 3,
      "FOOD_SAFETY": 2,
      "INTELLECTUAL_PROPERTY": 2
    },
    "posts": {
      "鍖哄潡閾?: 40,
      "鎶€鏈?: 30,
      "鐮旂┒": 20,
      "鍏朵粬": 10
    },
    "meetings": {
      "SEMINAR": 15,
      "PROGRESS_REPORT": 10,
      "TEAM_MEETING": 5
    }
  }
}
```

---

### 7. 鏂囦欢缁熻

**接口**: `GET /stats/files`

**鍔熻兘鎻忚堪**: 鑾峰彇鏂囦欢鐩稿叧鐨勭粺璁℃暟鎹?
**鏉冮檺瑕佹眰**: 鏃?
**鎴愬姛鍝嶅簲**:

| 鐘舵€佺爜 | 鏁版嵁缁撴瀯 | 璇存槑 |
|--------|----------|------|
| 200 | `Map<String, Object>` | 鏂囦欢缁熻 |

**鍝嶅簲绀轰緥**:

```json
{
  "code": 200,
  "message": "鎴愬姛",
  "data": {
    "totalFiles": 15,
    "totalSize": 52428800,
    "totalDownloads": 500,
    "averageFileSize": 3495253,
    "filesByType": {
      "application/pdf": 8,
      "image/jpeg": 4,
      "application/zip": 3
    },
    "filesByCategory": {
      "鏂囨。": 8,
      "鍥剧墖": 4,
      "鍘嬬缉鍖?: 3
    },
    "mostDownloadedFiles": [
      {
        "id": 1,
        "fileName": "document.pdf",
        "downloadCount": 100
      }
    ]
  }
}
```

---

### 8. 鏃堕棿鑼冨洿缁熻

**接口**: `GET /stats/range`

**鍔熻兘鎻忚堪**: 鑾峰彇鎸囧畾鏃堕棿鑼冨洿鍐呯殑缁熻鏁版嵁

**鏉冮檺瑕佹眰**: 鏃?
**鏌ヨ鍙傛暟**:

| 鍙傛暟鍚?| 绫诲瀷 | 蹇呭～ | 璇存槑 |
|--------|------|------|------|
| startDate | string | 鏄?| 寮€濮嬫棩鏈燂紙YYYY-MM-DD锛?|
| endDate | string | 鏄?| 缁撴潫鏃ユ湡锛圷YYY-MM-DD锛?|

**璇锋眰绀轰緥**:

```bash
GET /stats/range?startDate=2024-01-01&endDate=2024-01-31
```

**鎴愬姛鍝嶅簲**:

| 鐘舵€佺爜 | 鏁版嵁缁撴瀯 | 璇存槑 |
|--------|----------|------|
| 200 | `Map<String, Object>` | 鏃堕棿鑼冨洿缁熻 |

**鍝嶅簲绀轰緥**:

```json
{
  "code": 200,
  "message": "鎴愬姛",
  "data": {
    "startDate": "2024-01-01",
    "endDate": "2024-01-31",
    "newMembers": 5,
    "newPosts": 20,
    "newProjects": 2,
    "newMeetings": 5,
    "newFiles": 3,
    "totalViews": 5000,
    "totalLikes": 200,
    "totalComments": 50
  }
}
```

**澶辫触鍝嶅簲**:

| 鐘舵€佺爜 | 閿欒鐮?| 閿欒淇℃伅 | 瑙﹀彂鍦烘櫙 |
|--------|--------|----------|----------|
| 400 | 400 | 鏃ユ湡鏍煎紡閿欒 | 鏃ユ湡鏍煎紡涓嶆纭?|

**閿欒鍝嶅簲绀轰緥**:

```json
{
  "message": "鏃ユ湡鏍煎紡閿欒"
}
```

---

### 9. 瀹炴椂缁熻

**接口**: `GET /stats/realtime`

**鍔熻兘鎻忚堪**: 鑾峰彇瀹炴椂鐨勭郴缁熺粺璁℃暟鎹?
**鏉冮檺瑕佹眰**: 鏃?
**鎴愬姛鍝嶅簲**:

| 鐘舵€佺爜 | 鏁版嵁缁撴瀯 | 璇存槑 |
|--------|----------|------|
| 200 | `Map<String, Object>` | 瀹炴椂缁熻 |

**鍝嶅簲绀轰緥**:

```json
{
  "code": 200,
  "message": "鎴愬姛",
  "data": {
    "onlineUsers": 10,
    "currentTimestamp": "2024-01-15T14:30:00",
    "recentActivity": [
      {
        "type": "VIEW",
        "user": "寮犱笁",
        "timestamp": "2024-01-15T14:30:00"
      }
    ]
  }
}
```

---

### 10. 瀵煎嚭缁熻

**接口**: `GET /stats/export`

**鍔熻兘鎻忚堪**: 瀵煎嚭缁熻鏁版嵁涓篔SON鏍煎紡

**鏉冮檺瑕佹眰**: 鏃?
**鎴愬姛鍝嶅簲**:

| 鐘舵€佺爜 | 鏁版嵁缁撴瀯 | 璇存槑 |
|--------|----------|------|
| 200 | `Map<String, Object>` | 瀵煎嚭鐨勭粺璁℃暟鎹?|

**鍝嶅簲绀轰緥**:

```json
{
  "code": 200,
  "message": "鎴愬姛",
  "data": {
    "exportTime": "2024-01-15T14:30:00",
    "overview": {
      "totalMembers": 50,
      "totalProjects": 20,
      "totalPosts": 100,
      "totalMeetings": 30,
      "totalFiles": 15
    },
    "users": {
      "totalMembers": 50,
      "activeMembers": 45
    },
    "content": {
      "posts": {
        "total": 100,
        "published": 80
      },
      "projects": {
        "total": 20,
        "ongoing": 15
      }
    }
  }
}
```

---

## 鏁版嵁缁撴瀯璇存槑

### 缁熻鏁版嵁閫氱敤鏍煎紡

鎵€鏈夌粺璁℃帴鍙ｉ兘杩斿洖缁熶竴鐨勬暟鎹牸寮忥細

```json
{
  "code": 200,
  "message": "鎴愬姛",
  "data": {
    // 鍏蜂綋鐨勭粺璁℃暟鎹?  }
}
```

### 瀛楁璇存槑

| 瀛楁鍚?| 绫诲瀷 | 璇存槑 |
|--------|------|------|
| code | integer | 鐘舵€佺爜锛?00琛ㄧず鎴愬姛锛?|
| message | string | 娑堟伅 |
| data | object | 鍏蜂綋鐨勭粺璁℃暟鎹?|

---

## 娉ㄦ剰浜嬮」

1. **鏁版嵁鏇存柊**: 缁熻鏁版嵁瀹炴椂鏇存柊锛屽弽鏄犳渶鏂扮殑绯荤粺鐘舵€?2. **缂撳瓨鏈哄埗**: 閮ㄥ垎缁熻鎺ュ彛鍙兘鏈夌紦瀛橈紝鏁版嵁鍙兘涓嶆槸瀹屽叏瀹炴椂鐨?3. **鎬ц兘鑰冭檻**: 澶嶆潅鐨勭粺璁℃煡璇㈠彲鑳介渶瑕佽緝闀挎椂闂?4. **鏁版嵁鏉冮檺**: 鎵€鏈夌粺璁℃暟鎹兘鏄叕寮€鐨勶紝鏃犻渶鐗规畩鏉冮檺
5. **瀵煎嚭闄愬埗**: 瀵煎嚭鍔熻兘鍙兘瀵规暟鎹噺鏈夐檺鍒?6. **鏃堕棿鏍煎紡**: 鎵€鏈夋椂闂村瓧娈甸兘浣跨敤ISO 8601鏍煎紡锛圷YYY-MM-DDTHH:mm:ss锛

