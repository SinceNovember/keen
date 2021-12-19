<template>
  <div class="add-container">
    <div class="dialog-title">添加菜单</div>
    <div class="info-container">
      <el-menu
        :default-active="activeIndex"
        class="el-menu-demo"
        mode="horizontal"
        @select="handleSelect"
      >
        <el-menu-item index="DIRECTORY">目录</el-menu-item>
        <el-menu-item index="MENU">菜单</el-menu-item>
        <el-menu-item index="BUTTON">按钮</el-menu-item>
      </el-menu>
      <el-form
        :model="menuInfo"
        label-position="right"
        label-width="90px"
        :rules="rules"
        ref="menuInfo"
      >
        <div class="menu-content">
          <!-- <div class="menu-content" v-if="activeIndex == 2"> -->
          <el-form-item v-if="activeIndex != 'DIRECTORY'" label="上级菜单" prop="parentId">
            <tree-select
              v-model="menuInfo.parentId"
              :width="340"
              :data="menuTreeModel"
              nodeKey="value"
              :checkedKeys="defaultCheckedKeys"
              @popoverHide="popoverHide"
            ></tree-select>
          </el-form-item>
          <el-form-item :label="activeIndex != 'BUTTON' ? '菜单名称' : '按钮名称'" prop="meta.title">
            <el-input v-model="menuInfo.meta.title"></el-input>
          </el-form-item>
          <!-- <el-form-item label="菜单标志" prop="menuName">
                <el-input v-model="menuInfo.menuName" class="inline-input"></el-input>
          </el-form-item>-->
          <el-form-item :label="activeIndex != 'BUTTON' ?'路由地址' :'Api地址'" prop="path">
            <el-input v-model="menuInfo.path"></el-input>
          </el-form-item>
          <el-form-item v-if="activeIndex == 'MENU'" label="组件地址" prop="component">
            <el-input v-model="menuInfo.component"></el-input>
          </el-form-item>
          <el-form-item label="重定向" v-if="activeIndex != 'BUTTON'">
            <el-col :span="10">
              <el-input v-model="menuInfo.redirect"></el-input>
            </el-col>
            <el-col class="line" :span="3">标志</el-col>
            <el-col :span="11">
              <el-input v-model="menuInfo.name"></el-input>
            </el-col>
          </el-form-item>
          <el-form-item label="Api类型" v-if="activeIndex == 'BUTTON'">
            <el-radio-group v-model="menuInfo.requestMethod">
              <el-radio label="GET">GET</el-radio>
              <el-radio label="POST">POST</el-radio>
              <el-radio label="PUT">PUT</el-radio>
              <el-radio label="DELETE">DELETE</el-radio>
            </el-radio-group>
          </el-form-item>

          <el-form-item :label="activeIndex != 'BUTTON' ? '菜单图标' : '排序'">
            <el-col :span="10" v-if="activeIndex != 'BUTTON'">
              <el-input v-model="menuInfo.meta.icon"></el-input>
            </el-col>
            <el-col class="line" :span="3" v-if="activeIndex != 'BUTTON'">排序</el-col>
            <el-col :span="11">
              <el-input-number v-model="menuInfo.orderNum" class="full-width"></el-input-number>
            </el-col>
            <!-- <el-input v-model="menuInfo.meta.icon" class="small-inline-input"></el-input>
            <span class="label">排序</span> <el-input-number v-model="menuInfo.description" class="small-inline-input" ></el-input-number>-->
          </el-form-item>
          <!-- <el-form-item label="菜单排序">
                <el-input-number v-model="menuInfo.description" class="small-inline-input" ></el-input-number>
          </el-form-item>-->
          <el-form-item label="隐藏" v-if="activeIndex != 'BUTTON'">
            <el-checkbox v-model="menuInfo.hidden"></el-checkbox>
            <span>展开</span>
            <el-checkbox v-model="menuInfo.isExpand"></el-checkbox>
            <span>固定导航栏</span>
            <el-checkbox v-model="menuInfo.meta.affix"></el-checkbox>
            <span>公开</span>
            <el-checkbox v-model="menuInfo.alwaysShow"></el-checkbox>
          </el-form-item>

          <el-form-item>
            <el-button type="primary" @click="addMenu('menuInfo')">确认</el-button>
            <el-button @click="closeDialog">取消</el-button>
          </el-form-item>
        </div>
      </el-form>
    </div>
  </div>
</template>

<script>
import { saveMenu, updateMenu, fetchMenuTreeModel } from "@/api/menu";
import TreeSelect from "@/components/TreeSelect.vue";

export default {
  props: {
    menuInfo: Object,
    activeIndex: String,
    defaultCheckedKeys: Array
  },
  components: {
    TreeSelect
  },
  data() {
    return {
      menuTreeModel: [],
      rules: {
        parentId: [
          { required: true, message: "上级菜单不能为空", trigger: "blur" }
        ],
        "meta.title": [
          { required: true, message: "菜单名称不能为空", trigger: "blur" }
        ],
        path: [
          { required: true, message: "路由地址不能为空", trigger: "blur" }
        ],
        component: [
          { required: true, message: "组件地址不能为空", trigger: "blur" }
        ]
      }
    };
  },
  mounted() {
    this.loadMenuTreeModel();
  },
  methods: {
    handleSelect(key, keyPath) {
      this.activeIndex = key;
    },
    popoverHide(key, value) {
      this.menuInfo.parentId = key;
    },
    addMenu(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          this.menuInfo.menuType = this.activeIndex;
          if (this.menuInfo.menuType === "DIRECTORY") {
            this.menuInfo.parentId = "";
          }
          if (this.menuInfo.id) {
            updateMenu(this.menuInfo).then(res => {
              this.$emit("closeDialog", 1);
              this.$message({
                message: "修改成功",
                type: "success"
              });
            });
          } else {
            saveMenu(this.menuInfo).then(res => {
              this.$emit("closeDialog", 1);
              this.$message({
                message: "添加成功",
                type: "success"
              });
            });
          }
        }
      });
    },
    closeDialog() {
      this.$emit("closeDialog");
    },
    loadMenuTreeModel() {
      fetchMenuTreeModel().then(res => {
        this.menuTreeModel = res.data;
      });
    },
    getDefaultTree(arr) {
      fetchMenuTreeModel().then(res => {
        arr = res.data;
      });
    }
  }
};
</script>

<style lang="scss" scoped>
.info-container {
  padding-top: 0px;
}
.menu-content {
  margin-top: 30px;
}
</style>