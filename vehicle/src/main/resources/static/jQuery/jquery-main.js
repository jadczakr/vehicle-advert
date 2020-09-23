$(document).ready(function()
	{


	cena = document.getElementsByClassName("cena");
	var finalCena ;
	var i ;
	var element;

	for(i = 0 ; i<cena.length ; i++)
		{
		
            element = cena[i].innerText;
             
          
          if(element.length==8)
               {
                 cena[i].textContent = element.charAt(0) + " " + element.substring(1,8);                 
               }
          
          
            if(element.length==9)
               {
                 cena[i].textContent = element.substring(0,2) + " " + element.substring(2,9);                 
               }
          
                    
          if(element.length==10)
               {
                 cena[i].textContent = element.substring(0,3) + " " + element.substring(3,10);                 
               }
          
		}

	
	
	
	$('body').hide();
	$('body').fadeIn(1000);
	$(".container-fluid").hide();
	$(".container-fluid").delay(2000).fadeIn(1000);

	{   //options tak/nie
		var options = "<option value='true'>Tak</option><option value='false'>Nie</option>";
		$(".true-false").html(options);
	}
	
	
	$(".type-button").click(function()
		{
			var str = $(this).attr('value');
			$(".container").fadeOut("slow");
			$("#"+$(this).attr('value')).fadeIn("slow");
		});

		$(".add").hide();

	$(".btn-choose").click(function()
			{
				
				
				$(".btn-choose").removeClass("btn-choosed");
				$(this).addClass("btn-choosed");
				$(".add-form-car").slideUp("fast");
				$("#" +$(this).attr('value')).delay(500).slideToggle("slow");
		
			});
	
	$("#sendImageButton").click(function()
			{
				$("#inputPhotos").click();	
			});
		
	
	
	
	$(".additional-equipment-button").click(function()
			{
				var wyposazenie = $("#inputAdditional").val();
				
					if(wyposazenie.search($(this).val())==-1)
						{
							$("#inputAdditional").val($("#inputAdditional").val()+$(this).val() + ";");
							$(this).removeClass("additional-equipment-button");
							$(this).addClass("additional-equipment-button-checked");
						}
					else
						{	
							
							$(this).removeClass("additional-equipment-button-checked");
							$(this).addClass("additional-equipment-button");
							
							var string1 = $("#inputAdditional").val();
							var string2 = $(this).val();
							var string3 = string1.replace(string2 + ";","");	
							$("#inputAdditional").val(string3);
						}
			});
	
	
	
	 var ctrlDown = false,
     ctrlKey = 17,
     cmdKey = 91,
     vKey = 86,
     cKey = 67;

 $(document).keydown(function(e) {
     if (e.keyCode == ctrlKey || e.keyCode == cmdKey) ctrlDown = true;
 }).keyup(function(e) {
     if (e.keyCode == ctrlKey || e.keyCode == cmdKey) ctrlDown = false;
 });

 $(".no-copy-paste").keydown(function(e) {
     if (ctrlDown && (e.keyCode == vKey || e.keyCode == cKey)) return false;
 });
 
 // Document Ctrl + C/V 
 $(document).keydown(function(e) {
     if (ctrlDown && (e.keyCode == cKey)) console.log("Document catch Ctrl+C");
     if (ctrlDown && (e.keyCode == vKey)) console.log("Document catch Ctrl+V");
 });
 
 
	
});

$(window).scroll(function() {
	
	var height = $(window).scrollTop();
	
	document.getElementById("kontakt").style.top= height+200 +'px';
	document.getElementById("kontakt-name").style.top= height+200 +'px';
	document.getElementById("mapka").style.top=height + 200 + 'px';
});


function bodyonload()
{
var year = 1960;
var till = 2020;
var options = "";

for(var y=year; y<=till; y++){
  options += "<option>"+ y +"</option>";    
}

document.getElementById("inputProdYear").innerHTML = options;
document.getElementById("inputProdYear1").innerHTML = options;

}

function updateIloscHeader()
{

aktualnaIlosc = document.getElementById("inputDescription").value.length;
	

	
	if(aktualnaIlosc>25 && aktualnaIlosc<40)
		{
			document.getElementById("inputDescription").style.color="	#999900";
			document.getElementById("iloscHeader").style.color="	#999900";
		}
	else if(aktualnaIlosc>39)
		{
			document.getElementById("inputDescription").style.color="red";
			document.getElementById("iloscHeader").style.color="red";
		}
	else
		{
			document.getElementById("inputDescription").style.color="#142355";
			document.getElementById("iloscHeader").style.color="#142355";
		}
	
	document.getElementById("iloscHeader").innerText = aktualnaIlosc + " / 50"; 
}


function updateIloscDescriptionLong()
{

aktualnaIlosc = document.getElementById("inputDescriptionLong").value.length;
	

	
	if(aktualnaIlosc>300 && aktualnaIlosc<400)
		{
			document.getElementById("inputDescriptionLong").style.color="	#999900";
			document.getElementById("iloscDescriptionLong").style.color="	#999900";
		}
	else if(aktualnaIlosc>399)
		{
			document.getElementById("inputDescriptionLong").style.color="red";
			document.getElementById("iloscDescriptionLong").style.color="red";
		}
	else
		{
			document.getElementById("inputDescriptionLong").style.color="#142355";
			document.getElementById("iloscDescriptionLong").style.color="#142355";
		}
	
	document.getElementById("iloscDescriptionLong").innerText = aktualnaIlosc + " / 250"; 
}

