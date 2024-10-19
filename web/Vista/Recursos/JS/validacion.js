/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
function revisar_checks(form, seleccionadosGrid){
    validacion=document.getElementById(form + ':validacion');
    validacion.value="OK";
    var seleccionados = document.getElementById(form + ':' + seleccionadosGrid);
    var cuantos = 0;
    seleccionados.value = "";
    var stocks = document.getElementById(form);
    for (i=0; i < stocks.elements.length; i++){
        if(stocks.elements[i].type == "checkbox"){
            if (stocks.elements[i].checked == 1){
                seleccionados.value = seleccionados.value + stocks.elements[i].value + ",";
                cuantos++;
            }
        }
    }
    if (cuantos > 0){
        if(cuantos == 1){
            return true;
        }
        validacion.value="ERROR";
        alert("Debe seleccionar solo un Registro de la Lista");
        return false; //Hay mas de un Checks Seleccionado
    }else{
        //No Hay Checks Seleccionados
        validacion.value="ERROR";
        alert("Debe seleccionar un Registro de la Lista");
        return false;
    }
}

function checks_seleccionados(form, seleccionadosGrid){
    //alert(document.getElementsByTagName('FORM')[0].id);
    var seleccionados = document.getElementById(form + ':' + seleccionadosGrid);
    seleccionados.value="";
    var cuantos = 0;
    var stocks = document.getElementById('vista:claves:stock');
    for (i=0; i < stocks.elements.length; i++){
        if(stocks.elements[i].type == "checkbox"){
            if (stocks.elements[i].checked == 1){
                seleccionados.value = seleccionados.value + stocks.elements[i].value + ",";
                cuantos++;
            }
        }
    }
    return true;
}

