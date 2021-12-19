<template>
  <div class="tree-list-container">
    <div class="tree-list-content">
      <div class="tree-list-left">
        <div class="tree-list-title">
          <span class="title">{{treeTitle}}</span>
        </div>
        <div class="tree-list-body" :style="bodyStyle">
          <el-input placeholder="输入关键字进行过滤" v-model="filterText"></el-input>

          <div class="tree-content" :style="contentStyle">
            <el-tree
              class="filter-tree"
              icon-class="el-icon-arrow-right"
              :check-strictly="checkStrictly"
              show-checkbox
              :node-key="nodeKey"
              :data="deptTree"
              :filter-node-method="filterNode"
              :default-checked-keys="selectedKeyList"
              @check="fnClickNode"
              ref="tree"
            ></el-tree>
          </div>
        </div>
      </div>
      <div class="tree-list-right">
        <div class="tree-list-title">
          <span class="title">
            已选择记录
            <span v-if="selectedList.length > 0">({{selectedList.length}})</span>
          </span>
        </div>
        <div class="tree-list-body" :style="bodyStyle">
          <div class="list-header">
            <i class="bx bx-undo"></i>
            <i class="bx bx-trash" @click="clearSelected"></i>
          </div>
          <div class="tree-content" :style="contentStyle">
            <ul class="tree-item">
              <li v-for="(item, index) in selectedList" :key="index">
                <span class="item-label">{{item.label}}</span>
                <i class="bx bx-x" @click="removeSelected(item.value)"></i>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    height: {
      type: Number,
      default() {
        return 600;
      }
    },
    nodeKey: {
      type: String,
      default() {
        return "value";
      }
    },
    checkStrictly: {
      type: Boolean,
      default() {
        return false;
      }
    },
    onlyLeaf: {
      type: Boolean,
      default() {
        return false;
      }
    },
    treeType: {
      type: String,
      default() {
        return "dept";
      }
    },
    deptTree: Array,
    treeTitle: String,
    selectedKeyList: Array,
    selectedList: Array
  },
  data() {
    return {
      filterText: "",
      style: "height:" + this.height + "px;",
      bodyStyle: "height:" + (this.height - 120) + "px;",
      contentStyle: "height:" + (this.height - 190) + "px;"
    };
  },
  mounted() {},
  watch: {
    filterText(val) {
      this.$refs.tree.filter(val);
    }
  },
  methods: {
    filterNode(value, data) {
      if (this.treeType == "user" && data.nodeType == 0) {
        return false;
      }
      if (!value) return true;
      return data.label.indexOf(value) !== -1;
    },
    fnClickNode() {
      // 获取选中的子节点列表
      // getCheckedNodes 的第一个参数为false，表示连同父节点一并获取，true只获取子节点
      this.selectedList = this.$refs.tree.getCheckedNodes(
        this.onlyLeaf,
        !this.onlyLeaf
      );
      if (this.treeType == "user") {
        this.selectedList = this.selectedList.filter(
          item => item.nodeType == 1
        );
      }
    },
    removeSelected(id) {
      var _this = this;
      _this.selectedList = this.$refs.tree
        .getCheckedNodes(this.onlyLeaf, !this.onlyLeaf)
        .filter(item => item.value != id);
      if (_this.treeType == "user") {
        _this.selectedList = _this.selectedList.filter(
          item => item.nodeType == 1
        );
      }
        _this.setCheckedNodes(_this.selectedList);

    },
    clearSelected() {
      var _this = this;
      _this.selectedList = [];
      _this.setCheckedNodes([]);
    },
    setCheckedNodes(selectedList) {
      this.$refs.tree.setCheckedNodes(selectedList);
    },
    getCheckedKeys() {
      var checkedNodes = this.$refs.tree.getCheckedNodes(
        this.onlyLeaf,
        !this.onlyLeaf
      );
      if (this.treeType == "user") {
        checkedNodes = checkedNodes.filter(item => item.nodeType == 1);
      }
      return checkedNodes.map(item => item.value);
    }
  }
};
</script>

<style lang="scss" scoped>
.tree-list-container {
  width: 100%;
  .tree-list-content {
    height: 90%;

    .tree-list-left,
    .tree-list-right {
      width: 50%;
      float: left;
      padding: 5px 10px;
      .tree-list-title {
        .title {
          line-height: 32px;
          padding: 5px 10px;
          font-size: 16px;
          border: 1px solid #ebebeb;
          // border-radius: 4px;
          border-top-left-radius: 4px;
          border-top-right-radius: 4px;
          color: #2590eb;
          border-bottom: 1px solid transparent;
        }
      }

      .tree-list-body {
        // min-height: 500px;
        border: 1px solid #ebebeb;
        padding: 10px;
        margin-top: -1px;

        .list-header {
          line-height: 38px;
          height: 38px;
          font-size: 20px;
          padding-top: 10px;
          border-bottom: 1px solid #ebebeb;

          i {
            float: right;
            color: #b5b5b5;
            margin-right: 10px;
            cursor: pointer;
          }

          i:hover {
            color: #2590eb;
          }
        }

        .tree-content {
          margin: 10px 0px;
          overflow-y: scroll;

          .filter-tree {
            margin-top: 10px;
          }
        }

        .tree-item {
          margin: 10px 5px;

          & > li {
            list-style: none;
            line-height: 30px;

            i {
              float: right;
              line-height: 30px;
              font-size: 20px;
              cursor: pointer;
              display: none;
            }
          }
          & > li:hover {
            background: #f5f5f5;
            border-radius: 3px;

            i {
              display: block;
            }
          }
        }
      }
    }
  }
}
</style>