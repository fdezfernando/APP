<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
  <meta name="description" content="" />
  <meta name="author" content="" />
  <!--[if IE]>
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <![endif]-->
  <!-- Cambia el title dinámicamente-->
  <title>BandaSoLApp - <?php echo $title; ?></title>
  <!-- Carga dinámica del contenido de bootstrap de grocery-->
  <?php
  if(isset($css_files)) {
    foreach($css_files as $file): ?>
    <link type="text/css" rel="stylesheet" href="<?php echo $file; ?>" />
  <?php endforeach;
} ?>
<!-- BOOTSTRAP CORE STYLE  -->
<link href="<?=site_url('assets/css/bootstrap.css'); ?>" rel="stylesheet" />
<!-- FONT AWESOME ICONS  -->
<link href="<?=site_url('assets/css/font-awesome.css'); ?>" rel="stylesheet" />
<!-- CUSTOM STYLE  -->
<link href="<?=site_url('assets/css/style.css'); ?>" rel="stylesheet" />
<link href="<?=site_url('assets/css/sweetalert2.css'); ?>" rel="stylesheet" />
<!-- HTML5 Shiv and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
</head>
<body>
  <header>
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <a href="auth/login">Salir</a><strong></strong>

        </div>
      </div>
    </div>
  </header>
  <!-- HEADER END-->
  <div class="navbar navbar-inverse set-radius-zero">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="<?=site_url('inicio');?>">
          <img src="<?=site_url('assets/img/logo.jpg');?>" style="width:200px; heigth:60px;"/>
        </a>

      </div>

      <div class="left-div">
        <div class="user-settings-wrapper">
          <ul class="nav">

            <li class="dropdown">
              <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                <!--<span class="glyphicon glyphicon-user" style="font-size: 25px;"></span>-->
              </a>
              <!--  <div class="dropdown-menu dropdown-settings">
              <div class="media">
              <a class="media-left" href="#">
              <img src="assets/img/64-64.jpg" alt="" class="img-rounded" />
            </a>
            <div class="media-body">
            <h4 class="media-heading">Jhon Deo Alex </h4>
            <h5>Developer & Designer</h5>

          </div>
        </div>
        <hr />
        <h5><strong>Personal Bio : </strong></h5>
        Anim pariatur cliche reprehen derit.
        <hr />
        <a href="#" class="btn btn-info btn-sm">Full Profile</a>&nbsp; <a href="login.html" class="btn btn-danger btn-sm">Logout</a>

      </div>-->
    </li>


  </ul>
</div>
</div>
</div>
</div>
<!-- LOGO HEADER END-->
<section class="menu-section">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <div class="navbar-collapse collapse ">
          <ul id="menu-top" class="nav navbar-nav navbar-right">
            <li><a class="<?php if($this->uri->segment(1)=="inicio"){echo "menu-top-active";}?>" href="<?=site_url('inicio');?>">Inicio</a></li>
            <li><a class="<?php if($this->uri->segment(1)=="noticias"){echo "menu-top-active";}?>" href="<?=site_url('noticias');?>">Noticias</a></li>
            <li><a class="<?php if($this->uri->segment(1)=="componentes"){echo "menu-top-active";}?>" href="<?=site_url('componentes');?>">Componentes</a></li>
            <li><a class="<?php if($this->uri->segment(1)=="eventos"){echo "menu-top-active";}?>" href="<?=site_url('eventos');?>">Eventos</a></li>
            <li><a class="<?php if($this->uri->segment(1)=="instrumentos"){echo "menu-top-active";}?>" href="<?=site_url('instrumentos');?>">Instrumentos</a></li>
            <li><a class="<?php if($this->uri->segment(1)=="marchas"){echo "menu-top-active";}?>" href="<?=site_url('marchas');?>">Marchas</a></li>
          </ul>
        </div>
      </div>

    </div>
  </div>
</section>
<!-- MENU SECTION END-->
<div class="content-wrapper">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <h4 class="page-head-line"><?php echo $title; ?></h4>

      </div>

    </div>
