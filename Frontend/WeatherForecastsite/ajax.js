var sock = new SockJS('http://localhost:8082/weathersocket');

 sock.onopen = function() {
     console.log('open');
     sock.send('{"name":"okan"}');
 };

 sock.onmessage = function(e) {
	 var data = JSON.parse(e.data);
	 for(var district in data){
		var districtObj = data[district];
		 
		 
		
		 console.log(districtObj["temperature1"]);	
         console.log(districtObj["temperature2"]);	 
		 console.log(districtObj["temperature3"]);		 
		 console.log(data);
 		 	
	 }
	 for (var cityName in data){
		 
		 var cityObj= data[cityName];
		 
	 }

	if(cityObj["cityName"]=="ISTANBUL")
	{
		if(districtObj["district"]=="ISTANBUL-MERKEZ")
		{
		$("#data1").text(districtObj["temperature1"]+" ℃ ");
		$("#data2").text(districtObj["temperature2"]+" ℃ ");
		$("#data3").text(districtObj["temperature3"]+" ℃ ");
		}
		if(districtObj["district"]=="ARNAVUTKOY")
		{
		$("#data4").text(districtObj["temperature1"]+" ℃ ");
		$("#data5").text(districtObj["temperature2"]+" ℃ ");
		$("#data6").text(districtObj["temperature3"]+" ℃ ");
		}
		if(districtObj["district"]=="ATASEHIR")
		{
		$("#data7").text(districtObj["temperature1"]+" ℃ ");
		$("#data8").text(districtObj["temperature2"]+" ℃ ");
		$("#data9").text(districtObj["temperature3"]+" ℃ ");
		}
		if(districtObj["district"]=="AVCILAR")
		{
		$("#data10").text(districtObj["temperature1"]+" ℃ ");
		$("#data11").text(districtObj["temperature2"]+" ℃ ");
		$("#data12").text(districtObj["temperature3"]+" ℃ ");
		}
		if(districtObj["district"]=="BASAKSEHIR")
		{
		$("#data13").text(districtObj["temperature1"]+" ℃ ");
		$("#data14").text(districtObj["temperature2"]+" ℃ ");
		$("#data15").text(districtObj["temperature3"]+" ℃ ");
		}
		if(districtObj["district"]=="KADIKOY")
		{
		$("#data16").text(districtObj["temperature1"]+" ℃ ");
		$("#data17").text(districtObj["temperature2"]+" ℃ ");
		$("#data18").text(districtObj["temperature3"]+" ℃ ");
		}
		
		
	 
	}
	if(cityObj["cityName"]=="ANKARA")
	{
		if(districtObj["district"]=="ANKARA-MERKEZ")
		{
		$("#data19").text(districtObj["temperature1"]+" ℃ ");
		$("#data20").text(districtObj["temperature2"]+" ℃ ");
		$("#data21").text(districtObj["temperature3"]+" ℃ ");
		}
		if(districtObj["district"]=="YENIMAHALLE")
		{
		$("#data22").text(districtObj["temperature1"]+" ℃ ");
		$("#data23").text(districtObj["temperature2"]+" ℃ ");
		$("#data24").text(districtObj["temperature3"]+" ℃ ");
		}
		if(districtObj["district"]=="CANKAYA")
		{
		$("#data25").text(districtObj["temperature1"]+" ℃ ");
		$("#data26").text(districtObj["temperature2"]+" ℃ ");
		$("#data27").text(districtObj["temperature3"]+" ℃ ");
		}
		if(districtObj["district"]=="GOLBASI")
		{
		$("#data28").text(districtObj["temperature1"]+" ℃ ");
		$("#data29").text(districtObj["temperature2"]+" ℃ ");
		$("#data30").text(districtObj["temperature3"]+" ℃ ");
		}
		if(districtObj["district"]=="MAMAK")
		{
		$("#data31").text(districtObj["temperature1"]+" ℃ ");
		$("#data32").text(districtObj["temperature2"]+" ℃ ");
		$("#data33").text(districtObj["temperature3"]+" ℃ ");
		}
		if(districtObj["district"]=="POLATLI")
		{
		$("#data34").text(districtObj["temperature1"]+" ℃ ");
		$("#data35").text(districtObj["temperature2"]+" ℃ ");
		$("#data36").text(districtObj["temperature3"]+" ℃ ");
		}
		
		
	 
	}
	if(cityObj["cityName"]=="IZMIR")
	{
		if(districtObj["district"]=="IZMIR-MERKEZ")
		{
		$("#data37").text(districtObj["temperature1"]+" ℃ ");
		$("#data38").text(districtObj["temperature2"]+" ℃ ");
		$("#data39").text(districtObj["temperature3"]+" ℃ ");
		}
		if(districtObj["district"]=="ALIAGA")
		{
		$("#data40").text(districtObj["temperature1"]+" ℃ ");
		$("#data41").text(districtObj["temperature2"]+" ℃ ");
		$("#data42").text(districtObj["temperature3"]+" ℃ ");
		}
		if(districtObj["district"]=="BALCOVA")
		{
		$("#data43").text(districtObj["temperature1"]+" ℃ ");
		$("#data44").text(districtObj["temperature2"]+" ℃ ");
		$("#data45").text(districtObj["temperature3"]+" ℃ ");
		}
		if(districtObj["district"]=="BORNOVA")
		{
		$("#data46").text(districtObj["temperature1"]+" ℃ ");
		$("#data47").text(districtObj["temperature2"]+" ℃ ");
		$("#data48").text(districtObj["temperature3"]+" ℃ ");
		}
		if(districtObj["district"]=="CESME")
		{
		$("#data49").text(districtObj["temperature1"]+" ℃ ");
		$("#data50").text(districtObj["temperature2"]+" ℃ ");
		$("#data51").text(districtObj["temperature3"]+" ℃ ");
		}
		if(districtObj["district"]=="KARSIYAKA")
		{
		$("#data52").text(districtObj["temperature1"]+" ℃ ");
		$("#data53").text(districtObj["temperature2"]+" ℃ ");
		$("#data54").text(districtObj["temperature3"]+" ℃ ");
		}
		
		
	 
	}
	
	 

 };

 sock.onclose = function() {
     console.log('close');
 };
 