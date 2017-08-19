$( document ).ready(function() {
	carregarPaginador();
	carregarMascaras();
});


$(document).on("pfAjaxComplete", function(event, xhr, options) {
	var $source = $("[id='" + options.source + "']");
    if ($source.hasClass("ui-button") || $source.hasClass("ui-commandlink")) {   
    	carregarMascaras();
    	Materialize.updateTextFields();
    	$('select').material_select();
    	$('ul.tabs').tabs();
    	carregarPaginador();
    }
});



/**
 * Axxiom Soluções Tecnológicas
 * 
 * @author ajsantos
 * @date 27 de mar de 2017
 * @descriptions Todo submit que for efetuado nas telas, essa função será
 *               chamada para que o 'Loading' possa aparecer.
 */
$("[type=submit]").click(function() {
	$("#aguarde").css({
		'position' : 'absolute',
		'top' : '0',
		'left' : '0',
		'width' : '100%',
		'height' : '100%',
		'z-index' : '100000',
		'background-color' : 'rgba(0,0,0,0.5)'
	});

	$("#imagemGif").css({
		'position' : 'absolute',
		'left' : '45%',
		'top' : '50%',
		'width' : '140px',
		'height' : '80px'
	});

	$("#textLoading").css({
		'position' : 'absolute',
		'left' : '46%',
		'top' : '60%',
		'font-size' : '18px'
	});

	$("#aguarde").show();

})

function abrirModal(idModal) {
	Materialize.updateTextFields();
	$('select').material_select();
	$('ul.tabs').tabs();
	$(idModal).modal('open');
}

function carregarMascaras(){
    //Mascara de CNPJ verificando a Class do componente
    $('.maskCNPJ').focusout(function(event) {
    	if ($(this).val().length != 18){//considerando a quantidade com ponto e traço
    		$(this).val('');
    	}
    });
    $('.maskCNPJ').mask('00.000.000/0000-00',{reverse: true});

    //Mascara de CPF verificando a Class do componente
    $('.maskCPF').focusout(function(event) {
        if ($(this).val().length != 14){//considerando a quantidade com ponto e traço
        	$(this).val('');
        }
    });
    $('.maskCPF').mask('000.000.000-00',{reverse: true});
}

function carregarPaginador() {
	$('.ui-icon-seek-prev').addClass('material-icons');
	$('.ui-icon-seek-next').addClass('material-icons');
	
	$('.ui-icon-seek-first').addClass('material-icons');
	$('.ui-icon-seek-end').addClass('material-icons');
}
