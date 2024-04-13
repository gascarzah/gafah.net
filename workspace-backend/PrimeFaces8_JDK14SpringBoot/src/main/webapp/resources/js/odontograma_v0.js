/**
 * Giovanni Ascarza Hinostroza
 * 
 * 
 */
(function($) {
	
	
	var contaPerPorExtraer= 0;
	var contaPerProtesis= 0;
	var contaPerPerdida= 0;
	var contaPerObturada= 0;
	var contaPerCariada= 0;
	var contaPerFracturada= 0;
	var contaPerTotal= 0;

	var contaResPorExtraer= 0;
	var contaResProtesis= 0;
	var contaResPerdida= 0;
	var contaResObturada= 0;
	var contaResCariada= 0;
	var contaResFracturada= 0;
	var contaResTotal= 0;
	
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
	
	var arrPieza = [];
	var arrCara = [];
	var arrColor = [];
	var arrPiezaInicial = [];
	var arrCaraInicial = [];
	var arrColorInicial = [];
	var tratamientoDefinitivo = [];//15032016
	
	
	var conta11 = 0;
	var conta12 = 0;
	var conta13 = 0;
	var conta14 = 0;
	var conta15 = 0;
	var conta16 = 0;
	var conta17 = 0;
	var conta18 = 0;
	
	var conta21 = 0;
	var conta22 = 0;
	var conta23 = 0;
	var conta24 = 0;
	var conta25 = 0;
	var conta26 = 0;
	var conta27 = 0;
	var conta28 = 0;
	
	var conta31 = 0;
	var conta32 = 0;
	var conta33 = 0;
	var conta34 = 0;
	var conta35 = 0;
	var conta36 = 0;
	var conta37 = 0;
	var conta38 = 0;
	
	var conta41 = 0;
	var conta42 = 0;
	var conta43 = 0;
	var conta44 = 0;
	var conta45 = 0;
	var conta46 = 0;
	var conta47 = 0;
	var conta48 = 0;
	
	var conta51 = 0;
	var conta52 = 0;
	var conta53 = 0;
	var conta54 = 0;
	var conta55 = 0;
	
	var conta61 = 0;
	var conta62 = 0;
	var conta63 = 0;
	var conta64 = 0;
	var conta65 = 0;
	
	var conta71 = 0;
	var conta72 = 0;
	var conta73 = 0;
	var conta74 = 0;
	var conta75 = 0;
	
	var conta81 = 0;
	var conta82 = 0;
	var conta83 = 0;
	var conta84 = 0;
	var conta85 = 0;
	
	
	//View Models
	var colorCara ;
	var carColor ;
	

	function DienteModel(id, x, y) {
		var self = this;

		self.id = id;
		self.x = x ; //se le aumenta 5 espacios a la coordenada
		self.y = y + 10; //se le aumenta 10 espacios a la coordenada
	}

	//Cargo los dientes
	var dientes = [];
	//constante horizontal
	var k = 35;
	//constante horizontal derecha
	var kd = 210+85;
	
	//constante vertical
	var kv = 45;
	//Dientes izquierdos
	for (var i = 0; i < 8; i++) {
		dientes.push(new DienteModel((18 - i)/10, (i * k)+5, 0));
	}
	for (var i = 0; i < 5; i++) {
		dientes.push(new DienteModel((55 - i)/10, ((i + 3) * k)+5, 1 * kv ));
	}
	for (var i = 0; i < 5; i++) {
		dientes.push(new DienteModel((85 - i)/10, ((i + 3) * k)+5, 2 * kv ));
	}
	for (var i = 0; i < 8; i++) {
		dientes.push(new DienteModel((48 - i)/10, (i * k)+5, 3 * kv));
	}
	//Dientes derechos
	for (var i = 0; i < 8; i++) {
		dientes.push(new DienteModel((21 + i)/10, (i * k + kd), 0  ));
	}
	for (var i = 0; i < 5; i++) {
		dientes.push(new DienteModel((61 + i)/10, (i * k + kd), 1 * kv ));
	}
	for (var i = 0; i < 5; i++) {
		dientes.push(new DienteModel((71 + i)/10, (i * k + kd), 2 * kv));
	}
	for (var i = 0; i < 8; i++) {
		dientes.push(new DienteModel((31 + i)/10, (i * k + kd), 3 * kv));
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
					//Super superior
					return [[5, -5], [15, -5], [20, 0], [0, 0]];	
				case 'r'://'T':
					//Super inferior
					return [[5, 25], [15, 25], [20, 20], [0, 20]];	
				default:
					throw new Error('La cara: ' + cara + ' no es una cara valida.');
				}
			}

		

							
		
		
		var attachEventsAndData = function(element, cara) {
			
			if(!settings.readOnly){				
				element.data('cara', cara).click(function() {
					var me = $(this);
					var cara = me.data('cara');

					if (cara == 'X' ){
						var count = 0;
						for(var i=0; i < arrPiezaInicial.length; i++){
							if(diente.id == arrPiezaInicial[i]){
								count++;
								break;
							}
						}
						
						if(count == 1){
							obtenerProcedimientoPieza([{name:'dienteId', value:diente.id}, {name:'cara', value:cara}]); //makes a remote call with parameter
						}else{
							alert('Debe de marcar esta pieza con las opciones de la parte inferior izquierda.');	
						}
						
					}else {
					
					if (!$('input:radio').is(":checked")) {
						alert('Debe seleccionar una opcion previamente.');
						return false;
					}
					
					var tempoNuevas = [];//17032016
					var tempoDifCara = [];//17032016
					

					
					
					
					
					// Validaciones de si la cara tiene tratamiento o no, etc...
					var tratamientoIngresado = {
						diente: diente,
						cara: cara,
						//tratamiento: tratamientoSeleccionado
						color: carColor //opcion del color una vez marcado //carColor Opcion marcada (Protesis, por extraer, ausente, etc) //colorCara : color de la cara
					};
						
						var lados = ['L','V','M','D','O','R','r'];
						//cuando todo esta vacio
						if(tratamientosAplicados.length == 0){
								// verificar si la opcion es por extraer, protesis, perdida, el cual marca a todos
								if(carColor == '398' || carColor == '400' || carColor ==  '401'){
									me.data('oldFill', me.attr('fill'));
									me.attr('fill', colorCara);
									
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
									
								}else if(carColor=='395'){
												
									
								}else{
										me.data('oldFill', me.attr('fill'));
										me.attr('fill', colorCara);
												// Validaciones de si la cara tiene tratamiento o no, etc...
//										var tratamientoOriginal = {diente: diente, cara: cara, color: carColor };
										tratamientosAplicados.push(tratamientoIngresado);
										
										//aumenta contadores
										cuentaVariables(tratamientoIngresado.diente.id,tratamientoIngresado.cara, tratamientoIngresado.color);
								}
								
						}else{
							//cuando ya se tiene piezas marcadas
							//INICIO DE LAS DIFERENTES MARCAS DE LAS CARAS 
							var marcasLlenas =0;
							var marcasParciales =0;
							var marcas =0;
							
							//evaluar las marcas de la pieza
							for(var i=0; i < tratamientosAplicados.length ; i++){
								if(tratamientoIngresado.diente.id == tratamientosAplicados[i].diente.id){ 
									if(tratamientosAplicados[i].color == '398' || tratamientosAplicados[i].color == '400' || tratamientosAplicados[i].color == '401'){
										marcasLlenas++;
									}else if(tratamientosAplicados[i].color == '395'){
									
									}else{
										marcasParciales++;	
									}
								}else{
									marcas++;
								}
							}
							
							
							//SI SON MARCAS NUEVAS
							if(marcas == tratamientosAplicados.length){
								
								
								// verificar si la opcion es por extraer, protesis, perdida, el cual marca a todos
								if(tratamientoIngresado.color == '398' || tratamientoIngresado.color == '400' || tratamientoIngresado.color ==  '401'){
									
									me.data('oldFill', me.attr('fill'));
									me.attr('fill', colorCara);
									
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
//										var tratamientoOriginal = {diente: diente, cara: cara, color: carColor };
										tratamientosAplicados.push(tratamientoIngresado);
										
										//aumenta contadores
										cuentaVariables(tratamientoIngresado.diente.id,tratamientoIngresado.cara, tratamientoIngresado.color);
								}
								
								
								
								
								}else{
								
								if(marcasLlenas == 7){ //todas estan marcadas
									
									//elimino todas
									/////////////////////
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
									while(6!=contador){
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
									///////////////////////////
									
									
									if(tratamientoIngresado.color == '398' || tratamientoIngresado.color == '400' || tratamientoIngresado.color == '401'){
									
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
													var tratamientoRestante = {diente: diente,cara: nuevLados[i],color: carColor };
													tratamientosAplicados.push(tratamientoRestante);
													//cuenta Variables restantes
													cuentaVariables(tratamientoRestante.diente.id,tratamientoRestante.cara, tratamientoRestante.color);
											}
											
											for(var y = 0; y < tratamientosAplicados.length ; y++){
												console.debug("luego ingresar nuevo  diente.id "+tratamientosAplicados[y].diente.id + " color "+tratamientosAplicados[y].color + " lado "+tratamientosAplicados[y].cara);
											}
									///////////////
									
									
									}else if(tratamientoIngresado.color == '395'){
									 
										/////////////////////
										
											for(var i=0; i < lados.length; i++){
												if(lados[i]!=tratamientoIngresado.cara){
													caras[lados[i]].attr('fill', colorCara);
												}
											}
										///////////////
										
										
									}else{
										
										//agregar nuevamente al tratamientosAplicados
										tratamientosAplicados.push(tratamientoIngresado);
										//cuenta Variables
										cuentaVariables(tratamientoIngresado.diente.id,tratamientoIngresado.cara, tratamientoIngresado.color);
										
											for(var i=0; i < lados.length; i++){
												if(lados[i]!=tratamientoIngresado.cara){
													caras[lados[i]].attr('fill', 'white');
												}
											}
										///////////////
										
									}
								}
								else{
								
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////								
								if (marcasParciales <= 7){
									
									if(tratamientoIngresado.color== '398' || tratamientoIngresado.color == '400' || tratamientoIngresado.color ==  '401'){
								  		var parcial = 0;
										//elimino todas y agrego todas
										/////////////////////
//								  		evaluarListado(tratamientosAplicados, marcasParciales);
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
										
										
											///////////////////////////
									}else{
								//si se pinta la misma cara
										me.data('oldFill', me.attr('fill'));
										me.attr('fill', colorCara);
										
										
										//elimino todas 
								  		var parcial = 0;
										
										while(7 != parcial){
											for(var y = 0; y < tratamientosAplicados.length ; y++){
												if(tratamientosAplicados[y].diente.id == tratamientoIngresado.diente.id ){
													if(tratamientosAplicados[y].color == '398' || tratamientosAplicados[y].color == '400' 
														||tratamientosAplicados[y].color == '401'){
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
								
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////								
								}
								
								}
							
									  
									  
						}
						


							
							var cadena='';
							for (var i = 0; i < tratamientosAplicados.length; i++) {
//								console.debug(tratamientosAplicados[i].diente.id + tratamientosAplicados[i].cara+	tratamientosAplicados[i].color) ;
								cadena += tratamientosAplicados[i].diente.id + tratamientosAplicados[i].cara+	tratamientosAplicados[i].color+ "|";
							}
							
							var piezasMarcadas='';
							
							console.debug("Marcas ");
							for (var i = 0; i < arrPiezaInicial.length; i++) {
								console.debug(arrPiezaInicial[i] + arrCaraInicial[i]+	arrColorInicial[i]) ;
								piezasMarcadas += arrPiezaInicial[i] + arrCaraInicial[i]+	arrColorInicial[i]+ "|";
							}
							console.debug("fin Marcas ");
							
							
							console.debug("Luego arrPieza Final :"+arrPieza);
							console.debug("Luego arrCara Final :"+arrCara);
							console.debug("Luego arrColor Final :"+arrColor);
						
							
//							console.debug("tam defi "+defi);
							console.debug("tam actual "+cadena);
							console.debug("tam piezas marcardas "+piezasMarcadas);
							$("#vDientes").val(cadena) ;
							$("#vPiezasMarcadas").val(piezasMarcadas) ;
							self.trigger('tratamientoAplicado.odontograma', tratamiento);
							
							
					}
					
				})
			}
			
			return element;
		}
		
		var createCara = function(cara) {
				var polygonPoints = calculatePolygon(cara);
				return attachEventsAndData($(svg.polygon(dienteGroup, polygonPoints, defaultPolygon)), cara);
			}

		
			//Creo las cara SVG y las agrego como un diccionario
//		var caras = ['S', 'I', 'D', 'Z', 'C','W','T'];
		var caras = ['L','V','M','D','O','R','r'];
		for (var i = caras.length - 1; i >= 0; i--) {
			var cara = caras[i];
			caras[cara] = createCara(cara);
		}

		//Creo el diente completo y lo agrego a las caras
		var caraCompleto = svg.text(dienteGroup, 4.5, 35, diente.id.toString(), {
			fill: 'navy',
			stroke: 'navy',
			strokeWidth: 0.1,
			style: 'font-size: 6pt;font-weight:normal;cursor:pointer'
		});
		caraCompleto = attachEventsAndData($(caraCompleto), 'X');

		caras['X'] = caraCompleto;

		//Busco los tratamientos aplicados al diente
		var tratamientosAplicadosAlDiente = arrayFilter(tratamientosAplicados, function(t) {
			//console.debug("tratamientosAplicadosAlDiente "+t.diente.id)
			return t.diente.id == diente.id;
		});

		for (var i = tratamientosAplicadosAlDiente.length - 1; i >= 0; i--) {
			var t = tratamientosAplicadosAlDiente[i];
			console.debug("===>>> t.diente.id "+t.diente.id + " t.cara "+t.cara + " t.color "+t.color );
			var colorFinal='';
			if(t.color == '401'){		
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
			console.debug("t.diente.id "+t.diente.id + " t.cara "+t.cara + " opcion "+t.color + " color cara "+colorFinal );
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
		

	}
	
	
	 
	 
	 
	
	//tama?o del cuadro que va a contener todos los dientes defaults.tratamientosAplicados
	var defaults = {
		width: '850px',
		height: '285px',
		scale: 1.5,
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

	
	
	$('input:radio').change(function(  ) {
	 if( $(this).is(":checked") ){ // check if the radio is checked
		
		if($(this).val() == 'Y'){     // por extraer
				carColor = '401';
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
			
			
			
        }
    

	 
	});
	
	
	//luego de crear el odontograma, reensambla el ultimo ontograma generado
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
					 console.debug("posi "+posi)
					 console.debug("dientes "+dientes[posi])
					 console.debug("dientes >>"+dientes[posi].id)
					 console.debug("Matriz Formada en el cliente")
					 console.debug("diente[posi] "+dientes[posi].id + " tempCara "+tempCara[x]+ " opcionColor" +tempColor[x]);
					 marcarPiezaOdontograma(dientes[posi],tempCara[x],tempColor[x]);
					 
				 }
			 
		 }
		}
	 
	
	 
	 function obtenerPosicion(pieza){
		 var posicion;
	 
		 switch (pieza) {
			
		 case 1.8: posicion = 0 ; break;
		 case 1.7: posicion = 1 ; break;
		 case 1.6: posicion = 2 ; break;
		 case 1.5: posicion = 3 ; break;
		 case 1.4: posicion = 4 ; break;
		 case 1.3: posicion = 5 ; break;
		 case 1.2: posicion = 6 ; break;
		 case 1.1: posicion = 7 ; break;
		 case 5.5: posicion = 8 ; break;
		 case 5.4: posicion = 9 ; break;
		 case 5.3: posicion = 10 ; break;
		 case 5.2: posicion = 11 ; break;
		 case 5.1: posicion = 12 ; break;
		 case 8.5: posicion = 13 ; break;
		 case 8.4: posicion = 14 ; break;
		 case 8.3: posicion = 15 ; break;
		 case 8.2: posicion = 16 ; break;
		 case 8.1: posicion = 17 ; break;
		 case 4.8: posicion = 18 ; break;
		 case 4.7: posicion = 19 ; break;
		 case 4.6: posicion = 20 ; break;
		 case 4.5: posicion = 21 ; break;
		 case 4.4: posicion = 22 ; break;
		 case 4.3: posicion = 23 ; break;
		 case 4.2: posicion = 24 ; break;
		 case 4.1: posicion = 25 ; break;
		 case 2.1: posicion = 26 ; break;
		 case 2.2: posicion = 27 ; break;
		 case 2.3: posicion = 28 ; break;
		 case 2.4: posicion = 29 ; break;
		 case 2.5: posicion = 30 ; break;
		 case 2.6: posicion = 31 ; break;
		 case 2.7: posicion = 32 ; break;
		 case 2.8: posicion = 33 ; break;
		 case 6.1: posicion = 34 ; break;
		 case 6.2: posicion = 35 ; break;
		 case 6.3: posicion = 36 ; break;
		 case 6.4: posicion = 37 ; break;
		 case 6.5: posicion = 38 ; break;
		 case 7.1: posicion = 39 ; break;
		 case 7.2: posicion = 40 ; break;
		 case 7.3: posicion = 41 ; break;
		 case 7.4: posicion = 42 ; break;
		 case 7.5: posicion = 43 ; break;
		 case 3.1: posicion = 44 ; break;
		 case 3.2: posicion = 45 ; break;
		 case 3.3: posicion = 46 ; break;
		 case 3.4: posicion = 47 ; break;
		 case 3.5: posicion = 48 ; break;
		 case 3.6: posicion = 49 ; break;
		 case 3.7: posicion = 50 ; break;
		 case 3.8: posicion = 51 ; break;
		 
		 
		 }
		 return posicion;
		 
	 }
	
	function marcarPiezaOdontograma(diente,cara,carColor){
		///OBTENER EL POLIGONO
//		var polygonPoints = calculatePolygon(cara);
//		var me = $(svg.polygon(dienteGroup, polygonPoints, defaultPolygon));
//		
//		me.data('oldFill', me.attr('fill'));
//		me.attr('fill', colorCara);
		
//		var me = $(this);
//		 var cara = me.data(cara);
		 
		 var tratamiento = {
					diente: diente,
					cara: cara,
					color: carColor
				};
//		 
//		 alert("default >>> "+defaults.tratamientosAplicados)
//		 alert("cara >>> "+tempo.cara)
//		 alert("color >>> "+tempo.color)
		 
		 
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
			
			
				
			
			
			
			console.debug("tam actual "+cadena);
			console.debug("tam piezas marcardas "+piezasMarcadas);
			$("#vDientes").val(cadena) ;
			$("#vPiezasMarcadas").val(piezasMarcadas) ;
//			self.trigger('tratamientoAplicado.odontograma', tratamiento);
	 }	
	
	
	function disminuirVariables(pieza, cara, color){
		var colorBorrar = '';
		console.debug("Iniciales arrPieza :"+arrPieza);
		console.debug("Iniciales arrCara :"+arrCara);
		console.debug("Iniciales arrColor :"+arrColor);
		for(var x=0; x < arrPieza.length; x++){
		console.debug("marcada "+arrPieza[x]+arrCara[x]+arrColor[x])
		}
	
		
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
					}else if(color == '398' || color == '400' || color == '401'){
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
		
		
		console.debug("Excluyente :"+contaExcluyente);
		console.debug("Luego arrPieza :"+arrPieza);
		console.debug("Luego arrCara :"+arrCara);
		console.debug("Luego arrColor :"+arrColor);
		var lados = ['L','V','M','D','O','R','r'];
		
		if(contaExcluyente==1){
			
			colorBorrar=color;
			var counter = 0;
			while(7!= counter){
				for(var i=0; i < arrPieza.length; i++){
					if(arrPieza[i] == pieza && arrColor[i] == color){
								arrPieza.splice(i, 1);
								arrCara.splice(i, 1);
								arrColor.splice(i, 1);
								console.debug(counter);
								console.debug("Luego arrPieza :"+arrPieza);
								console.debug("Luego arrCara :"+arrCara);
								console.debug("Luego arrColor :"+arrColor);
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
		console.debug("Despues arrPieza :"+arrPieza);
		console.debug("Despues arrCara :"+arrCara);
		console.debug("Despues arrColor :"+arrColor);
		
		
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
	
	function valoresArr(pieza,cara,color){
		var conta = 0;
		if(arrPieza.length==0){
			arrPieza.push(pieza);
			arrColor.push(color);
			arrCara.push(cara);
		}else{
			for(var i=0; i<arrPieza.length;i++){
				if(arrPieza[i]==pieza && arrColor[i]==color && arrCara[i]==cara){
					//no se ingresa nada
				}else{
					conta++;
				}
			}
			
			if(conta==arrPieza.length){
				arrPieza.push(pieza);
				arrColor.push(color);
				arrCara.push(cara);
			}
			
		}
	}
	
	function valoresInicialesArr(pieza,cara,color){
		var conta =0;
		
		if(arrPiezaInicial.length == 0){
			arrPiezaInicial.push(pieza);
			arrCaraInicial.push(cara);
			arrColorInicial.push(color);
		}else{
			
			for(var i=0; i<arrPiezaInicial.length ; i++){
				if(arrPiezaInicial[i] == pieza){
					break;
				}else{
					conta++;
				}
			}
			
			if(conta == arrPiezaInicial.length){
				arrPiezaInicial.push(pieza);
				arrCaraInicial.push(cara);
				arrColorInicial.push(color);	
			}
		}	
	}
	
	
	
	
	function disminuirVariablesRes(color){
		if(color == '401'){
			contaResPorExtraer--;
			contaResTotal--;
			cResPorExtraer(contaResPorExtraer,contaResTotal);
		}else if(color == '400'){
			 contaResProtesis--;
			 contaResTotal--;
			 
			 cResProtesis(contaResProtesis,contaResTotal);
		 }else if(color == '398'){
			 contaResPerdida--;
			 contaResTotal--;
			 cResPerdida(contaResPerdida,contaResTotal);
		 }else if(color == '397'){
			 contaResObturada--;
			 contaResTotal--;
			 cResObturada(contaResObturada,contaResTotal);
		 }else if(color == '396'){
			 contaResCariada--;
			 contaResTotal--;
			 cResCariada(contaResCariada,contaResTotal);
		}else if(color == '399'){
			 contaResFracturada--;
			 contaResTotal--;
			 cResFracturada(contaResFracturada,contaResTotal);
		 }else if(color == '395'){

		 }
	}
	
	function disminuirVariablesPer(color){
		if(color == '401'){
			 contaPerPorExtraer--;
			 contaPerTotal--;
			 cPerPorExtraer(contaPerPorExtraer,contaPerTotal);
		 }else if(color == '400'){
			 contaPerProtesis--;
			 contaPerTotal--;
			 cPerProtesis(contaPerProtesis,contaPerTotal);
		 }else if(color == '398'){
			 contaPerPerdida--;
			 contaPerTotal--;
			 cPerPerdida(contaPerPerdida,contaPerTotal);
		 }else if(color == '397'){
			 contaPerObturada--;
			 contaPerTotal--;
			 cPerObturada(contaPerObturada,contaPerTotal);
		 }else if(color == '396'){
			 contaPerCariada--;
			 contaPerTotal--;
			 cPerCariada(contaPerCariada,contaPerTotal);
		 }else if(color == '399'){
			 contaPerFracturada--;
			 contaPerTotal--;
			 cPerFracturada(contaPerFracturada,contaPerTotal);
		 }else if(color == '395'){
			 
		 }
	}
	
	
	function disminuirContadores(pieza,cara,color){
			
			switch (pieza) {
			
			case  1.1:
					conta11=0;
					disminuirVariablesPer(color);
				break;
			case  1.2:
				conta12=0;
				disminuirVariablesPer(color);

				break;
			case  1.3:
				conta13=0;
				disminuirVariablesPer(color);

				
				break;
			case  1.4:
				conta14=0;
				disminuirVariablesPer(color);

				break;
			case  1.5:
				conta15=0;
				disminuirVariablesPer(color);

				break;
			case  1.6:
				conta16=0;
				disminuirVariablesPer(color);

				break;
			case  1.7:
				conta17=0;
				disminuirVariablesPer(color);
				break;
			case  1.8:
				conta18=0;
				disminuirVariablesPer(color);
				break;
				
			
			case  2.1:
				conta21=0;
				disminuirVariablesPer(color);
				break;
			case  2.2:
				conta22=0;
				disminuirVariablesPer(color);
				break;
			case  2.3:
				conta23=0;
				disminuirVariablesPer(color);

				
				break;
			case  2.4:
				conta24=0;
				disminuirVariablesPer(color);

				break;
			case  2.5:
				conta25=0;
				disminuirVariablesPer(color);

				break;
			case  2.6:
				conta26=0;
				disminuirVariablesPer(color);

				break;
			case  2.7:
				conta27=0;
				disminuirVariablesPer(color);
				break;
			case  2.8:
				conta28=0;
				disminuirVariablesPer(color);
				break;	
				
			
			case  3.1:
				conta31=0;
				disminuirVariablesPer(color);
				break;
			case  3.2:
				conta32=0;
				disminuirVariablesPer(color);

				break;
			case  3.3:
				conta33=0;
				disminuirVariablesPer(color);

				
				break;
			case  3.4:
				conta34=0;
				disminuirVariablesPer(color);

				break;
			case  3.5:
				conta35=0;
				disminuirVariablesPer(color);

				break;
			case  3.6:
				conta36=0;
				disminuirVariablesPer(color);

				break;
			case  3.7:
				conta37=0;
				disminuirVariablesPer(color);
				break;
			case  3.8:
				conta38=0;
				disminuirVariablesPer(color);
				break;
			
			case  4.1:
				conta41=0;
				disminuirVariablesPer(color);
				break;
			case  4.2:
				conta42=0;
				disminuirVariablesPer(color);

				break;
			case  4.3:
				conta43=0;
				disminuirVariablesPer(color);
				
				break;
			case  4.4:
				conta44=0;
				disminuirVariablesPer(color);

				break;
			case  4.5:
				conta45=0;
				disminuirVariablesPer(color);

				break;
			case  4.6:
				conta46=0;
				disminuirVariablesPer(color);

				break;
			case  4.7:
				conta47=0;
				disminuirVariablesPer(color);
				break;
			case  4.8:
				conta48=0;
				disminuirVariablesPer(color);
				break;
			
			case  5.1:
				conta51=0;
				disminuirVariablesRes(color);
				break;
				
			case  5.2:
				conta52=0;
				disminuirVariablesRes(color);
				break;
				
			case  5.3:
				conta53=0;
				disminuirVariablesRes(color);
				break;
				
			case  5.4:
				conta54=0;
				disminuirVariablesRes(color);
				break;
				
				
			case 5.5:
				conta55=0;
				disminuirVariablesRes(color);
				 
				break;
			
			case  6.1:
				conta61=0;
				disminuirVariablesRes(color);
				break;
				
			case  6.2:
				conta62=0;
				disminuirVariablesRes(color);
				break;
				
			case  6.3:
				conta63=0;
				disminuirVariablesRes(color);
				break;
				
			case  6.4:
				conta64=0;
				disminuirVariablesRes(color);
				break;
				
				
			case 6.5:
				conta65=0;
				disminuirVariablesRes(color);
				break;
				
			case  7.1:
				conta71=0;
				disminuirVariablesRes(color);
				break;
				
			case  7.2:
				conta72=0;
				disminuirVariablesRes(color);
				break;
				
			case  7.3:
				conta73=0;
				disminuirVariablesRes(color);
				break;
				
			case  7.4:
				conta74=0;
				disminuirVariablesRes(color);
				break;
				
				
			case 7.5:
				conta75=0;
				disminuirVariablesRes(color);
				break;
				
			case  8.1:
				conta81=0;
				disminuirVariablesRes(color);
				break;
				
			case  8.2:
				conta82=0;
				disminuirVariablesRes(color);
				break;
				
			case  8.3:
				conta83=0;
				disminuirVariablesRes(color);
				break;
				
			case  8.4:
				conta84=0;
				disminuirVariablesRes(color);
				break;
				
				
			case 8.5:
				conta85=0;
				disminuirVariablesRes(color);
				break;
		}

	}
	
	
			
	function cuentaVariables(pieza,cara, color){
		
		if(color !='395'){
			valoresArr(pieza,cara,color);
		}
		
		switch (pieza) {
		
		case  1.1:
			if(conta11 == 0){
				conta11=1;
				valoresInicialesArr(pieza,cara,color);
				contarVariablesPer(color);
			}
			//agregar cara y color
			break;
		case  1.2:
			if(conta12 == 0){
				conta12=1;
				valoresInicialesArr(pieza,cara,color);
				contarVariablesPer(color);
			}

			break;
		case  1.3:
			if(conta13 == 0){
				conta13=1;
				valoresInicialesArr(pieza,cara,color);
				contarVariablesPer(color);
			}

			
			break;
		case  1.4:
			if(conta14 == 0){
				conta14=1;
				valoresInicialesArr(pieza,cara,color);
				contarVariablesPer(color);
			}

			break;
		case  1.5:
			if(conta15 == 0){
				conta15=1;
				valoresInicialesArr(pieza,cara,color);
				contarVariablesPer(color);
			}

			break;
		case  1.6:
			if(conta16 == 0){
				conta16=1;
				valoresInicialesArr(pieza,cara,color);
				contarVariablesPer(color);
			}

			break;
		case  1.7:
			if(conta17 == 0){
				conta17=1;
				valoresInicialesArr(pieza,cara,color);
				contarVariablesPer(color);
			}
			break;
		case  1.8:
			if(conta18 == 0){
				conta18=1;
				valoresInicialesArr(pieza,cara,color);
				contarVariablesPer(color);
			}
			break;
			
		
		case  2.1:
			if(conta21 == 0){
				conta21=1;
				valoresInicialesArr(pieza,cara,color);
				contarVariablesPer(color);
			}
			break;
		case  2.2:
			if(conta22 == 0){
				conta22=1;
				valoresInicialesArr(pieza,cara,color);
				contarVariablesPer(color);
			}

			break;
		case  2.3:
			if(conta23 == 0){
				conta23=1;
				valoresInicialesArr(pieza,cara,color);
				contarVariablesPer(color);
			}

			
			break;
		case  2.4:
			if(conta24 == 0){
				conta24=1;
				valoresInicialesArr(pieza,cara,color);
				contarVariablesPer(color);
			}

			break;
		case  2.5:
			if(conta25 == 0){
				conta25=1;
				valoresInicialesArr(pieza,cara,color);
				contarVariablesPer(color);
			}

			break;
		case  2.6:
			if(conta26 == 0){
				conta26=1;
				valoresInicialesArr(pieza,cara,color);
				contarVariablesPer(color);
			}

			break;
		case  2.7:
			if(conta27 == 0){
				conta27=1;
				valoresInicialesArr(pieza,cara,color);
				contarVariablesPer(color);
			}
			break;
		case  2.8:
			if(conta28 == 0){
				conta28=1;
				valoresInicialesArr(pieza,cara,color);
				contarVariablesPer(color);
			}
			break;	
			
		
		case  3.1:
			if(conta31 == 0){
				conta31=1;
				valoresInicialesArr(pieza,cara,color);
				contarVariablesPer(color);
			}
			break;
		case  3.2:
			if(conta32 == 0){
				conta32=1;
				valoresInicialesArr(pieza,cara,color);
				contarVariablesPer(color);
			}

			break;
		case  3.3:
			if(conta33 == 0){
				conta33=1;
				valoresInicialesArr(pieza,cara,color);
				contarVariablesPer(color);
			}

			
			break;
		case  3.4:
			if(conta34 == 0){
				conta34=1;
				valoresInicialesArr(pieza,cara,color);
				contarVariablesPer(color);
			}

			break;
		case  3.5:
			if(conta35 == 0){
				conta35=1;
				valoresInicialesArr(pieza,cara,color);
				contarVariablesPer(color);
			}

			break;
		case  3.6:
			if(conta36 == 0){
				conta36=1;
				valoresInicialesArr(pieza,cara,color);
				contarVariablesPer(color);
			}

			break;
		case  3.7:
			if(conta37 == 0){
				conta37=1;
				valoresInicialesArr(pieza,cara,color);
				contarVariablesPer(color);
			}
			break;
		case  3.8:
			if(conta38 == 0){
				conta38=1;
				valoresInicialesArr(pieza,cara,color);
				contarVariablesPer(color);
			}
			break;
		
		case  4.1:
			if(conta41 == 0){
				conta41=1;
				valoresInicialesArr(pieza,cara,color);
				contarVariablesPer(color);
			}
			break;
		case  4.2:
			if(conta42 == 0){
				conta42=1;
				valoresInicialesArr(pieza,cara,color);
				contarVariablesPer(color);
			}

			break;
		case  4.3:
			if(conta43 == 0){
				conta43=1;
				valoresInicialesArr(pieza,cara,color);
				contarVariablesPer(color);
			}

			
			break;
		case  4.4:
			if(conta44 == 0){
				conta44=1;
				valoresInicialesArr(pieza,cara,color);
				contarVariablesPer(color);
			}

			break;
		case  4.5:
			if(conta45 == 0){
				conta45=1;
				valoresInicialesArr(pieza,cara,color);
				contarVariablesPer(color);
			}

			break;
		case  4.6:
			if(conta46 == 0){
				conta46=1;
				valoresInicialesArr(pieza,cara,color);
				contarVariablesPer(color);
			}

			break;
		case  4.7:
			if(conta47 == 0){
				conta47=1;
				valoresInicialesArr(pieza,cara,color);
				contarVariablesPer(color);
			}
			break;
		case  4.8:
			if(conta48 == 0){
				conta48=1;
				valoresInicialesArr(pieza,cara,color);
				contarVariablesPer(color);
			}
			break;
		
		case  5.1:
			if(conta51 == 0){
				conta51=1;
				valoresInicialesArr(pieza,cara,color);
				contarVariablesRes(color);
			}
			break;
			
		case  5.2:
			if(conta52 == 0){
				conta52=1;
				valoresInicialesArr(pieza,cara,color);
				contarVariablesRes(color);
			}
			break;
			
		case  5.3:
			if(conta53 == 0){
				conta53=1;
				valoresInicialesArr(pieza,cara,color);
				contarVariablesRes(color);
			}
			break;
			
		case  5.4:
			if(conta54 == 0){
				conta54=1;
				valoresInicialesArr(pieza,cara,color);
				contarVariablesRes(color);
			}
			break;
			
			
		case 5.5:
			if(conta55 == 0){
				conta55=1;
				valoresInicialesArr(pieza,cara,color);
				contarVariablesRes(color);
			}
			 
			break;
		
		case  6.1:
			if(conta61 == 0){
				conta61=1;
				valoresInicialesArr(pieza,cara,color);
				contarVariablesRes(color);
			}
			break;
			
		case  6.2:
			if(conta62 == 0){
				conta62=1;
				valoresInicialesArr(pieza,cara,color);
				contarVariablesRes(color);
			}
			break;
			
		case  6.3:
			if(conta63 == 0){
				conta63=1;
				valoresInicialesArr(pieza,cara,color);
				contarVariablesRes(color);
			}
			break;
			
		case  6.4:
			if(conta64 == 0){
				conta64=1;
				valoresInicialesArr(pieza,cara,color);
				contarVariablesRes(color);
			}
			break;
			
			
		case 6.5:
			if(conta65 == 0){
				conta65=1;
				valoresInicialesArr(pieza,cara,color);
				contarVariablesRes(color);
			}
			break;
		case  7.1:
			if(conta71 == 0){
				conta71=1;
				valoresInicialesArr(pieza,cara,color);
				contarVariablesRes(color);
			}
			break;
			
		case  7.2:
			if(conta72 == 0){
				conta72=1;
				valoresInicialesArr(pieza,cara,color);
				contarVariablesRes(color);
			}
			break;
			
		case  7.3:
			if(conta73 == 0){
				conta73=1;
				valoresInicialesArr(pieza,cara,color);
				contarVariablesRes(color);
			}
			break;
			
		case  7.4:
			if(conta74 == 0){
				conta74=1;
				valoresInicialesArr(pieza,cara,color);
				contarVariablesRes(color);
			}
			break;
			
			
		case 7.5:
			if(conta75 == 0){
				conta75=1;
				valoresInicialesArr(pieza,cara,color);
				contarVariablesRes(color);
			}
			break;
		case  8.1:
			if(conta81 == 0){
				conta81=1;
				valoresInicialesArr(pieza,cara,color);
				contarVariablesRes(color);
			}
			break;
			
		case  8.2:
			if(conta82 == 0){
				conta82=1;
				valoresInicialesArr(pieza,cara,color);
				contarVariablesRes(color);
			}
			break;
			
		case  8.3:
			if(conta83 == 0){
				conta83=1;
				valoresInicialesArr(pieza,cara,color);
				contarVariablesRes(color);
			}
			break;
			
		case  8.4:
			if(conta84 == 0){
				conta84=1;
				valoresInicialesArr(pieza,cara,color);
				contarVariablesRes(color);
			}
			break;
			
			
		case 8.5:
			if(conta85 == 0){
				conta85=1;
				valoresInicialesArr(pieza,cara,color);
				contarVariablesRes(color);
			}
			break;
	}
		
		
		
	}
			
	
	
	//contadores
	function contarVariablesRes(color){
		//cuentaColor++;//va a contar aca el cuenta color
		if(color == '401'){
			contaResPorExtraer++;
			contaResTotal++;
			cResPorExtraer(contaResPorExtraer,contaResTotal);
		 }else if(color == '400'){
			 contaResProtesis++;
			 contaResTotal++;
			 cResProtesis(contaResProtesis,contaResTotal);
		 }else if(color == '398'){
			 contaResPerdida++;
			 contaResTotal++;
			 cResPerdida(contaResPerdida,contaResTotal);
		 }else if(color == '397'){
			 contaResObturada++;
			 contaResTotal++;
			 cResObturada(contaResObturada,contaResTotal);
		 }else if(color == '396'){
			 contaResCariada++;
			 contaResTotal++;
			 cResCariada(contaResCariada,contaResTotal);
		 }else if(color == '399'){
			 contaResFracturada++;
			 contaResTotal++;
			 cResFracturada(contaResFracturada,contaResTotal);
		 }else if(color == '395'){
			 
		 }
	}
	
	function cResPorExtraer(contaResPorExtraer,contaResTotal){
		resPorExtraer.innerHTML = contaResPorExtraer;
		resTotal.innerHTML = contaResTotal;
		
		$("#cResPorExtraer").val(contaResPorExtraer) ;
		 $("#cResTotal").val(contaResTotal) ;
	}
	
	function cResProtesis(contaResProtesis,contaResTotal){
		 resProtesis.innerHTML = contaResProtesis;
		 resTotal.innerHTML = contaResTotal;
		 
		 $("#cResProtesis").val(contaResProtesis) ;
		 $("#cResTotal").val(contaResTotal) ;
	}
	
	function cResPerdida(contaResPerdida,contaResTotal){
		resPerdida.innerHTML = contaResPerdida;
		 resTotal.innerHTML = contaResTotal;
		 
		 $("#cResPerdida").val(contaResPerdida) ;
		 $("#cResTotal").val(contaResTotal) ;
	}
	
	function cResObturada(contaResObturada,contaResTotal){
		resObturada.innerHTML = contaResObturada;
		 resTotal.innerHTML = contaResTotal;
		 
		 $("#cResObturada").val(contaResObturada) ;
		 $("#cResTotal").val(contaResTotal) ;
	}
	
	function cResCariada(contaResCariada,contaResTotal){
		resCariada.innerHTML = contaResCariada;
		 resTotal.innerHTML = contaResTotal;
		 
		 $("#cResCariada").val(contaResCariada) ;
		 $("#cResTotal").val(contaResTotal) ;
	}
	
	function cResFracturada(contaResFracturada,contaResTotal){
		resFracturada.innerHTML = contaResFracturada;
		 resTotal.innerHTML = contaResTotal;
		 
		 $("#cResFracturada").val(contaResFracturada) ;
		 $("#cResTotal").val(contaResTotal) ;
	}
	
	function cPerPorExtraer(contaPerPorExtraer,contaPerTotal){
		 perPorExtraer.innerHTML=contaPerPorExtraer;
		 perTotal.innerHTML = contaPerTotal;
	 
		 $("#cPerPorExtraer").val(contaPerPorExtraer) ;
		 $("#cPerTotal").val(contaPerTotal) ;
	}
	
	
	function cPerProtesis(contaPerProtesis,contaPerTotal){
		 perProtesis.innerHTML = contaPerProtesis;
		 perTotal.innerHTML = contaPerTotal;
			
		 $("#cPerProtesis").val(contaPerProtesis) ;
		 $("#cPerTotal").val(contaPerTotal) ;
	}
	
	function cPerPerdida(contaPerPerdida,contaPerTotal){
		 perPerdida.innerHTML = contaPerPerdida;
		 perTotal.innerHTML = contaPerTotal;
			
		 $("#cPerPerdida").val(contaPerPerdida) ;
		 $("#cPerTotal").val(contaPerTotal) ;
	}
	
	function cPerObturada(contaPerObturada,contaPerTotal){
		 perObturada.innerHTML = contaPerObturada;
		 perTotal.innerHTML = contaPerTotal;
			
		 $("#cPerObturada").val(contaPerObturada) ;
		 $("#cPerTotal").val(contaPerTotal) ;

	}
	
	function cPerCariada(contaPerCariada,contaPerTotal){
		 perCariada.innerHTML = contaPerCariada;					
		 perTotal.innerHTML = contaPerTotal;
		
		 $("#cPerCariada").val(contaPerCariada) ;
		 $("#cPerTotal").val(contaPerTotal) ;
	}
	
	function cPerFracturada(contaPerFracturada,contaPerTotal){
		 perFracturada.innerHTML = contaPerFracturada;
		 perTotal.innerHTML = contaPerTotal;
		
		 $("#cPerFracturada").val(contaPerFracturada) ;
		 $("#cPerTotal").val(contaPerTotal) ;
	}
			
	
	function contarVariablesPer(color){
	
		 if(color == '401'){
			 contaPerPorExtraer++;
			 contaPerTotal++;
			 cPerPorExtraer(contaPerPorExtraer,contaPerTotal);
		 }else if(color == '400'){
			 contaPerProtesis++;
			 contaPerTotal++;
			 cPerProtesis(contaPerProtesis,contaPerTotal);
		 }else if(color == '398'){
			 contaPerPerdida++;
			 contaPerTotal++;
			 cPerPerdida(contaPerPerdida,contaPerTotal);
		 }else if(color == '397'){
			 contaPerObturada++;
			 contaPerTotal++;
			 cPerObturada(contaPerObturada,contaPerTotal);
		 }else if(color == '396'){
			 contaPerCariada++;
			 contaPerTotal++;
			 cPerCariada(contaPerCariada,contaPerTotal);
		 }else if(color == '399'){
			 contaPerFracturada++;
			 contaPerTotal++;
			 cPerFracturada(contaPerFracturada,contaPerTotal);
		 }else if(color == '395'){
			 
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
	

	
})(jQuery);