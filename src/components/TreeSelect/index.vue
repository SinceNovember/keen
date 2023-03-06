<template>
    <el-select :value="valueTitle" :clearable="clearable" @clear="clearHandle">
        <el-option :value="valueTitle" :label="valueTitle">
            <el-tree id="tree-option" ref="selectTree" class="scroll" :accordion="accordion" :data="options"
                :props="props" :node-key="props.value" :default-expanded-keys="defaultExpandedKey"
                @node-click="handleNodeClick">
            </el-tree>
        </el-option>
    </el-select>
</template>
<script>
export default {
    name: "tree-select",
    props: {
        /* 配置项 */
        props: {
            type: Object,
            default: () => {
                return {
                    value: 'value',             // ID字段名
                    label: 'label',         // 显示名称
                    children: 'children'    // 子级字段名
                }
            }
        },
        /* 选项列表数据(树形结构的对象数组) */
        options: {
            type: Array,
            default: () => { return [] }
        },
        /* 初始值 */
        value: {
            type: Number,
            default: () => { return null }
        },
        /* 可清空选项 */
        clearable: {
            type: Boolean,
            default: () => { return false }
        },
        /* 自动收起 */
        accordion: {
            type: Boolean,
            default: () => { return false }
        },
    },
    data() {
        return {
            valueId: this.value,    // 初始值
            valueTitle: '',
            defaultExpandedKey: []
        }
    },
    mounted() {
        this.initHandle()
    },
    methods: {
        // 初始化值
        initHandle() {
            if (this.valueId) {
                this.$nextTick(() => {
                    let node = this.$refs.selectTree.getNode(this.valueId);
                    if (node != null) {
                        this.valueTitle = node.data[this.props.label]; // 初始化显示
                        this.$refs.selectTree.setCurrentKey(this.valueId); // 设置默认选中
                        this.defaultExpandedKey = [this.valueId]; // 设置默认展开
                    }
                });
            } else {
                this.valueTitle = ""; // 清除缓存显示
            }
            // this.initScroll();
        },
        // 切换选项
        handleNodeClick(node) {
            this.valueTitle = node[this.props.label]
            this.valueId = node[this.props.value]
            this.$emit('getValue', this.valueId)
            this.defaultExpandedKey = []
        },
        // 清除选中
        clearHandle() {
            this.valueTitle = ''
            this.valueId = null
            this.defaultExpandedKey = []
            this.clearSelected()
            this.$emit('getValue', null)
        },
        /* 清空选中样式 */
        clearSelected() {
            let allNode = document.querySelectorAll('#tree-option .el-tree-node')
            allNode.forEach((element) => element.classList.remove('is-current'))
        }
    },
    watch: {
        value() {
            this.valueId = this.value;
            this.initHandle();
        },
        options: {
            handler(newValue, oldValue) {
                this.valueId = this.value;
                this.initHandle();
            },
            deep: true
        }
    },
};
</script>
<style lang="scss" scoped>
.el-scrollbar {
    .el-scrollbar__view {
        .el-select-dropdown__item {
            height: auto;
            max-height: 274px;
            padding: 0;
            overflow: hidden;
            overflow-y: auto;
        }
    }

}
</style>