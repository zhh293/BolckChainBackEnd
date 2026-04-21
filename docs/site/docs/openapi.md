---
sidebar_position: 20
---

# OpenAPI 与在线调试

## 规范文件

- OpenAPI YAML: `/openapi.yaml`
- OpenAPI JSON: `/openapi.json`

## 交互式文档

- Swagger UI: `/swagger/index.html`
- Redoc: `/redoc/index.html`

## 前端复制参数建议

1. 在 Swagger UI 中选择接口后点击 Try it out。
2. 填写路径参数、查询参数、请求体。
3. 直接复制 Curl 或 Request URL。
4. 对需要会话态的接口，在 Header 中添加 `Cookie: JSESSIONID=...`。

## 鉴权说明

- 技术鉴权：当前后端 `SecurityConfig` 为全放行。
- 业务鉴权：部分写接口要求已登录 Session 或隐藏入口访问约定。
- 以代码行为为准：文档中已明确标注请求前置条件和异常场景。
