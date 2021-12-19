<template>
  <div class="add-container">
      <div class="dialog-title">添加部门</div>
      <div class="info-container">
        <el-form :model="deptInfo" label-position="right" label-width="80px"  :rules="rules"   ref="deptInfo"  >
                <el-form-item label="上级部门">
                    <tree-select  v-model="deptInfo.parentId" 
                        :width="340"
                        :data="deptOptions" 
                        nodeKey="value"
                        :checkedKeys="defaultCheckedKeys"
                        @popoverHide="popoverHide"></tree-select>
                </el-form-item>
                <el-form-item label="部门名称" prop="deptName">
                    <el-input v-model="deptInfo.deptName"></el-input>
                </el-form-item>
                <el-form-item label="部门简称">
                    <el-input v-model="deptInfo.deptShortName"></el-input>
                </el-form-item>
                <el-form-item label="排序号">
                    <el-input-number v-model="deptInfo.orderNum"></el-input-number>
                </el-form-item>
                <el-form-item label="描述">
                    <el-input v-model="deptInfo.description" type="textarea"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="addDept('deptInfo')">确认</el-button>
                    <el-button @click="closeDialog">取消</el-button>
                </el-form-item>
        </el-form>

      </div>
      </div>

</template>

<script>
import { saveDept, updateDept, fetchDeptOptions} from "@/api/dept"
import TreeSelect from '@/components/TreeSelect.vue'
import {remove_empty_children, typeObj} from '@/utils/utils'
import {checkPhone, checkEmail} from '@/utils/rule'

export default {
    components:{
        TreeSelect,
          
    },
    props:{
        deptInfo: Object,
        defaultCheckedKeys: Array,
    },
    data(){ 
        return {
            deptOptions: [],
            sexOptions:[{
            value: '0',
            label: '男'
            }, {
            value: '1',
            label: '女'
            }, {
            value: '2',
            label: '未知'
            }],
            StatusOptions:[ 
            {
            value: '0',
            label: '禁用'
            }, {
            value: '1',
            label: '有效'
            }],
            rules: {
                deptName: [
                    { required: true, message: '部门名称不能为空', trigger: 'blur' }
                ]
            }
        }
    },
    mounted(){
        this.loadDeptOptions();
    },
    methods:{
        addDept(formName){
            this.$refs[formName].validate((valid)=>{
                if(valid){
                    var _this = this;
                    if (typeObj(_this.deptInfo.parentId) == 'Array'){
                        _this.deptInfo.parentId = _this.deptInfo.parentId[_this.deptInfo.parentId.length - 1];
                    }
                    
                    if (_this.deptInfo.deptId){
                        updateDept(_this.deptInfo).then(res => {
                            this.$emit('closeDialog', 1);
                            this.$message({
                                message: "修改成功",
                                type: 'success'
                            });
                        })
                    } else {
                        saveDept(_this.deptInfo).then(res => {
                            this.$emit('closeDialog', 1);
                            this.$message({
                                message: "添加成功",
                                type: 'success'
                            });
                        })
                    }
  
                }
            });
        },
        closeDialog(){
            this.$emit('closeDialog');
        },
        loadDeptOptions(){
            var _this = this;
                fetchDeptOptions().then(res => {
                _this.deptOptions = res.data;
                // remove_empty_children(_this.deptOptions);
            })
        },  
        popoverHide(key, value){
            var _this = this;
            _this.deptInfo.parentId = key;
        },
    }
}
</script>

<style lang="scss" scoped>

</style>