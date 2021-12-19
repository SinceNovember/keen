
import Vue from 'vue'
import { msgDateFormat, nowTimeStr } from './utils.js'

Vue.filter('SexFilter', function (status) {
  const statusMap = {
    MALE: '男',
    FEMALE: '女',
    UNKNOWN: '未知'
  }
  return statusMap[status]
});


Vue.filter('StatusFilter', function (status) {
  const statusMap = {
    VALID: 'success',
    LOCK: 'danger'
  }
  return statusMap[status]
});

Vue.filter('StatusInfoFilter', function (status) {
  const statusMap = {
    LOCK: '禁用',
    VALID: '启用',
  }
  return statusMap[status]
});

Vue.filter('msgDateFilter', function (data) {
  return msgDateFormat(data)
})

Vue.filter('dateStrFilter', function (data) {
  if (data) {
    var timeArr = data.replace(" ", ":").replace(/\:/g, "-").split("-");
    var nowArr = nowTimeStr().replace(" ", ":").replace(/\:/g, "-").split("-");
    //今天的显示时间
    if (nowArr[1] == timeArr[1] && nowArr[2] == timeArr[2]) {
      return "" + timeArr[3] + ":" + timeArr[4]
    }
    return "" + timeArr[1] + "-" + timeArr[2]
  }

  return ''
})