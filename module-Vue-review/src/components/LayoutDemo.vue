<script setup lang="ts">
// 用 Element Plus 的 24 栅格系统演示 el-row / el-col 的自由组合：
// - el-row：一行（容器），可用 :gutter 控制列间距
// - el-col：行内的一列，:span 表示它占 24 份中的几份
//   只要同一行内所有 span 之和 <= 24，就能任意组合布局
</script>

<template>
  <div class="layout-demo">
    <h2>el-row + el-col(span) 栅格布局</h2>
    <p class="tip">
      每一行总共 <b>24</b> 份，<code>span</code> 就是这一列占的份数，同一行内 span 之和 ≤ 24 即可自由组合。
    </p>

    <!-- 1. 等分两列 -->
    <h3>1. 等分两列：span = 12 + 12</h3>
    <el-row>
      <el-col :span="12"><div class="grid-box">span=12</div></el-col>
      <el-col :span="12"><div class="grid-box alt">span=12</div></el-col>
    </el-row>

    <!-- 2. 三等分 -->
    <h3>2. 三等分：span = 8 + 8 + 8</h3>
    <el-row>
      <el-col :span="8"><div class="grid-box">span=8</div></el-col>
      <el-col :span="8"><div class="grid-box alt">span=8</div></el-col>
      <el-col :span="8"><div class="grid-box">span=8</div></el-col>
    </el-row>

    <!-- 3. 按比例 2:1 -->
    <h3>3. 按比例 2:1：span = 16 + 8</h3>
    <el-row>
      <el-col :span="16"><div class="grid-box">span=16</div></el-col>
      <el-col :span="8"><div class="grid-box alt">span=8</div></el-col>
    </el-row>

    <!-- 4. 经典后台布局 -->
    <h3>4. 经典后台布局：侧边栏 6 + 内容区 18</h3>
    <el-row>
      <el-col :span="6"><div class="grid-box sidebar">侧边栏 span=6</div></el-col>
      <el-col :span="18"><div class="grid-box content">内容区 span=18</div></el-col>
    </el-row>

    <!-- 5. gutter 控制列间距 -->
    <h3>5. 用 :gutter 控制列与列之间的间距</h3>
    <el-row :gutter="20">
      <el-col :span="8"><div class="grid-box">span=8</div></el-col>
      <el-col :span="8"><div class="grid-box alt">span=8</div></el-col>
      <el-col :span="8"><div class="grid-box">span=8</div></el-col>
    </el-row>

    <!-- 6. offset 让列向右偏移 -->
    <h3>6. 用 :offset 让列向右偏移</h3>
    <el-row>
      <el-col :span="8"><div class="grid-box">span=8</div></el-col>
      <el-col :span="8" :offset="8"><div class="grid-box alt">span=8 offset=8</div></el-col>
    </el-row>
  </div>
</template>

<style scoped>
.layout-demo {
  padding: 24px;
  text-align: left;
}

.tip {
  color: #909399;
  margin-bottom: 16px;
}

h3 {
  margin: 20px 0 8px;
  font-size: 15px;
  font-weight: 600;
}

.grid-box {
  background: #409eff;
  color: #fff;
  text-align: center;
  padding: 16px 0;
  border-radius: 4px;
  font-size: 13px;
}

.grid-box.alt {
  background: #67c23a;
}

.grid-box.sidebar {
  background: #e6a23c;
}

.grid-box.content {
  background: #909399;
}
</style>
