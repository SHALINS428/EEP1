<template>
    <el-menu
        active-text-color="#ffd04b"
        background-color="#95bff9"
        class="el-menu-vertical-demo"
        :default-active="$route.path"
        text-color="#fff"
        :router="true"
    >
        <template v-for="(item, index) in $router.options.routes" :key="index">
            <!-- 单个菜单项 -->
            <el-menu-item
                :index="item.path"
                v-if="item.children === undefined && item.meta && item.meta.show"
            >
                <component :is="item.meta.icon" class="icon"></component>
                <span>{{ item.meta.title }}</span>
            </el-menu-item>

            <!-- 子菜单 -->
            <el-sub-menu
                :index="item.path"
                v-if="item.children !== undefined && item.meta && item.meta.show"
            >
                <template #title>
                    <component :is="item.meta.icon" class="icon"></component>
                    <span>{{ item.meta.title }}</span>
                </template>
                <el-menu-item-group :title="item.meta.title">
                    <template
                        v-for="(child, childIndex) in item.children"
                        :key="childIndex"
                    >
                        <el-menu-item
                            :index="child.path"
                            v-if="child.meta && child.meta.show"
                        >
                            <component
                                :is="child.meta.icon"
                                class="icon"
                            ></component>
                            <p>{{ child.meta.title }}</p>
                        </el-menu-item>
                    </template>
                </el-menu-item-group>
            </el-sub-menu>
        </template>
    </el-menu>
</template>

<script lang="ts" setup>
// 此处无需额外逻辑，依赖 Vue Router 提供的 routes 配置
</script>

<style scoped>
.el-menu-item span {
    font-size: 18px;
    font-weight: 700;
}
.el-sub-menu span {
    font-size: 18px;
    font-weight: 700;
}
.el-sub-menu p {
    font-size: 16px;
    font-weight: 700;
}
.el-menu-vertical-demo:not(.el-menu--collapse) {
    width: 200px;
    min-height: calc(100vh - 50px);
}
.icon {
    width: 20px;
    height: 20px;
    padding-right: 5px;
}
</style>
