var Brewer = Brewer || {};

Brewer.MaskMoney = (function() {
	
	function MaskMoney() {
		this.decimal = $('.js-decimal');
		this.inteiro = $('.js-inteiro');
	}
	
	MaskMoney.prototype.enable = function() {
		this.decimal.maskMoney({ decimal: ',', thousands: '.' });
		this.inteiro.maskMoney({ precision: 0, thousands: '.' });
	}
	
	return MaskMoney;
}());

Brewer.MaskCep = (function() {
	function MaskCep() {
		this.inputCep = $('.js-cep');
	}
	
	MaskCep.prototype.enable = function() {
		var maskBehavior = function (val) {
		  return '00000-000';
		};
		
		var options = {
		  onKeyPress: function(val, e, field, options) {
		      field.mask(maskBehavior.apply({}, arguments), options);
		    }
		};
		
		this.inputCep.mask(maskBehavior, options);
	}
	
	return MaskCep;
	
}());

Brewer.MaskTelefone = (function() {
	function MaskTelefone() {
		this.inputTelefone = $('.js-telefone');
	}
	
	MaskTelefone.prototype.enable = function() {
		var maskBehavior = function (val) {
		  return val.replace(/\D/g, '').length === 11 ? '(00) 00000-0000' : '(00) 0000-00009';
		};
		
		var options = {
		  onKeyPress: function(val, e, field, options) {
		      field.mask(maskBehavior.apply({}, arguments), options);
		    }
		};
		
		this.inputTelefone.mask(maskBehavior, options);
	}
	
	return MaskTelefone;
	
}());


$(function() {
		var maskMoney = new Brewer.MaskMoney();
		maskMoney.enable();
		
		var maskCep = new Brewer.MaskCep();
		maskCep.enable();
	  
		var maskTelefone = new Brewer.MaskTelefone();
		maskTelefone.enable();
	  
});

