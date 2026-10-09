<script setup lang="ts">
// import LayoutDemo from './components/LayoutDemo.vue'
// import A_table from "./components/a_table.vue";
// import B_life from "./components/b_life.vue";
import Cmp01Header from './components/Cmp01Header.vue';
// import Cmp02Menu from './components/Cmp02Menu.vue';
import Cmp03Content from './components/Cmp03Content.vue';
import Parent from './components/parent.vue';
import Child from './components/child.vue';
const stuName = "Tom";

const receiveData = (animalName: string, animalPrice: number) => {
  console.log(`父组件接收到子组件传递过来的数据：${animalName} ${animalPrice}`);
}
</script>

<!--<template>-->
<!--  <LayoutDemo />-->
<!--  <a_table/>-->
<!--  <p>指定内容</p>-->
<!--  <b_life>-->
<!--    <p>子类</p>-->
<!--  </b_life>-->

<!--</template>-->
<template>
  <div>
    <div class="rowContainer">
      <!-- -----------------父组件给 Props 属性传值----------------- -->
      <!-- 编译阶段的报错信息： -->
      <!-- Type 'string' is not assignable to type 'number'. -->
      <!-- "20" 字面量是字符串类型的，而 stuAge 是 number 类型，无法直接赋值 -->
      <!-- 虽然 JavaScript 运行的时候支持自动的类型转换，但是 TypeScript 在编译阶段认为类型不匹配 -->
      <!-- 解决办法：给 stu-age 属性前面加上引号，表示对属性值进行解析，解析之后字符串变成数值类型就可以赋值了 -->
      <!-- 那这么来看，前面 stu-name 是不是也可以加引号？ -->
      <!-- 加上之后，语法含义一样，也是表示当前属性需要解析 -->
      <!-- 如果此时指定一个字符串字面量，没有对应的同名变量（或常量），那么就会导致解析失败 -->
      <!-- -----------------父组件接收子组件传递上来的值----------------- -->
      <!-- @add 表示对子组件定义事件的监听，父组件需要声明一个对应的函数来接收数据 -->
      <Cmp01Header :stu-name="stuName" :stu-age="20" @add="receiveData">~~~App.vue父组件指定的内容~~~</Cmp01Header>
    </div>
    <div class="rowContainer">
      <Cmp02Menu/>
      <Cmp03Content/>
      <parent/>
      <child/>
    </div>
  </div>
</template>

<style scoped>
.rowContainer {
  display: flex;
  justify-content: center;
}
</style>