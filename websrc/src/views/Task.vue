<template>
  <div class="task-container">
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item>当前路径</el-breadcrumb-item>
      <el-breadcrumb-item>Task</el-breadcrumb-item>
    </el-breadcrumb>
    <div class="func-area">
      <el-switch
        v-model="isAutoRefresh"
        active-text="自动刷新"
        inactive-text="不刷新">
      </el-switch>
      <span class="minite-box">
        <el-input-number size="mini" v-model="autoSeconds" :min="1" :max="10" label="描述文字"></el-input-number>
        秒/次
      </span>
    </div>
    <el-progress :percentage="percentage" :color="customColors" :stroke-width="3"></el-progress>
    <el-table
      :data="taskData"
      style="width: 100%">
      <el-table-column type="expand">
        <template slot-scope="props">
          <el-form label-position="left" inline class="demo-table-expand">
            <el-form-item label="任务号">
              <span>{{ props.row.taskId }}</span>
            </el-form-item>
            <el-form-item label="IMEI">
              <span>{{ props.row.mobileImei }}</span>
            </el-form-item>
            <el-form-item label="别名">
              <span>{{ props.row.alias }}</span>
            </el-form-item>
            <el-form-item label="机器码">
              <span>{{ props.row.machineCode }}</span>
            </el-form-item>
            <el-form-item label="IP">
              <span>{{ props.row.ipAddress }}</span>
            </el-form-item>
            <el-form-item label="设备状态">
              <span>{{ props.row.deviceState }}</span>
            </el-form-item>
            <el-form-item label="注册码">
              <span>{{ props.row.regCode }}</span>
            </el-form-item>
            <el-form-item label="到期时间">
              <span>{{ props.row.expireDate }}</span>
            </el-form-item>
            <el-form-item label="创建时间">
              <span>{{ props.row.createTime }}</span>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>
      <el-table-column label="任务号" prop="taskId"></el-table-column>
      <el-table-column label="IMEI" prop="mobileImei"> </el-table-column>
      <el-table-column label="别名" prop="alias"> </el-table-column>
      <el-table-column label="机器码" prop="machineCode"></el-table-column>
      <el-table-column label="IP" prop="ipAddress"> </el-table-column>
      <el-table-column label="设备状态" prop="deviceState"></el-table-column>
      <el-table-column label="注册码" prop="regCode"> </el-table-column>
      <el-table-column label="到期时间" prop="expireDate"></el-table-column>
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
import { clearInterval, setTimeout } from 'timers';

export default {
  name: 'Task',
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
      this.$POST(`${this.baseReqUrl}/taskManagement/getPageList`, 
        {current: this.currentPage, keyword: "", size: this.pageSize}
      ).then((data) => {
        if (data.records) {
          console.log('request data ', data)
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
  mounted() {
    console.log('init task')
    this.updateTable()
  }
}
</script>
