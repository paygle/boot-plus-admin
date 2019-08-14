<template>
  <div class="login-container">
    <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="login-ruleForm">
      <el-form-item label="账户" prop="account">
        <el-input v-model="ruleForm.pass"></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="pass">
        <el-input type="password" v-model="ruleForm.pass"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">登录</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>

export default {
  name: 'Login',
  data() {

    var validateAccount = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入账户'));
      } else {
        if (this.ruleForm.checkPass !== '') {
          this.$refs.ruleForm.validateField('checkAcount');
        }
        callback();
      }
    };

    var validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入密码'));
      } else {
        if (this.ruleForm.checkPass !== '') {
          this.$refs.ruleForm.validateField('checkPass');
        }
        callback();
      }
    };

    return {
      ruleForm: {
        account: '',
        pass: ''
      },
      rules: {
        checkAcount: [
          { validator: validateAccount, trigger: 'blur' }
        ],
        checkPass: [
          { validator: validatePass, trigger: 'blur' }
        ]
      }
    };
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          alert('submit!');
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    }
  }
}
</script>
