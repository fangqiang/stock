package cn.truthseeker.template;

/**
 * @Description:
 * @author: qiang.fang
 * @email: lowping@163.com
 * @date: Created by on 19/4/29
 */
public class Day {

    public static String render(String s){
        return html.replace("DATA",s);
    }

    private static final String html = "<!DOCTYPE html>\n" +
            "<html style=\"height: 100%\">\n" +
            "   <head>\n" +
            "       <meta charset=\"utf-8\">\n" +
            "   </head>\n" +
            "   <body style=\"height: 100%; margin: 0\">\n" +
            "       <div id=\"container\" style=\"height: 100%\"></div>\n" +
            "       <script type=\"text/javascript\" src=\"http://echarts.baidu.com/gallery/vendors/echarts/echarts.min.js\"></script>\n" +
            "       <script type=\"text/javascript\" src=\"http://echarts.baidu.com/gallery/vendors/echarts-gl/echarts-gl.min.js\"></script>\n" +
            "       <script type=\"text/javascript\" src=\"http://echarts.baidu.com/gallery/vendors/echarts-stat/ecStat.min.js\"></script>\n" +
            "       <script type=\"text/javascript\" src=\"http://echarts.baidu.com/gallery/vendors/echarts/extension/dataTool.min.js\"></script>\n" +
            "       <script type=\"text/javascript\" src=\"http://echarts.baidu.com/gallery/vendors/echarts/extension/bmap.min.js\"></script>\n" +
            "       <script type=\"text/javascript\" src=\"http://echarts.baidu.com/gallery/vendors/simplex.js\"></script>\n" +
            "       <script type=\"text/javascript\">\n" +
            "var dom = document.getElementById(\"container\");\n" +
            "var myChart = echarts.init(dom);\n" +
            "var app = {};\n" +
            "option = null;\n" +
            "var upColor = '#ec0000';\n" +
            "var upBorderColor = '#8A0000';\n" +
            "var downColor = '#00da3c';\n" +
            "var downBorderColor = '#008F28';\n" +
            "\n" +
            "\n" +
            "// 数据意义：开盘(open)，收盘(close)，最低(lowest)，最高(highest)\n" +
            "var data0 = splitData(DATA);\n" +
            "\n" +
            "\n" +
            "function splitData(rawData) {\n" +
            "    var categoryData = [];\n" +
            "    var values = []\n" +
            "    for (var i = 0; i < rawData.length; i++) {\n" +
            "        categoryData.push(rawData[i].splice(0, 1)[0]);\n" +
            "        values.push(rawData[i])\n" +
            "    }\n" +
            "    return {\n" +
            "        categoryData: categoryData,\n" +
            "        values: values\n" +
            "    };\n" +
            "}\n" +
            "\n" +
            "function calculateMA(dayCount) {\n" +
            "    var result = [];\n" +
            "    for (var i = 0, len = data0.values.length; i < len; i++) {\n" +
            "        if (i < dayCount) {\n" +
            "            result.push('-');\n" +
            "            continue;\n" +
            "        }\n" +
            "        var sum = 0;\n" +
            "        for (var j = 0; j < dayCount; j++) {\n" +
            "            sum += data0.values[i - j][1];\n" +
            "        }\n" +
            "        result.push(sum / dayCount);\n" +
            "    }\n" +
            "    return result;\n" +
            "}\n" +
            "\n" +
            "\n" +
            "\n" +
            "option = {\n" +
            "    title: {\n" +
            "        text: '上证指数',\n" +
            "        left: 0\n" +
            "    },\n" +
            "    tooltip: {\n" +
            "        trigger: 'axis',\n" +
            "        axisPointer: {\n" +
            "            type: 'cross'\n" +
            "        }\n" +
            "    },\n" +
            "    legend: {\n" +
            "        data: ['日K', 'MA5', 'MA10', 'MA20', 'MA30']\n" +
            "    },\n" +
            "    grid: {\n" +
            "        left: '10%',\n" +
            "        right: '10%',\n" +
            "        bottom: '15%'\n" +
            "    },\n" +
            "    xAxis: {\n" +
            "        type: 'category',\n" +
            "        data: data0.categoryData,\n" +
            "        scale: true,\n" +
            "        boundaryGap : false,\n" +
            "        axisLine: {onZero: false},\n" +
            "        splitLine: {show: false},\n" +
            "        splitNumber: 20,\n" +
            "        min: 'dataMin',\n" +
            "        max: 'dataMax'\n" +
            "    },\n" +
            "    yAxis: {\n" +
            "        scale: true,\n" +
            "        splitArea: {\n" +
            "            show: true\n" +
            "        }\n" +
            "    },\n" +
            "    dataZoom: [\n" +
            "        {\n" +
            "            type: 'inside',\n" +
            "            start: 50,\n" +
            "            end: 100\n" +
            "        },\n" +
            "        {\n" +
            "            show: true,\n" +
            "            type: 'slider',\n" +
            "            y: '90%',\n" +
            "            start: 50,\n" +
            "            end: 100\n" +
            "        }\n" +
            "    ],\n" +
            "    series: [\n" +
            "        {\n" +
            "            name: '日K',\n" +
            "            type: 'candlestick',\n" +
            "            data: data0.values,\n" +
            "            itemStyle: {\n" +
            "                normal: {\n" +
            "                    color: upColor,\n" +
            "                    color0: downColor,\n" +
            "                    borderColor: upBorderColor,\n" +
            "                    borderColor0: downBorderColor\n" +
            "                }\n" +
            "            },\n" +
            "            markPoint: {\n" +
            "                label: {\n" +
            "                    normal: {\n" +
            "                        formatter: function (param) {\n" +
            "                            return param != null ? Math.round(param.value) : '';\n" +
            "                        }\n" +
            "                    }\n" +
            "                },\n" +
            "                data: [\n" +
            "                    {\n" +
            "                        name: 'XX标点',\n" +
            "                        coord: ['2013/5/31', 2300],\n" +
            "                        value: 2300,\n" +
            "                        itemStyle: {\n" +
            "                            normal: {color: 'rgb(41,60,85)'}\n" +
            "                        }\n" +
            "                    },\n" +
            "                    {\n" +
            "                        name: 'highest value',\n" +
            "                        type: 'max',\n" +
            "                        valueDim: 'highest'\n" +
            "                    },\n" +
            "                    {\n" +
            "                        name: 'lowest value',\n" +
            "                        type: 'min',\n" +
            "                        valueDim: 'lowest'\n" +
            "                    },\n" +
            "                    {\n" +
            "                        name: 'average value on close',\n" +
            "                        type: 'average',\n" +
            "                        valueDim: 'close'\n" +
            "                    }\n" +
            "                ],\n" +
            "                tooltip: {\n" +
            "                    formatter: function (param) {\n" +
            "                        return param.name + '<br>' + (param.data.coord || '');\n" +
            "                    }\n" +
            "                }\n" +
            "            },\n" +
            "            markLine: {\n" +
            "                symbol: ['none', 'none'],\n" +
            "                data: [\n" +
            "                    [\n" +
            "                        {\n" +
            "                            name: 'from lowest to highest',\n" +
            "                            type: 'min',\n" +
            "                            valueDim: 'lowest',\n" +
            "                            symbol: 'circle',\n" +
            "                            symbolSize: 10,\n" +
            "                            label: {\n" +
            "                                normal: {show: false},\n" +
            "                                emphasis: {show: false}\n" +
            "                            }\n" +
            "                        },\n" +
            "                        {\n" +
            "                            type: 'max',\n" +
            "                            valueDim: 'highest',\n" +
            "                            symbol: 'circle',\n" +
            "                            symbolSize: 10,\n" +
            "                            label: {\n" +
            "                                normal: {show: false},\n" +
            "                                emphasis: {show: false}\n" +
            "                            }\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    {\n" +
            "                        name: 'min line on close',\n" +
            "                        type: 'min',\n" +
            "                        valueDim: 'close'\n" +
            "                    },\n" +
            "                    {\n" +
            "                        name: 'max line on close',\n" +
            "                        type: 'max',\n" +
            "                        valueDim: 'close'\n" +
            "                    }\n" +
            "                ]\n" +
            "            }\n" +
            "        },\n" +
            "        {\n" +
            "            name: 'MA5',\n" +
            "            type: 'line',\n" +
            "            data: calculateMA(5),\n" +
            "            smooth: true,\n" +
            "            lineStyle: {\n" +
            "                normal: {opacity: 0.5}\n" +
            "            }\n" +
            "        },\n" +
            "        {\n" +
            "            name: 'MA10',\n" +
            "            type: 'line',\n" +
            "            data: calculateMA(10),\n" +
            "            smooth: true,\n" +
            "            lineStyle: {\n" +
            "                normal: {opacity: 0.5}\n" +
            "            }\n" +
            "        },\n" +
            "        {\n" +
            "            name: 'MA20',\n" +
            "            type: 'line',\n" +
            "            data: calculateMA(20),\n" +
            "            smooth: true,\n" +
            "            lineStyle: {\n" +
            "                normal: {opacity: 0.5}\n" +
            "            }\n" +
            "        },\n" +
            "        {\n" +
            "            name: 'MA30',\n" +
            "            type: 'line',\n" +
            "            data: calculateMA(30),\n" +
            "            smooth: true,\n" +
            "            lineStyle: {\n" +
            "                normal: {opacity: 0.5}\n" +
            "            }\n" +
            "        },\n" +
            "\n" +
            "    ]\n" +
            "};\n" +
            "\n" +
            ";\n" +
            "if (option && typeof option === \"object\") {\n" +
            "    myChart.setOption(option, true);\n" +
            "}\n" +
            "       </script>\n" +
            "   </body>\n" +
            "</html>";
}
