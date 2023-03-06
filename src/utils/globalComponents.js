import KeenDialog from '@/components/KeenDialog'

function plugins(Vue) {
    //注册
    Vue.component('KeenDialog', KeenDialog); //第一个参数:组件名称,第二个参数:要注册的组件
}
export default plugins;