<script setup lang="ts">
import {ref, computed} from 'vue'
import {ElMessage} from 'element-plus'

interface Todo {
  id: number;
  title: string;
  done: boolean
}

const todos = ref<Todo[]>([
  {id: 1, title: '学习 Vue', done: false},
  {id: 2, title: '学习 TS', done: true},
])

const input = ref('')
const undoneCount = computed(() => todos.value.filter(t => !t.done).length)

function add() {
  if (!input.value.trim()) {
    ElMessage.warning('先输入内容')
    return
  }
  todos.value.push({id: Date.now(), title: input.value, done: false})
  input.value = ''
}

function remove(id: number) {
  todos.value = todos.value.filter(t => t.id !== id)
}
</script>

<template>
  <el-row :gutter="16">
    <el-col :span="24">
      <h2>待办事项</h2>
    </el-col>

    <!-- ② 输入区：el-col 内用 flex 把输入框和按钮排成一行 -->
    <el-col :span="24">
      <div class="add-bar">
        <el-input v-model="input" placeholder="输入待办，回车添加" @keyup.enter="add"/>
        <el-button type="primary" @click="add">添加</el-button>
      </div>
    </el-col>

    <!-- ③ 状态 + 列表区 -->
    <el-col :span="24">
      <p>还剩 {{ undoneCount }} 项未完成</p>
      <ul>
        <li v-for="t in todos" :key="t.id" class="todo-item">
          <input type="checkbox" v-model="t.done"/>
          <span :style="{ textDecoration: t.done ? 'line-through' : 'none' }" class="title">{{ t.title }}</span>
          <el-button size="small" type="danger" @click="remove(t.id)">删除</el-button>
        </li>
      </ul>
    </el-col>
  </el-row>
</template>
<style scoped>
/* ② 输入区：flex 排一行，输入框撑满、按钮固定右侧（flex: 1 见第 21 节） */
.add-bar {
  display: flex;
  gap: 8px;
}

.add-bar .el-input {
  flex: 1;
}

/* ③ 每条待办：flex 排一行，勾选框 + 文字 + 删除按钮 */
.todo-item {
  display: flex;
  align-items: center;
  gap: 8px;
}

.todo-item .title {
  flex: 1;
}
</style>