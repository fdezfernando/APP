$( document ).ready(function(){

  // Ajax con el que agregamos una noticia
  $(document).on("click", "#send", function(){
    $.ajax({
      method: "POST",
      url: "http://localhost/bandasolapp/noticias/insert",
      data: {tituloAjax: $("#inputTitulo").val(),cuerpoAjax:$("#inputCuerpo").val()}
    })
    .done(function(respuesta){
      //alert('OK');
      $('#myModal').modal('toggle');
      window.location.href = "http://localhost/bandasolapp/noticias"; //Es necesario para que recargue Firfox
      console.log(respuesta);
    })
    .fail(function(respuesta) {
      //alert( "Error: " + respuesta );
      console.log(respuesta);
    });
  });

  // Función Ajax para editar la noticia
  $(document).on("click", ".btn-edit-noticia", function(){
    $.ajax({
      method: "GET",
      url: "http://localhost/bandasolapp/noticias/editajax",
      data: {idNoticiaAjax: $(this).attr("idNoticia")}
    })
    .done(function(respuesta){
      //alert('OK');
      $('#myModaledit').modal('toggle');
      var obj = jQuery.parseJSON( respuesta );
      $("#idEdicion").val(obj.idNoticia);
      $("#inputTituloEdit").val(obj.titulo);
      $("#inputCuerpoEdit").val(obj.cuerpo);

      console.log(respuesta);
    })
    .fail(function(respuesta) {
      alert( "Error: " + respuesta );
      //console.log(respuesta);
    });
  });

  // Ajax con el que editamos una noticia
  $(document).on("click", "#sendEdit", function(){
    $.ajax({
      method: "POST",
      url: "http://localhost/bandasolapp/noticias/edit",
      data: {idNoticiaAjax: $("#idEdicion").val(),
      tituloAjaxEdit: $("#inputTituloEdit").val(),
      cuerpoAjaxEdit:$("#inputCuerpoEdit").val()}
    })
    .done(function(respuesta){
      //alert('OK');
      $('#myModal').modal('toggle');
      window.location.href = "http://localhost/bandasolapp/noticias";
      console.log(respuesta);
    })
    .fail(function(respuesta) {
      //alert( "Error: " + respuesta );
      console.log(respuesta);
    });
  });


});

// Script para preguntar al usuario si quiere borrar la noticia
$(".delete").click(function(e){
  if(!confirm('¿Seguro que quieres eliminar la noticia?')){
    e.preventDefault();
    return false;
  }
  return true;
});
