<script setup lang="ts">
import { ref } from 'vue';
import Cmp01Header from './Cmp01Header.vue';

const animalObj = ref({
  animalName: "小狗",
  animalPrice: 2000
});

const receiveData = (animalName: string, animalPrice: number) => {
  console.log(`Content.vue组件接收到子组件传递过来的数据：${animalName} ${animalPrice}`);
  animalObj.value.animalName = animalName;
  animalObj.value.animalPrice = animalPrice;
}
</script>

<template>
  <div class="mainContentDiv">
    <Cmp01Header stu-name="Jerry" :stu-age="88" @add="receiveData">~~~Content父组件指定的内容~~~</Cmp01Header>
    <h3>主体数据</h3>
    <h4>登鹳雀楼</h4>
    <p>白日依山尽，</p>
    <p>黄河入海流。</p>
    <p>欲穷千里目，</p>
    <p>更上一层楼。</p>
    <p>动物名称：{{ animalObj.animalName }} 动物价格：{{ animalObj.animalPrice }}</p>
  </div>
</template>

<style scoped>
.mainContentDiv {
  border: 1px solid #ccc;
  width: 80%;
  height: 500px;
}
</style>