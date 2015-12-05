/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
function loadingStyle(){
    return '<div class="row"><div class="col-2"><i class="fa fa-spinner fa-spin fa-5x"></i></div><div class="col-3"><h2> Please Wait....</h2></div></div>';
}
function failResult(){
    return '<h2>Fail..!!</h2>';
}
function ajaxView(method, uri, variable, resulte){
    $.ajax({
        type: method,
        url: uri,
        dataType: 'text',
        data: variable,
        beforeSend:function(){
            $(resulte).html(loadingStyle());
        },
        success: function(data) {
            $(resulte).html(data);
        },
        error: function() {
            $(resulte).html(failResult());
        }
    });
               
}
function modalLoad(idName, idModalName, modalTitle, modalContent){
    $(idName).click(function(){
        $(idModalName).modal('show');
        $('.modal-title').text(modalTitle);
        $('.modal-body').html(modalContent);
    });
}

function modalOpener(idModalName, modalTitle, modalContent){
    $(idModalName).modal('show');
    $('.modal-title').text(modalTitle);
    $('.modal-body').html(modalContent);
}

function maskDate(a){
    var checkout = $(a).datepicker({
        format: 'dd-mm-yyyy'
    }).on('changeDate', function() {
        checkout.hide();
    }).data('datepicker');
}

