    var map;
    var mark;
    var lineCoords = [];
    var infowindow;

    var speedText = function(speed){
        return '<div style="color:black">'+speed+' MPH</div>';
    }

    var initialize = function(lat, lng) {
      map  = new google.maps.Map(document.getElementById('map-canvas'), {center:{lat:lat, lng:lng},zoom:15});
      var icon = {
              path: "M29.395,0H17.636c-3.117,0-5.643,3.467-5.643,6.584v34.804c0,3.116,2.526,5.644,5.643,5.644h11.759 c3.116,0,5.644-2.527,5.644-5.644V6.584C35.037,3.467,32.511,0,29.395,0z M34.05,14.188v11.665l-2.729,0.351v-4.806L34.05,14.188z M32.618,10.773c-1.016,3.9-2.219,8.51-2.219,8.51H16.631l-2.222-8.51C14.41,10.773,23.293,7.755,32.618,10.773z M15.741,21.713 v4.492l-2.73-0.349V14.502L15.741,21.713z M13.011,37.938V27.579l2.73,0.343v8.196L13.011,37.938z M14.568,40.882l2.218-3.336 h13.771l2.219,3.336H14.568z M31.321,35.805v-7.872l2.729-0.355v10.048L31.321,35.805z",
              fillColor: '#FF0000',
              fillOpacity: .6,
              anchor: new google.maps.Point(25,50),
              strokeWeight: 0,
          }

      mark = new google.maps.Marker({position:{lat:lat, lng:lng}, map:map, icon: icon});
      infowindow = new google.maps.InfoWindow({content: speedText(0)});
      infowindow.open(map, mark);
    };

    var redraw = function(lat, lng, direction, speed) {
    console.log("this is direction "+direction);
      if(lat){
          map.setCenter({lat:lat, lng:lng, alt:0});
          mark.setPosition({lat:lat, lng:lng, alt:0});
          console.log(speed +' MPH');
          var icon=mark.getIcon();
          icon.rotation=direction;
          mark.setIcon(icon);
            infowindow.setContent(speedText(speed));
          lineCoords.push(new google.maps.LatLng(lat, lng));

          var lineCoordinatesPath = new google.maps.Polyline({
            path: lineCoords,
            geodesic: true,
            strokeColor: '#2E10FF'
          });

          lineCoordinatesPath.setMap(map);
      }
    };


    var initMap = function(){
                        fetch('/process?path=C%3A%5CUsers%5Csumit%5CPictures%5C14er%5Cdashcam%5CGPSDATA%5CG2020_0808_034437_00000FA.txt')
        .then(response => response.json())
  .then(data => {
        console.log(data);
     initialize(data[0].lat, data[0].lon);
     console.log("init done");
     var i = 1;

     var setWait =  setInterval(()=>{
          if(data[i].lat!= 999 && data[i].lon != 999)
              redraw(data[i].lat, data[i].lon, data[i].dir, data[i].velocity);
              i++;
              if(i==data.length){
                clearInterval(setWait);
                alert("swagatam");
              }
     }, 100);
      });
 }

    window.initMap = initMap;