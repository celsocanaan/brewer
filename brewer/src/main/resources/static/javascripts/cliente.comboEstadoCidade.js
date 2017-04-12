var Brewer = Brewer || {};

Brewer.ComboEstado = (function() {
	
	function ComboEstado() {
		this.combo = $('#estado');
		this.emitter = $({}); // Objeto para auxiliar lançar eventos
		this.on = this.emitter.on.bind(this.emitter); // Lança eventos em "iniciar"
	}

	ComboEstado.prototype.iniciar = function() {
		this.combo.on('change', onEstadoAlterado.bind(this));
	}

	function onEstadoAlterado() {
		this.emitter.trigger('alterado', this.combo.val());
	}

	return ComboEstado;
}());

Brewer.ComboCidade = (function() {
	
	function ComboCidade(comboEstado) {
		this.comboEstado = comboEstado;
		this.combo = $('#cidade');
		this.imgLoading = $('.js-img-loading'); // Classe js-img-loading da tela
	}

	ComboCidade.prototype.iniciar = function() {
		reset.call(this);
		this.comboEstado.on('alterado', onEstadoAlterado.bind(this));
	}

	function onEstadoAlterado(evento, id) {
		console.log("Estado alterado: "+id);
		
		if (id) {
			var resposta = $.ajax({
				url : this.combo.data('url'),
				method : 'GET',
				contentType : 'application/json',
				data : {'estado' : id},
				beforeSend : iniciarRequisicao.bind(this),
				complete : finalizarRequisicao.bind(this)
			});
			resposta.done(onBuscarCidadesFinalizado.bind(this));
		} else {
			reset.call(this);
		}
	}

	function onBuscarCidadesFinalizado(cidades) {
		console.log('cidades.........', cidades)
		var options = [];
		cidades.forEach(function(cidade) {
			options.push('<option value"' + cidade.id + '">' + cidade.nome + '</option>');
		});
		
		this.combo.html(options.join(''));
		this.combo.removeAttr('disabled');
	}
	
	function reset() {
		this.combo.html('<option value="">Selecione</option>');
		this.combo.val('');
		this.combo.attr('disabled', 'disabled');
	}
	
	function iniciarRequisicao() {
		reset.call(this);
		this.imgLoading.show();
	}

	function finalizarRequisicao() {
		this.imgLoading.hide();
	}

	return ComboCidade;
}());

$(function() {
	var comboEstado = new Brewer.ComboEstado();
	comboEstado.iniciar();

	var comboCidade = new Brewer.ComboCidade(comboEstado);
	comboCidade.iniciar();

});