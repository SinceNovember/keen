<template>
  <div class="login-container">
    <div class="left-nav">
      <div class="left-nav-container">
        <div class="left-nav-header">
          <i class="bx bxl-slack bx-spin bx-rotate-180"></i>
          <span>Admintory</span>
        </div>
        <div class="left-nav-main">
          <div class="login-wrap">
            <div class="login-header">
              <h3>Sign Up to your account</h3>
            </div>
            <div class="login-input-content">
              <el-form ref="loginForm" :model="loginForm" :rules="loginRules">
                <div class="login-input">
                  <el-form-item prop="username">
                    <el-input v-model="loginForm.username" class="inline-input" placeholder="请输入账号"></el-input>
                    <i class="bx bxs-user"></i>
                  </el-form-item>
                </div>
                <div class="login-input">
                  <el-form-item prop="password">
                    <el-input
                      v-model="loginForm.password"
                      class="inline-input"
                      placeholder="请输入密码"
                      show-password
                    ></el-input>
                    <i class="bx bx-key bx-rotate-90"></i>
                  </el-form-item>
                </div>
              </el-form>
            </div>

            <div class="login-tab-content">
              <el-checkbox v-model="checked">Remember</el-checkbox>
              <el-button type="primary" class="login-btn" @click="handleLogin">Sign in</el-button>
              <div class="register">
                <span>
                  Don't have an account?
                  <a href="#">Sign up</a>
                </span>
              </div>
            </div>
          </div>
        </div>
        <div class="left-nav-bottom">
          <span class="tab">Login With</span>
          <div class="other">
            <span class="link">facebook</span>
            <span class="link">twitter</span>
            <span class="link">google</span>
          </div>
        </div>
      </div>
    </div>
    <div class="right-nav">
      <div class="right-nav-header">
        <div class="right-header-content">
          <i class="bx bx-menu"></i>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { getFirstMenuPermission } from "@/api/menu";

export default {
  data() {
    return {
      redirect: undefined,
      loginForm: {
        username: "",
        password: ""
      },
      loginRules: {
        username: [
          { required: true, trigger: "blur", message: "账号不能为空" }
        ],
        password: [{ required: true, trigger: "blur", message: "密码不能为空" }]
      }
    };
  },
  watch: {
    $route: {
      handler: function(route) {
        const query = route.query;
        if (query) {
          this.redirect = query.redirect;
          this.otherQuery = this.getOtherQuery(query);
        }
      },
      immediate: true
    }
  },
  methods: {
    handleLogin() {
      this.$refs.loginForm.validate(valid => {
        if (valid) {
          this.$store.dispatch("user/login", this.loginForm).then(() => {
            getFirstMenuPermission().then(res => {
              this.redirect = res.data.path;
              this.$router.push({
                path: this.redirect || "/",
                query: this.otherQuery
              });
            });
          });
        } else {
          return false;
        }
      });
    },
    getOtherQuery(query) {
      return Object.keys(query).reduce((acc, cur) => {
        if (cur !== "redirect") {
          acc[cur] = query[cur];
        }
        return acc;
      }, {});
    }
  }
};
</script>

<style lang="scss" scoped>
.login-container {
  height: 100vh;
  width: 100%;

  .left-nav {
    width: 37%;
    height: 100%;
    float: left;
    color: #a5a3a3;
    font-size: 16px;

    .left-nav-container {
      margin: 10px;
      height: 100%;

      .left-nav-header {
        display: flex;
        align-items: center;
        justify-content: center;
        height: 20%;
        font-size: 32px;
        color: #909de2;

        span {
          margin-left: 5px;
        }
      }

      .left-nav-main {
        height: 60%;
        display: flex;
        align-items: flex-start;
        justify-content: center;

        .login-wrap {
          width: 60%;
          margin-top: 10%;

          .login-header {
            margin-bottom: 30px;
            font-weight: 500;
          }

          .login-input-content {
            .login-input {
              position: relative;
              margin-bottom: 40px;

              .inline-input {
                height: 50px;
              }

              i {
                position: absolute;
                left: 10px;
                top: 15px;
                font-size: 20px;
              }
            }
          }

          .login-tab-content {
            display: flex;
            flex-direction: column;
            align-items: flex-start;
            justify-content: flex-start;

            .left-tab {
              .tab {
                margin-left: 10px;
              }
            }

            .login-btn {
              background-color: #3c57c9;
              border-color: #3c57c9;
              width: 100%;
              height: 50px;
              margin: 15px 0px;
            }

            .register {
              width: 100%;
              text-align: center;
            }
          }
        }
      }
      .left-nav-bottom {
        height: 20%;
        display: flex;
        justify-content: space-around;
        align-items: center;

        .other {
          .link {
            color: #2d4fdb;
            margin-left: 10px;
            cursor: pointer;
          }
        }
      }
    }
  }
  .right-nav {
    width: 63%;
    height: 100%;
    float: left;
    background: url("https://img.yanlutong.com/uploadimg/image/20210128/20210128103434_41233.jpg")
      no-repeat;
    background-size: cover;

    .right-nav-header {
      margin: 20px;
      height: 30px;
      font-size: 30px;
      color: #f7f0f0;

      .right-header-content {
        float: right;
      }
    }
  }
}
</style>