//
//function aparOrt11Sup(svg,g3){
//	svg.polyline(g3,[[0,-35], [12,-45], [22.5,-35] ]);
//}
//
//function aparOrt21Sup(svg,g3){
//	svg.polyline(g3,[[-2.5,-35], [8,-45], [20,-35] ]);
//}
//
//function apartOrtComunSup(svg,g3){
//	svg.polyline(g3,[[0,-35], [10,-45], [20,-35] ]);
//}
//
//function aparOrt41Inf(svg,g3){
//	svg.polyline(g3,[[0,55], [12,65], [22.5,55] ]);
//}
//function aparOrt31Inf(svg,g3){
//	svg.polyline(g3,[[-2.5,55], [8,65], [20,55] ]);
//}
//function apartOrtComunInf(svg,g3){
//	svg.polyline(g3,[[0,55], [10,65], [20,55] ]);
//}
//
////para protesis removible
//function protRem11Sup(svg,g3){
//	svg.line(g3, 0, -35, 22.5, -35);
//	svg.line(g3, 0, -40, 22.5, -40);
//}
//
//function protRem21Sup(svg,g3){
//	svg.line(g3, -2.5, -35, 20, -35);
//	svg.line(g3, -2.5, -40, 20, -40);
//}
//
//function protRemComunSup(svg,g3){
//	svg.line(g3, 0, -35, 20, -35);
//	svg.line(g3, 0, -40, 20, -40);
//}
//
//function protRem41Inf(svg,g3){
//	svg.line(g3, 0, 55, 22.5, 55);
//	svg.line(g3, 0, 60, 22.5, 60);
//}
//function protRem31Inf(svg,g3){
//	svg.line(g3, -2.5, 55, 20, 55);
//	svg.line(g3, -2.5, 60, 20, 60);
//}
//function protRemComunInf(svg,g3){
//	svg.line(g3, 0, 55, 20, 55);//Horizontal inferior
//	svg.line(g3, 0, 60, 20, 60);
//}
//
////protesis total
//function protTot11Sup(svg,g3){
//	svg.line(g3, 0, 8, 22.5, 8);
//	svg.line(g3, 0, 12, 22.5, 12);
//}
//
//function protTot21Sup(svg,g3){
//	svg.line(g3, -2.5, 8, 20, 8);
//	svg.line(g3, -2.5, 12, 20, 12);
//}
//
//function protTotComunSup(svg,g3){
//	svg.line(g3, 0, 8, 20, 8);
//	svg.line(g3, 0, 12, 20, 12);
//}
//
//function protTot41Inf(svg,g3){
//	svg.line(g3, 0, 8, 22.5, 8);
//	svg.line(g3, 0, 12, 22.5, 12);
//}
//function protTot31Inf(svg,g3){
//	svg.line(g3, -2.5, 8, 20, 8);
//	svg.line(g3, -2.5, 12, 20, 12);
//}
//function protTotComunInf(svg,g3){
//	svg.line(g3, 0, 8, 20, 8);//Horizontal inferior
//	svg.line(g3, 0, 12, 20, 12);
//}
//
//function edentuloTotComun(svg,g3){
//	svg.line(g3, 0, 10, 20, 10);
//}
//
//function edentuloTotIzq(svg,g3){
//	svg.line(g3, 0, 10, 22.5, 10);
//}
//
//function edentuloTotDer(svg,g3){
//	svg.line(g3, -2.5, 10, 20, 10);
//}
//
//
//function crearFiguraSinExtremos(svg,diente,opt,color){
//		var g = svg.group({transform: 'scale('+scale+')',id: diente.id});
//		var g2 = svg.group(g, {transform: 'translate('+diente.x+','+diente.y+')'}); 
//		var g3 = svg.group(g2, {fill: 'none', stroke: color, strokeWidth: 1, style: 'font-size: 6pt;font-weight:normal'});
//				
//
//	switch (diente.id) {
//	case 1.1:
//		if (opt == aparOrtRem || opt == aparOrtRemMal) {
//			aparOrt11Sup(svg, g3);
//		} else if (opt == protRemovible || opt == protRemovibleMal) {
//			protRem11Sup(svg, g3);
//		} else if (opt == protTotal || opt == protTotalMal) {
//			protTot11Sup(svg, g3);
//		} else if (opt == edentuloTotal) {
//			edentuloTotIzq(svg, g3);
//		}
//
//		break;
//	case 2.1:
//
//		if (opt == aparOrtRem || opt == aparOrtRemMal) {
//			aparOrt21Sup(svg, g3);
//		} else if (opt == protRemovible || opt == protRemovibleMal) {
//			protRem21Sup(svg, g3);
//		} else if (opt == protTotal || opt == protTotalMal) {
//			protTot21Sup(svg, g3);
//		} else if (opt == edentuloTotal) {
//			edentuloTotDer(svg, g3);
//		}
//
//		break;
//
//	case 4.1:
//		if (opt == aparOrtRem || opt == aparOrtRemMal) {
//			aparOrt41Inf(svg, g3);
//		} else if (opt == protRemovible || opt == protRemovibleMal) {
//			protRem41Inf(svg, g3);
//		} else if (opt == protTotal || opt == protTotalMal) {
//			protTot41Inf(svg, g3);
//		} else if (opt == edentuloTotal) {
//			edentuloTotIzq(svg, g3);
//		}
//
//		break;
//
//	case 3.1:
//
//		if (opt == aparOrtRem || opt == aparOrtRemMal) {
//			aparOrt31Inf(svg, g3);
//		} else if (opt == protRemovible || opt == protRemovibleMal) {
//			protRem31Inf(svg, g3);
//		} else if (opt == protTotal || opt == protTotalMal) {
//			protTot31Inf(svg, g3);
//		} else if (opt == edentuloTotal) {
//			edentuloTotDer(svg, g3);
//		}
//
//		break;
//
//	default:
//		if (isCuadranteSuperior(diente)) {
//			if (opt == aparOrtRem || opt == aparOrtRemMal) {
//				apartOrtComunSup(svg, g3);
//			} else if (opt == protRemovible || opt == protRemovibleMal) {
//				protRemComunSup(svg, g3);
//			} else if (opt == protTotal || opt == protTotalMal) {
//				protTotComunSup(svg, g3);
//			} else if (opt == edentuloTotal) {
//				edentuloTotComun(svg, g3);
//			}
//
//		} else if (isCuadranteInferior(diente)) {
//
//			if (opt == aparOrtRem || opt == aparOrtRemMal) {
//				apartOrtComunInf(svg, g3);
//			} else if (opt == protRemovible || opt == protRemovibleMal) {
//				protRemComunInf(svg, g3);
//			} else if (opt == protTotal || opt == protTotalMal) {
//				protTotComunInf(svg, g3);
//			} else if (opt == edentuloTotal) {
//				edentuloTotComun(svg, g3);
//			}
//		}
//		break;
//	}	
//
//		
//}
//
//
//function crearLineaEntreExtremos(svg,diente,color){
//	var g = svg.group({transform: 'scale('+scale+')',id: diente.id});
//	var g2 = svg.group(g, {transform: 'translate('+diente.x+','+diente.y+')'}); 
//	var g3 = svg.group(g2, {fill: 'none', stroke: color, strokeWidth: 1, style: 'font-size: 6pt;font-weight:normal'});
//	
//	switch(diente.id){	
//	case 1.1:
//		svg.line(g3, 0, -35, 22.5, -35);
//		break;
//	
//	case 2.1:
//		svg.line(g3, -2.5, -35, 20, -35);
//		break;	
//	
//	case 3.1:
//		svg.line(g3, -2.5, 55, 20, 55);
//		break;
//	
//	case 4.1:
//		svg.line(g3, 0, 55, 22.5, 55);
//		break;
//	default:
//		if (isCuadranteSuperior(diente)) {
//			svg.line(g3, 0, -35, 20, -35);
//		} else if (isCuadranteInferior(diente)) {
//			svg.line(g3, 0, 55, 20, 55);
//		}
//		break;
//	}
//
//	
//}
//
//function aparOrtSup(svg,diente, lado,g3){
//
//	svg.polygon(g3,[[5,-40], [5,-30], [15,-30], [15,-40]]); //vertical superior
//	svg.line(g3, 10, -33, 10, -37);				//vertical superior
//	svg.line(g3, 13, -35, 7, -35);				//Horizontal superior
//
//
//	if(lado == lad_izquierdo){
//		if(diente.id == 1.1){
//			svg.line(g3, 15, -35, 22.5, -35);				
//		}else{
//			svg.line(g3, 15, -35, 20, -35);				//Horizontal superior inicial coninua izquierdo
//		}
//	}else{
//		if(diente.id == 2.1){
//			svg.line(g3, 5, -35, -2.5, -35);				
//		}else{
//			svg.line(g3, 5, -35, 0, -35);				//Horizontal superior inicial coninua derecho
//		}
//		
//	}
//	
//	
////	switch(diente.id){	
////	case 1.1:
////		svg.line(g3, 15, -35, 22.5, -35);
////		break;
////	
////	case 2.1:
////		svg.line(g3, 5, -35, -2.5, -35);
////		break;	
////	
////	default:
////		if(lado == lad_izquierdo){
////			svg.line(g3, 15, -35, 20, -35);
////		} else {
////			svg.line(g3, 5, -35, 0, -35);
////		}
////		break;
////	}
//	
//}
//
//
//function aparOrtInf(svg,diente, lado,g3){
//
//	svg.polygon(g3,[[5,60], [5,50], [15,50], [15,60]]); //vertical inferior
//	svg.line(g3, 10, 53, 10, 57);				//vertical inferior
//	svg.line(g3, 13, 55, 7, 55);				//Horizontal inferior
//
//
//	if(lado == lad_izquierdo){
//
//		if(diente.id == 4.1){
//			svg.line(g3, 15, 55, 22.5, 55);				
//		}else{
//			svg.line(g3, 15, 55, 20, 55);				//Horizontal inferior inicial continua izquierdo
//		}
//		
//	}else{
//
//		if(diente.id == 3.1){
//			svg.line(g3, 5, 55, -2.5, 55);				
//		}else{
//			svg.line(g3, 5, 55, 0, 55);				//Horizontal inferior inicial continua derecho
//		}
//	}
//	
////	switch(diente.id){	
////	case 4.1:
////		svg.line(g3, 15, 55, 22.5, 55);
////		break;
////	
////	case 3.1:
////		svg.line(g3, 5, 55, -2.5, 55);
////		break;	
////	
////	default:
////		if(lado == lad_izquierdo){
////			svg.line(g3, 15, 55, 20, 55);
////		} else {
////			svg.line(g3, 5, 55, 0, 55);	
////		}
////		break;
////	}
//	
//	
//}
//
//
//function protFijaSup(svg,diente, lado,g3){
//
//	svg.line(g3, 10, -30, 10, -35);
//	
//	if (lado == lad_izquierdo) {
//		
//		if (diente.id == 1.1) {
//			svg.line(g3, 10, -35, 22.5, -35);
//			
//		} else {
//			svg.line(g3, 10, -35, 20, -35); // Horizontal superior
//											// inicial coninua izquierdo
//		}
//	} else {
//
//		if (diente.id == 2.1) {
//			svg.line(g3, 10, -35, -2.5, -35);
//			
//		} else {
//			svg.line(g3, 10, -35, 0, -35); // Horizontal superior
//											// inicial coninua derecho
//		}
//	}
//
////	switch(diente.id){	
////	case 1.1:
////		svg.line(g3, 10, -35, 22.5, -35);
////		break;
////	
////	case 2.1:
////		svg.line(g3, 10, -35, -2.5, -35);
////		break;	
////	
////	default:
////		if(lado == lad_izquierdo){
////			svg.line(g3, 10, -35, 20, -35);
////		} else {
////			svg.line(g3, 10, -35, 0, -35);
////		}
////		break;
////	}
//
//}
//
//function protFijaInf(svg,diente, lado,g3){
//
//	svg.line(g3, 10, 50, 10, 55);
//
//	if (lado == lad_izquierdo) {
//
//		if (diente.id == 4.1) {
//			svg.line(g3, 10, 55, 22.5, 55);
//		} else {
//			svg.line(g3, 10, 55, 20, 55); 
//		}
//
//	} else {
//
//		if (diente.id == 3.1) {
//			svg.line(g3, 10, 55, -2.5, 55);
//		} else {
//			svg.line(g3, 10, 55, 0, 55); 
//		}
//	}
//
//	
//
////	switch(diente.id){	
////	case 4.1:
////		svg.line(g3, 10, 55, 22.5, 55);
////		break;
////	
////	case 3.1:
////		svg.line(g3, 10, 55, -2.5, 55);
////		break;	
////	
////	default:
////		if(lado == lad_izquierdo){
////			svg.line(g3, 10, 55, 20, 55);
////		} else {
////			svg.line(g3, 10, 55, 0, 55);
////		}
////		break;
////	}
//
//}
//
//function fusionSup(svg,diente,lado,g3){
//	if (lado == lad_izquierdo) {
////		console.debug("entro a lado izquierdo fusion")
//		if (diente.id == 1.1) {
//			svg.ellipse(g3, 13,-25 , 11, 8);
//			
//		} else {
//			svg.ellipse(g3, 12.5,-25 , 11, 8); 
//		}
//	} else {
////		console.debug("entro a lado izquierdo fusion")
//		if (diente.id == 2.1) {
//			svg.ellipse(g3, 5,-25 , 11, 8);
//			
//		} else {
//			svg.ellipse(g3, 7.5,-25 , 11, 8);
//		}
//	}
//	
//}
//
//function fusionInf(svg,diente,lado,g3){
//	if (lado == lad_izquierdo) {
//		
//		if (diente.id == 4.1) {
//			svg.ellipse(g3, 13,43 , 11, 8);
//			
//		} else {
//			svg.ellipse(g3, 12.5,43 , 11, 8); 
//		}
//	} else {
//
//		if (diente.id == 3.1) {
//			svg.ellipse(g3, 5,43 , 11, 8);
//			
//		} else {
//			svg.ellipse(g3, 7.5,43 , 11, 8);
//		}
//	}
//	
//	
//	
//}
//
//
//
//function crearExtremos(svg,diente,lado,opt,color){
//	console.debug("entro CON OPCION "+opt)
//	
//	var g = svg.group({transform: 'scale('+scale+')',id: diente.id});
//	var g2 = svg.group(g, { transform: 'translate('+diente.x+','+diente.y+')'}); 
//	var g3 = svg.group(g2, {fill: 'none', stroke: color, strokeWidth: 1, style: 'font-size: 6pt;font-weight:normal'});
//
//	
//	if(isCuadranteSuperior(diente)){
//		
//		switch (opt) {
//		case aparOrtFijo:
//			aparOrtSup(svg,diente, lado,g3);
//			break;
//
//		case aparOrtFijoMal:
//			aparOrtSup(svg,diente, lado,g3);
//		
//			break;
//			
//		case protFija:
//			protFijaSup(svg,diente, lado,g3);
//		
//			break;
//
//		case protFijaMal:
//			protFijaSup(svg,diente, lado,g3);
//			break;
//		
//		case fusion:
//			fusionSup(svg,diente,lado,g3);
//				
//			
//			break;
//			
//		case diastema:
//
//			var path = svg.createPath();
//			
//			if (diente.id == 1.1) {
//					svg.path(g3, path.move(20,0).curveC(22.5,5 , 22.5,15 ,  20,20));//curva derecha
//				
//			} else if (diente.id == 2.1) {
//					svg.path(g3, path.move(0,0).curveC(-2.5,5 , -2.5,15 ,  0,20));
//
//			}
//				
//			
//			break;
//	
//		case transposicion:
//			var path = svg.createPath();
//			
//			if (lado == lad_izquierdo) {
//					svg.path(g3, path.move(0,-30).curveC(7.5,-40 , 21.5,-40 ,  30,-30));
//					svg.polygon(g3,[[27,-30], [30,-30], [29,-34]]);
//				
//			} else {
//
//					svg.path(g3, path.move(20,-30).curveC(12.5,-40 , -2.5,-40 ,  -10,-30));
//					svg.polygon(g3,[[-7,-30], [-10,-30], [-10,-34]]);
//
//			}
//			
//			break;
//			
//		case supernumerario:
//			
//			if (lado == lad_izquierdo) {
//				if (diente.id == 1.1) {
//					svg.circle(g3,22.5,-30,5.5); 
//					svg.text(g3, 21,-28, 'S', {fontSize: 6});
//				} else {
//					svg.circle(g3,20,-30,5); //corona temporal
//					svg.text(g3, 18.5,-28, 'S',{fontSize: 6}); 
//				}
//			
//			}
//			break;
//			
//		default:
//			break;
//		}
//		
//				
//	}else if(isCuadranteInferior(diente)){
//		
//		switch (opt) {
//		case aparOrtFijo:
//			aparOrtInf(svg,diente, lado,g3);
//			break;
//
//		case aparOrtFijoMal:
//			aparOrtInf(svg,diente, lado,g3);
//			break;
//
//			
//		case protFija:
//			protFijaInf(svg,diente, lado,g3);
//			break;
//
//		case protFijaMal:
//			protFijaInf(svg,diente, lado,g3);
//			
//			break;	
//			
//		case fusion:
//			fusionInf(svg,diente,lado,g3);
//				
//
//			break;
//			
//		case diastema:
//			var path = svg.createPath();
//
//				if (diente.id == 4.1) {
//					svg.path(g3, path.move(20,0).curveC(22.5,5 , 22.5,15 ,  20,20));
//
//				}else if (diente.id == 3.1) {
//					svg.path(g3, path.move(0,0).curveC(-2.5,5 , -2.5,15 ,  0,20));
//
//				}
//
//				break;
//				
//		case transposicion:
//			var path = svg.createPath();
//			
//			if (lado == lad_izquierdo) {
//					svg.path(g3, path.move(0,50).curveC(7.5,60 , 21.5,60 ,  30,50));
//					svg.polygon(g3,[[27,50], [30,50], [29,54]]);
//				
//			} else {
//
//					svg.path(g3, path.move(20,50).curveC(12.5,60 , -2.5,60 ,  -10,50));
//					svg.polygon(g3,[[-7,50], [-10,50], [-10,54]]);
//
//			}
//
//			break;
//			
//		case supernumerario:
//
//			
//			if (lado == lad_izquierdo) {
//				if (diente.id == 4.1) {
//					svg.circle(g3,22.5,50,5.5); 
//					svg.text(g3, 21,52, 'S', {fontSize: 6});
//				} else {
//					svg.circle(g3,20,50,5); //corona temporal
//					svg.text(g3, 18.5,52, 'S',{fontSize: 6}); 
//				}
//			
//			}
//			
//			break;
//			
//		default:
//			break;
//		}
//
//
//	}
//	
//}
//
//
//
//function isCuadranteSuperior(diente){
//	if(diente.id == 1.8 || diente.id == 1.7 || diente.id == 1.6 || diente.id == 1.5 || diente.id == 1.4 || diente.id == 1.3 || diente.id == 1.2 || diente.id == 1.1 || 
//			   diente.id == 2.8 || diente.id == 2.7 || diente.id == 2.6 || diente.id == 2.5 || diente.id == 2.4 || diente.id == 2.3 || diente.id == 2.2 || diente.id == 2.1){
//		return true;
//	}
//	
//	return false;
//}
//
//
//function isCuadranteInferior(diente){
//	if(diente.id == 4.8 || diente.id == 4.7 || diente.id == 4.6 || diente.id == 4.5 || diente.id == 4.4 || diente.id == 4.3 || diente.id == 4.2 || diente.id == 4.1 || 
//			   diente.id == 3.8 || diente.id == 3.7 || diente.id == 3.6 || diente.id == 3.5 || diente.id == 3.4 || diente.id == 3.3 || diente.id == 3.2 || diente.id == 3.1){
//		return true;
//	}
//	return false;
//}
//
//function isCuadranteSuperiorTotal(diente){
//	if(diente.id == 1.8 || diente.id == 1.7 || diente.id == 1.6 || diente.id == 1.5 || diente.id == 1.4 || diente.id == 1.3 || diente.id == 1.2 || diente.id == 1.1 || 
//	   diente.id == 2.8 || diente.id == 2.7 || diente.id == 2.6 || diente.id == 2.5 || diente.id == 2.4 || diente.id == 2.3 || diente.id == 2.2 || diente.id == 2.1 ||
//	   diente.id == 5.5 || diente.id == 5.4 || diente.id == 5.3 || diente.id == 5.2 || diente.id == 5.1 ||
//	   diente.id == 6.1 || diente.id == 6.2 || diente.id == 6.3 || diente.id == 6.4 || diente.id == 6.5 ){
//		return true;
//	}
//	
//	return false;
//}
//
//
//function isCuadranteInferiorTotal(diente){
//	if(diente.id == 4.8 || diente.id == 4.7 || diente.id == 4.6 || diente.id == 4.5 || diente.id == 4.4 || diente.id == 4.3 || diente.id == 4.2 || diente.id == 4.1 || 
//	   diente.id == 3.8 || diente.id == 3.7 || diente.id == 3.6 || diente.id == 3.5 || diente.id == 3.4 || diente.id == 3.3 || diente.id == 3.2 || diente.id == 3.1 || 
//	   diente.id == 8.5 || diente.id == 8.4 || diente.id == 8.3 || diente.id == 8.2 || diente.id == 8.1 ||
//	   diente.id == 7.5 || diente.id == 7.4 || diente.id == 7.3 || diente.id == 7.2 || diente.id == 7.1 ){
//		return true;
//	}
//	return false;
//}
//
//function pernoMunon(svg,diente,g3){
////	console.debug("entro a pintar munon")
//	svg.polygon(g3,[[5,5], [15,5], [15,15], [5,15]]);
////	console.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> antes de entrar a muñon")
//    if(isCuadranteSuperiorTotal(diente)){
//    	svg.line(g3, 10, 5, 10, -15);  			
////    	console.debug("paso primer cuadrante munon")
//	}else if(isCuadranteInferiorTotal(diente)){
//		svg.line(g3, 10, 15, 10, 35);  			//PERNO MUÑON
////		console.debug("paso ultimo cuadrante munon")
//	}
//}
//
//function crearFiguraIndividual(svg,diente,opt,color){
//	var g = svg.group({transform: 'scale('+scale+')',id: diente.id});
//	var g2 = svg.group(g, { transform: 'translate('+diente.x+','+diente.y+')'}); //, onclick : 'borrar('+diente.id+','+opt+')' 
//	var g3 = svg.group(g2, {fill: 'none', stroke: color, strokeWidth: 1, style: 'font-size: 6pt;font-weight:normal'}); 
////	console.debug(">>>>>>>>>>>>>>> crearFiguraIndividual")
////	console.debug(" opt = "+opt)
//	switch (opt) {
//	
//	case fractura:
//		
//		if(isCuadranteSuperiorTotal(diente)){
//			svg.line(g3, 0, 20, 20, -15,{id: diente.id});  			//FRACTURA	ABAJO			
//		}else if(isCuadranteInferiorTotal(diente)){
//			svg.line(g3, 0, 35, 20, 0,{id: diente.id});  			//FRACTURA	ARRIBA
//		}
//		
//		break;
//		
//	case ausente:
//		 
//	    if(isCuadranteSuperiorTotal(diente)){
//	    	svg.line(g3, 0, -15, 20, 20);
//		    svg.line(g3, 0, 20, 20, -15);  			//EXTRACCION	
//		    
//		}else if(isCuadranteInferiorTotal(diente)){
//			svg.line(g3, 0, 0, 20, 35);
//		    svg.line(g3, 0, 35, 20, 0);  			//EXTRACCION	
//		}
//	    
//	    break;
//	case pulpar:
//		
//	    if(isCuadranteSuperiorTotal(diente)){
//	    	svg.line(g3, 10, 10, 10, -15);  			//TRATAMIENTO PULPAR
//	    	
//		}else if(isCuadranteInferiorTotal(diente)){
//			svg.line(g3, 10, 10, 10, 35);  			//TRATAMIENTO PULPAR     
//		}
//	    break;
//	    
//	case munon:
//		console.debug("antes de pintar munon")
//		pernoMunon(svg,diente,g3);
//	    break;
//
//	case munonMal:
//		
//		pernoMunon(svg,diente,g3);
//	    break;
//	    
//	case clavija:
//
//	    if(isCuadranteSuperiorTotal(diente)){
//		    svg.polygon(g3,[[10,-34], [0,-18], [20,-18]]);//DIENTE EN CLAVIJA
//	    	
//		}else if(isCuadranteInferiorTotal(diente)){
//		    svg.polygon(g3,[[10,35], [0,48], [20,48]]);//DIENTE EN CLAVIJA
//		}
//				 
//	    break;
//	    
//	case remanente: 
//
//	    if(isCuadranteSuperiorTotal(diente)){
//	    	svg.text(g3,5,-5,'RR');
//	    	
//		}else if(isCuadranteInferiorTotal(diente)){
//			svg.text(g3,5,30,'RR');
//		}
//				    
//	    break;
//
//	case extruido: //DIENTE EXTRUIDO
//
//	    if(isCuadranteSuperiorTotal(diente)){
//			svg.line(g3, 10, 21, 10, 30);
//			svg.polygon(g3,[[10,30], [8,27], [12,27]]);
//			
//		}else if(isCuadranteInferiorTotal(diente)){
//			svg.line(g3, 10, -1, 10, -10);
//			svg.polygon(g3,[[10,-10], [8,-7], [12,-7]]);
//			
//		}
//				    
//	    break;
//
//	case intruido: //DIENTE INTRUIDO
//	    if(isCuadranteSuperiorTotal(diente)){
//			svg.line(g3, 10, 21, 10, 30);
//			svg.polygon(g3,[[10,21], [8,24], [12,24]]);
//			
//		}else if(isCuadranteInferiorTotal(diente)){
//			svg.line(g3, 10, -1, 10, -10);
//			svg.polygon(g3,[[10,-1], [8,-4], [12,-4]]);
//			
//		}
//				    
//	    break;
//	    
//	case erupcion: //DIENTE ERUPCIÓN
//
//	    if(isCuadranteSuperiorTotal(diente)){
//			svg.polyline(g3,[[0,-10], [20,-5], [0,0], [20,5], [0,10], [10,15], [10,20], [12,18], [8,18], [10,20]]); 
//	    	
//		}else if(isCuadranteInferiorTotal(diente)){
//			svg.polyline(g3,[[0,30], [20,25], [0,20], [20,15], [0,10], [10,5], [10,0], [12,2], [ 8,2], [ 10,0]]);
//			
//		}
//				    
//	    break;
//	
//	case coronaDefinitiva:
//
//		marcarCorona(g3, svg)
//				    
//	    break;
//	    
//	case coronaTemporal:
//
//		marcarCorona(g3, svg);
//				    
//	    break;
//	    
//	case migracion: //DIENTE ERUPCIÓN
//
//	    if(isCuadranteSuperiorTotal(diente)){
//	    	svg.line(g3, 0, 25, 20, 25);				
//			svg.polygon(g3,[[20,25], [18,23], [18,27]]); 
//	    	
//		}else if(isCuadranteInferiorTotal(diente)){
//			svg.line(g3, 0, -5, 20, -5);				 
//			svg.polygon(g3,[[20,-5], [18,-3], [18,-7]]);  
//			
//		}
//				    
//	    break;
//	
//	case giroversion: 
//
//		var path = svg.createPath();
//
//	    if(isCuadranteSuperiorTotal(diente)){
//			svg.path(g3, path.move(0,25).curveC(5,30 , 15,30 ,  20,25));
//			svg.polyline(g3,[[17,24], [20,25], [19,29]]); 
//	    	
//		}else if(isCuadranteInferiorTotal(diente)){
//			svg.path(g3, path.move(0,-5).curveC(5,-10 , 15,-10 ,  20,-5));
//			svg.polyline(g3,[[17,-4], [20,-5], [19,-9]]); 
//			
//		}
//				    
//	    break;
// 
//		
//	case sellantes:
////		var surface = svg.rect(0, 0, '100%', '100%', {id: 'surface', fill: 'white'}); 
////        $(surface).mousedown(startDrag).mousemove(dragging).mouseup(endDrag); 
////        resetSize(svg, '100%', '100%'); 
//        
//		break;
//	}  
//}	
//
//
//
//	function marcarCorona(g, svg){
//		svg.circle(g,10,10,10); //corona temporal
//	}
//	
//
//
//function marcadas(){
//
//	console.debug("arrIndPos  luego de agregar "+arrIndPos);
//    console.debug("arrIndOptMarc  luego de agregar "+arrIndOptMarc);
//	console.debug("arrExtOptMarc luego de agregar "+arrExtOptMarc);
//	console.debug("arrExtPosIni  luego de agregar "+arrExtPosIni);
//	console.debug("arrExtPosFin  luego de agregar "+arrExtPosFin);
//	
//	//para las opciones de los costados marcada
//	$("#vPiezasIndMark").val(arrIndPos) ;
//	$("#vOptIndMark").val(arrIndOptMarc) ;
//	$("#vOptExtMark").val(arrExtOptMarc) ;
//	$("#vPiezasIniExtMark").val(arrExtPosIni) ;
//	$("#vPiezasFinExtMark").val(arrExtPosFin) ;
//	
//}
//
//function agregarMarcasExtremos(ini,fin,opt){
//	arrExtOptMarc.push(opt);//opcion marcada
//	arrExtPosIni.push(ini);
//	arrExtPosFin.push(fin);
//
//	marcadas();
//}
//
//function agregarMarcasIndividuales(ini,opt){
//
//	 
//	 arrIndPos.push(ini);
//	 arrIndOptMarc.push(opt);
//	 
//	 marcadas();
//}
//
//
//function eliminarFiguraIndividual(posi,id){
//	var flag = false;
//	for (var i = 0; i < arrIndPos.length; i++) {
//		if (arrIndPos[i] == posi) {
//			arrIndPos.splice(i, 1);
//			arrIndOptMarc.splice(i, 1);
//			flag = true;
//			console.debug("Elimina "+id)
//			eliminarFigura(id);
//			break;
//		}
//	}
//	return flag;
//}
//
//function borrarFigura(diente,opt){
//	var posi =  obtenerPosicion(diente.id);
//
//	var flag = false;
//	//si la posicion que ingreso forma parte de un rango
//	if(arrExtPosIni.length > 0){	
//		for(var i=0; i < arrExtPosIni.length ; i++){
//			if(arrExtPosIni[i] <= posi && posi <= arrExtPosFin[i]){
//				ini = arrExtPosIni[i];
//				fin =  arrExtPosFin[i];
//			
//				arrExtPosIni.splice(i, 1);
//				arrExtPosFin.splice(i, 1);
//				arrExtOptMarc.splice(i, 1);
//				
//				for (var i = ini; i <= fin; i++) {
//					console.debug("elimina posi ="+i+" diente "+tempDientes[i])
//					eliminarFigura(tempDientes[i]);
//					
//				}
//				break;
//			}
//		}
//	}
//	
//	if (arrIndPos.length > 0) {
//		flag = eliminarFiguraIndividual(posi,diente.id);
//		
//	}
//
//	
//}
//
////para borrar las figuras entre extremos 05122016
//function borrarFigurasEnRangos(ini,fin,opt){
//	console.debug("inicio = "+ini)
//	console.debug("fin = "+fin)
//	var posi = 0;
//	var fdel = false;
//	//buscar en el nuevo rrango las  marcas individuales en el arreglo de marcas inviduales
//	if(arrIndPos.length > 0){
//		for (var i = ini; i <= fin; i++) {
//			for(var x = 0; x < arrIndPos.length; x++){
//				if(i == arrIndPos[x] ){
//					console.debug("entro a marca invidual")
//					arrIndPos.splice(x, 1);
//					arrIndOptMarc.splice(x, 1);
//					eliminarFigura(tempDientes[i]);
//					break;
//				}
//			}
//		}
//		console.debug("arr Posiciones Figuras Individuales ="+arrIndPos)
//		console.debug("arr Opciones Individuales  Marcadas="+arrIndOptMarc)
//	}
//	
//	
//	//buscar los extremos dentro de los arreglos de los extremos inicial y final
////	var tini =0;
////	var tfin =0;
//	if(arrExtPosIni.length > 0){
//
//		eliminarRango(ini);
//		eliminarRango(fin);
//		eliminarRangosInternos(ini, fin, arrExtPosIni);
////		console.debug("elimina rango interno arrExtPosIni")
//		eliminarRangosInternos(ini, fin, arrExtPosFin);
////		console.debug("elimina rango interno arrExtPosFini")
//
//
//	}
//}
//
//function eliminarRangosInternos(ini, fin, arrExt){
//	var fdel = false;
//	for(var i=0; i < arrExt.length ; i++){
//		if( ini <= arrExt[i] && arrExt[i] <= fin){
//			arrExtPosIni.splice(i, 1);
//			arrExtPosFin.splice(i, 1);
//			arrExtOptMarc.splice(i, 1);
//			
//			for (var i = ini; i <= fin; i++) {
//				console.debug("elimina posi ="+i+" diente "+tempDientes[i])
//				eliminarFigura(tempDientes[i]);
//				
//			}
//			fdel = true;
//			break;
//		}
//		
//	}
//	
//	
//	return fdel;
//}
//
//function eliminarRango(posi){
//	console.debug("inicial arrIni ="+arrExtPosIni)
//	console.debug("final arrFin ="+arrExtPosFin)
//	console.debug("arrPos ="+arrExtOptMarc)
//	
//	var tini =0;
//	var tfin =0;
//	var fdel = false;
//	for(var i=0; i < arrExtPosIni.length ; i++){
//		if(arrExtPosIni[i] <= posi && posi <= arrExtPosFin[i]){
//			tini = arrExtPosIni[i];
//			tfin =  arrExtPosFin[i];
//			console.debug("rango a eliminar ini ="+tini + " fin = "+tfin)
//			console.debug("arrExtPosIni ="+arrExtPosIni)
//			console.debug("arrExtPosFin ="+arrExtPosFin)
//			console.debug("arrExtOptMarc ="+arrExtOptMarc)
//			arrExtPosIni.splice(i, 1);
//			arrExtPosFin.splice(i, 1);
//			arrExtOptMarc.splice(i, 1);
//			
//			for (var i = tini; i <= tfin; i++) {
//				console.debug("elimina posi ="+i+" diente "+tempDientes[i])
//				eliminarFigura(tempDientes[i]);
//			}
//			fdel = true;
//			break;
//		}
//	
//	}
//	return fdel;
//}
//
//function eliminarFigura(id){
//	
//		$('#odontograma svg g').each(function(){
//
//			if($(this).attr('id') == id){
//				$(this).remove();
//			}
//		});
//}
////se esta quitando validacion de rangos 01/12/2016
//function verificarMarca(ini,fin){
//	var flag = false;
//	
//	if(arrExtPosIni.length == 0 && arrExtPosFin.length == 0){
////		alert("arrposi vacias")
//		arrExtPosIni.push(ini);
//		arrExtPosFin.push(fin);
//		
//	}else{
//		if(!existeEnRango(ini) && !existeEnRango(fin)){
////			alert("no se encuentran en rango")
//			arrExtPosIni.push(ini);
//			arrExtPosFin.push(fin);
//			
//		}else{
//			alert("Extremos existen en otro rango")
//			flag = true;
//			
//		}
//	}
//	
//	return flag;
//}
//
//function existeEnRango(posi,arr){
//	var flag = false;
//	
//	for(var i = 0; i < arrExtPosIni.length; i++){
//		
//		if(arrExtPosIni[i] <= posi && posi <= arrExtPosFin[i]){
//				flag = true;
//				break;
//		}
//		
//	}
//	
//	return flag;
//}