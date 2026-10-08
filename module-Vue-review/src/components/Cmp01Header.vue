<template>
  <!-- template 中建议有且只有一个根标签 -->
  <div>
    <h3>Banner</h3>
    <p>[子组件中的固定内容]<slot/>[子组件中的固定内容]</p>
    <p>学生姓名：{{ studentProps.stuName }} 学生年龄：{{ studentProps.stuAge }}</p>
    <button @click="passValueToParent">点击这里让子组件给父组件传值</button>
  </div>
</template>

<script setup lang="ts">
interface Student {
  stuName: string;
  stuAge: number;
}

// 为了可以接收父组件传递过来的数据，定义 props 对象
const studentProps = defineProps<Student>();

// 为了让子组件可以给父组件传值，定义一个 emit 对象
const emit = defineEmits<{add: [animalName: string, animalPrice: number]}>();

const passValueToParent = () => {
  // 调用 emit 对象的方法给父组件传递数据
  // 前面定义的 emit 对象本质上是一个函数
  // emit() 函数参数一：事件名称，就是在 defineEmits 泛型中定义的那个
  // emit() 函数后续的可变参数：就是要传递给父组件的数据，数据类型就是在 defineEmits 泛型中定义的那个
  emit('add', '小猫', 1000);
}
</script>

<style scoped>
div {
  border: 1px solid #ccc;
  width: 100%;
  height: 200px;
}
</style>