
import { createRouter, createWebHistory } from "vue-router";



//配置路由文件
const routes = [
    {
        path: '/',
        name: 'home',
        component: () => import('@/views/Home.vue'),
        //useFrame 为true时候 代表不是全屏显示  为false时候是全屏显示
        meta: { title: '首页', show: true, icon:'HomeFilled',useFrame:true },
    },
    {
        path: '/category',
        component: () => import('@/views/category/Index.vue'),
        meta: { title: '类目管理', show: true, icon: 'Grid' },
        children: [
            {
                path: '/category/add',
                name: 'category-add',
                component: () => import('@/views/category/Add.vue'),
                meta:{ title: '添加类目', show: true, icon:'Plus'}
            },
            {
                path: '/category/edit',
                name: 'category-edit',
                component: () => import('@/views/category/Edit.vue'),
                meta:{ title: '编辑类目', show: true, icon:'Edit'}
            },
            {
                path: '/category/list',
                name: 'category-list',
                component: () => import('@/views/category/List.vue'),
                meta:{ title: '类目列表', show: true, icon:'List'}
            }
               
            
        ]
    },
    {
        path: '/product',
        component: () => import('@/views/product/Index.vue'),
        meta: { title: '商品管理', show: true, icon: 'Briefcase' },
        children: [
            {
                path: '/product/add',
                name: 'product-add',
                component: () => import('@/views/product/Add.vue'),
                meta: { title: '新品添加', show: true, icon: 'Plus' }
            },
            {
                path: '/product/edit',
                name: 'product-edit',
                component: () => import('@/views/product/Edit.vue'),
                meta: { title: '商品编辑', show: true, icon: 'Edit' }
            },
            {
                path: '/product/list',
                name: 'product-list',
                component: () => import('@/views/product/List.vue'),
                meta: { title: '商品列表', show: true, icon: 'List' }
            }


        ]
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

//导出路由
export default router