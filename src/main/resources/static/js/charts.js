var decodedChartData = decodeHtml(chartData);
var chartDataJsonArray = JSON.parse(decodedChartData);

var arrayLength = chartDataJsonArray.length;
var countData =[];
var stageData = [];

for(var i=0; i < arrayLength; i++){
    countData[i] = chartDataJsonArray[i].count;
    stageData[i] = chartDataJsonArray[i].stage;
}

// For a pie chart
new Chart(document.getElementById('mainPieChart'), {
    type: 'pie',
    // The data for our dataset
    data: {
        labels: stageData,
        datasets: [{
            label: 'My First dataset',
            backgroundColor: ["#E1586D","#41ADD8","#FCFF5E"],
            borderColor: 'rgb(246,255,253)',
            data: countData
        }]
    },

    // Configuration options go here
    options: {
        title:{
            display : true,
            text : 'Project Status.'
        }
    }
});

// "[{"value": 1, "label": "COMPLETED"},{"value": 2, "label": "INPROGRESS"},{"value": 1, "label": "NOTSTARTED"}]"
function decodeHtml(html) {
    var txt = document.createElement("textarea");
    txt.innerHTML = html;
    return txt.value;
}