<script setup lang="ts">
  import {userStore} from "../store/count.ts";
  const countStore = userStore();
  console.log(countStore.count);
</script>

<template>

</template>

<style scoped>

</style>