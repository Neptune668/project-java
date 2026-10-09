<script setup lang="ts">
import { reactive, ref } from 'vue'
import { ElMessage } from 'element-plus'
import type { FormInstance, FormRules } from 'element-plus'

// reactive：像 ref 但适合整个对象，访问不用 .value
const form = reactive({ username: '', email: '' })

// 校验规则：每个字段的检查项
const rules: FormRules = {
  username: [{ required: true, message: '请输入用户名', trigger: 'blur' }],
  email: [
    { required: true, message: '请输入邮箱', trigger: 'blur' },
    { type: 'email', message: '邮箱格式不对', trigger: 'blur' },
  ],
}
const formRef = ref<FormInstance>()

function onSubmit() {
  // validate()：触发校验。通过才继续，不过会自动提示
  formRef.value?.validate().then(() => {
    console.log('提交的数据：', form)   // 第 35 节这里会换成调后端接口
    ElMessage.success('校验通过，准备提交！')
  })
}
</script>

<template>
  <el-form ref="formRef" :model="form" :rules="rules" label-width="80px" style="width: 500px">
    <el-form-item label="用户名" prop="username">
      <el-input v-model="form.username" />
    </el-form-item>
    <el-form-item label="邮箱" prop="email">
      <el-input v-model="form.email" />
    </el-form-item>
    <el-button type="primary" @click="onSubmit">登录</el-button>
  </el-form>
</template>