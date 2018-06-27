$(document).ready(function() {
	$("#tauxTva").on("keyup",function(){
		//alert("Tva event");
		tvaKeyUpFunction();
	})
});

tvaKeyUpFunction = function (){
	var prixUnitHT = $("#prixUnitaireHT").val();
	var tauxTVA = $("#tauxTva").val();
	var prixUnitTTC = parseFloat(parseFloat(prixUnitHT ) * parseFloat(tauxTVA)/100  + parseFloat(prixUnitHT));
	$("#prixUnitaireTTC").val(prixUnitTTC);
}