var city_name = null;
var district_name = null;

//set_districts();

 $(function(){
  set_districts();
  $("#city-dropdown li a").click(function(e){
	  city_name = $(e.currentTarget).attr("city_name");
	$("#city-button").text($(this).text());
	set_districts();
	});	 
});


function set_districts(){
	$("#confirm_btn").prop( "disabled", true );
	district_name = null;
	 $("#district-button").html('Districts<span class="caret"></span>');
	switch(city_name){
	  case "ISTANBUL":
	  
	  $("#districts-dropdown-menu").html('\
	  <li role="presentation"><a role="menuitem" tabindex="-1" href="#" city_id="3">MERKEZ</a></li>\
      <li role="presentation"><a role="menuitem" tabindex="-1" href="#" city_id="1">ARNAVUTKOY</a></li>\
      <li role="presentation"><a role="menuitem" tabindex="-1" href="#" city_id="2">ATASEHIR</a></li>\
      <li role="presentation"><a role="menuitem" tabindex="-1" href="#" city_id="3">AVCILAR</a></li>\
	  <li role="presentation"><a role="menuitem" tabindex="-1" href="#" city_id="3">BASAKSEHIR</a></li>\
	  <li role="presentation"><a role="menuitem" tabindex="-1" href="#" city_id="3">KADIKOY</a></li>');
	  break;
	  case "ANKARA":
	  
	  $("#districts-dropdown-menu").html('\
	  <li role="presentation"><a role="menuitem" tabindex="-1" href="#" city_id="3">MERKEZ</a></li>\
      <li role="presentation"><a role="menuitem" tabindex="-1" href="#" city_id="1">YENIMAHALLE</a></li>\
      <li role="presentation"><a role="menuitem" tabindex="-1" href="#" city_id="2">CANKAYA</a></li>\
      <li role="presentation"><a role="menuitem" tabindex="-1" href="#" city_id="3">GOLBASI</a></li>\
	  <li role="presentation"><a role="menuitem" tabindex="-1" href="#" city_id="3">MAMAK</a></li>\
	  <li role="presentation"><a role="menuitem" tabindex="-1" href="#" city_id="3">POLATLI</a></li>');
	  break;
	  case "IZMIR":
	 
	  $("#districts-dropdown-menu").html('\
	  <li role="presentation"><a role="menuitem" tabindex="-1" href="#" city_id="3">MERKEZ</a></li>\
      <li role="presentation"><a role="menuitem" tabindex="-1" href="#" city_id="1">ALIAGA</a></li>\
      <li role="presentation"><a role="menuitem" tabindex="-1" href="#" city_id="2">BALCOVA</a></li>\
      <li role="presentation"><a role="menuitem" tabindex="-1" href="#" city_id="3">BORNOVA</a></li>\
	  <li role="presentation"><a role="menuitem" tabindex="-1" href="#" city_id="3">CESME</a></li>\
	  <li role="presentation"><a role="menuitem" tabindex="-1" href="#" city_id="3">KARSIYAKA</a></li>');
	  break;
	  default:
	  
	  $("#districts-dropdown-menu").html('\
      <li role="presentation">Please choose a city</li>');
	}
    $("#districts-dropdown-menu li a").click(function(e){
    district_name = $(e.currentTarget).text();
	if(district_name == "MERKEZ"){
		district_name = city_name + "-MERKEZ";
	}
	$("#district-button").text($(this).text());
	$("#confirm_btn").prop( "disabled", false );
	});
}
 
function isNumberKey(evt)
{
	var charCode = (evt.which) ? evt.which : evt.keyCode;
	if (charCode != 46 && charCode !=45 && charCode > 31 
	&& (charCode < 48 || charCode > 57))
	return false;
	return true;
}  



function send_data(temperature1,temperature2,temperature3) {
	


	$.ajax({
	  type: "POST",
	  url: "http://localhost:8081/weather/new_data",
	  contentType: "application/json",
	  data: JSON.stringify({
		  "cityName": city_name,
		  "district": district_name,
	      "temperature1": parseInt(temperature1), 
	      "temperature2": parseInt(temperature2), 
		  "temperature3": parseInt(temperature3) 
	  }),
	  success: (data) => {
		console.log(data);
	  },
	  dataType: "json"
	});
}



