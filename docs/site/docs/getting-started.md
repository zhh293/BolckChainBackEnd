---
sidebar_position: 2
---

# 快速开始

本指南将帮助您快速开始使用区块链实验室网站后端API。

## 环境准备

### 开发环境

```
http://localhost:8082/api
```

### 测试环境

```
http://test.blockchain-lab.com:8082/api
```

### 生产环境

```
http://blockchain-lab.com:8082/api
```

## 认证流程

### 1. 管理员登录

首先需要通过登录接口获取Session ID。

**请求示例**:

```bash
curl -X POST http://localhost:8082/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "username": "admin",
    "password": "123456"
  }'
```

**响应示例**:

```json
{
  "token": "admin_session",
  "refreshToken": "",
  "expiresIn": 3600000,
  "username": "admin",
  "role": "ADMIN"
}
```

### 2. 使用Session ID

登录成功后，系统会自动设置Cookie。后续请求会自动携带Session ID。

## 基本请求示例

### 获取所有成员

```bash
curl -X GET http://localhost:8082/api/members \
  -H "Cookie: JSESSIONID=admin_session"
```

### 创建新项目

```bash
curl -X POST http://localhost:8082/api/projects \
  -H "Content-Type: application/json" \
  -H "Cookie: JSESSIONID=admin_session" \
  -d '{
    "name": "区块链供应链项目",
    "description": "基于区块链技术的供应链管理系统",
    "category": "BLOCKCHAIN",
    "status": "PLANNING",
    "startDate": "2024-01-01",
    "budget": 100000,
    "progress": 0,
    "isPublic": true
  }'
```

## 分页查询

大多数列表接口都支持分页查询。

### 请求参数

| 参数 | 类型 | 必填 | 默认值 | 说明 |
|------|------|------|--------|------|
| page | integer | 否 | 0 | 页码（从0开始） |
| size | integer | 否 | 20 | 每页大小 |
| sortBy | string | 否 | id | 排序字段 |
| sortDirection | string | 否 | DESC | 排序方向（ASC/DESC） |

### 示例

```bash
curl -X GET "http://localhost:8082/api/projects?page=0&size=10&sortBy=createdAt&sortDirection=DESC" \
  -H "Cookie: JSESSIONID=admin_session"
```

## 错误处理

所有接口在发生错误时会返回统一的错误格式。

### 错误响应示例

```json
{
  "code": 401,
  "message": "未找到有效 Session，浏览器未携带 JSESSIONID 或 Session 已失效",
  "data": null
}
```

### 常见错误码

| 错误码 | 说明 |
|--------|------|
| 400 | 请求参数错误 |
| 401 | 未授权 |
| 404 | 资源不存在 |
| 500 | 服务器内部错误 |

## 下一步

- 查看[认证管理](./authentication.md)了解详细的认证机制
- 查看[API接口](./api/auth.md)了解具体的接口使用方法
- 查看[错误码](./error-codes.md)了解所有可能的错误信息
- 查看[OpenAPI 与在线调试](./openapi.md)直接在 Swagger/Redoc 中调试接口
- 查看[Postman 集合](./postman.md)一键导入联调