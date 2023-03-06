<template>
    <div :class="$options.name">
      <el-dialog
        :visible.sync="dialogVisible"
        width="600px"
        :before-close="handleClose" 
        append-to-body>
        <div
          class="cropper-container">
          <div class="cropper-el">
            <vue-cropper
              ref="cropper"
              :img="cropperImg"
              :output-size="option.size"
              :output-type="option.outputType"
              :info="true"
              :full="option.full"
              :can-move="option.canMove"
              :can-move-box="option.canMoveBox"
              :fixed-box="option.fixedBox"
              :original="option.original"
              :auto-crop="option.autoCrop"
              :auto-crop-width="option.autoCropWidth"
              :auto-crop-height="option.autoCropHeight"
              :center-box="option.centerBox"
              :high="option.high"
              :info-true="option.infoTrue"
              @realTime="realTime"
              :enlarge="option.enlarge"
              :fixed="option.fixed"
              :fixed-number="option.fixedNumber"
            />
          </div>
          <!-- 预览 -->
          <div
            class="prive-el">
            <div
              class="prive-style"
              :style="{'width': '150px', 'height': '266px', 'overflow': 'hidden', 'margin': '0 25px', 'display':'flex', 'align-items' : 'center'}">
              <div
                class="preview"
                :style="previews.div">
                <img
                  :src="previews.url"
                  :style="previews.img">
              </div>
            </div>
            <el-button
              @click="uploadBth"
              v-if="option.img">重新上传</el-button>
          </div>
        </div>
        <span
          slot="footer"
          class="dialog-footer">
          <el-button
            @click="handleClose">取 消</el-button>
          <el-button
            type="primary"
            @click="saveImg">确 定</el-button>
        </span>
      </el-dialog>
    </div>
  </template>
  
  <script>
  import { VueCropper } from 'vue-cropper';
  export default {
    name: 'Cropper',
    components: {
      VueCropper
    },
    props: {
      dialogVisible: {
        type: Boolean,
        default: false
      },
      imgType: {
        type: String,
        default: 'blob'
      },
      cropperImg: {
        type: String,
        default: ''
      }
    },
    data () {
      return {
        previews: {},
        option: {
          img: '', // 裁剪图片的地址
          size: 1, // 裁剪生成图片的质量
          full: false, // 是否输出原图比例的截图 默认false
          outputType: 'png', // 裁剪生成图片的格式 默认jpg
          canMove: false, // 上传图片是否可以移动
          fixedBox: false, // 固定截图框大小 不允许改变
          original: false, // 上传图片按照原始比例渲染
          canMoveBox: true, // 截图框能否拖动
          autoCrop: true, // 是否默认生成截图框
          // 只有自动截图开启 宽度高度才生效
          autoCropWidth: 200, // 默认生成截图框宽度
          autoCropHeight: 150, // 默认生成截图框高度
          centerBox: true, // 截图框是否被限制在图片里面
          high: false, // 是否按照设备的dpr 输出等比例图片
          enlarge: 1, // 图片根据截图框输出比例倍数
          mode: 'contain', // 图片默认渲染方式
          maxImgSize: 2000, // 限制图片最大宽度和高度
          limitMinSize: [100, 120], // 更新裁剪框最小属性
          infoTrue: false, // true 为展示真实输出图片宽高 false 展示看到的截图框宽高
          fixed: true, // 是否开启截图框宽高固定比例  (默认:true)
          fixedNumber: [9, 16] // 截图框的宽高比例
        }
      };
    },
    methods: {
      // 裁剪时触发的方法，用于实时预览
      realTime (data) {
        this.previews = data;
      },
      // 重新上传
      uploadBth () {
        this.$emit('update-cropper');
      },
      // 取消关闭弹框
      handleClose () {
        this.$emit('colse-dialog', false);
      },
      // 获取裁剪之后的图片，默认blob，也可以获取base64的图片
      saveImg () {
        if (this.imgType === 'blob') {
          this.$refs.cropper.getCropBlob(data => {
            this.$emit('upload-img', data);
          });
        } else {
          this.$refs.cropper.getCropData(data => {
            this.uploadFile = data;
            this.$emit('upload-img', data);
          });
        }
      }
    }
  };
  </script>
  
  <style lang="scss" scoped>
  .Cropper {
    .cropper-el {
      height: 300px;
      width: 300px;
    }
    .cropper-container {
      display: flex;
      justify-content: space-between;
      .prive-el {
        height: 164px;
        width: 94px;
        flex: 1;
        text-align: center;
        .prive-style {
          margin: 0 auto;
          flex: 1;
          -webkit-flex: 1;
          display: flex;
          display: -webkit-flex;
          justify-content: center;
          -webkit-justify-content: center;
          overflow: hidden;
          background: #ededed;
          margin-left: 40px;
        }
        .preview {
          overflow: hidden;
        }
        .el-button {
          margin-top: 20px;
        }
      }
    }
  }
  </style>