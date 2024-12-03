<template>
 <el-container>
        <el-header>
            <el-row class="row-bg" justify="space-between">
                <el-col :span="6" class="logo">
                    <img src="../src/assets/logo.jpg" alt="">
                </el-col>
                <el-col :span="6" class="title">
                    <span>汽车服务平台</span>
                </el-col>
                <el-col :span="6">
                    <el-dropdown>
                        <span class="el-dropdown-link">
                            美杜莎 <el-icon>
                                <User />
                            </el-icon>
                            <el-icon class="el-icon--right">
                                <arrow-down />
                            </el-icon>
                        </span>
                        <template #dropdown>
                            <el-dropdown-menu>
                                <el-dropdown-item>个人中心</el-dropdown-item>
                                <el-dropdown-item>账户与安全</el-dropdown-item>
                                <el-dropdown-item>关于我们</el-dropdown-item>
                                <el-dropdown-item disabled>设置</el-dropdown-item>
                                <el-dropdown-item divided command="logout">注销</el-dropdown-item>
                            </el-dropdown-menu>
                        </template>
                    </el-dropdown>
                </el-col>
            </el-row>
        </el-header>
        <el-container>
            <el-aside width="200px">
                <Menu></Menu>
            </el-aside>
            <el-main>
                <!--路由的出口只为 展示路由的内容-->
                <RouterView></RouterView>
            </el-main>
        </el-container>
    </el-container>


</template>
<script setup lang="ts">
//引用组件
import Menu from "@/components/Menu.vue"
import { User, ArrowDown } from "@element-plus/icons-vue";


</script>
<style scoped>
.el-header{
    background-color: #8ab7f3;
    height: 50px;
    padding: 0px;
}
.logo img{
    width: 200px;
    height: 50px;
}
.title span{
    font-size: 21px;
    color: white;
    font-weight: 800;
    line-height: 50px;
    text-align: center;
    padding: 0px 51px;

}
.el-dropdown{
    float: right;
   line-height: 50px;
   padding-right: 5px;
   color: white;
   font-size: 19px;
   font-weight: 800;
}
</style>
