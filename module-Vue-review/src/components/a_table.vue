<script setup lang="ts">
import {ref} from 'vue'

// const stuList = ref([
//   { stuId: 1, stuName: '张三', stuAge: 20, stuSubject: '计算机' },
// ])
const title = ref('Hello World')
const html = ref('<h1>Hello World</h1>')
const info = ref("HELLO WORLD")
const count = ref(0)
const user = ref({name: "张三", age: 17})
const agree = ref(false)
const city = ref("sz")
function doClick() {
  user.value.age++
}

</script>

<template>
  <!--  <h1 v-text="title">{{ title }}</h1>-->
  <h1>{{ title }}</h1>
  <h2 v-html="html"></h2>
  <h2>{{ info }} {{ count }}</h2>
  <input :value="info">
  <button @click="doClick">修改</button>
  <p>{{ user.age }}</p>
  <p v-if="user.age < 18">玩</p>
  <p v-else>成年可以上班</p>

  <!--  <table>-->
  <!--    <tr><th>id</th><th>姓名</th><th>年龄</th><th>专业</th></tr>-->
  <!--    <tr v-for="stu in stuList" :key="stu.stuId">-->
  <!--      <td>{{ stu.stuId }}</td>-->
  <!--      <td>{{ stu.stuName }}</td>-->
  <!--      <td>{{ stu.stuAge }}</td>-->
  <!--      <td>{{ stu.stuSubject }}</td>-->
  <!--    </tr>-->
  <!--  </table>-->
  <input v-model="user.name">
  <p>你输入的是：{{user.name}}</p>

  <input type="checkbox" v-model="agree" />   <!-- 勾选 → 布尔 -->
  <select v-model="city">                       <!-- 下拉 → 选中值 -->
    <option value="sz">深圳</option>
    <option value="gz">广州</option>
  </select>

</template>


<style scoped>

</style>