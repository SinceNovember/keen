import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/views/login'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    { 
      "id": 1,
      "path": "/",
      "parentId": null,
      "name": "Utilities",
      "redirect": "/user",
      "meta": {
        "title": "Dashboards",
        "icon": "bi-grid fs-3",
        "breadCrumb": true
      },
      'isExpand': false,
      'isHover': false,
      "type": "DIRECTORY",
      "orderNum": 9,
      "hidden": false,
      "alwaysShow": true,
      "requestMethod": "GET",
      "children": [{
        "id": 88,
        "path": "/",
        "parentId": null,
        "name": "Modals",
        "redirect": "/user",
        'isExpand': false,
        'isHover': false,

        "meta": {
          "title": "Modals",
          "icon":  "bi-grid fs-3",
          "breadCrumb": true
        },
        "parentId": 1,
        "type": "DIRECTORY",
        "orderNum": 9,
        "hidden": false,
        "alwaysShow": true,
        "requestMethod": "GET",
        "children": [{
          "id": 92,
          "path": "/",
          "parentId": null,
          "name": "General",
          "redirect": "/user",
          'isExpand': false,
          'isHover': false,
          "meta": {
            "title": "General",
            "icon": "",
            "breadCrumb": true
          },
          "type": "DIRECTORY",
          "parentId": 1,
          "orderNum": 9,
          "hidden": false,
          "alwaysShow": true,
          "requestMethod": "GET",
          "children": []
        },{
          "id": 93,
          "path": "/",
          "parentId": null,
          "name": "Forms",
          "redirect": "/user",
          'isExpand': false,
          'isHover': false,
          "parentId": 1,
          "meta": {
            "title": "Forms",
            "icon": "",
            "breadCrumb": true
          },
          "type": "DIRECTORY",
          "orderNum": 9,
          "hidden": false,
          "alwaysShow": true,
          "requestMethod": "GET",
          "children": []
        }]
      },
      {
        "id": 89,
        "path": "/",
        "parentId": null,
        "name": "Search",
        'isExpand': false,
        'isHover': false,
        "redirect": "/user",
        "parentId": 1,
        "meta": {
          "title": "Search",
          "icon": "",
          "breadCrumb": true
        },
        "type": "DIRECTORY",
        "orderNum": 9,
        "hidden": false,
        "alwaysShow": true,
        "requestMethod": "GET",
        "children": [{
          "id": 88,
          "path": "/",
          "parentId": null,
          "name": "Modals",
          "redirect": "/user",
          'isExpand': false,
          'isHover': false,
          "meta": {
            "title": "Modals",
            "breadCrumb": true
          },
          "parentId": 1,
          "type": "DIRECTORY",
          "orderNum": 9,
          "hidden": false,
          "alwaysShow": true,
          "requestMethod": "GET",
          "children": [{
            "id": 92,
            "path": "/",
            "parentId": null,
            "name": "General",
            "redirect": "/user",
            'isExpand': false,
            'isHover': false,
            "meta": {
              "title": "General",
              "icon": "",
              "breadCrumb": true
            },
            "type": "DIRECTORY",
            "parentId": 1,
            "orderNum": 9,
            "hidden": false,
            "alwaysShow": true,
            "requestMethod": "GET",
            "children": []
          },{
            "id": 93,
            "path": "/",
            "parentId": null,
            "name": "Forms",
            "redirect": "/user",
            'isExpand': false,
            'isHover': false,
            "parentId": 1,
            "meta": {
              "title": "Forms",
              "icon": "",
              "breadCrumb": true
            },
            "type": "DIRECTORY",
            "orderNum": 9,
            "hidden": false,
            "alwaysShow": true,
            "requestMethod": "GET",
            "children": []
          }]
        },
        {
          "id": 89,
          "path": "/",
          "parentId": null,
          "name": "Search",
          'isExpand': false,
          'isHover': false,
          "redirect": "/user",
          "parentId": 1,
          "meta": {
            "title": "Search",
            "icon": "",
            "breadCrumb": true
          },
          "type": "DIRECTORY",
          "orderNum": 9,
          "hidden": false,
          "alwaysShow": true,
          "requestMethod": "GET",
          "children": []
        },
        {
          "id": 90,
          "path": "/",
          "parentId": null,
          "name": "Wizards",
          'isExpand': false,
          'isHover': false,
          "redirect": "/user",
          "meta": {
            "title": "Wizards",
            "icon": "",
            "breadCrumb": true
          },
          "type": "DIRECTORY",
          "orderNum": 9,
          "hidden": false,
          "alwaysShow": true,
          "requestMethod": "GET",
          "children": []
        }]
      },
      {
        "id": 90,
        "path": "/",
        "parentId": null,
        "name": "Wizards",
        'isExpand': false,
        'isHover': false,
        "redirect": "/user",
        "meta": {
          "title": "Wizards",
          "icon": "",
          "breadCrumb": true
        },
        "type": "DIRECTORY",
        "orderNum": 9,
        "hidden": false,
        "alwaysShow": true,
        "requestMethod": "GET",
        "children": []
      }]
    },
    {
      "id": 1,
      "path": "/",
      "parentId": null,
      "name": "Utilities",
      "redirect": "/user",
      "meta": {
        "title": "测试",
        "icon": "bi-grid fs-3",
        "breadCrumb": true
      },
      'isExpand': false,
      'isHover': false,
      "type": "DIRECTORY",
      "orderNum": 9,
      "hidden": false,
      "alwaysShow": true,
      "requestMethod": "GET",
      "children": [{
        "id": 88,
        "path": "/",
        "parentId": 1,
        "name": "Modals",
        "redirect": "/user",
        'isExpand': false,
        'isHover': false,
        "meta": {
          "title": "测试2",
          "breadCrumb": true
        },
        "parentId": 1,
        "type": "DIRECTORY",
        "orderNum": 9,
        "hidden": false,
        "alwaysShow": true,
        "requestMethod": "GET",
        "children": []
      },
      {
        "id": 89,
        "path": "/",
        "parentId": null,
        "name": "Search",
        'isExpand': false,
        'isHover': false,
        "redirect": "/user",
        "parentId": 1,
        "meta": {
          "title": "测试3",
          "icon": "",
          "breadCrumb": true
        },
        "type": "DIRECTORY",
        "orderNum": 9,
        "hidden": false,
        "alwaysShow": true,
        "requestMethod": "GET",
        "children": []
      },
      {
        "id": 90,
        "path": "/",
        "parentId": null,
        "name": "Wizards",
        'isExpand': false,
        'isHover': false,
        "redirect": "/user",
        "meta": {
          "title": "Wizards",
          "icon": "",
          "breadCrumb": true
        },
        "parentId": 1,

        "type": "DIRECTORY",
        "orderNum": 9,
        "hidden": false,
        "alwaysShow": true,
        "requestMethod": "GET",
        "children": []
      }]
    },
    {
      "id": 1,
      "path": "/",
      "parentId": null,
      "name": "Utilities",
      "redirect": "/user",
      "meta": {
        "title": "系统管理",
        "icon": "bi-grid fs-3",
        "breadCrumb": true
      },
      'isExpand': false,
      'isHover': false,
      "type": "DIRECTORY",
      "orderNum": 9,
      "hidden": false,
      "alwaysShow": true,
      "requestMethod": "GET",
      "children": [{
        "id": 88,
        "path": "/",
        "parentId": 1,
        "name": "Modals",
        "redirect": "/user",
        'isExpand': false,
        'isHover': false,
        "meta": {
          "title": "数据管理1",
          "breadCrumb": true
        },
        "parentId": 1,
        "type": "DIRECTORY",
        "orderNum": 9,
        "hidden": false,
        "alwaysShow": true,
        "requestMethod": "GET",
        "children": []
      },
      {
        "id": 89,
        "path": "/",
        "parentId": null,
        "name": "Search",
        'isExpand': false,
        'isHover': false,
        "redirect": "/user",
        "parentId": 1,
        "meta": {
          "title": "数据管理12",
          "icon": "",
          "breadCrumb": true
        },
        "type": "DIRECTORY",
        "orderNum": 9,
        "hidden": false,
        "alwaysShow": true,
        "requestMethod": "GET",
        "children": []
      },
      {
        "id": 90,
        "path": "/",
        "parentId": null,
        "name": "Wizards",
        'isExpand': false,
        'isHover': false,
        "redirect": "/user",
        "meta": {
          "title": "数据管理13",
          "icon": "",
          "breadCrumb": true
        },
        "parentId": 1,

        "type": "DIRECTORY",
        "orderNum": 9,
        "hidden": false,
        "alwaysShow": true,
        "requestMethod": "GET",
        "children": []
      },  {
        "id": 90,
        "path": "/",
        "parentId": null,
        "name": "Wizards",
        'isExpand': false,
        'isHover': false,
        "redirect": "/user",
        "meta": {
          "title": "数据管理15",
          "icon": "",
          "breadCrumb": true
        },
        "parentId": 1,

        "type": "DIRECTORY",
        "orderNum": 9,
        "hidden": false,
        "alwaysShow": true,
        "requestMethod": "GET",
        "children": []
      }]
    },
    {
      "id": 83,
      "path": "/metadata",
      "parentId": null,
      "name": "nnb",
      "redirect": "",
      'isExpand': false,
      'isHover': false,
      "meta": {
        "title": "元数据管理",
        "icon": "bi-sticky",
        "breadCrumb": true
      },
      "type": "DIRECTORY",
      "orderNum": 7,
      "hidden": false,
      "alwaysShow": true,
      "requestMethod": "GET",
      "children": [
        {
          "id": 84,
          "path": "/systemConfig",
          "parentId": 83,
          "name": "systemConfig",
          "redirect": "",
          'isExpand': false,
          'isHover': false,
          "meta": {
            "title": "系统参数",
            "icon": "mdi mdi-air-filter",
            "breadCrumb": true
          },
          "type": "MENU",
          "orderNum": 9,
          "hidden": false,
          "alwaysShow": true,
          "requestMethod": "GET",
          "children": []
        },
        {
          "id": 85,
          "path": "/codeMain",
          "parentId": 83,
          'isExpand': false,
          'isHover': false,
          "name": "ccc",
          "redirect": "",
          "meta": {
            "title": "代码管理",
            "icon": "mdi mdi-account-details",
            "breadCrumb": true
          },
          "type": "MENU",
          "orderNum": 8,
          "hidden": false,
          "alwaysShow": true,
          "requestMethod": "GET",
          "children": []
        }
      ]
    },
    {
      "id": 157,
      "path": "/monitor",
      "parentId": null,
      "name": "monitor",
      'isExpand': false,
      'isHover': false,
      "redirect": null,
      "meta": {
        "title": "系统监控",
        "icon": "bi-box-seam",
        "breadCrumb": true
      },
      "type": "DIRECTORY",
      "orderNum": 6,
      "hidden": false,
      "alwaysShow": true,
      "requestMethod": "GET",
      "children": [
        {
          "id": 158,
          "path": "/loginLog",
          "parentId": 157,
          "name": "loginLog",
          'isExpand': false,
          'isHover': false,
          "redirect": null,
          "meta": {
            "title": "登录日志",
            "icon": "",
            "breadCrumb": true
          },
          "type": "MENU",
          "orderNum": 0,
          "hidden": false,
          "alwaysShow": true,
          "requestMethod": "GET",
          "children": []
        },
        {
          "id": 159,
          "path": "/operateLog",
          "parentId": 157,
          "name": "operateLog",
          'isExpand': false,
          'isHover': false,
          "redirect": null,
          "meta": {
            "title": "操作日志",
            "icon": "",
            "breadCrumb": true
          },
          "type": "MENU",
          "orderNum": 0,
          "hidden": false,
          "alwaysShow": true,
          "requestMethod": "GET",
          "children": []
        }
      ]
    },
    {
      "id": 158,
      "path": "/loginLog",
      "parentId": 157,
      "name": "loginLog",
      'isExpand': false,
      'isHover': false,
      "redirect": null,
      "meta": {
        "title": "APPS",
        "icon": "",
        "breadCrumb": true
      },
      "type": "MENU",
      "orderNum": 0,
      "hidden": false,
      "alwaysShow": true,
      "requestMethod": "GET",
      "isHeader": true,
      "children": []
    },
    {
      "id": 158,
      "path": "/loginLog",
      "parentId": null,
      "name": "loginLog",
      'isExpand': false,
      'isHover': false,
      "redirect": null,
      "meta": {
        "title": "登录日志",
        "icon": "",
        "breadCrumb": true
      },
      "type": "MENU",
      "orderNum": 0,
      "hidden": false,
      "alwaysShow": true,
      "requestMethod": "GET",
      "children": []
    },
  
  ]
})
