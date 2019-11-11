var seriesOptions = [],

		// create the chart when all data is loaded
		createChart = function () {
				Highcharts.stockChart('container', {
						rangeSelector: {
							buttons: [{
							    type: 'year',
							    count: 1,
							    text: '1y'
							}, {
							    type: 'year',
							    count: 5,
							    text: '5y'
							}, {
							    type: 'year',
							    count: 10,
							    text: '10y'
							}, {
							    type: 'all',
							    text: 'All'
							}],
							selected: 1
						},
						yAxis: {
								title: {
									text: 'Percentage',
									align: 'middle'
								},
								plotLines: [{
										value: 0,
										width: 3,
										color: 'silver'
								}],
								opposite: false,
						},
						xAxis: {
							title: {
								text: 'Date',
								align: 'high'
							},
							plotBands: [{
								from: Date.UTC(2007, 12),
								to: Date.UTC(2009, 1),
								color: 'lightgrey',
								label: {
									text: 'Comfort zone',
									align: 'center',
									verticalAlign: 'top',
									x: 12
								}
							}]
						},
						plotOptions: {
								series: {
								}
						},
						tooltip: {
								valueDecimals: 2,
								headerFormat: '<span style="font-size: 10px">{series.name}</span><br/>',
								pointFormatter: function() {
								    return '<span style="color: '+ this.series.color + '">'+Highcharts.dateFormat('%a, %Y-%m-%d',this.x)+'</span> '
								    +': <b>'+ this.y +'</b><br/>'
								}
						},
						series: seriesOptions
				});
		};
		
//		$.each(names, function (i, name) {
//			$.getJSON('https://data.jianshukeji.com/jsonp?filename=json/' + name.toLowerCase() + '-c.json&callback=?',    function (data) {
//					seriesOptions[i] = {
//							name: name,
//							data: data
//					};
//					// As we're loading the data asynchronously, we don't know what order it will arrive. So
//					// we keep a counter and create the chart when all the data is loaded.
//					seriesCounter += 1;
//					if (seriesCounter === names.length) {
//							createChart();
//					}
//			});
//	});

$.getJSON('/getDefaultList',function (data) {
	var myData = [];
	
	console.log('***observationDate: '+data[1200].observationDate);
	console.log('***observationDate: '+data[150].observationDate);
	
	 for(var i=0;i<data.length;i++){

		 var observationDate = data[i].observationDate;
		 var t10Y2Y = data[i].t10Y2Y;
		 var postData = [observationDate,t10Y2Y];
		 
		 myData.push(postData);
     };
    console.log('***data: '+myData[1200]);
 	seriesOptions[0]= {
 			  name: 'T10Y2Y',
 			  data: myData
 			};
     createChart();   
 });