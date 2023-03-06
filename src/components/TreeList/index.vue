<template>
    <div class="tree-list-container">
        <div class="tree-list-content">
            <div class="tree-list-left">
                <div class="tree-list-title">
                    <span class="title">{{ treeTitle }}</span>
                </div>
                <div class="tree-list-body" :style="bodyStyle">
                    <el-input placeholder="输入关键字进行过滤" v-model="filterText"></el-input>
                    <div class="tree-content scroll" :style="contentStyle">
                        <el-tree class="filter-tree" icon-class="el-icon-arrow-right" :check-strictly="checkStrictly"
                            show-checkbox :node-key="nodeKey" :data="treeData" :filter-node-method="filterNode"
                            :default-checked-keys="selectedKeyList" @check="fnClickNode" ref="tree"></el-tree>
                    </div>
                </div>
            </div>
            <div class="tree-list-right">
                <div class="tree-list-title">
                    <span class="title">
                        已选择记录
                        <span v-if="selectedNodeList.length > 0">({{ selectedNodeList.length }})</span>
                    </span>
                </div>
                <div class="tree-list-body" :style="bodyStyle">
                    <div class="list-header">
                        <i class="bi bi-trash3"></i>
                        <i class="bi bi-arrow-clockwise" @click="clearSelected"></i>
                    </div>
                    <div class="tree-content scroll" :style="contentStyle">
                        <ul class="tree-item">
                            <li v-for="(item, index) in selectedNodeList" :key="index">
                                <span class="item-label">{{ item.label }}</span>
                                <i class="bi bi-x" @click="removeSelected(item.value)"></i>
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
                return 540;
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
                return "dept"
            }
        },
        treeData: {
            type: Array,
            default: () => []
        },
        treeTitle: {
            type: String,
            default() {
                return "授权部门"
            }
        },
        selectedKeyList: {
            type: Array,
            default: () => []
        },
        selectedList: {
            type: Array,
            default: () => []
        },
    },
    data() {
        return {
            selectedNodeList: this.selectedList,
            filterText: "",
            style: "height:" + this.height + "px;",
            bodyStyle: "height:" + (this.height - 120) + "px;",
            contentStyle: "height:" + (this.height - 190) + "px;"
        };
    },
    watch: {
        filterText(val) {
            this.$refs.tree.filter(val);
        },
    },
    methods: {
        recursiveNode(tree, arr, toArr) {
            tree.forEach(node => {
                if (arr.indexOf(node.value) != -1) {
                    toArr.push(node);
                }
                if (node.children) {
                    this.recursiveNode(node.children, arr, toArr);
                }
            });
        },
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
            this.selectedNodeList = this.$refs.tree.getCheckedNodes(
                this.onlyLeaf,
                !this.onlyLeaf
            );
            // if (this.treeType == "user") {
            //     this.selectedList = this.selectedList.filter(
            //         item => item.nodeType == 1
            //     );
            // }
        },
        removeSelected(id) {
            this.selectedNodeList = this.$refs.tree
                .getCheckedNodes(this.onlyLeaf, !this.onlyLeaf)
                .filter(item => item.value != id);
            // if (this.treeType == "user") {
            //     this.selectedNodeList = this.selectedNodeList.filter(
            //         item => item.nodeType == 1
            //     );
            // }
            this.setCheckedNodes(this.selectedNodeList);
        },
        clearSelected() {
            this.selectedNodeList = [];
            this.setCheckedNodes([]);
        },
        setCheckedNodes(selectedNodeList) {
            this.$refs.tree.setCheckedNodes(selectedNodeList);
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
                    border: 1px solid var(--bs-border-dashed-color);
                    border-top-left-radius: 4px;
                    border-top-right-radius: 4px;
                    color: #409EFF;
                    border-bottom: 1px solid transparent;
                }
            }

            .tree-list-body {
                border: 1px solid var(--bs-border-dashed-color);
                padding: 10px;
                margin-top: -1px;

                .list-header {
                    line-height: 36px;
                    height: 36px;
                    font-size: 20px;
                    padding-top: 10px;
                    border-bottom: 1px solid var(--bs-border-dashed-color);

                    i {
                        float: right;
                        color: var(--bs-gray-600);
                        margin-right: 10px;
                        cursor: pointer;
                    }

                    i:hover {
                        color: #2590eb;
                    }
                }

                .tree-content {
                    margin: 5px 0px;

                    .filter-tree {
                        margin-top: 4px;
                    }
                }

                .tree-item {
                    margin: 5px;
                    padding: 0px;
                    color: var(--bs-gray-700);

                    &>li {
                        list-style: none;
                        line-height: 30px;

                        i {
                            float: right;
                            line-height: 30px;
                            font-size: 20px;
                            cursor: pointer;
                            display: none;
                            color: var(--bs-gray-600);

                        }

                        .item-label {
                            padding-left: 4px;
                        }
                    }

                    &>li:hover {
                        background: var(--bs-gray-100);
                        border-radius: 3px;

                        i {
                            display: block;
                        }
                    }
                }
            }
        }

        .tree-list-right {
            .tree-list-body {
                padding-right: 0px;
            }
        }
    }
}
</style>