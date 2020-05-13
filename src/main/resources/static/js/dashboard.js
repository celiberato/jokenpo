function dragPanel(idPanel){
		
	// Make the DIV element draggable:
	dragElement(document.getElementById(idPanel));
}

function dragElement(elmnt) {
  var pos1 = 0, pos2 = 0, pos3 = 0, pos4 = 0;
  if (document.getElementById(elmnt.id + "_header")) {
    // if present, the header is where you move the DIV from:
    document.getElementById(elmnt.id + "_header").onmousedown = dragMouseDown;
  } else {
    // otherwise, move the DIV from anywhere inside the DIV: 
    elmnt.onmousedown = dragMouseDown;
  }

  function dragMouseDown(e) {
    e = e || window.event;
    e.preventDefault();
    // get the mouse cursor position at startup:
    pos3 = e.clientX;
    pos4 = e.clientY;
    document.onmouseup = closeDragElement;
    // call a function whenever the cursor moves:
    document.onmousemove = elementDrag;
  }

  function elementDrag(e) {
    e = e || window.event;
    e.preventDefault();
    // calculate the new cursor position:
    pos1 = pos3 - e.clientX;
    pos2 = pos4 - e.clientY;
    pos3 = e.clientX;
    pos4 = e.clientY;
    // set the element's new position:
    elmnt.style.top = (elmnt.offsetTop - pos2) + "px";
    elmnt.style.left = (elmnt.offsetLeft - pos1) + "px";
  }

  function closeDragElement() {
    // stop moving when mouse button is released:
    document.onmouseup = null;
    document.onmousemove = null;
  }

}	

function resetarLayout(){
	$('#panelDrag_filtro').css('top', 10);
	$('#panelDrag_filtro').css('left', 14);
	$('#panelDrag_filtro').css('width', 414);
	$('#panelDrag_filtro').css('height', 172);
	
	$('#panelDrag_endereco').css('top', 10);
	$('#panelDrag_endereco').css('left', 45);
	$('#panelDrag_endereco').css('width', 414);
	$('#panelDrag_endereco').css('height', 172);
	
	$('#panelDrag_legenda').css('top', 10);
	$('#panelDrag_legenda').css('left', 78);
	$('#panelDrag_legenda').css('width', 414);
	$('#panelDrag_legenda').css('height', 172);
		
	$('#panelDrag_mapa').css('top', 192);
	$('#panelDrag_mapa').css('left', 14);
	$('#panelDrag_mapa').css('width', 1260);
	$('#panelDrag_mapa').css('height', 344);
		
	$('#panelDrag_ocorrencias').css('top', 544);
	$('#panelDrag_ocorrencias').css('left', 14);
	$('#panelDrag_ocorrencias').css('width', 626);
	$('#panelDrag_ocorrencias').css('height', 173);
		
	$('#panelDrag_recursos').css('top', 544);
	$('#panelDrag_recursos').css('left', 64);
	$('#panelDrag_recursos').css('width', 623);
	$('#panelDrag_recursos').css('height', 173);
	
}

function carregarLayout(){

	var coordenadas = JSON.parse(localStorage.getItem('coordenadas'));
	
	$('#panelDrag_filtro').css('top', coordenadas.filtro_top);
	$('#panelDrag_filtro').css('left', coordenadas.filtro_left);
	$('#panelDrag_filtro').css('width', coordenadas.filtro_width);
	$('#panelDrag_filtro').css('height', coordenadas.filtro_height);
	
	$('#panelDrag_endereco').css('top', coordenadas.endereco_top);
	$('#panelDrag_endereco').css('left', coordenadas.endereco_left);
	$('#panelDrag_endereco').css('width', coordenadas.endereco_width);
	$('#panelDrag_endereco').css('height', coordenadas.endereco_height);
	
	$('#panelDrag_legenda').css('top', coordenadas.legenda_top);
	$('#panelDrag_legenda').css('left', coordenadas.legenda_left);
	$('#panelDrag_legenda').css('width', coordenadas.legenda_width);
	$('#panelDrag_legenda').css('height', coordenadas.legenda_height);
		
	$('#panelDrag_mapa').css('top', coordenadas.mapa_top);
	$('#panelDrag_mapa').css('left', coordenadas.mapa_left);
	$('#panelDrag_mapa').css('width', coordenadas.mapa_width);
	$('#panelDrag_mapa').css('height', coordenadas.mapa_height);
		
	$('#panelDrag_ocorrencias').css('top', coordenadas.ocorrencias_top);
	$('#panelDrag_ocorrencias').css('left', coordenadas.ocorrencias_left);
	$('#panelDrag_ocorrencias').css('width', coordenadas.ocorrencias_width);
	$('#panelDrag_ocorrencias').css('height', coordenadas.ocorrencias_height);
		
	$('#panelDrag_recursos').css('top', coordenadas.recursos_top);
	$('#panelDrag_recursos').css('left', coordenadas.recursos_left);
	$('#panelDrag_recursos').css('width', coordenadas.recursos_width);
	$('#panelDrag_recursos').css('height', coordenadas.recursos_height);

}

function salvarLayout() {
	var coordenadas = 
		{
			"filtro_top": $('#panelDrag_filtro').css('top'), 
			"filtro_left": $('#panelDrag_filtro').css('left'), 
			"filtro_width": $('#panelDrag_filtro').css('width'), 
			"filtro_height": $('#panelDrag_filtro').css('height'),
			"endereco_top":	$('#panelDrag_endereco').css('top'), 
			"endereco_left": $('#panelDrag_endereco').css('left'), 
			"endereco_width": $('#panelDrag_endereco').css('width'), 
			"endereco_height": $('#panelDrag_endereco').css('height'),
			"legenda_top": $('#panelDrag_legenda').css('top'), 
			"legenda_left": $('#panelDrag_legenda').css('left'), 
			"legenda_width": $('#panelDrag_legenda').css('width'), 
			"legenda_height": $('#panelDrag_legenda').css('height'),
			"mapa_top": $('#panelDrag_mapa').css('top'), 
			"mapa_left": $('#panelDrag_mapa').css('left'), 
			"mapa_width": $('#panelDrag_mapa').css('width'), 
			"mapa_height": $('#panelDrag_mapa').css('height'),
			"ocorrencias_top": $('#panelDrag_ocorrencias').css('top'), 
			"ocorrencias_left": $('#panelDrag_ocorrencias').css('left'), 
			"ocorrencias_width": $('#panelDrag_ocorrencias').css('width'), 
			"ocorrencias_height": $('#panelDrag_ocorrencias').css('height'),
			"recursos_top": $('#panelDrag_recursos').css('top'), 
			"recursos_left": $('#panelDrag_recursos').css('left'), 
			"recursos_width": $('#panelDrag_recursos').css('width'), 
			"recursos_height": $('#panelDrag_recursos').css('height')
		}

	localStorage.setItem('coordenadas', JSON.stringify(coordenadas));
	
	alert('Layout Salvo com Sucesso!');
}

function alternarTick(opcao){
	if(opcao=="filtro"){
		$('#tick_filtro').toggleClass("tick_verde");
		$('#tick_filtro').toggleClass("tick_verde_invisible");
		
		$('#panelDrag_filtro').toggleClass("panel-visible");
		$('#panelDrag_filtro').toggleClass("panel-invisible");
	}
	if(opcao=="endereco"){
		$('#tick_endereco').toggleClass("tick_verde");
		$('#tick_endereco').toggleClass("tick_verde_invisible");

		$('#panelDrag_endereco').toggleClass("panel-visible");
		$('#panelDrag_endereco').toggleClass("panel-invisible");
	}
	if(opcao=="legenda"){
		$('#tick_legenda').toggleClass("tick_verde");
		$('#tick_legenda').toggleClass("tick_verde_invisible");

		$('#panelDrag_legenda').toggleClass("panel-visible");
		$('#panelDrag_legenda').toggleClass("panel-invisible");
	}
	if(opcao=="mapa"){
		$('#tick_mapa').toggleClass("tick_verde");
		$('#tick_mapa').toggleClass("tick_verde_invisible");
		
		$('#panelDrag_mapa').toggleClass("panel-visible");
		$('#panelDrag_mapa').toggleClass("panel-invisible");		
	}
	if(opcao=="ocorrencias"){
		$('#tick_ocorrencias').toggleClass("tick_verde");
		$('#tick_ocorrencias').toggleClass("tick_verde_invisible");
		
		$('#panelDrag_ocorrencias').toggleClass("panel-visible");
		$('#panelDrag_ocorrencias').toggleClass("panel-invisible");		
	}
	if(opcao=="recursos"){
		$('#tick_recursos').toggleClass("tick_verde");
		$('#tick_recursos').toggleClass("tick_verde_invisible");

		$('#panelDrag_recursos').toggleClass("panel-visible");
		$('#panelDrag_recursos').toggleClass("panel-invisible");
	}
}

$( document ).ready(function() {
	
	dragPanel("panelDrag_filtro");
	dragPanel("panelDrag_endereco");
	dragPanel("panelDrag_legenda");
	dragPanel("panelDrag_mapa");
	dragPanel("panelDrag_ocorrencias");
	dragPanel("panelDrag_recursos");
	
	resetarLayout();
	
	$('#btnQuem').click(function(){
		$('#divOnde').addClass("collapse-display");
		$('#divOcorrencias').addClass("collapse-display");
		$('#divRecursos').addClass("collapse-display");

		$('#divQuem').toggleClass("collapse-display");
	});
	$('#btnOnde').click(function(){
		$('#divQuem').addClass("collapse-display");
		$('#divOcorrencias').addClass("collapse-display");
		$('#divRecursos').addClass("collapse-display");

		$('#divOnde').toggleClass("collapse-display");
	});
	$('#btnOcorrencias').click(function(){
		$('#divQuem').addClass("collapse-display");
		$('#divOnde').addClass("collapse-display");
		$('#divRecursos').addClass("collapse-display");

		$('#divOcorrencias').toggleClass("collapse-display");
	});
	$('#btnRecursos').click(function(){
		$('#divQuem').addClass("collapse-display");
		$('#divOnde').addClass("collapse-display");
		$('#divOcorrencias').addClass("collapse-display");
		
		$('#divRecursos').toggleClass("collapse-display");
	});
	
});