type = ['','info','success','warning','danger'];
    	

demo = {
    initPickColor: function(){
        $('.pick-class-label').click(function(){
            var new_class = $(this).attr('new-class');  
            var old_class = $('#display-buttons').attr('data-class');
            var display_div = $('#display-buttons');
            if(display_div.length) {
                var display_buttons = display_div.find('.btn');
                display_buttons.removeClass(old_class);
                display_buttons.addClass(new_class);
                display_div.attr('data-class', new_class);
            }
        });
    },
    
    initChartist: function(){    
        
        var dataSales = {
            labels: ['Jan', 'Feb', 'Mar', 'Apr', 'Mei', 'Jun', 'Jul', 'Agu', 'Sep', 'Okt', 'Nov', 'Des'],
            series: [
            [2870, 3850, 4900, 4920, 5540, 5860, 6980, 6950, 7520, 7880, 8460, 9440],
            [1170, 2520, 3430, 4400, 5270, 5650, 6350, 6770, 7090, 7220, 8140, 9070],
            [670, 1520, 1430, 2400, 2870, 3350, 4350, 4370, 5390, 5420, 5440, 6470],
            [430, 1230, 1370, 2180, 2500, 3090, 4170, 4280, 5090, 5300, 5360, 6090],
            [230, 1130, 670, 1080, 1900, 2390, 3070, 3080, 4390, 4100, 4100, 5090]
            ]
        };
        
        var optionsSales = {
            lineSmooth: false,
            low: 0,
            high: 10000,
            showArea: true,
            height: "245px",
            axisX: {
                showGrid: false
            },
            lineSmooth: Chartist.Interpolation.simple({
                divisor: 5
            }),
            showLine: false,
            showPoint: false
        };
    
        Chartist.Line('#chartHours', dataSales, optionsSales);
        
    
        var data = {
            labels: ['Jan', 'Feb', 'Mar', 'Apr', 'Mei', 'Jun', 'Jul', 'Agu', 'Sep', 'Okt', 'Nov', 'Des'],
            series: [
            [542, 443, 320, 780, 553, 453, 326, 434, 568, 610, 756, 895],
            [412, 243, 280, 580, 453, 353, 300, 364, 368, 410, 636, 695]
            ]
        };
        
        var options = {
            seriesBarDistance: 10,
            axisX: {
                showGrid: false
            },
            height: "245px"
        };
        
        var responsiveOptions = [
        ['screen and (max-width: 640px)', {
            seriesBarDistance: 5,
            axisX: {
                labelInterpolationFnc: function (value) {
                    return value[0];
                }
            }
        }]
        ];
        
        Chartist.Bar('#chartActivity', data, options, responsiveOptions);
    
        var dataKebutuhan = {
            labels: ['2012', '2013', '2014', '2015'],
            series: [
            [550, 500, 450, 500],
            [500, 500, 450, 500],
            [570, 500, 550, 480]
            ]
        };
        
        Chartist.Bar('#chartKebutuhan', dataKebutuhan, options, responsiveOptions);
        
        var dataPreferences = {
            series: [
            [25, 30, 20, 25]
            ]
        };
        
        var optionsPreferences = {
            donut: true,
            donutWidth: 40,
            startAngle: 0,
            total: 100,
            showLabel: false,
            axisX: {
                showGrid: false
            }
        };
    
        Chartist.Pie('#chartPreferences', dataPreferences, optionsPreferences);
        
        Chartist.Pie('#chartPreferences', {
            labels: ['62%','32%','6%'],
            series: [62, 32, 6]
        });   
        
        Chartist.Pie('#chartIjin', dataPreferences, optionsPreferences);
        
        Chartist.Pie('#chartIjin', {
            labels: ['40%','32%','8%','11%','9%'],
            series: [40, 32, 8, 11, 9]
        });   
    },
    
    initGoogleMaps: function(){
        var myLatlng = new google.maps.LatLng(40.748817, -73.985428);
        var mapOptions = {
            zoom: 13,
            center: myLatlng,
            scrollwheel: false, //we disable de scroll over the map, it is a really annoing when you scroll through page
            styles: [{
                "featureType":"water",
                "stylers":[{
                    "saturation":43
                },{
                    "lightness":-11
                },{
                    "hue":"#0088ff"
                }]
                },{
                "featureType":"road",
                "elementType":"geometry.fill",
                "stylers":[{
                    "hue":"#ff0000"
                },{
                    "saturation":-100
                },{
                    "lightness":99
                }]
                },{
                "featureType":"road",
                "elementType":"geometry.stroke",
                "stylers":[{
                    "color":"#808080"
                },{
                    "lightness":54
                }]
                },{
                "featureType":"landscape.man_made",
                "elementType":"geometry.fill",
                "stylers":[{
                    "color":"#ece2d9"
                }]
                },{
                "featureType":"poi.park",
                "elementType":"geometry.fill",
                "stylers":[{
                    "color":"#ccdca1"
                }]
                },{
                "featureType":"road",
                "elementType":"labels.text.fill",
                "stylers":[{
                    "color":"#767676"
                }]
                },{
                "featureType":"road",
                "elementType":"labels.text.stroke",
                "stylers":[{
                    "color":"#ffffff"
                }]
                },{
                "featureType":"poi",
                "stylers":[{
                    "visibility":"off"
                }]
                },{
                "featureType":"landscape.natural",
                "elementType":"geometry.fill",
                "stylers":[{
                    "visibility":"on"
                },{
                    "color":"#b8cb93"
                }]
                },{
                "featureType":"poi.park",
                "stylers":[{
                    "visibility":"on"
                }]
                },{
                "featureType":"poi.sports_complex",
                "stylers":[{
                    "visibility":"on"
                }]
                },{
                "featureType":"poi.medical",
                "stylers":[{
                    "visibility":"on"
                }]
                },{
                "featureType":"poi.business",
                "stylers":[{
                    "visibility":"simplified"
                }]
                }]
    
        }
        var map = new google.maps.Map(document.getElementById("map"), mapOptions);
        
        var marker = new google.maps.Marker({
            position: myLatlng,
            title:"Hello World!"
        });
        
        // To add the marker to the map, call setMap();
        marker.setMap(map);
    },
    
    showNotification: function(from, align){
        color = Math.floor((Math.random() * 4) + 1);
    	
        $.notify({
            icon: "pe-7s-gift",
            message: "Welcome to <b>Light Bootstrap Dashboard</b> - a beautiful freebie for every web developer."
        	
        },{
            type: type[color],
            timer: 4000,
            placement: {
                from: from,
                align: align
            }
        });
    }

    
}

