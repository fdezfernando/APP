<!-- Page Content -->
<div class="text-center alert alert-warning">
  <a  class="btn btn-social btn btn-primary" data-toggle="modal" data-target="#myModal">
    <i class="fa fa-newspaper-o"></i>&nbsp; Crear nueva noticia</a>
  </div>
  <hr>
  <div class="row">

    <?php foreach($noticias as $not) { ?>
      <div class="col-md-4 col-sm-4">
        <div class="panel panel-primary">
          <div class="panel-heading">
            <h4 class="texto"><?=$not->titulo?></h4>
          </div>
          <div class="panel-body">
            <p class="texto"><?=$not->cuerpo?></p>
            <span class="fecha"><?=date("d/m/Y", strtotime($not->fecha));?></span>
          </div>
          <div class="panel-footer" align="center">
            <button idNoticia="<?=$not->idNoticia?>" class="btn btn-primary btn-edit-noticia"><i class="fa fa-edit "></i></button>
            <button class="btn btn-danger"><a class="delete" href="<?php echo site_url('noticias/delete/'.$not->idNoticia); ?>" ><i class="fa fa-trash-o"></i></a></button>
          </div>
        </div>
      </div>
      <?php } ?>

    </div>


    <!-- Modal agregar -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title" id="myModalLabel">Nueva noticia</h4>
          </div>
          <div class="modal-body">
            <input type="text" class="form-control" id="inputTitulo" name="titulo" placeholder="Título..."><br>
            <textarea class="form-control" id="inputCuerpo" name="cuerpo"  placeholder="Cuerpo..." rows="18"></textarea>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
            <button id="send" type="button" class="btn btn-primary">Guardar</button>
          </div>
        </div>
      </div>
    </div>

    <!-- Modal editar -->
    <div class="modal fade" id="myModaledit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
      <input type="hidden" id="idEdicion" value="" />
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title" id="myModalLabel">Editar noticia</h4>
          </div>
          <div class="modal-body">
            <input type="text" class="form-control" id="inputTituloEdit" name="titulo" placeholder="Título..."><br>
            <textarea class="form-control" id="inputCuerpoEdit" name="cuerpo"  placeholder="Cuerpo..." rows="18"></textarea>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
            <button id="sendEdit" type="button" class="btn btn-primary">Guardar</button>
          </div>
        </div>
      </div>
    </div>
