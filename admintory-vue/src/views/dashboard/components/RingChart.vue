<template>
  <div :class="className" :style="{height:height,width:width}" />
</template>

<script>
import * as echarts from "echarts";
require("echarts/theme/macarons"); // echarts theme
// import resize from './mixins/resize'

const colorList = ["#9E87FF", "#73DDFF", "#fe9a8b", "#F56948", "#9E87FF"];

export default {
  //   mixins: [resize],
  props: {
    className: {
      type: String,
      default: "chart"
    },
    width: {
      type: String,
      default: "100%"
    },
    height: {
      type: String,
      default: "300px"
    },
    autoResize: {
      type: Boolean,
      default: true
    },
    chartData: {
      type: Object,
      required: true
    }
  },
  data() {
    return {
      chart: null
    };
  },
  watch: {
    chartData: {
      deep: true,
      handler(val) {
        this.setOptions(val);
      }
    }
  },
  mounted() {
    this.$nextTick(() => {
      this.initChart();
    });
  },
  beforeDestroy() {
    if (!this.chart) {
      return;
    }
    this.chart.dispose();
    this.chart = null;
  },
  methods: {
    initChart() {
      this.chart = echarts.init(this.$el, "macarons");
      this.setOptions(this.chartData);
    },
    setOptions(data) {
      this.chart.setOption({
        legend: {
          orient: "vertical",
          top: "10%",
          right: "2%",
          data: data.map(item => item.name),
          textStyle: {
            fontSize: 12
          }
        },
        tooltip: {
          trigger: "item",
          formatter: "{a} <br/>{b} : {c} ({d}%)",
          backgroundColor: "#fff",
          textStyle: {
            color: "#5c6c7c"
          },
          extraCssText: "box-shadow: 1px 0 2px 0 rgba(163,163,163,0.5)"

        },
        series: [
          {
            name: "角色人数",
            type: "pie",
            radius: ["30%", "80%"],
            center: ["40%", "50%"],
            roseType: "radius",
            label: {
              show: true,
              normal: {
                position: "outside",
                fontSize: 16
              }
            },
            labelLine: {
              length: 1,
              length2: 20,
              smooth: true
            },
            data: data
          }
        ]
      });
    }
  }
};
</script>
