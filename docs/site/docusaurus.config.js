const { themes } = require('prism-react-renderer');

module.exports = {
  title: '区块链实验室网站后端API文档',
  tagline: 'RESTful API 接口文档',
  favicon: 'img/favicon.ico',
  url: 'https://blockchain-lab.com',
  baseUrl: '/api-docs/',
  organizationName: 'blockchain-lab',
  projectName: 'blockchain-backend-api',
  onBrokenLinks: 'warn',
  i18n: {
    defaultLocale: 'zh-CN',
    locales: ['zh-CN'],
  },
  markdown: {
    hooks: {
      onBrokenMarkdownLinks: 'warn',
    },
  },
  presets: [
    [
      'classic',
      {
        docs: {
          sidebarPath: require.resolve('./sidebars.js'),
          editUrl: 'https://github.com/blockchain-lab/blockchain-backend-api/tree/main/docs',
          routeBasePath: '/',
        },
        blog: false,
        theme: {
          customCss: require.resolve('./src/css/custom.css'),
        },
      },
    ],
  ],
  themeConfig:
    ({
      navbar: {
        title: 'API文档',
        logo: {
          alt: '区块链实验室',
          src: 'img/logo.svg',
          href: '/intro',
        },
        items: [
          {
            to: '/intro',
            label: '接口文档',
            position: 'left',
          },
          {
            href: '/swagger/index.html',
            label: 'Swagger UI',
            position: 'left',
          },
          {
            href: '/redoc/index.html',
            label: 'Redoc',
            position: 'left',
          },
          {
            to: '/postman',
            label: 'Postman',
            position: 'left',
          },
          {
            href: 'https://github.com/blockchain-lab/blockchain-backend-api',
            label: 'GitHub',
            position: 'right',
          },
        ],
      },
      footer: {
        style: 'dark',
        links: [
          {
            title: '文档',
            items: [
              {
                label: '接口文档',
                to: '/intro',
              },
              {
                label: 'OpenAPI规范',
                to: '/openapi',
              },
            ],
          },
          {
            title: '社区',
            items: [
              {
                label: 'GitHub',
                href: 'https://github.com/blockchain-lab/blockchain-backend-api',
              },
            ],
          },
          {
            title: '更多',
            items: [
              {
                label: '更新日志',
                to: '/changelog',
              },
            ],
          },
        ],
        copyright: `Copyright © ${new Date().getFullYear()} 区块链实验室. Built with Docusaurus.`,
      },
      prism: {
        theme: themes.github,
        darkTheme: themes.dracula,
        additionalLanguages: ['java', 'bash', 'json', 'yaml'],
      },
      colorMode: {
        defaultMode: 'light',
        disableSwitch: false,
        respectPrefersColorScheme: true,
      },
    }),
  plugins: [
    [
      require.resolve('@easyops-cn/docusaurus-search-local'),
      {
        indexDocs: true,
        indexBlog: false,
        language: ['en', 'zh'],
      },
    ],
  ],
};