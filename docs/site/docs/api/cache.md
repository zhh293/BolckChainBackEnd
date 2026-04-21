---
sidebar_position: 8
---

# 缓存管理接口

> 业务权限：建议仅后台运维入口调用。

## 接口列表

- `DELETE /cache/clear-all` 清空全部缓存
- `DELETE /cache/clear/{cacheName}` 清空指定缓存
- `GET /cache/names` 获取缓存名称列表

## 参数说明

### `clear/{cacheName}`

| 参数 | 位置 | 类型 | 必填 | 说明 |
|---|---|---|---|---|
| cacheName | path | string | 是 | 缓存名 |

## 成功响应示例

```json
"所有缓存清除成功，共清除 3 个缓存: posts, projects, members"
```

## 失败响应示例

```json
"清除缓存失败: Redis连接不可用"
```
