<script setup lang="ts">
import { ref, onMounted, onUpdated, onUnmounted } from 'vue'
const count = ref(2)
onMounted(() => {
  console.log('mounted')
})
onUpdated(() => {
  console.log('updated')
})
onUnmounted(() => {
  console.log('unmounted')
})
</script>

<template>
  <p>{{count}}</p>
  <button @click="count++">+1</button>
  <slot />
</template>

<style scoped>

</style>