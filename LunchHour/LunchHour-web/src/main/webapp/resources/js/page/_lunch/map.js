var markers = [];
var defaultZoom = 15;

function loadMarkers(jsonArrayRestaurant) {

   var ja = JSON.parse(jsonArrayRestaurant);
   var latlng = new google.maps.LatLng(ja[0].latitude, ja[0].longitude);

   var myOptions = {
      zoom: defaultZoom,
      center: latlng,
      mapTypeId: google.maps.MapTypeId.HYBRID,
      styles: [
         {
            featureType: 'poi.business',
            elementType: 'labels',
            stylers: [
               {visibility: 'off'}
            ]
         },
         {
            featureType: 'poi.medical',
            elementType: 'labels',
            stylers: [
               {visibility: 'off'}
            ]
         },
         {
            featureType: 'transit.station.bus',
            elementType: 'labels',
            stylers: [
               {visibility: 'off'}
            ]
         }
      ]

   };

   map = new google.maps.Map(document.getElementById("map"), myOptions);

   for (var i = 0; i < ja.length; i++) {

      var marker = new google.maps.Marker({
         position: new google.maps.LatLng(ja[i].latitude, ja[i].longitude),
         draggable: false,
         animation: google.maps.Animation.DROP,
         map: map
      });
      
      markers.push(marker);

   }

}


function loadLocation(latitude, longitude, name, address) {
   
   setMapOnAll(null);
   markers = [];
   var latLgn = new google.maps.LatLng(latitude, longitude)

   var marker = new google.maps.Marker({
      position: latLgn,
      draggable: false,
      animation: google.maps.Animation.DROP,
      map: map
   });
   
   map.setZoom(19);
   map.setCenter(latLgn);
   
   var contentString = 
      '<div>'+name
      +'</div>'
      +'<div>'+address
      +'</div>';
      
   marker.addListener('click', function() {
      
      var infowindow = new google.maps.InfoWindow({
          content: contentString
      });
      
      infowindow.open(map, marker);

   });

   markers.push(marker);

}


function setMapOnAll(map) {
   
   for (var i = 0; i < markers.length; i++) {
      markers[i].setMap(map);
   }
   
}