<template>
    <keen-dialog title="图片剪裁" :visible.sync="dialogVisible" :width="780" @save="saveImg" @cancel="handleClose"
        :appendBody="true">
        <div class="cropper-content">
            <div class="cropper">
                <vueCropper ref="cropper" :img="cropperImg" :outputSize="option.size" :outputType="option.outputType"
                    :info="true" :full="option.full" :canMove="option.canMove" :canMoveBox="option.canMoveBox"
                    :original="option.original" :autoCrop="option.autoCrop" :fixed="option.fixed"
                    :fixedNumber="option.fixedNumber" :centerBox="option.centerBox" :infoTrue="option.infoTrue"
                    :fixedBox="option.fixedBox"></vueCropper>
            </div>
        </div>
    </keen-dialog>
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
    data() {
        return {
            option: {
                img: '', // 裁剪图片的地址
                info: true, // 裁剪框的大小信息
                outputSize: 0.8, // 裁剪生成图片的质量
                outputType: 'jpeg', // 裁剪生成图片的格式
                canScale: false, // 图片是否允许滚轮缩放
                autoCrop: true, // 是否默认生成截图框
                autoCropWidth: 200, // 默认生成截图框宽度
                autoCropHeight: 200, // 默认生成截图框高度
                // fixedBox: true, // 固定截图框大小 不允许改变
                fixed: false, // 是否开启截图框宽高固定比例
                fixedNumber: [7, 5], // 截图框的宽高比例
                full: true, // 是否输出原图比例的截图
                canMoveBox: true, // 截图框能否拖动
                original: false, // 上传图片按照原始比例渲染
                centerBox: false, // 截图框是否被限制在图片里面
                infoTrue: true // true 为展示真实输出图片宽高 false 展示看到的截图框宽高
            },
        }
    },
    methods: {
        handleClose() {
            this.$emit('colse-dialog', false);
        },
        // 获取裁剪之后的图片，默认blob，也可以获取base64的图片
        saveImg() {
            if (this.imgType === 'blob') {
                this.$refs.cropper.getCropBlob(data => {
                    this.$emit('upload-img', data);
                });
            } else {
                this.$refs.cropper.getCropData(data => {
                    this.uploadFile = data;
                    this.$emit('upload-img', data);
                })
            }
        }
    }
}
</script>
<style lang="scss" scoped>
.cropper-content {
    .cropper {
        text-align: center;
        width: auto;
        height: 400px;
    }
}
</style>