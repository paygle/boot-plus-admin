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
        每
        <el-input-number size="mini" v-model="autoMinute" :min="1" :max="10" label="描述文字"></el-input-number>
        秒/次
      </span>
    </div>
    <el-progress :percentage="percentage" :color="customColors" :stroke-width="3"></el-progress>
    <el-table
      :data="tableData"
      style="width: 100%">
      <el-table-column type="expand">
        <template slot-scope="props">
          <el-form label-position="left" inline class="demo-table-expand">
            <el-form-item label="商品名称">
              <span>{{ props.row.name }}</span>
            </el-form-item>
            <el-form-item label="所属店铺">
              <span>{{ props.row.shop }}</span>
            </el-form-item>
            <el-form-item label="商品 ID">
              <span>{{ props.row.id }}</span>
            </el-form-item>
            <el-form-item label="店铺 ID">
              <span>{{ props.row.shopId }}</span>
            </el-form-item>
            <el-form-item label="商品分类">
              <span>{{ props.row.category }}</span>
            </el-form-item>
            <el-form-item label="店铺地址">
              <span>{{ props.row.address }}</span>
            </el-form-item>
            <el-form-item label="商品描述">
              <span>{{ props.row.desc }}</span>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>
      <el-table-column
        label="商品 ID"
        prop="id">
      </el-table-column>
      <el-table-column
        label="商品名称"
        prop="name">
      </el-table-column>
      <el-table-column
        label="描述"
        prop="desc">
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
  name: 'Task',
  data() {
    return {
      autoMinute: 1,
      isAutoRefresh: true,
      percentage: 20,
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
      tableData: [{
        id: '12987122',
        name: '好滋好味鸡蛋仔',
        category: '江浙小吃、小吃零食',
        desc: '荷兰优质淡奶，奶香浓而不腻',
        address: '上海市普陀区真北路',
        shop: '王小虎夫妻店',
        shopId: '10333'
      }, {
        id: '12987126',
        name: '好滋好味鸡蛋仔',
        category: '江浙小吃、小吃零食',
        desc: '荷兰优质淡奶，奶香浓而不腻',
        address: '上海市普陀区真北路',
        shop: '王小虎夫妻店',
        shopId: '10333'
      }]
    }
  },
  computed: {
    ...mapState(['baseReqUrl'])
  },
  methods: {
    updateTable() {
      this.$POST(`${this.baseReqUrl}/taskManagement/getPageList`, 
        {current: this.currentPage, keyword: "", size: this.pageSize}
      ).then((data) => {
        if (data.records) {
          console.log('request data ', data)
          this.taskData = data.records
          this.total = Number(data.total)
        }
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
