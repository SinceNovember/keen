export function remove_empty_children(obj) {
  Object.keys(obj).forEach(function (k) {
    var v = obj[k];
    if (v.children.length <= 0) delete v.children;
    else {
      remove_empty_children(v.children);
    }
  })
}

export function typeObj(obj) {
  var type = Object.prototype.toString.call(obj);
  if (type == '[object Array]') {
    return 'Array';
  } else if (type == '[object  Object]') {
    return 'Object';
  } else {
    return "obj is not object or array"
  }

}

export function dateFormat(fmt, date) {
  var o = {
    "M+": date.getMonth() + 1,                 //月份 
    "d+": date.getDate(),                    //日 
    "h+": date.getHours(),                   //小时 
    "m+": date.getMinutes(),                 //分 
    "s+": date.getSeconds(),                 //秒 
    "q+": Math.floor((date.getMonth() + 3) / 3), //季度 
    "S": date.getMilliseconds()             //毫秒 
  };
  if (/(y+)/.test(fmt)) {
    fmt = fmt.replace(RegExp.$1, (date.getFullYear() + "").substr(4 - RegExp.$1.length));
  }
  for (var k in o) {
    if (new RegExp("(" + k + ")").test(fmt)) {
      fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    }
  }
  return fmt;
}

export function msgDateFormat(date) {
  return dateFormat('hh:mm', date)
}

export function nowTimeStr() {
  return dateTimeFormat(new Date())
}

export function dateTimeFormat(date) {
  return dateFormat("yyyy-MM-dd hh:mm:ss", date)
}

export function getTimeLine(lastMsg) {
  var now = "";
  //消息之间差三分钟，添加时间线
  if (!lastMsg || parseInt(Date.parse(new Date()) - Date.parse(lastMsg.createTime)) / 1000 / 60 > 3) {
    now = dateFormat("hh:mm", new Date());
  }
  return now;
}
