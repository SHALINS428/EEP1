<template>
    <!-- 查询 -->
    <el-form :inline="true" :model="fromData" class="demo-form-inline">
        <el-form-item label="品牌编号">
            <el-input v-model="fromData.id" placeholder="请输入正确的编号" clearable />
        </el-form-item>
        <el-form-item label="品牌名称">
            <el-input v-model="fromData.name" placeholder="请输入正确的名称" clearable />
        </el-form-item>
        <el-form-item label="批量查询">
            <el-input v-model="fromData.ids" placeholder="请输入正确的编号" clearable />
        </el-form-item>

        <el-form-item>
            <el-button type="primary" @click="onSubmit">查询</el-button>
        </el-form-item>
    </el-form>


    <!--列表数据-->
    <el-table :data="tableData" style="width: 100%">
        <el-table-column fixed prop="id" label="汽车编号" width="90" />
        <el-table-column prop="name" label="汽车名字" width="120" />
        <el-table-column prop="img" label="汽车图片" width="120">
            <template #default="scope">
                <img :src="scope.row.img" alt="" width="50px" height="50px">
            </template>

        </el-table-column>
        <el-table-column prop="seq" label="汽车排序" width="90" />
        <el-table-column prop="status" label="状态码" width="100" />
        <el-table-column prop="parentId" label="父目录ID" width="120" />
        <el-table-column prop="lastupdatetime" label="更新时间" width="120" />

        <el-table-column fixed="right" label="操作" min-width="150">
            <template #default>
                <el-button type="danger" size="small" @click="handleClick">
                    下线
                </el-button>
                <el-button type="warning" size="small">编辑</el-button>
            </template>
        </el-table-column>
    </el-table>

</template>
<script lang="ts" setup>
import { ref, onMounted, reactive } from "vue"
// import axios from "axios"
import {CategoryApi} from "@/api"

const tableData = ref([])
const fromData = reactive({
    id: '',
    name: '',
    ids: [],
    parentId:''
})

//渲染的钩子函数
onMounted(() => { 
    // axios({
    //     method: 'get',
    //     url:'/api/category'
    // }).then((res) => { 
    //     console.log(res.data);
    //     tableData.value=res.data
    // })
    CallCategoryApi()
})
//构建一个函数 用来封装后台的API接口
const CallCategoryApi = () => { 
    let id = fromData.id === '' ? undefined : fromData.id
    let name = fromData.name === '' ? undefined : fromData.name
    let ids = fromData.ids == []? undefined : fromData.ids

    CategoryApi.select.call({id:id,name:name,ids:ids}).then((res) => { 
        console.log(res);
        tableData.value=res.data
    })
}

const onSubmit = () => {
    console.log('submit!')
    //回调函数 显示查询后的内容
    CallCategoryApi()
}
</script>
<style scoped></style>