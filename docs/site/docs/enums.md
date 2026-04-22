---
sidebar_position: 2
---

# 枚举值

本文档列出了API接口中使用的所有枚举类型及其可选值。

## 成员相关枚举

### 成员角色 (MemberRole)

| 值 | 说明 |
|----|------|
| STUDENT | 学生 |
| TEACHER | 教师 |
| POSTDOCTOR | 博士后 |

### 成员状态 (MemberStatus)

| 值 | 说明 |
|----|------|
| ACTIVE | 活跃 |
| INACTIVE | 非活跃 |
| GRADUATED | 已毕业 |

## 项目相关枚举

### 项目分类 (ProjectCategory)

| 值 | 说明 |
|----|------|
| BLOCKCHAIN | 区块链 |
| SMART_CONTRACT | 智能合约 |
| REAL_ESTATE | 房地产 |
| FOOD_SAFETY | 食品安全 |
| INTELLECTUAL_PROPERTY | 知识产权 |

### 项目状态 (ProjectStatus)

| 值 | 说明 |
|----|------|
| PLANNING | 计划中 |
| IN_PROGRESS | 进行中 |
| COMPLETED | 已完成 |
| CANCELLED | 已取消 |
| ON_HOLD | 暂停 |
| ONGOING | 持续进行 |

## 文章相关枚举

### 文章状态 (PostStatus)

| 值 | 说明 |
|----|------|
| DRAFT | 草稿 |
| PUBLISHED | 已发布 |
| ARCHIVED | 已归档 |

## 例会相关枚举

### 例会类型 (MeetingType)

| 值 | 说明 |
|----|------|
| SEMINAR | 研讨会 |
| PROGRESS_REPORT | 进度汇报 |
| TEAM_MEETING | 团队会议 |

### 例会状态 (MeetingStatus)

| 值 | 说明 |
|----|------|
| SCHEDULED | 已安排 |
| COMPLETED | 已完成 |
| CANCELLED | 已取消 |

## 文件相关枚举

### 文件分类 (FileCategory)

| 值 | 说明 |
|----|------|
| 文档 | 文档文件 |
| 图片 | 图片文件 |
| 视频 | 视频文件 |
| 音频 | 音频文件 |
| 压缩包 | 压缩包文件 |
| 其他 | 其他文件 |

### 文件类型 (FileType)

支持的文件类型包括：

| MIME类型 | 扩展名 | 说明 |
|----------|--------|------|
| application/pdf | .pdf | PDF文档 |
| application/msword | .doc | Word文档（旧版） |
| application/vnd.openxmlformats-officedocument.wordprocessingml.document | .docx | Word文档 |
| application/vnd.ms-excel | .xls | Excel表格（旧版） |
| application/vnd.openxmlformats-officedocument.spreadsheetml.sheet | .xlsx | Excel表格 |
| application/vnd.ms-powerpoint | .ppt | PowerPoint演示文稿（旧版） |
| application/vnd.openxmlformats-officedocument.presentationml.presentation | .pptx | PowerPoint演示文稿 |
| text/plain | .txt | 纯文本 |
| image/jpeg | .jpg, .jpeg | JPEG图片 |
| image/png | .png | PNG图片 |
| image/gif | .gif | GIF图片 |
| image/webp | .webp | WebP图片 |
| application/zip | .zip | ZIP压缩包 |
| application/x-rar-compressed | .rar | RAR压缩包 |
| application/x-7z-compressed | .7z | 7Z压缩包 |

## 排序相关枚举

### 排序方向 (SortDirection)

| 值 | 说明 |
|----|------|
| ASC | 升序 |
| DESC | 降序 |

## 通用枚举

### HTTP方法 (HttpMethod)

| 值 | 说明 |
|----|------|
| GET | 获取资源 |
| POST | 创建资源 |
| PUT | 更新资源（完整更新） |
| PATCH | 更新资源（部分更新） |
| DELETE | 删除资源 |

## 使用说明

### 在请求中使用枚举值

枚举值通常作为字符串传递，例如：

```json
{
  "role": "STUDENT",
  "status": "ACTIVE"
}
```

### 在查询参数中使用枚举值

枚举值也可以在查询参数中使用，例如：

```
GET /members?status=ACTIVE
GET /projects?category=BLOCKCHAIN
```

### 枚举值的大小写

所有枚举值都是大写字母，使用下划线分隔单词。例如：
- `IN_PROGRESS`（正确）
- `in_progress`（错误）
- `In Progress`（错误）

### 枚举值的扩展

枚举值可能会在未来版本中扩展，客户端应该能够处理未知的枚举值。

## 常见问题

### Q: 如果传递了无效的枚举值会怎样？

A: 服务器会返回400错误，错误信息会说明哪个字段的枚举值无效。

### Q: 枚举值会变化吗？

A: 已有的枚举值不会变化，但可能会新增枚举值。新增的枚举值会在更新日志中说明。

### Q: 如何获取所有可用的枚举值？

A: 可以查看OpenAPI规范文件，其中包含了所有枚举值的定义。