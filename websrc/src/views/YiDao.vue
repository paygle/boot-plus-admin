<template>
  <div class="yidao-container">
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item>当前路径</el-breadcrumb-item>
      <el-breadcrumb-item>YiDao</el-breadcrumb-item>
    </el-breadcrumb>
    <img alt="Vue logo" src="../assets/logo.png">
    <HelloWorld msg="Welcome to Your Yidao"/>
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'YiDao',
  components: {
    HelloWorld
  }
}
</script>
