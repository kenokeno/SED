// JavaScript Document
var XMLHttpRequestObject = false; 
try{
    XMLHttpRequestObject= new ActiveXObject("MSXML2.XMLHTTP.5.0");
}catch(exception1){
    try{
        XMLHttpRequestObject= new ActiveXObject("Microsoft.XMLHTTP");
    }catch(exception2){
        XMLHttpRequestObject = false;
    }
}
if(!XMLHttpRequestObject && window.XMLHttpRequest){
    XMLHttpRequestObject = new XMLHttpRequest();
}
function pedirDatos(fuenteDatos, divID){ 
    if(XMLHttpRequestObject) {      
        var obj = document.getElementById(divID); 
        XMLHttpRequestObject.open("GET", fuenteDatos, true); 
        XMLHttpRequestObject.onreadystatechange = function(){ 
            if (XMLHttpRequestObject.readyState == 4) {
                obj.innerHTML = XMLHttpRequestObject.responseText;
            }
        }  
        XMLHttpRequestObject.send(null); 
        $("#displayTagDiv").displayTagAjax();
    }   
}