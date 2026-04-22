module.exports = {
  apiSidebar: [
    {
      type: 'category',
      label: '快速开始',
      collapsed: false,
      items: ['intro', 'getting-started', 'authentication', 'dependency-and-idempotency'],
    },
    {
      type: 'category',
      label: 'API接口',
      collapsed: false,
      items: [
        'api/auth',
        'api/members',
        'api/projects',
        'api/posts',
        'api/meetings',
        'api/files',
        'api/stats',
        'api/cache',
        'api/performance',
        'api/visit-stats',
      ],
    },
    {
      type: 'category',
      label: '交付物',
      collapsed: false,
      items: ['openapi', 'postman', 'error-codes', 'enums', 'changelog', 'deprecation-policy'],
    },
  ],
};