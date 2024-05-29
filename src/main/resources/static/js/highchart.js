'use strict'; 

    const basisOptionen = {

         chart: {
             type: 'bar'
        },
        title: {
           text: null
        },
         xAxis: {
             title: {
                 text: null
             },
             gridLineWidth: 1,
             lineWidth: 0,
             labels: {
                 useHTML: true,
                 format: '<b>{value}</b>'
             },
             type: 'category'
         },
         yAxis: {
             min: 0,
             title: {
                 text: '',
                 align: 'high'
             },
             labels: {
                 overflow: 'justify'
             },
             gridLineWidth: 0,
             opposite: true,
             plotLines: [{
                 color: 'red', 
                 width: 3, 
                 value: 100
             }]
         },
         tooltip: {
             valueSuffix: ' % Tagesdosis'
         },
         plotOptions: {
             bar: {
                 borderRadius: '50%',
                 groupPadding: 0.1
             }
         },
         legend: {
             layout: 'vertical',
             align: 'right',
             verticalAlign: 'top',
             x: -40,
             y: 80,
             floating: true,
             borderWidth: 1,
             backgroundColor:
                 Highcharts.defaultOptions.legend.backgroundColor || '#FFFFFF',
             shadow: true
         },
         credits: {
             enabled: false
         },
         series: [{
             dataLabels: {
                 enabled: true,
                 format: ''
                 //format: '{y} {point.dimension}'
             },
             showInLegend: false
         }]
     };

    const erstelleChart = (containerId, spezifischeOptionen) => {
         return Highcharts.chart(containerId, Highcharts.merge(basisOptionen, spezifischeOptionen));
     }
     
    const addColors = (chartdata) => {
       return chartdata
               .map(obj => {
                   return {
                     ...obj,
                     color: data.getColor(obj.zuordnung) 
                   };
                 })
               .sort((a,b) => a.feld - b.feld)
    }
    
    