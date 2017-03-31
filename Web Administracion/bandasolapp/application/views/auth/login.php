<!DOCTYPE html>
<html lang="es">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Banda SoL</title>


  <!-- CSS -->
  <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
  <link rel="stylesheet" href="<?=site_url('assets/login/bootstrap/css/bootstrap.min.css');?>">
  <link rel="stylesheet" href="<?=site_url('assets/login/font-awesome/css/font-awesome.min.css');?>">
  <link rel="stylesheet" href="<?=site_url('assets/login/css/form-elements.css');?>">
  <link rel="stylesheet" href="<?=site_url('assets/login/css/style.css');?>">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
  <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->

  <!-- Favicon and touch icons -->
  <link rel="shortcut icon" href="<?=site_url('assets/login/ico/favicon.png');?>">
  <link rel="apple-touch-icon-precomposed" sizes="144x144" href="<?=site_url('assets/login/ico/apple-touch-icon-144-precomposed.png');?>">
  <link rel="apple-touch-icon-precomposed" sizes="114x114" href="<?=site_url('assets/login/ico/apple-touch-icon-114-precomposed.png');?>">
  <link rel="apple-touch-icon-precomposed" sizes="72x72" href="<?=site_url('assets/login/ico/apple-touch-icon-72-precomposed.png');?>">
  <link rel="apple-touch-icon-precomposed" href="<?=site_url('assets/login/ico/apple-touch-icon-57-precomposed.png');?>">

</head>


<body>

  <!-- Top content -->
  <div class="top-content">

    <div class="inner-bg">
      <div class="container">

        <div class="row">
          <div class="col-sm-6 col-sm-offset-3 form-box">
            <div class="form-top">
              <div class="form-top-left">
                <h3>Bienvenido</h3>
                <p>Logueate: </p>
              </div>
              <div class="form-top-right">
                <i class="fa fa-lock"></i>
              </div>
            </div>
            <div class="form-bottom">
              <?php echo form_open("auth/login");?>
              <form role="form"  method="post" class="login-form">
                <div class="form-group">
                  <label class="sr-only" for="form-username">Username</label>
                  <?php echo form_input($identity);?>
                </div>

                <div class="form-group">
                  <label class="sr-only" for="form-password">Password</label>
                  <?php echo form_input($password);?>
                </div>
                <?php echo lang('login_remember_label', 'remember');?>
                <?php echo form_checkbox('remember', '1', FALSE, 'id="remember"');?>
                <?php echo form_submit('submit', lang('login_submit_btn'));?>
                <?php echo form_close();?>
                <!--<button type="submit" class="btn" value>ENTRAR</button>-->
              </form>
            
            </div>
          </div>
        </div>

      </div>
    </div>

  </div>

  <!-- Javascript -->
  <script src="<?=site_url('assets/login/js/jquery-1.11.1.min.js');?>"></script>
  <script src="<?=site_url('assets/login/bootstrap/js/bootstrap.min.js');?>"></script>
  <script src="<?=site_url('assets/login/js/jquery.backstretch.min.js');?>"></script>
  <script src="<?=site_url('assets/login/js/scripts.js');?>"></script>

  <!--[if lt IE 10]>
  <script src="assets/js/placeholder.js"></script>
  <![endif]-->

</body>

</html>
