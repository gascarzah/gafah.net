$(function(){
	function EdicionOdontograma(){
		
		var self = this;

		self.tratamientosPosibles = ko.observableArray([]);
		self.tratamientoSeleccionado = ko.observable(null);
		self.tratamientosAplicados = ko.observableArray([]);

		self.quitarTratamiento = function(tratamiento){
			self.tratamientosAplicados.remove(tratamiento);			
			$("#odontograma1").odontograma('removeTratamiento', tratamiento);
		}

		self.guardar = function(){
			var tratamientos = $("#odontograma1").odontograma('getTratamientosAplicados');
			console.log(JSON.stringify(tratamientos));
			$.post("guardar.aspx", tratamientos, function(r){ console.log(r);}, "json");
		}

		self.tratamientoSeleccionado.subscribe(function(tratamiento){
			$("#odontograma1").odontograma('setTratamiento', tratamiento);
		});
	}


	var vm = new EdicionOdontograma();	
	ko.applyBindings(vm);

	$("#odontograma1").odontograma().bind('tratamientoAplicado.odontograma', function(evt, tratamiento){
		vm.tratamientosAplicados.push(tratamiento);
	});
})