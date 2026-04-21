---
sidebar_position: 21
---

# Postman 集合

## 一键导入链接

- Postman Collection: `/postman/blockchain-backend.postman_collection.json`

## 导入方式

1. 打开 Postman，点击 Import。
2. 选择 Link。
3. 粘贴上面的链接（站点部署域名 + 路径）。
4. 导入后选择环境变量 `baseUrl`，即可直接调试。

## 变量说明

- `baseUrl`: 默认 `http://localhost:8082/api`
- `jsessionid`: 登录后从 `Set-Cookie` 获取
