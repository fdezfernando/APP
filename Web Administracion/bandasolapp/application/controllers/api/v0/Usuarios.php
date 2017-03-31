<?php

// Clase usuarios de la API

defined('BASEPATH') OR exit('No direct script access allowed');

// This can be removed if you use __autoload() in config.php OR use Modular Extensions
/** @noinspection PhpIncludeInspection */
require APPPATH . '/libraries/REST_Controller.php';

// use namespace
use Restserver\Libraries\REST_Controller;

/**
* This is an example of a few basic user interaction methods you could use
* all done with a hardcoded array
*
* @package         CodeIgniter
* @subpackage      Rest Server
* @category        Controller
* @author          Phil Sturgeon, Chris Kacerguis
* @license         MIT
* @link            https://github.com/chriskacerguis/codeigniter-restserver
*/
class Usuarios extends REST_Controller {


  // Método que devuelve una lista de usuarios
  public function login_post()
  {
    //Cargamos el modelo de la librería ion_auth
    $this->load->model('ion_auth_model');
    // Cargamos nuestro model usuarios
    $this->load->model('usuarios_model');
    //Me guardo en dos variables los dos datos que
    // le paso como son usuario y contraseña
    $email = $this->input->post("e");
    $pass = $this->input->post("p");
    // Guardamos en una variable el email del usuario
    $usuario = $this->usuarios_model->get_user_by_email($email);
    // Guardamos en una variable el usuario y
    //la contraseña para que la compare
    $login = $this->ion_auth_model->hash_password_db($usuario->id, $pass);
    // Si el login es correcto devolvemos el mensaje "Login Correcto"
    // si no devolvemos "Login incorrecto"
    if($login == TRUE) {
      $this->set_response(array(
        'status' => "success",
        'data' => $usuario,
        'mensaje'=>"Login correcto"
      ), REST_Controller::HTTP_OK);
    } else {
      $this->set_response(
        array(
          'status' => "error",
          'data' => null,
          'mensaje'=>"Login incorrecto"
        ), REST_Controller::HTTP_NOT_FOUND);
      }
    }
  }
