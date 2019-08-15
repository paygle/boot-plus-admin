<template>
  <div class="yidao-container">
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item>当前路径</el-breadcrumb-item>
      <el-breadcrumb-item>YiDao</el-breadcrumb-item>
    </el-breadcrumb>
    <div class="func-area">
      <el-switch
        v-model="isAutoRefresh"
        active-text="自动刷新"
        inactive-text="不刷新">
      </el-switch>
      <span class="minite-box">
        <el-input-number size="mini" v-model="autoSeconds" :min="1" :max="10"></el-input-number>
        秒/次
      </span>
    </div>
    <el-progress :percentage="percentage" :color="customColors" :stroke-width="3"></el-progress>
    <el-table
      :data="taskData"
      style="width: 100%">
      <el-table-column type="expand">
        <template slot-scope="props">
          <el-form label-position="left" inline>
            <el-form-item label="ID">
              <span>{{ props.row.daoId }}</span>
            </el-form-item>
            <el-form-item label="账号">
              <span>{{ props.row.account }}</span>
            </el-form-item>
            <el-form-item label="密码">
              <span>{{ props.row.passwd }}</span>
            </el-form-item>
            <el-form-item label="区服">
              <span>{{ props.row.gameArea }}</span>
            </el-form-item>
            <el-form-item label="VIP">
              <span>{{ props.row.vipLevel }}</span>
            </el-form-item>
            <el-form-item label="元宝数量">
              <span>{{ props.row.ingotNum }}</span>
            </el-form-item>
            <el-form-item label="任务类型">
              <span>{{ props.row.taskType }}</span>
            </el-form-item>
            <el-form-item label="任务阶段">
              <span>{{ props.row.taskPhase }}</span>
            </el-form-item>
            <el-form-item label="账号状态">
              <span>{{ props.row.accountStatus }}</span>
            </el-form-item>
            <el-form-item label="登录次数">
              <span>{{ props.row.loginTimesDay }}</span>
            </el-form-item>
            <el-form-item label="封禁状态">
              <span>{{ props.row.accountBlocked }}</span>
            </el-form-item>
            <el-form-item label="登录时间">
              <span>{{ props.row.loginTime }}</span>
            </el-form-item>
            <el-form-item label="最近退出时间">
              <span>{{ props.row.logoutTime }}</span>
            </el-form-item>
            <el-form-item label="创建时间">
              <span>{{ props.row.createTime }}</span>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>
      <el-table-column label="ID" prop="daoId"></el-table-column>
      <el-table-column label="账号" prop="account"> </el-table-column>
      <el-table-column label="区服" prop="gameArea"> </el-table-column>
      <el-table-column label="VIP" prop="vipLevel"></el-table-column>
      <el-table-column label="元宝" prop="ingotNum"> </el-table-column>
      <el-table-column label="任务类型" prop="taskType"></el-table-column>
      <el-table-column label="任务阶段" prop="taskPhase"> </el-table-column>
      <el-table-column label="账号状态" prop="accountStatus"></el-table-column>
      <el-table-column label="登录次数" prop="loginTimesDay"></el-table-column>
      <el-table-column label="封禁状态" prop="accountBlocked"></el-table-column>
      <el-table-column label="登录时间" prop="loginTime">
        <template slot-scope="prop">{{prop.row.loginTime | dateLessYear}}</template>
      </el-table-column>
      <el-table-column label="登出时间" prop="logoutTime">
        <template slot-scope="prop">{{prop.row.logoutTime | dateLessYear}}</template>
      </el-table-column>
      <el-table-column label="操作" class-name="tb-col-operation">
        <template slot-scope="prop">
          <el-button type="text" @click="deviceOperation(prop.row)" icon="el-icon-delete"></el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="currentPage"
      :page-sizes="[10, 20, 50]"
      :page-size="10"
      layout="total, sizes, prev, pager, next, jumper"
      :total="total">
    </el-pagination>
  </div>
</template>

<script>
import { mapState } from 'vuex'

export default {
  name: 'YiDao',
  data() {
    return {
      autoSeconds: 5,
      currentTimeout: 0,
      isAutoRefresh: true,
      percentage: 0,
      customColors: [
        {color: '#f56c6c', percentage: 20},
        {color: '#e6a23c', percentage: 40},
        {color: '#5cb87a', percentage: 60},
        {color: '#1989fa', percentage: 80},
        {color: '#6f7ad3', percentage: 100}
      ],
      pageSize: 10,
      currentPage: 1,
      total: 0,
      taskData: [],
      updateRefHandler: null
    }
  },
  watch: {
    isAutoRefresh: {
      immediate: true,
      handler() {
        this.autoUpdateInfo()
      }
    }
  },
  computed: {
    ...mapState(['baseReqUrl'])
  },
  methods: {
    deviceOperation(row) {
      console.log("Operation: ", row)
    },
    autoUpdateInfo() {
      const _this = this;
      let start, oldsteptime

      function step(timestamp) {
        const mountSec = _this.autoSeconds * 1000
        const perOne = mountSec / 1000
        if (!start) start = timestamp;
        let steptime, percentage, progress = timestamp - start;

        if (progress <= mountSec && _this.isAutoRefresh) {
          percentage = Math.floor(progress / mountSec * 100) 
          steptime =  Math.floor(progress / 1000)
          if ((_this.percentage !== percentage || _this.percentage === 0) && steptime !== oldsteptime) {
            oldsteptime = steptime
            _this.percentage = percentage
          }
          _this.updateRefHandler = requestAnimationFrame(step);
        } else if (mountSec >= 1000 && _this.isAutoRefresh) {
          _this.percentage = 100
          setTimeout(() => {
            start = 0
            _this.percentage = 0
            _this.updateTable(() => { _this.updateRefHandler = requestAnimationFrame(step); })
          }, 1000)
        }
      }

      if (this.isAutoRefresh) {
        cancelAnimationFrame(this.updateRefHandler )
        this.updateRefHandler = requestAnimationFrame(step)
      } else {
        cancelAnimationFrame(this.updateRefHandler )
      }
    },
    updateTable(callback) {
      this.$POST(`${this.baseReqUrl}/yidao/getPageList`, 
        {current: this.currentPage, keyword: "", size: this.pageSize}
      ).then((data) => {
        if (data.records) {
          console.log('Yidao request data ', data)
          this.taskData = data.records
          this.total = Number(data.total)
        }
        if (typeof callback === 'function') callback();
      }).catch((e) => {
        console.log('request data error', e)
      })
    },
    handleSizeChange(val) {
      this.pageSize = val
      this.updateTable()
    },
    handleCurrentChange(val) {
      this.currentPage = val
      this.updateTable()
    }
  },
  beforeDestroy() {
    this.isAutoRefresh = false
  },
  mounted() {
    console.log('init task')
    this.updateTable()
  }
}
</script>
