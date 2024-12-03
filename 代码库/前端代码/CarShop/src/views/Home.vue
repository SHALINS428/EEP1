<template>
    <div class="home-page">
      <!-- 欢迎标题 -->
      <h1>欢迎来到汽车服务平台</h1>
  
      <!-- 按钮组 -->
      <!-- <div class="mb-4">
        <el-button>Default</el-button>
        <el-button type="primary">Primary</el-button>
        <el-button type="success">Success</el-button>
        <el-button type="info">Info</el-button>
        <el-button type="warning">Warning</el-button>
        <el-button type="danger">Danger</el-button>
      </div> -->
  
      <!-- 数据概览 -->
      <div class="overview">
        <el-row :gutter="20">
          <el-col :span="6">
            <el-card shadow="hover">
              <div slot="header">今日订单</div>
              <p class="overview-number">125</p>
            </el-card>
          </el-col>
          <el-col :span="6">
            <el-card shadow="hover">
              <div slot="header">本月收入</div>
              <p class="overview-number">￥18,560</p>
            </el-card>
          </el-col>
          <el-col :span="6">
            <el-card shadow="hover">
              <div slot="header">用户总数</div>
              <p class="overview-number">2450</p>
            </el-card>
          </el-col>
          <el-col :span="6">
            <el-card shadow="hover">
              <div slot="header">待处理工单</div>
              <p class="overview-number">18</p>
            </el-card>
          </el-col>
        </el-row>
      </div>
  
      <!-- 数据表格 -->
      <div class="data-table">
        <h2>最近订单</h2>
        <el-table :data="orders" style="width: 100%">
          <el-table-column prop="id" label="订单编号" width="150" />
          <el-table-column prop="customer" label="客户姓名" />
          <el-table-column prop="amount" label="订单金额" />
          <el-table-column prop="status" label="状态" />
          <el-table-column label="操作">
            <template #default="scope">
              <el-button size="mini" type="text" @click="handleView(scope.row)">
                查看
              </el-button>
              <el-button size="mini" type="text" @click="handleDelete(scope.row)">
                删除
              </el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>
  
      <!-- 简单表单 -->
      <div class="form-section">
        <h2>新增订单</h2>
        <el-form :model="form" label-width="100px" class="demo-form">
          <el-form-item label="客户姓名">
            <el-input v-model="form.customer" />
          </el-form-item>
          <el-form-item label="订单金额">
            <el-input v-model="form.amount" />
          </el-form-item>
          <el-form-item label="状态">
            <el-select v-model="form.status" placeholder="请选择状态">
              <el-option label="待处理" value="pending" />
              <el-option label="已完成" value="completed" />
            </el-select>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="handleSubmit">提交</el-button>
          </el-form-item>
        </el-form>
      </div>
    </div>
  </template>
  
  <script lang="ts" setup>
  import { ref } from "vue";
  
  // 数据概览
  const orders = ref([
    { id: "OD123", customer: "张三", amount: "￥200", status: "已完成" },
    { id: "OD124", customer: "李四", amount: "￥350", status: "待处理" },
    { id: "OD125", customer: "王五", amount: "￥500", status: "已完成" },
  ]);
  
  // 表单模型
  const form = ref({
    customer: "",
    amount: "",
    status: "",
  });
  
  // 操作事件
  const handleView = (row: any) => {
    console.log("查看订单:", row);
  };
  const handleDelete = (row: any) => {
    console.log("删除订单:", row);
  };
  const handleSubmit = () => {
    console.log("提交表单:", form.value);
  };
  </script>
  
  <style scoped>
  .home-page {
    padding: 20px;
  }
  
  .overview-number {
    font-size: 24px;
    font-weight: bold;
    color: #409eff;
    text-align: center;
  }
  
  .data-table {
    margin-top: 20px;
  }
  
  .form-section {
    margin-top: 20px;
  }
  
  .demo-form {
    max-width: 400px;
  }
  </style>
  