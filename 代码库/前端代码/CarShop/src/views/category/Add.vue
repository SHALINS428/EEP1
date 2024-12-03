<template>
    <div class="category-page">
      <h1>类目管理</h1>
  
      <!-- 类目添加表单 -->
      <div class="form-section">
        <h4>添加新类目</h4>
        <el-form :model="form" label-width="100px" class="demo-form">
          <el-form-item label="类目名称">
            <el-input v-model="form.name" placeholder="请输入类目名称" />
          </el-form-item>
          <el-form-item label="类目描述">
            <el-input v-model="form.description" placeholder="请输入类目描述" />
          </el-form-item>
          <el-form-item>
            <el-button :loading="loading" type="primary" @click="addCategory">添加</el-button>
          </el-form-item>
        </el-form>
      </div>
  
      <!-- 类目列表 -->
      <div class="category-list">
        <h2>现有类目</h2>
        <el-table :data="categories" style="width: 100%">
          <el-table-column prop="id" label="ID" width="100" />
          <el-table-column prop="name" label="类目名称" />
          <el-table-column prop="description" label="类目描述" />
          <el-table-column label="操作">
            <template #default="scope">
              <el-button size="mini" type="text" @click="deleteCategory(scope.row)">
                删除
              </el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>
    </div>
  </template>
  
  
  <script lang="ts" setup>
import { ref, onMounted } from "vue";
import axios from "axios";

// 类目列表类型定义
type Category = {
  id: number;
  name: string;
  description?: string;
  parentId: number;
  isActive: boolean;
};

// 类目数据
const categories = ref<Category[]>([]);

// 表单模型
const form = ref({
  name: "",
  description: "",
});

// 加载状态
const loading = ref(false);

// 获取类目列表
const fetchCategories = async () => {
  try {
    const response = await axios.get("http://localhost:8080/api/categories");
    categories.value = response.data.data as Category[];
  } catch (error) {
    console.error("获取类目失败:", error);
    alert("获取类目失败，请检查后端服务是否启动！");
  }
};

// 添加类目
const addCategory = async () => {
  if (!form.value.name.trim()) {
    alert("类目名称不能为空");
    return;
  }

  loading.value = true;

  try {
    const response = await axios.post("http://localhost:8080/api/categories", {
        name: form.value.name,
        description: form.value.description,
        parentId: 0, // 默认根类目
        isActive: true, // 默认激活
    });


    const newCategory = response.data as Category;
    categories.value.push(newCategory);


    form.value.name = "";
    form.value.description = "";
    alert("类目添加成功！");
  } catch (error) {
    console.error("添加类目失败:", error);
    alert("添加类目失败，请检查后端服务！");
  } finally {
    loading.value = false;
  }
};

// 删除类目
const deleteCategory = async (category: Category) => {
  try {
    await axios.delete(`http://localhost:8080/api/categories/${category.id}`);
    categories.value = categories.value.filter((item) => item.id !== category.id);
    alert("删除成功！");
  } catch (error) {
    console.error("删除类目失败:", error);
    alert("删除失败，请检查后端服务！");
  }
};

onMounted(() => {
  fetchCategories();
});
</script>

  
  <style scoped>
  .category-page {
    padding: 20px;
  }
  
  .form-section {
    margin-bottom: 20px;
  }
  
  .demo-form {
    max-width: 400px;
  }
  
  .category-list {
    margin-top: 20px;
  }
  </style>
  