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
		if(color == porextraer){
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
		if(color == porextraer){
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
		if(color == porextraer){
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
	
		 if(color == porextraer){
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
	