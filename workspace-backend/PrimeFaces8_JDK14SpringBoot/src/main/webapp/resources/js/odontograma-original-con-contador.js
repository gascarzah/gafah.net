/**
 * Giovanni Ascarza Hinostroza
 * 
 * 
 */

(function($) {
	

	
	var perPorExtraer = document.getElementById("perPorExtraer");
	var resPorExtraer = document.getElementById("resPorExtraer");
	var perProtesis = document.getElementById("perProtesis");
	var resProtesis = document.getElementById("resProtesis");
	
	var perPerdida = document.getElementById("perPerdida");
	var resPerdida = document.getElementById("resPerdida");
	var perObturada = document.getElementById("perObturada");
	var resObturada = document.getElementById("resObturada");
	
	var perCariada = document.getElementById("perCariada");
	var resCariada = document.getElementById("resCariada");
	var perFracturada = document.getElementById("perFracturada");
	var resFracturada = document.getElementById("resFracturada");
	
	var perTotal = document.getElementById("perTotal");
	var resTotal = document.getElementById("resTotal");

	
	perPorExtraer.innerHTML = contaPerPorExtraer;
	resPorExtraer.innerHTML = contaResPorExtraer;
	perProtesis.innerHTML = contaPerProtesis;
	resProtesis.innerHTML = contaResProtesis;
	
	perPerdida.innerHTML = contaPerPerdida;
	resPerdida.innerHTML = contaResPerdida;
	perObturada.innerHTML = contaPerObturada;
	resObturada.innerHTML = contaResObturada;
	
	perCariada.innerHTML = contaPerCariada;
	resCariada.innerHTML = contaResCariada;
	perFracturada.innerHTML = contaPerFracturada;
	resFracturada.innerHTML = contaResFracturada;
	
		
	perTotal.innerHTML = contaPerTotal; 
	resTotal.innerHTML = contaResTotal;
	

	
	
	//View Models
	var colorCara ;
	var carColor ;
//	var scale = "1.5";

	function DienteModel(id, x, y) {
		var self = this;

		self.id = id;
		self.x = x ; //se le aumenta 5 espacios a la coordenada
		self.y = y + 50; //se le aumenta 10 espacios a la coordenada
		tempDientes.push(id);
	}

	//Cargo los dientes
	var dientes = [];
	//constante horizontal
	var k = 20;
	//constante desplazamiento horizontal piezas derecha
	var kd = 200;
	//constante desplazamiento horizontal piezas izquierda
	var ks = 35;
	//constante vertical
	var kv = 48;

	//PC
	//izquierdo
	for (var i = 0; i < 8; i++) {
		dientes.push(new DienteModel((18 - i) / 10, (i * k) + ks, 0));
	}
	//derecho
	for (var i = 0; i < 8; i++) {
		dientes.push(new DienteModel((21 + i) / 10, (i * k) + kd, 0));
	}
	
	//SC
	// izquierdo
	for (var i = 0; i < 5; i++) {
		dientes.push(new DienteModel((55 - i) / 10, ((i + 3) * k) + ks, 1 * 50));
	}
	//derecho
	for (var i = 0; i < 5; i++) {
		dientes.push(new DienteModel((61 + i) / 10, (i * k) + kd, 1 * 50));
	}
	
	//TC
	// izquierdo
	for (var i = 0; i < 5; i++) {
		dientes.push(new DienteModel((85 - i) / 10, ((i + 3) * k) + ks, 2 * kv));
	}
	// derecho
	for (var i = 0; i < 5; i++) {
		dientes.push(new DienteModel((71 + i) / 10, (i * k) + kd, 2 * kv));
	}
	
	//CC
	/// izquierdo
	for (var i = 0; i < 8; i++) {
		dientes.push(new DienteModel((48 - i) / 10, (i * k) + ks, 3 * kv));
	}
	
	//derechos
	for (var i = 0; i < 8; i++) {
		dientes.push(new DienteModel((31 + i) / 10, (i * k) + kd, 3 * kv));
	}
	

	function arrayFilter(array, predicate) {
		array = array || [];
		var result = [];
		for (var i = 0, j = array.length; i < j; i++)
		if (predicate(array[i])) result.push(array[i]);
		return result;
	}

	function drawDiente(svg, parentGroup, diente) {
		
		if (!diente) throw new Error('Error no se ha especificado el diente.');

		var x = diente.x || 0,
			y = diente.y || 0;

		var defaultPolygon = {
			fill: 'white',
			stroke: 'navy',
			strokeWidth: 0.5
		}

//		var supernumerario = svg.line(parentGroup, {
//			transform: 'translate(' + x + ',' + y + ')'
//		});
		
		var dienteGroup = svg.group(parentGroup, {
			transform: 'translate(' + x + ',' + y + ')'
		});

		var calculatePolygon = function(cara) {
				switch (cara) {
				case 'L': //'S':
					//Superior
					return [[0, 0], [20, 0], [15, 5], [5, 5]];
				case 'V'://'I':
					//Inferior
					return [[5, 15], [15, 15], [20, 20], [0, 20]];
				case 'M'://'D':
					//Derecha
					return [[15, 5], [20, 0], [20, 20], [15, 15]];
				case 'D'://'Z':
					//Izquierda
					return [[0, 0], [5, 5], [5, 15], [0, 20]];
				case 'O'://'C':
					//Central
					return [[5, 5], [15, 5], [15, 15], [5, 15]];
					
				case 'R'://'W':
					//Raiz Superior o raiz izquierda
					if(diente.id == 1.8 || diente.id == 1.7 || diente.id == 1.6 || diente.id == 1.4 || diente.id == 2.8 || diente.id == 2.7 || diente.id == 2.6 || diente.id == 2.4
							|| diente.id == 5.5 || diente.id == 5.4 || diente.id == 6.4 || diente.id == 6.5  ){
						return [[0, -15], [10, 0], [0, 0]]; //triangulo izquierdo arriba
						
					}else if(diente.id == 4.8 || diente.id == 4.7 || diente.id == 4.6 || diente.id == 3.8 || diente.id == 3.7 || diente.id == 3.6 
							|| diente.id == 8.5 || diente.id == 8.4 || diente.id == 7.4 || diente.id == 7.5  ){
						return [[0, 20], [0,35], [10, 20]];//triangulo izquierdo abajo
					}
					else if(diente.id == 1.5 || diente.id == 1.3 || diente.id == 1.2 || diente.id == 1.1 || diente.id == 2.1 || diente.id == 2.2 
							|| diente.id == 2.3 || diente.id == 2.5 || diente.id == 5.3 || diente.id == 5.2 || diente.id == 5.1 
							|| diente.id == 6.3 || diente.id == 6.2 || diente.id == 6.1){
						return [[0, 0], [10, -15], [20, 0]]; //triangulo del medio arriba
					}else{
						return [[0, 20], [10, 35], [20, 20]];//triangulo del medio abajo
					}
				case 'r'://'T':
					//Super inferior o raiz derecha
					
					if(diente.id == 1.8 || diente.id == 1.7 || diente.id == 1.6 || diente.id == 1.4 || diente.id == 2.8 || diente.id == 2.7 || diente.id == 2.6 || diente.id == 2.4
							|| diente.id == 5.5 || diente.id == 5.4 || diente.id == 6.4 || diente.id == 6.5  ){
						return [[20, -15], [20, 0], [10, 0]]; //triangulo derecho arriba
					}else if(diente.id == 4.8 || diente.id == 4.7 || diente.id == 4.6 || diente.id == 3.8 || diente.id == 3.7 || diente.id == 3.6 
							|| diente.id == 8.5 || diente.id == 8.4 || diente.id == 7.4 || diente.id == 7.5  ){
						return [[10, 20], [20, 20], [20, 35]];//triangulo derecho abajo
					}
					else{
						return [];
					}
					
					
				case 'z'://'T':
					//raiz del medio
					if(diente.id == 1.8 || diente.id == 1.7 || diente.id == 1.6 || diente.id == 1.4 || diente.id == 2.8 || diente.id == 2.7 || diente.id == 2.6 || diente.id == 2.4
							|| diente.id == 5.5 || diente.id == 5.4 || diente.id == 6.4 || diente.id == 6.5  ){
						return [[6, -5], [10, -15], [14, -5],[10,0]];
						
					}else if(diente.id == 4.8 || diente.id == 4.7 || diente.id == 4.6 || diente.id == 3.8 || diente.id == 3.7 || diente.id == 3.6 
							|| diente.id == 8.5 || diente.id == 8.4 || diente.id == 7.4 || diente.id == 7.5  ){
						return [[6,25],[10,35], [14,25], [10,20]];
					}
					else{
						return [];
					}
					
				default:
					throw new Error('La cara: ' + cara + ' no es una cara valida.');
				}
			}

		
		var attachEventsAndData = function(element, cara) {
			
			if(!settings.readOnly){
				
				element.data('cara', cara).click(function() {
					
					var me = $(this);
					var cara = me.data('cara');
//					alert("cara "+cara)
					if (cara == 'X' ){
						var count = 0;
						for(var i=0; i < arrPiezaInicial.length; i++){
							if(diente.id == arrPiezaInicial[i]){
								count++;
								break;
							}
						}
//						alert("count "+count)
						if(count == 1){
							obtenerProcedimientoPieza([{name:'dienteId', value:diente.id}, {name:'cara', value:cara}]);
						}else{
							alert('Debe de marcar esta pieza con las opciones de la parte inferior izquierda.');	
						}
						
						
					}else {
						
						if (!$('input:radio[name=opt]').is(":checked") && !$('input:radio[name=color]').is(":checked")) {
							alert('Debe seleccionar una opcion previamente.');
							return false;
						}
						
						var tempoNuevas = [];//17032016
						var tempoDifCara = [];//17032016
//						alert(carColor)
//						alert($('input:radio[name=opt]').val())
						// Validaciones de si la cara tiene tratamiento o no, etc...
						var tratamientoIngresado = {
							diente: diente,
							cara: cara,
							//tratamiento: tratamientoSeleccionado
							color: carColor //opcion del color una vez marcado //carColor Opcion marcada (Protesis, por extraer, ausente, etc) //colorCara : color de la cara
						};
						
						if ($('input:radio[name=opt]').is(":checked")) {
							//general
							validarTipoMarca(svg,diente,tratamientoIngresado.color);
						}
						if ($('input:radio[name=color]').is(":checked") ) {
							
						
						var lados = [];
						
							if(diente.id == 1.8 || diente.id == 1.7 || diente.id == 1.6 ||  diente.id == 2.8 || diente.id == 2.7 || diente.id == 2.6 
									|| diente.id == 5.5 || diente.id == 5.4 || diente.id == 6.4 || diente.id == 6.5  ){
							
								lados = ['L','V','M','D','O','R','r','z'];
							}else if(diente.id == 4.8 || diente.id == 4.7 || diente.id == 4.6 || diente.id == 3.8 || diente.id == 3.7 || diente.id == 3.6 
									|| diente.id == 8.5 || diente.id == 8.4 || diente.id == 7.4 || diente.id == 7.5 || diente.id == 1.4 || diente.id == 2.4){
								lados = ['L','V','M','D','O','R','r'];
							}else {
								lados = ['L','V','M','D','O','R'];
							}

							//cuando todo esta vacio, ninguna pieza marcada
							if(tratamientosAplicados.length == 0){
								//pintar la pieza
									// verificar si la opcion es por extraer, protesis, perdida, el cual marca a todos
									if(carColor == '398' || carColor == '400' || carColor ==  porextraer){
										me.data('oldFill', me.attr('fill'));
										me.attr('fill', colorCara);
										
//										marcaDoble(svg,diente,carColor);------------------------sacado
										
										// Validaciones de si la cara tiene tratamiento o no, etc...
										//var tratamientoOriginal = {diente: diente,cara: cara,color: carColor};
										tratamientosAplicados.push(tratamientoIngresado);
								
										//aumenta contadores
										cuentaVariables(tratamientoIngresado.diente.id,tratamientoIngresado.cara, tratamientoIngresado.color);
										
										
										for(var i=0; i < lados.length; i++){
											if(lados[i]!=cara){
												caras[lados[i]].attr('fill', colorCara);
												
												//se ingresa las piezas restantes
												var tratamientoRestante = {diente: diente,cara: lados[i],color: carColor };
												tratamientosAplicados.push(tratamientoRestante);
												//aumentar contadores
												cuentaVariables(tratamientoRestante.diente.id,tratamientoRestante.cara, tratamientoRestante.color);
												
											}
										}
										
									}else if(carColor=='395'){

									}else{
										//si se esta pintando solamente 1 cara del diente
											me.data('oldFill', me.attr('fill'));
											me.attr('fill', colorCara);
											// Validaciones de si la cara tiene tratamiento o no, etc...
											tratamientosAplicados.push(tratamientoIngresado);
											
											//aumenta contadores
											cuentaVariables(tratamientoIngresado.diente.id,tratamientoIngresado.cara, tratamientoIngresado.color);
									}
									
							}else{
								//cuando se tiene piezas marcadas
								//INICIO DE LAS DIFERENTES MARCAS DE LAS CARAS 
								var marcasLlenas =0;
								var marcasParciales =0;
								var marcas =0;
								
								//verifica si la pieza ingresada tiene lados marcados
								for(var i=0; i < tratamientosAplicados.length ; i++){
									
									if(tratamientoIngresado.diente.id == tratamientosAplicados[i].diente.id){
										
										if(tratamientosAplicados[i].color == '398' || tratamientosAplicados[i].color == '400' || tratamientosAplicados[i].color == porextraer){
											marcasLlenas++; 
										}else if(tratamientosAplicados[i].color == '395'){
										
										}else{
											marcasParciales++;	
										}
									}else{
										marcas++; //indica que la opcion ingresada no esta presente en los tratamientos aplicados.
									}
								}
								
								//pintar
								//SI SON MARCAS NUEVAS
								if(marcas == tratamientosAplicados.length){
									
									
									// verificar si la opcion ingresada es por extraer, protesis, perdida
									if(tratamientoIngresado.color == '398' || tratamientoIngresado.color == '400' || tratamientoIngresado.color ==  porextraer){
										
										me.data('oldFill', me.attr('fill'));
										me.attr('fill', colorCara);
										
										//para las diferentes opciones nuevo componente 29112016
//										marcaDoble(svg,diente,tratamientoIngresado.color);

										
										// Validaciones de si la cara tiene tratamiento o no, etc...
	//									var tratamientoOriginal = {diente: diente,cara: cara,color: carColor};
										tratamientosAplicados.push(tratamientoIngresado);
								
										//aumenta contadores
										cuentaVariables(tratamientoIngresado.diente.id,tratamientoIngresado.cara, tratamientoIngresado.color);
										
										
										for(var i=0; i < lados.length; i++){
											if(lados[i]!=cara){
												caras[lados[i]].attr('fill', colorCara);
												//se ingresa las piezas restantes
												var tratamientoRestante = {diente: diente,cara: lados[i],color: carColor };
												tratamientosAplicados.push(tratamientoRestante);
												//aumentar contadores
												cuentaVariables(tratamientoRestante.diente.id,tratamientoRestante.cara, tratamientoRestante.color);
												
											}
										}
										
									}else if(tratamientoIngresado.color=='395'){
													
										
									}else{
											me.data('oldFill', me.attr('fill'));
											me.attr('fill', colorCara);
											// Validaciones de si la cara tiene tratamiento o no, etc...
											tratamientosAplicados.push(tratamientoIngresado);
											
											//aumenta contadores
											cuentaVariables(tratamientoIngresado.diente.id,tratamientoIngresado.cara, tratamientoIngresado.color);
									}
									
									
									
									
								}else{//si se quiere marcar una pieza ya marcada con otro color
										//borra la pieza marcada
										if(marcasLlenas == lados.length){ //todas las piezas estan marcadas
											
											//elimino todas
											var con=0;
											for(var y = 0; y < tratamientosAplicados.length ; y++){

												if(tratamientosAplicados[y].diente.id == tratamientoIngresado.diente.id && 
														tratamientosAplicados[y].cara == tratamientoIngresado.cara ){
													//disminuir contadores
													disminuirVariables(tratamientosAplicados[y].diente.id,tratamientosAplicados[y].cara, tratamientosAplicados[y].color);
													tratamientosAplicados.splice(y, 1); //primera cara borrada
													break;
												}		
											}
											
											var contador=0;
											while(lados.length - 1 !=contador){
											//1
											for(var y = 0; y < tratamientosAplicados.length ; y++){
												if(tratamientosAplicados[y].diente.id == tratamientoIngresado.diente.id){
													for(var i=0; i < lados.length; i++){
														if(lados[i]==tratamientosAplicados[y].cara){
															tratamientosAplicados.splice(y, 1); 	
														break;
														}
													}
												}
											}
											contador++;
											}
											
											
											me.data('oldFill', me.attr('fill'));
											me.attr('fill', colorCara);
											
											
											//pinta la pieza con el nuevo color
											if(tratamientoIngresado.color == '398' || tratamientoIngresado.color == '400' || tratamientoIngresado.color == porextraer){
											
												//agregar nuevamente al tratamientosAplicados
												tratamientosAplicados.push(tratamientoIngresado);
												//cuenta Variables
												cuentaVariables(tratamientoIngresado.diente.id,tratamientoIngresado.cara, tratamientoIngresado.color);
												//armo nuevos lados
												var nuevLados = [];
													for(var i = 0; i < lados.length; i++){
														if(lados[i]!=tratamientoIngresado.cara){
															nuevLados.push(lados[i]);
														}
													}
												
													for(var i=0; i < nuevLados.length; i++){
															caras[nuevLados[i]].attr('fill', colorCara);
															//se ingresa las piezas restantes
															var tratamientoRestante = {diente: diente,cara: nuevLados[i],color: carColor};
															tratamientosAplicados.push(tratamientoRestante);
															//cuenta Variables restantes
															cuentaVariables(tratamientoRestante.diente.id,tratamientoRestante.cara, tratamientoRestante.color);
													}
													
											
											}else if(tratamientoIngresado.color == '395'){
												
													for(var i=0; i < lados.length; i++){
														if(lados[i]!=tratamientoIngresado.cara){
															caras[lados[i]].attr('fill', colorCara);
														}
													}
												
												
												
											}else{ //se pinta un lado de un color
												
												//agregar nuevamente al tratamientosAplicados
												tratamientosAplicados.push(tratamientoIngresado);
												//cuenta Variables
												cuentaVariables(tratamientoIngresado.diente.id,tratamientoIngresado.cara, tratamientoIngresado.color);
												
													for(var i=0; i < lados.length; i++){
														if(lados[i]!=tratamientoIngresado.cara){
															caras[lados[i]].attr('fill', 'white');
														}
													}
												
											}

										}else{
										
										
										if (marcasParciales <= lados.length){
											
											if(tratamientoIngresado.color== '398' || tratamientoIngresado.color == '400' || tratamientoIngresado.color ==  porextraer){
										  		var parcial = 0;
												//elimino todas y agrego todas
										  		//evaluarListado(tratamientosAplicados, marcasParciales);
												while(marcasParciales != parcial){
													for(var y = 0; y < tratamientosAplicados.length ; y++){
														if(tratamientosAplicados[y].diente.id == tratamientoIngresado.diente.id){
															//disminuir contadores
															disminuirVariables(tratamientosAplicados[y].diente.id,tratamientosAplicados[y].cara, tratamientosAplicados[y].color);//
															//borrar todas las marcas de la cara
															tratamientosAplicados.splice(y, 1);
															break;
														}
													}
													parcial++;
												}
												
												me.data('oldFill', me.attr('fill'));
												me.attr('fill', colorCara);
												
												//agregar nuevamente al tratamientosAplicados
												tratamientosAplicados.push(tratamientoIngresado);
												//cuenta Variables
												cuentaVariables(tratamientoIngresado.diente.id,tratamientoIngresado.cara, tratamientoIngresado.color);
												
												var nuevLados = [];
												for(var i = 0; i < lados.length; i++){
													if(lados[i]!=tratamientoIngresado.cara){
														nuevLados.push(lados[i]);
													}
												}
											
												for(var i=0; i < nuevLados.length; i++){
														caras[nuevLados[i]].attr('fill', colorCara);
														//se ingresa las piezas restantes
														var tratamientoRestante = {diente: diente,cara: nuevLados[i],color: carColor };
														tratamientosAplicados.push(tratamientoRestante);
														//cuenta Variables restantes
														cuentaVariables(tratamientoRestante.diente.id,tratamientoRestante.cara, tratamientoRestante.color);
												}
												
												
		
											}else{
												//si se pinta la misma cara
												me.data('oldFill', me.attr('fill'));
												me.attr('fill', colorCara);
												
												
												//elimino todas 
										  		var parcial = 0;
												
												while(lados.length != parcial){
													for(var y = 0; y < tratamientosAplicados.length ; y++){
														if(tratamientosAplicados[y].diente.id == tratamientoIngresado.diente.id ){
															if(tratamientosAplicados[y].color == '398' || tratamientosAplicados[y].color == '400' 
																||tratamientosAplicados[y].color == porextraer){
															//disminuir contadores
															disminuirVariables(tratamientosAplicados[y].diente.id,tratamientosAplicados[y].cara, tratamientosAplicados[y].color);//
															//borrar todas las marcas de la cara
															tratamientosAplicados.splice(y, 1);
															break;
															}
														}
													}
													parcial++;
												}
												
												
												var count=0;
												
													//si el que entra es blanco, entonces busco en la lista que tengo y lo saco
													for (var i = 0; i < tratamientosAplicados.length; i++) {
															if(tratamientoIngresado.diente.id == tratamientosAplicados[i].diente.id){
																if(tratamientoIngresado.cara == tratamientosAplicados[i].cara){
																	if(tratamientoIngresado.color == '395'){
																		disminuirVariables(tratamientoIngresado.diente.id,tratamientoIngresado.cara, tratamientoIngresado.color);//aumentar contador
																		tratamientosAplicados.splice(i, 1);
																		break;
																	}else{
																		disminuirVariables(tratamientosAplicados[i].diente.id,tratamientosAplicados[i].cara, tratamientosAplicados[i].color);//
																		tratamientosAplicados.splice(i, 1);
																		tratamientosAplicados.push(tratamientoIngresado);
																		
																		cuentaVariables(tratamientoIngresado.diente.id,tratamientoIngresado.cara, tratamientoIngresado.color);//
																		break;
																	}	
																}else{
																	count++;
																}
															}else{
																count++;
															}
													}
													
												
												 if(count == tratamientosAplicados.length){
													 if(tratamientoIngresado.color == '395'){
															//si es blanco, no se agrega
														}else{ 
														 	tratamientosAplicados.push(tratamientoIngresado);
														 	cuentaVariables(tratamientoIngresado.diente.id,tratamientoIngresado.cara, tratamientoIngresado.color);//
														}
												 }
												
										
											}
										
										
										}
										
								
										}
										
										}
								
										  
										  
							}
							
	
								
								var cadena='';
								for (var i = 0; i < tratamientosAplicados.length; i++) {
									cadena += tratamientosAplicados[i].diente.id + tratamientosAplicados[i].cara+	tratamientosAplicados[i].color+ "|";
								}
								
								var piezasMarcadas='';
								
//								console.debug("Marcas ");
								for (var i = 0; i < arrPiezaInicial.length; i++) {
//									if(!validarMarca(arrColorInicial[i])){
										piezasMarcadas += arrPiezaInicial[i] + arrCaraInicial[i]+	arrColorInicial[i]+ "|";
//									}
								}

								console.debug("piezasMarcadas  >>>>> "+piezasMarcadas )
								$("#vDientes").val(cadena) ;
								$("#vPiezasMarcadas").val(piezasMarcadas) ;
								
								
								self.trigger('tratamientoAplicado.odontograma', tratamiento);
								
					
						}
				}
					
				})
			}

//			DENTRO DE LA ARMADA DE LOS DIENTES			
//			xSVG = svg;
//			
//			 if(sOptMarcaDoble != '' &&
//						sOptMarcaDobleInicio != '' &&
//						sOptMarcaDobleFin != '' ){
//						 var xOptMarcaDoble = sOptMarcaDoble.split(",");
//						 var xOptMarcaDobleInicio = sOptMarcaDobleInicio.split(",");
//						 var xOptMarcaDobleFin	 = sOptMarcaDobleFin.split(",");
//						 
//						 for(var x = 0; x < xOptMarcaDoble.length; x++){
//							 validarTipoMarca(xSVG,dientes[xOptMarcaDobleInicio[x]],xOptMarcaDoble[x]);
//							 validarTipoMarca(xSVG,dientes[xOptMarcaDobleFin[x]],xOptMarcaDoble[x]);
//						 }
//					 }
			
			return element;
		}
		
		var createCara = function(cara) {
				var polygonPoints = calculatePolygon(cara);
				return attachEventsAndData($(svg.polygon(dienteGroup, polygonPoints, defaultPolygon)), cara);
			}

		
			//Creo las cara SVG y las agrego como un diccionario
//		var caras = ['S', 'I', 'D', 'Z', 'C','W','T'];
		var posipieza;
		
		if(diente.id == 1.8 || diente.id == 1.7 || diente.id == 1.6 || diente.id == 1.5 || diente.id == 1.4 || diente.id == 1.3 || diente.id == 1.2 || diente.id == 1.1 || 
		   diente.id == 2.8 || diente.id == 2.7 || diente.id == 2.6 || diente.id == 2.5 || diente.id == 2.4 || diente.id == 2.3 || diente.id == 2.2 || diente.id == 2.1){
			posipieza = -20;
		}else if(diente.id == 5.5 || diente.id == 5.4 || diente.id == 5.3 || diente.id == 5.2 || diente.id == 5.1 ||
		   diente.id == 6.5 || diente.id == 6.4 || diente.id == 6.3 || diente.id == 6.2 || diente.id == 6.1 ){
			posipieza = 30;
		}else if(diente.id == 8.5 || diente.id == 8.4 || diente.id == 8.3 || diente.id == 8.2 || diente.id == 8.1 ||
				   diente.id == 7.5 || diente.id == 7.4 || diente.id == 7.3 || diente.id == 7.2 || diente.id == 7.1 ) {
			posipieza = -4;
		}else if(diente.id == 4.8 || diente.id == 4.7 || diente.id == 4.6 || diente.id == 4.5 || diente.id == 4.4 || diente.id == 4.3 || diente.id == 4.2 || diente.id == 4.1 || 
		   diente.id == 3.8 || diente.id == 3.7 || diente.id == 3.6 || diente.id == 3.5 || diente.id == 3.4 || diente.id == 3.3 || diente.id == 3.2 || diente.id == 3.1){
			posipieza = 45;
		}
		
		var caras ;
		
		if(diente.id == 1.8 || diente.id == 1.7 || diente.id == 1.6 || diente.id == 2.8 || diente.id == 2.7 || diente.id == 2.6
				|| diente.id == 5.5 || diente.id == 5.4 || diente.id == 6.4 || diente.id == 6.5 ){
			caras = ['L','V','M','D','O','R','r','z'];	
		}else{
			caras = ['L','V','M','D','O','R','r'];
		}
	
//		console.debug(caras)
		
		for (var i = caras.length - 1; i >= 0; i--) {
			var cara = caras[i];
			caras[cara] = createCara(cara);
		}

		//Creo el diente completo y lo agrego a las caras
		var caraCompleto = svg.text(dienteGroup, 4.5, posipieza, diente.id.toString(), {
			fill: 'navy',
			stroke: 'navy',
			strokeWidth: 0.1,
			style: 'font-size: 5pt;font-weight:normal;cursor:pointer'
		});
		caraCompleto = attachEventsAndData($(caraCompleto), 'X');

		caras['X'] = caraCompleto;

		//Busco los tratamientos aplicados al diente
		var tratamientosAplicadosAlDiente = arrayFilter(tratamientosAplicados, function(t) {
//			console.debug("tratamientosAplicadosAlDiente "+t.diente.id)
			return t.diente.id == diente.id;
		});

		for (var i = tratamientosAplicadosAlDiente.length - 1; i >= 0; i--) {
			var t = tratamientosAplicadosAlDiente[i];
//			console.debug("===>>> t.diente.id "+t.diente.id + " t.cara "+t.cara + " t.color "+t.color );
			var colorFinal='';
			if(t.color == porextraer){		
				colorFinal = '#f4dde8'; 	// cambiado por rosado
			}else if(t.color == '400'){ //protesis
				colorFinal = '#D3D3D3'; 	// cambiado por gris
			}else if(t.color == '398'){ //perdida
				colorFinal = 'black'; 	// Negro
			}else if(t.color == '397'){	//obturada
				colorFinal = 'blue'; 	// Azul
			}else if(t.color == '396'){	//cariada
				colorFinal = 'red'; 		// Rojo
			}else if(t.color == '399'){	//fracturada
				colorFinal = 'green'; 	// Verde
			}else{
				colorFinal = 'white';
			}
//			console.debug("t.diente.id "+t.diente.id + " t.cara "+t.cara + " opcion "+t.color + " color cara "+colorFinal );
			caras[t.cara].attr('fill', colorFinal);
//			caras[t.cara].attr('fill', "green");
	}
	}

	

	function renderSvg() {
		var svg = self.svg('get').clear();
		var parentGroup = svg.group({
			transform: 'scale(' + settings.scale.toString() + ')'
		});
		for (var i = dientes.length - 1; i >= 0; i--) {
			drawDiente(svg, parentGroup, dientes[i]);
		}
		
		reensamblaOpt(svg);
	}
	
	
	 
	 
	 
	
	//tama?o del cuadro que va a contener todos los dientes defaults.tratamientosAplicados
	var defaults = {
		width: '600px',
		height: '400px',
		scale: scale,//1.5,
		readOnly: false,
		tratamientosAplicados: []
	}

	var settings,
		tratamientoSeleccionado, 
		tratamientosAplicados,
		self;

	var methods = {
		init: function(options) {
			settings = $.extend(defaults, options);
			return this.each(function() {
				//Init the SVG object
				self = $(this);
				self.svg({
					settings: {
						width: settings.width,
						height: settings.height
					}
				});

				tratamientosAplicados = settings.tratamientosAplicados;
				renderSvg();
			});
		},
		setTratamiento: function(tratamiento) {
			tratamientoSeleccionado = tratamiento;
		},
		removeTratamiento: function(tratamiento) {
			tratamientosAplicados = arrayFilter(tratamientosAplicados, function(t) {
				return !(t.cara == tratamiento.cara && t.diente.id == tratamiento.diente.id && t.tratamiento.id == tratamiento.tratamiento.id);
			});
			renderSvg();
		},
		getTratamientosAplicados: function(){
			return tratamientosAplicados;
		}
	}
	
	
	
//	alert("self1 "+self)
	$.fn.odontograma = function(method) {

		// Method calling logic
		if (methods[method]) {
			return methods[method].apply(this, Array.prototype.slice.call(arguments, 1));
		} else if (typeof method === 'object' || !method) {
			return methods.init.apply(this, arguments);
		} else {
			$.error('Method ' + method + ' does not exist on jQuery.odontograma');
		}
	}

	
	
	$('input:radio[name=color]').change(function(  ) {
	 if( $(this).is(":checked") ){ // check if the radio is checked
		
		if($(this).val() == 'Y'){     // por extraer
				carColor = porextraer;
			    colorCara = '#f4dde8'; // Amarillo - cambiado por rosado
		}else if($(this).val() == 'O'){ //protesis
				carColor = '400';
			    colorCara = '#D3D3D3'; // Naranja - cambiado por gris
		}else if($(this).val() == 'D'){ //perdida
				carColor = '398';
			    colorCara = 'black'; // Negro
		}else if($(this).val() == 'B'){//obturada
				carColor = '397';
			    colorCara = 'blue'; // Azul
		}else if($(this).val() == 'R'){//cariada
				carColor = '396';		
			    colorCara = 'red'; // Rojo
		}else if($(this).val() == 'G'){//fracturada
				carColor = '399';
			    colorCara = 'green'; // Verde
		}else{
				carColor = '395';
			    colorCara = 'white'; // Blanco
		}		
			
		$('input:radio[name=opt]').prop('checked', false);	
			
        }
	 
	});
	
	

		$('input:radio[name=opt]').change(function() {
		if ($(this).is(":checked")) { // check if the radio is checked

			carColor = $(this).val();
			colorCara = 'white'; // Amarillo - cambiado por rosado
			//limpiado los checks del color
			$('input:radio[name=color]').prop('checked', false);
		}

	}
		
		
		
		);
	
	
	// luego de crear el odontograma, reensambla el ultimo ontograma generado
	reensamblarOdontograma();
	
	function reensamblarOdontograma(){
	 	
		 
		 if(sPiezaMarcada != '' &&
			sCaraMarcada != '' &&
			sColorMarcada != '' &&
			sPiezaMarcadaInicial != '' &&
			sCaraMarcadaInicial != '' &&
			sColorMarcadaInicial != '' ){

			 var tempPieza = sPiezaMarcada.split(",");
			 var tempCara = sCaraMarcada.split(",");
			 var tempColor = sColorMarcada.split(",");
			 
			 var tempPiezaInicial = sPiezaMarcadaInicial.split(",");
			 var tempCaraInicial = sCaraMarcadaInicial.split(",");
			 var tempColorInicial = sColorMarcadaInicial.split(",");
			 
			 var posi=0; 
			 
				 for(var x = 0; x < tempPieza.length; x++){
					 posi = obtenerPosicion(parseFloat(tempPieza[x]));
					 marcarPiezaOdontograma(dientes[posi],tempCara[x],tempColor[x]);
				 }
			 
		 }
		 
		}
	 
	function reensamblaOpt(svg){
	 //EN REENSAMBLAR
//	 alert("$('#odontograma') " + $('#odontograma'))
//	 var xSVG =  $('#odontograma').svg('get');
//	 var xSVG = SVG.create('svg')
//	 var xSVG = self.svg('get').clear();
//	 var xSVG =  self.svg('get');
//	 alert("hxSVG "+xSVG.height())
//	 alert("wxSVG "+xSVG.weight())
	 
//	 var xSVG = $('#odontograma svg'); 
	 if(sOptMarcaDoble != '' &&
		sOptMarcaDobleInicio != '' &&
		sOptMarcaDobleFin != '' ){
		 var xOptMarcaDoble = sOptMarcaDoble.split(",");
		 var xOptMarcaDobleInicio = sOptMarcaDobleInicio.split(",");
		 var xOptMarcaDobleFin	 = sOptMarcaDobleFin.split(",");
		 
		 for(var x = 0; x < xOptMarcaDoble.length; x++){
			 validarTipoMarca(svg,dientes[xOptMarcaDobleInicio[x]],xOptMarcaDoble[x]);
			 validarTipoMarca(svg,dientes[xOptMarcaDobleFin[x]],xOptMarcaDoble[x]);
		 }
	 }
	 
	 if(sOptMarcaIndividual != '' &&
		sOptPzaIndividual != '' ){
		 
		 var xOptMarcaIndividual = sOptMarcaIndividual.split(",");
		 var xOptPzaIndividual = sOptPzaIndividual.split(",");
		 
			 
			 for(var x = 0; x < xOptMarcaIndividual.length; x++){
				 validarTipoMarca(svg,dientes[xOptPzaIndividual[x]],xOptMarcaIndividual[x]);

			 }
		 }
	 
	 	//setear los valores que llegan del servidor 28032017
//	 	$("#vPiezasIndMark").val(sOptPzaIndividual ) ;
//		$("#vOptIndMark").val(sOptMarcaIndividual) ;
	 	$("#vPiezasIndMark").val(sOptMarcaIndividual) ;
		$("#vOptIndMark").val(sOptPzaIndividual) ;
		$("#vOptExtMark").val(sOptMarcaDoble) ;
		$("#vPiezasIniExtMark").val(sOptMarcaDobleInicio) ;
		$("#vPiezasFinExtMark").val(sOptMarcaDobleFin) ;
		
//		console.debug("vPiezasIndMark >>> "+$("#vPiezasIndMark").val());
//		console.debug("vOptIndMark >>> "+$("#vOptIndMark").val());
//		console.debug("vOptExtMark >>> "+$("#vOptExtMark").val());
//		console.debug("vPiezasIniExtMark >>> "+$("#vPiezasIniExtMark").val());
//		console.debug("vPiezasFinExtMark >>> "+$("#vPiezasFinExtMark").val());
	}
	
	function validarTipoMarca(svg,diente,opt){
//		console.debug("opt >>> "+opt)
		if(opt == buena){
			borrarFigura(diente,opt);
		}else{
			if(validarMarca(opt)){
				marcaDoble(svg,diente,opt);
			}else{
				marcaIndividual(svg,diente,opt);
			}
		}
	}
	

	
	
	function validarMarca(opt){
		if(opt == aparOrtFijo || opt == aparOrtFijoMal || 
		   opt == aparOrtRem  || opt == aparOrtRemMal || 
		   opt == edentuloTotal || opt == fusion ||  
		   opt == transposicion || opt == protFija || 
		   opt == protRemovible || opt == protRemovibleMal ||
		   opt == protTotal || opt== protTotalMal ||
		   opt == protFija || opt == protFijaMal ||
		   opt == diastema || opt == supernumerario){
			return true;
		}
		return false;
	}
	
	function marcaIndividual(svg,diente,opt){
		borrarFigura(diente,opt);
		crearFiguraIndividual(svg,diente,opt,obtenerColor(opt));
//		console.debug("agregar marcas individuales")
//		console.debug("agregar marcas individuales")
		//se agrega a los arreglos las marcas individuales
		agregarMarcasIndividuales(obtenerPosicion(diente.id),opt)
//		console.debug("agregar marcas individuales ok")
	}
	
	function marcaDoble(svg,diente,opt){
//		console.debug("marca doble")
		
		arrRangoTempo.push(diente);
		
			if(arrRangoTempo.length == 2){
				if(arrRangoTempo[0] != arrRangoTempo[1]){
					if(isCuadranteSuperior(arrRangoTempo[0]) && isCuadranteSuperior(arrRangoTempo[1])){
						calcularRango(svg,opt)
					}else if(isCuadranteInferior(arrRangoTempo[0]) && isCuadranteInferior(arrRangoTempo[1])){
						calcularRango(svg,opt)
					}else{
						alert("Las 2 piezas marcadas, deben de encontrarse en la misma fila (1.8 al 2.8 ó 4.8 al 3.8)")
						arrRangoTempo = []
					}
				}else{
					alert("Se ha marcado la misma pieza 2 veces ")
					arrRangoTempo = []
				}
		
			}
	}
	

	
	function calcularRango(svg, opt){
//		console.debug('calcularRango opt '+opt)
		var flag = false;
		//dibujar linea continua
		var tempo = 0;
		
		var ini = obtenerPosicion(arrRangoTempo[0].id);
		var fin = obtenerPosicion(arrRangoTempo[1].id);
		
		if(ini > fin){
			tempo = fin;
			fin = ini;
			ini = tempo;
		}
		
		//borrar antes
		borrarFigurasEnRangos(ini,fin,opt) //05122016
//		if(!verificarMarca(ini,fin)){ se esta quitando validacion de rangos 01/12/2016
//		alert("marcas no se encuentran en rango")
			if(opt== aparOrtFijo || opt == aparOrtFijoMal || opt== protFija || opt == protFijaMal ){
				figuraConExtremos(svg,ini,fin,opt);
				
			}else if(opt==aparOrtRem || opt == aparOrtRemMal || opt== protRemovible || opt== protRemovibleMal || opt== protTotal || opt== protTotalMal || opt==edentuloTotal){
				figuraSinExtremos(svg,ini,fin,opt);
				
			}else if(opt == fusion  || opt== transposicion || opt == supernumerario){
				figuraJunta(svg,ini,fin,opt);
			
			}else if(opt == diastema){
				
				if(ini == 7 && fin ==8 ){
					figuraJunta(svg,ini,fin,opt);
					
				}else if(ini == 43 && fin ==44 ){
					figuraJunta(svg,ini,fin,opt);
				}else{
					flag = true;
					alert("La diastema debe estar entre las piezas 1.1 y 2.1 ó 3.1 y 4.1")
				}
			}
//		}
		borrarTemporal();
		arrTempo2 = [];
		
		if(!flag){
			//se agrega a los arreglos las marcas con extremos
			agregarMarcasExtremos(ini,fin,opt);
		}
	}
	
	function figuraJunta(svg,ini,fin,opt){
		
		if(ini+1 == fin){

			for(var x = ini ; x <= fin; x ++){
				
				if(x == ini){
					 //izquierdo
					crearExtremos(svg,dientes[x],0,opt,obtenerColor(opt));
				
				}else if(x == fin){
					//derecho
					crearExtremos(svg,dientes[x],1,opt,obtenerColor(opt));
			
				}
				
			}
			
 
				
		}else{
			alert("figuras no estan juntas")
		}
	}
	
	function figuraSinExtremos(svg,ini,fin,opt){
		for(var x = ini ; x <= fin; x ++){
			crearFiguraSinExtremos(svg,dientes[x],opt,obtenerColor(opt)); 
		}	
	}
	
	function figuraConExtremos(svg,ini,fin,opt){
		for(var x = ini ; x <= fin; x ++){
		
			if(x == ini){
				crearExtremos(svg,dientes[x],0,opt,obtenerColor(opt)); //izquierdo
			
			}else if(x == fin){
				crearExtremos(svg,dientes[x],1,opt,obtenerColor(opt));//derecho
		
			}else{
				crearLineaEntreExtremos(svg,dientes[x],obtenerColor(opt));

			}
		}	
	}
	
	
	function borrarTemporal(){
		arrRangoTempo = []
	}
	

	function obtenerColor(opt){
      var color = 'blue';
		
		if(opt == aparOrtFijoMal || 
			opt ==  aparOrtRemMal ||
			opt == cariada ||
			opt == coronaTemporal ||
			opt == fractura ||
			opt == munonMal ||
			opt == protFijaMal ||
			opt == protRemovibleMal ||
			opt == protTotalMal ||
			opt == remanente ||
			opt == restauracionTemporal || 
			opt == munonMal){
			color = 'red';
		}
		
	return color;
		
	}
	
	
	function marcarPiezaOdontograma(diente,cara,carColor){
		 
		 var tratamiento = {
					diente: diente,
					cara: cara,
					color: carColor
				};
		 
		 
		 var conta = 0;		
			
			
			if(defaults.tratamientosAplicados.length == 0){
				if(tratamiento.color == '395'){
					//si es blanco, no se agrega
				}else{ 
					defaults.tratamientosAplicados.push(tratamiento);
					cuentaVariables(tratamiento.diente.id,tratamiento.cara, tratamiento.color);//aumentar contador
				}
			}else{
				//si el que entra es blanco, entonces busco en la lista que tengo y lo saco
				for (var i = 0; i < defaults.tratamientosAplicados.length; i++) {
						if(tratamiento.diente.id == defaults.tratamientosAplicados[i].diente.id){
							if(tratamiento.cara == defaults.tratamientosAplicados[i].cara){
								if(tratamiento.color == '395'){
									disminuirVariables(tratamiento.diente.id,tratamiento.cara, tratamiento.color);//aumentar contador
									defaults.tratamientosAplicados.splice(i, 1);
									break;
								}else{
									disminuirVariables(defaults.tratamientosAplicados[i].diente.id,defaults.tratamientosAplicados[i].cara, defaults.tratamientosAplicados[i].color);//
									defaults.tratamientosAplicados.splice(i, 1);
									defaults.tratamientosAplicados.push(tratamiento);
									
									cuentaVariables(tratamiento.diente.id,tratamiento.cara, tratamiento.color);//
									break;
								}	
							}else{
							conta++;
							}
						}else{
							conta++;
						}
				}
				
			
			 if(conta == defaults.tratamientosAplicados.length){
				 if(tratamiento.color == '395'){
						//si es blanco, no se agrega
					}else{ 
						defaults.tratamientosAplicados.push(tratamiento);
					 	cuentaVariables(tratamiento.diente.id,tratamiento.cara, tratamiento.color);
					}
			 }
			}
			
			
			var cadena='';
			for (var i = 0; i < defaults.tratamientosAplicados.length; i++) {
				cadena += defaults.tratamientosAplicados[i].diente.id + defaults.tratamientosAplicados[i].cara+	defaults.tratamientosAplicados[i].color+ "|";
			}
			
			var piezasMarcadas='';
			
			for (var i = 0; i < arrPiezaInicial.length; i++) {
				piezasMarcadas += arrPiezaInicial[i] + arrCaraInicial[i]+	arrColorInicial[i]+ "|";
			}
			
			
				
			
			
//			console.debug("tam actual "+cadena);
//			console.debug("tam piezas marcardas "+piezasMarcadas);
			$("#vDientes").val(cadena) ;
			$("#vPiezasMarcadas").val(piezasMarcadas) ;
//			self.trigger('tratamientoAplicado.odontograma', tratamiento);
	 }	
	
	
	function disminuirVariables(pieza, cara, color){
		var colorBorrar = '';
//		console.debug("Iniciales arrPieza :"+arrPieza);
//		console.debug("Iniciales arrCara :"+arrCara);
//		console.debug("Iniciales arrColor :"+arrColor);
//		for(var x=0; x < arrPieza.length; x++){
//		console.debug("marcada "+arrPieza[x]+arrCara[x]+arrColor[x])
//		}
	
		
		var contaExcluyente=0;
		
		for(var i=0; i<arrPieza.length ; i++){
			if(pieza == arrPieza[i]){
				if(cara == arrCara[i]){
					if(color == '395'){//color que ingresa es blanco
						colorBorrar=arrColor[i]; //se guarda el color de la lista
						//se borra						
						arrPieza.splice(i, 1);
						arrCara.splice(i, 1);
						arrColor.splice(i, 1);
						//verificar si es pieza inicial
						
						break;
					}else if(color == '398' || color == '400' || color == porextraer){
						contaExcluyente++;
						break;
					}else{//si es de otro color entoncs se borra y se salva el color de ingreso						
						arrPieza.splice(i, 1);
						arrCara.splice(i, 1);
						arrColor.splice(i, 1);
						
						colorBorrar=color;
						break;
					}
					
				}else{
					
				}
				
			}else{
				
			}
			
		}
		
		
//		console.debug("Excluyente :"+contaExcluyente);
//		console.debug("Luego arrPieza :"+arrPieza);
//		console.debug("Luego arrCara :"+arrCara);
//		console.debug("Luego arrColor :"+arrColor);
//		var lados = ['L','V','M','D','O','R','r'];
		var lados = [];
		
		if(pieza == 1.8 || pieza == 1.7 || pieza == 1.6 ||  pieza == 2.8 || pieza == 2.7 || pieza == 2.6 
				|| pieza == 5.5 || pieza == 5.4 || pieza == 6.4 || pieza == 6.5  ){
			lados = ['L','V','M','D','O','R','r','z'];
		}else if(pieza == 4.8 || pieza == 4.7 || pieza == 4.6 || pieza == 3.8 || pieza == 3.7 || pieza == 3.6 
				|| pieza == 8.5 || pieza == 8.4 || pieza == 7.4 || pieza == 7.5 || pieza == 1.4 || pieza == 2.4){
			lados = ['L','V','M','D','O','R','r'];
		}else {
			lados = ['L','V','M','D','O','R'];
		}

		
		if(contaExcluyente==1){
			
			colorBorrar=color;
			var counter = 0;
			while(lados.length != counter){
				for(var i=0; i < arrPieza.length; i++){
					if(arrPieza[i] == pieza && arrColor[i] == color){
								arrPieza.splice(i, 1);
								arrCara.splice(i, 1);
								arrColor.splice(i, 1);
//								console.debug(counter);
//								console.debug("Luego arrPieza :"+arrPieza);
//								console.debug("Luego arrCara :"+arrCara);
//								console.debug("Luego arrColor :"+arrColor);
								break;
					}
				}
				counter++;
			}
			

				for(var i = 0; i < arrPiezaInicial.length ; i++){
					if(arrPiezaInicial[i]==pieza){
						arrPiezaInicial.splice(i, 1);
						arrCaraInicial.splice(i, 1);
						arrColorInicial.splice(i, 1);
						buscarNuevoInicial(pieza,cara,colorBorrar);
						break;
						}
					}

		}
		/////////////////////poner else
		else{
//		console.debug("Despues arrPieza :"+arrPieza);
//		console.debug("Despues arrCara :"+arrCara);
//		console.debug("Despues arrColor :"+arrColor);
		
		
		var conta =0;
		
		//verificar que no se encuentre en el listado de todas las piezas
		for(var i=0; i<arrPieza.length ; i++){
			if(arrPieza[i]==pieza){
				if(arrCara[i]==cara){
					if(arrColor[i]==colorBorrar){
						conta++;
					}
				
				}
			}
		}
		

		if(conta==0){
			//verificar si se borro la pieza inicial
			for(var i = 0; i < arrPiezaInicial.length ; i++){
				if(arrPiezaInicial[i]==pieza){
					if(arrCaraInicial[i]==cara){
						if(arrColorInicial[i]==colorBorrar){ //cuando son del mismo color
							//borrar la pieza inicial si se borro en las piezas marcadas
							arrPiezaInicial.splice(i, 1);
							arrCaraInicial.splice(i, 1);
							arrColorInicial.splice(i, 1);
							
							buscarNuevoInicial(pieza,cara,colorBorrar);
							//buscar nueva pieza inicial
							break;
						}else{

						}
					}else{

					}
				}
			}
			
		}else{
			//es porque es otra cara
		}
		
		}

		
	}
	
	function buscarNuevoInicial(pieza,cara,color){
		var conta = 0;
		for(var i=0; i<arrPieza.length ; i++){
			if(pieza == arrPieza[i]){ //existe pieza todavia marcada
				conta++;
				//asigna un valor que ya hay como precedente
				arrPiezaInicial.push(arrPieza[i]);
				arrCaraInicial.push(arrCara[i]);
				arrColorInicial.push(arrColor[i]);
				//actualizar contadores
				//disminuir contadoores
				disminuirContadores(pieza,cara,color);
				//aumentar
				cuentaVariables(arrPieza[i],arrCara[i], arrColor[i]);
				break;
			}
		}
		
		if(conta==0){
			disminuirContadores(pieza,cara,color);
		}
		
	}
	

	function evaluarListado(tratamientosGlobal, n){
		
		if(n > 0){
			for(var y = 0; y < tratamientosGlobal.length ; y++){
				if(tratamientosGlobal[y].diente.id == tratamientoIngresado.diente.id){
					//disminuir contadores
					disminuirVariables(tratamientosGlobal[y].diente.id,tratamientosGlobal[y].cara, tratamientosGlobal[y].color);//
					//borrar todas las marcas de la cara
					tratamientosGlobal.splice(y, 1);
					break;
				}
			}
			evaluarListado(tratamientosGlobal, n-1);
		
		}
	}
	


	function aparOrt11Sup(svg,g3){
		svg.polyline(g3,[[0,-35], [12,-45], [22.5,-35] ]);
	}

	function aparOrt21Sup(svg,g3){
		svg.polyline(g3,[[-2.5,-35], [8,-45], [20,-35] ]);
	}

	function apartOrtComunSup(svg,g3){
		svg.polyline(g3,[[0,-35], [10,-45], [20,-35] ]);
	}

	function aparOrt41Inf(svg,g3){
		svg.polyline(g3,[[0,55], [12,65], [22.5,55] ]);
	}
	function aparOrt31Inf(svg,g3){
		svg.polyline(g3,[[-2.5,55], [8,65], [20,55] ]);
	}
	function apartOrtComunInf(svg,g3){
		svg.polyline(g3,[[0,55], [10,65], [20,55] ]);
	}

	//para protesis removible
	function protRem11Sup(svg,g3){
		svg.line(g3, 0, -35, 22.5, -35);
		svg.line(g3, 0, -40, 22.5, -40);
	}

	function protRem21Sup(svg,g3){
		svg.line(g3, -2.5, -35, 20, -35);
		svg.line(g3, -2.5, -40, 20, -40);
	}

	function protRemComunSup(svg,g3){
		svg.line(g3, 0, -35, 20, -35);
		svg.line(g3, 0, -40, 20, -40);
	}

	function protRem41Inf(svg,g3){
		svg.line(g3, 0, 55, 22.5, 55);
		svg.line(g3, 0, 60, 22.5, 60);
	}
	function protRem31Inf(svg,g3){
		svg.line(g3, -2.5, 55, 20, 55);
		svg.line(g3, -2.5, 60, 20, 60);
	}
	function protRemComunInf(svg,g3){
		svg.line(g3, 0, 55, 20, 55);//Horizontal inferior
		svg.line(g3, 0, 60, 20, 60);
	}

	//protesis total
	function protTot11Sup(svg,g3){
		svg.line(g3, 0, 8, 22.5, 8);
		svg.line(g3, 0, 12, 22.5, 12);
	}

	function protTot21Sup(svg,g3){
		svg.line(g3, -2.5, 8, 20, 8);
		svg.line(g3, -2.5, 12, 20, 12);
	}

	function protTotComunSup(svg,g3){
		svg.line(g3, 0, 8, 20, 8);
		svg.line(g3, 0, 12, 20, 12);
	}

	function protTot41Inf(svg,g3){
		svg.line(g3, 0, 8, 22.5, 8);
		svg.line(g3, 0, 12, 22.5, 12);
	}
	function protTot31Inf(svg,g3){
		svg.line(g3, -2.5, 8, 20, 8);
		svg.line(g3, -2.5, 12, 20, 12);
	}
	function protTotComunInf(svg,g3){
		svg.line(g3, 0, 8, 20, 8);//Horizontal inferior
		svg.line(g3, 0, 12, 20, 12);
	}

	function edentuloTotComun(svg,g3){
		svg.line(g3, 0, 10, 20, 10);
	}

	function edentuloTotIzq(svg,g3){
		svg.line(g3, 0, 10, 22.5, 10);
	}

	function edentuloTotDer(svg,g3){
		svg.line(g3, -2.5, 10, 20, 10);
	}


	function crearFiguraSinExtremos(svg,diente,opt,color){
			var g = svg.group({transform: 'scale('+scale+')',id: diente.id});
			var g2 = svg.group(g, {transform: 'translate('+diente.x+','+diente.y+')'}); 
			var g3 = svg.group(g2, {fill: 'none', stroke: color, strokeWidth: 1, style: 'font-size: 6pt;font-weight:normal'});
					

		switch (diente.id) {
		case 1.1:
			if (opt == aparOrtRem || opt == aparOrtRemMal) {
				aparOrt11Sup(svg, g3);
			} else if (opt == protRemovible || opt == protRemovibleMal) {
				protRem11Sup(svg, g3);
			} else if (opt == protTotal || opt == protTotalMal) {
				protTot11Sup(svg, g3);
			} else if (opt == edentuloTotal) {
				edentuloTotIzq(svg, g3);
			}

			break;
		case 2.1:

			if (opt == aparOrtRem || opt == aparOrtRemMal) {
				aparOrt21Sup(svg, g3);
			} else if (opt == protRemovible || opt == protRemovibleMal) {
				protRem21Sup(svg, g3);
			} else if (opt == protTotal || opt == protTotalMal) {
				protTot21Sup(svg, g3);
			} else if (opt == edentuloTotal) {
				edentuloTotDer(svg, g3);
			}

			break;

		case 4.1:
			if (opt == aparOrtRem || opt == aparOrtRemMal) {
				aparOrt41Inf(svg, g3);
			} else if (opt == protRemovible || opt == protRemovibleMal) {
				protRem41Inf(svg, g3);
			} else if (opt == protTotal || opt == protTotalMal) {
				protTot41Inf(svg, g3);
			} else if (opt == edentuloTotal) {
				edentuloTotIzq(svg, g3);
			}

			break;

		case 3.1:

			if (opt == aparOrtRem || opt == aparOrtRemMal) {
				aparOrt31Inf(svg, g3);
			} else if (opt == protRemovible || opt == protRemovibleMal) {
				protRem31Inf(svg, g3);
			} else if (opt == protTotal || opt == protTotalMal) {
				protTot31Inf(svg, g3);
			} else if (opt == edentuloTotal) {
				edentuloTotDer(svg, g3);
			}

			break;

		default:
			if (isCuadranteSuperior(diente)) {
				if (opt == aparOrtRem || opt == aparOrtRemMal) {
					apartOrtComunSup(svg, g3);
				} else if (opt == protRemovible || opt == protRemovibleMal) {
					protRemComunSup(svg, g3);
				} else if (opt == protTotal || opt == protTotalMal) {
					protTotComunSup(svg, g3);
				} else if (opt == edentuloTotal) {
					edentuloTotComun(svg, g3);
				}

			} else if (isCuadranteInferior(diente)) {

				if (opt == aparOrtRem || opt == aparOrtRemMal) {
					apartOrtComunInf(svg, g3);
				} else if (opt == protRemovible || opt == protRemovibleMal) {
					protRemComunInf(svg, g3);
				} else if (opt == protTotal || opt == protTotalMal) {
					protTotComunInf(svg, g3);
				} else if (opt == edentuloTotal) {
					edentuloTotComun(svg, g3);
				}
			}
			break;
		}	

			
	}


	function crearLineaEntreExtremos(svg,diente,color){
		var g = svg.group({transform: 'scale('+scale+')',id: diente.id});
		var g2 = svg.group(g, {transform: 'translate('+diente.x+','+diente.y+')'}); 
		var g3 = svg.group(g2, {fill: 'none', stroke: color, strokeWidth: 1, style: 'font-size: 6pt;font-weight:normal'});
		
		switch(diente.id){	
		case 1.1:
			svg.line(g3, 0, -35, 22.5, -35);
			break;
		
		case 2.1:
			svg.line(g3, -2.5, -35, 20, -35);
			break;	
		
		case 3.1:
			svg.line(g3, -2.5, 55, 20, 55);
			break;
		
		case 4.1:
			svg.line(g3, 0, 55, 22.5, 55);
			break;
		default:
			if (isCuadranteSuperior(diente)) {
				svg.line(g3, 0, -35, 20, -35);
			} else if (isCuadranteInferior(diente)) {
				svg.line(g3, 0, 55, 20, 55);
			}
			break;
		}

		
	}

	function aparOrtSup(svg,diente, lado,g3){

		svg.polygon(g3,[[5,-40], [5,-30], [15,-30], [15,-40]]); //vertical superior
		svg.line(g3, 10, -33, 10, -37);				//vertical superior
		svg.line(g3, 13, -35, 7, -35);				//Horizontal superior


		if(lado == lad_izquierdo){
			if(diente.id == 1.1){
				svg.line(g3, 15, -35, 22.5, -35);				
			}else{
				svg.line(g3, 15, -35, 20, -35);				//Horizontal superior inicial coninua izquierdo
			}
		}else{
			if(diente.id == 2.1){
				svg.line(g3, 5, -35, -2.5, -35);				
			}else{
				svg.line(g3, 5, -35, 0, -35);				//Horizontal superior inicial coninua derecho
			}
			
		}
		
		
//		switch(diente.id){	
//		case 1.1:
//			svg.line(g3, 15, -35, 22.5, -35);
//			break;
	//	
//		case 2.1:
//			svg.line(g3, 5, -35, -2.5, -35);
//			break;	
	//	
//		default:
//			if(lado == lad_izquierdo){
//				svg.line(g3, 15, -35, 20, -35);
//			} else {
//				svg.line(g3, 5, -35, 0, -35);
//			}
//			break;
//		}
		
	}


	function aparOrtInf(svg,diente, lado,g3){

		svg.polygon(g3,[[5,60], [5,50], [15,50], [15,60]]); //vertical inferior
		svg.line(g3, 10, 53, 10, 57);				//vertical inferior
		svg.line(g3, 13, 55, 7, 55);				//Horizontal inferior


		if(lado == lad_izquierdo){

			if(diente.id == 4.1){
				svg.line(g3, 15, 55, 22.5, 55);				
			}else{
				svg.line(g3, 15, 55, 20, 55);				//Horizontal inferior inicial continua izquierdo
			}
			
		}else{

			if(diente.id == 3.1){
				svg.line(g3, 5, 55, -2.5, 55);				
			}else{
				svg.line(g3, 5, 55, 0, 55);				//Horizontal inferior inicial continua derecho
			}
		}
		
//		switch(diente.id){	
//		case 4.1:
//			svg.line(g3, 15, 55, 22.5, 55);
//			break;
	//	
//		case 3.1:
//			svg.line(g3, 5, 55, -2.5, 55);
//			break;	
	//	
//		default:
//			if(lado == lad_izquierdo){
//				svg.line(g3, 15, 55, 20, 55);
//			} else {
//				svg.line(g3, 5, 55, 0, 55);	
//			}
//			break;
//		}
		
		
	}


	function protFijaSup(svg,diente, lado,g3){

		svg.line(g3, 10, -30, 10, -35);
		
		if (lado == lad_izquierdo) {
			
			if (diente.id == 1.1) {
				svg.line(g3, 10, -35, 22.5, -35);
				
			} else {
				svg.line(g3, 10, -35, 20, -35); // Horizontal superior
												// inicial coninua izquierdo
			}
		} else {

			if (diente.id == 2.1) {
				svg.line(g3, 10, -35, -2.5, -35);
				
			} else {
				svg.line(g3, 10, -35, 0, -35); // Horizontal superior
												// inicial coninua derecho
			}
		}

//		switch(diente.id){	
//		case 1.1:
//			svg.line(g3, 10, -35, 22.5, -35);
//			break;
	//	
//		case 2.1:
//			svg.line(g3, 10, -35, -2.5, -35);
//			break;	
	//	
//		default:
//			if(lado == lad_izquierdo){
//				svg.line(g3, 10, -35, 20, -35);
//			} else {
//				svg.line(g3, 10, -35, 0, -35);
//			}
//			break;
//		}

	}

	function protFijaInf(svg,diente, lado,g3){

		svg.line(g3, 10, 50, 10, 55);

		if (lado == lad_izquierdo) {

			if (diente.id == 4.1) {
				svg.line(g3, 10, 55, 22.5, 55);
			} else {
				svg.line(g3, 10, 55, 20, 55); 
			}

		} else {

			if (diente.id == 3.1) {
				svg.line(g3, 10, 55, -2.5, 55);
			} else {
				svg.line(g3, 10, 55, 0, 55); 
			}
		}

		

//		switch(diente.id){	
//		case 4.1:
//			svg.line(g3, 10, 55, 22.5, 55);
//			break;
	//	
//		case 3.1:
//			svg.line(g3, 10, 55, -2.5, 55);
//			break;	
	//	
//		default:
//			if(lado == lad_izquierdo){
//				svg.line(g3, 10, 55, 20, 55);
//			} else {
//				svg.line(g3, 10, 55, 0, 55);
//			}
//			break;
//		}

	}

	function fusionSup(svg,diente,lado,g3){
		if (lado == lad_izquierdo) {
//			console.debug("entro a lado izquierdo fusion")
			if (diente.id == 1.1) {
				svg.ellipse(g3, 13,-25 , 11, 8);
				
			} else {
				svg.ellipse(g3, 12.5,-25 , 11, 8); 
			}
		} else {
//			console.debug("entro a lado izquierdo fusion")
			if (diente.id == 2.1) {
				svg.ellipse(g3, 5,-25 , 11, 8);
				
			} else {
				svg.ellipse(g3, 7.5,-25 , 11, 8);
			}
		}
		
	}

	function fusionInf(svg,diente,lado,g3){
		if (lado == lad_izquierdo) {
			
			if (diente.id == 4.1) {
				svg.ellipse(g3, 13,43 , 11, 8);
				
			} else {
				svg.ellipse(g3, 12.5,43 , 11, 8); 
			}
		} else {

			if (diente.id == 3.1) {
				svg.ellipse(g3, 5,43 , 11, 8);
				
			} else {
				svg.ellipse(g3, 7.5,43 , 11, 8);
			}
		}
		
		
		
	}



	function crearExtremos(svg,diente,lado,opt,color){
//		console.debug("entro CON OPCION "+opt)
		
		var g = svg.group({transform: 'scale('+scale+')',id: diente.id});
		var g2 = svg.group(g, { transform: 'translate('+diente.x+','+diente.y+')'}); 
		var g3 = svg.group(g2, {fill: 'none', stroke: color, strokeWidth: 1, style: 'font-size: 6pt;font-weight:normal'});

		
		if(isCuadranteSuperior(diente)){
			
			switch (opt) {
			case aparOrtFijo:
				aparOrtSup(svg,diente, lado,g3);
				break;

			case aparOrtFijoMal:
				aparOrtSup(svg,diente, lado,g3);
			
				break;
				
			case protFija:
				protFijaSup(svg,diente, lado,g3);
			
				break;

			case protFijaMal:
				protFijaSup(svg,diente, lado,g3);
				break;
			
			case fusion:
				fusionSup(svg,diente,lado,g3);
					
				
				break;
				
			case diastema:

				var path = svg.createPath();
				
				if (diente.id == 1.1) {
						svg.path(g3, path.move(20,0).curveC(22.5,5 , 22.5,15 ,  20,20));//curva derecha
					
				} else if (diente.id == 2.1) {
						svg.path(g3, path.move(0,0).curveC(-2.5,5 , -2.5,15 ,  0,20));

				}
					
				
				break;
		
			case transposicion:
				var path = svg.createPath();
				
				if (lado == lad_izquierdo) {
						svg.path(g3, path.move(0,-30).curveC(7.5,-40 , 21.5,-40 ,  30,-30));
						svg.polygon(g3,[[27,-30], [30,-30], [29,-34]]);
					
				} else {

						svg.path(g3, path.move(20,-30).curveC(12.5,-40 , -2.5,-40 ,  -10,-30));
						svg.polygon(g3,[[-7,-30], [-10,-30], [-10,-34]]);

				}
				
				break;
				
			case supernumerario:
				
				if (lado == lad_izquierdo) {
					if (diente.id == 1.1) {
						svg.circle(g3,22.5,-30,5.5); 
						svg.text(g3, 21,-28, 'S', {fontSize: 6});
					} else {
						svg.circle(g3,20,-30,5); //corona temporal
						svg.text(g3, 18.5,-28, 'S',{fontSize: 6}); 
					}
				
				}
				break;
				
			default:
				break;
			}
			
					
		}else if(isCuadranteInferior(diente)){
			
			switch (opt) {
			case aparOrtFijo:
				aparOrtInf(svg,diente, lado,g3);
				break;

			case aparOrtFijoMal:
				aparOrtInf(svg,diente, lado,g3);
				break;

				
			case protFija:
				protFijaInf(svg,diente, lado,g3);
				break;

			case protFijaMal:
				protFijaInf(svg,diente, lado,g3);
				
				break;	
				
			case fusion:
				fusionInf(svg,diente,lado,g3);
					

				break;
				
			case diastema:
				var path = svg.createPath();

					if (diente.id == 4.1) {
						svg.path(g3, path.move(20,0).curveC(22.5,5 , 22.5,15 ,  20,20));

					}else if (diente.id == 3.1) {
						svg.path(g3, path.move(0,0).curveC(-2.5,5 , -2.5,15 ,  0,20));

					}

					break;
					
			case transposicion:
				var path = svg.createPath();
				
				if (lado == lad_izquierdo) {
						svg.path(g3, path.move(0,50).curveC(7.5,60 , 21.5,60 ,  30,50));
						svg.polygon(g3,[[27,50], [30,50], [29,54]]);
					
				} else {

						svg.path(g3, path.move(20,50).curveC(12.5,60 , -2.5,60 ,  -10,50));
						svg.polygon(g3,[[-7,50], [-10,50], [-10,54]]);

				}

				break;
				
			case supernumerario:

				
				if (lado == lad_izquierdo) {
					if (diente.id == 4.1) {
						svg.circle(g3,22.5,50,5.5); 
						svg.text(g3, 21,52, 'S', {fontSize: 6});
					} else {
						svg.circle(g3,20,50,5); //corona temporal
						svg.text(g3, 18.5,52, 'S',{fontSize: 6}); 
					}
				
				}
				
				break;
				
			default:
				break;
			}


		}
		
	}



	function isCuadranteSuperior(diente){
		if(diente.id == 1.8 || diente.id == 1.7 || diente.id == 1.6 || diente.id == 1.5 || diente.id == 1.4 || diente.id == 1.3 || diente.id == 1.2 || diente.id == 1.1 || 
				   diente.id == 2.8 || diente.id == 2.7 || diente.id == 2.6 || diente.id == 2.5 || diente.id == 2.4 || diente.id == 2.3 || diente.id == 2.2 || diente.id == 2.1){
			return true;
		}
		
		return false;
	}


	function isCuadranteInferior(diente){
		if(diente.id == 4.8 || diente.id == 4.7 || diente.id == 4.6 || diente.id == 4.5 || diente.id == 4.4 || diente.id == 4.3 || diente.id == 4.2 || diente.id == 4.1 || 
				   diente.id == 3.8 || diente.id == 3.7 || diente.id == 3.6 || diente.id == 3.5 || diente.id == 3.4 || diente.id == 3.3 || diente.id == 3.2 || diente.id == 3.1){
			return true;
		}
		return false;
	}

	function isCuadranteSuperiorTotal(diente){
		if(diente.id == 1.8 || diente.id == 1.7 || diente.id == 1.6 || diente.id == 1.5 || diente.id == 1.4 || diente.id == 1.3 || diente.id == 1.2 || diente.id == 1.1 || 
		   diente.id == 2.8 || diente.id == 2.7 || diente.id == 2.6 || diente.id == 2.5 || diente.id == 2.4 || diente.id == 2.3 || diente.id == 2.2 || diente.id == 2.1 ||
		   diente.id == 5.5 || diente.id == 5.4 || diente.id == 5.3 || diente.id == 5.2 || diente.id == 5.1 ||
		   diente.id == 6.1 || diente.id == 6.2 || diente.id == 6.3 || diente.id == 6.4 || diente.id == 6.5 ){
			return true;
		}
		
		return false;
	}


	function isCuadranteInferiorTotal(diente){
		if(diente.id == 4.8 || diente.id == 4.7 || diente.id == 4.6 || diente.id == 4.5 || diente.id == 4.4 || diente.id == 4.3 || diente.id == 4.2 || diente.id == 4.1 || 
		   diente.id == 3.8 || diente.id == 3.7 || diente.id == 3.6 || diente.id == 3.5 || diente.id == 3.4 || diente.id == 3.3 || diente.id == 3.2 || diente.id == 3.1 || 
		   diente.id == 8.5 || diente.id == 8.4 || diente.id == 8.3 || diente.id == 8.2 || diente.id == 8.1 ||
		   diente.id == 7.5 || diente.id == 7.4 || diente.id == 7.3 || diente.id == 7.2 || diente.id == 7.1 ){
			return true;
		}
		return false;
	}

	function pernoMunon(svg,diente,g3){
//		console.debug("entro a pintar munon")
		svg.polygon(g3,[[5,5], [15,5], [15,15], [5,15]]);
//		console.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> antes de entrar a muñon")
	    if(isCuadranteSuperiorTotal(diente)){
	    	svg.line(g3, 10, 5, 10, -15);  			
//	    	console.debug("paso primer cuadrante munon")
		}else if(isCuadranteInferiorTotal(diente)){
			svg.line(g3, 10, 15, 10, 35);  			//PERNO MUÑON
//			console.debug("paso ultimo cuadrante munon")
		}
	}

	function crearFiguraIndividual(svg,diente,opt,color){
		var g = svg.group({transform: 'scale('+scale+')',id: diente.id});
		var g2 = svg.group(g, { transform: 'translate('+diente.x+','+diente.y+')'}); //, onclick : 'borrar('+diente.id+','+opt+')' 
		var g3 = svg.group(g2, {fill: 'none', stroke: color, strokeWidth: 1, style: 'font-size: 6pt;font-weight:normal'}); 
//		console.debug(">>>>>>>>>>>>>>> crearFiguraIndividual")
//		console.debug(" opt = "+opt)
		switch (opt) {
		
		case fractura:
			
			if(isCuadranteSuperiorTotal(diente)){
				svg.line(g3, 0, 20, 20, -15,{id: diente.id});  			//FRACTURA	ABAJO			
			}else if(isCuadranteInferiorTotal(diente)){
				svg.line(g3, 0, 35, 20, 0,{id: diente.id});  			//FRACTURA	ARRIBA
			}
			
			break;
			
		case ausente:
			 
		    if(isCuadranteSuperiorTotal(diente)){
		    	svg.line(g3, 0, -15, 20, 20);
			    svg.line(g3, 0, 20, 20, -15);  			//EXTRACCION	
			    
			}else if(isCuadranteInferiorTotal(diente)){
				svg.line(g3, 0, 0, 20, 35);
			    svg.line(g3, 0, 35, 20, 0);  			//EXTRACCION	
			}
		    
		    break;
		case pulpar:
			
		    if(isCuadranteSuperiorTotal(diente)){
		    	svg.line(g3, 10, 10, 10, -15);  			//TRATAMIENTO PULPAR
		    	
			}else if(isCuadranteInferiorTotal(diente)){
				svg.line(g3, 10, 10, 10, 35);  			//TRATAMIENTO PULPAR     
			}
		    break;
		    
		case munon:
//			console.debug("antes de pintar munon")
			pernoMunon(svg,diente,g3);
		    break;

		case munonMal:
			
			pernoMunon(svg,diente,g3);
		    break;
		    
		case clavija:

		    if(isCuadranteSuperiorTotal(diente)){
			    svg.polygon(g3,[[10,-34], [0,-18], [20,-18]]);//DIENTE EN CLAVIJA
		    	
			}else if(isCuadranteInferiorTotal(diente)){
			    svg.polygon(g3,[[10,35], [0,48], [20,48]]);//DIENTE EN CLAVIJA
			}
					 
		    break;
		    
		case remanente: 

		    if(isCuadranteSuperiorTotal(diente)){
		    	svg.text(g3,5,-5,'RR');
		    	
			}else if(isCuadranteInferiorTotal(diente)){
				svg.text(g3,5,30,'RR');
			}
					    
		    break;

		case extruido: //DIENTE EXTRUIDO

		    if(isCuadranteSuperiorTotal(diente)){
				svg.line(g3, 10, 21, 10, 30);
				svg.polygon(g3,[[10,30], [8,27], [12,27]]);
				
			}else if(isCuadranteInferiorTotal(diente)){
				svg.line(g3, 10, -1, 10, -10);
				svg.polygon(g3,[[10,-10], [8,-7], [12,-7]]);
				
			}
					    
		    break;

		case intruido: //DIENTE INTRUIDO
		    if(isCuadranteSuperiorTotal(diente)){
				svg.line(g3, 10, 21, 10, 30);
				svg.polygon(g3,[[10,21], [8,24], [12,24]]);
				
			}else if(isCuadranteInferiorTotal(diente)){
				svg.line(g3, 10, -1, 10, -10);
				svg.polygon(g3,[[10,-1], [8,-4], [12,-4]]);
				
			}
					    
		    break;
		    
		case erupcion: //DIENTE ERUPCIÓN

		    if(isCuadranteSuperiorTotal(diente)){
				svg.polyline(g3,[[0,-10], [20,-5], [0,0], [20,5], [0,10], [10,15], [10,20], [12,18], [8,18], [10,20]]); 
		    	
			}else if(isCuadranteInferiorTotal(diente)){
				svg.polyline(g3,[[0,30], [20,25], [0,20], [20,15], [0,10], [10,5], [10,0], [12,2], [ 8,2], [ 10,0]]);
				
			}
					    
		    break;
		
		case coronaDefinitiva:

			marcarCorona(g3, svg)
					    
		    break;
		    
		case coronaTemporal:

			marcarCorona(g3, svg);
					    
		    break;
		    
		case migracion: //DIENTE ERUPCIÓN

		    if(isCuadranteSuperiorTotal(diente)){
		    	svg.line(g3, 0, 25, 20, 25);				
				svg.polygon(g3,[[20,25], [18,23], [18,27]]); 
		    	
			}else if(isCuadranteInferiorTotal(diente)){
				svg.line(g3, 0, -5, 20, -5);				 
				svg.polygon(g3,[[20,-5], [18,-3], [18,-7]]);  
				
			}
					    
		    break;
		
		case giroversion: 

			var path = svg.createPath();

		    if(isCuadranteSuperiorTotal(diente)){
				svg.path(g3, path.move(0,25).curveC(5,30 , 15,30 ,  20,25));
				svg.polyline(g3,[[17,24], [20,25], [19,29]]); 
		    	
			}else if(isCuadranteInferiorTotal(diente)){
				svg.path(g3, path.move(0,-5).curveC(5,-10 , 15,-10 ,  20,-5));
				svg.polyline(g3,[[17,-4], [20,-5], [19,-9]]); 
				
			}
					    
		    break;
	 
			
		case sellantes:
//			var surface = svg.rect(0, 0, '100%', '100%', {id: 'surface', fill: 'white'}); 
//	        $(surface).mousedown(startDrag).mousemove(dragging).mouseup(endDrag); 
//	        resetSize(svg, '100%', '100%'); 
	        
			break;
		}  
	}	



		function marcarCorona(g, svg){
			svg.circle(g,10,10,10); //corona temporal
		}
		


	function marcadas(){

//		console.debug("arrIndPos  luego de agregar "+arrIndPos);
//	    console.debug("arrIndOptMarc  luego de agregar "+arrIndOptMarc);
//		console.debug("arrExtOptMarc luego de agregar "+arrExtOptMarc);
//		console.debug("arrExtPosIni  luego de agregar "+arrExtPosIni);
//		console.debug("arrExtPosFin  luego de agregar "+arrExtPosFin);
		
		//para las opciones de los costados marcada
//		$("#vPiezasIndMark").val(arrIndPos) ;
//		$("#vOptIndMark").val(arrIndOptMarc) ;
		$("#vPiezasIndMark").val(arrIndOptMarc) ;
		$("#vOptIndMark").val(arrIndPos) ;
		$("#vOptExtMark").val(arrExtOptMarc) ;
		$("#vPiezasIniExtMark").val(arrExtPosIni) ;
		$("#vPiezasFinExtMark").val(arrExtPosFin) ;
		
		console.debug("vPiezasIndMark >>> "+$("#vPiezasIndMark").val());
		console.debug("vOptIndMark >>> "+$("#vOptIndMark").val());
		console.debug("vOptExtMark >>> "+$("#vOptExtMark").val());
		console.debug("vPiezasIniExtMark >>> "+$("#vPiezasIniExtMark").val());
		console.debug("vPiezasFinExtMark >>> "+$("#vPiezasFinExtMark").val());
	}

	function agregarMarcasExtremos(ini,fin,opt){
		arrExtOptMarc.push(opt);//opcion marcada
		arrExtPosIni.push(ini);
		arrExtPosFin.push(fin);

		marcadas();
	}

	function agregarMarcasIndividuales(ini,opt){

		 
		 arrIndPos.push(ini);
		 arrIndOptMarc.push(opt);
		 
		 marcadas();
	}


	function eliminarFiguraIndividual(posi,id){
		var flag = false;
		for (var i = 0; i < arrIndPos.length; i++) {
			if (arrIndPos[i] == posi) {
				arrIndPos.splice(i, 1);
				arrIndOptMarc.splice(i, 1);
				flag = true;
//				console.debug("Elimina "+id)
				eliminarFigura(id);
				break;
			}
		}
		return flag;
	}

	function borrarFigura(diente,opt){
		var posi =  obtenerPosicion(diente.id);

		var flag = false;
		//si la posicion que ingreso forma parte de un rango
		if(arrExtPosIni.length > 0){	
			for(var i=0; i < arrExtPosIni.length ; i++){
				if(arrExtPosIni[i] <= posi && posi <= arrExtPosFin[i]){
					ini = arrExtPosIni[i];
					fin =  arrExtPosFin[i];
				
					arrExtPosIni.splice(i, 1);
					arrExtPosFin.splice(i, 1);
					arrExtOptMarc.splice(i, 1);
					
					for (var i = ini; i <= fin; i++) {
//						console.debug("elimina posi ="+i+" diente "+tempDientes[i])
						eliminarFigura(tempDientes[i]);
						
					}
					break;
				}
			}
		}
		
		if (arrIndPos.length > 0) {
			flag = eliminarFiguraIndividual(posi,diente.id);
			
		}

		
	}

	//para borrar las figuras entre extremos 05122016
	function borrarFigurasEnRangos(ini,fin,opt){
//		console.debug("inicio = "+ini)
//		console.debug("fin = "+fin)
		var posi = 0;
		var fdel = false;
		//buscar en el nuevo rrango las  marcas individuales en el arreglo de marcas inviduales
		if(arrIndPos.length > 0){
			for (var i = ini; i <= fin; i++) {
				for(var x = 0; x < arrIndPos.length; x++){
					if(i == arrIndPos[x] ){
//						console.debug("entro a marca invidual")
						arrIndPos.splice(x, 1);
						arrIndOptMarc.splice(x, 1);
						eliminarFigura(tempDientes[i]);
						break;
					}
				}
			}
//			console.debug("arr Posiciones Figuras Individuales ="+arrIndPos)
//			console.debug("arr Opciones Individuales  Marcadas="+arrIndOptMarc)
		}
		
		
		//buscar los extremos dentro de los arreglos de los extremos inicial y final
//		var tini =0;
//		var tfin =0;
		if(arrExtPosIni.length > 0){

			eliminarRango(ini);
			eliminarRango(fin);
			eliminarRangosInternos(ini, fin, arrExtPosIni);
//			console.debug("elimina rango interno arrExtPosIni")
			eliminarRangosInternos(ini, fin, arrExtPosFin);
//			console.debug("elimina rango interno arrExtPosFini")


		}
	}

	function eliminarRangosInternos(ini, fin, arrExt){
		var fdel = false;
		for(var i=0; i < arrExt.length ; i++){
			if( ini <= arrExt[i] && arrExt[i] <= fin){
				arrExtPosIni.splice(i, 1);
				arrExtPosFin.splice(i, 1);
				arrExtOptMarc.splice(i, 1);
				
				for (var i = ini; i <= fin; i++) {
//					console.debug("elimina posi ="+i+" diente "+tempDientes[i])
					eliminarFigura(tempDientes[i]);
					
				}
				fdel = true;
				break;
			}
			
		}
		
		
		return fdel;
	}

	function eliminarRango(posi){
//		console.debug("inicial arrIni ="+arrExtPosIni)
//		console.debug("final arrFin ="+arrExtPosFin)
//		console.debug("arrPos ="+arrExtOptMarc)
		
		var tini =0;
		var tfin =0;
		var fdel = false;
		for(var i=0; i < arrExtPosIni.length ; i++){
			if(arrExtPosIni[i] <= posi && posi <= arrExtPosFin[i]){
				tini = arrExtPosIni[i];
				tfin =  arrExtPosFin[i];
//				console.debug("rango a eliminar ini ="+tini + " fin = "+tfin)
//				console.debug("arrExtPosIni ="+arrExtPosIni)
//				console.debug("arrExtPosFin ="+arrExtPosFin)
//				console.debug("arrExtOptMarc ="+arrExtOptMarc)
				arrExtPosIni.splice(i, 1);
				arrExtPosFin.splice(i, 1);
				arrExtOptMarc.splice(i, 1);
				
				for (var i = tini; i <= tfin; i++) {
//					console.debug("elimina posi ="+i+" diente "+tempDientes[i])
					eliminarFigura(tempDientes[i]);
				}
				fdel = true;
				break;
			}
		
		}
		return fdel;
	}

	function eliminarFigura(id){
		
			$('#odontograma svg g').each(function(){

				if($(this).attr('id') == id){
					$(this).remove();
				}
			});
	}
	//se esta quitando validacion de rangos 01/12/2016
	function verificarMarca(ini,fin){
		var flag = false;
		
		if(arrExtPosIni.length == 0 && arrExtPosFin.length == 0){
//			alert("arrposi vacias")
			arrExtPosIni.push(ini);
			arrExtPosFin.push(fin);
			
		}else{
			if(!existeEnRango(ini) && !existeEnRango(fin)){
//				alert("no se encuentran en rango")
				arrExtPosIni.push(ini);
				arrExtPosFin.push(fin);
				
			}else{
				alert("Extremos existen en otro rango")
				flag = true;
				
			}
		}
		
		return flag;
	}

	function existeEnRango(posi,arr){
		var flag = false;
		
		for(var i = 0; i < arrExtPosIni.length; i++){
			
			if(arrExtPosIni[i] <= posi && posi <= arrExtPosFin[i]){
					flag = true;
					break;
			}
			
		}
		
		return flag;
	}

})(jQuery);
//$.getScript("odontogramaOpciones.js");		