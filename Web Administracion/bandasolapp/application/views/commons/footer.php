<!-- CONTENT-WRAPPER SECTION END-->
<footer>
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        &copy; 2017 CCyTT Nuestra Señora del Sol | <a href="http://www.designbootstrap.com/" target="_blank">Todos los derechos reservados.</a>
      </div>

    </div>
  </div>
</footer>

<!-- FOOTER SECTION END-->
<!-- JAVASCRIPT AT THE BOTTOM TO REDUCE THE LOADING TIME  -->
<!-- CORE JQUERY SCRIPTS -->
<script src="<?=site_url('assets/js/jquery-1.11.1.js'); ?>"></script>
<!-- BOOTSTRAP SCRIPTS  -->
<script src="<?=site_url('assets/js/bootstrap.js'); ?>"></script>
<script src="<?=site_url('assets/js/sweetalert2.js'); ?>"></script>
<!-- Carga dinámica del contenido de bootstrap de grocery-->
<?php if(isset($css_files)) {
  foreach($js_files as $file): ?>
  <script src="<?php echo $file; ?>"></script>
<?php endforeach;
}?>
<!--SCRIPTS PERSONALIZADOS-->
<script src="<?=site_url('assets/js/script.js');?>"></script>

</body>
</html>
