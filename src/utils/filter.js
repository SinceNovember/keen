
import Vue from 'vue'

Vue.filter('StatusFilter', function (status) {
    const statusMap = {
        true: '是',
        false: '否'
    }
    return statusMap[status]
});


Vue.filter('SexFilter', function (status) {
    const statusMap = {
        MALE: '男',
        FEMALE: '女',
        UNKNOWN: '未知'
    }
    return statusMap[status]
});


Vue.filter('StatusTypeFilter', function (status) {
    const statusMap = {
        LOCK: '禁用',
        VALID: '启用',
    }
    return statusMap[status]
});
