/**
 * 
 */
//Valida que el key sea num�rico. Si no es num�rico, retorna false
function validaNumeros(e)
{
	var keynum
	var keychar
	var numcheck

	if(window.event) // IE
	{
	keynum = e.keyCode;
	}
	else if(e.which) // Netscape/Firefox/Opera
	{
	keynum = e.which;
	}

// NOTE: Backspace = 8, Enter = 13, '0' = 48, '9' = 57, '.' = 46                
	return (keynum <= 13 || (keynum >= 48 && keynum <= 57) || keynum == 46);;
}
//Valida que el key sea num�rico. Si no es num�rico, retorna false
function validaNumeros2(e,admitePunto)
{
	var keynum
	var keychar
	var numcheck

	if(window.event) // IE
	{
	keynum = e.keyCode;
	}
	else if(e.which) // Netscape/Firefox/Opera
	{
	keynum = e.which;
	}

// NOTE: Backspace = 8, Enter = 13, '0' = 48, '9' = 57, '.' = 46
        var resultado
        if(admitePunto)
            resultado=(keynum <= 13 || (keynum >= 48 && keynum <= 57) || keynum == 46);
        else
            resultado=(keynum <= 13 || (keynum >= 48 && keynum <= 57));
	return resultado;
}

//Valida que la cadena sea num�rica.
function esNumerico(campo,descCampo){
    if(isNaN(campo.value))
   {
     alert("El valor ingresado en el campo "+descCampo+ " no es num�rico.");
     campo.value="";
     return (false);
   }
}


//Valida que el key sea num�rico o cadena. Si no es num�rico, retorna false
function validaNumerosyLetras(e)
{
	var keynum
	var keychar
	var numcheck

	if(window.event) // IE
	{
	keynum = e.keyCode;
	}
	else if(e.which) // Netscape/Firefox/Opera
	{
	keynum = e.which;
	}

// NOTE: Backspace = 8, Enter = 13, '0' = 48, '9' = 57,      A-Z								a-z             
	return (keynum <= 13 || (keynum >= 48 && keynum <= 57) || (keynum >= 65 && keynum <= 90) || (keynum >= 97 && keynum <= 122) );
}



//Valida que el key cadena. 
function validaLetras(e)
{
	var keynum
	var keychar
	var numcheck

	if(window.event) // IE
	{
	keynum = e.keyCode;
	}
	else if(e.which) // Netscape/Firefox/Opera
	{
	keynum = e.which;
	}

// NOTE: A-Z								a-z             
	return  ((keynum >= 65 && keynum <= 90) || (keynum >= 97 && keynum <= 122) );
}


//Valida que el key sea num�rico. Si no es num�rico, retorna false
function validaDescOdon(e)
{
	var keynum
	var keychar
	var numcheck

	if(window.event) // IE
	{
	keynum = e.keyCode;
	}
	else if(e.which) // Netscape/Firefox/Opera
	{
	keynum = e.which;
	}
	
	
// NOTE: Backspace = 8, Enter = 13, '0' = 48, '9' = 57,      A-Z								a-z             				 , '/'=47			TAB
	return (keynum <= 13 || (keynum >= 48 && keynum <= 57) || (keynum >= 65 && keynum <= 90) || (keynum >= 97 && keynum <= 122) || keynum == 47 || e.keyCode == 9);
}
