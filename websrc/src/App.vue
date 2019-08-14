<template>
<el-container id="app">
  <el-header>cloud plantform</el-header>
  <el-container>
    <el-aside width="200px">
       <el-menu
        default-active="/"
        class="el-menu-vertical-demo"
        @open="handleOpen"
        @close="handleClose" router>
        <el-menu-item index="/">
          <i class="el-icon-s-home"></i>
          <span slot="title">Home</span>
        </el-menu-item>
        <el-menu-item index="/task">
          <i class="el-icon-mobile-phone"></i>
          <span slot="title">Task</span>
        </el-menu-item>
        <el-menu-item index="/yidao">
          <i class="el-icon-thumb"></i>
          <span slot="title">YiDao</span>
        </el-menu-item>
        <el-menu-item index="/about">
          <i class="el-icon-s-promotion"></i>
          <span slot="title">About</span>
        </el-menu-item>
      </el-menu>
    </el-aside>
    <el-main>
      <router-view/>
    </el-main>
  </el-container>
</el-container>
</template>
<script>
export default {
  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    }
  }
}
</script>
<style lang="less">
@import './less/index.less';
</style>
